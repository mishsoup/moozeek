package ast;

import java.util.ArrayList;
import java.util.List;

public class MELODY extends BASESOUND {
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("MELODY:");
        while(!tokenizer.checkToken("]")) {
            BASEKEY key = null;
            if (tokenizer.checkToken("R")) {
                key = new REST();
            } else {
                key = new NOTE();
            }
            key.parse();
            notes.add(key);
            while (tokenizer.checkToken(",")) {
                tokenizer.getAndCheckNext(",");
                BASEKEY key2 = null;
                if (tokenizer.checkToken("R")) {
                    key2 = new REST();
                } else {
                    key2 = new NOTE();
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
