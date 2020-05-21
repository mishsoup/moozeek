package ast;

import visitors.Visitor;

public class REST extends BASEKEY {
    @Override
    public void parse() {
        length = new LENGTH();
        theNote = "R";
        tokenizer.getAndCheckNext("REST");
        length.parse();
    }

    @Override
    public String accept(Visitor visitor) {
        visitor.evaluate(this);
        return null;
    }


}
