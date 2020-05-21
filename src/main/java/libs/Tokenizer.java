package libs;

import java.util.Arrays;
import java.util.List;

public class Tokenizer {
    private static String program;
    private static Tokenizer globalTokenizer;
    private static List<String> keyWords = Arrays.asList("START", ",", "{", "}", "PLAY", "CONNECT", "INTO", "LAYER",
            "CREATE", "Guitar", "Piano", "R", "Chord:", "-", "+", "BPM", "sixteenth", "eighth", "quarter", "half",
            "whole", "/");
    private int currentTokenIndex = 0;
    private String[] tokens;

    private Tokenizer(String fileName) {
        try {
            program = new String(Files.readAllBytes(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        }
        tokenize();
    }

    private void tokenize() {
        String tokenizedProgram = program.replace("\n", "");
        for (String s : keywords) {
            tokenizedProgram = tokenizedProgram.replace(s, "_" + s + "_");
        }
        tokenizedProgram = tokenizedProgram.replace("__","_");
        if (tokenizedProgram.length() > 0 && tokenizedProgram.charAt(0) == '_') {
            tokenizedProgram = tokenizedProgram.substring(1); // without first character
        }
        tokens = tokenizedProgram.split("_");
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].trim();
        }
    }

    private String checkNext() {return "";}
    public String getNext() {return "";}
    public boolean checkToken(String regexp) {return false;}
    public String getAndCheckNext(String regexp) {return "";}
    public boolean moreToken() {return false;}

    public static Tokenizer getTokenizer() {
        return globalTokenizer;
    }
}
