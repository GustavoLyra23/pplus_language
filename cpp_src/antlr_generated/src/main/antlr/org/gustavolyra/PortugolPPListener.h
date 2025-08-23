
// Generated from src/main/antlr/org/gustavolyra/PortugolPP.g4 by ANTLR 4.13.1

#pragma once


#include "antlr4-runtime.h"
#include "PortugolPPParser.h"


/**
 * This interface defines an abstract listener for a parse tree produced by PortugolPPParser.
 */
class  PortugolPPListener : public antlr4::tree::ParseTreeListener {
public:

  virtual void enterPrograma(PortugolPPParser::ProgramaContext *ctx) = 0;
  virtual void exitPrograma(PortugolPPParser::ProgramaContext *ctx) = 0;

  virtual void enterImportarDeclaracao(PortugolPPParser::ImportarDeclaracaoContext *ctx) = 0;
  virtual void exitImportarDeclaracao(PortugolPPParser::ImportarDeclaracaoContext *ctx) = 0;

  virtual void enterDeclaracao(PortugolPPParser::DeclaracaoContext *ctx) = 0;
  virtual void exitDeclaracao(PortugolPPParser::DeclaracaoContext *ctx) = 0;

  virtual void enterAssinaturaMetodo(PortugolPPParser::AssinaturaMetodoContext *ctx) = 0;
  virtual void exitAssinaturaMetodo(PortugolPPParser::AssinaturaMetodoContext *ctx) = 0;

  virtual void enterDeclaracaoInterface(PortugolPPParser::DeclaracaoInterfaceContext *ctx) = 0;
  virtual void exitDeclaracaoInterface(PortugolPPParser::DeclaracaoInterfaceContext *ctx) = 0;

  virtual void enterDeclaracaoQuebra(PortugolPPParser::DeclaracaoQuebraContext *ctx) = 0;
  virtual void exitDeclaracaoQuebra(PortugolPPParser::DeclaracaoQuebraContext *ctx) = 0;

  virtual void enterDeclaracaoContinue(PortugolPPParser::DeclaracaoContinueContext *ctx) = 0;
  virtual void exitDeclaracaoContinue(PortugolPPParser::DeclaracaoContinueContext *ctx) = 0;

  virtual void enterDeclaracaoFacaEnquanto(PortugolPPParser::DeclaracaoFacaEnquantoContext *ctx) = 0;
  virtual void exitDeclaracaoFacaEnquanto(PortugolPPParser::DeclaracaoFacaEnquantoContext *ctx) = 0;

  virtual void enterDeclaracaoPara(PortugolPPParser::DeclaracaoParaContext *ctx) = 0;
  virtual void exitDeclaracaoPara(PortugolPPParser::DeclaracaoParaContext *ctx) = 0;

  virtual void enterDeclaracaoEnquanto(PortugolPPParser::DeclaracaoEnquantoContext *ctx) = 0;
  virtual void exitDeclaracaoEnquanto(PortugolPPParser::DeclaracaoEnquantoContext *ctx) = 0;

  virtual void enterDeclaracaoSe(PortugolPPParser::DeclaracaoSeContext *ctx) = 0;
  virtual void exitDeclaracaoSe(PortugolPPParser::DeclaracaoSeContext *ctx) = 0;

  virtual void enterDeclaracaoReturn(PortugolPPParser::DeclaracaoReturnContext *ctx) = 0;
  virtual void exitDeclaracaoReturn(PortugolPPParser::DeclaracaoReturnContext *ctx) = 0;

  virtual void enterDeclaracaoClasse(PortugolPPParser::DeclaracaoClasseContext *ctx) = 0;
  virtual void exitDeclaracaoClasse(PortugolPPParser::DeclaracaoClasseContext *ctx) = 0;

  virtual void enterDeclaracaoVar(PortugolPPParser::DeclaracaoVarContext *ctx) = 0;
  virtual void exitDeclaracaoVar(PortugolPPParser::DeclaracaoVarContext *ctx) = 0;

  virtual void enterDeclaracaoFuncao(PortugolPPParser::DeclaracaoFuncaoContext *ctx) = 0;
  virtual void exitDeclaracaoFuncao(PortugolPPParser::DeclaracaoFuncaoContext *ctx) = 0;

