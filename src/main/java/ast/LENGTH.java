package ast;

import libs.Node;

public class LENGTH extends Node {
    String length;
    @Override
    public void parse() {
        length = tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}
