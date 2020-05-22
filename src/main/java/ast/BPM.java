package ast;

import libs.Node;

public class BPM extends Node {
    public String bpm;
    // validate pattern 1 - 200
    String pattern = "^([1-9]|[1-9][0-9]|[1][0-9][0-9]|20[0-0])$";

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("BPM:");
        bpm = tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}
