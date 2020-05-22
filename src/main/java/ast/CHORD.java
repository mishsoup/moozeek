package ast;

import visitors.Visitor;

public class CHORD extends BASEKEY {
    @Override
    public void parse() {
        theNote = tokenizer.getNext();
        if (tokenizer.checkToken("-") || tokenizer.checkToken("+")) {
            octave = new OCTAVE();
            octave.parse();
        }
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }

}
