package libs;

import visitors.Visitor;

import java.util.regex.Pattern;

public abstract class Node {
    protected Tokenizer tokenizer = Tokenizer.getTokenizer();

    abstract public void parse();
    abstract public <C, T> T accept(Visitor<C, T> visitor, C context);

    public boolean isCorrectInput(String pattern, String text) {
        return Pattern.matches(pattern, text);
    }

}
