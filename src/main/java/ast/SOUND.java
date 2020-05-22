package ast;

import libs.Node;

public class SOUND extends Node {
    public INSTRUMENT instrument = new INSTRUMENT();
    public BEAT beat = new BEAT();
    public BASESOUND baseSound;
    public BPM bpm = null;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("[");
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
        }
        // TODO else exception
        baseSound.parse();
        tokenizer.getAndCheckNext("]");
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

    @Override
    public void evaluate() {

    }
}
