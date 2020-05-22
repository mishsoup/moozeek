package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class PROGRAM extends Node {
    public BPM bpm = new BPM();
    public List<INSTRUCTION> instructions = new ArrayList<>();
    // play optional
    public PLAY play = null;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("START");
        bpm.parse();
        tokenizer.getAndCheckNext(",");
        while(tokenizer.moreToken() && !tokenizer.checkToken(",")) {
            INSTRUCTION instruction = null;
            if (tokenizer.checkToken("CONNECT")) {
                instruction = new CONNECT();
            } else if (tokenizer.checkToken("CREATE")) {
                instruction = new CREATE();
            } else if (tokenizer.checkToken("//")) {
                instruction = new COMMENT();
            } else if (tokenizer.checkToken("LAYER")) {
                instruction = new LAYER();
            }
            // TODO have not catch exception
            instruction.parse();
            instructions.add(instruction);
        }
        // PLAY
        if (tokenizer.checkToken(",")) {
            tokenizer.getAndCheckNext(",");
                play = new PLAY();
                play.parse();
        }
    }

    @Override
    public void evaluate() {
        for (INSTRUCTION eachInstruction: instructions) {
            eachInstruction.evaluate();
        }
        play.evaluate();
    }
}
