package sk.stuba.fei.uim.oop;

import java.util.LinkedList;

public class Player {

    private String name;
    private int balance;
    private LinkedList<Property> owned;
    private int position = 0;
    private int timeInJail;


    public Player(String name) {
        this.name = name;
        this.balance = 300;
        owned = new LinkedList<>();
        this.position = 0;
        timeInJail = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void increaseBalance(int balance) {
        this.balance += balance;
//        System.out.println("Your account balance is: " + this.balance);
    }

    public void decreaseBalance(int balance) {
        this.balance -= balance;
//        System.out.println("Your account balance is: " + this.balance);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move(int movement){
        this.position+=movement;
        if(this.position >= 23){
            this.position = 0;
        }
//        this.position+=movement;
    }

    public void jail(int turns){
        this.setPosition(6);
        this.timeInJail = turns;
        System.out.println("Oh no! You're in jail for "+ turns + " turns. Enjoy your stay!");
    }

    public boolean inJail(){
        if(timeInJail <= 0)
            return false;

        this.timeInJail--;

        return this.timeInJail > 0;
    }


    public int getTimeInJail() {
        return this.timeInJail;
    }

    public void addProperty(Property property){
        this.owned.add(property);
        this.balance -= property.getPrice();
    }

    public void returnProperties(){
        for(Property property : this.owned){
            property.returnProperty();
        }
    }

//    @Override
//    public String toString() {
//        return getTimeInJail() > 0 ? "\nPlayer " + name + ", balance=" + balance + ", vo vazani na " + timeInJail + "tahov" :
//                "\nPlayer " + name + ", balance=" + balance;
//    }
}
