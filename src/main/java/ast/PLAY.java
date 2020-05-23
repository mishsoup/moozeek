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
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }


}
