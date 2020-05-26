package ast;

import visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public class LAYER extends INSTRUCTION {
    private String beginKey = "LAYER";
    private List<NAME> subNames = new ArrayList<>();
    private NAME newName = new NAME();

    public List<NAME> getSubNames() {
        return subNames;
    }
    public NAME getNewName() {
        return newName;
    }

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
        while(tokenizer.checkToken(",")) {
            tokenizer.getAndCheckNext(",");
            NAME subName = new NAME();
            subName.parse();
            subNames.add(subName);
        }
        tokenizer.getAndCheckNext("INTO");
        newName.parse();
    }

    @Override
    public <C, T> T accept(Visitor<C, T> visitor, C context) {
        return visitor.evaluate(this, context);
    }

}
