package ast;

import libs.Node;
import visitors.Visitor;

import java.util.regex.Pattern;

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
        if (!Pattern.matches(pattern, bpm)) {
            throw new RuntimeException("The input of BPM is " + bpm + ". It should be between 1 to 200.");
        }
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }

}
