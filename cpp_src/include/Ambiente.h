#pragma once

#include "Valor.h"
#include <string>
#include <map>
#include <memory>
#include <vector>

// Forward declarations
namespace antlr4 { namespace tree { class ParseTree; } }

class Ambiente : public std::enable_shared_from_this<Ambiente> {
private:
    std::shared_ptr<Ambiente> enclosing;
    std::map<std::string, std::shared_ptr<Valor>> valores;
    std::map<std::string, antlr4::tree::ParseTree*> classes;
    std::map<std::string, antlr4::tree::ParseTree*> interfaces;
    std::shared_ptr<ValorObjeto> thisObjeto;

public:
    explicit Ambiente(std::shared_ptr<Ambiente> enc = nullptr);
    
    // Variable management
    void definir(const std::string& nome, std::shared_ptr<Valor> valor);
    std::shared_ptr<Valor> obter(const std::string& nome);
    void atualizarOuDefinir(const std::string& nome, std::shared_ptr<Valor> valor);
    
    // Class management
    void definirClasse(const std::string& nome, antlr4::tree::ParseTree* declaracao);
    antlr4::tree::ParseTree* obterClasse(const std::string& nome);
    
    // Interface management
    void definirInterface(const std::string& nome, antlr4::tree::ParseTree* declaracao);
    antlr4::tree::ParseTree* obterInterface(const std::string& nome);
    
    // Helper methods
    std::vector<std::string> getInterfaces(antlr4::tree::ParseTree* classeContext);
    std::string getSuperClasse(antlr4::tree::ParseTree* classeContext);
    
    // This object management
    void setThisObjeto(std::shared_ptr<ValorObjeto> obj);
    std::shared_ptr<ValorObjeto> getThisObjeto() const;
    
    // Enclosing environment access
    std::shared_ptr<Ambiente> getEnclosing() const;
};