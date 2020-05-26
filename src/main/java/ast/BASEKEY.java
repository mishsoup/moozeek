package ast;

import libs.Node;

// NOTE REST CHORD extends BASEKEY
public abstract class BASEKEY extends Node {
    private String theNote = null;
    private String lengths = null;
    private String octave = null;
    public String lengthPattern = "[s|i|q|h|w]+";
    public String octavePattern = "[\\-|\\+][1-5]";


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

    public int getIndex(String str, String key1, String key2) {
        int addSignIndex = str.indexOf(key1);
        int minusSignIndex = str.indexOf(key2);
        return Math.max(addSignIndex, minusSignIndex);
    }

}
