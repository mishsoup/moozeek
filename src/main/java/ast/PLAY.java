package ast;

import exceptions.WrongNameException;
import libs.Node;
import org.jfugue.pattern.PatternProducer;

public class PLAY extends Node {
    public NAME name = new NAME();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("PLAY");
        name.parse();
    }

    @Override
    public void evaluate() {
        try {
            PatternProducer music = musicCreator.getSound(name.name);
            musicCreator.getPlayer().play(music);
        } catch (WrongNameException e) {
            e.printStackTrace();
        }
    }
}
