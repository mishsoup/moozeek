package ast;

public class NOTE extends BASEKEY {
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
