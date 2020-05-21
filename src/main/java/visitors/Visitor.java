package visitors;

import ast.*;

public interface Visitor<T> {
    T evaluate(PLAY play);
    T evaluate(BEAT beat);
    T evaluate(CHORD chord);
    T evaluate(CHORDPROGRESSION chordprogression);
    T evaluate(COUNTS counts);
    T evaluate(COUNTVALUE countvalue);
    T evaluate(CREATE create);
    T evaluate(INSTRUMENT instrument);
    T evaluate(JOIN join);
    T evaluate(LENGTH length);
    T evaluate(MELODY melody);
    T evaluate(NAME name);
    T evaluate(NOTE note);
    T evaluate(PROGRAM program);
    T evaluate(REST rest);
    T evaluate(SOUND sound);
    T evaluate(TITLE title);
}