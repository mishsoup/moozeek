package ast;

import libs.Node;
import visitors.Visitor;

public class COUNTS extends Node {
    private String counts;

    // values we use for evaluate, can change to re later
    String pattern = "[1-8]";

    public String getCounts() {
        return counts;
    }

    @Override
    public void parse() {
        counts = tokenizer.getNext();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }

}
