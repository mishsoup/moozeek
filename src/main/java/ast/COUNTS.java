package ast;

import libs.Node;

public class COUNTS extends Node {
    String num;
    @Override
    public void parse() {
        num = tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}
