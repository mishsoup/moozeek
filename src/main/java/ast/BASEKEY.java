package ast;

import libs.Node;

// NOTE REST CHORD extends BASEKEY
public abstract class BASEKEY extends Node {
    public String theNote;
    public String lengths;
    public String octave;

    public int getOctaveIndex(String str) {
        int addSignIndex = str.indexOf("+");
        int minusSignIndex = str.indexOf("-");
        return Math.max(addSignIndex, minusSignIndex);
    }

}
