package libs;

import ast.BASEKEY;
import ast.BASESOUND;
import ast.SOUND;
import org.jfugue.pattern.Pattern;
import org.jfugue.pattern.PatternProducer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicCreator {
    private Map<String, PatternProducer> songs = new HashMap<String, PatternProducer>();

    public void addMusic(String name, PatternProducer pattern) {
        songs.put(name, pattern);
    }

    public Pattern createMusic(SOUND sound) {
        StringBuilder musicString = new StringBuilder();

        //TODO have to figure out how beat works add add it here

        String instrument = sound.getInstrument().instrument;
        //append the instrument first
        musicString.append("V0 I["+ instrument +"]");

        List<BASEKEY> baseSound = sound.getBaseSound().notes;
        for (BASEKEY eachKey: baseSound) {
            // need to call evaluate to parse the string theNote into corresponding one in the API
            eachKey.evaluate();
            musicString.append(" " + eachKey.theNote + eachKey.length.getLength() + " ");
        }

        Pattern newPattern = new Pattern(musicString.toString());
        return newPattern;
    }

}
