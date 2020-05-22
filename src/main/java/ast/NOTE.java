package ast;

public class NOTE extends BASEKEY {

    @Override
    public void parse() {
        String wholeNote = tokenizer.getNext();
        int octaveIndex = getOctaveIndex(wholeNote);
        theNote = wholeNote.substring(0, octaveIndex);

    }

    @Override
    public void evaluate() {
    }
}
