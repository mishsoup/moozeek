package ast;

import libs.Node;
import visitors.Visitor;

public class INSTRUMENT extends Node {
    public String instrument;

    @Override
    public void parse() {
        instrument = tokenizer.getNext();
    }

    @Override
    public String accept(Visitor visitor) {
        visitor.evaluate(this);
        return null;
    }

}
