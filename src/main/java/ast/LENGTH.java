package ast;

import libs.Node;
import visitors.Visitor;

public class LENGTH extends Node {
    String length;
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
