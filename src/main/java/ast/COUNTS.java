package ast;

import libs.Node;
import visitors.Visitor;

public class COUNTS extends Node {
    public String num;
    // COUNTS ::= [1-8]

    @Override
    public void parse() {
        num = tokenizer.getNext();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }

}
