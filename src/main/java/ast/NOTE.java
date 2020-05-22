package ast;

import visitors.Visitor;

public class NOTE extends BASEKEY {

    @Override
    public void parse() {
        String wholeNote = tokenizer.getNext();
        int octaveIndex = getOctaveIndex(wholeNote);
        theNote = wholeNote.substring(0, octaveIndex);

    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }


}
