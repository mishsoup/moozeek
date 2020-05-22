package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public abstract class BASESOUND extends Node {
    // BASEKEY can be NOTE | REST for MELODY; CHORD | REST for CHORD
    public List<BASEKEY> notes = new ArrayList<>();
}
