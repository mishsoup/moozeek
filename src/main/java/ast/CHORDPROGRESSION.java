package ast;

import java.util.ArrayList;
import java.util.List;

public class CHORDPROGRESSION extends BASESOUND {
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("CHORD:");
        while(!tokenizer.checkToken("]")) {
            BASEKEY key = null;
            if (tokenizer.checkToken("R")) {
                key = new REST();
            } else {
                key = new CHORD();
            }
            key.parse();
            notes.add(key);
            while (tokenizer.checkToken(",")) {
                tokenizer.getAndCheckNext(",");
                BASEKEY key2 = null;
                if (tokenizer.checkToken("R")) {
                    key2 = new REST();
                } else {
                    key2 = new CHORD();
                }
                key2.parse();
                notes.add(key2);
            }
        }
    }

    @Override
    public void evaluate() {

    }
}
