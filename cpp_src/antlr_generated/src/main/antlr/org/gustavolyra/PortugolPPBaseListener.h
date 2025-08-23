
// Generated from src/main/antlr/org/gustavolyra/PortugolPP.g4 by ANTLR 4.13.1

#pragma once


#include "antlr4-runtime.h"
#include "PortugolPPListener.h"


/**
 * This class provides an empty implementation of PortugolPPListener,
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
class  PortugolPPBaseListener : public PortugolPPListener {
public:

  virtual void enterPrograma(PortugolPPParser::ProgramaContext * /*ctx*/) override { }
  virtual void exitPrograma(PortugolPPParser::ProgramaContext * /*ctx*/) override { }

  virtual void enterImportarDeclaracao(PortugolPPParser::ImportarDeclaracaoContext * /*ctx*/) override { }
  virtual void exitImportarDeclaracao(PortugolPPParser::ImportarDeclaracaoContext * /*ctx*/) override { }

  virtual void enterDeclaracao(PortugolPPParser::DeclaracaoContext * /*ctx*/) override { }
  virtual void exitDeclaracao(PortugolPPParser::DeclaracaoContext * /*ctx*/) override { }

  virtual void enterAssinaturaMetodo(PortugolPPParser::AssinaturaMetodoContext * /*ctx*/) override { }
  virtual void exitAssinaturaMetodo(PortugolPPParser::AssinaturaMetodoContext * /*ctx*/) override { }

  virtual void enterDeclaracaoInterface(PortugolPPParser::DeclaracaoInterfaceContext * /*ctx*/) override { }
  virtual void exitDeclaracaoInterface(PortugolPPParser::DeclaracaoInterfaceContext * /*ctx*/) override { }

  virtual void enterDeclaracaoQuebra(PortugolPPParser::DeclaracaoQuebraContext * /*ctx*/) override { }
  virtual void exitDeclaracaoQuebra(PortugolPPParser::DeclaracaoQuebraContext * /*ctx*/) override { }

  virtual void enterDeclaracaoContinue(PortugolPPParser::DeclaracaoContinueContext * /*ctx*/) override { }
  virtual void exitDeclaracaoContinue(PortugolPPParser::DeclaracaoContinueContext * /*ctx*/) override { }

  virtual void enterDeclaracaoFacaEnquanto(PortugolPPParser::DeclaracaoFacaEnquantoContext * /*ctx*/) override { }
  virtual void exitDeclaracaoFacaEnquanto(PortugolPPParser::DeclaracaoFacaEnquantoContext * /*ctx*/) override { }

  virtual void enterDeclaracaoPara(PortugolPPParser::DeclaracaoParaContext * /*ctx*/) override { }
  virtual void exitDeclaracaoPara(PortugolPPParser::DeclaracaoParaContext * /*ctx*/) override { }

  virtual void enterDeclaracaoEnquanto(PortugolPPParser::DeclaracaoEnquantoContext * /*ctx*/) override { }
  virtual void exitDeclaracaoEnquanto(PortugolPPParser::DeclaracaoEnquantoContext * /*ctx*/) override { }

  virtual void enterDeclaracaoSe(PortugolPPParser::DeclaracaoSeContext * /*ctx*/) override { }
  virtual void exitDeclaracaoSe(PortugolPPParser::DeclaracaoSeContext * /*ctx*/) override { }

  virtual void enterDeclaracaoReturn(PortugolPPParser::DeclaracaoReturnContext * /*ctx*/) override { }
  virtual void exitDeclaracaoReturn(PortugolPPParser::DeclaracaoReturnContext * /*ctx*/) override { }

  virtual void enterDeclaracaoClasse(PortugolPPParser::DeclaracaoClasseContext * /*ctx*/) override { }
  virtual void exitDeclaracaoClasse(PortugolPPParser::DeclaracaoClasseContext * /*ctx*/) override { }

  virtual void enterDeclaracaoVar(PortugolPPParser::DeclaracaoVarContext * /*ctx*/) override { }
  virtual void exitDeclaracaoVar(PortugolPPParser::DeclaracaoVarContext * /*ctx*/) override { }

  virtual void enterDeclaracaoFuncao(PortugolPPParser::DeclaracaoFuncaoContext * /*ctx*/) override { }
  virtual void exitDeclaracaoFuncao(PortugolPPParser::DeclaracaoFuncaoContext * /*ctx*/) override { }

  virtual void enterListaParams(PortugolPPParser::ListaParamsContext * /*ctx*/) override { }
  virtual void exitListaParams(PortugolPPParser::ListaParamsContext * /*ctx*/) override { }

  virtual void enterParam(PortugolPPParser::ParamContext * /*ctx*/) override { }
  virtual void exitParam(PortugolPPParser::ParamContext * /*ctx*/) override { }

  virtual void enterTipo(PortugolPPParser::TipoContext * /*ctx*/) override { }
  virtual void exitTipo(PortugolPPParser::TipoContext * /*ctx*/) override { }

  virtual void enterBloco(PortugolPPParser::BlocoContext * /*ctx*/) override { }
  virtual void exitBloco(PortugolPPParser::BlocoContext * /*ctx*/) override { }

  virtual void enterExpressao(PortugolPPParser::ExpressaoContext * /*ctx*/) override { }
  virtual void exitExpressao(PortugolPPParser::ExpressaoContext * /*ctx*/) override { }

  virtual void enterAtribuicao(PortugolPPParser::AtribuicaoContext * /*ctx*/) override { }
  virtual void exitAtribuicao(PortugolPPParser::AtribuicaoContext * /*ctx*/) override { }

  virtual void enterAcesso(PortugolPPParser::AcessoContext * /*ctx*/) override { }
  virtual void exitAcesso(PortugolPPParser::AcessoContext * /*ctx*/) override { }

  virtual void enterAcessoArray(PortugolPPParser::AcessoArrayContext * /*ctx*/) override { }
  virtual void exitAcessoArray(PortugolPPParser::AcessoArrayContext * /*ctx*/) override { }

  virtual void enterLogicaOu(PortugolPPParser::LogicaOuContext * /*ctx*/) override { }
  virtual void exitLogicaOu(PortugolPPParser::LogicaOuContext * /*ctx*/) override { }

  virtual void enterLogicaE(PortugolPPParser::LogicaEContext * /*ctx*/) override { }
  virtual void exitLogicaE(PortugolPPParser::LogicaEContext * /*ctx*/) override { }

  virtual void enterIgualdade(PortugolPPParser::IgualdadeContext * /*ctx*/) override { }
  virtual void exitIgualdade(PortugolPPParser::IgualdadeContext * /*ctx*/) override { }

  virtual void enterComparacao(PortugolPPParser::ComparacaoContext * /*ctx*/) override { }
  virtual void exitComparacao(PortugolPPParser::ComparacaoContext * /*ctx*/) override { }

  virtual void enterAdicao(PortugolPPParser::AdicaoContext * /*ctx*/) override { }
  virtual void exitAdicao(PortugolPPParser::AdicaoContext * /*ctx*/) override { }

  virtual void enterMultiplicacao(PortugolPPParser::MultiplicacaoContext * /*ctx*/) override { }
  virtual void exitMultiplicacao(PortugolPPParser::MultiplicacaoContext * /*ctx*/) override { }

  virtual void enterUnario(PortugolPPParser::UnarioContext * /*ctx*/) override { }
  virtual void exitUnario(PortugolPPParser::UnarioContext * /*ctx*/) override { }

  virtual void enterChamada(PortugolPPParser::ChamadaContext * /*ctx*/) override { }
  virtual void exitChamada(PortugolPPParser::ChamadaContext * /*ctx*/) override { }

  virtual void enterChamadaFuncao(PortugolPPParser::ChamadaFuncaoContext * /*ctx*/) override { }
  virtual void exitChamadaFuncao(PortugolPPParser::ChamadaFuncaoContext * /*ctx*/) override { }

  virtual void enterArgumentos(PortugolPPParser::ArgumentosContext * /*ctx*/) override { }
  virtual void exitArgumentos(PortugolPPParser::ArgumentosContext * /*ctx*/) override { }

  virtual void enterPrimario(PortugolPPParser::PrimarioContext * /*ctx*/) override { }
  virtual void exitPrimario(PortugolPPParser::PrimarioContext * /*ctx*/) override { }

  virtual void enterListaLiteral(PortugolPPParser::ListaLiteralContext * /*ctx*/) override { }
  virtual void exitListaLiteral(PortugolPPParser::ListaLiteralContext * /*ctx*/) override { }

  virtual void enterMapaLiteral(PortugolPPParser::MapaLiteralContext * /*ctx*/) override { }
  virtual void exitMapaLiteral(PortugolPPParser::MapaLiteralContext * /*ctx*/) override { }


  virtual void enterEveryRule(antlr4::ParserRuleContext * /*ctx*/) override { }
  virtual void exitEveryRule(antlr4::ParserRuleContext * /*ctx*/) override { }
  virtual void visitTerminal(antlr4::tree::TerminalNode * /*node*/) override { }
  virtual void visitErrorNode(antlr4::tree::ErrorNode * /*node*/) override { }

};

