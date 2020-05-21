package ast;

import libs.Node;
import visitors.Visitor;

public class SOUND extends Node {
    public INSTRUMENT instrument = new INSTRUMENT();
    public BEAT beat = new BEAT();
    public BASESOUND baseSound;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("{");
        instrument.parse();
        tokenizer.getAndCheckNext(",");
        beat.parse();
        tokenizer.getAndCheckNext(",");
        if (tokenizer.checkToken("MELODY:")) {
            baseSound = new MELODY();
        } else if (tokenizer.checkToken("CHORD:")) {
            baseSound = new CHORDPROGRESSION();
        }
        baseSound.parse();
        tokenizer.getAndCheckNext("}");
    }

    @Override
    public String accept(Visitor visitor) {
        visitor.evaluate(this);
        return null;
    }

    public INSTRUMENT getInstrument() {
        return instrument;
    }

    public BEAT getBeat() {
        return beat;
    }

    public BASESOUND getBaseSound() {
        return baseSound;
    }


}
