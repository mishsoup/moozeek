package ast;

import libs.Node;
import visitors.Visitor;

public class TITLE extends Node {
    @Override
    public void parse() {

    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }


}
