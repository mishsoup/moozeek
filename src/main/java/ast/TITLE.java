package ast;

import libs.Node;
import visitors.Visitor;

public class TITLE extends Node {
    @Override
    public void parse() {

    }

    @Override
    public String accept(Visitor visitor) {
        visitor.evaluate(this);
        return null;
    }


}
