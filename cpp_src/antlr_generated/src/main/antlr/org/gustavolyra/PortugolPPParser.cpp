
// Generated from src/main/antlr/org/gustavolyra/PortugolPP.g4 by ANTLR 4.13.1


#include "PortugolPPListener.h"
#include "PortugolPPVisitor.h"

#include "PortugolPPParser.h"


using namespace antlrcpp;

using namespace antlr4;

namespace {

struct PortugolPPParserStaticData final {
  PortugolPPParserStaticData(std::vector<std::string> ruleNames,
                        std::vector<std::string> literalNames,
                        std::vector<std::string> symbolicNames)
      : ruleNames(std::move(ruleNames)), literalNames(std::move(literalNames)),
        symbolicNames(std::move(symbolicNames)),
        vocabulary(this->literalNames, this->symbolicNames) {}

  PortugolPPParserStaticData(const PortugolPPParserStaticData&) = delete;
  PortugolPPParserStaticData(PortugolPPParserStaticData&&) = delete;
  PortugolPPParserStaticData& operator=(const PortugolPPParserStaticData&) = delete;
  PortugolPPParserStaticData& operator=(PortugolPPParserStaticData&&) = delete;

  std::vector<antlr4::dfa::DFA> decisionToDFA;
  antlr4::atn::PredictionContextCache sharedContextCache;
  const std::vector<std::string> ruleNames;
  const std::vector<std::string> literalNames;
  const std::vector<std::string> symbolicNames;
  const antlr4::dfa::Vocabulary vocabulary;
  antlr4::atn::SerializedATNView serializedATN;
  std::unique_ptr<antlr4::atn::ATN> atn;
};

::antlr4::internal::OnceFlag portugolppParserOnceFlag;
#if ANTLR4_USE_THREAD_LOCAL_CACHE
static thread_local
#endif
PortugolPPParserStaticData *portugolppParserStaticData = nullptr;

void portugolppParserInitialize() {
#if ANTLR4_USE_THREAD_LOCAL_CACHE
  if (portugolppParserStaticData != nullptr) {
    return;
  }
#else
  assert(portugolppParserStaticData == nullptr);
#endif
  auto staticData = std::make_unique<PortugolPPParserStaticData>(
    std::vector<std::string>{
      "programa", "importarDeclaracao", "declaracao", "assinaturaMetodo", 
      "declaracaoInterface", "declaracaoQuebra", "declaracaoContinue", "declaracaoFacaEnquanto", 
      "declaracaoPara", "declaracaoEnquanto", "declaracaoSe", "declaracaoReturn", 
      "declaracaoClasse", "declaracaoVar", "declaracaoFuncao", "listaParams", 
      "param", "tipo", "bloco", "expressao", "atribuicao", "acesso", "acessoArray", 
      "logicaOu", "logicaE", "igualdade", "comparacao", "adicao", "multiplicacao", 
      "unario", "chamada", "chamadaFuncao", "argumentos", "primario", "listaLiteral", 
      "mapaLiteral"
    },
    std::vector<std::string>{
      "", "'importar'", "';'", "'funcao'", "'('", "')'", "':'", "'interface'", 
      "'{'", "'}'", "'quebra'", "'continue'", "'faca'", "'enquanto'", "'para'", 
      "'se'", "'senao'", "'return'", "'classe'", "'estende'", "'implementa'", 
      "','", "'var'", "'='", "'Inteiro'", "'Real'", "'Texto'", "'Logico'", 
      "'Lista'", "'Mapa'", "'.'", "'['", "']'", "'ou'", "'e'", "'=='", "'!='", 
      "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", 
      "'verdadeiro'", "'falso'", "'this'", "'nova'", "'[['"
    },
    std::vector<std::string>{
      "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
      "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
      "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
      "", "ID", "NUMERO", "TEXTO_LITERAL", "ESPACO", "COMENTARIO", "COMENTARIO_BLOCO"
    }
  );
  static const int32_t serializedATNSegment[] = {
  	4,1,57,421,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,5,2,6,7,6,2,
  	7,7,7,2,8,7,8,2,9,7,9,2,10,7,10,2,11,7,11,2,12,7,12,2,13,7,13,2,14,7,
  	14,2,15,7,15,2,16,7,16,2,17,7,17,2,18,7,18,2,19,7,19,2,20,7,20,2,21,7,
  	21,2,22,7,22,2,23,7,23,2,24,7,24,2,25,7,25,2,26,7,26,2,27,7,27,2,28,7,
  	28,2,29,7,29,2,30,7,30,2,31,7,31,2,32,7,32,2,33,7,33,2,34,7,34,2,35,7,
  	35,1,0,5,0,74,8,0,10,0,12,0,77,9,0,1,0,5,0,80,8,0,10,0,12,0,83,9,0,1,
  	0,1,0,1,1,1,1,1,1,1,1,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,
  	1,2,1,2,1,2,1,2,1,2,1,2,3,2,109,8,2,1,3,1,3,1,3,1,3,3,3,115,8,3,1,3,1,
  	3,1,3,3,3,120,8,3,1,3,1,3,1,4,1,4,1,4,1,4,5,4,128,8,4,10,4,12,4,131,9,
  	4,1,4,1,4,1,5,1,5,1,5,1,6,1,6,1,6,1,7,1,7,1,7,1,7,1,7,1,7,1,7,1,7,1,8,
  	1,8,1,8,1,8,1,8,1,8,3,8,155,8,8,1,8,1,8,1,8,1,8,1,8,1,8,1,9,1,9,1,9,1,
  	9,1,9,1,9,1,10,1,10,1,10,1,10,1,10,1,10,1,10,3,10,176,8,10,1,11,1,11,
  	3,11,180,8,11,1,11,1,11,1,12,1,12,1,12,1,12,3,12,188,8,12,1,12,1,12,1,
  	12,1,12,5,12,194,8,12,10,12,12,12,197,9,12,3,12,199,8,12,1,12,1,12,1,
  	12,5,12,204,8,12,10,12,12,12,207,9,12,1,12,1,12,1,13,1,13,1,13,1,13,3,
  	13,215,8,13,1,13,1,13,3,13,219,8,13,1,13,1,13,1,14,1,14,1,14,1,14,3,14,
  	227,8,14,1,14,1,14,1,14,3,14,232,8,14,1,14,1,14,1,15,1,15,1,15,5,15,239,
  	8,15,10,15,12,15,242,9,15,1,16,1,16,1,16,1,16,1,17,1,17,1,18,1,18,5,18,
  	252,8,18,10,18,12,18,255,9,18,1,18,1,18,1,19,1,19,1,20,1,20,1,20,3,20,
  	264,8,20,1,20,1,20,1,20,3,20,269,8,20,1,21,1,21,1,21,1,21,1,22,1,22,1,
  	22,1,22,1,22,1,22,1,22,1,22,1,22,1,22,1,22,1,22,1,22,3,22,288,8,22,1,
  	23,1,23,1,23,5,23,293,8,23,10,23,12,23,296,9,23,1,24,1,24,1,24,5,24,301,
  	8,24,10,24,12,24,304,9,24,1,25,1,25,1,25,5,25,309,8,25,10,25,12,25,312,
  	9,25,1,26,1,26,1,26,5,26,317,8,26,10,26,12,26,320,9,26,1,27,1,27,1,27,
  	5,27,325,8,27,10,27,12,27,328,9,27,1,28,1,28,1,28,5,28,333,8,28,10,28,
  	12,28,336,9,28,1,29,1,29,1,29,3,29,341,8,29,1,30,1,30,1,30,1,30,1,30,
  	3,30,348,8,30,1,30,3,30,351,8,30,5,30,353,8,30,10,30,12,30,356,9,30,1,
  	30,3,30,359,8,30,1,31,1,31,1,31,3,31,364,8,31,1,31,1,31,1,31,1,31,1,31,
  	1,31,3,31,372,8,31,1,31,1,31,3,31,376,8,31,1,32,1,32,1,32,5,32,381,8,
  	32,10,32,12,32,384,9,32,1,33,1,33,1,33,1,33,1,33,1,33,1,33,3,33,393,8,
  	33,1,33,3,33,396,8,33,1,33,1,33,1,33,1,33,1,33,1,33,1,33,1,33,1,33,3,
  	33,407,8,33,1,33,1,33,1,33,3,33,412,8,33,1,34,1,34,1,34,1,35,1,35,1,35,
  	1,35,1,35,0,0,36,0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,
  	38,40,42,44,46,48,50,52,54,56,58,60,62,64,66,68,70,0,6,2,0,24,29,52,52,
  	1,0,35,36,1,0,37,40,1,0,41,42,1,0,43,45,2,0,42,42,46,46,447,0,75,1,0,
  	0,0,2,86,1,0,0,0,4,108,1,0,0,0,6,110,1,0,0,0,8,123,1,0,0,0,10,134,1,0,
  	0,0,12,137,1,0,0,0,14,140,1,0,0,0,16,148,1,0,0,0,18,162,1,0,0,0,20,168,
  	1,0,0,0,22,177,1,0,0,0,24,183,1,0,0,0,26,210,1,0,0,0,28,222,1,0,0,0,30,
  	235,1,0,0,0,32,243,1,0,0,0,34,247,1,0,0,0,36,249,1,0,0,0,38,258,1,0,0,
  	0,40,268,1,0,0,0,42,270,1,0,0,0,44,287,1,0,0,0,46,289,1,0,0,0,48,297,
  	1,0,0,0,50,305,1,0,0,0,52,313,1,0,0,0,54,321,1,0,0,0,56,329,1,0,0,0,58,
  	340,1,0,0,0,60,358,1,0,0,0,62,375,1,0,0,0,64,377,1,0,0,0,66,411,1,0,0,
  	0,68,413,1,0,0,0,70,416,1,0,0,0,72,74,3,2,1,0,73,72,1,0,0,0,74,77,1,0,
  	0,0,75,73,1,0,0,0,75,76,1,0,0,0,76,81,1,0,0,0,77,75,1,0,0,0,78,80,3,4,
  	2,0,79,78,1,0,0,0,80,83,1,0,0,0,81,79,1,0,0,0,81,82,1,0,0,0,82,84,1,0,
  	0,0,83,81,1,0,0,0,84,85,5,0,0,1,85,1,1,0,0,0,86,87,5,1,0,0,87,88,5,54,
  	0,0,88,89,5,2,0,0,89,3,1,0,0,0,90,109,3,24,12,0,91,109,3,26,13,0,92,109,
  	3,28,14,0,93,109,3,20,10,0,94,95,3,62,31,0,95,96,5,2,0,0,96,109,1,0,0,
  	0,97,109,3,36,18,0,98,99,3,38,19,0,99,100,5,2,0,0,100,109,1,0,0,0,101,
  	109,3,22,11,0,102,109,3,18,9,0,103,109,3,16,8,0,104,109,3,14,7,0,105,
  	109,3,10,5,0,106,109,3,12,6,0,107,109,3,8,4,0,108,90,1,0,0,0,108,91,1,
  	0,0,0,108,92,1,0,0,0,108,93,1,0,0,0,108,94,1,0,0,0,108,97,1,0,0,0,108,
  	98,1,0,0,0,108,101,1,0,0,0,108,102,1,0,0,0,108,103,1,0,0,0,108,104,1,
  	0,0,0,108,105,1,0,0,0,108,106,1,0,0,0,108,107,1,0,0,0,109,5,1,0,0,0,110,
  	111,5,3,0,0,111,112,5,52,0,0,112,114,5,4,0,0,113,115,3,30,15,0,114,113,
  	1,0,0,0,114,115,1,0,0,0,115,116,1,0,0,0,116,119,5,5,0,0,117,118,5,6,0,
  	0,118,120,3,34,17,0,119,117,1,0,0,0,119,120,1,0,0,0,120,121,1,0,0,0,121,
  	122,5,2,0,0,122,7,1,0,0,0,123,124,5,7,0,0,124,125,5,52,0,0,125,129,5,
  	8,0,0,126,128,3,6,3,0,127,126,1,0,0,0,128,131,1,0,0,0,129,127,1,0,0,0,
  	129,130,1,0,0,0,130,132,1,0,0,0,131,129,1,0,0,0,132,133,5,9,0,0,133,9,
  	1,0,0,0,134,135,5,10,0,0,135,136,5,2,0,0,136,11,1,0,0,0,137,138,5,11,
  	0,0,138,139,5,2,0,0,139,13,1,0,0,0,140,141,5,12,0,0,141,142,3,4,2,0,142,
  	143,5,13,0,0,143,144,5,4,0,0,144,145,3,38,19,0,145,146,5,5,0,0,146,147,
  	5,2,0,0,147,15,1,0,0,0,148,149,5,14,0,0,149,154,5,4,0,0,150,155,3,26,
  	13,0,151,152,3,38,19,0,152,153,5,2,0,0,153,155,1,0,0,0,154,150,1,0,0,
  	0,154,151,1,0,0,0,155,156,1,0,0,0,156,157,3,38,19,0,157,158,5,2,0,0,158,
  	159,3,38,19,0,159,160,5,5,0,0,160,161,3,4,2,0,161,17,1,0,0,0,162,163,
  	5,13,0,0,163,164,5,4,0,0,164,165,3,38,19,0,165,166,5,5,0,0,166,167,3,
  	4,2,0,167,19,1,0,0,0,168,169,5,15,0,0,169,170,5,4,0,0,170,171,3,38,19,
  	0,171,172,5,5,0,0,172,175,3,4,2,0,173,174,5,16,0,0,174,176,3,4,2,0,175,
  	173,1,0,0,0,175,176,1,0,0,0,176,21,1,0,0,0,177,179,5,17,0,0,178,180,3,
  	38,19,0,179,178,1,0,0,0,179,180,1,0,0,0,180,181,1,0,0,0,181,182,5,2,0,
  	0,182,23,1,0,0,0,183,184,5,18,0,0,184,187,5,52,0,0,185,186,5,19,0,0,186,
  	188,5,52,0,0,187,185,1,0,0,0,187,188,1,0,0,0,188,198,1,0,0,0,189,190,
  	5,20,0,0,190,195,5,52,0,0,191,192,5,21,0,0,192,194,5,52,0,0,193,191,1,
  	0,0,0,194,197,1,0,0,0,195,193,1,0,0,0,195,196,1,0,0,0,196,199,1,0,0,0,
  	197,195,1,0,0,0,198,189,1,0,0,0,198,199,1,0,0,0,199,200,1,0,0,0,200,205,
  	5,8,0,0,201,204,3,26,13,0,202,204,3,28,14,0,203,201,1,0,0,0,203,202,1,
  	0,0,0,204,207,1,0,0,0,205,203,1,0,0,0,205,206,1,0,0,0,206,208,1,0,0,0,
  	207,205,1,0,0,0,208,209,5,9,0,0,209,25,1,0,0,0,210,211,5,22,0,0,211,214,
  	5,52,0,0,212,213,5,6,0,0,213,215,3,34,17,0,214,212,1,0,0,0,214,215,1,
  	0,0,0,215,218,1,0,0,0,216,217,5,23,0,0,217,219,3,38,19,0,218,216,1,0,
  	0,0,218,219,1,0,0,0,219,220,1,0,0,0,220,221,5,2,0,0,221,27,1,0,0,0,222,
  	223,5,3,0,0,223,224,5,52,0,0,224,226,5,4,0,0,225,227,3,30,15,0,226,225,
  	1,0,0,0,226,227,1,0,0,0,227,228,1,0,0,0,228,231,5,5,0,0,229,230,5,6,0,
  	0,230,232,3,34,17,0,231,229,1,0,0,0,231,232,1,0,0,0,232,233,1,0,0,0,233,
  	234,3,36,18,0,234,29,1,0,0,0,235,240,3,32,16,0,236,237,5,21,0,0,237,239,
  	3,32,16,0,238,236,1,0,0,0,239,242,1,0,0,0,240,238,1,0,0,0,240,241,1,0,
  	0,0,241,31,1,0,0,0,242,240,1,0,0,0,243,244,5,52,0,0,244,245,5,6,0,0,245,
  	246,3,34,17,0,246,33,1,0,0,0,247,248,7,0,0,0,248,35,1,0,0,0,249,253,5,
  	8,0,0,250,252,3,4,2,0,251,250,1,0,0,0,252,255,1,0,0,0,253,251,1,0,0,0,
  	253,254,1,0,0,0,254,256,1,0,0,0,255,253,1,0,0,0,256,257,5,9,0,0,257,37,
  	1,0,0,0,258,259,3,40,20,0,259,39,1,0,0,0,260,264,5,52,0,0,261,264,3,42,
  	21,0,262,264,3,44,22,0,263,260,1,0,0,0,263,261,1,0,0,0,263,262,1,0,0,
  	0,264,265,1,0,0,0,265,266,5,23,0,0,266,269,3,38,19,0,267,269,3,46,23,
  	0,268,263,1,0,0,0,268,267,1,0,0,0,269,41,1,0,0,0,270,271,3,66,33,0,271,
  	272,5,30,0,0,272,273,5,52,0,0,273,43,1,0,0,0,274,275,3,66,33,0,275,276,
  	5,31,0,0,276,277,3,38,19,0,277,278,5,32,0,0,278,288,1,0,0,0,279,280,3,
  	66,33,0,280,281,5,31,0,0,281,282,3,38,19,0,282,283,5,32,0,0,283,284,5,
  	31,0,0,284,285,3,38,19,0,285,286,5,32,0,0,286,288,1,0,0,0,287,274,1,0,
  	0,0,287,279,1,0,0,0,288,45,1,0,0,0,289,294,3,48,24,0,290,291,5,33,0,0,
  	291,293,3,48,24,0,292,290,1,0,0,0,293,296,1,0,0,0,294,292,1,0,0,0,294,
  	295,1,0,0,0,295,47,1,0,0,0,296,294,1,0,0,0,297,302,3,50,25,0,298,299,
  	5,34,0,0,299,301,3,50,25,0,300,298,1,0,0,0,301,304,1,0,0,0,302,300,1,
  	0,0,0,302,303,1,0,0,0,303,49,1,0,0,0,304,302,1,0,0,0,305,310,3,52,26,
  	0,306,307,7,1,0,0,307,309,3,52,26,0,308,306,1,0,0,0,309,312,1,0,0,0,310,
  	308,1,0,0,0,310,311,1,0,0,0,311,51,1,0,0,0,312,310,1,0,0,0,313,318,3,
  	54,27,0,314,315,7,2,0,0,315,317,3,54,27,0,316,314,1,0,0,0,317,320,1,0,
  	0,0,318,316,1,0,0,0,318,319,1,0,0,0,319,53,1,0,0,0,320,318,1,0,0,0,321,
  	326,3,56,28,0,322,323,7,3,0,0,323,325,3,56,28,0,324,322,1,0,0,0,325,328,
  	1,0,0,0,326,324,1,0,0,0,326,327,1,0,0,0,327,55,1,0,0,0,328,326,1,0,0,
  	0,329,334,3,58,29,0,330,331,7,4,0,0,331,333,3,58,29,0,332,330,1,0,0,0,
  	333,336,1,0,0,0,334,332,1,0,0,0,334,335,1,0,0,0,335,57,1,0,0,0,336,334,
  	1,0,0,0,337,338,7,5,0,0,338,341,3,58,29,0,339,341,3,60,30,0,340,337,1,
  	0,0,0,340,339,1,0,0,0,341,59,1,0,0,0,342,354,3,66,33,0,343,344,5,30,0,
  	0,344,350,5,52,0,0,345,347,5,4,0,0,346,348,3,64,32,0,347,346,1,0,0,0,
  	347,348,1,0,0,0,348,349,1,0,0,0,349,351,5,5,0,0,350,345,1,0,0,0,350,351,
  	1,0,0,0,351,353,1,0,0,0,352,343,1,0,0,0,353,356,1,0,0,0,354,352,1,0,0,
  	0,354,355,1,0,0,0,355,359,1,0,0,0,356,354,1,0,0,0,357,359,3,44,22,0,358,
  	342,1,0,0,0,358,357,1,0,0,0,359,61,1,0,0,0,360,361,5,52,0,0,361,363,5,
  	4,0,0,362,364,3,64,32,0,363,362,1,0,0,0,363,364,1,0,0,0,364,365,1,0,0,
  	0,365,376,5,5,0,0,366,367,3,66,33,0,367,368,5,30,0,0,368,369,5,52,0,0,
  	369,371,5,4,0,0,370,372,3,64,32,0,371,370,1,0,0,0,371,372,1,0,0,0,372,
  	373,1,0,0,0,373,374,5,5,0,0,374,376,1,0,0,0,375,360,1,0,0,0,375,366,1,
  	0,0,0,376,63,1,0,0,0,377,382,3,38,19,0,378,379,5,21,0,0,379,381,3,38,
  	19,0,380,378,1,0,0,0,381,384,1,0,0,0,382,380,1,0,0,0,382,383,1,0,0,0,
  	383,65,1,0,0,0,384,382,1,0,0,0,385,412,5,47,0,0,386,412,5,48,0,0,387,
  	412,5,53,0,0,388,412,5,54,0,0,389,395,5,52,0,0,390,392,5,4,0,0,391,393,
  	3,64,32,0,392,391,1,0,0,0,392,393,1,0,0,0,393,394,1,0,0,0,394,396,5,5,
  	0,0,395,390,1,0,0,0,395,396,1,0,0,0,396,412,1,0,0,0,397,412,5,49,0,0,
  	398,399,5,4,0,0,399,400,3,38,19,0,400,401,5,5,0,0,401,412,1,0,0,0,402,
  	403,5,50,0,0,403,404,5,52,0,0,404,406,5,4,0,0,405,407,3,64,32,0,406,405,
  	1,0,0,0,406,407,1,0,0,0,407,408,1,0,0,0,408,412,5,5,0,0,409,412,3,68,
  	34,0,410,412,3,70,35,0,411,385,1,0,0,0,411,386,1,0,0,0,411,387,1,0,0,
  	0,411,388,1,0,0,0,411,389,1,0,0,0,411,397,1,0,0,0,411,398,1,0,0,0,411,
  	402,1,0,0,0,411,409,1,0,0,0,411,410,1,0,0,0,412,67,1,0,0,0,413,414,5,
  	31,0,0,414,415,5,32,0,0,415,69,1,0,0,0,416,417,5,51,0,0,417,418,5,32,
  	0,0,418,419,5,32,0,0,419,71,1,0,0,0,42,75,81,108,114,119,129,154,175,
  	179,187,195,198,203,205,214,218,226,231,240,253,263,268,287,294,302,310,
  	318,326,334,340,347,350,354,358,363,371,375,382,392,395,406,411
  };
  staticData->serializedATN = antlr4::atn::SerializedATNView(serializedATNSegment, sizeof(serializedATNSegment) / sizeof(serializedATNSegment[0]));

  antlr4::atn::ATNDeserializer deserializer;
  staticData->atn = deserializer.deserialize(staticData->serializedATN);

  const size_t count = staticData->atn->getNumberOfDecisions();
  staticData->decisionToDFA.reserve(count);
  for (size_t i = 0; i < count; i++) { 
    staticData->decisionToDFA.emplace_back(staticData->atn->getDecisionState(i), i);
  }
  portugolppParserStaticData = staticData.release();
}

}

