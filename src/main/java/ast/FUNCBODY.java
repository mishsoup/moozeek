package ast;

import libs.Node;
import visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FUNCBODY extends Node{
    List<String> paraNames = new ArrayList<>();
    List<INSTRUCTION> instructions = new ArrayList<>();

    public List<String> getParaNames() {
        return paraNames;
    }

    public List<INSTRUCTION> getInstructions() {
        return instructions;
    }

    @Override
    public void parse() {
        if (tokenizer.checkToken("\\(")) {
            tokenizer.getAndCheckNext("\\(");
            String name1 = tokenizer.getNext();
            paraNames.add(name1);
            while (tokenizer.checkToken("\\,")) {
                tokenizer.getAndCheckNext("\\,");
                String name2 = tokenizer.getNext();
                paraNames.add(name2);
            }
            tokenizer.getAndCheckNext("\\)");
        }
        tokenizer.getAndCheckNext("\\{");
        while (!tokenizer.checkToken("\\}")) {
            INSTRUCTION instruction = null;
            if (tokenizer.checkToken("CONNECT")) {
                instruction = new CONNECT();
            } else if (tokenizer.checkToken("CREATE")) {
                instruction = new CREATE();
            } else if (tokenizer.checkToken("&")) {
                instruction = new COMMENT();
            } else if (tokenizer.checkToken("LAYER")) {
                instruction = new LAYER();
            } else if (tokenizer.checkToken("RUN")) {
                instruction = new RUN();
            } else {
                throw new RuntimeException("Unknown instruction in FUNCBODY: " + tokenizer.getNext());
            }
            instruction.parse();
            instructions.add(instruction);
        }
        tokenizer.getAndCheckNext("\\}");
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return null;
    }
}
