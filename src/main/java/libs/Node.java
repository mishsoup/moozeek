package libs;

import exceptions.DuplicateNameException;
import visitors.Visitor;

import java.util.regex.Pattern;

public abstract class Node {
    protected Tokenizer tokenizer = Tokenizer.getTokenizer();

    abstract public void parse();
    abstract public <T> T accept(Visitor<T> visitor);

    public boolean isCorrectInput(String pattern, String text) {
        return Pattern.matches(pattern, text);
    }

}
