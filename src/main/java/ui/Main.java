package ui;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class Main {
    public static void main(String[] args) {
        // TODO: Please try to run this to confirm the dependency works well
        Player p = new Player();
        //        p.play("I[Piano] Aq Bq Cq Dq Eq Fq Gq");

        // TESTS to be removed below
        Pattern musicPattern2 = new Pattern("TIME:4/4");
        musicPattern2.add("E5s D#5s E5s D#5s E5s B4s D5s C5s A4q c4s e4s a4s b4q e4s a4s b4s c5q");
        musicPattern2.setInstrument("piano");
        musicPattern2.setTempo(70);
        musicPattern2.setVoice(0);

        Pattern musicPattern = new Pattern("TIME:4/4");
        musicPattern.add("Ri Rw A3s E3s A3s");
        musicPattern.setInstrument("piano");
        musicPattern.setTempo(70);
        musicPattern.setVoice(1);

        Pattern musicPattern3 = new Pattern();
        musicPattern3.add(musicPattern2);
        musicPattern3.add(musicPattern);

        musicPattern3.repeat(2);

        p.play(musicPattern3);


    }
}
