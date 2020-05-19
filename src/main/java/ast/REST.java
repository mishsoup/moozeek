package ast;

public class REST extends BASEKEY {
    LENGTH length = new LENGTH();
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("REST");
        length.parse();
    }

    @Override
    public void evaluate() {

    }
}
