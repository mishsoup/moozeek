package ast;

import libs.Node;

public class COUNTVALUE extends Node {
    String value;

    @Override
    public void parse() {
        value = tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}
