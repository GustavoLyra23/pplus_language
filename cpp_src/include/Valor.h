#pragma once

#include <string>
#include <memory>
#include <map>
#include <vector>
#include <functional>

// Forward declarations
class Ambiente;
namespace antlr4 { namespace tree { class ParseTree; } }

class Valor {
public:
    enum class Type {
        INTEIRO,
        REAL,
        TEXTO,
        LOGICO,
        LISTA,
        MAPA,
        OBJETO,
        FUNCAO,
        INTERFACE,
        NULO
    };

    virtual ~Valor() = default;
    virtual Type getType() const = 0;
    virtual std::string toString() const = 0;
    virtual std::shared_ptr<Valor> clone() const = 0;
};

class ValorInteiro : public Valor {
private:
    int valor;
public:
    explicit ValorInteiro(int v) : valor(v) {}
    Type getType() const override { return Type::INTEIRO; }
    std::string toString() const override { return std::to_string(valor); }
    std::shared_ptr<Valor> clone() const override { return std::make_shared<ValorInteiro>(valor); }
    int getValue() const { return valor; }
    void setValue(int v) { valor = v; }
};

class ValorReal : public Valor {
private:
    double valor;
public:
    explicit ValorReal(double v) : valor(v) {}
    Type getType() const override { return Type::REAL; }
    std::string toString() const override { return std::to_string(valor); }
    std::shared_ptr<Valor> clone() const override { return std::make_shared<ValorReal>(valor); }
    double getValue() const { return valor; }
    void setValue(double v) { valor = v; }
};

class ValorTexto : public Valor {
private:
    std::string valor;
public:
    explicit ValorTexto(const std::string& v) : valor(v) {}
    Type getType() const override { return Type::TEXTO; }
    std::string toString() const override { return valor; }
    std::shared_ptr<Valor> clone() const override { return std::make_shared<ValorTexto>(valor); }
    const std::string& getValue() const { return valor; }
    void setValue(const std::string& v) { valor = v; }
};

class ValorLogico : public Valor {
private:
    bool valor;
public:
    explicit ValorLogico(bool v) : valor(v) {}
    Type getType() const override { return Type::LOGICO; }
    std::string toString() const override { return valor ? "verdadeiro" : "falso"; }
    std::shared_ptr<Valor> clone() const override { return std::make_shared<ValorLogico>(valor); }
    bool getValue() const { return valor; }
    void setValue(bool v) { valor = v; }
};

class ValorLista : public Valor {
private:
    std::vector<std::shared_ptr<Valor>> elementos;
public:
    ValorLista() = default;
    explicit ValorLista(const std::vector<std::shared_ptr<Valor>>& v) : elementos(v) {}
    Type getType() const override { return Type::LISTA; }
    std::string toString() const override { return "[Lista]"; }
    std::shared_ptr<Valor> clone() const override;
    std::vector<std::shared_ptr<Valor>>& getElementos() { return elementos; }
    const std::vector<std::shared_ptr<Valor>>& getElementos() const { return elementos; }
};

class ValorMapa : public Valor {
private:
    std::map<std::string, std::shared_ptr<Valor>> elementos;
public:
    ValorMapa() = default;
    explicit ValorMapa(const std::map<std::string, std::shared_ptr<Valor>>& v) : elementos(v) {}
    Type getType() const override { return Type::MAPA; }
    std::string toString() const override { return "[Mapa]"; }
    std::shared_ptr<Valor> clone() const override;
    std::map<std::string, std::shared_ptr<Valor>>& getElementos() { return elementos; }
    const std::map<std::string, std::shared_ptr<Valor>>& getElementos() const { return elementos; }
};

class ValorObjeto : public Valor {
private:
    std::string klass;
    std::map<std::string, std::shared_ptr<Valor>> campos;
    std::string superClasse;
    std::vector<std::string> interfaces;

public:
    ValorObjeto(const std::string& k, const std::map<std::string, std::shared_ptr<Valor>>& c, 
                const std::string& sc = "", const std::vector<std::string>& i = {})
        : klass(k), campos(c), superClasse(sc), interfaces(i) {}
    
    Type getType() const override { return Type::OBJETO; }
    std::string toString() const override { return "[Objeto " + klass + "]"; }
    std::shared_ptr<Valor> clone() const override;
    
    const std::string& getKlass() const { return klass; }
    std::map<std::string, std::shared_ptr<Valor>>& getCampos() { return campos; }
    const std::map<std::string, std::shared_ptr<Valor>>& getCampos() const { return campos; }
    const std::string& getSuperClasse() const { return superClasse; }
    const std::vector<std::string>& getInterfaces() const { return interfaces; }
};

// Function callback types
using FuncaoNativa = std::function<std::shared_ptr<Valor>(const std::vector<std::shared_ptr<Valor>>&)>;
using FuncaoImplementacao = std::function<std::shared_ptr<Valor>(const std::vector<std::shared_ptr<Valor>>&, std::shared_ptr<Ambiente>)>;

class ValorFuncao : public Valor {
private:
    std::string nome;
    antlr4::tree::ParseTree* declaracao;
    std::string tipoRetorno;
    FuncaoImplementacao implementacao;
    FuncaoNativa metodoCallback;

public:
    ValorFuncao(const std::string& n, antlr4::tree::ParseTree* d = nullptr, 
                const std::string& tr = "", FuncaoImplementacao impl = nullptr,
                FuncaoNativa callback = nullptr)
        : nome(n), declaracao(d), tipoRetorno(tr), implementacao(impl), metodoCallback(callback) {}
    
    Type getType() const override { return Type::FUNCAO; }
    std::string toString() const override { return "[função " + nome + "]"; }
    std::shared_ptr<Valor> clone() const override;
    
    const std::string& getNome() const { return nome; }
    antlr4::tree::ParseTree* getDeclaracao() const { return declaracao; }
    const std::string& getTipoRetorno() const { return tipoRetorno; }
    FuncaoImplementacao getImplementacao() const { return implementacao; }
    FuncaoNativa getMetodoCallback() const { return metodoCallback; }
};

class ValorNulo : public Valor {
public:
    Type getType() const override { return Type::NULO; }
    std::string toString() const override { return "nulo"; }
    std::shared_ptr<Valor> clone() const override { return std::make_shared<ValorNulo>(); }
};

// Global singleton for null value
extern std::shared_ptr<ValorNulo> VALOR_NULO;

// Helper functions for type checking and conversion
std::shared_ptr<ValorInteiro> asInteiro(std::shared_ptr<Valor> valor);
std::shared_ptr<ValorReal> asReal(std::shared_ptr<Valor> valor);
std::shared_ptr<ValorTexto> asTexto(std::shared_ptr<Valor> valor);
std::shared_ptr<ValorLogico> asLogico(std::shared_ptr<Valor> valor);
std::shared_ptr<ValorLista> asLista(std::shared_ptr<Valor> valor);
std::shared_ptr<ValorMapa> asMapa(std::shared_ptr<Valor> valor);
std::shared_ptr<ValorObjeto> asObjeto(std::shared_ptr<Valor> valor);
std::shared_ptr<ValorFuncao> asFuncao(std::shared_ptr<Valor> valor);