package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

// NOTE REST CHORD extends BASEKEY
public abstract class BASEKEY extends Node {
    public String theNote;
    public String lengths;

    public int getOctaveIndex(String str) {
        int addSignIndex = str.indexOf("+");
        int minusSignIndex = str.indexOf("-");
        if (addSignIndex > minusSignIndex) {
            return addSignIndex;
        } else {
            return minusSignIndex;
        }
    }

}
