package ast;

import visitors.Visitor;

public class NOTE extends BASEKEY {

    @Override
    public void parse() {
        String wholeNote = tokenizer.getNext();
        int sharpOrbIndex = getIndexOfSharpOrb(wholeNote);
        int octaveIndex = getIndex(wholeNote, "+", "-");
        int lengthsIndex;
        if (sharpOrbIndex > 0) {
            setTheNote(wholeNote.substring(0, sharpOrbIndex + 1));
            lengthsIndex = sharpOrbIndex + 1;
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

    private int getIndexOfSharpOrb(String str) {
        int indexOfSharp = str.indexOf("#");
        int indexOfb = str.indexOf("b");
        return Math.max(indexOfSharp, indexOfb);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.evaluate(this);
    }


}
