package ast;

import visitors.Visitor;

public class REST extends BASEKEY {
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("REST");
        setTheNote("REST");
        String lengths = tokenizer.getNext();
        if (isCorrectInput(pattern, lengths)) {
            setLengths(tokenizer.getNext());
        } else {
            throw new RuntimeException("The LENGTH in REST should only have: " + pattern + ". But input is " + lengths);
        }
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }

}
