package libs;

import org.jfugue.pattern.PatternProducer;

import java.util.HashMap;
import java.util.Map;

public class MusicCreator {
    private Map<String, PatternProducer> songs = new HashMap<String, PatternProducer>();

    public void addMusic(String name, PatternProducer pattern) {
        songs.put(name, pattern);
    }

}
