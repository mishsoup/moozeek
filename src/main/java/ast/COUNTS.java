package ast;

import libs.Node;

public class COUNTS extends Node {
    public String counts;
    // COUNTS ::= [1-8]

    @Override
    public void parse() {
        counts = tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}
