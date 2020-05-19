package ast;

import libs.Node;

public class INSTRUMENT extends Node {
    public String instrument;

    @Override
    public void parse() {
        instrument = tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}
