package ast;

import visitors.Visitor;

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
    public String accept(Visitor visitor) {
        visitor.evaluate(this);
        return null;
    }


}
