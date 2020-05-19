package libs;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public abstract class Node {
    protected Tokenizer tokenizer = Tokenizer.getTokenizer();
    static protected MusicCreator musicCreator;

    abstract public void parse();
    abstract public void evaluate();

}
