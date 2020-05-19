package ast;

import java.util.ArrayList;
import java.util.List;

public class CHORDPROGRESSION extends BASESOUND {
    List<BASEKEY> chords = new ArrayList<>();
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("CHORD:");
        while(!tokenizer.checkToken("}")) {
            BASEKEY key = null;
            if (tokenizer.checkToken("REST")) {
                key = new REST();
            } else {
                key = new CHORD();
            }
            key.parse();
            chords.add(key);
        }
    }

    @Override
    public void evaluate() {

    }
}
