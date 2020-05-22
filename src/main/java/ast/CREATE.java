package ast;

public class CREATE extends INSTRUCTION {
    public NAME name = new NAME();
    public SOUND sound = new SOUND();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("CREATE");
        name.parse();
        tokenizer.getAndCheckNext(",");
        sound.parse();
    }

    @Override
    public void evaluate() {
        String songName = name.name;
        musicCreator.addMusic(songName,musicCreator.createMusic(sound));
    }
}
