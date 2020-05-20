package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public abstract class BASESOUND extends Node {
    public List<BASEKEY> notes = new ArrayList<>();
}
