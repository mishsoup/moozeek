package ui;

import ast.PROGRAM;
import libs.Tokenizer;
import visitors.PlayerVisitor;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> literals = Arrays.asList(",", "[", "]", "PLAY", "CONNECT", "INTO", "LAYER", "/", "MELODY:"
        , "REST", "CHORD:", "CREATE", "BPM:", "&", "DEF", "RUN", "{", "}", "(", ")", "REF");
        Tokenizer.makeTokenizer("input.music",literals);
        PROGRAM program = new PROGRAM();
        program.parse();
        PlayerVisitor pv = new PlayerVisitor();
        program.accept(pv, PlayerVisitor.environmentTable);
    }
}
