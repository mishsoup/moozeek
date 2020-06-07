package visitors;

import ast.*;
import libs.MusicCreator;
import org.jfugue.pattern.Pattern;
import org.jfugue.pattern.PatternProducer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerVisitor implements Visitor<Map<String, Integer>, String>{
    static protected MusicCreator musicCreator = MusicCreator.getMusicCreator();
    private int defaultBPM = 100;
    public static Map<String, Integer> environmentTable = new HashMap<>();

    @Override
    public String evaluate(PLAY play, Map<String, Integer> envTable) {
        NAME name = play.getName();
        String nameValue = name.getName();
        Pattern music = musicCreator.getSound(nameValue, envTable);
        musicCreator.getPlayer().play(music);
        return null;
    }

    @Override
    public String evaluate(BEAT beat, Map<String, Integer> envTable) {
        return null;
    }

    @Override
    public String evaluate(CHORD chord, Map<String, Integer> envTable) {
        String octaveString = getOctave(chord.getOctave());
        String note = chord.getTheNote().substring(0,1);
        String tone = "maj";
        if (chord.getTheNote().substring(1).equals("m")){
            tone = "min";
        }
        return note+octaveString+tone+chord.getLengths();
    }

    @Override
    public String evaluate(CHORDPROGRESSION chordprogression, Map<String, Integer> envTable) {
        StringBuilder musicString = new StringBuilder("");
        for (BASEKEY eachKey: chordprogression.getNotes()) {
            musicString.append(" " + eachKey.accept(this, envTable) + " ");
        }
        // TODO maybe we can take this line out and just directly return the string
        // TODO to be considered later
        Pattern musicPattern = new Pattern(musicString.toString());
        return musicPattern.toString();
    }

    @Override
    public String evaluate(COUNTS counts, Map<String, Integer> envTable) {
        return counts.getCounts();
    }

    @Override
    public String evaluate(COUNTVALUE countvalue, Map<String, Integer> envTable) {
        return countvalue.getCountValue();
    }

    @Override
    public String evaluate(CREATE create, Map<String, Integer> envTable) {
        NAME name = create.getName();
        SOUND sound = create.getSound();
        String songName = name.getName();
        Pattern pattern = new Pattern(sound.accept(this, envTable));
        musicCreator.addMusicToSongs(songName, pattern, envTable);
        return null;
    }

    @Override
    public String evaluate(INSTRUMENT instrument, Map<String, Integer> envTable) {
        return instrument.getInstrument();
    }

    @Override
    public String evaluate(CONNECT connect, Map<String, Integer> envTable) {
        List<NAME> names = connect.getSubNames();
        int nameListSize = names.size();
        Pattern song = new Pattern();
        for (int i = 0; i < nameListSize ; i++) {
            song.add(musicCreator.getSound(names.get(i).getName(), envTable));
        }
        musicCreator.addMusicToSongs(connect.getNewName().getName(), song, envTable);
        //TODO remove this line, only for debugging
        //System.out.println(song);
        return null;
    }

    @Override
    public String evaluate(LENGTH length, Map<String, Integer> envTable) {
        return length.getLength();
    }

    @Override
    public String evaluate(MELODY melody, Map<String, Integer> envTable) {
        StringBuilder musicString = new StringBuilder("");
        for (BASEKEY eachKey: melody.getNotes()) {
            musicString.append(" " + eachKey.accept(this, envTable) + " ");
        }
        // TODO maybe we can take this line out and just directly return the string
        // TODO to be considered later
        Pattern musicPattern = new Pattern(musicString.toString());
        return musicPattern.toString();
    }

    @Override
    public String evaluate(NAME name, Map<String, Integer> envTable) {
        return name.getName();
    }

    @Override
    public String evaluate(NOTE note, Map<String, Integer> envTable) {
        String octaveString = getOctave(note.getOctave());
        return note.getTheNote()+octaveString+note.getLengths();
    }

    @Override
    public String evaluate(PROGRAM program, Map<String, Integer> envTable) {
        for (FUNC eachFunc: program.getFuncs()) {
            eachFunc.accept(this, envTable);
        }
        for (INSTRUCTION eachInstruction: program.getInstructions()) {
            eachInstruction.accept(this, envTable);
        }
        if (program.getPlay() != null) {
            program.getPlay().accept(this, envTable);
        }
        return null;
    }

    @Override
    public String evaluate(REST rest, Map<String, Integer> envTable) {
        return "R"+rest.getLengths();
    }

    @Override
    public String evaluate(SOUND sound, Map<String, Integer> envTable) {
        BEAT beat = sound.getBeat();
        COUNTS counts = beat.getCounts();
        COUNTVALUE countvalue = beat.getCountvalue();
        Pattern musicPattern = new Pattern("TIME:" + counts.getCounts() + "/" + countvalue.getCountValue());
        musicPattern.add(sound.getBaseSound().accept(this, envTable));
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
    public String evaluate(LAYER layer, Map<String, Integer> envTable) {
        List<NAME> names = layer.getSubNames();
        int nameListSize = names.size();
        Pattern song = new Pattern();
        for (int i = 0; i < nameListSize ; i++) {
            Pattern newSongSetName = new Pattern(musicCreator.getSound(names.get(i).getName(), envTable));
            newSongSetName.setVoice(i);
            song.add(newSongSetName);
        }
        musicCreator.addMusicToSongs(layer.getNewName().getName(), song, envTable);
        //TODO remove this line, only for debugging
        System.out.println(song);
        return null;
    }

    @Override
    public String evaluate(BPM bpm, Map<String, Integer> envTable) {
        return bpm.getBpm();
    }

    @Override
    public String evaluate(COMMENT comment, Map<String, Integer> envTable) {
        return comment.getComment();
    }

    @Override
    public String evaluate(RUN run, Map<String, Integer> envTable) {
        String functionName = run.getFuncName();
        List<String> paraValues = run.getParaNames();
        FUNCBODY funcbody = musicCreator.getFuncbody(functionName, envTable);
        List<String> paraNames = funcbody.getParaNames();

        Map<String, Integer> funEnv = new HashMap<>();

        for (int i = 0; i < paraNames.size(); i++) {
            String inputValueName = paraValues.get(i);
            String paraName = paraNames.get(i);

            Object object = musicCreator.getObject(inputValueName, envTable);
            if (funcbody.getTableForCheckScope().get(paraName)) {
                Integer oldAddress = envTable.get(inputValueName);
                funEnv.put(paraName, oldAddress);
            }

            musicCreator.addObjectToSongs(paraName, object, funEnv);
        }
        funcbody.accept(this, funEnv);

        // we need to clean the memory which point by funEnv
        // 1) find out all not REF parameters' address
        Map<String, Boolean> funcScopeTable = funcbody.getTableForCheckScope();
        List<String> nonRefName = new ArrayList<>();
        for (Map.Entry<String,Boolean> entry : funcScopeTable.entrySet()) {
            if (!entry.getValue()) {
                nonRefName.add(entry.getKey());
            }
        }
        List<Integer> nonRefAddress = new ArrayList<>();
        for (String eachName: nonRefName) {
            nonRefAddress.add(funEnv.get(eachName));
        }

        // 2) use this address delete it in memoryTable
        for (Integer eachAddress: nonRefAddress) {
            musicCreator.getMemoryTable().remove(eachAddress);
        }
        return null;
    }

    @Override
    public String evaluate(FUNC func, Map<String, Integer> envTable) {
        String name = func.getName();
        FUNCBODY funcbody = func.getFuncbody();
        musicCreator.addFuncBodyToSongs(name, funcbody, envTable);
        return null;
    }

    @Override
    public String evaluate(FUNCBODY funcbody,  Map<String, Integer> envTable) {
        for (INSTRUCTION eachInstruction: funcbody.getInstructions()) {
            eachInstruction.accept(this, envTable);
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
