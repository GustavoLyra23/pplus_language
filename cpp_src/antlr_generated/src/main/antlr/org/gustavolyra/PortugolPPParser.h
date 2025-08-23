
// Generated from src/main/antlr/org/gustavolyra/PortugolPP.g4 by ANTLR 4.13.1

#pragma once


#include "antlr4-runtime.h"




class  PortugolPPParser : public antlr4::Parser {
public:
  enum {
    T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, 
    T__7 = 8, T__8 = 9, T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, 
    T__14 = 15, T__15 = 16, T__16 = 17, T__17 = 18, T__18 = 19, T__19 = 20, 
    T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24, T__24 = 25, T__25 = 26, 
    T__26 = 27, T__27 = 28, T__28 = 29, T__29 = 30, T__30 = 31, T__31 = 32, 
    T__32 = 33, T__33 = 34, T__34 = 35, T__35 = 36, T__36 = 37, T__37 = 38, 
    T__38 = 39, T__39 = 40, T__40 = 41, T__41 = 42, T__42 = 43, T__43 = 44, 
    T__44 = 45, T__45 = 46, T__46 = 47, T__47 = 48, T__48 = 49, T__49 = 50, 
    T__50 = 51, ID = 52, NUMERO = 53, TEXTO_LITERAL = 54, ESPACO = 55, COMENTARIO = 56, 
    COMENTARIO_BLOCO = 57
  };

  enum {
    RulePrograma = 0, RuleImportarDeclaracao = 1, RuleDeclaracao = 2, RuleAssinaturaMetodo = 3, 
    RuleDeclaracaoInterface = 4, RuleDeclaracaoQuebra = 5, RuleDeclaracaoContinue = 6, 
    RuleDeclaracaoFacaEnquanto = 7, RuleDeclaracaoPara = 8, RuleDeclaracaoEnquanto = 9, 
    RuleDeclaracaoSe = 10, RuleDeclaracaoReturn = 11, RuleDeclaracaoClasse = 12, 
    RuleDeclaracaoVar = 13, RuleDeclaracaoFuncao = 14, RuleListaParams = 15, 
    RuleParam = 16, RuleTipo = 17, RuleBloco = 18, RuleExpressao = 19, RuleAtribuicao = 20, 
    RuleAcesso = 21, RuleAcessoArray = 22, RuleLogicaOu = 23, RuleLogicaE = 24, 
    RuleIgualdade = 25, RuleComparacao = 26, RuleAdicao = 27, RuleMultiplicacao = 28, 
    RuleUnario = 29, RuleChamada = 30, RuleChamadaFuncao = 31, RuleArgumentos = 32, 
    RulePrimario = 33, RuleListaLiteral = 34, RuleMapaLiteral = 35
  };

  explicit PortugolPPParser(antlr4::TokenStream *input);

  PortugolPPParser(antlr4::TokenStream *input, const antlr4::atn::ParserATNSimulatorOptions &options);

  ~PortugolPPParser() override;

  std::string getGrammarFileName() const override;

  const antlr4::atn::ATN& getATN() const override;

  const std::vector<std::string>& getRuleNames() const override;

  const antlr4::dfa::Vocabulary& getVocabulary() const override;

  antlr4::atn::SerializedATNView getSerializedATN() const override;


  class ProgramaContext;
  class ImportarDeclaracaoContext;
  class DeclaracaoContext;
  class AssinaturaMetodoContext;
  class DeclaracaoInterfaceContext;
  class DeclaracaoQuebraContext;
  class DeclaracaoContinueContext;
  class DeclaracaoFacaEnquantoContext;
  class DeclaracaoParaContext;
  class DeclaracaoEnquantoContext;
  class DeclaracaoSeContext;
  class DeclaracaoReturnContext;
  class DeclaracaoClasseContext;
  class DeclaracaoVarContext;
  class DeclaracaoFuncaoContext;
  class ListaParamsContext;
  class ParamContext;
  class TipoContext;
  class BlocoContext;
  class ExpressaoContext;
  class AtribuicaoContext;
  class AcessoContext;
  class AcessoArrayContext;
  class LogicaOuContext;
  class LogicaEContext;
  class IgualdadeContext;
  class ComparacaoContext;
  class AdicaoContext;
  class MultiplicacaoContext;
  class UnarioContext;
  class ChamadaContext;
  class ChamadaFuncaoContext;
  class ArgumentosContext;
  class PrimarioContext;
  class ListaLiteralContext;
  class MapaLiteralContext; 

  class  ProgramaContext : public antlr4::ParserRuleContext {
  public:
    ProgramaContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *EOF();
    std::vector<ImportarDeclaracaoContext *> importarDeclaracao();
    ImportarDeclaracaoContext* importarDeclaracao(size_t i);
    std::vector<DeclaracaoContext *> declaracao();
    DeclaracaoContext* declaracao(size_t i);

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ProgramaContext* programa();

  class  ImportarDeclaracaoContext : public antlr4::ParserRuleContext {
  public:
    ImportarDeclaracaoContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *TEXTO_LITERAL();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ImportarDeclaracaoContext* importarDeclaracao();

