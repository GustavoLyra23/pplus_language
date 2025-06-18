// Generated from c:/Users/gusta/IdeaProjects/p_mais_mais/src/main/antlr/org/gustavolyra/PortugolPP.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PortugolPPParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, ID=51, NUMERO=52, TEXTO_LITERAL=53, 
		ESPACO=54, COMENTARIO=55, COMENTARIO_BLOCO=56;
	public static final int
		RULE_programa = 0, RULE_declaracao = 1, RULE_assinaturaMetodo = 2, RULE_declaracaoInterface = 3, 
		RULE_declaracaoQuebra = 4, RULE_declaracaoContinue = 5, RULE_declaracaoFacaEnquanto = 6, 
		RULE_declaracaoPara = 7, RULE_declaracaoEnquanto = 8, RULE_declaracaoSe = 9, 
		RULE_declaracaoReturn = 10, RULE_declaracaoClasse = 11, RULE_declaracaoVar = 12, 
		RULE_declaracaoFuncao = 13, RULE_listaParams = 14, RULE_param = 15, RULE_tipo = 16, 
		RULE_bloco = 17, RULE_expressao = 18, RULE_atribuicao = 19, RULE_acesso = 20, 
		RULE_acessoArray = 21, RULE_logicaOu = 22, RULE_logicaE = 23, RULE_igualdade = 24, 
		RULE_comparacao = 25, RULE_adicao = 26, RULE_multiplicacao = 27, RULE_unario = 28, 
		RULE_chamada = 29, RULE_chamadaFuncao = 30, RULE_argumentos = 31, RULE_primario = 32, 
		RULE_listaLiteral = 33, RULE_mapaLiteral = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaracao", "assinaturaMetodo", "declaracaoInterface", 
			"declaracaoQuebra", "declaracaoContinue", "declaracaoFacaEnquanto", "declaracaoPara", 
			"declaracaoEnquanto", "declaracaoSe", "declaracaoReturn", "declaracaoClasse", 
			"declaracaoVar", "declaracaoFuncao", "listaParams", "param", "tipo", 
			"bloco", "expressao", "atribuicao", "acesso", "acessoArray", "logicaOu", 
			"logicaE", "igualdade", "comparacao", "adicao", "multiplicacao", "unario", 
			"chamada", "chamadaFuncao", "argumentos", "primario", "listaLiteral", 
			"mapaLiteral"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'funcao'", "'('", "')'", "':'", "'interface'", "'{'", "'}'", 
			"'quebra'", "'continue'", "'faca'", "'enquanto'", "'para'", "'se'", "'senao'", 
			"'return'", "'classe'", "'estende'", "'implementa'", "','", "'var'", 
			"'='", "'Inteiro'", "'Real'", "'Texto'", "'Logico'", "'Lista'", "'Mapa'", 
			"'.'", "'['", "']'", "'ou'", "'e'", "'=='", "'!='", "'<'", "'<='", "'>'", 
			"'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'verdadeiro'", "'falso'", 
			"'this'", "'nova'", "'[['"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "ID", "NUMERO", "TEXTO_LITERAL", "ESPACO", "COMENTARIO", 
			"COMENTARIO_BLOCO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PortugolPP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PortugolPPParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PortugolPPParser.EOF, 0); }
		public List<DeclaracaoContext> declaracao() {
			return getRuleContexts(DeclaracaoContext.class);
		}
		public DeclaracaoContext declaracao(int i) {
			return getRuleContext(DeclaracaoContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17981414236716748L) != 0)) {
				{
				{
				setState(70);
				declaracao();
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoContext extends ParserRuleContext {
		public DeclaracaoClasseContext declaracaoClasse() {
			return getRuleContext(DeclaracaoClasseContext.class,0);
		}
		public DeclaracaoVarContext declaracaoVar() {
			return getRuleContext(DeclaracaoVarContext.class,0);
		}
		public DeclaracaoFuncaoContext declaracaoFuncao() {
			return getRuleContext(DeclaracaoFuncaoContext.class,0);
		}
		public DeclaracaoSeContext declaracaoSe() {
			return getRuleContext(DeclaracaoSeContext.class,0);
		}
		public ChamadaFuncaoContext chamadaFuncao() {
			return getRuleContext(ChamadaFuncaoContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public DeclaracaoReturnContext declaracaoReturn() {
			return getRuleContext(DeclaracaoReturnContext.class,0);
		}
		public DeclaracaoEnquantoContext declaracaoEnquanto() {
			return getRuleContext(DeclaracaoEnquantoContext.class,0);
		}
		public DeclaracaoParaContext declaracaoPara() {
			return getRuleContext(DeclaracaoParaContext.class,0);
		}
		public DeclaracaoFacaEnquantoContext declaracaoFacaEnquanto() {
			return getRuleContext(DeclaracaoFacaEnquantoContext.class,0);
		}
		public DeclaracaoQuebraContext declaracaoQuebra() {
			return getRuleContext(DeclaracaoQuebraContext.class,0);
		}
		public DeclaracaoContinueContext declaracaoContinue() {
			return getRuleContext(DeclaracaoContinueContext.class,0);
		}
		public DeclaracaoInterfaceContext declaracaoInterface() {
			return getRuleContext(DeclaracaoInterfaceContext.class,0);
		}
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracao);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				declaracaoClasse();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				declaracaoVar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				declaracaoFuncao();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				declaracaoSe();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				chamadaFuncao();
				setState(83);
				match(T__0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(85);
				bloco();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(86);
				expressao();
				setState(87);
				match(T__0);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(89);
				declaracaoReturn();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(90);
				declaracaoEnquanto();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(91);
				declaracaoPara();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(92);
				declaracaoFacaEnquanto();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(93);
				declaracaoQuebra();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(94);
				declaracaoContinue();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(95);
				declaracaoInterface();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssinaturaMetodoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PortugolPPParser.ID, 0); }
		public ListaParamsContext listaParams() {
			return getRuleContext(ListaParamsContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public AssinaturaMetodoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assinaturaMetodo; }
	}

	public final AssinaturaMetodoContext assinaturaMetodo() throws RecognitionException {
		AssinaturaMetodoContext _localctx = new AssinaturaMetodoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assinaturaMetodo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__1);
			setState(99);
			match(ID);
			setState(100);
			match(T__2);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(101);
				listaParams();
				}
			}

			setState(104);
			match(T__3);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(105);
				match(T__4);
				setState(106);
				tipo();
				}
			}

			setState(109);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoInterfaceContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PortugolPPParser.ID, 0); }
		public List<AssinaturaMetodoContext> assinaturaMetodo() {
			return getRuleContexts(AssinaturaMetodoContext.class);
		}
		public AssinaturaMetodoContext assinaturaMetodo(int i) {
			return getRuleContext(AssinaturaMetodoContext.class,i);
		}
		public DeclaracaoInterfaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoInterface; }
	}

	public final DeclaracaoInterfaceContext declaracaoInterface() throws RecognitionException {
		DeclaracaoInterfaceContext _localctx = new DeclaracaoInterfaceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracaoInterface);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__5);
			setState(112);
			match(ID);
			setState(113);
			match(T__6);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(114);
				assinaturaMetodo();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoQuebraContext extends ParserRuleContext {
		public DeclaracaoQuebraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoQuebra; }
	}

	public final DeclaracaoQuebraContext declaracaoQuebra() throws RecognitionException {
		DeclaracaoQuebraContext _localctx = new DeclaracaoQuebraContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaracaoQuebra);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(T__8);
			setState(123);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoContinueContext extends ParserRuleContext {
		public DeclaracaoContinueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoContinue; }
	}

	public final DeclaracaoContinueContext declaracaoContinue() throws RecognitionException {
		DeclaracaoContinueContext _localctx = new DeclaracaoContinueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaracaoContinue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__9);
			setState(126);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoFacaEnquantoContext extends ParserRuleContext {
		public DeclaracaoContext declaracao() {
			return getRuleContext(DeclaracaoContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public DeclaracaoFacaEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoFacaEnquanto; }
	}

	public final DeclaracaoFacaEnquantoContext declaracaoFacaEnquanto() throws RecognitionException {
		DeclaracaoFacaEnquantoContext _localctx = new DeclaracaoFacaEnquantoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaracaoFacaEnquanto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(T__10);
			setState(129);
			declaracao();
			setState(130);
			match(T__11);
			setState(131);
			match(T__2);
			setState(132);
			expressao();
			setState(133);
			match(T__3);
			setState(134);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoParaContext extends ParserRuleContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public DeclaracaoContext declaracao() {
			return getRuleContext(DeclaracaoContext.class,0);
		}
		public DeclaracaoVarContext declaracaoVar() {
			return getRuleContext(DeclaracaoVarContext.class,0);
		}
		public DeclaracaoParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoPara; }
	}

	public final DeclaracaoParaContext declaracaoPara() throws RecognitionException {
		DeclaracaoParaContext _localctx = new DeclaracaoParaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaracaoPara);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__12);
			setState(137);
			match(T__2);
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				{
				setState(138);
				declaracaoVar();
				}
				break;
			case T__2:
			case T__29:
			case T__40:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case ID:
			case NUMERO:
			case TEXTO_LITERAL:
				{
				setState(139);
				expressao();
				setState(140);
				match(T__0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(144);
			expressao();
			setState(145);
			match(T__0);
			setState(146);
			expressao();
			setState(147);
			match(T__3);
			setState(148);
			declaracao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoEnquantoContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public DeclaracaoContext declaracao() {
			return getRuleContext(DeclaracaoContext.class,0);
		}
		public DeclaracaoEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoEnquanto; }
	}

	public final DeclaracaoEnquantoContext declaracaoEnquanto() throws RecognitionException {
		DeclaracaoEnquantoContext _localctx = new DeclaracaoEnquantoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaracaoEnquanto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__11);
			setState(151);
			match(T__2);
			setState(152);
			expressao();
			setState(153);
			match(T__3);
			setState(154);
			declaracao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoSeContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public List<DeclaracaoContext> declaracao() {
			return getRuleContexts(DeclaracaoContext.class);
		}
		public DeclaracaoContext declaracao(int i) {
			return getRuleContext(DeclaracaoContext.class,i);
		}
		public DeclaracaoSeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoSe; }
	}

	public final DeclaracaoSeContext declaracaoSe() throws RecognitionException {
		DeclaracaoSeContext _localctx = new DeclaracaoSeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_declaracaoSe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__13);
			setState(157);
			match(T__2);
			setState(158);
			expressao();
			setState(159);
			match(T__3);
			setState(160);
			declaracao();
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(161);
				match(T__14);
				setState(162);
				declaracao();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoReturnContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public DeclaracaoReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoReturn; }
	}

	public final DeclaracaoReturnContext declaracaoReturn() throws RecognitionException {
		DeclaracaoReturnContext _localctx = new DeclaracaoReturnContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_declaracaoReturn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(T__15);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17981414234390536L) != 0)) {
				{
				setState(166);
				expressao();
				}
			}

			setState(169);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoClasseContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PortugolPPParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PortugolPPParser.ID, i);
		}
		public List<DeclaracaoVarContext> declaracaoVar() {
			return getRuleContexts(DeclaracaoVarContext.class);
		}
		public DeclaracaoVarContext declaracaoVar(int i) {
			return getRuleContext(DeclaracaoVarContext.class,i);
		}
		public List<DeclaracaoFuncaoContext> declaracaoFuncao() {
			return getRuleContexts(DeclaracaoFuncaoContext.class);
		}
		public DeclaracaoFuncaoContext declaracaoFuncao(int i) {
			return getRuleContext(DeclaracaoFuncaoContext.class,i);
		}
		public DeclaracaoClasseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoClasse; }
	}

	public final DeclaracaoClasseContext declaracaoClasse() throws RecognitionException {
		DeclaracaoClasseContext _localctx = new DeclaracaoClasseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_declaracaoClasse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__16);
			setState(172);
			match(ID);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(173);
				match(T__17);
				setState(174);
				match(ID);
				}
			}

			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(177);
				match(T__18);
				setState(178);
				match(ID);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__19) {
					{
					{
					setState(179);
					match(T__19);
					setState(180);
					match(ID);
					}
					}
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(188);
			match(T__6);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==T__20) {
				{
				setState(191);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__20:
					{
					setState(189);
					declaracaoVar();
					}
					break;
				case T__1:
					{
					setState(190);
					declaracaoFuncao();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(196);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoVarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PortugolPPParser.ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public DeclaracaoVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoVar; }
	}

	public final DeclaracaoVarContext declaracaoVar() throws RecognitionException {
		DeclaracaoVarContext _localctx = new DeclaracaoVarContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declaracaoVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(T__20);
			setState(199);
			match(ID);
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(200);
				match(T__4);
				setState(201);
				tipo();
				}
			}

			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(204);
				match(T__21);
				setState(205);
				expressao();
				}
			}

			setState(208);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoFuncaoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PortugolPPParser.ID, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ListaParamsContext listaParams() {
			return getRuleContext(ListaParamsContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public DeclaracaoFuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoFuncao; }
	}

	public final DeclaracaoFuncaoContext declaracaoFuncao() throws RecognitionException {
		DeclaracaoFuncaoContext _localctx = new DeclaracaoFuncaoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_declaracaoFuncao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__1);
			setState(211);
			match(ID);
			setState(212);
			match(T__2);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(213);
				listaParams();
				}
			}

			setState(216);
			match(T__3);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(217);
				match(T__4);
				setState(218);
				tipo();
				}
			}

			setState(221);
			bloco();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListaParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ListaParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaParams; }
	}

	public final ListaParamsContext listaParams() throws RecognitionException {
		ListaParamsContext _localctx = new ListaParamsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_listaParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			param();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(224);
				match(T__19);
				setState(225);
				param();
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PortugolPPParser.ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(ID);
			setState(232);
			match(T__4);
			setState(233);
			tipo();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PortugolPPParser.ID, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2251800342167552L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoContext extends ParserRuleContext {
		public List<DeclaracaoContext> declaracao() {
			return getRuleContexts(DeclaracaoContext.class);
		}
		public DeclaracaoContext declaracao(int i) {
			return getRuleContext(DeclaracaoContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(T__6);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17981414236716748L) != 0)) {
				{
				{
				setState(238);
				declaracao();
				}
				}
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(244);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoContext extends ParserRuleContext {
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expressao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			atribuicao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtribuicaoContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode ID() { return getToken(PortugolPPParser.ID, 0); }
		public AcessoContext acesso() {
			return getRuleContext(AcessoContext.class,0);
		}
		public AcessoArrayContext acessoArray() {
			return getRuleContext(AcessoArrayContext.class,0);
		}
		public LogicaOuContext logicaOu() {
			return getRuleContext(LogicaOuContext.class,0);
		}
		public AtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao; }
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_atribuicao);
		try {
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(248);
					match(ID);
					}
					break;
				case 2:
					{
					setState(249);
					acesso();
					}
					break;
				case 3:
					{
					setState(250);
					acessoArray();
					}
					break;
				}
				setState(253);
				match(T__21);
				setState(254);
				expressao();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				logicaOu();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AcessoContext extends ParserRuleContext {
		public PrimarioContext primario() {
			return getRuleContext(PrimarioContext.class,0);
		}
		public TerminalNode ID() { return getToken(PortugolPPParser.ID, 0); }
		public AcessoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acesso; }
	}

	public final AcessoContext acesso() throws RecognitionException {
		AcessoContext _localctx = new AcessoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_acesso);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			primario();
			setState(259);
			match(T__28);
			setState(260);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AcessoArrayContext extends ParserRuleContext {
		public PrimarioContext primario() {
			return getRuleContext(PrimarioContext.class,0);
		}
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public AcessoArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acessoArray; }
	}

	public final AcessoArrayContext acessoArray() throws RecognitionException {
		AcessoArrayContext _localctx = new AcessoArrayContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_acessoArray);
		try {
			setState(275);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				primario();
				setState(263);
				match(T__29);
				setState(264);
				expressao();
				setState(265);
				match(T__30);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				primario();
				setState(268);
				match(T__29);
				setState(269);
				expressao();
				setState(270);
				match(T__30);
				setState(271);
				match(T__29);
				setState(272);
				expressao();
				setState(273);
				match(T__30);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicaOuContext extends ParserRuleContext {
		public List<LogicaEContext> logicaE() {
			return getRuleContexts(LogicaEContext.class);
		}
		public LogicaEContext logicaE(int i) {
			return getRuleContext(LogicaEContext.class,i);
		}
		public LogicaOuContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicaOu; }
	}

	public final LogicaOuContext logicaOu() throws RecognitionException {
		LogicaOuContext _localctx = new LogicaOuContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_logicaOu);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			logicaE();
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__31) {
				{
				{
				setState(278);
				match(T__31);
				setState(279);
				logicaE();
				}
				}
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicaEContext extends ParserRuleContext {
		public List<IgualdadeContext> igualdade() {
			return getRuleContexts(IgualdadeContext.class);
		}
		public IgualdadeContext igualdade(int i) {
			return getRuleContext(IgualdadeContext.class,i);
		}
		public LogicaEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicaE; }
	}

	public final LogicaEContext logicaE() throws RecognitionException {
		LogicaEContext _localctx = new LogicaEContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_logicaE);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			igualdade();
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__32) {
				{
				{
				setState(286);
				match(T__32);
				setState(287);
				igualdade();
				}
				}
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IgualdadeContext extends ParserRuleContext {
		public List<ComparacaoContext> comparacao() {
			return getRuleContexts(ComparacaoContext.class);
		}
		public ComparacaoContext comparacao(int i) {
			return getRuleContext(ComparacaoContext.class,i);
		}
		public IgualdadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_igualdade; }
	}

	public final IgualdadeContext igualdade() throws RecognitionException {
		IgualdadeContext _localctx = new IgualdadeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_igualdade);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			comparacao();
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__33 || _la==T__34) {
				{
				{
				setState(294);
				_la = _input.LA(1);
				if ( !(_la==T__33 || _la==T__34) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(295);
				comparacao();
				}
				}
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparacaoContext extends ParserRuleContext {
		public List<AdicaoContext> adicao() {
			return getRuleContexts(AdicaoContext.class);
		}
		public AdicaoContext adicao(int i) {
			return getRuleContext(AdicaoContext.class,i);
		}
		public ComparacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparacao; }
	}

	public final ComparacaoContext comparacao() throws RecognitionException {
		ComparacaoContext _localctx = new ComparacaoContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_comparacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			adicao();
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1030792151040L) != 0)) {
				{
				{
				setState(302);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1030792151040L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(303);
				adicao();
				}
				}
				setState(308);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdicaoContext extends ParserRuleContext {
		public List<MultiplicacaoContext> multiplicacao() {
			return getRuleContexts(MultiplicacaoContext.class);
		}
		public MultiplicacaoContext multiplicacao(int i) {
			return getRuleContext(MultiplicacaoContext.class,i);
		}
		public AdicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_adicao; }
	}

	public final AdicaoContext adicao() throws RecognitionException {
		AdicaoContext _localctx = new AdicaoContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_adicao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			multiplicacao();
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__39 || _la==T__40) {
				{
				{
				setState(310);
				_la = _input.LA(1);
				if ( !(_la==T__39 || _la==T__40) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(311);
				multiplicacao();
				}
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicacaoContext extends ParserRuleContext {
		public List<UnarioContext> unario() {
			return getRuleContexts(UnarioContext.class);
		}
		public UnarioContext unario(int i) {
			return getRuleContext(UnarioContext.class,i);
		}
		public MultiplicacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicacao; }
	}

	public final MultiplicacaoContext multiplicacao() throws RecognitionException {
		MultiplicacaoContext _localctx = new MultiplicacaoContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_multiplicacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			unario();
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30786325577728L) != 0)) {
				{
				{
				setState(318);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30786325577728L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(319);
				unario();
				}
				}
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnarioContext extends ParserRuleContext {
		public UnarioContext unario() {
			return getRuleContext(UnarioContext.class,0);
		}
		public ChamadaContext chamada() {
			return getRuleContext(ChamadaContext.class,0);
		}
		public UnarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unario; }
	}

	public final UnarioContext unario() throws RecognitionException {
		UnarioContext _localctx = new UnarioContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_unario);
		int _la;
		try {
			setState(328);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__40:
			case T__44:
				enterOuterAlt(_localctx, 1);
				{
				setState(325);
				_la = _input.LA(1);
				if ( !(_la==T__40 || _la==T__44) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(326);
				unario();
				}
				break;
			case T__2:
			case T__29:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case ID:
			case NUMERO:
			case TEXTO_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(327);
				chamada();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChamadaContext extends ParserRuleContext {
		public PrimarioContext primario() {
			return getRuleContext(PrimarioContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(PortugolPPParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PortugolPPParser.ID, i);
		}
		public List<ArgumentosContext> argumentos() {
			return getRuleContexts(ArgumentosContext.class);
		}
		public ArgumentosContext argumentos(int i) {
			return getRuleContext(ArgumentosContext.class,i);
		}
		public AcessoArrayContext acessoArray() {
			return getRuleContext(AcessoArrayContext.class,0);
		}
		public ChamadaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamada; }
	}

	public final ChamadaContext chamada() throws RecognitionException {
		ChamadaContext _localctx = new ChamadaContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_chamada);
		int _la;
		try {
			setState(346);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(330);
				primario();
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__28) {
					{
					{
					setState(331);
					match(T__28);
					setState(332);
					match(ID);
					setState(338);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(333);
						match(T__2);
						setState(335);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17981414234390536L) != 0)) {
							{
							setState(334);
							argumentos();
							}
						}

						setState(337);
						match(T__3);
						}
					}

					}
					}
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(345);
				acessoArray();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChamadaFuncaoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PortugolPPParser.ID, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public PrimarioContext primario() {
			return getRuleContext(PrimarioContext.class,0);
		}
		public ChamadaFuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamadaFuncao; }
	}

	public final ChamadaFuncaoContext chamadaFuncao() throws RecognitionException {
		ChamadaFuncaoContext _localctx = new ChamadaFuncaoContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_chamadaFuncao);
		int _la;
		try {
			setState(363);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				match(ID);
				setState(349);
				match(T__2);
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17981414234390536L) != 0)) {
					{
					setState(350);
					argumentos();
					}
				}

				setState(353);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(354);
				primario();
				setState(355);
				match(T__28);
				setState(356);
				match(ID);
				setState(357);
				match(T__2);
				setState(359);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17981414234390536L) != 0)) {
					{
					setState(358);
					argumentos();
					}
				}

				setState(361);
				match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentosContext extends ParserRuleContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			expressao();
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(366);
				match(T__19);
				setState(367);
				expressao();
				}
				}
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimarioContext extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(PortugolPPParser.NUMERO, 0); }
		public TerminalNode TEXTO_LITERAL() { return getToken(PortugolPPParser.TEXTO_LITERAL, 0); }
		public TerminalNode ID() { return getToken(PortugolPPParser.ID, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ListaLiteralContext listaLiteral() {
			return getRuleContext(ListaLiteralContext.class,0);
		}
		public MapaLiteralContext mapaLiteral() {
			return getRuleContext(MapaLiteralContext.class,0);
		}
		public PrimarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primario; }
	}

	public final PrimarioContext primario() throws RecognitionException {
		PrimarioContext _localctx = new PrimarioContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_primario);
		int _la;
		try {
			setState(399);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__45:
				enterOuterAlt(_localctx, 1);
				{
				setState(373);
				match(T__45);
				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 2);
				{
				setState(374);
				match(T__46);
				}
				break;
			case NUMERO:
				enterOuterAlt(_localctx, 3);
				{
				setState(375);
				match(NUMERO);
				}
				break;
			case TEXTO_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(376);
				match(TEXTO_LITERAL);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(377);
				match(ID);
				setState(383);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(378);
					match(T__2);
					setState(380);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17981414234390536L) != 0)) {
						{
						setState(379);
						argumentos();
						}
					}

					setState(382);
					match(T__3);
					}
				}

				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 6);
				{
				setState(385);
				match(T__47);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 7);
				{
				setState(386);
				match(T__2);
				setState(387);
				expressao();
				setState(388);
				match(T__3);
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 8);
				{
				setState(390);
				match(T__48);
				setState(391);
				match(ID);
				setState(392);
				match(T__2);
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17981414234390536L) != 0)) {
					{
					setState(393);
					argumentos();
					}
				}

				setState(396);
				match(T__3);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 9);
				{
				setState(397);
				listaLiteral();
				}
				break;
			case T__49:
				enterOuterAlt(_localctx, 10);
				{
				setState(398);
				mapaLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListaLiteralContext extends ParserRuleContext {
		public ListaLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaLiteral; }
	}

	public final ListaLiteralContext listaLiteral() throws RecognitionException {
		ListaLiteralContext _localctx = new ListaLiteralContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_listaLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			match(T__29);
			setState(402);
			match(T__30);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MapaLiteralContext extends ParserRuleContext {
		public MapaLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapaLiteral; }
	}

	public final MapaLiteralContext mapaLiteral() throws RecognitionException {
		MapaLiteralContext _localctx = new MapaLiteralContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_mapaLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			match(T__49);
			setState(405);
			match(T__30);
			setState(406);
			match(T__30);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00018\u0199\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0001"+
		"\u0000\u0005\u0000H\b\u0000\n\u0000\f\u0000K\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001a\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002g\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002l\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003t\b\u0003\n\u0003\f\u0003w\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u008f\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\t\u00a4\b\t\u0001\n\u0001\n\u0003\n\u00a8"+
		"\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00b0\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u00b6\b\u000b\n\u000b\f\u000b\u00b9\t\u000b\u0003\u000b\u00bb\b"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00c0\b\u000b\n"+
		"\u000b\f\u000b\u00c3\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u00cb\b\f\u0001\f\u0001\f\u0003\f\u00cf\b\f\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00d7\b\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u00dc\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u00e3\b\u000e\n\u000e\f\u000e\u00e6\t\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0005\u0011\u00f0\b\u0011\n\u0011\f\u0011\u00f3\t\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u00fc\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u0101\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0003\u0015\u0114\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005"+
		"\u0016\u0119\b\u0016\n\u0016\f\u0016\u011c\t\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0005\u0017\u0121\b\u0017\n\u0017\f\u0017\u0124\t\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u0129\b\u0018\n\u0018\f\u0018"+
		"\u012c\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0131\b"+
		"\u0019\n\u0019\f\u0019\u0134\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0005\u001a\u0139\b\u001a\n\u001a\f\u001a\u013c\t\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0005\u001b\u0141\b\u001b\n\u001b\f\u001b\u0144\t\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0149\b\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u0150\b\u001d"+
		"\u0001\u001d\u0003\u001d\u0153\b\u001d\u0005\u001d\u0155\b\u001d\n\u001d"+
		"\f\u001d\u0158\t\u001d\u0001\u001d\u0003\u001d\u015b\b\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0003\u001e\u0160\b\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u0168\b\u001e"+
		"\u0001\u001e\u0001\u001e\u0003\u001e\u016c\b\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0005\u001f\u0171\b\u001f\n\u001f\f\u001f\u0174\t\u001f\u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u017d\b \u0001 \u0003"+
		" \u0180\b \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0003 \u018b\b \u0001 \u0001 \u0001 \u0003 \u0190\b \u0001!\u0001!\u0001"+
		"!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0000\u0000#\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.02468:<>@BD\u0000\u0006\u0002\u0000\u0017\u001c33\u0001\u0000\""+
		"#\u0001\u0000$\'\u0001\u0000()\u0001\u0000*,\u0002\u0000))--\u01b3\u0000"+
		"I\u0001\u0000\u0000\u0000\u0002`\u0001\u0000\u0000\u0000\u0004b\u0001"+
		"\u0000\u0000\u0000\u0006o\u0001\u0000\u0000\u0000\bz\u0001\u0000\u0000"+
		"\u0000\n}\u0001\u0000\u0000\u0000\f\u0080\u0001\u0000\u0000\u0000\u000e"+
		"\u0088\u0001\u0000\u0000\u0000\u0010\u0096\u0001\u0000\u0000\u0000\u0012"+
		"\u009c\u0001\u0000\u0000\u0000\u0014\u00a5\u0001\u0000\u0000\u0000\u0016"+
		"\u00ab\u0001\u0000\u0000\u0000\u0018\u00c6\u0001\u0000\u0000\u0000\u001a"+
		"\u00d2\u0001\u0000\u0000\u0000\u001c\u00df\u0001\u0000\u0000\u0000\u001e"+
		"\u00e7\u0001\u0000\u0000\u0000 \u00eb\u0001\u0000\u0000\u0000\"\u00ed"+
		"\u0001\u0000\u0000\u0000$\u00f6\u0001\u0000\u0000\u0000&\u0100\u0001\u0000"+
		"\u0000\u0000(\u0102\u0001\u0000\u0000\u0000*\u0113\u0001\u0000\u0000\u0000"+
		",\u0115\u0001\u0000\u0000\u0000.\u011d\u0001\u0000\u0000\u00000\u0125"+
		"\u0001\u0000\u0000\u00002\u012d\u0001\u0000\u0000\u00004\u0135\u0001\u0000"+
		"\u0000\u00006\u013d\u0001\u0000\u0000\u00008\u0148\u0001\u0000\u0000\u0000"+
		":\u015a\u0001\u0000\u0000\u0000<\u016b\u0001\u0000\u0000\u0000>\u016d"+
		"\u0001\u0000\u0000\u0000@\u018f\u0001\u0000\u0000\u0000B\u0191\u0001\u0000"+
		"\u0000\u0000D\u0194\u0001\u0000\u0000\u0000FH\u0003\u0002\u0001\u0000"+
		"GF\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000"+
		"\u0000IJ\u0001\u0000\u0000\u0000JL\u0001\u0000\u0000\u0000KI\u0001\u0000"+
		"\u0000\u0000LM\u0005\u0000\u0000\u0001M\u0001\u0001\u0000\u0000\u0000"+
		"Na\u0003\u0016\u000b\u0000Oa\u0003\u0018\f\u0000Pa\u0003\u001a\r\u0000"+
		"Qa\u0003\u0012\t\u0000RS\u0003<\u001e\u0000ST\u0005\u0001\u0000\u0000"+
		"Ta\u0001\u0000\u0000\u0000Ua\u0003\"\u0011\u0000VW\u0003$\u0012\u0000"+
		"WX\u0005\u0001\u0000\u0000Xa\u0001\u0000\u0000\u0000Ya\u0003\u0014\n\u0000"+
		"Za\u0003\u0010\b\u0000[a\u0003\u000e\u0007\u0000\\a\u0003\f\u0006\u0000"+
		"]a\u0003\b\u0004\u0000^a\u0003\n\u0005\u0000_a\u0003\u0006\u0003\u0000"+
		"`N\u0001\u0000\u0000\u0000`O\u0001\u0000\u0000\u0000`P\u0001\u0000\u0000"+
		"\u0000`Q\u0001\u0000\u0000\u0000`R\u0001\u0000\u0000\u0000`U\u0001\u0000"+
		"\u0000\u0000`V\u0001\u0000\u0000\u0000`Y\u0001\u0000\u0000\u0000`Z\u0001"+
		"\u0000\u0000\u0000`[\u0001\u0000\u0000\u0000`\\\u0001\u0000\u0000\u0000"+
		"`]\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`_\u0001\u0000\u0000"+
		"\u0000a\u0003\u0001\u0000\u0000\u0000bc\u0005\u0002\u0000\u0000cd\u0005"+
		"3\u0000\u0000df\u0005\u0003\u0000\u0000eg\u0003\u001c\u000e\u0000fe\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000"+
		"hk\u0005\u0004\u0000\u0000ij\u0005\u0005\u0000\u0000jl\u0003 \u0010\u0000"+
		"ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000"+
		"\u0000mn\u0005\u0001\u0000\u0000n\u0005\u0001\u0000\u0000\u0000op\u0005"+
		"\u0006\u0000\u0000pq\u00053\u0000\u0000qu\u0005\u0007\u0000\u0000rt\u0003"+
		"\u0004\u0002\u0000sr\u0001\u0000\u0000\u0000tw\u0001\u0000\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vx\u0001\u0000\u0000"+
		"\u0000wu\u0001\u0000\u0000\u0000xy\u0005\b\u0000\u0000y\u0007\u0001\u0000"+
		"\u0000\u0000z{\u0005\t\u0000\u0000{|\u0005\u0001\u0000\u0000|\t\u0001"+
		"\u0000\u0000\u0000}~\u0005\n\u0000\u0000~\u007f\u0005\u0001\u0000\u0000"+
		"\u007f\u000b\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u000b\u0000\u0000"+
		"\u0081\u0082\u0003\u0002\u0001\u0000\u0082\u0083\u0005\f\u0000\u0000\u0083"+
		"\u0084\u0005\u0003\u0000\u0000\u0084\u0085\u0003$\u0012\u0000\u0085\u0086"+
		"\u0005\u0004\u0000\u0000\u0086\u0087\u0005\u0001\u0000\u0000\u0087\r\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0005\r\u0000\u0000\u0089\u008e\u0005\u0003"+
		"\u0000\u0000\u008a\u008f\u0003\u0018\f\u0000\u008b\u008c\u0003$\u0012"+
		"\u0000\u008c\u008d\u0005\u0001\u0000\u0000\u008d\u008f\u0001\u0000\u0000"+
		"\u0000\u008e\u008a\u0001\u0000\u0000\u0000\u008e\u008b\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0003$\u0012\u0000"+
		"\u0091\u0092\u0005\u0001\u0000\u0000\u0092\u0093\u0003$\u0012\u0000\u0093"+
		"\u0094\u0005\u0004\u0000\u0000\u0094\u0095\u0003\u0002\u0001\u0000\u0095"+
		"\u000f\u0001\u0000\u0000\u0000\u0096\u0097\u0005\f\u0000\u0000\u0097\u0098"+
		"\u0005\u0003\u0000\u0000\u0098\u0099\u0003$\u0012\u0000\u0099\u009a\u0005"+
		"\u0004\u0000\u0000\u009a\u009b\u0003\u0002\u0001\u0000\u009b\u0011\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0005\u000e\u0000\u0000\u009d\u009e\u0005"+
		"\u0003\u0000\u0000\u009e\u009f\u0003$\u0012\u0000\u009f\u00a0\u0005\u0004"+
		"\u0000\u0000\u00a0\u00a3\u0003\u0002\u0001\u0000\u00a1\u00a2\u0005\u000f"+
		"\u0000\u0000\u00a2\u00a4\u0003\u0002\u0001\u0000\u00a3\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u0013\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a7\u0005\u0010\u0000\u0000\u00a6\u00a8\u0003$\u0012"+
		"\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\u0001\u0000"+
		"\u0000\u00aa\u0015\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\u0011\u0000"+
		"\u0000\u00ac\u00af\u00053\u0000\u0000\u00ad\u00ae\u0005\u0012\u0000\u0000"+
		"\u00ae\u00b0\u00053\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af"+
		"\u00b0\u0001\u0000\u0000\u0000\u00b0\u00ba\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0005\u0013\u0000\u0000\u00b2\u00b7\u00053\u0000\u0000\u00b3\u00b4"+
		"\u0005\u0014\u0000\u0000\u00b4\u00b6\u00053\u0000\u0000\u00b5\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001"+
		"\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00b1\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001"+
		"\u0000\u0000\u0000\u00bc\u00c1\u0005\u0007\u0000\u0000\u00bd\u00c0\u0003"+
		"\u0018\f\u0000\u00be\u00c0\u0003\u001a\r\u0000\u00bf\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c4\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c5\u0005\b\u0000\u0000\u00c5\u0017\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c7\u0005\u0015\u0000\u0000\u00c7\u00ca\u00053\u0000\u0000"+
		"\u00c8\u00c9\u0005\u0005\u0000\u0000\u00c9\u00cb\u0003 \u0010\u0000\u00ca"+
		"\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb"+
		"\u00ce\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005\u0016\u0000\u0000\u00cd"+
		"\u00cf\u0003$\u0012\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d1"+
		"\u0005\u0001\u0000\u0000\u00d1\u0019\u0001\u0000\u0000\u0000\u00d2\u00d3"+
		"\u0005\u0002\u0000\u0000\u00d3\u00d4\u00053\u0000\u0000\u00d4\u00d6\u0005"+
		"\u0003\u0000\u0000\u00d5\u00d7\u0003\u001c\u000e\u0000\u00d6\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001"+
		"\u0000\u0000\u0000\u00d8\u00db\u0005\u0004\u0000\u0000\u00d9\u00da\u0005"+
		"\u0005\u0000\u0000\u00da\u00dc\u0003 \u0010\u0000\u00db\u00d9\u0001\u0000"+
		"\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000"+
		"\u0000\u0000\u00dd\u00de\u0003\"\u0011\u0000\u00de\u001b\u0001\u0000\u0000"+
		"\u0000\u00df\u00e4\u0003\u001e\u000f\u0000\u00e0\u00e1\u0005\u0014\u0000"+
		"\u0000\u00e1\u00e3\u0003\u001e\u000f\u0000\u00e2\u00e0\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e6\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u001d\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e7\u00e8\u00053\u0000\u0000"+
		"\u00e8\u00e9\u0005\u0005\u0000\u0000\u00e9\u00ea\u0003 \u0010\u0000\u00ea"+
		"\u001f\u0001\u0000\u0000\u0000\u00eb\u00ec\u0007\u0000\u0000\u0000\u00ec"+
		"!\u0001\u0000\u0000\u0000\u00ed\u00f1\u0005\u0007\u0000\u0000\u00ee\u00f0"+
		"\u0003\u0002\u0001\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000\u00f0\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f4\u0001\u0000\u0000\u0000\u00f3\u00f1"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005\b\u0000\u0000\u00f5#\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f7\u0003&\u0013\u0000\u00f7%\u0001\u0000\u0000"+
		"\u0000\u00f8\u00fc\u00053\u0000\u0000\u00f9\u00fc\u0003(\u0014\u0000\u00fa"+
		"\u00fc\u0003*\u0015\u0000\u00fb\u00f8\u0001\u0000\u0000\u0000\u00fb\u00f9"+
		"\u0001\u0000\u0000\u0000\u00fb\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd"+
		"\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005\u0016\u0000\u0000\u00fe\u0101"+
		"\u0003$\u0012\u0000\u00ff\u0101\u0003,\u0016\u0000\u0100\u00fb\u0001\u0000"+
		"\u0000\u0000\u0100\u00ff\u0001\u0000\u0000\u0000\u0101\'\u0001\u0000\u0000"+
		"\u0000\u0102\u0103\u0003@ \u0000\u0103\u0104\u0005\u001d\u0000\u0000\u0104"+
		"\u0105\u00053\u0000\u0000\u0105)\u0001\u0000\u0000\u0000\u0106\u0107\u0003"+
		"@ \u0000\u0107\u0108\u0005\u001e\u0000\u0000\u0108\u0109\u0003$\u0012"+
		"\u0000\u0109\u010a\u0005\u001f\u0000\u0000\u010a\u0114\u0001\u0000\u0000"+
		"\u0000\u010b\u010c\u0003@ \u0000\u010c\u010d\u0005\u001e\u0000\u0000\u010d"+
		"\u010e\u0003$\u0012\u0000\u010e\u010f\u0005\u001f\u0000\u0000\u010f\u0110"+
		"\u0005\u001e\u0000\u0000\u0110\u0111\u0003$\u0012\u0000\u0111\u0112\u0005"+
		"\u001f\u0000\u0000\u0112\u0114\u0001\u0000\u0000\u0000\u0113\u0106\u0001"+
		"\u0000\u0000\u0000\u0113\u010b\u0001\u0000\u0000\u0000\u0114+\u0001\u0000"+
		"\u0000\u0000\u0115\u011a\u0003.\u0017\u0000\u0116\u0117\u0005 \u0000\u0000"+
		"\u0117\u0119\u0003.\u0017\u0000\u0118\u0116\u0001\u0000\u0000\u0000\u0119"+
		"\u011c\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011a"+
		"\u011b\u0001\u0000\u0000\u0000\u011b-\u0001\u0000\u0000\u0000\u011c\u011a"+
		"\u0001\u0000\u0000\u0000\u011d\u0122\u00030\u0018\u0000\u011e\u011f\u0005"+
		"!\u0000\u0000\u011f\u0121\u00030\u0018\u0000\u0120\u011e\u0001\u0000\u0000"+
		"\u0000\u0121\u0124\u0001\u0000\u0000\u0000\u0122\u0120\u0001\u0000\u0000"+
		"\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123/\u0001\u0000\u0000\u0000"+
		"\u0124\u0122\u0001\u0000\u0000\u0000\u0125\u012a\u00032\u0019\u0000\u0126"+
		"\u0127\u0007\u0001\u0000\u0000\u0127\u0129\u00032\u0019\u0000\u0128\u0126"+
		"\u0001\u0000\u0000\u0000\u0129\u012c\u0001\u0000\u0000\u0000\u012a\u0128"+
		"\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b1\u0001"+
		"\u0000\u0000\u0000\u012c\u012a\u0001\u0000\u0000\u0000\u012d\u0132\u0003"+
		"4\u001a\u0000\u012e\u012f\u0007\u0002\u0000\u0000\u012f\u0131\u00034\u001a"+
		"\u0000\u0130\u012e\u0001\u0000\u0000\u0000\u0131\u0134\u0001\u0000\u0000"+
		"\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000\u0000"+
		"\u0000\u01333\u0001\u0000\u0000\u0000\u0134\u0132\u0001\u0000\u0000\u0000"+
		"\u0135\u013a\u00036\u001b\u0000\u0136\u0137\u0007\u0003\u0000\u0000\u0137"+
		"\u0139\u00036\u001b\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0139\u013c"+
		"\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013a\u013b"+
		"\u0001\u0000\u0000\u0000\u013b5\u0001\u0000\u0000\u0000\u013c\u013a\u0001"+
		"\u0000\u0000\u0000\u013d\u0142\u00038\u001c\u0000\u013e\u013f\u0007\u0004"+
		"\u0000\u0000\u013f\u0141\u00038\u001c\u0000\u0140\u013e\u0001\u0000\u0000"+
		"\u0000\u0141\u0144\u0001\u0000\u0000\u0000\u0142\u0140\u0001\u0000\u0000"+
		"\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u01437\u0001\u0000\u0000\u0000"+
		"\u0144\u0142\u0001\u0000\u0000\u0000\u0145\u0146\u0007\u0005\u0000\u0000"+
		"\u0146\u0149\u00038\u001c\u0000\u0147\u0149\u0003:\u001d\u0000\u0148\u0145"+
		"\u0001\u0000\u0000\u0000\u0148\u0147\u0001\u0000\u0000\u0000\u01499\u0001"+
		"\u0000\u0000\u0000\u014a\u0156\u0003@ \u0000\u014b\u014c\u0005\u001d\u0000"+
		"\u0000\u014c\u0152\u00053\u0000\u0000\u014d\u014f\u0005\u0003\u0000\u0000"+
		"\u014e\u0150\u0003>\u001f\u0000\u014f\u014e\u0001\u0000\u0000\u0000\u014f"+
		"\u0150\u0001\u0000\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151"+
		"\u0153\u0005\u0004\u0000\u0000\u0152\u014d\u0001\u0000\u0000\u0000\u0152"+
		"\u0153\u0001\u0000\u0000\u0000\u0153\u0155\u0001\u0000\u0000\u0000\u0154"+
		"\u014b\u0001\u0000\u0000\u0000\u0155\u0158\u0001\u0000\u0000\u0000\u0156"+
		"\u0154\u0001\u0000\u0000\u0000\u0156\u0157\u0001\u0000\u0000\u0000\u0157"+
		"\u015b\u0001\u0000\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0159"+
		"\u015b\u0003*\u0015\u0000\u015a\u014a\u0001\u0000\u0000\u0000\u015a\u0159"+
		"\u0001\u0000\u0000\u0000\u015b;\u0001\u0000\u0000\u0000\u015c\u015d\u0005"+
		"3\u0000\u0000\u015d\u015f\u0005\u0003\u0000\u0000\u015e\u0160\u0003>\u001f"+
		"\u0000\u015f\u015e\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000"+
		"\u0000\u0160\u0161\u0001\u0000\u0000\u0000\u0161\u016c\u0005\u0004\u0000"+
		"\u0000\u0162\u0163\u0003@ \u0000\u0163\u0164\u0005\u001d\u0000\u0000\u0164"+
		"\u0165\u00053\u0000\u0000\u0165\u0167\u0005\u0003\u0000\u0000\u0166\u0168"+
		"\u0003>\u001f\u0000\u0167\u0166\u0001\u0000\u0000\u0000\u0167\u0168\u0001"+
		"\u0000\u0000\u0000\u0168\u0169\u0001\u0000\u0000\u0000\u0169\u016a\u0005"+
		"\u0004\u0000\u0000\u016a\u016c\u0001\u0000\u0000\u0000\u016b\u015c\u0001"+
		"\u0000\u0000\u0000\u016b\u0162\u0001\u0000\u0000\u0000\u016c=\u0001\u0000"+
		"\u0000\u0000\u016d\u0172\u0003$\u0012\u0000\u016e\u016f\u0005\u0014\u0000"+
		"\u0000\u016f\u0171\u0003$\u0012\u0000\u0170\u016e\u0001\u0000\u0000\u0000"+
		"\u0171\u0174\u0001\u0000\u0000\u0000\u0172\u0170\u0001\u0000\u0000\u0000"+
		"\u0172\u0173\u0001\u0000\u0000\u0000\u0173?\u0001\u0000\u0000\u0000\u0174"+
		"\u0172\u0001\u0000\u0000\u0000\u0175\u0190\u0005.\u0000\u0000\u0176\u0190"+
		"\u0005/\u0000\u0000\u0177\u0190\u00054\u0000\u0000\u0178\u0190\u00055"+
		"\u0000\u0000\u0179\u017f\u00053\u0000\u0000\u017a\u017c\u0005\u0003\u0000"+
		"\u0000\u017b\u017d\u0003>\u001f\u0000\u017c\u017b\u0001\u0000\u0000\u0000"+
		"\u017c\u017d\u0001\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000"+
		"\u017e\u0180\u0005\u0004\u0000\u0000\u017f\u017a\u0001\u0000\u0000\u0000"+
		"\u017f\u0180\u0001\u0000\u0000\u0000\u0180\u0190\u0001\u0000\u0000\u0000"+
		"\u0181\u0190\u00050\u0000\u0000\u0182\u0183\u0005\u0003\u0000\u0000\u0183"+
		"\u0184\u0003$\u0012\u0000\u0184\u0185\u0005\u0004\u0000\u0000\u0185\u0190"+
		"\u0001\u0000\u0000\u0000\u0186\u0187\u00051\u0000\u0000\u0187\u0188\u0005"+
		"3\u0000\u0000\u0188\u018a\u0005\u0003\u0000\u0000\u0189\u018b\u0003>\u001f"+
		"\u0000\u018a\u0189\u0001\u0000\u0000\u0000\u018a\u018b\u0001\u0000\u0000"+
		"\u0000\u018b\u018c\u0001\u0000\u0000\u0000\u018c\u0190\u0005\u0004\u0000"+
		"\u0000\u018d\u0190\u0003B!\u0000\u018e\u0190\u0003D\"\u0000\u018f\u0175"+
		"\u0001\u0000\u0000\u0000\u018f\u0176\u0001\u0000\u0000\u0000\u018f\u0177"+
		"\u0001\u0000\u0000\u0000\u018f\u0178\u0001\u0000\u0000\u0000\u018f\u0179"+
		"\u0001\u0000\u0000\u0000\u018f\u0181\u0001\u0000\u0000\u0000\u018f\u0182"+
		"\u0001\u0000\u0000\u0000\u018f\u0186\u0001\u0000\u0000\u0000\u018f\u018d"+
		"\u0001\u0000\u0000\u0000\u018f\u018e\u0001\u0000\u0000\u0000\u0190A\u0001"+
		"\u0000\u0000\u0000\u0191\u0192\u0005\u001e\u0000\u0000\u0192\u0193\u0005"+
		"\u001f\u0000\u0000\u0193C\u0001\u0000\u0000\u0000\u0194\u0195\u00052\u0000"+
		"\u0000\u0195\u0196\u0005\u001f\u0000\u0000\u0196\u0197\u0005\u001f\u0000"+
		"\u0000\u0197E\u0001\u0000\u0000\u0000)I`fku\u008e\u00a3\u00a7\u00af\u00b7"+
		"\u00ba\u00bf\u00c1\u00ca\u00ce\u00d6\u00db\u00e4\u00f1\u00fb\u0100\u0113"+
		"\u011a\u0122\u012a\u0132\u013a\u0142\u0148\u014f\u0152\u0156\u015a\u015f"+
		"\u0167\u016b\u0172\u017c\u017f\u018a\u018f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}