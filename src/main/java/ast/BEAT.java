package ast;

import libs.Node;
import visitors.Visitor;

public class BEAT extends Node {
    private COUNTS counts = new COUNTS();
    private COUNTVALUE countvalue = new COUNTVALUE();

    public COUNTS getCounts() {
        return counts;
    }

    public COUNTVALUE getCountvalue() {
        return countvalue;
    }

    @Override
    public void parse() {
        counts.parse();
        tokenizer.getAndCheckNext("/");
        countvalue.parse();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }


}
