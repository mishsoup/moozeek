package ast;

import libs.Node;

public class INSTRUMENT extends Node {
    String instrument;

    @Override
    public void parse() {
        instrument = tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}
