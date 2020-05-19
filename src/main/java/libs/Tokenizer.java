package libs;

import org.jfugue.pattern.PatternProducer;
import org.jfugue.pattern.Token;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tokenizer {
    private static String program;
    private static Tokenizer globalTokenizer;
    private static List<String> keyWords = Arrays.asList("START", ",", "{", "}", "PLAY", "JOIN", "CREATE", "INTO",
            "MELODY:", "REST", "CHORD:", "/");
    private int currentTokenIndex = 0;
    private String[] tokens;
    private Map<String, PatternProducer> musices = new HashMap<String, PatternProducer>();

    private Tokenizer(String fileName) {

    }

    private void tokenize() {}
    private String checkNext() {return "";}
    public String getNext() {return "";}
    public boolean checkToken(String regexp) {return false;}
    public String getAndCheckNext(String regexp) {return "";}
    public boolean moreToken() {return false;}

    public void addMusic(String name, PatternProducer pattern) {
        musices.put(name, pattern);
    }

    public static Tokenizer getTokenizer() {
        return globalTokenizer;
    }
}
