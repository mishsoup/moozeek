package ast;

import visitors.Visitor;

public class CHORD extends BASEKEY {
    @Override
    public void parse() {
        String wholeNote = tokenizer.getNext();
        int mOrMIndex = getIndexOfMorm(wholeNote);
        int octaveIndex = getOctaveIndex(wholeNote);
        int lengthsIndex;
        if (mOrMIndex > 0) {
            setTheNote(wholeNote.substring(0, mOrMIndex + 1));
            lengthsIndex = mOrMIndex + 1;
        } else {
            setTheNote(wholeNote.substring(0, 1));
            lengthsIndex = 1;
        }
        if (octaveIndex > 0) {
            setOctave(wholeNote.substring(octaveIndex, octaveIndex + 2));
            lengthsIndex = octaveIndex + 2;
        }
        setLengths(wholeNote.substring(lengthsIndex));
    }

    private int getIndexOfMorm(String str) {
        int indexOfM = str.indexOf("M");
        int indexOfm = str.indexOf("m");
        return Math.max(indexOfM, indexOfm);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }

}
