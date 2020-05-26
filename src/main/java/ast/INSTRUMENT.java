package ast;

import libs.Node;
import visitors.Visitor;

public class INSTRUMENT extends Node {
    private String instrument;

    public String getInstrument() {
        return instrument;
    }

    @Override
    public void parse() {
        instrument = tokenizer.getNext();
    }

    @Override
    public <C, T> T accept(Visitor<C, T> visitor, C context) {
        return visitor.evaluate(this, context);
    }

}
