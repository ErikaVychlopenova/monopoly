package sk.stuba.fei.uim.oop;

public class CornerTile extends Tile{

    private final String name;

    public CornerTile(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "You landed on " + name;
    }
}