  class  DeclaracaoContext : public antlr4::ParserRuleContext {
  public:
    DeclaracaoContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    DeclaracaoClasseContext *declaracaoClasse();
    DeclaracaoVarContext *declaracaoVar();
    DeclaracaoFuncaoContext *declaracaoFuncao();
    DeclaracaoSeContext *declaracaoSe();
    ChamadaFuncaoContext *chamadaFuncao();
    BlocoContext *bloco();
    ExpressaoContext *expressao();
    DeclaracaoReturnContext *declaracaoReturn();
    DeclaracaoEnquantoContext *declaracaoEnquanto();
    DeclaracaoParaContext *declaracaoPara();
    DeclaracaoFacaEnquantoContext *declaracaoFacaEnquanto();
    DeclaracaoQuebraContext *declaracaoQuebra();
    DeclaracaoContinueContext *declaracaoContinue();
    DeclaracaoInterfaceContext *declaracaoInterface();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  DeclaracaoContext* declaracao();

  class  AssinaturaMetodoContext : public antlr4::ParserRuleContext {
  public:
    AssinaturaMetodoContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *ID();
    ListaParamsContext *listaParams();
    TipoContext *tipo();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  AssinaturaMetodoContext* assinaturaMetodo();

  class  DeclaracaoInterfaceContext : public antlr4::ParserRuleContext {
  public:
    DeclaracaoInterfaceContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *ID();
    std::vector<AssinaturaMetodoContext *> assinaturaMetodo();
    AssinaturaMetodoContext* assinaturaMetodo(size_t i);

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  DeclaracaoInterfaceContext* declaracaoInterface();

  class  DeclaracaoQuebraContext : public antlr4::ParserRuleContext {
  public:
    DeclaracaoQuebraContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  DeclaracaoQuebraContext* declaracaoQuebra();

  class  DeclaracaoContinueContext : public antlr4::ParserRuleContext {
  public:
    DeclaracaoContinueContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  DeclaracaoContinueContext* declaracaoContinue();

  class  DeclaracaoFacaEnquantoContext : public antlr4::ParserRuleContext {
  public:
    DeclaracaoFacaEnquantoContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    DeclaracaoContext *declaracao();
    ExpressaoContext *expressao();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  DeclaracaoFacaEnquantoContext* declaracaoFacaEnquanto();

  class  DeclaracaoParaContext : public antlr4::ParserRuleContext {
  public:
    DeclaracaoParaContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<ExpressaoContext *> expressao();
    ExpressaoContext* expressao(size_t i);
    DeclaracaoContext *declaracao();
    DeclaracaoVarContext *declaracaoVar();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  DeclaracaoParaContext* declaracaoPara();

  class  DeclaracaoEnquantoContext : public antlr4::ParserRuleContext {
  public:
    DeclaracaoEnquantoContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    ExpressaoContext *expressao();
    DeclaracaoContext *declaracao();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  DeclaracaoEnquantoContext* declaracaoEnquanto();

  class  DeclaracaoSeContext : public antlr4::ParserRuleContext {
  public:
    DeclaracaoSeContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    ExpressaoContext *expressao();
    std::vector<DeclaracaoContext *> declaracao();
    DeclaracaoContext* declaracao(size_t i);

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  DeclaracaoSeContext* declaracaoSe();

  class  DeclaracaoReturnContext : public antlr4::ParserRuleContext {
  public:
    DeclaracaoReturnContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    ExpressaoContext *expressao();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  DeclaracaoReturnContext* declaracaoReturn();

  class  DeclaracaoClasseContext : public antlr4::ParserRuleContext {
  public:
    DeclaracaoClasseContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<antlr4::tree::TerminalNode *> ID();
    antlr4::tree::TerminalNode* ID(size_t i);
    std::vector<DeclaracaoVarContext *> declaracaoVar();
    DeclaracaoVarContext* declaracaoVar(size_t i);
    std::vector<DeclaracaoFuncaoContext *> declaracaoFuncao();
    DeclaracaoFuncaoContext* declaracaoFuncao(size_t i);

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  DeclaracaoClasseContext* declaracaoClasse();

  class  DeclaracaoVarContext : public antlr4::ParserRuleContext {
  public:
    DeclaracaoVarContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *ID();
    TipoContext *tipo();
    ExpressaoContext *expressao();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  DeclaracaoVarContext* declaracaoVar();

  class  DeclaracaoFuncaoContext : public antlr4::ParserRuleContext {
  public:
    DeclaracaoFuncaoContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *ID();
    BlocoContext *bloco();
    ListaParamsContext *listaParams();
    TipoContext *tipo();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  DeclaracaoFuncaoContext* declaracaoFuncao();

  class  ListaParamsContext : public antlr4::ParserRuleContext {
  public:
    ListaParamsContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<ParamContext *> param();
    ParamContext* param(size_t i);

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ListaParamsContext* listaParams();

