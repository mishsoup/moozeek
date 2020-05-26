package ast;

import libs.Node;
import visitors.Visitor;

public class LENGTH extends Node {
    // LENGTH ::= s i q h w
    private String length;
    public String pattern = "[s|i|q|h|w]";

    public String get() {
        return pattern;
    }

    @Override
    public void parse() {
        length = tokenizer.getNext();
    }

    @Override
    public <C, T> T accept(Visitor<C, T> visitor, C context) {
        return visitor.evaluate(this, context);
    }

    public String getLength() {
        return length;
    }

}
