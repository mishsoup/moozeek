package libs;

import org.jfugue.pattern.Token;

import java.util.Arrays;
import java.util.List;

public class Tokenizer {
    private static String program;
    private static Tokenizer globalTokenizer;
    private static List<String> keyWords = Arrays.asList("START");
    private int currentTokenIndex = 0;

    private Tokenizer(String fileName) {

    }

    private void tokenize() {}
    private String checkNext() {return "";}
    public String getNext() {return "";}
    public boolean checkToken(String regexp) {return false;}
    public String getAndCheckNext(String regexp) {return "";}
    public boolean moreToken() {return false;}

    public static Tokenizer getTokenizer() {
        return globalTokenizer;
    }
}
