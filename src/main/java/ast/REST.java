package ast;

import visitors.Visitor;

public class REST extends BASEKEY {
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("REST");
        setTheNote("REST");
        setLengths(tokenizer.getNext());
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }

}
