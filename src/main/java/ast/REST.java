package ast;

public class REST extends BASEKEY {
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("R");
        theNote = "R";
        lengths = tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}
