package ast;

public class CHORD extends BASEKEY {
    String chord;
    LENGTH length = new LENGTH();
    @Override
    public void parse() {
        chord = tokenizer.getNext();
        tokenizer.getAndCheckNext(",");
        length.parse();
    }

    @Override
    public void evaluate() {

    }
}
