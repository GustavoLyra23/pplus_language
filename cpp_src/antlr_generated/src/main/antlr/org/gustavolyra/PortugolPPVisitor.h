
// Generated from src/main/antlr/org/gustavolyra/PortugolPP.g4 by ANTLR 4.13.1

#pragma once


#include "antlr4-runtime.h"
#include "PortugolPPParser.h"



/**
 * This class defines an abstract visitor for a parse tree
 * produced by PortugolPPParser.
 */
class  PortugolPPVisitor : public antlr4::tree::AbstractParseTreeVisitor {
public:

  /**
   * Visit parse trees produced by PortugolPPParser.
   */
    virtual std::any visitPrograma(PortugolPPParser::ProgramaContext *context) = 0;

    virtual std::any visitImportarDeclaracao(PortugolPPParser::ImportarDeclaracaoContext *context) = 0;

    virtual std::any visitDeclaracao(PortugolPPParser::DeclaracaoContext *context) = 0;

    virtual std::any visitAssinaturaMetodo(PortugolPPParser::AssinaturaMetodoContext *context) = 0;

    virtual std::any visitDeclaracaoInterface(PortugolPPParser::DeclaracaoInterfaceContext *context) = 0;

    virtual std::any visitDeclaracaoQuebra(PortugolPPParser::DeclaracaoQuebraContext *context) = 0;

    virtual std::any visitDeclaracaoContinue(PortugolPPParser::DeclaracaoContinueContext *context) = 0;

    virtual std::any visitDeclaracaoFacaEnquanto(PortugolPPParser::DeclaracaoFacaEnquantoContext *context) = 0;

    virtual std::any visitDeclaracaoPara(PortugolPPParser::DeclaracaoParaContext *context) = 0;

    virtual std::any visitDeclaracaoEnquanto(PortugolPPParser::DeclaracaoEnquantoContext *context) = 0;

    virtual std::any visitDeclaracaoSe(PortugolPPParser::DeclaracaoSeContext *context) = 0;

    virtual std::any visitDeclaracaoReturn(PortugolPPParser::DeclaracaoReturnContext *context) = 0;

    virtual std::any visitDeclaracaoClasse(PortugolPPParser::DeclaracaoClasseContext *context) = 0;

    virtual std::any visitDeclaracaoVar(PortugolPPParser::DeclaracaoVarContext *context) = 0;

    virtual std::any visitDeclaracaoFuncao(PortugolPPParser::DeclaracaoFuncaoContext *context) = 0;

    virtual std::any visitListaParams(PortugolPPParser::ListaParamsContext *context) = 0;

    virtual std::any visitParam(PortugolPPParser::ParamContext *context) = 0;

    virtual std::any visitTipo(PortugolPPParser::TipoContext *context) = 0;

    virtual std::any visitBloco(PortugolPPParser::BlocoContext *context) = 0;

    virtual std::any visitExpressao(PortugolPPParser::ExpressaoContext *context) = 0;

    virtual std::any visitAtribuicao(PortugolPPParser::AtribuicaoContext *context) = 0;

    virtual std::any visitAcesso(PortugolPPParser::AcessoContext *context) = 0;

    virtual std::any visitAcessoArray(PortugolPPParser::AcessoArrayContext *context) = 0;

    virtual std::any visitLogicaOu(PortugolPPParser::LogicaOuContext *context) = 0;

    virtual std::any visitLogicaE(PortugolPPParser::LogicaEContext *context) = 0;

    virtual std::any visitIgualdade(PortugolPPParser::IgualdadeContext *context) = 0;

    virtual std::any visitComparacao(PortugolPPParser::ComparacaoContext *context) = 0;

    virtual std::any visitAdicao(PortugolPPParser::AdicaoContext *context) = 0;

    virtual std::any visitMultiplicacao(PortugolPPParser::MultiplicacaoContext *context) = 0;

    virtual std::any visitUnario(PortugolPPParser::UnarioContext *context) = 0;

    virtual std::any visitChamada(PortugolPPParser::ChamadaContext *context) = 0;

    virtual std::any visitChamadaFuncao(PortugolPPParser::ChamadaFuncaoContext *context) = 0;

    virtual std::any visitArgumentos(PortugolPPParser::ArgumentosContext *context) = 0;

    virtual std::any visitPrimario(PortugolPPParser::PrimarioContext *context) = 0;

    virtual std::any visitListaLiteral(PortugolPPParser::ListaLiteralContext *context) = 0;

    virtual std::any visitMapaLiteral(PortugolPPParser::MapaLiteralContext *context) = 0;


};