PortugolPPParser::PortugolPPParser(TokenStream *input) : PortugolPPParser(input, antlr4::atn::ParserATNSimulatorOptions()) {}

PortugolPPParser::PortugolPPParser(TokenStream *input, const antlr4::atn::ParserATNSimulatorOptions &options) : Parser(input) {
  PortugolPPParser::initialize();
  _interpreter = new atn::ParserATNSimulator(this, *portugolppParserStaticData->atn, portugolppParserStaticData->decisionToDFA, portugolppParserStaticData->sharedContextCache, options);
}

PortugolPPParser::~PortugolPPParser() {
  delete _interpreter;
}

const atn::ATN& PortugolPPParser::getATN() const {
  return *portugolppParserStaticData->atn;
}

std::string PortugolPPParser::getGrammarFileName() const {
  return "PortugolPP.g4";
}

const std::vector<std::string>& PortugolPPParser::getRuleNames() const {
  return portugolppParserStaticData->ruleNames;
}

const dfa::Vocabulary& PortugolPPParser::getVocabulary() const {
  return portugolppParserStaticData->vocabulary;
}

antlr4::atn::SerializedATNView PortugolPPParser::getSerializedATN() const {
  return portugolppParserStaticData->serializedATN;
}


//----------------- ProgramaContext ------------------------------------------------------------------

