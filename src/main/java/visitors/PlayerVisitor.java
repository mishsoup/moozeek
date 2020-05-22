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
        String octaveString = getOctave(chord.octave);
        String note = chord.theNote.substring(0,1);
        String tone = "maj";
        if (chord.theNote.substring(1).equals("m")){
            tone = "min";
        }
        return note+tone+octaveString+chord.lengths;
    }

    @Override
    public String evaluate(CHORDPROGRESSION chordprogression) {
        StringBuilder musicString = new StringBuilder("");
        for (BASEKEY eachKey: chordprogression.notes) {
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
    public String evaluate(CONNECT connect) {
        List<NAME> names = connect.getSubNames();
        int nameListSize = names.size();
        Pattern song = new Pattern();
        for (int i = 0; i < nameListSize ; i++) {
            song.add(musicCreator.getSound(names.get(i).name));
        }
        musicCreator.addMusicToSongs(connect.getNewName().name, song);
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
        // TODO maybe we can take this line out and just directly return the string
        // TODO to be considered later
        Pattern musicPattern = new Pattern(musicString.toString());
        return musicPattern.toString();
    }

    @Override
    public String evaluate(NAME name) {
        return null;
    }

    @Override
    public String evaluate(NOTE note) {
        String octaveString = getOctave(note.octave);
        return note.theNote+octaveString+note.lengths;
    }

    @Override
    public String evaluate(PROGRAM program) {
        defaultBPM = Integer.parseInt(program.bpm.bpm);
        for (INSTRUCTION eachInstruction: program.instructions) {
            eachInstruction.accept(this);
        }
        if (program.play != null) {
            program.play.accept(this);
        }
        return null;
    }

    @Override
    public String evaluate(REST rest) {
        return "R"+rest.lengths;
    }

    @Override
    public String evaluate(SOUND sound) {
        BEAT beat = sound.getBeat();
        Pattern musicPattern = new Pattern("TIME:" + beat.counts.num + "/" + beat.countvalue.countValue);
        musicPattern.add(sound.getBaseSound().accept(this));
        musicPattern.setInstrument(sound.getInstrument().instrument);
        if (sound.bpm != null) {
            musicPattern.setTempo(Integer.parseInt(sound.bpm.bpm));
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
            song.add(musicCreator.getSound(names.get(i).name).setVoice(i));
        }
        musicCreator.addMusicToSongs(layer.getNewName().name, song);
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

    private String getOctave(String octaveString){
        String sign = octaveString.substring(0,1);
        int octave;
        if (sign.equals("+")) {
            octave = 5 + Integer.valueOf(octaveString.substring(1));
            if (octave > 10) {
                octave = 10;
            }
        } else {
            octave = 5 - Integer.valueOf(octaveString.substring(1));
            if (octave < 0) {
                octave = 0;
            }
        }
        return Integer.toString(octave);
    }
}
