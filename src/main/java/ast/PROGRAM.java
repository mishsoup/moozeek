package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class PROGRAM extends Node {
    List<INSTRUCTION> instructions = new ArrayList<>();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("START");

    }

    @Override
    public void evaluate() {

    }
}
