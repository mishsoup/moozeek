package ast;

import visitors.Visitor;

public class CREATE extends INSTRUCTION {
    private NAME name = new NAME();
    private SOUND sound = new SOUND();

    public NAME getName() {
        return name;
    }

    public SOUND getSound() {
        return sound;
    }

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
