#include "Interpretador.h"
#include <iostream>
#include <stdexcept>
#include <set>

class RetornoException : public std::exception {
public:
    std::shared_ptr<Valor> valor;
    explicit RetornoException(std::shared_ptr<Valor> v) : valor(v) {}
};

Interpretador::Interpretador() {
    global = std::make_shared<Ambiente>();
    ambiente = global;
    funcaoAtual = nullptr;
    setupFuncoesNativas();
}

void Interpretador::interpretar(PortugolPPParser::ProgramaContext* tree) {
    try {
        processarDeclaracoesDoArquivo(tree);
        visitFuncaoMain();
    } catch (const std::exception& e) {
        std::cerr << "Erro durante a interpretação: " << e.what() << std::endl;
    }
}

std::any Interpretador::visitPrograma(PortugolPPParser::ProgramaContext *ctx) {
    for (auto declaracao : ctx->declaracao()) {
        visit(declaracao);
    }
    return VALOR_NULO;
}

std::any Interpretador::visitExpressao(PortugolPPParser::ExpressaoContext *ctx) {
    auto resultado = visit(ctx->atribuicao());
    return resultado;
}

std::any Interpretador::visitPrimario(PortugolPPParser::PrimarioContext *ctx) {
    
    if (ctx->NUMERO()) {
        std::string numStr = ctx->NUMERO()->getText();
        if (numStr.find('.') != std::string::npos) {
            auto valor = std::make_shared<ValorReal>(std::stod(numStr));
            return std::static_pointer_cast<Valor>(valor);
        } else {
            auto valor = std::make_shared<ValorInteiro>(std::stoi(numStr));
            return std::static_pointer_cast<Valor>(valor);
        }
    }
    
    if (ctx->TEXTO_LITERAL()) {
        std::string texto = ctx->TEXTO_LITERAL()->getText();
        // Remove quotes
        texto = texto.substr(1, texto.length() - 2);
        auto valor = std::make_shared<ValorTexto>(texto);
        return std::static_pointer_cast<Valor>(valor);
    }
    
    if (ctx->getText() == "verdadeiro") {
        auto valor = std::make_shared<ValorLogico>(true);
        return std::static_pointer_cast<Valor>(valor);
    }
    
    if (ctx->getText() == "falso") {
        auto valor = std::make_shared<ValorLogico>(false);
        return std::static_pointer_cast<Valor>(valor);
    }
    
    if (ctx->ID()) {
        std::string nome = ctx->ID()->getText();
        
        // Check if it's a function call
        if (ctx->argumentos()) {
            std::vector<std::shared_ptr<Valor>> argumentos;
            if (ctx->argumentos()) {
                for (auto expr : ctx->argumentos()->expressao()) {
                    auto valor = std::any_cast<std::shared_ptr<Valor>>(visit(expr));
                    argumentos.push_back(valor);
                }
            }
            return chamadaFuncao(nome, argumentos);
        } else {
            // Variable access
            return ambiente->obter(nome);
        }
    }
    
    if (ctx->expressao()) {
        return visit(ctx->expressao());
    }
    
    return std::static_pointer_cast<Valor>(VALOR_NULO);
}

std::any Interpretador::visitAtribuicao(PortugolPPParser::AtribuicaoContext *ctx) {
    
    if (ctx->logicaOu()) {
        return visit(ctx->logicaOu());
    }
    
    if (ctx->ID()) {
        std::string nome = ctx->ID()->getText();
        auto valor = std::any_cast<std::shared_ptr<Valor>>(visit(ctx->expressao()));
        ambiente->atualizarOuDefinir(nome, valor);
        return valor;
    }
    
    return std::static_pointer_cast<Valor>(VALOR_NULO);
}

std::any Interpretador::visitDeclaracaoVar(PortugolPPParser::DeclaracaoVarContext *ctx) {
    std::string nome = ctx->ID()->getText();
    std::shared_ptr<Valor> valor = VALOR_NULO;
    
    if (ctx->expressao()) {
        valor = std::any_cast<std::shared_ptr<Valor>>(visit(ctx->expressao()));
    }
    
    ambiente->definir(nome, valor);
    return VALOR_NULO;
}

