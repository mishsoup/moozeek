package ast;

import visitors.Visitor;

public class REST extends BASEKEY {
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("REST");
        setTheNote("REST");
        String lengths = tokenizer.getNext();
        if (isCorrectInput(lengthPattern, lengths)) {
            setLengths(lengths);
        } else {
            throw new RuntimeException("The LENGTH in REST should only have: " + lengthPattern + ". But input is " + lengths);
        }
    }

    @Override
    public <C, T> T accept(Visitor<C, T> visitor, C context) {
        return visitor.evaluate(this, context);
    }

}
