package ast;

import libs.Node;
import visitors.Visitor;

public class FUNC extends Node {
    String name;
    FUNCBODY funcbody = new FUNCBODY();

    public String getName() {
        return name;
    }

    public FUNCBODY getFuncbody() {
        return funcbody;
    }

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("DEF");
        name = tokenizer.getNext();
        funcbody.parse();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }
}
