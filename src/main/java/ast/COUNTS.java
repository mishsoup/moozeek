package ast;

import libs.Node;

public class COUNTS extends Node {
    String num;
    // values we use for evaluate, can change to re later
    String[] values = new String[] {"1", "2", "3", "4", "5", "6", "7", "8"};
    @Override
    public void parse() {
        num = tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}
