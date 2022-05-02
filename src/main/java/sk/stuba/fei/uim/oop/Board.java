package sk.stuba.fei.uim.oop;

import java.util.LinkedList;

public class Board extends LinkedList<Tile> {


    public Board(){
        this.add(new CornerTile("Start"));
        this.add(new Property("Restaurant Grand", 50, 25));
        this.add(new Chance("chance1"));
        this.add(new Property("Restaurant Dom Kultury", 75, 50));
        this.add(new Property("Restaurant Pub El Diabolo", 25, 25));
        this.add(new Property("Restaurant Jonatan", 50, 75));
        this.add(new CornerTile("Jail"));
        this.add(new Property("Restaurant Zeleny strom", 100, 125));
        this.add(new Chance("chance2"));
        this.add(new Property("Restaurant Mambo", 50, 25));
        this.add(new Property("Restaurant U Bazanta", 25, 75));
        this.add(new Property("Broadway Bowling restaurant", 100, 150));
        this.add(new CornerTile("Police"));
        this.add(new Property("Restaurant Zlaty Bazant", 75, 75));
        this.add(new Chance("chance3"));
        this.add(new Property("Restaurant Klub", 50, 25));
        this.add(new Property("Restaurant Maxi", 100, 125));
        this.add(new Property("Restaurant Na Korze", 25, 50));
        this.add(new CornerTile("Tax"));
        this.add(new Property("Restaurant Hotel Torysa", 50, 75));
        this.add(new Chance("chance4"));
        this.add(new Property("Grand Werdant restaurant", 125, 150));
        this.add(new Property("Bufet", 25, 75));
        this.add(new Property("Restaurant Pohoda", 25, 25));
    }
}
