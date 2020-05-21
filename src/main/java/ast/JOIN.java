package ast;

import visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public class JOIN extends INSTRUCTION {
    List<NAME> subNames = new ArrayList<>();
    NAME joinedName = new NAME();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("JOIN");
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
        joinedName.parse();
    }

    @Override
    public String accept(Visitor visitor) {
        visitor.evaluate(this);
        return null;
    }


}
