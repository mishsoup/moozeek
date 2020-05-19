package ast;

public class CHORD extends BASEKEY {
    @Override
    public void parse() {
        length = new LENGTH();
        theNote = tokenizer.getNext();
        tokenizer.getAndCheckNext(",");
        length.parse();
    }

    @Override
    public void evaluate() {

    }
}
