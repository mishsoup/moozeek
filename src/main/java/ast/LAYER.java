package ast;

import java.util.ArrayList;
import java.util.List;

public class LAYER extends INSTRUCTION {
    private String beginKey = "LAYER";
    public List<NAME> subNames = new ArrayList<>();
    public NAME newName = new NAME();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext(beginKey);
        NAME subName1 = new NAME();
        subName1.parse();
        subNames.add(subName1);
        tokenizer.getAndCheckNext(",");
        NAME subName2 = new NAME();
        subName2.parse();
        subNames.add(subName2);
        while(!tokenizer.checkToken("INTO")) {
            tokenizer.getAndCheckNext(",");
            NAME subName = new NAME();
            subName.parse();
            subNames.add(subName);
        }
        tokenizer.getAndCheckNext("INTO");
        newName.parse();
    }

    @Override
    public void evaluate() {

    }
}