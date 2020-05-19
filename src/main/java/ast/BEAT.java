package ast;

import libs.Node;

public class BEAT extends Node {
    public COUNTS counts = new COUNTS();
    public COUNTVALUE countvalue = new COUNTVALUE();
    public String finalValue;
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
