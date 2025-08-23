#include "Valor.h"

// Global null value singleton
std::shared_ptr<ValorNulo> VALOR_NULO = std::make_shared<ValorNulo>();

// Clone implementations for complex types
std::shared_ptr<Valor> ValorLista::clone() const {
    std::vector<std::shared_ptr<Valor>> copiedElements;
    for (const auto& elemento : elementos) {
        copiedElements.push_back(elemento->clone());
    }
    return std::make_shared<ValorLista>(copiedElements);
}

std::shared_ptr<Valor> ValorMapa::clone() const {
    std::map<std::string, std::shared_ptr<Valor>> copiedElements;
    for (const auto& [key, value] : elementos) {
        copiedElements[key] = value->clone();
    }
    return std::make_shared<ValorMapa>(copiedElements);
}

std::shared_ptr<Valor> ValorObjeto::clone() const {
    std::map<std::string, std::shared_ptr<Valor>> copiedCampos;
    for (const auto& [key, value] : campos) {
        copiedCampos[key] = value->clone();
    }
    return std::make_shared<ValorObjeto>(klass, copiedCampos, superClasse, interfaces);
}

std::shared_ptr<Valor> ValorFuncao::clone() const {
    return std::make_shared<ValorFuncao>(nome, declaracao, tipoRetorno, implementacao, metodoCallback);
}

// Helper functions for type checking and conversion
std::shared_ptr<ValorInteiro> asInteiro(std::shared_ptr<Valor> valor) {
    if (valor->getType() == Valor::Type::INTEIRO) {
        return std::static_pointer_cast<ValorInteiro>(valor);
    }
    return nullptr;
}

std::shared_ptr<ValorReal> asReal(std::shared_ptr<Valor> valor) {
    if (valor->getType() == Valor::Type::REAL) {
        return std::static_pointer_cast<ValorReal>(valor);
    }
    return nullptr;
}

std::shared_ptr<ValorTexto> asTexto(std::shared_ptr<Valor> valor) {
    if (valor->getType() == Valor::Type::TEXTO) {
        return std::static_pointer_cast<ValorTexto>(valor);
    }
    return nullptr;
}

std::shared_ptr<ValorLogico> asLogico(std::shared_ptr<Valor> valor) {
    if (valor->getType() == Valor::Type::LOGICO) {
        return std::static_pointer_cast<ValorLogico>(valor);
    }
    return nullptr;
}

std::shared_ptr<ValorLista> asLista(std::shared_ptr<Valor> valor) {
    if (valor->getType() == Valor::Type::LISTA) {
        return std::static_pointer_cast<ValorLista>(valor);
    }
    return nullptr;
}

std::shared_ptr<ValorMapa> asMapa(std::shared_ptr<Valor> valor) {
    if (valor->getType() == Valor::Type::MAPA) {
        return std::static_pointer_cast<ValorMapa>(valor);
    }
    return nullptr;
}

std::shared_ptr<ValorObjeto> asObjeto(std::shared_ptr<Valor> valor) {
    if (valor->getType() == Valor::Type::OBJETO) {
        return std::static_pointer_cast<ValorObjeto>(valor);
    }
    return nullptr;
}

std::shared_ptr<ValorFuncao> asFuncao(std::shared_ptr<Valor> valor) {
    if (valor->getType() == Valor::Type::FUNCAO) {
        return std::static_pointer_cast<ValorFuncao>(valor);
    }
    return nullptr;
}