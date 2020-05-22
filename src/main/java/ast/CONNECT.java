package ast;

import org.jfugue.pattern.Pattern;

import java.util.ArrayList;
import java.util.List;

public class CONNECT extends INSTRUCTION {
    private String beginKey = "CONNECT";
    public List<NAME> subNames = new ArrayList<>();
    public NAME newName = new NAME();

    public NAME getJoinedName() {
        return joinedName;
    }

    public List<NAME> getSubNames() {
        return subNames;
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
<<<<<<< HEAD:src/main/java/ast/JOIN.java
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
=======
    public void evaluate() {
        Pattern newSound = new Pattern();
        for (NAME subName: subNames) {
            newSound.add(musicCreator.getSound(subName.name));
        }
        musicCreator.addMusic(newName.name, newSound);
>>>>>>> kevin:src/main/java/ast/CONNECT.java
    }


}
