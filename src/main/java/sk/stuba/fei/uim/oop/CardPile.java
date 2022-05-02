package sk.stuba.fei.uim.oop;

import java.util.LinkedList;

public class CardPile {

    private LinkedList<ChanceCard> chanceCards ;
    private LinkedList<ChanceCard> used_chanceCards;

    public CardPile(){
        chanceCards = new LinkedList<>();
        used_chanceCards = new LinkedList<>();
        addCards();
    }

    public void addCards(){
        chanceCards.add(new ChanceCard("Your car broke. Service costs 200."));
        chanceCards.add(new ChanceCard("You won a lottery. 200 money is yours, enjoy!"));
        chanceCards.add(new ChanceCard("You see a homeless man begging for money and decide to give him 50."));
        chanceCards.add(new ChanceCard("You found 100 laying on the sidewalk and nobody seems to be looking for it. You keep it."));
        chanceCards.add(new ChanceCard("The police got you. You're arrested for 1 round."));
//        Collections.shuffle(chanceCards);
    }

    public ChanceCard drawCard(Player player){
        ChanceCard card = chanceCards.pop();

        switch (card.getContent()){
            case "Your car broke. Service costs 200.":
                player.decreaseBalance(200);
                break;
            case "You see a homeless man begging for money and decide to give him 50.":
                player.decreaseBalance(50);
                break;
            case "You won a lottery. 200 money is yours, enjoy!":
                player.increaseBalance(200);
                break;
            case "You found 100 laying on the sidewalk and nobody seems to be looking for it. You keep it.":
                player.increaseBalance(100);
                break;
            case "The police got you. You're arrested for 1 round.":
                player.jail(1);
                break;
        }

        used_chanceCards.add(card);
        System.out.println(card);

        if(chanceCards.size() <= 0){
            chanceCards = used_chanceCards;
            used_chanceCards.remove();
        }

        return card;
    }
}
