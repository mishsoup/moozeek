package visitors;

import ast.*;
import exceptions.WrongNameException;
import libs.MusicCreator;
import org.jfugue.pattern.Pattern;
import org.jfugue.pattern.PatternProducer;

import java.util.List;

public class PlayerVisitor implements Visitor<String>{
    static protected MusicCreator musicCreator = MusicCreator.getMusicCreator();
    private String defaultBPM;

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
        //TODO need to evaluate chord
        return null;
    }

    @Override
    public String evaluate(CHORDPROGRESSION chordprogression) {
        StringBuilder musicString = new StringBuilder("");
        for (BASEKEY eachKey: chordprogression.notes) {
            musicString.append(" " + eachKey.accept(this) + " ");
        }
        Pattern musicPattern = new Pattern(musicString.toString());
        return musicPattern.toString();
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
        Pattern pattern = new Pattern(create.sound.accept(this));
        musicCreator.addMusicToSongs(songName,pattern);
        return null;
    }

    @Override
    public String evaluate(INSTRUMENT instrument) {
        return null;
    }

    @Override
    public String evaluate(JOIN join) {
        List<NAME> names = join.getSubNames();
        int nameListSize = names.size();
        Pattern song = new Pattern();
        for (int i = nameListSize - 1; 0 <=  i ; i--) {
            //prepend the previous song, since API only offers prepend we have to do it this way
            song = song.prepend(musicCreator.getSound(names.get(i).name));
        }
        musicCreator.addMusicToSongs(join.getJoinedName().name, song);
        return null;
    }

    @Override
    public String evaluate(LENGTH length) {
        String len;
        switch(length.getLength())
        {
            case "sixteenth":
                len = "s";
                break;
            case "eighth":
                len = "i";
                break;
            case "quarter":
                len = "q";
                break;
            case "half":
                len = "h";
                break;
            case "whole":
                len = "w";
                break;
            default:
                len = "";
                System.out.println("Length has no match");
        }
        return len;
    }

    @Override
    public String evaluate(MELODY melody) {
        StringBuilder musicString = new StringBuilder("");
        for (BASEKEY eachKey: melody.notes) {
            musicString.append(" " + eachKey.accept(this) + " ");
        }
        Pattern musicPattern = new Pattern(musicString.toString());
        return musicPattern.toString();
    }

    @Override
    public String evaluate(NAME name) {
        return null;
    }

    @Override
    public String evaluate(NOTE note) {
        //TODO need to evaluate note
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
        //TODO need to evaluate rest
        return null;
    }

    @Override
    public String evaluate(SOUND sound) {
        BEAT beat = sound.getBeat();
        Pattern musicPattern = new Pattern("TIME:" + beat.counts.num + "/" + beat.countvalue);
        musicPattern.add(sound.getBaseSound().accept(this));
        musicPattern.setInstrument(sound.getInstrument().instrument);
        // TODO need to add BPM to the music pattern if it exist else use defaultBPM
        // TODO wait until the parser finishes and BPM class is added
        return musicPattern.toString();
    }

    @Override
    public String evaluate(TITLE title) {
        return null;
    }
}
