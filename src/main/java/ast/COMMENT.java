package ast;

import visitors.Visitor;

public class COMMENT extends INSTRUCTION {
    private String comment;

    public String getComment() {
        return comment;
    }

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("&");
        comment = tokenizer.getNext();
        tokenizer.getAndCheckNext("&");
    }

    @Override
    public <C, T> T accept(Visitor<C, T> visitor, C context) {
        return visitor.evaluate(this, context);
    }

}
