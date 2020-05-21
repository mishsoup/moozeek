package visitors;

import ast.*;

public interface Visitor {
    String evaluate(PLAY play);
    String evaluate(BEAT beat);
    String evaluate(CHORD chord);
    String evaluate(CHORDPROGRESSION chordprogression);
    String evaluate(COUNTS counts);
    String evaluate(COUNTVALUE countvalue);
    String evaluate(CREATE create);
    String evaluate(INSTRUMENT instrument);
    String evaluate(JOIN join);
    String evaluate(LENGTH length);
    String evaluate(MELODY melody);
    String evaluate(NAME name);
    String evaluate(NOTE note);
    String evaluate(PROGRAM program);
    String evaluate(REST rest);
    String evaluate(SOUND sound);
    String evaluate(TITLE title);
}
