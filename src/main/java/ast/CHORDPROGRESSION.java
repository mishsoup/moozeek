package ast;

import java.util.ArrayList;
import java.util.List;

public class CHORDPROGRESSION extends BASESOUND {
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
            notes.add(key);
        }
    }

    @Override
    public void evaluate() {

    }
}
