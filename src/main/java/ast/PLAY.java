package ast;

import libs.Node;
import visitors.Visitor;

public class PLAY extends Node {
    public NAME name = new NAME();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("PLAY");
        name.parse();
    }

    @Override
    public String accept(Visitor visitor) {
        visitor.evaluate(this);
        return null;
    }


}
