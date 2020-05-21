package ast;

import visitors.Visitor;

public class NOTE extends BASEKEY {
    @Override
    public void parse() {
        length = new LENGTH();
        theNote = tokenizer.getNext();
        tokenizer.getAndCheckNext(",");
        length.parse();
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.evaluate(this);
    }


}
