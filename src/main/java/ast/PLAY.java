package ast;

import libs.Node;

public class PLAY extends Node {
    NAME name = new NAME();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("PLAY");
        name.parse();
    }

    @Override
    public void evaluate() {

    }
}