PortugolPPParser::ProgramaContext::ProgramaContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* PortugolPPParser::ProgramaContext::EOF() {
  return getToken(PortugolPPParser::EOF, 0);
}

std::vector<PortugolPPParser::ImportarDeclaracaoContext *> PortugolPPParser::ProgramaContext::importarDeclaracao() {
  return getRuleContexts<PortugolPPParser::ImportarDeclaracaoContext>();
}

PortugolPPParser::ImportarDeclaracaoContext* PortugolPPParser::ProgramaContext::importarDeclaracao(size_t i) {
  return getRuleContext<PortugolPPParser::ImportarDeclaracaoContext>(i);
}

std::vector<PortugolPPParser::DeclaracaoContext *> PortugolPPParser::ProgramaContext::declaracao() {
  return getRuleContexts<PortugolPPParser::DeclaracaoContext>();
}

PortugolPPParser::DeclaracaoContext* PortugolPPParser::ProgramaContext::declaracao(size_t i) {
  return getRuleContext<PortugolPPParser::DeclaracaoContext>(i);
}


size_t PortugolPPParser::ProgramaContext::getRuleIndex() const {
  return PortugolPPParser::RulePrograma;
}

void PortugolPPParser::ProgramaContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterPrograma(this);
}

void PortugolPPParser::ProgramaContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitPrograma(this);
}


std::any PortugolPPParser::ProgramaContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitPrograma(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::ProgramaContext* PortugolPPParser::programa() {
  ProgramaContext *_localctx = _tracker.createInstance<ProgramaContext>(_ctx, getState());
  enterRule(_localctx, 0, PortugolPPParser::RulePrograma);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(75);
    _errHandler->sync(this);
    _la = _input->LA(1);
    while (_la == PortugolPPParser::T__0) {
      setState(72);
      importarDeclaracao();
      setState(77);
      _errHandler->sync(this);
      _la = _input->LA(1);
    }
    setState(81);
    _errHandler->sync(this);
    _la = _input->LA(1);
    while ((((_la & ~ 0x3fULL) == 0) &&
      ((1ULL << _la) & 35962828473433496) != 0)) {
      setState(78);
      declaracao();
      setState(83);
      _errHandler->sync(this);
      _la = _input->LA(1);
    }
    setState(84);
    match(PortugolPPParser::EOF);
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- ImportarDeclaracaoContext ------------------------------------------------------------------

PortugolPPParser::ImportarDeclaracaoContext::ImportarDeclaracaoContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* PortugolPPParser::ImportarDeclaracaoContext::TEXTO_LITERAL() {
  return getToken(PortugolPPParser::TEXTO_LITERAL, 0);
}


size_t PortugolPPParser::ImportarDeclaracaoContext::getRuleIndex() const {
  return PortugolPPParser::RuleImportarDeclaracao;
}

void PortugolPPParser::ImportarDeclaracaoContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterImportarDeclaracao(this);
}

void PortugolPPParser::ImportarDeclaracaoContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitImportarDeclaracao(this);
}


std::any PortugolPPParser::ImportarDeclaracaoContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitImportarDeclaracao(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::ImportarDeclaracaoContext* PortugolPPParser::importarDeclaracao() {
  ImportarDeclaracaoContext *_localctx = _tracker.createInstance<ImportarDeclaracaoContext>(_ctx, getState());
  enterRule(_localctx, 2, PortugolPPParser::RuleImportarDeclaracao);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(86);
    match(PortugolPPParser::T__0);
    setState(87);
    match(PortugolPPParser::TEXTO_LITERAL);
    setState(88);
    match(PortugolPPParser::T__1);
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- DeclaracaoContext ------------------------------------------------------------------

PortugolPPParser::DeclaracaoContext::DeclaracaoContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

PortugolPPParser::DeclaracaoClasseContext* PortugolPPParser::DeclaracaoContext::declaracaoClasse() {
  return getRuleContext<PortugolPPParser::DeclaracaoClasseContext>(0);
}

PortugolPPParser::DeclaracaoVarContext* PortugolPPParser::DeclaracaoContext::declaracaoVar() {
  return getRuleContext<PortugolPPParser::DeclaracaoVarContext>(0);
}

PortugolPPParser::DeclaracaoFuncaoContext* PortugolPPParser::DeclaracaoContext::declaracaoFuncao() {
  return getRuleContext<PortugolPPParser::DeclaracaoFuncaoContext>(0);
}

PortugolPPParser::DeclaracaoSeContext* PortugolPPParser::DeclaracaoContext::declaracaoSe() {
  return getRuleContext<PortugolPPParser::DeclaracaoSeContext>(0);
}

PortugolPPParser::ChamadaFuncaoContext* PortugolPPParser::DeclaracaoContext::chamadaFuncao() {
  return getRuleContext<PortugolPPParser::ChamadaFuncaoContext>(0);
}

PortugolPPParser::BlocoContext* PortugolPPParser::DeclaracaoContext::bloco() {
  return getRuleContext<PortugolPPParser::BlocoContext>(0);
}

PortugolPPParser::ExpressaoContext* PortugolPPParser::DeclaracaoContext::expressao() {
  return getRuleContext<PortugolPPParser::ExpressaoContext>(0);
}

PortugolPPParser::DeclaracaoReturnContext* PortugolPPParser::DeclaracaoContext::declaracaoReturn() {
  return getRuleContext<PortugolPPParser::DeclaracaoReturnContext>(0);
}

PortugolPPParser::DeclaracaoEnquantoContext* PortugolPPParser::DeclaracaoContext::declaracaoEnquanto() {
  return getRuleContext<PortugolPPParser::DeclaracaoEnquantoContext>(0);
}

PortugolPPParser::DeclaracaoParaContext* PortugolPPParser::DeclaracaoContext::declaracaoPara() {
  return getRuleContext<PortugolPPParser::DeclaracaoParaContext>(0);
}

PortugolPPParser::DeclaracaoFacaEnquantoContext* PortugolPPParser::DeclaracaoContext::declaracaoFacaEnquanto() {
  return getRuleContext<PortugolPPParser::DeclaracaoFacaEnquantoContext>(0);
}

PortugolPPParser::DeclaracaoQuebraContext* PortugolPPParser::DeclaracaoContext::declaracaoQuebra() {
  return getRuleContext<PortugolPPParser::DeclaracaoQuebraContext>(0);
}

PortugolPPParser::DeclaracaoContinueContext* PortugolPPParser::DeclaracaoContext::declaracaoContinue() {
  return getRuleContext<PortugolPPParser::DeclaracaoContinueContext>(0);
}

PortugolPPParser::DeclaracaoInterfaceContext* PortugolPPParser::DeclaracaoContext::declaracaoInterface() {
  return getRuleContext<PortugolPPParser::DeclaracaoInterfaceContext>(0);
}


size_t PortugolPPParser::DeclaracaoContext::getRuleIndex() const {
  return PortugolPPParser::RuleDeclaracao;
}

void PortugolPPParser::DeclaracaoContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterDeclaracao(this);
}

void PortugolPPParser::DeclaracaoContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitDeclaracao(this);
}


std::any PortugolPPParser::DeclaracaoContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitDeclaracao(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::DeclaracaoContext* PortugolPPParser::declaracao() {
  DeclaracaoContext *_localctx = _tracker.createInstance<DeclaracaoContext>(_ctx, getState());
  enterRule(_localctx, 4, PortugolPPParser::RuleDeclaracao);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(108);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 2, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(90);
      declaracaoClasse();
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(91);
      declaracaoVar();
      break;
    }

    case 3: {
      enterOuterAlt(_localctx, 3);
      setState(92);
      declaracaoFuncao();
      break;
    }

    case 4: {
      enterOuterAlt(_localctx, 4);
      setState(93);
      declaracaoSe();
      break;
    }

    case 5: {
      enterOuterAlt(_localctx, 5);
      setState(94);
      chamadaFuncao();
      setState(95);
      match(PortugolPPParser::T__1);
      break;
    }

    case 6: {
      enterOuterAlt(_localctx, 6);
      setState(97);
      bloco();
      break;
    }

    case 7: {
      enterOuterAlt(_localctx, 7);
      setState(98);
      expressao();
      setState(99);
      match(PortugolPPParser::T__1);
      break;
    }

    case 8: {
      enterOuterAlt(_localctx, 8);
      setState(101);
      declaracaoReturn();
      break;
    }

    case 9: {
      enterOuterAlt(_localctx, 9);
      setState(102);
      declaracaoEnquanto();
      break;
    }

    case 10: {
      enterOuterAlt(_localctx, 10);
      setState(103);
      declaracaoPara();
      break;
    }

    case 11: {
      enterOuterAlt(_localctx, 11);
      setState(104);
      declaracaoFacaEnquanto();
      break;
    }

    case 12: {
      enterOuterAlt(_localctx, 12);
      setState(105);
      declaracaoQuebra();
      break;
    }

    case 13: {
      enterOuterAlt(_localctx, 13);
      setState(106);
      declaracaoContinue();
      break;
    }

    case 14: {
      enterOuterAlt(_localctx, 14);
      setState(107);
      declaracaoInterface();
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- AssinaturaMetodoContext ------------------------------------------------------------------

PortugolPPParser::AssinaturaMetodoContext::AssinaturaMetodoContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* PortugolPPParser::AssinaturaMetodoContext::ID() {
  return getToken(PortugolPPParser::ID, 0);
}

PortugolPPParser::ListaParamsContext* PortugolPPParser::AssinaturaMetodoContext::listaParams() {
  return getRuleContext<PortugolPPParser::ListaParamsContext>(0);
}

PortugolPPParser::TipoContext* PortugolPPParser::AssinaturaMetodoContext::tipo() {
  return getRuleContext<PortugolPPParser::TipoContext>(0);
}


size_t PortugolPPParser::AssinaturaMetodoContext::getRuleIndex() const {
  return PortugolPPParser::RuleAssinaturaMetodo;
}

void PortugolPPParser::AssinaturaMetodoContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterAssinaturaMetodo(this);
}

void PortugolPPParser::AssinaturaMetodoContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitAssinaturaMetodo(this);
}


