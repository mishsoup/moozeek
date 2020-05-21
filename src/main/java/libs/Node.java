package libs;

import exceptions.DuplicateNameException;

public abstract class Node {
    protected Tokenizer tokenizer = Tokenizer.getTokenizer();
    static protected MusicCreator musicCreator = MusicCreator.getMusicCreator();

    abstract public void parse();
    abstract public void evaluate();

}
