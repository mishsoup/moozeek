package ast;

import libs.Node;
import visitors.Visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PROGRAM extends Node {
    public List<INSTRUCTION> instructions = new ArrayList<>();
    public PLAY play = new PLAY();
    HashMap<String, String> songs = new HashMap<>();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("START");
        while(!tokenizer.checkToken("PLAY")) {
            INSTRUCTION instruction = null;
            if (tokenizer.checkToken("JOIN")) {
                instruction = new JOIN();
            } else if (tokenizer.checkToken("CREATE")) {
                instruction = new CREATE();
            }
            instruction.parse();
            instructions.add(instruction);
        }
        play.parse();
    }

    @Override
    public String accept(Visitor visitor) {
        visitor.evaluate(this);
        return null;
    }


}