std::any PortugolPPParser::AssinaturaMetodoContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitAssinaturaMetodo(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::AssinaturaMetodoContext* PortugolPPParser::assinaturaMetodo() {
  AssinaturaMetodoContext *_localctx = _tracker.createInstance<AssinaturaMetodoContext>(_ctx, getState());
  enterRule(_localctx, 6, PortugolPPParser::RuleAssinaturaMetodo);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(110);
    match(PortugolPPParser::T__2);
    setState(111);
    match(PortugolPPParser::ID);
    setState(112);
    match(PortugolPPParser::T__3);
    setState(114);
    _errHandler->sync(this);

    _la = _input->LA(1);
    if (_la == PortugolPPParser::ID) {
      setState(113);
      listaParams();
    }
    setState(116);
    match(PortugolPPParser::T__4);
    setState(119);
    _errHandler->sync(this);

    _la = _input->LA(1);
    if (_la == PortugolPPParser::T__5) {
      setState(117);
      match(PortugolPPParser::T__5);
      setState(118);
      tipo();
    }
    setState(121);
    match(PortugolPPParser::T__1);
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- DeclaracaoInterfaceContext ------------------------------------------------------------------

PortugolPPParser::DeclaracaoInterfaceContext::DeclaracaoInterfaceContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* PortugolPPParser::DeclaracaoInterfaceContext::ID() {
  return getToken(PortugolPPParser::ID, 0);
}

std::vector<PortugolPPParser::AssinaturaMetodoContext *> PortugolPPParser::DeclaracaoInterfaceContext::assinaturaMetodo() {
  return getRuleContexts<PortugolPPParser::AssinaturaMetodoContext>();
}

PortugolPPParser::AssinaturaMetodoContext* PortugolPPParser::DeclaracaoInterfaceContext::assinaturaMetodo(size_t i) {
  return getRuleContext<PortugolPPParser::AssinaturaMetodoContext>(i);
}


size_t PortugolPPParser::DeclaracaoInterfaceContext::getRuleIndex() const {
  return PortugolPPParser::RuleDeclaracaoInterface;
}

void PortugolPPParser::DeclaracaoInterfaceContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterDeclaracaoInterface(this);
}

void PortugolPPParser::DeclaracaoInterfaceContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitDeclaracaoInterface(this);
}


std::any PortugolPPParser::DeclaracaoInterfaceContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitDeclaracaoInterface(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::DeclaracaoInterfaceContext* PortugolPPParser::declaracaoInterface() {
  DeclaracaoInterfaceContext *_localctx = _tracker.createInstance<DeclaracaoInterfaceContext>(_ctx, getState());
  enterRule(_localctx, 8, PortugolPPParser::RuleDeclaracaoInterface);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(123);
    match(PortugolPPParser::T__6);
    setState(124);
    match(PortugolPPParser::ID);
    setState(125);
    match(PortugolPPParser::T__7);
    setState(129);
    _errHandler->sync(this);
    _la = _input->LA(1);
    while (_la == PortugolPPParser::T__2) {
      setState(126);
      assinaturaMetodo();
      setState(131);
      _errHandler->sync(this);
      _la = _input->LA(1);
    }
    setState(132);
    match(PortugolPPParser::T__8);
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- DeclaracaoQuebraContext ------------------------------------------------------------------

PortugolPPParser::DeclaracaoQuebraContext::DeclaracaoQuebraContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}


size_t PortugolPPParser::DeclaracaoQuebraContext::getRuleIndex() const {
  return PortugolPPParser::RuleDeclaracaoQuebra;
}

void PortugolPPParser::DeclaracaoQuebraContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterDeclaracaoQuebra(this);
}

void PortugolPPParser::DeclaracaoQuebraContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitDeclaracaoQuebra(this);
}


std::any PortugolPPParser::DeclaracaoQuebraContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitDeclaracaoQuebra(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::DeclaracaoQuebraContext* PortugolPPParser::declaracaoQuebra() {
  DeclaracaoQuebraContext *_localctx = _tracker.createInstance<DeclaracaoQuebraContext>(_ctx, getState());
  enterRule(_localctx, 10, PortugolPPParser::RuleDeclaracaoQuebra);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(134);
    match(PortugolPPParser::T__9);
    setState(135);
    match(PortugolPPParser::T__1);
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- DeclaracaoContinueContext ------------------------------------------------------------------

PortugolPPParser::DeclaracaoContinueContext::DeclaracaoContinueContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}


size_t PortugolPPParser::DeclaracaoContinueContext::getRuleIndex() const {
  return PortugolPPParser::RuleDeclaracaoContinue;
}

void PortugolPPParser::DeclaracaoContinueContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterDeclaracaoContinue(this);
}

void PortugolPPParser::DeclaracaoContinueContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitDeclaracaoContinue(this);
}


std::any PortugolPPParser::DeclaracaoContinueContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitDeclaracaoContinue(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::DeclaracaoContinueContext* PortugolPPParser::declaracaoContinue() {
  DeclaracaoContinueContext *_localctx = _tracker.createInstance<DeclaracaoContinueContext>(_ctx, getState());
  enterRule(_localctx, 12, PortugolPPParser::RuleDeclaracaoContinue);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(137);
    match(PortugolPPParser::T__10);
    setState(138);
    match(PortugolPPParser::T__1);
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- DeclaracaoFacaEnquantoContext ------------------------------------------------------------------

PortugolPPParser::DeclaracaoFacaEnquantoContext::DeclaracaoFacaEnquantoContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

PortugolPPParser::DeclaracaoContext* PortugolPPParser::DeclaracaoFacaEnquantoContext::declaracao() {
  return getRuleContext<PortugolPPParser::DeclaracaoContext>(0);
}

PortugolPPParser::ExpressaoContext* PortugolPPParser::DeclaracaoFacaEnquantoContext::expressao() {
  return getRuleContext<PortugolPPParser::ExpressaoContext>(0);
}


size_t PortugolPPParser::DeclaracaoFacaEnquantoContext::getRuleIndex() const {
  return PortugolPPParser::RuleDeclaracaoFacaEnquanto;
}

void PortugolPPParser::DeclaracaoFacaEnquantoContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterDeclaracaoFacaEnquanto(this);
}

void PortugolPPParser::DeclaracaoFacaEnquantoContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitDeclaracaoFacaEnquanto(this);
}


std::any PortugolPPParser::DeclaracaoFacaEnquantoContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitDeclaracaoFacaEnquanto(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::DeclaracaoFacaEnquantoContext* PortugolPPParser::declaracaoFacaEnquanto() {
  DeclaracaoFacaEnquantoContext *_localctx = _tracker.createInstance<DeclaracaoFacaEnquantoContext>(_ctx, getState());
  enterRule(_localctx, 14, PortugolPPParser::RuleDeclaracaoFacaEnquanto);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(140);
    match(PortugolPPParser::T__11);
    setState(141);
    declaracao();
    setState(142);
    match(PortugolPPParser::T__12);
    setState(143);
    match(PortugolPPParser::T__3);
    setState(144);
    expressao();
    setState(145);
    match(PortugolPPParser::T__4);
    setState(146);
    match(PortugolPPParser::T__1);
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- DeclaracaoParaContext ------------------------------------------------------------------

PortugolPPParser::DeclaracaoParaContext::DeclaracaoParaContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

std::vector<PortugolPPParser::ExpressaoContext *> PortugolPPParser::DeclaracaoParaContext::expressao() {
  return getRuleContexts<PortugolPPParser::ExpressaoContext>();
}

PortugolPPParser::ExpressaoContext* PortugolPPParser::DeclaracaoParaContext::expressao(size_t i) {
  return getRuleContext<PortugolPPParser::ExpressaoContext>(i);
}

PortugolPPParser::DeclaracaoContext* PortugolPPParser::DeclaracaoParaContext::declaracao() {
  return getRuleContext<PortugolPPParser::DeclaracaoContext>(0);
}

PortugolPPParser::DeclaracaoVarContext* PortugolPPParser::DeclaracaoParaContext::declaracaoVar() {
  return getRuleContext<PortugolPPParser::DeclaracaoVarContext>(0);
}


size_t PortugolPPParser::DeclaracaoParaContext::getRuleIndex() const {
  return PortugolPPParser::RuleDeclaracaoPara;
}

void PortugolPPParser::DeclaracaoParaContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterDeclaracaoPara(this);
}

void PortugolPPParser::DeclaracaoParaContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitDeclaracaoPara(this);
}


std::any PortugolPPParser::DeclaracaoParaContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitDeclaracaoPara(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::DeclaracaoParaContext* PortugolPPParser::declaracaoPara() {
  DeclaracaoParaContext *_localctx = _tracker.createInstance<DeclaracaoParaContext>(_ctx, getState());
  enterRule(_localctx, 16, PortugolPPParser::RuleDeclaracaoPara);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(148);
    match(PortugolPPParser::T__13);
    setState(149);
    match(PortugolPPParser::T__3);
    setState(154);
    _errHandler->sync(this);
    switch (_input->LA(1)) {
      case PortugolPPParser::T__21: {
        setState(150);
        declaracaoVar();
        break;
      }

      case PortugolPPParser::T__3:
      case PortugolPPParser::T__30:
      case PortugolPPParser::T__41:
      case PortugolPPParser::T__45:
      case PortugolPPParser::T__46:
      case PortugolPPParser::T__47:
      case PortugolPPParser::T__48:
      case PortugolPPParser::T__49:
      case PortugolPPParser::T__50:
      case PortugolPPParser::ID:
      case PortugolPPParser::NUMERO:
      case PortugolPPParser::TEXTO_LITERAL: {
        setState(151);
        expressao();
        setState(152);
        match(PortugolPPParser::T__1);
        break;
      }

    default:
      throw NoViableAltException(this);
    }
    setState(156);
    expressao();
    setState(157);
    match(PortugolPPParser::T__1);
    setState(158);
    expressao();
    setState(159);
    match(PortugolPPParser::T__4);
    setState(160);
    declaracao();
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- DeclaracaoEnquantoContext ------------------------------------------------------------------

PortugolPPParser::DeclaracaoEnquantoContext::DeclaracaoEnquantoContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

PortugolPPParser::ExpressaoContext* PortugolPPParser::DeclaracaoEnquantoContext::expressao() {
  return getRuleContext<PortugolPPParser::ExpressaoContext>(0);
}

PortugolPPParser::DeclaracaoContext* PortugolPPParser::DeclaracaoEnquantoContext::declaracao() {
  return getRuleContext<PortugolPPParser::DeclaracaoContext>(0);
}


size_t PortugolPPParser::DeclaracaoEnquantoContext::getRuleIndex() const {
  return PortugolPPParser::RuleDeclaracaoEnquanto;
}

void PortugolPPParser::DeclaracaoEnquantoContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterDeclaracaoEnquanto(this);
}

void PortugolPPParser::DeclaracaoEnquantoContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitDeclaracaoEnquanto(this);
}


std::any PortugolPPParser::DeclaracaoEnquantoContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitDeclaracaoEnquanto(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::DeclaracaoEnquantoContext* PortugolPPParser::declaracaoEnquanto() {
  DeclaracaoEnquantoContext *_localctx = _tracker.createInstance<DeclaracaoEnquantoContext>(_ctx, getState());
  enterRule(_localctx, 18, PortugolPPParser::RuleDeclaracaoEnquanto);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(162);
    match(PortugolPPParser::T__12);
    setState(163);
    match(PortugolPPParser::T__3);
    setState(164);
    expressao();
    setState(165);
    match(PortugolPPParser::T__4);
    setState(166);
    declaracao();
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- DeclaracaoSeContext ------------------------------------------------------------------

PortugolPPParser::DeclaracaoSeContext::DeclaracaoSeContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

PortugolPPParser::ExpressaoContext* PortugolPPParser::DeclaracaoSeContext::expressao() {
  return getRuleContext<PortugolPPParser::ExpressaoContext>(0);
}

std::vector<PortugolPPParser::DeclaracaoContext *> PortugolPPParser::DeclaracaoSeContext::declaracao() {
  return getRuleContexts<PortugolPPParser::DeclaracaoContext>();
}

PortugolPPParser::DeclaracaoContext* PortugolPPParser::DeclaracaoSeContext::declaracao(size_t i) {
  return getRuleContext<PortugolPPParser::DeclaracaoContext>(i);
}


size_t PortugolPPParser::DeclaracaoSeContext::getRuleIndex() const {
  return PortugolPPParser::RuleDeclaracaoSe;
}

void PortugolPPParser::DeclaracaoSeContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterDeclaracaoSe(this);
}

void PortugolPPParser::DeclaracaoSeContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitDeclaracaoSe(this);
}


