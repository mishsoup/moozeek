package ast;

import libs.Node;
import visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public class PROGRAM extends Node {

    private List<INSTRUCTION> instructions = new ArrayList<>();
    private PLAY play = null;
    private List<FUNC> funcs = new ArrayList<>();

    // getter
    public List<INSTRUCTION> getInstructions() { return instructions; }
    public PLAY getPlay() { return play; }
    public List<FUNC> getFuncs() { return funcs; }

    @Override
    public void parse() {
        while (tokenizer.checkToken("DEF")) {
            FUNC func = new FUNC();
            func.parse();
            funcs.add(func);
        }
        while(tokenizer.moreTokens() && !tokenizer.checkToken(",")) {
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
                throw new RuntimeException("Unknown instruction in PROGRAM: " + tokenizer.getNext());
            }
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
    public <C, T> T accept(Visitor<C, T> visitor, C context) {
        return visitor.evaluate(this, context);
    }


}
