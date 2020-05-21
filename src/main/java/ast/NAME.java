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
    public String accept(Visitor visitor) {
        visitor.evaluate(this);
        return null;
    }


}
