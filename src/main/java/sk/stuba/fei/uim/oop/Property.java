package sk.stuba.fei.uim.oop;

public class Property extends Tile{

    private final String name;
    private final int price;
    private Player owner;
    private int fine;

    public Property(String name, int price, int fine) {
        this.name = name;
        this.price = price;
        this.fine = fine;
    }

    public int getPrice() {
        return price;
    }

    public int getFine() {
        return fine;
    }

    public boolean buy(Player player){
        if(hasOwner())
            return false;
        this.owner = player;
        player.addProperty(this);
        System.out.println("You bought the property, good job!");
        return true;
    }

    public void payFine(int fine, Player player){
        this.fine = fine;
        player.decreaseBalance(fine);
        this.owner.increaseBalance(fine);
    }
    public void returnProperty(){
        this.owner = null;
    }


    public boolean hasOwner(){
        return !(owner == null);
    }

    public Player getOwner() {
        return this.owner;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return hasOwner() ? "You landed on " + name +" owned by " + getOwner().getName() + " and need to pay him " + fine +"." :
                "You step on " + name + ". Value: " + price +".";
    }
}