  class  ParamContext : public antlr4::ParserRuleContext {
  public:
    ParamContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *ID();
    TipoContext *tipo();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ParamContext* param();

  class  TipoContext : public antlr4::ParserRuleContext {
  public:
    TipoContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *ID();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  TipoContext* tipo();

  class  BlocoContext : public antlr4::ParserRuleContext {
  public:
    BlocoContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<DeclaracaoContext *> declaracao();
    DeclaracaoContext* declaracao(size_t i);

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  BlocoContext* bloco();

  class  ExpressaoContext : public antlr4::ParserRuleContext {
  public:
    ExpressaoContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    AtribuicaoContext *atribuicao();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ExpressaoContext* expressao();

  class  AtribuicaoContext : public antlr4::ParserRuleContext {
  public:
    AtribuicaoContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    ExpressaoContext *expressao();
    antlr4::tree::TerminalNode *ID();
    AcessoContext *acesso();
    AcessoArrayContext *acessoArray();
    LogicaOuContext *logicaOu();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  AtribuicaoContext* atribuicao();

  class  AcessoContext : public antlr4::ParserRuleContext {
  public:
    AcessoContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    PrimarioContext *primario();
    antlr4::tree::TerminalNode *ID();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  AcessoContext* acesso();

  class  AcessoArrayContext : public antlr4::ParserRuleContext {
  public:
    AcessoArrayContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    PrimarioContext *primario();
    std::vector<ExpressaoContext *> expressao();
    ExpressaoContext* expressao(size_t i);

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  AcessoArrayContext* acessoArray();

  class  LogicaOuContext : public antlr4::ParserRuleContext {
  public:
    LogicaOuContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<LogicaEContext *> logicaE();
    LogicaEContext* logicaE(size_t i);

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  LogicaOuContext* logicaOu();

  class  LogicaEContext : public antlr4::ParserRuleContext {
  public:
    LogicaEContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<IgualdadeContext *> igualdade();
    IgualdadeContext* igualdade(size_t i);

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  LogicaEContext* logicaE();

  class  IgualdadeContext : public antlr4::ParserRuleContext {
  public:
    IgualdadeContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<ComparacaoContext *> comparacao();
    ComparacaoContext* comparacao(size_t i);

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  IgualdadeContext* igualdade();

  class  ComparacaoContext : public antlr4::ParserRuleContext {
  public:
    ComparacaoContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<AdicaoContext *> adicao();
    AdicaoContext* adicao(size_t i);

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ComparacaoContext* comparacao();

  class  AdicaoContext : public antlr4::ParserRuleContext {
  public:
    AdicaoContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<MultiplicacaoContext *> multiplicacao();
    MultiplicacaoContext* multiplicacao(size_t i);

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  AdicaoContext* adicao();

  class  MultiplicacaoContext : public antlr4::ParserRuleContext {
  public:
    MultiplicacaoContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<UnarioContext *> unario();
    UnarioContext* unario(size_t i);

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  MultiplicacaoContext* multiplicacao();

  class  UnarioContext : public antlr4::ParserRuleContext {
  public:
    UnarioContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    UnarioContext *unario();
    ChamadaContext *chamada();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  UnarioContext* unario();

  class  ChamadaContext : public antlr4::ParserRuleContext {
  public:
    ChamadaContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    PrimarioContext *primario();
    std::vector<antlr4::tree::TerminalNode *> ID();
    antlr4::tree::TerminalNode* ID(size_t i);
    std::vector<ArgumentosContext *> argumentos();
    ArgumentosContext* argumentos(size_t i);
    AcessoArrayContext *acessoArray();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ChamadaContext* chamada();

  class  ChamadaFuncaoContext : public antlr4::ParserRuleContext {
  public:
    ChamadaFuncaoContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *ID();
    ArgumentosContext *argumentos();
    PrimarioContext *primario();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ChamadaFuncaoContext* chamadaFuncao();

  class  ArgumentosContext : public antlr4::ParserRuleContext {
  public:
    ArgumentosContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<ExpressaoContext *> expressao();
    ExpressaoContext* expressao(size_t i);

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ArgumentosContext* argumentos();

  class  PrimarioContext : public antlr4::ParserRuleContext {
  public:
    PrimarioContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *NUMERO();
    antlr4::tree::TerminalNode *TEXTO_LITERAL();
    antlr4::tree::TerminalNode *ID();
    ArgumentosContext *argumentos();
    ExpressaoContext *expressao();
    ListaLiteralContext *listaLiteral();
    MapaLiteralContext *mapaLiteral();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  PrimarioContext* primario();

  class  ListaLiteralContext : public antlr4::ParserRuleContext {
  public:
    ListaLiteralContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ListaLiteralContext* listaLiteral();

  class  MapaLiteralContext : public antlr4::ParserRuleContext {
  public:
    MapaLiteralContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  MapaLiteralContext* mapaLiteral();


  // By default the static state used to implement the parser is lazily initialized during the first
  // call to the constructor. You can call this function if you wish to initialize the static state
  // ahead of time.
  static void initialize();

private:
};

