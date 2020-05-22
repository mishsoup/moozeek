package ast;

public class CHORD extends BASEKEY {
    @Override
    public void parse() {
        String wholeNote = tokenizer.getNext();
        int mOrMIndex = getIndexOfMorm(wholeNote);
        int octaveIndex = getOctaveIndex(wholeNote);
        int lengthsIndex;
        if (mOrMIndex > 0) {
            theNote = wholeNote.substring(0, mOrMIndex + 1);
            lengthsIndex = mOrMIndex + 1;
        } else {
            theNote = wholeNote.substring(0, 1);
            lengthsIndex = 1;
        }
        if (octaveIndex > 0) {
            octave = wholeNote.substring(octaveIndex, octaveIndex + 2);
            lengthsIndex = octaveIndex + 2;
        }
        lengths = wholeNote.substring(lengthsIndex);
    }

    private int getIndexOfMorm(String str) {
        int indexOfM = str.indexOf("M");
        int indexOfm = str.indexOf("m");
        return Math.max(indexOfM, indexOfm);
    }

    @Override
    public void evaluate() {
        if (theNote.matches("[A-G][m][1-9]")) {
            String firstHalf  = theNote.substring(0,1);
            String secondHalf = theNote.substring(2);
            theNote = firstHalf + "min" + secondHalf;
        } else if (theNote.matches("[A-G][m]")) {
            String firstHalf  = theNote.substring(0,1);
            theNote = firstHalf+"min";
        } else if (theNote.matches("[A-G][1-9]")) {
            String firstHalf  = theNote.substring(0,1);
            String secondHalf = theNote.substring(1);
            theNote = firstHalf + "maj" + secondHalf;
        } else if (theNote.matches("[A-G]")) {
            String firstHalf  = theNote.substring(0,1);
            theNote = firstHalf+"maj";
        }
    }
}
