package ast;

import libs.Node;
import visitors.Visitor;

public class BPM extends Node {
    private String bpm;
    // validate pattern 1 - 200
    String pattern = "^([1-9]|[1-9][0-9]|[1][0-9][0-9]|20[0-0])$";

    public String getBpm() {
        return bpm;
    }

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("BPM:");
        bpm = tokenizer.getNext();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }

}
