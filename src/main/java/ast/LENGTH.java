package ast;

import libs.Node;

public class LENGTH extends Node {
    // LENGTH ::= sixteenth | eighth | quarter | half | whole
    String length;
    @Override
    public void parse() {
        length = tokenizer.getNext();
    }

    public String getLength() {
        return length;
    }

    @Override
    public void evaluate() {

    }
}
