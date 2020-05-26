package ast;

import visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public class CHORDPROGRESSION extends BASESOUND {
    private List<BASEKEY> notes = new ArrayList<>();

    public List<BASEKEY> getNotes() {
        return notes;
    }

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("CHORD:");
        while(!tokenizer.checkToken("\\]")) {
            BASEKEY key;
            if (tokenizer.checkToken("REST")) {
                key = new REST();
            } else {
                key = new CHORD();
            }
            key.parse();
            notes.add(key);
            while (tokenizer.checkToken(",")) {
                tokenizer.getAndCheckNext(",");
                BASEKEY key2;
                if (tokenizer.checkToken("REST")) {
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
    public <C, T> T accept(Visitor<C, T> visitor, C context) {
        return visitor.evaluate(this, context);
    }


}
