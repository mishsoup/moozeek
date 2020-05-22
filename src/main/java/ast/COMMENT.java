package ast;

public class COMMENT extends INSTRUCTION {
    public String comment;
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("//");
        comment = tokenizer.getNext();
        tokenizer.getAndCheckNext("//");
    }

    @Override
    public void evaluate() {

    }
}
