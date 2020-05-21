package ast;

import libs.Node;
import visitors.Visitor;

public class COUNTVALUE extends Node {
    String value;
    // values we use for evaluate
    String[] values = new String[] {"sixteenth", "eighth", "quarter", "half", "whole"};

    @Override
    public void parse() {
        value = tokenizer.getNext();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }

}
