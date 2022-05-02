package sk.stuba.fei.uim.oop;

public class Chance extends Tile{

    private String name;
//    private String content;

    public Chance(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
