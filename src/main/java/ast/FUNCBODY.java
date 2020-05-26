package ast;

import libs.Node;
import visitors.Visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FUNCBODY extends Node{
    List<String> paraNames = new ArrayList<>();
    List<INSTRUCTION> instructions = new ArrayList<>();
    Map<String, Boolean> tableForCheckScope = new HashMap<>();
    // false means, actual value
    // true means reference

    public List<String> getParaNames() {
        return paraNames;
    }
    public List<INSTRUCTION> getInstructions() {
        return instructions;
    }

    public Map<String, Boolean> getTableForCheckScope() {
        return tableForCheckScope;
    }

    @Override
    public void parse() {
        if (tokenizer.checkToken("\\(")) {
            tokenizer.getAndCheckNext("\\(");
            boolean isRef = false;
            if (tokenizer.checkToken("REF")) {
                tokenizer.getAndCheckNext("REF");
                isRef = true;
            }
            String name1 = tokenizer.getNext();
            paraNames.add(name1);
            tableForCheckScope.put(name1, isRef);
            while (tokenizer.checkToken("\\,")) {
                tokenizer.getAndCheckNext("\\,");
                boolean isRef1 = false;
                if (tokenizer.checkToken("REF")) {
                    tokenizer.getAndCheckNext("REF");
                    isRef1 = true;
                }
                String name2 = tokenizer.getNext();
                paraNames.add(name2);
                tableForCheckScope.put(name2, isRef1);
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
    public <C, T> T accept(Visitor<C, T> visitor, C context) {
        return visitor.evaluate(this, context);
    }
}
