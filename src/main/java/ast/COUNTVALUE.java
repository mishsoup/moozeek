package ast;

import libs.Node;
import visitors.Visitor;

public class COUNTVALUE extends Node {
    public String countValue;
    // COUNTVALUE ::= 16 | 8| 4| 2

    @Override
    public void parse() {
        countValue = tokenizer.getNext();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }

}
