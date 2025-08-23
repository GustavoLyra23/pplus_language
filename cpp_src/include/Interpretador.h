#pragma once

#include "Valor.h"
#include "Ambiente.h"
#include "PortugolPPBaseVisitor.h"
#include "PortugolPPParser.h"
#include <memory>
#include <set>

class Interpretador : public PortugolPPBaseVisitor {
private:
    std::shared_ptr<Ambiente> global;
    std::shared_ptr<Ambiente> ambiente;
    std::shared_ptr<ValorFuncao> funcaoAtual;
    std::set<std::string> arquivosImportados;

public:
    Interpretador();
    
    void interpretar(PortugolPPParser::ProgramaContext* tree);
    
    // Main visitor methods
    std::any visitPrograma(PortugolPPParser::ProgramaContext *ctx) override;
    std::any visitDeclaracao(PortugolPPParser::DeclaracaoContext *ctx) override;
    std::any visitExpressao(PortugolPPParser::ExpressaoContext *ctx) override;
    std::any visitPrimario(PortugolPPParser::PrimarioContext *ctx) override;
    std::any visitAtribuicao(PortugolPPParser::AtribuicaoContext *ctx) override;
    std::any visitDeclaracaoVar(PortugolPPParser::DeclaracaoVarContext *ctx) override;
    std::any visitDeclaracaoFuncao(PortugolPPParser::DeclaracaoFuncaoContext *ctx) override;
    std::any visitChamadaFuncao(PortugolPPParser::ChamadaFuncaoContext *ctx) override;
    std::any visitDeclaracaoClasse(PortugolPPParser::DeclaracaoClasseContext *ctx) override;
    std::any visitDeclaracaoInterface(PortugolPPParser::DeclaracaoInterfaceContext *ctx) override;
    std::any visitBloco(PortugolPPParser::BlocoContext *ctx) override;
    
    // Arithmetic operations
    std::any visitAdicao(PortugolPPParser::AdicaoContext *ctx) override;
    std::any visitMultiplicacao(PortugolPPParser::MultiplicacaoContext *ctx) override;
    std::any visitUnario(PortugolPPParser::UnarioContext *ctx) override;
    std::any visitChamada(PortugolPPParser::ChamadaContext *ctx) override;
    
    // Logical operations
    std::any visitLogicaOu(PortugolPPParser::LogicaOuContext *ctx) override;
    std::any visitLogicaE(PortugolPPParser::LogicaEContext *ctx) override;
    std::any visitIgualdade(PortugolPPParser::IgualdadeContext *ctx) override;
    std::any visitComparacao(PortugolPPParser::ComparacaoContext *ctx) override;
    
    // Control flow
    std::any visitDeclaracaoSe(PortugolPPParser::DeclaracaoSeContext *ctx) override;
    std::any visitDeclaracaoEnquanto(PortugolPPParser::DeclaracaoEnquantoContext *ctx) override;
    std::any visitDeclaracaoPara(PortugolPPParser::DeclaracaoParaContext *ctx) override;
    std::any visitDeclaracaoReturn(PortugolPPParser::DeclaracaoReturnContext *ctx) override;

private:
    // Helper methods
    std::shared_ptr<Valor> avaliarExpressao(antlr4::tree::ParseTree* ctx);
    std::shared_ptr<Valor> chamadaFuncao(const std::string& nome, const std::vector<std::shared_ptr<Valor>>& argumentos);
    void setupFuncoesNativas();
    void processarDeclaracoesDoArquivo(PortugolPPParser::ProgramaContext* tree);
    void visitFuncaoMain();
};