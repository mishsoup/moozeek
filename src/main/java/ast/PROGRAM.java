package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class PROGRAM extends Node {
    List<INSTRUCTION> instructions = new ArrayList<>();
    PLAY play = new PLAY();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("START");
        while(tokenizer.moreToken() && !tokenizer.checkToken("PLAY")) {
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
    public void evaluate() {

    }
}