std::any PortugolPPParser::DeclaracaoSeContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitDeclaracaoSe(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::DeclaracaoSeContext* PortugolPPParser::declaracaoSe() {
  DeclaracaoSeContext *_localctx = _tracker.createInstance<DeclaracaoSeContext>(_ctx, getState());
  enterRule(_localctx, 20, PortugolPPParser::RuleDeclaracaoSe);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(168);
    match(PortugolPPParser::T__14);
    setState(169);
    match(PortugolPPParser::T__3);
    setState(170);
    expressao();
    setState(171);
    match(PortugolPPParser::T__4);
    setState(172);
    declaracao();
    setState(175);
    _errHandler->sync(this);

    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 7, _ctx)) {
    case 1: {
      setState(173);
      match(PortugolPPParser::T__15);
      setState(174);
      declaracao();
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- DeclaracaoReturnContext ------------------------------------------------------------------

PortugolPPParser::DeclaracaoReturnContext::DeclaracaoReturnContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

PortugolPPParser::ExpressaoContext* PortugolPPParser::DeclaracaoReturnContext::expressao() {
  return getRuleContext<PortugolPPParser::ExpressaoContext>(0);
}


size_t PortugolPPParser::DeclaracaoReturnContext::getRuleIndex() const {
  return PortugolPPParser::RuleDeclaracaoReturn;
}

void PortugolPPParser::DeclaracaoReturnContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterDeclaracaoReturn(this);
}

void PortugolPPParser::DeclaracaoReturnContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitDeclaracaoReturn(this);
}


std::any PortugolPPParser::DeclaracaoReturnContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitDeclaracaoReturn(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::DeclaracaoReturnContext* PortugolPPParser::declaracaoReturn() {
  DeclaracaoReturnContext *_localctx = _tracker.createInstance<DeclaracaoReturnContext>(_ctx, getState());
  enterRule(_localctx, 22, PortugolPPParser::RuleDeclaracaoReturn);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(177);
    match(PortugolPPParser::T__16);
    setState(179);
    _errHandler->sync(this);

    _la = _input->LA(1);
    if ((((_la & ~ 0x3fULL) == 0) &&
      ((1ULL << _la) & 35962828468781072) != 0)) {
      setState(178);
      expressao();
    }
    setState(181);
    match(PortugolPPParser::T__1);
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- DeclaracaoClasseContext ------------------------------------------------------------------

PortugolPPParser::DeclaracaoClasseContext::DeclaracaoClasseContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

std::vector<tree::TerminalNode *> PortugolPPParser::DeclaracaoClasseContext::ID() {
  return getTokens(PortugolPPParser::ID);
}

tree::TerminalNode* PortugolPPParser::DeclaracaoClasseContext::ID(size_t i) {
  return getToken(PortugolPPParser::ID, i);
}

std::vector<PortugolPPParser::DeclaracaoVarContext *> PortugolPPParser::DeclaracaoClasseContext::declaracaoVar() {
  return getRuleContexts<PortugolPPParser::DeclaracaoVarContext>();
}

PortugolPPParser::DeclaracaoVarContext* PortugolPPParser::DeclaracaoClasseContext::declaracaoVar(size_t i) {
  return getRuleContext<PortugolPPParser::DeclaracaoVarContext>(i);
}

std::vector<PortugolPPParser::DeclaracaoFuncaoContext *> PortugolPPParser::DeclaracaoClasseContext::declaracaoFuncao() {
  return getRuleContexts<PortugolPPParser::DeclaracaoFuncaoContext>();
}

PortugolPPParser::DeclaracaoFuncaoContext* PortugolPPParser::DeclaracaoClasseContext::declaracaoFuncao(size_t i) {
  return getRuleContext<PortugolPPParser::DeclaracaoFuncaoContext>(i);
}


size_t PortugolPPParser::DeclaracaoClasseContext::getRuleIndex() const {
  return PortugolPPParser::RuleDeclaracaoClasse;
}

void PortugolPPParser::DeclaracaoClasseContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterDeclaracaoClasse(this);
}

void PortugolPPParser::DeclaracaoClasseContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitDeclaracaoClasse(this);
}


std::any PortugolPPParser::DeclaracaoClasseContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitDeclaracaoClasse(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::DeclaracaoClasseContext* PortugolPPParser::declaracaoClasse() {
  DeclaracaoClasseContext *_localctx = _tracker.createInstance<DeclaracaoClasseContext>(_ctx, getState());
  enterRule(_localctx, 24, PortugolPPParser::RuleDeclaracaoClasse);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(183);
    match(PortugolPPParser::T__17);
    setState(184);
    match(PortugolPPParser::ID);
    setState(187);
    _errHandler->sync(this);

    _la = _input->LA(1);
    if (_la == PortugolPPParser::T__18) {
      setState(185);
      match(PortugolPPParser::T__18);
      setState(186);
      match(PortugolPPParser::ID);
    }
    setState(198);
    _errHandler->sync(this);

    _la = _input->LA(1);
    if (_la == PortugolPPParser::T__19) {
      setState(189);
      match(PortugolPPParser::T__19);
      setState(190);
      match(PortugolPPParser::ID);
      setState(195);
      _errHandler->sync(this);
      _la = _input->LA(1);
      while (_la == PortugolPPParser::T__20) {
        setState(191);
        match(PortugolPPParser::T__20);
        setState(192);
        match(PortugolPPParser::ID);
        setState(197);
        _errHandler->sync(this);
        _la = _input->LA(1);
      }
    }
    setState(200);
    match(PortugolPPParser::T__7);
    setState(205);
    _errHandler->sync(this);
    _la = _input->LA(1);
    while (_la == PortugolPPParser::T__2

    || _la == PortugolPPParser::T__21) {
      setState(203);
      _errHandler->sync(this);
      switch (_input->LA(1)) {
        case PortugolPPParser::T__21: {
          setState(201);
          declaracaoVar();
          break;
        }

        case PortugolPPParser::T__2: {
          setState(202);
          declaracaoFuncao();
          break;
        }

      default:
        throw NoViableAltException(this);
      }
      setState(207);
      _errHandler->sync(this);
      _la = _input->LA(1);
    }
    setState(208);
    match(PortugolPPParser::T__8);
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- DeclaracaoVarContext ------------------------------------------------------------------

PortugolPPParser::DeclaracaoVarContext::DeclaracaoVarContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* PortugolPPParser::DeclaracaoVarContext::ID() {
  return getToken(PortugolPPParser::ID, 0);
}

PortugolPPParser::TipoContext* PortugolPPParser::DeclaracaoVarContext::tipo() {
  return getRuleContext<PortugolPPParser::TipoContext>(0);
}

PortugolPPParser::ExpressaoContext* PortugolPPParser::DeclaracaoVarContext::expressao() {
  return getRuleContext<PortugolPPParser::ExpressaoContext>(0);
}


size_t PortugolPPParser::DeclaracaoVarContext::getRuleIndex() const {
  return PortugolPPParser::RuleDeclaracaoVar;
}

void PortugolPPParser::DeclaracaoVarContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterDeclaracaoVar(this);
}

void PortugolPPParser::DeclaracaoVarContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitDeclaracaoVar(this);
}


std::any PortugolPPParser::DeclaracaoVarContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitDeclaracaoVar(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::DeclaracaoVarContext* PortugolPPParser::declaracaoVar() {
  DeclaracaoVarContext *_localctx = _tracker.createInstance<DeclaracaoVarContext>(_ctx, getState());
  enterRule(_localctx, 26, PortugolPPParser::RuleDeclaracaoVar);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(210);
    match(PortugolPPParser::T__21);
    setState(211);
    match(PortugolPPParser::ID);
    setState(214);
    _errHandler->sync(this);

    _la = _input->LA(1);
    if (_la == PortugolPPParser::T__5) {
      setState(212);
      match(PortugolPPParser::T__5);
      setState(213);
      tipo();
    }
    setState(218);
    _errHandler->sync(this);

    _la = _input->LA(1);
    if (_la == PortugolPPParser::T__22) {
      setState(216);
      match(PortugolPPParser::T__22);
      setState(217);
      expressao();
    }
    setState(220);
    match(PortugolPPParser::T__1);
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- DeclaracaoFuncaoContext ------------------------------------------------------------------

PortugolPPParser::DeclaracaoFuncaoContext::DeclaracaoFuncaoContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* PortugolPPParser::DeclaracaoFuncaoContext::ID() {
  return getToken(PortugolPPParser::ID, 0);
}

PortugolPPParser::BlocoContext* PortugolPPParser::DeclaracaoFuncaoContext::bloco() {
  return getRuleContext<PortugolPPParser::BlocoContext>(0);
}

PortugolPPParser::ListaParamsContext* PortugolPPParser::DeclaracaoFuncaoContext::listaParams() {
  return getRuleContext<PortugolPPParser::ListaParamsContext>(0);
}

PortugolPPParser::TipoContext* PortugolPPParser::DeclaracaoFuncaoContext::tipo() {
  return getRuleContext<PortugolPPParser::TipoContext>(0);
}


size_t PortugolPPParser::DeclaracaoFuncaoContext::getRuleIndex() const {
  return PortugolPPParser::RuleDeclaracaoFuncao;
}

void PortugolPPParser::DeclaracaoFuncaoContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterDeclaracaoFuncao(this);
}

void PortugolPPParser::DeclaracaoFuncaoContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitDeclaracaoFuncao(this);
}


std::any PortugolPPParser::DeclaracaoFuncaoContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitDeclaracaoFuncao(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::DeclaracaoFuncaoContext* PortugolPPParser::declaracaoFuncao() {
  DeclaracaoFuncaoContext *_localctx = _tracker.createInstance<DeclaracaoFuncaoContext>(_ctx, getState());
  enterRule(_localctx, 28, PortugolPPParser::RuleDeclaracaoFuncao);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(222);
    match(PortugolPPParser::T__2);
    setState(223);
    match(PortugolPPParser::ID);
    setState(224);
    match(PortugolPPParser::T__3);
    setState(226);
    _errHandler->sync(this);

    _la = _input->LA(1);
    if (_la == PortugolPPParser::ID) {
      setState(225);
      listaParams();
    }
    setState(228);
    match(PortugolPPParser::T__4);
    setState(231);
    _errHandler->sync(this);

    _la = _input->LA(1);
    if (_la == PortugolPPParser::T__5) {
      setState(229);
      match(PortugolPPParser::T__5);
      setState(230);
      tipo();
    }
    setState(233);
    bloco();
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- ListaParamsContext ------------------------------------------------------------------

PortugolPPParser::ListaParamsContext::ListaParamsContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

std::vector<PortugolPPParser::ParamContext *> PortugolPPParser::ListaParamsContext::param() {
  return getRuleContexts<PortugolPPParser::ParamContext>();
}

PortugolPPParser::ParamContext* PortugolPPParser::ListaParamsContext::param(size_t i) {
  return getRuleContext<PortugolPPParser::ParamContext>(i);
}


size_t PortugolPPParser::ListaParamsContext::getRuleIndex() const {
  return PortugolPPParser::RuleListaParams;
}

void PortugolPPParser::ListaParamsContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterListaParams(this);
}

void PortugolPPParser::ListaParamsContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitListaParams(this);
}


