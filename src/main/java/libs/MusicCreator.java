package libs;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

import java.util.HashMap;
import java.util.Map;

public class MusicCreator {

    private static MusicCreator theMusicCreator;
    private static final Map<String, Object> songs = new HashMap<String, Object>();
    private Player player = new Player();

    public Player getPlayer (){
        return player;
    }

    public void addMusicToSongs(String name, Pattern pattern) {
        songs.put(name, pattern);
    }

    public Pattern getSound(String name) {
        return (Pattern) songs.get(name);
    }

    // use for test case
    public int getSize() {
        return songs.size();
    }

    // TODO wanted to use this but seems redundant, may need to delete later if never gets called
    public Pattern createMusicPattern(String songString) {
        Pattern newPattern = new Pattern(songString.toString());
        return newPattern;
    }

    public static MusicCreator getMusicCreator() {
        if (theMusicCreator == null) {
            theMusicCreator = new MusicCreator();
        }
        return theMusicCreator;
    }
}
