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
    public String accept(Visitor visitor) {
        visitor.evaluate(this);
        return null;
    }

    public String getLength() {
        return length;
    }

}
