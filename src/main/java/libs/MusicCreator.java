package libs;

import ast.BASEKEY;
import ast.BASESOUND;
import ast.SOUND;
import exceptions.DuplicateNameException;
import exceptions.WrongNameException;
import org.jfugue.pattern.Pattern;
import org.jfugue.pattern.PatternProducer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicCreator {

    private static MusicCreator theMusicCreator;
    private Map<String, Pattern> songs = new HashMap<String, Pattern>();

    public void addMusic(String name, Pattern pattern) {
        songs.put(name, pattern);
    }

    public PatternProducer getSound(String name) {
        return songs.get(name);
    }

    // use for test case
    public int getSize() {
        return songs.size();
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

    public static MusicCreator getMusicCreator() {
        if (theMusicCreator == null) {
            theMusicCreator = new MusicCreator();
        }
        return theMusicCreator;
    }
}
