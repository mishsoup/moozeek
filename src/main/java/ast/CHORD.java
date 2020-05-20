package ast;

public class CHORD extends BASEKEY {
    @Override
    public void parse() {
        length = new LENGTH();
        theNote = tokenizer.getNext();
        tokenizer.getAndCheckNext(",");
        length.parse();
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
