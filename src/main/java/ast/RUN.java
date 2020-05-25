package ast;

import visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public class RUN extends INSTRUCTION {
    String funcName;
    List<String> paraNames = new ArrayList<>();

    public String getFuncName() {
        return funcName;
    }

    public List<String> getParaNames() {
        return paraNames;
    }

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("RUN");
        funcName = tokenizer.getNext();
        if (tokenizer.checkToken("\\(")) {
            String name1 = tokenizer.getNext();
            paraNames.add(name1);
            while (tokenizer.checkToken("\\,")) {
                tokenizer.getAndCheckNext("\\,");
                String name2 = tokenizer.getNext();
                paraNames.add(name2);
            }
            tokenizer.getAndCheckNext("\\)");
        }
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }
}
