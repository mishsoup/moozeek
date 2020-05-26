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
    public <C, T> T accept(Visitor<C, T> visitor, C context) {
        return visitor.evaluate(this, context);
    }
}
