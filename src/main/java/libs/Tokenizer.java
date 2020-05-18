package libs;

import java.util.List;

public class Tokenizer {
    private static String program;
    private static Tokenizer globalTokenizer;
    private static List<String> keyWords;
    private int currentTokenIndex = 0;

    public static Tokenizer getTokenizer() {
        return globalTokenizer;
    }
}
