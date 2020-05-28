package libs;

import ast.FUNCBODY;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

import java.util.HashMap;
import java.util.Map;

public class MusicCreator {

    private static MusicCreator theMusicCreator;
    private static final Map<Integer, Object> memoryTable = new HashMap<Integer, Object>();
    private Player player = new Player();
    private static Integer memoryAddress = 0;


    public Integer getNewMemoryAddress() {
        memoryAddress = memoryAddress + 1;
        return memoryAddress;
    }

    public Map<Integer, Object> getMemoryTable() {
        return memoryTable;
    }

    public Player getPlayer (){
        return player;
    }

    public void addObjectToSongs(String name, Object object, Map<String, Integer> environmentTable) {
        Integer address = null;
        if (environmentTable.containsKey(name)) {
            address = environmentTable.get(name);
        } else {
            address = getNewMemoryAddress();
            environmentTable.put(name, address);
        }
        memoryTable.put(address, object);
    }

    public void addMusicToSongs(String name, Pattern pattern, Map<String, Integer> environmentTable) {
        Integer address = null;
        if (environmentTable.containsKey(name)) {
            address = environmentTable.get(name);
        } else {
            address = getNewMemoryAddress();
            environmentTable.put(name, address);
        }
        memoryTable.put(address, pattern);
    }

    public void addFuncBodyToSongs(String name, FUNCBODY funcbody , Map<String, Integer> environmentTable) {
        Integer address = null;
        if (environmentTable.containsKey(name)) {
            address = environmentTable.get(name);
        } else {
            address = getNewMemoryAddress();
            environmentTable.put(name, address);
        }
        memoryTable.put(address, funcbody);
    }

    public Object getObject(String name, Map<String, Integer> environmentTable) {
        if (!environmentTable.containsKey(name)) {
            throw new RuntimeException("Song Error: " + name + " is not declared. \n");
        }
        Integer address = environmentTable.get(name);
        return (Object) memoryTable.get(address);
    }

    public Pattern getSound(String name, Map<String, Integer> environmentTable) {
        if (!environmentTable.containsKey(name)) {
            throw new RuntimeException("Song Error: " + name + " is not declared. \n");
        }
        Integer address = environmentTable.get(name);
        return (Pattern) memoryTable.get(address);
    }

    public FUNCBODY getFuncbody(String name, Map<String, Integer> environmentTable) {
        if (!environmentTable.containsKey(name)) {
            throw new RuntimeException("Func Error: " + name + " is not declared. \n");
        }
        Integer address = environmentTable.get(name);
        return (FUNCBODY) memoryTable.get(address);
    }

    // use for test case
    public int getSize() {
        return memoryTable.size();
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
