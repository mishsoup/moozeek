package ast;

import visitors.Visitor;

public class COMMENT extends INSTRUCTION {
    private String comment;

    public String getComment() {
        return comment;
    }

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("//");
        comment = tokenizer.getNext();
        tokenizer.getAndCheckNext("//");
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }

}
