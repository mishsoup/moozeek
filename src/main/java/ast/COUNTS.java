package ast;

import libs.Node;

public class COUNTS extends Node {
    public String num;
    // COUNTS ::= [1-8]

    @Override
    public void parse() {
        num = tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}
