package visitors;

import ast.*;
import exceptions.WrongNameException;
import libs.MusicCreator;
import org.jfugue.pattern.Pattern;
import org.jfugue.pattern.PatternProducer;

public class PlayerVisitor implements Visitor{
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
        if (chord.theNote.matches("[A-G][m][1-9]")) {
            String firstHalf  = chord.theNote.substring(0,1);
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
        for (NAME subName: subNames) {
            newSound.add(musicCreator.getSound(subName.name));
        }
        musicCreator.addMusic(joinedName.name, newSound);
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
        String baseSounds = sound.getBaseSound().accept(this);
        musicString.append(baseSounds);
        return musicString.toString();
    }

    @Override
    public String evaluate(TITLE title) {
        return null;
    }
}
