package ast;

import java.util.ArrayList;
import java.util.List;

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
    public void evaluate() {

    }
}
