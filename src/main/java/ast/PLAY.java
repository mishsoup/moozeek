package ast;

import libs.Node;
import visitors.Visitor;

public class PLAY extends Node {
    private NAME name = new NAME();

    public NAME getName() {
        return name;
    }

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("PLAY");
        name.parse();
    }

    @Override
    public <C, T> T accept(Visitor<C, T> visitor, C context) {
        return visitor.evaluate(this, context);
    }


}
