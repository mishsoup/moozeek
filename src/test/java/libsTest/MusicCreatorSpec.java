package libsTest;

import libs.MusicCreator;
import org.jfugue.pattern.Pattern;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MusicCreatorSpec {
    @Test
    public void testInstanceOfMusicCreator() {
        MusicCreator musicCreator1 = MusicCreator.getMusicCreator();
        musicCreator1.addMusic("1", new Pattern());
        MusicCreator musicCreator2 = MusicCreator.getMusicCreator();
        musicCreator2.addMusic("2", new Pattern());
        assertEquals(musicCreator1.getSize(), 2);
    }
}
