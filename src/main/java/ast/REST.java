package ast;

public class REST extends BASEKEY {
    @Override
    public void parse() {
        length = new LENGTH();
        theNote = "R";
        tokenizer.getAndCheckNext("REST");
        length.parse();
    }

    @Override
    public void evaluate() {

    }
}
