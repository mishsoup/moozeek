package ast;

import visitors.Visitor;

public class CHORD extends BASEKEY {
    @Override
    public void parse() {
        length = new LENGTH();
        theNote = tokenizer.getNext();
        tokenizer.getAndCheckNext(",");
        length.parse();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }

}
