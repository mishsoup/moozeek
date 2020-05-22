package ast;

import libs.Node;

public class OCTAVE extends Node {
    // OCTAVE ::= “-” [1-3] | “+” [1-6] 
    String octave;
    @Override
    public void parse() {
        StringBuffer sb = new StringBuffer();
        String sign = tokenizer.getNext();
        String value = tokenizer.getNext();
        sb.append(sign);
        sb.append(value);
        octave = sb.toString();
    }

    @Override
    public void evaluate() {

    }
}
