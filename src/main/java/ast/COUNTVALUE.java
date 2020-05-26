package ast;

import libs.Node;
import visitors.Visitor;

import java.util.regex.Pattern;

public class COUNTVALUE extends Node {
    private String countValue;
    // COUNTVALUE ::= 16 | 8| 4| 2
    String pattern = "[8|4|2]|16";

    public String getCountValue() {
        return countValue;
    }

    @Override
    public void parse() {
        countValue = tokenizer.getNext();
        if (!Pattern.matches(pattern, countValue)) {
            throw new RuntimeException("The input of counts is " + countValue + " which is not between " + pattern);
        }
    }

    @Override
    public <C, T> T accept(Visitor<C, T> visitor, C context) {
        return visitor.evaluate(this, context);
    }

}
