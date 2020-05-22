package ast;

import visitors.Visitor;

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
        }
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }


}