std::any PortugolPPParser::ListaParamsContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitListaParams(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::ListaParamsContext* PortugolPPParser::listaParams() {
  ListaParamsContext *_localctx = _tracker.createInstance<ListaParamsContext>(_ctx, getState());
  enterRule(_localctx, 30, PortugolPPParser::RuleListaParams);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(235);
    param();
    setState(240);
    _errHandler->sync(this);
    _la = _input->LA(1);
    while (_la == PortugolPPParser::T__20) {
      setState(236);
      match(PortugolPPParser::T__20);
      setState(237);
      param();
      setState(242);
      _errHandler->sync(this);
      _la = _input->LA(1);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- ParamContext ------------------------------------------------------------------

PortugolPPParser::ParamContext::ParamContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* PortugolPPParser::ParamContext::ID() {
  return getToken(PortugolPPParser::ID, 0);
}

PortugolPPParser::TipoContext* PortugolPPParser::ParamContext::tipo() {
  return getRuleContext<PortugolPPParser::TipoContext>(0);
}


size_t PortugolPPParser::ParamContext::getRuleIndex() const {
  return PortugolPPParser::RuleParam;
}

void PortugolPPParser::ParamContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterParam(this);
}

void PortugolPPParser::ParamContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitParam(this);
}


std::any PortugolPPParser::ParamContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitParam(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::ParamContext* PortugolPPParser::param() {
  ParamContext *_localctx = _tracker.createInstance<ParamContext>(_ctx, getState());
  enterRule(_localctx, 32, PortugolPPParser::RuleParam);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(243);
    match(PortugolPPParser::ID);
    setState(244);
    match(PortugolPPParser::T__5);
    setState(245);
    tipo();
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- TipoContext ------------------------------------------------------------------

PortugolPPParser::TipoContext::TipoContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* PortugolPPParser::TipoContext::ID() {
  return getToken(PortugolPPParser::ID, 0);
}


size_t PortugolPPParser::TipoContext::getRuleIndex() const {
  return PortugolPPParser::RuleTipo;
}

void PortugolPPParser::TipoContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterTipo(this);
}

void PortugolPPParser::TipoContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitTipo(this);
}


std::any PortugolPPParser::TipoContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitTipo(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::TipoContext* PortugolPPParser::tipo() {
  TipoContext *_localctx = _tracker.createInstance<TipoContext>(_ctx, getState());
  enterRule(_localctx, 34, PortugolPPParser::RuleTipo);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(247);
    _la = _input->LA(1);
    if (!((((_la & ~ 0x3fULL) == 0) &&
      ((1ULL << _la) & 4503600684335104) != 0))) {
    _errHandler->recoverInline(this);
    }
    else {
      _errHandler->reportMatch(this);
      consume();
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- BlocoContext ------------------------------------------------------------------

PortugolPPParser::BlocoContext::BlocoContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

std::vector<PortugolPPParser::DeclaracaoContext *> PortugolPPParser::BlocoContext::declaracao() {
  return getRuleContexts<PortugolPPParser::DeclaracaoContext>();
}

PortugolPPParser::DeclaracaoContext* PortugolPPParser::BlocoContext::declaracao(size_t i) {
  return getRuleContext<PortugolPPParser::DeclaracaoContext>(i);
}


size_t PortugolPPParser::BlocoContext::getRuleIndex() const {
  return PortugolPPParser::RuleBloco;
}

void PortugolPPParser::BlocoContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterBloco(this);
}

void PortugolPPParser::BlocoContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitBloco(this);
}


std::any PortugolPPParser::BlocoContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitBloco(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::BlocoContext* PortugolPPParser::bloco() {
  BlocoContext *_localctx = _tracker.createInstance<BlocoContext>(_ctx, getState());
  enterRule(_localctx, 36, PortugolPPParser::RuleBloco);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(249);
    match(PortugolPPParser::T__7);
    setState(253);
    _errHandler->sync(this);
    _la = _input->LA(1);
    while ((((_la & ~ 0x3fULL) == 0) &&
      ((1ULL << _la) & 35962828473433496) != 0)) {
      setState(250);
      declaracao();
      setState(255);
      _errHandler->sync(this);
      _la = _input->LA(1);
    }
    setState(256);
    match(PortugolPPParser::T__8);
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- ExpressaoContext ------------------------------------------------------------------

PortugolPPParser::ExpressaoContext::ExpressaoContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

PortugolPPParser::AtribuicaoContext* PortugolPPParser::ExpressaoContext::atribuicao() {
  return getRuleContext<PortugolPPParser::AtribuicaoContext>(0);
}


size_t PortugolPPParser::ExpressaoContext::getRuleIndex() const {
  return PortugolPPParser::RuleExpressao;
}

void PortugolPPParser::ExpressaoContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterExpressao(this);
}

void PortugolPPParser::ExpressaoContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitExpressao(this);
}


std::any PortugolPPParser::ExpressaoContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitExpressao(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::ExpressaoContext* PortugolPPParser::expressao() {
  ExpressaoContext *_localctx = _tracker.createInstance<ExpressaoContext>(_ctx, getState());
  enterRule(_localctx, 38, PortugolPPParser::RuleExpressao);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(258);
    atribuicao();
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- AtribuicaoContext ------------------------------------------------------------------

PortugolPPParser::AtribuicaoContext::AtribuicaoContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

PortugolPPParser::ExpressaoContext* PortugolPPParser::AtribuicaoContext::expressao() {
  return getRuleContext<PortugolPPParser::ExpressaoContext>(0);
}

tree::TerminalNode* PortugolPPParser::AtribuicaoContext::ID() {
  return getToken(PortugolPPParser::ID, 0);
}

PortugolPPParser::AcessoContext* PortugolPPParser::AtribuicaoContext::acesso() {
  return getRuleContext<PortugolPPParser::AcessoContext>(0);
}

PortugolPPParser::AcessoArrayContext* PortugolPPParser::AtribuicaoContext::acessoArray() {
  return getRuleContext<PortugolPPParser::AcessoArrayContext>(0);
}

PortugolPPParser::LogicaOuContext* PortugolPPParser::AtribuicaoContext::logicaOu() {
  return getRuleContext<PortugolPPParser::LogicaOuContext>(0);
}


size_t PortugolPPParser::AtribuicaoContext::getRuleIndex() const {
  return PortugolPPParser::RuleAtribuicao;
}

void PortugolPPParser::AtribuicaoContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterAtribuicao(this);
}

void PortugolPPParser::AtribuicaoContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitAtribuicao(this);
}


std::any PortugolPPParser::AtribuicaoContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitAtribuicao(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::AtribuicaoContext* PortugolPPParser::atribuicao() {
  AtribuicaoContext *_localctx = _tracker.createInstance<AtribuicaoContext>(_ctx, getState());
  enterRule(_localctx, 40, PortugolPPParser::RuleAtribuicao);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(268);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 21, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(263);
      _errHandler->sync(this);
      switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 20, _ctx)) {
      case 1: {
        setState(260);
        match(PortugolPPParser::ID);
        break;
      }

      case 2: {
        setState(261);
        acesso();
        break;
      }

      case 3: {
        setState(262);
        acessoArray();
        break;
      }

      default:
        break;
      }
      setState(265);
      match(PortugolPPParser::T__22);
      setState(266);
      expressao();
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(267);
      logicaOu();
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- AcessoContext ------------------------------------------------------------------

PortugolPPParser::AcessoContext::AcessoContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

PortugolPPParser::PrimarioContext* PortugolPPParser::AcessoContext::primario() {
  return getRuleContext<PortugolPPParser::PrimarioContext>(0);
}

tree::TerminalNode* PortugolPPParser::AcessoContext::ID() {
  return getToken(PortugolPPParser::ID, 0);
}


size_t PortugolPPParser::AcessoContext::getRuleIndex() const {
  return PortugolPPParser::RuleAcesso;
}

void PortugolPPParser::AcessoContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterAcesso(this);
}

void PortugolPPParser::AcessoContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitAcesso(this);
}


std::any PortugolPPParser::AcessoContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitAcesso(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::AcessoContext* PortugolPPParser::acesso() {
  AcessoContext *_localctx = _tracker.createInstance<AcessoContext>(_ctx, getState());
  enterRule(_localctx, 42, PortugolPPParser::RuleAcesso);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(270);
    primario();
    setState(271);
    match(PortugolPPParser::T__29);
    setState(272);
    match(PortugolPPParser::ID);
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- AcessoArrayContext ------------------------------------------------------------------

PortugolPPParser::AcessoArrayContext::AcessoArrayContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

PortugolPPParser::PrimarioContext* PortugolPPParser::AcessoArrayContext::primario() {
  return getRuleContext<PortugolPPParser::PrimarioContext>(0);
}

std::vector<PortugolPPParser::ExpressaoContext *> PortugolPPParser::AcessoArrayContext::expressao() {
  return getRuleContexts<PortugolPPParser::ExpressaoContext>();
}

PortugolPPParser::ExpressaoContext* PortugolPPParser::AcessoArrayContext::expressao(size_t i) {
  return getRuleContext<PortugolPPParser::ExpressaoContext>(i);
}


size_t PortugolPPParser::AcessoArrayContext::getRuleIndex() const {
  return PortugolPPParser::RuleAcessoArray;
}

void PortugolPPParser::AcessoArrayContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterAcessoArray(this);
}

void PortugolPPParser::AcessoArrayContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitAcessoArray(this);
}


std::any PortugolPPParser::AcessoArrayContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitAcessoArray(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::AcessoArrayContext* PortugolPPParser::acessoArray() {
  AcessoArrayContext *_localctx = _tracker.createInstance<AcessoArrayContext>(_ctx, getState());
  enterRule(_localctx, 44, PortugolPPParser::RuleAcessoArray);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(287);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 22, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(274);
      primario();
      setState(275);
      match(PortugolPPParser::T__30);
      setState(276);
      expressao();
      setState(277);
      match(PortugolPPParser::T__31);
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(279);
      primario();
      setState(280);
      match(PortugolPPParser::T__30);
      setState(281);
      expressao();
      setState(282);
      match(PortugolPPParser::T__31);
      setState(283);
      match(PortugolPPParser::T__30);
      setState(284);
      expressao();
      setState(285);
      match(PortugolPPParser::T__31);
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- LogicaOuContext ------------------------------------------------------------------

PortugolPPParser::LogicaOuContext::LogicaOuContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

std::vector<PortugolPPParser::LogicaEContext *> PortugolPPParser::LogicaOuContext::logicaE() {
  return getRuleContexts<PortugolPPParser::LogicaEContext>();
}

PortugolPPParser::LogicaEContext* PortugolPPParser::LogicaOuContext::logicaE(size_t i) {
  return getRuleContext<PortugolPPParser::LogicaEContext>(i);
}


size_t PortugolPPParser::LogicaOuContext::getRuleIndex() const {
  return PortugolPPParser::RuleLogicaOu;
}

void PortugolPPParser::LogicaOuContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterLogicaOu(this);
}

void PortugolPPParser::LogicaOuContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitLogicaOu(this);
}


