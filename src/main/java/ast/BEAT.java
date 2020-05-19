package ast;

import libs.Node;

public class BEAT extends Node {
    COUNTS counts = new COUNTS();
    COUNTVALUE countvalue = new COUNTVALUE();
    // TODO have not idea about the name
    String finalValue;
    @Override
    public void parse() {
        counts.parse();
        tokenizer.getAndCheckNext("/");
        countvalue.parse();
        tokenizer.getAndCheckNext(",");
        finalValue = tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}
