package sk.stuba.fei.uim.oop;

public class ChanceCard {

    private final String content;

    public ChanceCard(String content){
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    @Override
    public String toString() {
        return content;
    }
}
