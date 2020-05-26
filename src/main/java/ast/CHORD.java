package ast;

import visitors.Visitor;

public class CHORD extends BASEKEY {
    @Override
    public void parse() {
        String wholeNote = tokenizer.getNext();
        int mOrMIndex = getIndex(wholeNote, "M", "m");
        int octaveIndex = getIndex(wholeNote, "+", "-");
        int sharpOrbIndex = getIndex(wholeNote, "#", "b");
        int lengthsIndex;
        if (mOrMIndex > 0) {
            setTheNote(wholeNote.substring(0, mOrMIndex + 1));
            lengthsIndex = mOrMIndex + 1;
        } else if (sharpOrbIndex > 0) {
            setTheNote(wholeNote.substring(0, sharpOrbIndex + 1));
            lengthsIndex = sharpOrbIndex + 1;
        } else {
            setTheNote(wholeNote.substring(0, 1));
            lengthsIndex = 1;
        }
        if (octaveIndex > 0) {
            String octave = wholeNote.substring(octaveIndex, octaveIndex + 2);
            if (isCorrectInput(octavePattern, octave)) {
                setOctave(octave);
                lengthsIndex = octaveIndex + 2;
            } else {
                throw new RuntimeException("The OCTAVE in NOTE should only have: " + octavePattern + ". But input is " + octave);
            }
        }
        String lengths = wholeNote.substring(lengthsIndex);
        if (isCorrectInput(lengthPattern, lengths)) {
            setLengths(lengths);
        } else {
            throw new RuntimeException("The LENGTH in CHORD should only have: " + lengthPattern + ". But input is " + lengths);
        }
    }

    @Override
    public <C, T> T accept(Visitor<C, T> visitor, C context) {
        return visitor.evaluate(this, context);
    }

}
