package ast;

public class NOTE extends BASEKEY {
    String note;
    LENGTH length = new LENGTH();
    @Override
    public void parse() {
        note = tokenizer.getNext();
        tokenizer.getAndCheckNext(",");
        length.parse();
    }

    @Override
    public void evaluate() {

    }
}