std::any Interpretador::visitDeclaracaoFuncao(PortugolPPParser::DeclaracaoFuncaoContext *ctx) {
    std::string nome = ctx->ID()->getText();
    auto funcao = std::make_shared<ValorFuncao>(nome, ctx);
    global->definir(nome, funcao);
    return VALOR_NULO;
}

std::any Interpretador::visitDeclaracao(PortugolPPParser::DeclaracaoContext *ctx) {
    if (ctx->declaracaoVar()) {
        return visit(ctx->declaracaoVar());
    }
    if (ctx->declaracaoFuncao()) {
        return visit(ctx->declaracaoFuncao());
    }
    if (ctx->chamadaFuncao()) {
        return visit(ctx->chamadaFuncao());
    }
    if (ctx->expressao()) {
        return visit(ctx->expressao());
    }
    if (ctx->bloco()) {
        return visit(ctx->bloco());
    }
    if (ctx->declaracaoClasse()) {
        return visit(ctx->declaracaoClasse());
    }
    if (ctx->declaracaoInterface()) {
        return visit(ctx->declaracaoInterface());
    }
    if (ctx->declaracaoSe()) {
        return visit(ctx->declaracaoSe());
    }
    if (ctx->declaracaoEnquanto()) {
        return visit(ctx->declaracaoEnquanto());
    }
    if (ctx->declaracaoPara()) {
        return visit(ctx->declaracaoPara());
    }
    if (ctx->declaracaoReturn()) {
        return visit(ctx->declaracaoReturn());
    }
    
    return VALOR_NULO;
}

std::any Interpretador::visitBloco(PortugolPPParser::BlocoContext *ctx) {
    for (auto declaracao : ctx->declaracao()) {
        visit(declaracao);
    }
    return VALOR_NULO;
}

std::any Interpretador::visitAdicao(PortugolPPParser::AdicaoContext *ctx) {
    if (ctx->multiplicacao().size() == 1) {
        return visit(ctx->multiplicacao(0));
    }
    
    auto esquerda = std::any_cast<std::shared_ptr<Valor>>(visit(ctx->multiplicacao(0)));
    
    for (size_t i = 1; i < ctx->multiplicacao().size(); i++) {
        auto direita = std::any_cast<std::shared_ptr<Valor>>(visit(ctx->multiplicacao(i)));
        std::string operador = ctx->getToken(PortugolPPParser::T__26 + i - 1, 0)->getText(); // '+' or '-'
        
        if (operador == "+") {
            // Handle addition
            if (esquerda->getType() == Valor::Type::INTEIRO && direita->getType() == Valor::Type::INTEIRO) {
                auto left = asInteiro(esquerda);
                auto right = asInteiro(direita);
                esquerda = std::make_shared<ValorInteiro>(left->getValue() + right->getValue());
            } else if (esquerda->getType() == Valor::Type::REAL || direita->getType() == Valor::Type::REAL) {
                double leftVal = (esquerda->getType() == Valor::Type::REAL) ? asReal(esquerda)->getValue() : asInteiro(esquerda)->getValue();
                double rightVal = (direita->getType() == Valor::Type::REAL) ? asReal(direita)->getValue() : asInteiro(direita)->getValue();
                esquerda = std::make_shared<ValorReal>(leftVal + rightVal);
            } else if (esquerda->getType() == Valor::Type::TEXTO || direita->getType() == Valor::Type::TEXTO) {
                esquerda = std::make_shared<ValorTexto>(esquerda->toString() + direita->toString());
            }
        } else if (operador == "-") {
            // Handle subtraction
            if (esquerda->getType() == Valor::Type::INTEIRO && direita->getType() == Valor::Type::INTEIRO) {
                auto left = asInteiro(esquerda);
                auto right = asInteiro(direita);
                esquerda = std::make_shared<ValorInteiro>(left->getValue() - right->getValue());
            } else {
                double leftVal = (esquerda->getType() == Valor::Type::REAL) ? asReal(esquerda)->getValue() : asInteiro(esquerda)->getValue();
                double rightVal = (direita->getType() == Valor::Type::REAL) ? asReal(direita)->getValue() : asInteiro(direita)->getValue();
                esquerda = std::make_shared<ValorReal>(leftVal - rightVal);
            }
        }
    }
    
    return esquerda;
}

