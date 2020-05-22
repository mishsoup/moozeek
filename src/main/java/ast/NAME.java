package ast;

import libs.Node;

public class NAME extends Node {
    public String name;
    @Override
    public void parse() {
        name = tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}
