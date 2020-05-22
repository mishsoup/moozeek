package ast;

import libs.Node;

public class COUNTVALUE extends Node {
    public String countValue;
    // COUNTVALUE ::= 16 | 8| 4| 2

    @Override
    public void parse() {
        countValue = tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}