std::any Interpretador::visitMultiplicacao(PortugolPPParser::MultiplicacaoContext *ctx) {
    if (ctx->unario().size() == 1) {
        return visit(ctx->unario(0));
    }
    
    auto esquerda = std::any_cast<std::shared_ptr<Valor>>(visit(ctx->unario(0)));
    
    for (size_t i = 1; i < ctx->unario().size(); i++) {
        auto direita = std::any_cast<std::shared_ptr<Valor>>(visit(ctx->unario(i)));
        // This is simplified - would need proper token handling
        std::string operador = "*"; // Assume multiplication for now
        
        if (esquerda->getType() == Valor::Type::INTEIRO && direita->getType() == Valor::Type::INTEIRO) {
            auto left = asInteiro(esquerda);
            auto right = asInteiro(direita);
            esquerda = std::make_shared<ValorInteiro>(left->getValue() * right->getValue());
        } else {
            double leftVal = (esquerda->getType() == Valor::Type::REAL) ? asReal(esquerda)->getValue() : asInteiro(esquerda)->getValue();
            double rightVal = (direita->getType() == Valor::Type::REAL) ? asReal(direita)->getValue() : asInteiro(direita)->getValue();
            esquerda = std::make_shared<ValorReal>(leftVal * rightVal);
        }
    }
    
    return esquerda;
}

std::any Interpretador::visitUnario(PortugolPPParser::UnarioContext *ctx) {
    if (ctx->unario()) {
        // This is a unary operation like -x or !x
        auto operando = std::any_cast<std::shared_ptr<Valor>>(visit(ctx->unario()));
        std::string operador = ctx->children[0]->getText();
        
        if (operador == "-") {
            if (operando->getType() == Valor::Type::INTEIRO) {
                auto num = asInteiro(operando);
                return std::make_shared<ValorInteiro>(-num->getValue());
            } else if (operando->getType() == Valor::Type::REAL) {
                auto num = asReal(operando);
                return std::make_shared<ValorReal>(-num->getValue());
            }
        } else if (operador == "!") {
            if (operando->getType() == Valor::Type::LOGICO) {
                auto logico = asLogico(operando);
                return std::make_shared<ValorLogico>(!logico->getValue());
            }
        }
        return operando;
    } else {
        return visit(ctx->chamada());
    }
}

std::any Interpretador::visitChamada(PortugolPPParser::ChamadaContext *ctx) {
    return visit(ctx->primario());
}

std::shared_ptr<Valor> Interpretador::chamadaFuncao(const std::string& nome, const std::vector<std::shared_ptr<Valor>>& argumentos) {
    auto valor = ambiente->obter(nome);
    auto funcao = asFuncao(valor);
    
    if (!funcao) {
        throw std::runtime_error("Função não encontrada: " + nome);
    }
    
    if (funcao->getMetodoCallback()) {
        return funcao->getMetodoCallback()(argumentos);
    }
    
    // For user-defined functions
    if (funcao->getDeclaracao()) {
        auto ctx = static_cast<PortugolPPParser::DeclaracaoFuncaoContext*>(funcao->getDeclaracao());
        
        // Create new environment for function scope
        auto funcaoAmbiente = std::make_shared<Ambiente>(global);
        
        // Set function parameters
        if (ctx->listaParams()) {
            auto params = ctx->listaParams()->param();
            for (size_t i = 0; i < params.size() && i < argumentos.size(); i++) {
                std::string paramNome = params[i]->ID()->getText();
                funcaoAmbiente->definir(paramNome, argumentos[i]);
            }
        }
        
        // Save current environment and switch to function environment
        auto oldAmbiente = ambiente;
        ambiente = funcaoAmbiente;
        
        try {
            visit(ctx->bloco());
            ambiente = oldAmbiente;
            return VALOR_NULO;
        } catch (const RetornoException& retorno) {
            ambiente = oldAmbiente;
            return retorno.valor;
        } catch (...) {
            ambiente = oldAmbiente;
            throw;
        }
    }
    
    return VALOR_NULO;
}

