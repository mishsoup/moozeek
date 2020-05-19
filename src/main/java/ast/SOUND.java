package ast;

import libs.Node;

public class SOUND extends Node {
    INSTRUMENT instrument = new INSTRUMENT();
    BEAT beat = new BEAT();
    BASESOUND baseSound;

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
    public void evaluate() {

    }
}
