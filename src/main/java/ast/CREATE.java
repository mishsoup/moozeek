package ast;

import visitors.Visitor;

public class CREATE extends INSTRUCTION {
    public NAME name = new NAME();
    public SOUND sound = new SOUND();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("CREATE");
        name.parse();
        tokenizer.getAndCheckNext(",");
        sound.parse();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }


}
