package libs;

import exceptions.DuplicateNameException;
import visitors.Visitor;

public abstract class Node {
    protected Tokenizer tokenizer = Tokenizer.getTokenizer();

    abstract public void parse();
    abstract public <T> T accept(Visitor<T> visitor);

}
