package ast;

import libs.Node;
import visitors.Visitor;

public class NAME extends Node {
    public String name;
    @Override
    public void parse() {
        name = tokenizer.getNext();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }


}
