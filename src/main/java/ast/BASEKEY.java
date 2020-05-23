package ast;

import libs.Node;

// NOTE REST CHORD extends BASEKEY
public abstract class BASEKEY extends Node {
    private String theNote = null;
    private String lengths = null;
    private String octave = null;
    public String pattern = "[s|i|q|h|w]";

    //getter
    public String getLengths() {
        return lengths;
    }
    public String getOctave() {
        return octave;
    }
    public String getTheNote() {
        return theNote;
    }

    //setter
    public void setLengths(String lengths) { this.lengths = lengths; }
    public void setOctave(String octave) { this.octave = octave; }
    public void setTheNote(String theNote) { this.theNote = theNote; }

    public int getOctaveIndex(String str) {
        int addSignIndex = str.indexOf("+");
        int minusSignIndex = str.indexOf("-");
        return Math.max(addSignIndex, minusSignIndex);
    }

}
