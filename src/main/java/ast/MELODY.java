package ast;

import visitors.Visitor;

public class MELODY extends BASESOUND {
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("MELODY:");
        while(!tokenizer.checkToken("}")) {
            BASEKEY key = null;
            if (tokenizer.checkToken("REST")) {
                key = new REST();
            } else {
                key = new NOTE();
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
