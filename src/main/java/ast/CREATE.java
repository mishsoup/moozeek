package ast;

public class CREATE extends INSTRUCTION {
    NAME name = new NAME();
    SOUND sound = new SOUND();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("CREATE");
        name.parse();
        tokenizer.getAndCheckNext(",");
        sound.parse();
    }

    @Override
    public void evaluate() {

    }
}
