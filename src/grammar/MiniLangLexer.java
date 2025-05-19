// Generated from C:/Users/SAM/Downloads/PA2/src/grammar/MiniLang.g4 by ANTLR 4.13.2
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MiniLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, ELSE=2, WHILE=3, PRINT=4, INT=5, PLUS=6, MINUS=7, MUL=8, DIV=9, 
		ASSIGN=10, SEMI=11, LPAREN=12, RPAREN=13, LBRACE=14, RBRACE=15, LT=16, 
		GT=17, LE=18, GE=19, EQ=20, NEQ=21, ID=22, NUMBER=23, WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IF", "ELSE", "WHILE", "PRINT", "INT", "PLUS", "MINUS", "MUL", "DIV", 
			"ASSIGN", "SEMI", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LT", "GT", 
			"LE", "GE", "EQ", "NEQ", "ID", "NUMBER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'else'", "'while'", "'print'", "'int'", "'+'", "'-'", 
			"'*'", "'/'", "'='", "';'", "'('", "')'", "'{'", "'}'", "'<'", "'>'", 
			"'<='", "'>='", "'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "ELSE", "WHILE", "PRINT", "INT", "PLUS", "MINUS", "MUL", 
			"DIV", "ASSIGN", "SEMI", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LT", 
			"GT", "LE", "GE", "EQ", "NEQ", "ID", "NUMBER", "WS"
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


	public MiniLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0018\u0080\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0005\u0015p\b"+
		"\u0015\n\u0015\f\u0015s\t\u0015\u0001\u0016\u0004\u0016v\b\u0016\u000b"+
		"\u0016\f\u0016w\u0001\u0017\u0004\u0017{\b\u0017\u000b\u0017\f\u0017|"+
		"\u0001\u0017\u0001\u0017\u0000\u0000\u0018\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018\u0001\u0000\u0004\u0003"+
		"\u0000AZ__az\u0004\u000009AZ__az\u0001\u000009\u0003\u0000\t\n\r\r  \u0082"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00011\u0001\u0000\u0000\u0000\u00034\u0001\u0000"+
		"\u0000\u0000\u00059\u0001\u0000\u0000\u0000\u0007?\u0001\u0000\u0000\u0000"+
		"\tE\u0001\u0000\u0000\u0000\u000bI\u0001\u0000\u0000\u0000\rK\u0001\u0000"+
		"\u0000\u0000\u000fM\u0001\u0000\u0000\u0000\u0011O\u0001\u0000\u0000\u0000"+
		"\u0013Q\u0001\u0000\u0000\u0000\u0015S\u0001\u0000\u0000\u0000\u0017U"+
		"\u0001\u0000\u0000\u0000\u0019W\u0001\u0000\u0000\u0000\u001bY\u0001\u0000"+
		"\u0000\u0000\u001d[\u0001\u0000\u0000\u0000\u001f]\u0001\u0000\u0000\u0000"+
		"!_\u0001\u0000\u0000\u0000#a\u0001\u0000\u0000\u0000%d\u0001\u0000\u0000"+
		"\u0000\'g\u0001\u0000\u0000\u0000)j\u0001\u0000\u0000\u0000+m\u0001\u0000"+
		"\u0000\u0000-u\u0001\u0000\u0000\u0000/z\u0001\u0000\u0000\u000012\u0005"+
		"i\u0000\u000023\u0005f\u0000\u00003\u0002\u0001\u0000\u0000\u000045\u0005"+
		"e\u0000\u000056\u0005l\u0000\u000067\u0005s\u0000\u000078\u0005e\u0000"+
		"\u00008\u0004\u0001\u0000\u0000\u00009:\u0005w\u0000\u0000:;\u0005h\u0000"+
		"\u0000;<\u0005i\u0000\u0000<=\u0005l\u0000\u0000=>\u0005e\u0000\u0000"+
		">\u0006\u0001\u0000\u0000\u0000?@\u0005p\u0000\u0000@A\u0005r\u0000\u0000"+
		"AB\u0005i\u0000\u0000BC\u0005n\u0000\u0000CD\u0005t\u0000\u0000D\b\u0001"+
		"\u0000\u0000\u0000EF\u0005i\u0000\u0000FG\u0005n\u0000\u0000GH\u0005t"+
		"\u0000\u0000H\n\u0001\u0000\u0000\u0000IJ\u0005+\u0000\u0000J\f\u0001"+
		"\u0000\u0000\u0000KL\u0005-\u0000\u0000L\u000e\u0001\u0000\u0000\u0000"+
		"MN\u0005*\u0000\u0000N\u0010\u0001\u0000\u0000\u0000OP\u0005/\u0000\u0000"+
		"P\u0012\u0001\u0000\u0000\u0000QR\u0005=\u0000\u0000R\u0014\u0001\u0000"+
		"\u0000\u0000ST\u0005;\u0000\u0000T\u0016\u0001\u0000\u0000\u0000UV\u0005"+
		"(\u0000\u0000V\u0018\u0001\u0000\u0000\u0000WX\u0005)\u0000\u0000X\u001a"+
		"\u0001\u0000\u0000\u0000YZ\u0005{\u0000\u0000Z\u001c\u0001\u0000\u0000"+
		"\u0000[\\\u0005}\u0000\u0000\\\u001e\u0001\u0000\u0000\u0000]^\u0005<"+
		"\u0000\u0000^ \u0001\u0000\u0000\u0000_`\u0005>\u0000\u0000`\"\u0001\u0000"+
		"\u0000\u0000ab\u0005<\u0000\u0000bc\u0005=\u0000\u0000c$\u0001\u0000\u0000"+
		"\u0000de\u0005>\u0000\u0000ef\u0005=\u0000\u0000f&\u0001\u0000\u0000\u0000"+
		"gh\u0005=\u0000\u0000hi\u0005=\u0000\u0000i(\u0001\u0000\u0000\u0000j"+
		"k\u0005!\u0000\u0000kl\u0005=\u0000\u0000l*\u0001\u0000\u0000\u0000mq"+
		"\u0007\u0000\u0000\u0000np\u0007\u0001\u0000\u0000on\u0001\u0000\u0000"+
		"\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000"+
		"\u0000\u0000r,\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tv\u0007"+
		"\u0002\u0000\u0000ut\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x.\u0001\u0000\u0000"+
		"\u0000y{\u0007\u0003\u0000\u0000zy\u0001\u0000\u0000\u0000{|\u0001\u0000"+
		"\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0001"+
		"\u0000\u0000\u0000~\u007f\u0006\u0017\u0000\u0000\u007f0\u0001\u0000\u0000"+
		"\u0000\u0004\u0000qw|\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}