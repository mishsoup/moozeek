package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class COUNTVALUE extends Node {
    String value;
    // values we use for evaluate
    String[] values = new String[] {"sixteenth", "eighth", "quarter", "half", "whole"};

    @Override
    public void parse() {
        value = tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}
