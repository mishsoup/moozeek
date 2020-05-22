package ui;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class Main {
    public static void main(String[] args) {
        // TODO: Please try to run this to confirm the dependency works well
        Player p = new Player();
        //        p.play("I[Piano] Aq Bq Cq Dq Eq Fq Gq");

        // TESTS to be removed below
        Pattern musicPattern = new Pattern("TIME:4/4");
        musicPattern.add("Cq Dq Eq Fq Gq Aq Bq");
        musicPattern.setInstrument("piano");
        musicPattern.setTempo(180);
        musicPattern.setVoice(0);

        Pattern musicPattern2 = new Pattern("TIME:4/4");
        musicPattern2.add("Cq Dq Eq Fq Gq Aq Bq");
        musicPattern2.setInstrument("violin");
        musicPattern2.setTempo(180);
        musicPattern2.setVoice(1);

        Pattern musicPattern4 = new Pattern("TIME:4/4");
        musicPattern4.add("Cq Dq Eq Fq Gq Aq Bq");
        musicPattern4.setInstrument("guitar");
        musicPattern4.setTempo(300);

        Pattern musicPattern3 = new Pattern();
        musicPattern3.add(musicPattern2);
        musicPattern3.add(musicPattern);
        musicPattern3.add(musicPattern4);

        p.play(musicPattern3);


    }
}
