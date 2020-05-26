package ast;

import libs.Node;
import visitors.Visitor;

public class SOUND extends Node {
    private INSTRUMENT instrument = new INSTRUMENT();
    private BEAT beat = new BEAT();
    private BASESOUND baseSound;
    private BPM bpm = null;

    // getter
    public INSTRUMENT getInstrument() { return instrument; }
    public BEAT getBeat() {
        return beat;
    }
    public BASESOUND getBaseSound() {
        return baseSound;
    }
    public BPM getBpm() { return bpm; }

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("\\[");
        instrument.parse();
        tokenizer.getAndCheckNext(",");
        beat.parse();
        tokenizer.getAndCheckNext(",");
        if (tokenizer.checkToken("BPM:")) {
            bpm = new BPM();
            bpm.parse();
            tokenizer.getAndCheckNext(",");
        }
        if (tokenizer.checkToken("MELODY:")) {
            baseSound = new MELODY();
        } else if (tokenizer.checkToken("CHORD:")) {
            baseSound = new CHORDPROGRESSION();
        } else {
            throw new RuntimeException("Unknow baseSound:" + tokenizer.getNext());
        }
        baseSound.parse();
        tokenizer.getAndCheckNext("\\]");
    }

    @Override
    public <C, T> T accept(Visitor<C, T> visitor, C context) {
        return visitor.evaluate(this, context);
    }
}
