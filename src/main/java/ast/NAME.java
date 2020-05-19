package ast;

import libs.Node;

public class NAME extends Node {
    String name;
    @Override
    public void parse() {
        name = tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}
