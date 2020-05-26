package visitors;

import ast.*;
import exceptions.WrongNameException;
import libs.MusicCreator;
import org.jfugue.pattern.Pattern;
import org.jfugue.pattern.PatternProducer;

import java.util.List;

public class PlayerVisitor implements Visitor<String>{
    static protected MusicCreator musicCreator = MusicCreator.getMusicCreator();
    private int defaultBPM;

    @Override
    public String evaluate(PLAY play) {
        musicCreator.getPlayer().play(play.getName().accept(this));
        return null;
    }

    @Override
    public String evaluate(BEAT beat) {
        return null;
    }

    @Override
    public String evaluate(CHORD chord) {
        String octaveString = getOctave(chord.getOctave());
        String note = chord.getTheNote().substring(0,1);
        String tone = "maj";
        if (chord.getTheNote().substring(1).equals("m")){
            tone = "min";
        }
        return note+octaveString+tone+chord.getLengths();
    }

    @Override
    public String evaluate(CHORDPROGRESSION chordprogression) {
        StringBuilder musicString = new StringBuilder("");
        for (BASEKEY eachKey: chordprogression.getNotes()) {
            musicString.append(" " + eachKey.accept(this) + " ");
        }
        // TODO maybe we can take this line out and just directly return the string
        // TODO to be considered later
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
        NAME name = create.getName();
        SOUND sound = create.getSound();
        String songName = name.getName();
        Pattern pattern = new Pattern(sound.accept(this));
        musicCreator.addMusicToSongs(songName, pattern);
        return null;
    }

    @Override
    public String evaluate(INSTRUMENT instrument) {
        return null;
    }

    @Override
    public String evaluate(CONNECT connect) {
        List<NAME> names = connect.getSubNames();
        int nameListSize = names.size();
        Pattern song = new Pattern();
        for (int i = 0; i < nameListSize ; i++) {
            song.add(names.get(i).accept(this));
        }
        musicCreator.addMusicToSongs(connect.getNewName().getName(), song);
        //TODO remove this line, only for debugging
        System.out.println(song);
        return null;
    }

    @Override
    public String evaluate(LENGTH length) {
        return null;
    }

    @Override
    public String evaluate(MELODY melody) {
        StringBuilder musicString = new StringBuilder("");
        for (BASEKEY eachKey: melody.getNotes()) {
            musicString.append(" " + eachKey.accept(this) + " ");
        }
        // TODO maybe we can take this line out and just directly return the string
        // TODO to be considered later
        Pattern musicPattern = new Pattern(musicString.toString());
        return musicPattern.toString();
    }

    @Override
    public String evaluate(NAME name) {
        return musicCreator.getSound(name.getName()).toString();
    }

    @Override
    public String evaluate(NOTE note) {
        String octaveString = getOctave(note.getOctave());
        return note.getTheNote()+octaveString+note.getLengths();
    }

    @Override
    public String evaluate(PROGRAM program) {
        for (FUNC eachFunc: program.getFuncs()) {
            eachFunc.accept(this);
        }
        BPM bpm = program.getBpm();
        defaultBPM = Integer.parseInt(bpm.getBpm());
        for (INSTRUCTION eachInstruction: program.getInstructions()) {
            eachInstruction.accept(this);
        }
        if (program.getPlay() != null) {
            program.getPlay().accept(this);
        }
        return null;
    }

    @Override
    public String evaluate(REST rest) {
        return "R"+rest.getLengths();
    }

    @Override
    public String evaluate(SOUND sound) {
        BEAT beat = sound.getBeat();
        COUNTS counts = beat.getCounts();
        COUNTVALUE countvalue = beat.getCountvalue();
        Pattern musicPattern = new Pattern("TIME:" + counts.getCounts() + "/" + countvalue.getCountValue());
        musicPattern.add(sound.getBaseSound().accept(this));
        INSTRUMENT instrument = sound.getInstrument();
        musicPattern.setInstrument(instrument.getInstrument());
        if (sound.getBpm() != null) {
            musicPattern.setTempo(Integer.parseInt(sound.getBpm().getBpm()));
        } else {
            musicPattern.setTempo(defaultBPM);
        }
        return musicPattern.toString();
    }

    @Override
    public String evaluate(LAYER layer) {
        List<NAME> names = layer.getSubNames();
        int nameListSize = names.size();
        Pattern song = new Pattern();
        for (int i = 0; i < nameListSize ; i++) {
            Pattern newSongSetName = new Pattern(names.get(i).accept(this));
            newSongSetName.setVoice(i);
            song.add(newSongSetName);
        }
        musicCreator.addMusicToSongs(layer.getNewName().getName(), song);
        //TODO remove this line, only for debugging
        System.out.println(song);
        return null;
    }

    @Override
    public String evaluate(BPM bpm) {
        return null;
    }

    @Override
    public String evaluate(COMMENT comment) {
        return null;
    }

    @Override
    public String evaluate(RUN run) {
        return null;
    }

    @Override
    public String evaluate(FUNC func) {
        return null;
    }

    @Override
    public String evaluate(FUNCBODY funcbody) {
        for (INSTRUCTION eachInstruction: funcbody.getInstructions()) {
            eachInstruction.accept(this);
        }
        return null;
    }

    private String getOctave(String octaveString){
        if (octaveString == null) {
            return "5";
        }
        String sign = octaveString.substring(0,1);
        int octave;
        switch(sign) {
            case "+":
                octave = 5 + Integer.valueOf(octaveString.substring(1));
                if (octave > 10) {
                    octave = 10;
                }
                break;
            case "-":
                octave = 5 - Integer.valueOf(octaveString.substring(1));
                if (octave < 0) {
                    octave = 0;
                }
                break;
            default:
                return "5";
        }
        return Integer.toString(octave);
    }
}
