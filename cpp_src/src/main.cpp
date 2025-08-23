#include <iostream>
#include <fstream>
#include <string>
#include "antlr4-runtime.h"
#include "PortugolPPLexer.h"
#include "PortugolPPParser.h"
#include "Interpretador.h"

// Forward declarations
void executarPortugolPP(const std::string& codigo);

bool validarArquivo(const std::string& caminho) {
    std::ifstream arquivo(caminho);
    if (!arquivo.good()) {
        std::cout << "Erro: Arquivo não encontrado!" << std::endl;
        return false;
    }
    
    if (caminho.substr(caminho.find_last_of(".") + 1) != "ppp") {
        std::cout << "Formato do arquivo inválido! Use arquivos .pplus" << std::endl;
        return false;
    }
    
    return true;
}

void executarArquivo(const std::string& caminho) {
    try {
        if (!validarArquivo(caminho)) return;
        
        std::ifstream arquivo(caminho);
        std::string fileData((std::istreambuf_iterator<char>(arquivo)),
                            std::istreambuf_iterator<char>());
        
        executarPortugolPP(fileData);
    } catch (const std::exception& e) {
        std::cout << "Erro ao ler/executar o arquivo: " << e.what() << std::endl;
    }
}

void executarPortugolPP(const std::string& codigo) {
    try {
        std::cout << "Iniciando análise do código..." << std::endl;
        
        antlr4::ANTLRInputStream input(codigo);
        PortugolPPLexer lexer(&input);
        antlr4::CommonTokenStream tokens(&lexer);
        PortugolPPParser parser(&tokens);
        
        // Add error listeners
        parser.removeErrorListeners();
        class CustomErrorListener : public antlr4::BaseErrorListener {
        public:
            void syntaxError(antlr4::Recognizer* recognizer, antlr4::Token* offendingSymbol,
                           size_t line, size_t charPositionInLine, const std::string& msg,
                           std::exception_ptr e) override {
                std::cout << "Erro de sintaxe na linha " << line << ":" << charPositionInLine 
                         << " - " << msg << std::endl;
            }
        };
        parser.addErrorListener(new CustomErrorListener());
        
        std::cout << "Analisando código..." << std::endl;
        auto tree = parser.programa();
        
        if (!tree) {
            std::cout << "ERRO: Análise sintática falhou - árvore sintática nula!" << std::endl;
            return;
        }
        
        std::cout << "Executando interpretador..." << std::endl;
        Interpretador interpretador;
        interpretador.interpretar(tree);
        std::cout << "Terminando execução!" << std::endl;
        
    } catch (const std::exception& e) {
        std::cout << "Erro ao executar o programa: " << e.what() << std::endl;
    }
}

void modoInterativo() {
    std::cout << "Portugol++ CLI - Modo Interativo" << std::endl;
    std::cout << "Digite 'exit' para sair" << std::endl;
    std::cout << "Digite 'run <caminho>' para executar um arquivo" << std::endl;
    
    std::string input;
    while (true) {
        std::cout << "> ";
        std::getline(std::cin, input);
        
        if (input.empty()) continue;
        
        if (input == "exit") {
            break;
        }
        
        if (input.substr(0, 4) == "run ") {
            std::string caminho = input.substr(4);
            // Trim whitespace
            caminho.erase(0, caminho.find_first_not_of(" \t"));
            caminho.erase(caminho.find_last_not_of(" \t") + 1);
            executarArquivo(caminho);
        } else {
            executarPortugolPP(input);
        }
    }
}

int main(int argc, char* argv[]) {
    std::cout << "Iniciando Portugol++" << std::endl;
    
    if (argc > 1) {
        // File execution mode
        executarArquivo(argv[1]);
    } else {
        // Interactive mode
        modoInterativo();
    }
    
    return 0;
}