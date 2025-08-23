#include "Ambiente.h"
#include <stdexcept>

Ambiente::Ambiente(std::shared_ptr<Ambiente> enc) : enclosing(enc), thisObjeto(nullptr) {}

void Ambiente::definir(const std::string& nome, std::shared_ptr<Valor> valor) {
    valores[nome] = valor;
}

std::shared_ptr<Valor> Ambiente::obter(const std::string& nome) {
    if (nome == "this" && thisObjeto != nullptr) {
        return thisObjeto;
    }
    
    auto it = valores.find(nome);
    if (it != valores.end()) {
        return it->second;
    }
    
    // Check if it's a field of the current object
    if (thisObjeto != nullptr) {
        auto& campos = thisObjeto->getCampos();
        auto campoIt = campos.find(nome);
        if (campoIt != campos.end()) {
            return campoIt->second;
        }
    }
    
    // Check enclosing environment
    if (enclosing != nullptr) {
        auto externoValor = enclosing->obter(nome);
        if (externoValor != nullptr && externoValor->getType() != Valor::Type::NULO) {
            return externoValor;
        }
    }
    
    return VALOR_NULO;
}

void Ambiente::atualizarOuDefinir(const std::string& nome, std::shared_ptr<Valor> valor) {
    // Look for the variable in this and enclosing environments
    std::shared_ptr<Ambiente> ambienteAtual = shared_from_this();
    while (ambienteAtual != nullptr) {
        auto it = ambienteAtual->valores.find(nome);
        if (it != ambienteAtual->valores.end()) {
            ambienteAtual->valores[nome] = valor;
            return;
        }
        ambienteAtual = ambienteAtual->enclosing;
    }
    
    // If not found, define in current environment
    valores[nome] = valor;
}

void Ambiente::definirClasse(const std::string& nome, antlr4::tree::ParseTree* declaracao) {
    classes[nome] = declaracao;
}

antlr4::tree::ParseTree* Ambiente::obterClasse(const std::string& nome) {
    auto it = classes.find(nome);
    if (it != classes.end()) {
        return it->second;
    }
    
    if (enclosing != nullptr) {
        return enclosing->obterClasse(nome);
    }
    
    return nullptr;
}

void Ambiente::definirInterface(const std::string& nome, antlr4::tree::ParseTree* declaracao) {
    interfaces[nome] = declaracao;
}

antlr4::tree::ParseTree* Ambiente::obterInterface(const std::string& nome) {
    auto it = interfaces.find(nome);
    if (it != interfaces.end()) {
        return it->second;
    }
    
    if (enclosing != nullptr) {
        return enclosing->obterInterface(nome);
    }
    
    return nullptr;
}

std::vector<std::string> Ambiente::getInterfaces(antlr4::tree::ParseTree* classeContext) {
    // This would need to be implemented with ANTLR parse tree navigation
    // For now, return empty vector
    return {};
}

std::string Ambiente::getSuperClasse(antlr4::tree::ParseTree* classeContext) {
    // This would need to be implemented with ANTLR parse tree navigation
    // For now, return empty string
    return "";
}

void Ambiente::setThisObjeto(std::shared_ptr<ValorObjeto> obj) {
    thisObjeto = obj;
}

std::shared_ptr<ValorObjeto> Ambiente::getThisObjeto() const {
    return thisObjeto;
}

std::shared_ptr<Ambiente> Ambiente::getEnclosing() const {
    return enclosing;
}