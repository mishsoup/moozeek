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
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }

}
