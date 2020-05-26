package ast;

import libs.Node;
import visitors.Visitor;

public class NAME extends Node {
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public void parse() {
        name = tokenizer.getNext();
    }

    @Override
    public <C, T> T accept(Visitor<C, T> visitor, C context) {
        return visitor.evaluate(this, context);
    }


}
