package ast;

import libs.Node;
import visitors.Visitor;

public class BEAT extends Node {
    public COUNTS counts = new COUNTS();
    public COUNTVALUE countvalue = new COUNTVALUE();

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
