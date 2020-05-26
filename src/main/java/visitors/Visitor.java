package visitors;

import ast.*;

public interface Visitor<C, T> {
    T evaluate(PLAY play, C context);
    T evaluate(BEAT beat, C context);
    T evaluate(CHORD chord, C context);
    T evaluate(CHORDPROGRESSION chordprogression, C context);
    T evaluate(COUNTS counts, C context);
    T evaluate(COUNTVALUE countvalue, C context);
    T evaluate(CREATE create, C context);
    T evaluate(INSTRUMENT instrument, C context);
    T evaluate(CONNECT connect, C context);
    T evaluate(LENGTH length, C context);
    T evaluate(MELODY melody, C context);
    T evaluate(NAME name, C context);
    T evaluate(NOTE note, C context);
    T evaluate(PROGRAM program, C context);
    T evaluate(REST rest, C context);
    T evaluate(SOUND sound, C context);
    T evaluate(LAYER layer, C context);
    T evaluate(BPM bpm, C context);
    T evaluate(COMMENT comment, C context);
    T evaluate(RUN run, C context);
    T evaluate(FUNC func, C context);
    T evaluate(FUNCBODY funcbody, C context);
}
