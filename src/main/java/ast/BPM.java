package ast;

import libs.Node;

public class BPM extends Node {
    public String num;
    // validate pattern 1 - 200
    String pattern = "^([1-9]|[1-9][0-9]|[1][0-9][0-9]|20[0-0])$";

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("BPM:");
        num = tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}
