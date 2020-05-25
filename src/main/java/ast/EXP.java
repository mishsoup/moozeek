package ast;

import visitors.Visitor;

public interface EXP {
    void parse();
    <T> T accept(Visitor<T> visitor);
}
