package ast;

import libs.Node;
import visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public class PROGRAM extends Node {

    private BPM bpm = new BPM();
    private List<INSTRUCTION> instructions = new ArrayList<>();
    private PLAY play = null;

    // getter
    public BPM getBpm() { return bpm; }
    public List<INSTRUCTION> getInstructions() { return instructions; }
    public PLAY getPlay() { return play; }

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("START");
        bpm.parse();
        tokenizer.getAndCheckNext(",");
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
            } else {
                throw new RuntimeException("Unknown instruction: " + tokenizer.getNext());
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
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }


}
