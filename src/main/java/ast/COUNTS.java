package ast;

import libs.Node;
import visitors.Visitor;

import java.util.regex.Pattern;

public class COUNTS extends Node {
    private String counts;
    private String countsPattern = "[1-8]";


    // values we use for evaluate, can change to re later
    String pattern = "[1-8]";

    public String getCounts() {
        return counts;
    }

    @Override
    public void parse() {
        counts = tokenizer.getNext();
        if (!Pattern.matches(countsPattern, counts)) {
            throw new RuntimeException("The input of counts is " + counts + " which is not between " + countsPattern);
        }
    }

    @Override
    public <C, T> T accept(Visitor<C, T> visitor, C context) {
        return visitor.evaluate(this, context);
    }

}
