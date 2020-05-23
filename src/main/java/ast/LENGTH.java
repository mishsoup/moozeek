package ast;

import libs.Node;
import visitors.Visitor;

public class LENGTH extends Node {
    // LENGTH ::= s i q h w
    private String length;
    public String pattern = "[s|i|q|h|w]";

    public String getPattern() {
        return pattern;
    }

    @Override
    public void parse() {
        length = tokenizer.getNext();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }

    public String getLength() {
        return length;
    }

}