std::any PortugolPPParser::LogicaOuContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitLogicaOu(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::LogicaOuContext* PortugolPPParser::logicaOu() {
  LogicaOuContext *_localctx = _tracker.createInstance<LogicaOuContext>(_ctx, getState());
  enterRule(_localctx, 46, PortugolPPParser::RuleLogicaOu);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(289);
    logicaE();
    setState(294);
    _errHandler->sync(this);
    _la = _input->LA(1);
    while (_la == PortugolPPParser::T__32) {
      setState(290);
      match(PortugolPPParser::T__32);
      setState(291);
      logicaE();
      setState(296);
      _errHandler->sync(this);
      _la = _input->LA(1);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- LogicaEContext ------------------------------------------------------------------

PortugolPPParser::LogicaEContext::LogicaEContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

std::vector<PortugolPPParser::IgualdadeContext *> PortugolPPParser::LogicaEContext::igualdade() {
  return getRuleContexts<PortugolPPParser::IgualdadeContext>();
}

PortugolPPParser::IgualdadeContext* PortugolPPParser::LogicaEContext::igualdade(size_t i) {
  return getRuleContext<PortugolPPParser::IgualdadeContext>(i);
}


size_t PortugolPPParser::LogicaEContext::getRuleIndex() const {
  return PortugolPPParser::RuleLogicaE;
}

void PortugolPPParser::LogicaEContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterLogicaE(this);
}

void PortugolPPParser::LogicaEContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitLogicaE(this);
}


std::any PortugolPPParser::LogicaEContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitLogicaE(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::LogicaEContext* PortugolPPParser::logicaE() {
  LogicaEContext *_localctx = _tracker.createInstance<LogicaEContext>(_ctx, getState());
  enterRule(_localctx, 48, PortugolPPParser::RuleLogicaE);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(297);
    igualdade();
    setState(302);
    _errHandler->sync(this);
    _la = _input->LA(1);
    while (_la == PortugolPPParser::T__33) {
      setState(298);
      match(PortugolPPParser::T__33);
      setState(299);
      igualdade();
      setState(304);
      _errHandler->sync(this);
      _la = _input->LA(1);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- IgualdadeContext ------------------------------------------------------------------

PortugolPPParser::IgualdadeContext::IgualdadeContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

std::vector<PortugolPPParser::ComparacaoContext *> PortugolPPParser::IgualdadeContext::comparacao() {
  return getRuleContexts<PortugolPPParser::ComparacaoContext>();
}

PortugolPPParser::ComparacaoContext* PortugolPPParser::IgualdadeContext::comparacao(size_t i) {
  return getRuleContext<PortugolPPParser::ComparacaoContext>(i);
}


size_t PortugolPPParser::IgualdadeContext::getRuleIndex() const {
  return PortugolPPParser::RuleIgualdade;
}

void PortugolPPParser::IgualdadeContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterIgualdade(this);
}

void PortugolPPParser::IgualdadeContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitIgualdade(this);
}


std::any PortugolPPParser::IgualdadeContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitIgualdade(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::IgualdadeContext* PortugolPPParser::igualdade() {
  IgualdadeContext *_localctx = _tracker.createInstance<IgualdadeContext>(_ctx, getState());
  enterRule(_localctx, 50, PortugolPPParser::RuleIgualdade);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(305);
    comparacao();
    setState(310);
    _errHandler->sync(this);
    _la = _input->LA(1);
    while (_la == PortugolPPParser::T__34

    || _la == PortugolPPParser::T__35) {
      setState(306);
      _la = _input->LA(1);
      if (!(_la == PortugolPPParser::T__34

      || _la == PortugolPPParser::T__35)) {
      _errHandler->recoverInline(this);
      }
      else {
        _errHandler->reportMatch(this);
        consume();
      }
      setState(307);
      comparacao();
      setState(312);
      _errHandler->sync(this);
      _la = _input->LA(1);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- ComparacaoContext ------------------------------------------------------------------

PortugolPPParser::ComparacaoContext::ComparacaoContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

std::vector<PortugolPPParser::AdicaoContext *> PortugolPPParser::ComparacaoContext::adicao() {
  return getRuleContexts<PortugolPPParser::AdicaoContext>();
}

PortugolPPParser::AdicaoContext* PortugolPPParser::ComparacaoContext::adicao(size_t i) {
  return getRuleContext<PortugolPPParser::AdicaoContext>(i);
}


size_t PortugolPPParser::ComparacaoContext::getRuleIndex() const {
  return PortugolPPParser::RuleComparacao;
}

void PortugolPPParser::ComparacaoContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterComparacao(this);
}

void PortugolPPParser::ComparacaoContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitComparacao(this);
}


std::any PortugolPPParser::ComparacaoContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitComparacao(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::ComparacaoContext* PortugolPPParser::comparacao() {
  ComparacaoContext *_localctx = _tracker.createInstance<ComparacaoContext>(_ctx, getState());
  enterRule(_localctx, 52, PortugolPPParser::RuleComparacao);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(313);
    adicao();
    setState(318);
    _errHandler->sync(this);
    _la = _input->LA(1);
    while ((((_la & ~ 0x3fULL) == 0) &&
      ((1ULL << _la) & 2061584302080) != 0)) {
      setState(314);
      _la = _input->LA(1);
      if (!((((_la & ~ 0x3fULL) == 0) &&
        ((1ULL << _la) & 2061584302080) != 0))) {
      _errHandler->recoverInline(this);
      }
      else {
        _errHandler->reportMatch(this);
        consume();
      }
      setState(315);
      adicao();
      setState(320);
      _errHandler->sync(this);
      _la = _input->LA(1);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- AdicaoContext ------------------------------------------------------------------

PortugolPPParser::AdicaoContext::AdicaoContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

std::vector<PortugolPPParser::MultiplicacaoContext *> PortugolPPParser::AdicaoContext::multiplicacao() {
  return getRuleContexts<PortugolPPParser::MultiplicacaoContext>();
}

PortugolPPParser::MultiplicacaoContext* PortugolPPParser::AdicaoContext::multiplicacao(size_t i) {
  return getRuleContext<PortugolPPParser::MultiplicacaoContext>(i);
}


size_t PortugolPPParser::AdicaoContext::getRuleIndex() const {
  return PortugolPPParser::RuleAdicao;
}

void PortugolPPParser::AdicaoContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterAdicao(this);
}

void PortugolPPParser::AdicaoContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitAdicao(this);
}


std::any PortugolPPParser::AdicaoContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitAdicao(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::AdicaoContext* PortugolPPParser::adicao() {
  AdicaoContext *_localctx = _tracker.createInstance<AdicaoContext>(_ctx, getState());
  enterRule(_localctx, 54, PortugolPPParser::RuleAdicao);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(321);
    multiplicacao();
    setState(326);
    _errHandler->sync(this);
    _la = _input->LA(1);
    while (_la == PortugolPPParser::T__40

    || _la == PortugolPPParser::T__41) {
      setState(322);
      _la = _input->LA(1);
      if (!(_la == PortugolPPParser::T__40

      || _la == PortugolPPParser::T__41)) {
      _errHandler->recoverInline(this);
      }
      else {
        _errHandler->reportMatch(this);
        consume();
      }
      setState(323);
      multiplicacao();
      setState(328);
      _errHandler->sync(this);
      _la = _input->LA(1);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- MultiplicacaoContext ------------------------------------------------------------------

PortugolPPParser::MultiplicacaoContext::MultiplicacaoContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

std::vector<PortugolPPParser::UnarioContext *> PortugolPPParser::MultiplicacaoContext::unario() {
  return getRuleContexts<PortugolPPParser::UnarioContext>();
}

PortugolPPParser::UnarioContext* PortugolPPParser::MultiplicacaoContext::unario(size_t i) {
  return getRuleContext<PortugolPPParser::UnarioContext>(i);
}


size_t PortugolPPParser::MultiplicacaoContext::getRuleIndex() const {
  return PortugolPPParser::RuleMultiplicacao;
}

void PortugolPPParser::MultiplicacaoContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterMultiplicacao(this);
}

void PortugolPPParser::MultiplicacaoContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitMultiplicacao(this);
}


std::any PortugolPPParser::MultiplicacaoContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitMultiplicacao(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::MultiplicacaoContext* PortugolPPParser::multiplicacao() {
  MultiplicacaoContext *_localctx = _tracker.createInstance<MultiplicacaoContext>(_ctx, getState());
  enterRule(_localctx, 56, PortugolPPParser::RuleMultiplicacao);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(329);
    unario();
    setState(334);
    _errHandler->sync(this);
    _la = _input->LA(1);
    while ((((_la & ~ 0x3fULL) == 0) &&
      ((1ULL << _la) & 61572651155456) != 0)) {
      setState(330);
      _la = _input->LA(1);
      if (!((((_la & ~ 0x3fULL) == 0) &&
        ((1ULL << _la) & 61572651155456) != 0))) {
      _errHandler->recoverInline(this);
      }
      else {
        _errHandler->reportMatch(this);
        consume();
      }
      setState(331);
      unario();
      setState(336);
      _errHandler->sync(this);
      _la = _input->LA(1);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- UnarioContext ------------------------------------------------------------------

PortugolPPParser::UnarioContext::UnarioContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

PortugolPPParser::UnarioContext* PortugolPPParser::UnarioContext::unario() {
  return getRuleContext<PortugolPPParser::UnarioContext>(0);
}

PortugolPPParser::ChamadaContext* PortugolPPParser::UnarioContext::chamada() {
  return getRuleContext<PortugolPPParser::ChamadaContext>(0);
}


size_t PortugolPPParser::UnarioContext::getRuleIndex() const {
  return PortugolPPParser::RuleUnario;
}

void PortugolPPParser::UnarioContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterUnario(this);
}

void PortugolPPParser::UnarioContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitUnario(this);
}


std::any PortugolPPParser::UnarioContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitUnario(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::UnarioContext* PortugolPPParser::unario() {
  UnarioContext *_localctx = _tracker.createInstance<UnarioContext>(_ctx, getState());
  enterRule(_localctx, 58, PortugolPPParser::RuleUnario);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(340);
    _errHandler->sync(this);
    switch (_input->LA(1)) {
      case PortugolPPParser::T__41:
      case PortugolPPParser::T__45: {
        enterOuterAlt(_localctx, 1);
        setState(337);
        _la = _input->LA(1);
        if (!(_la == PortugolPPParser::T__41

        || _la == PortugolPPParser::T__45)) {
        _errHandler->recoverInline(this);
        }
        else {
          _errHandler->reportMatch(this);
          consume();
        }
        setState(338);
        unario();
        break;
      }

      case PortugolPPParser::T__3:
      case PortugolPPParser::T__30:
      case PortugolPPParser::T__46:
      case PortugolPPParser::T__47:
      case PortugolPPParser::T__48:
      case PortugolPPParser::T__49:
      case PortugolPPParser::T__50:
      case PortugolPPParser::ID:
      case PortugolPPParser::NUMERO:
      case PortugolPPParser::TEXTO_LITERAL: {
        enterOuterAlt(_localctx, 2);
        setState(339);
        chamada();
        break;
      }

    default:
      throw NoViableAltException(this);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- ChamadaContext ------------------------------------------------------------------

PortugolPPParser::ChamadaContext::ChamadaContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

PortugolPPParser::PrimarioContext* PortugolPPParser::ChamadaContext::primario() {
  return getRuleContext<PortugolPPParser::PrimarioContext>(0);
}

std::vector<tree::TerminalNode *> PortugolPPParser::ChamadaContext::ID() {
  return getTokens(PortugolPPParser::ID);
}

tree::TerminalNode* PortugolPPParser::ChamadaContext::ID(size_t i) {
  return getToken(PortugolPPParser::ID, i);
}

std::vector<PortugolPPParser::ArgumentosContext *> PortugolPPParser::ChamadaContext::argumentos() {
  return getRuleContexts<PortugolPPParser::ArgumentosContext>();
}

PortugolPPParser::ArgumentosContext* PortugolPPParser::ChamadaContext::argumentos(size_t i) {
  return getRuleContext<PortugolPPParser::ArgumentosContext>(i);
}

PortugolPPParser::AcessoArrayContext* PortugolPPParser::ChamadaContext::acessoArray() {
  return getRuleContext<PortugolPPParser::AcessoArrayContext>(0);
}


size_t PortugolPPParser::ChamadaContext::getRuleIndex() const {
  return PortugolPPParser::RuleChamada;
}

void PortugolPPParser::ChamadaContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterChamada(this);
}

void PortugolPPParser::ChamadaContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitChamada(this);
}


std::any PortugolPPParser::ChamadaContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitChamada(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::ChamadaContext* PortugolPPParser::chamada() {
  ChamadaContext *_localctx = _tracker.createInstance<ChamadaContext>(_ctx, getState());
  enterRule(_localctx, 60, PortugolPPParser::RuleChamada);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(358);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 33, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(342);
      primario();
      setState(354);
      _errHandler->sync(this);
      _la = _input->LA(1);
      while (_la == PortugolPPParser::T__29) {
        setState(343);
        match(PortugolPPParser::T__29);
        setState(344);
        match(PortugolPPParser::ID);
        setState(350);
        _errHandler->sync(this);

        _la = _input->LA(1);
        if (_la == PortugolPPParser::T__3) {
          setState(345);
          match(PortugolPPParser::T__3);
          setState(347);
          _errHandler->sync(this);

          _la = _input->LA(1);
          if ((((_la & ~ 0x3fULL) == 0) &&
            ((1ULL << _la) & 35962828468781072) != 0)) {
            setState(346);
            argumentos();
          }
          setState(349);
          match(PortugolPPParser::T__4);
        }
        setState(356);
        _errHandler->sync(this);
        _la = _input->LA(1);
      }
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(357);
      acessoArray();
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- ChamadaFuncaoContext ------------------------------------------------------------------

PortugolPPParser::ChamadaFuncaoContext::ChamadaFuncaoContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* PortugolPPParser::ChamadaFuncaoContext::ID() {
  return getToken(PortugolPPParser::ID, 0);
}

PortugolPPParser::ArgumentosContext* PortugolPPParser::ChamadaFuncaoContext::argumentos() {
  return getRuleContext<PortugolPPParser::ArgumentosContext>(0);
}

PortugolPPParser::PrimarioContext* PortugolPPParser::ChamadaFuncaoContext::primario() {
  return getRuleContext<PortugolPPParser::PrimarioContext>(0);
}


size_t PortugolPPParser::ChamadaFuncaoContext::getRuleIndex() const {
  return PortugolPPParser::RuleChamadaFuncao;
}

void PortugolPPParser::ChamadaFuncaoContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterChamadaFuncao(this);
}

void PortugolPPParser::ChamadaFuncaoContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitChamadaFuncao(this);
}


std::any PortugolPPParser::ChamadaFuncaoContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitChamadaFuncao(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::ChamadaFuncaoContext* PortugolPPParser::chamadaFuncao() {
  ChamadaFuncaoContext *_localctx = _tracker.createInstance<ChamadaFuncaoContext>(_ctx, getState());
  enterRule(_localctx, 62, PortugolPPParser::RuleChamadaFuncao);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(375);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 36, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(360);
      match(PortugolPPParser::ID);
      setState(361);
      match(PortugolPPParser::T__3);
      setState(363);
      _errHandler->sync(this);

      _la = _input->LA(1);
      if ((((_la & ~ 0x3fULL) == 0) &&
        ((1ULL << _la) & 35962828468781072) != 0)) {
        setState(362);
        argumentos();
      }
      setState(365);
      match(PortugolPPParser::T__4);
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(366);
      primario();
      setState(367);
      match(PortugolPPParser::T__29);
      setState(368);
      match(PortugolPPParser::ID);
      setState(369);
      match(PortugolPPParser::T__3);
      setState(371);
      _errHandler->sync(this);

      _la = _input->LA(1);
      if ((((_la & ~ 0x3fULL) == 0) &&
        ((1ULL << _la) & 35962828468781072) != 0)) {
        setState(370);
        argumentos();
      }
      setState(373);
      match(PortugolPPParser::T__4);
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- ArgumentosContext ------------------------------------------------------------------

PortugolPPParser::ArgumentosContext::ArgumentosContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

std::vector<PortugolPPParser::ExpressaoContext *> PortugolPPParser::ArgumentosContext::expressao() {
  return getRuleContexts<PortugolPPParser::ExpressaoContext>();
}

PortugolPPParser::ExpressaoContext* PortugolPPParser::ArgumentosContext::expressao(size_t i) {
  return getRuleContext<PortugolPPParser::ExpressaoContext>(i);
}


size_t PortugolPPParser::ArgumentosContext::getRuleIndex() const {
  return PortugolPPParser::RuleArgumentos;
}

void PortugolPPParser::ArgumentosContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterArgumentos(this);
}

void PortugolPPParser::ArgumentosContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitArgumentos(this);
}


std::any PortugolPPParser::ArgumentosContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitArgumentos(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::ArgumentosContext* PortugolPPParser::argumentos() {
  ArgumentosContext *_localctx = _tracker.createInstance<ArgumentosContext>(_ctx, getState());
  enterRule(_localctx, 64, PortugolPPParser::RuleArgumentos);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(377);
    expressao();
    setState(382);
    _errHandler->sync(this);
    _la = _input->LA(1);
    while (_la == PortugolPPParser::T__20) {
      setState(378);
      match(PortugolPPParser::T__20);
      setState(379);
      expressao();
      setState(384);
      _errHandler->sync(this);
      _la = _input->LA(1);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- PrimarioContext ------------------------------------------------------------------

PortugolPPParser::PrimarioContext::PrimarioContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* PortugolPPParser::PrimarioContext::NUMERO() {
  return getToken(PortugolPPParser::NUMERO, 0);
}

tree::TerminalNode* PortugolPPParser::PrimarioContext::TEXTO_LITERAL() {
  return getToken(PortugolPPParser::TEXTO_LITERAL, 0);
}

tree::TerminalNode* PortugolPPParser::PrimarioContext::ID() {
  return getToken(PortugolPPParser::ID, 0);
}

PortugolPPParser::ArgumentosContext* PortugolPPParser::PrimarioContext::argumentos() {
  return getRuleContext<PortugolPPParser::ArgumentosContext>(0);
}

PortugolPPParser::ExpressaoContext* PortugolPPParser::PrimarioContext::expressao() {
  return getRuleContext<PortugolPPParser::ExpressaoContext>(0);
}

PortugolPPParser::ListaLiteralContext* PortugolPPParser::PrimarioContext::listaLiteral() {
  return getRuleContext<PortugolPPParser::ListaLiteralContext>(0);
}

PortugolPPParser::MapaLiteralContext* PortugolPPParser::PrimarioContext::mapaLiteral() {
  return getRuleContext<PortugolPPParser::MapaLiteralContext>(0);
}


size_t PortugolPPParser::PrimarioContext::getRuleIndex() const {
  return PortugolPPParser::RulePrimario;
}

void PortugolPPParser::PrimarioContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterPrimario(this);
}

void PortugolPPParser::PrimarioContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitPrimario(this);
}


std::any PortugolPPParser::PrimarioContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitPrimario(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::PrimarioContext* PortugolPPParser::primario() {
  PrimarioContext *_localctx = _tracker.createInstance<PrimarioContext>(_ctx, getState());
  enterRule(_localctx, 66, PortugolPPParser::RulePrimario);
  size_t _la = 0;

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(411);
    _errHandler->sync(this);
    switch (_input->LA(1)) {
      case PortugolPPParser::T__46: {
        enterOuterAlt(_localctx, 1);
        setState(385);
        match(PortugolPPParser::T__46);
        break;
      }

      case PortugolPPParser::T__47: {
        enterOuterAlt(_localctx, 2);
        setState(386);
        match(PortugolPPParser::T__47);
        break;
      }

      case PortugolPPParser::NUMERO: {
        enterOuterAlt(_localctx, 3);
        setState(387);
        match(PortugolPPParser::NUMERO);
        break;
      }

      case PortugolPPParser::TEXTO_LITERAL: {
        enterOuterAlt(_localctx, 4);
        setState(388);
        match(PortugolPPParser::TEXTO_LITERAL);
        break;
      }

      case PortugolPPParser::ID: {
        enterOuterAlt(_localctx, 5);
        setState(389);
        match(PortugolPPParser::ID);
        setState(395);
        _errHandler->sync(this);

        _la = _input->LA(1);
        if (_la == PortugolPPParser::T__3) {
          setState(390);
          match(PortugolPPParser::T__3);
          setState(392);
          _errHandler->sync(this);

          _la = _input->LA(1);
          if ((((_la & ~ 0x3fULL) == 0) &&
            ((1ULL << _la) & 35962828468781072) != 0)) {
            setState(391);
            argumentos();
          }
          setState(394);
          match(PortugolPPParser::T__4);
        }
        break;
      }

      case PortugolPPParser::T__48: {
        enterOuterAlt(_localctx, 6);
        setState(397);
        match(PortugolPPParser::T__48);
        break;
      }

      case PortugolPPParser::T__3: {
        enterOuterAlt(_localctx, 7);
        setState(398);
        match(PortugolPPParser::T__3);
        setState(399);
        expressao();
        setState(400);
        match(PortugolPPParser::T__4);
        break;
      }

      case PortugolPPParser::T__49: {
        enterOuterAlt(_localctx, 8);
        setState(402);
        match(PortugolPPParser::T__49);
        setState(403);
        match(PortugolPPParser::ID);
        setState(404);
        match(PortugolPPParser::T__3);
        setState(406);
        _errHandler->sync(this);

        _la = _input->LA(1);
        if ((((_la & ~ 0x3fULL) == 0) &&
          ((1ULL << _la) & 35962828468781072) != 0)) {
          setState(405);
          argumentos();
        }
        setState(408);
        match(PortugolPPParser::T__4);
        break;
      }

      case PortugolPPParser::T__30: {
        enterOuterAlt(_localctx, 9);
        setState(409);
        listaLiteral();
        break;
      }

      case PortugolPPParser::T__50: {
        enterOuterAlt(_localctx, 10);
        setState(410);
        mapaLiteral();
        break;
      }

    default:
      throw NoViableAltException(this);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- ListaLiteralContext ------------------------------------------------------------------

PortugolPPParser::ListaLiteralContext::ListaLiteralContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}


size_t PortugolPPParser::ListaLiteralContext::getRuleIndex() const {
  return PortugolPPParser::RuleListaLiteral;
}

void PortugolPPParser::ListaLiteralContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterListaLiteral(this);
}

void PortugolPPParser::ListaLiteralContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitListaLiteral(this);
}


std::any PortugolPPParser::ListaLiteralContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitListaLiteral(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::ListaLiteralContext* PortugolPPParser::listaLiteral() {
  ListaLiteralContext *_localctx = _tracker.createInstance<ListaLiteralContext>(_ctx, getState());
  enterRule(_localctx, 68, PortugolPPParser::RuleListaLiteral);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(413);
    match(PortugolPPParser::T__30);
    setState(414);
    match(PortugolPPParser::T__31);
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- MapaLiteralContext ------------------------------------------------------------------

PortugolPPParser::MapaLiteralContext::MapaLiteralContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}


size_t PortugolPPParser::MapaLiteralContext::getRuleIndex() const {
  return PortugolPPParser::RuleMapaLiteral;
}

void PortugolPPParser::MapaLiteralContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterMapaLiteral(this);
}

void PortugolPPParser::MapaLiteralContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<PortugolPPListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitMapaLiteral(this);
}


std::any PortugolPPParser::MapaLiteralContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<PortugolPPVisitor*>(visitor))
    return parserVisitor->visitMapaLiteral(this);
  else
    return visitor->visitChildren(this);
}

PortugolPPParser::MapaLiteralContext* PortugolPPParser::mapaLiteral() {
  MapaLiteralContext *_localctx = _tracker.createInstance<MapaLiteralContext>(_ctx, getState());
  enterRule(_localctx, 70, PortugolPPParser::RuleMapaLiteral);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(416);
    match(PortugolPPParser::T__50);
    setState(417);
    match(PortugolPPParser::T__31);
    setState(418);
    match(PortugolPPParser::T__31);
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

void PortugolPPParser::initialize() {
#if ANTLR4_USE_THREAD_LOCAL_CACHE
  portugolppParserInitialize();
#else
  ::antlr4::internal::call_once(portugolppParserOnceFlag, portugolppParserInitialize);
#endif
}
