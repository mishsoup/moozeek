package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class JOIN extends INSTRUCTION {
    List<NAME> subNames = new ArrayList<>();
    NAME majorName = new NAME();

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
        majorName.parse();
    }

    @Override
    public void evaluate() {

    }
}
