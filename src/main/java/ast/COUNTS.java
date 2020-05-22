package ast;

import libs.Node;
import visitors.Visitor;

public class COUNTS extends Node {

    public String num;
    // values we use for evaluate, can change to re later
    String[] values = new String[] {"1", "2", "3", "4", "5", "6", "7", "8"};

    @Override
    public void parse() {
        num = tokenizer.getNext();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }

}