  virtual void enterListaParams(PortugolPPParser::ListaParamsContext *ctx) = 0;
  virtual void exitListaParams(PortugolPPParser::ListaParamsContext *ctx) = 0;

  virtual void enterParam(PortugolPPParser::ParamContext *ctx) = 0;
  virtual void exitParam(PortugolPPParser::ParamContext *ctx) = 0;

  virtual void enterTipo(PortugolPPParser::TipoContext *ctx) = 0;
  virtual void exitTipo(PortugolPPParser::TipoContext *ctx) = 0;

  virtual void enterBloco(PortugolPPParser::BlocoContext *ctx) = 0;
  virtual void exitBloco(PortugolPPParser::BlocoContext *ctx) = 0;

  virtual void enterExpressao(PortugolPPParser::ExpressaoContext *ctx) = 0;
  virtual void exitExpressao(PortugolPPParser::ExpressaoContext *ctx) = 0;

  virtual void enterAtribuicao(PortugolPPParser::AtribuicaoContext *ctx) = 0;
  virtual void exitAtribuicao(PortugolPPParser::AtribuicaoContext *ctx) = 0;

  virtual void enterAcesso(PortugolPPParser::AcessoContext *ctx) = 0;
  virtual void exitAcesso(PortugolPPParser::AcessoContext *ctx) = 0;

  virtual void enterAcessoArray(PortugolPPParser::AcessoArrayContext *ctx) = 0;
  virtual void exitAcessoArray(PortugolPPParser::AcessoArrayContext *ctx) = 0;

  virtual void enterLogicaOu(PortugolPPParser::LogicaOuContext *ctx) = 0;
  virtual void exitLogicaOu(PortugolPPParser::LogicaOuContext *ctx) = 0;

  virtual void enterLogicaE(PortugolPPParser::LogicaEContext *ctx) = 0;
  virtual void exitLogicaE(PortugolPPParser::LogicaEContext *ctx) = 0;

  virtual void enterIgualdade(PortugolPPParser::IgualdadeContext *ctx) = 0;
  virtual void exitIgualdade(PortugolPPParser::IgualdadeContext *ctx) = 0;

  virtual void enterComparacao(PortugolPPParser::ComparacaoContext *ctx) = 0;
  virtual void exitComparacao(PortugolPPParser::ComparacaoContext *ctx) = 0;

  virtual void enterAdicao(PortugolPPParser::AdicaoContext *ctx) = 0;
  virtual void exitAdicao(PortugolPPParser::AdicaoContext *ctx) = 0;

  virtual void enterMultiplicacao(PortugolPPParser::MultiplicacaoContext *ctx) = 0;
  virtual void exitMultiplicacao(PortugolPPParser::MultiplicacaoContext *ctx) = 0;

  virtual void enterUnario(PortugolPPParser::UnarioContext *ctx) = 0;
  virtual void exitUnario(PortugolPPParser::UnarioContext *ctx) = 0;

  virtual void enterChamada(PortugolPPParser::ChamadaContext *ctx) = 0;
  virtual void exitChamada(PortugolPPParser::ChamadaContext *ctx) = 0;

  virtual void enterChamadaFuncao(PortugolPPParser::ChamadaFuncaoContext *ctx) = 0;
  virtual void exitChamadaFuncao(PortugolPPParser::ChamadaFuncaoContext *ctx) = 0;

  virtual void enterArgumentos(PortugolPPParser::ArgumentosContext *ctx) = 0;
  virtual void exitArgumentos(PortugolPPParser::ArgumentosContext *ctx) = 0;

  virtual void enterPrimario(PortugolPPParser::PrimarioContext *ctx) = 0;
  virtual void exitPrimario(PortugolPPParser::PrimarioContext *ctx) = 0;

  virtual void enterListaLiteral(PortugolPPParser::ListaLiteralContext *ctx) = 0;
  virtual void exitListaLiteral(PortugolPPParser::ListaLiteralContext *ctx) = 0;

  virtual void enterMapaLiteral(PortugolPPParser::MapaLiteralContext *ctx) = 0;
  virtual void exitMapaLiteral(PortugolPPParser::MapaLiteralContext *ctx) = 0;


};