void Interpretador::setupFuncoesNativas() {
    // Add native print function
    auto escrever = std::make_shared<ValorFuncao>("escrever", nullptr, "", nullptr,
        [](const std::vector<std::shared_ptr<Valor>>& args) -> std::shared_ptr<Valor> {
            for (const auto& arg : args) {
                std::cout << arg->toString() << " ";
            }
            return VALOR_NULO;
        });
    global->definir("escrever", escrever);
    
    auto imprimir = std::make_shared<ValorFuncao>("imprimir", nullptr, "", nullptr,
        [](const std::vector<std::shared_ptr<Valor>>& args) -> std::shared_ptr<Valor> {
            for (const auto& arg : args) {
                std::cout << arg->toString() << " ";
            }
            return VALOR_NULO;
        });
    global->definir("imprimir", imprimir);
}

void Interpretador::processarDeclaracoesDoArquivo(PortugolPPParser::ProgramaContext* tree) {
    // Process interfaces first
    for (auto declaracao : tree->declaracao()) {
        if (declaracao->declaracaoInterface()) {
            visit(declaracao->declaracaoInterface());
        }
    }
    
    // Then classes
    for (auto declaracao : tree->declaracao()) {
        if (declaracao->declaracaoClasse()) {
            visit(declaracao->declaracaoClasse());
        }
    }
    
    // Then functions
    for (auto declaracao : tree->declaracao()) {
        if (declaracao->declaracaoFuncao()) {
            visit(declaracao->declaracaoFuncao());
        }
    }
}

void Interpretador::visitFuncaoMain() {
    try {
        auto main = global->obter("main");
        auto funcaoMain = asFuncao(main);
        if (funcaoMain) {
            chamadaFuncao("main", {});
        }
    } catch (const std::exception& e) {
        throw std::runtime_error("Falha durante a execução da função main: " + std::string(e.what()));
    }
}

// Stub implementations for other methods
std::any Interpretador::visitChamadaFuncao(PortugolPPParser::ChamadaFuncaoContext *ctx) { 
    try {
        std::string nome = ctx->ID()->getText();
        std::vector<std::shared_ptr<Valor>> argumentos;
        
        if (ctx->argumentos()) {
            for (auto expr : ctx->argumentos()->expressao()) {
                auto valor = std::any_cast<std::shared_ptr<Valor>>(visit(expr));
                argumentos.push_back(valor);
            }
        }
        
        auto resultado = chamadaFuncao(nome, argumentos);
        return resultado;
    } catch (const std::bad_any_cast& e) {
        return VALOR_NULO;
    } catch (const std::exception& e) {
        return VALOR_NULO;
    }
}
std::any Interpretador::visitDeclaracaoClasse(PortugolPPParser::DeclaracaoClasseContext *ctx) { return VALOR_NULO; }
std::any Interpretador::visitDeclaracaoInterface(PortugolPPParser::DeclaracaoInterfaceContext *ctx) { return VALOR_NULO; }
std::any Interpretador::visitLogicaOu(PortugolPPParser::LogicaOuContext *ctx) { 
    // For now, just visit the first logicaE
    return visit(ctx->logicaE(0));
}

std::any Interpretador::visitLogicaE(PortugolPPParser::LogicaEContext *ctx) { 
    // For now, just visit the first igualdade
    return visit(ctx->igualdade(0));
}

std::any Interpretador::visitIgualdade(PortugolPPParser::IgualdadeContext *ctx) { 
    // For now, just visit the first comparacao
    return visit(ctx->comparacao(0));
}

std::any Interpretador::visitComparacao(PortugolPPParser::ComparacaoContext *ctx) { 
    // For now, just visit the first adicao
    return visit(ctx->adicao(0));
}
std::any Interpretador::visitDeclaracaoSe(PortugolPPParser::DeclaracaoSeContext *ctx) { return VALOR_NULO; }
std::any Interpretador::visitDeclaracaoEnquanto(PortugolPPParser::DeclaracaoEnquantoContext *ctx) { return VALOR_NULO; }
std::any Interpretador::visitDeclaracaoPara(PortugolPPParser::DeclaracaoParaContext *ctx) { return VALOR_NULO; }
std::any Interpretador::visitDeclaracaoReturn(PortugolPPParser::DeclaracaoReturnContext *ctx) { return VALOR_NULO; }