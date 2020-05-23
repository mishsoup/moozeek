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
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }


}
