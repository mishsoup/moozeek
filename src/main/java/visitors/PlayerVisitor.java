package visitors;

import ast.*;
import exceptions.WrongNameException;
import libs.MusicCreator;
import org.jfugue.pattern.Pattern;
import org.jfugue.pattern.PatternProducer;

public class PlayerVisitor implements Visitor<String>{
    static protected MusicCreator musicCreator = MusicCreator.getMusicCreator();

    @Override
    public String evaluate(PLAY play) {
        PatternProducer music = musicCreator.getSound(play.name.name);
        musicCreator.getPlayer().play(music);

        return null;
    }

    @Override
    public String evaluate(BEAT beat) {
        return null;
    }

    @Override
    public String evaluate(CHORD chord) {
        return null;
    }

    @Override
    public String evaluate(CHORDPROGRESSION chordprogression) {
        return null;
    }

    @Override
    public String evaluate(COUNTS counts) {
        return null;
    }

    @Override
    public String evaluate(COUNTVALUE countvalue) {
        return null;
    }

    @Override
    public String evaluate(CREATE create) {
        String songName = create.name.name;
        Pattern pattern = musicCreator.createMusicPattern(create.sound.accept(this));
        musicCreator.addMusicToSongs(songName,pattern);
        return null;
    }

    @Override
    public String evaluate(INSTRUMENT instrument) {
        return null;
    }

    @Override
    public String evaluate(JOIN join) {
        Pattern newSound = new Pattern();
        for (NAME subName: join.getSubNames()) {
            newSound.add(musicCreator.getSound(subName.name));
        }
        musicCreator.addMusicToSongs(join.getJoinedName().name, newSound);
        return null;
    }

    @Override
    public String evaluate(LENGTH length) {
        return null;
    }

    @Override
    public String evaluate(MELODY melody) {
        StringBuilder musicString = new StringBuilder("");
        for (BASEKEY eachKey: melody.notes) {
            musicString.append(" " + eachKey.accept(this) + " ");
        }
        return musicString.toString();
    }

    @Override
    public String evaluate(NAME name) {
        return null;
    }

    @Override
    public String evaluate(NOTE note) {
        return null;
    }

    @Override
    public String evaluate(PROGRAM program) {
        for (INSTRUCTION eachInstruction: program.instructions) {
            eachInstruction.accept(this);
        }
        program.play.accept(this);
        return null;
    }

    @Override
    public String evaluate(REST rest) {
        return null;
    }

    @Override
    public String evaluate(SOUND sound) {
        StringBuilder musicString = new StringBuilder("V0 I["+sound.getInstrument()+"]");
        // TODO NEED TO ADD IN BEAT AND BPM HERE
        String baseSounds = (String) sound.getBaseSound().accept(this);
        musicString.append(baseSounds);
        return musicString.toString();
    }

    @Override
    public String evaluate(TITLE title) {
        return null;
    }
}
