package ast;

import libs.Node;

public class COUNTVALUE extends Node {
    public String value;
    // COUNTVALUE ::= 16 | 8| 4| 2

    @Override
    public void parse() {
        value = tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}
