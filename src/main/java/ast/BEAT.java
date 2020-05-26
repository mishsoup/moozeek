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
    public <C, T> T accept(Visitor<C,T> visitor, C context) {
        return visitor.evaluate(this, context);
    }


}
