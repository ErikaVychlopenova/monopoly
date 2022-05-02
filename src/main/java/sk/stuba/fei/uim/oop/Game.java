package sk.stuba.fei.uim.oop;


import java.util.LinkedList;
import java.util.Random;

public class Game {
    private Board board;
    private CardPile cards;
    private int playerCount = 0;
    private int currentPlayerIndex = 0;
    private LinkedList<Player> players = new LinkedList<>();
    private LinkedList<ChanceCard> chanceCards = new LinkedList<>();
    private LinkedList<ChanceCard> used_chanceCards = new LinkedList<>();
//    private int fine = 0;


    public void PlayGame() {
        board = new Board();
        Random dice = new Random();
        addPlayers();
        cards = new CardPile();
        currentPlayerIndex = 0;
        int diceRoll;

        while(!isWon()){
            Player currentPlayer = players.get(currentPlayerIndex);

            if(currentPlayer.inJail()){     // if player is in jail, he waits
                currentPlayer.move(0);
                System.out.println("\n"+currentPlayer.getName()+" ,you are in jail, mate! Wait " + currentPlayer.getTimeInJail() + " more rounds.\n");
//                nextPlayer();
            }
            else {
                System.out.println("\n" + currentPlayer.getName() + ", it's your turn.\nYour account balance is " + currentPlayer.getBalance() + ".");
                System.out.println("Press enter to roll the dice.");
                KeyboardInput.readString();
                diceRoll = dice.nextInt(6) + 1;
                System.out.println("*Throwing dice*");
                System.out.println("You got a " + diceRoll + ".\n");
                currentPlayer.move(diceRoll);


                if (board.get(currentPlayer.getPosition()) instanceof CornerTile) {     // check what Tile the player step on
                    CornerTile tile = (CornerTile) board.get(currentPlayer.getPosition());
                    System.out.println(tile);
                    if (tile.getName().equals("Start")) {       // if player steps on Tile Start, receive money
                        System.out.println("You get 200.");
                        currentPlayer.increaseBalance(200);
                    } else if (tile.getName().equals("Police")) {       //if player steps on Tile Police, go to jail
                        currentPlayer.jail(2);
                    } else if (tile.getName().equals("Tax")) {      //if player steps on Tile Tax, pay money
                        System.out.println("Pay 250 to the Bank.");
                        currentPlayer.decreaseBalance(250);
                    }
                } else if (board.get(currentPlayer.getPosition()) instanceof Chance) {  //if player steps on Tile Chance, draw card
                    System.out.println("You landed on Chance.");
                    ChanceCard tile = cards.drawCard(currentPlayer);
//                System.out.println("Chance card: " + tile);
                } else {
                    Property tile = (Property) board.get(currentPlayer.getPosition());  //if player steps on property
                    System.out.println(tile);
                    if (tile.hasOwner()) {      // if the property has owner, pay him a fine
//                    fine = tile.getFine();
                        tile.payFine(tile.getFine(), currentPlayer);
                    } else {
                        String answer = null;
                        while (answer == null) {        // if the property is free, ask
                            answer = KeyboardInput.readString("This property doesn't have an owner yet. Do you want to buy it? (Y/N) ").toUpperCase();
                            if (answer.equals("Y")) {
                                tile.buy(currentPlayer);
                            } else if (answer.equals("N")) {
                                System.out.println("Your loss. It's a beautiful building.");
                            } else
                                answer = null;
                        }
                    }
                }
                if (currentPlayer.getBalance() <= 0) {      // player lost
                    System.out.println(currentPlayer.getName() + " you're in debt and you loose. Sorry.\n");
                    killPlayer(currentPlayer);
                }
                System.out.println("\nYour account balance after your turn is " +currentPlayer.getBalance());
            }
            System.out.println("______________________________________________________________________________________");
            nextPlayer();

        }
        System.out.println("Last player remaining, the game ends.\n");

    }

    private void addPlayers(){  // input number of players and give them nicknames
        while (true){
            try{
                playerCount = Integer.parseInt(KeyboardInput.readString("Enter the number of players"));
                if(playerCount > 0 && playerCount <= 6) {
                    break;
                }
            }
            catch (NumberFormatException e){
                System.out.print("Error, you need to enter a number.\nTry again to ");
            }
//            System.out.println(playerCount);
        }
        for(int i = 0; i< playerCount; i++){
            String name = "";
            while (name.length() <= 0) {
                name = KeyboardInput.readString("Enter the name for "+ (i+1) +". player");
                players.add(new Player(name));
            }
        }
    }

    private boolean isWon(){
        return players.size() <= 1;
    }   // while more than 1 players are in game

    private void nextPlayer(){      // give player on next index
        if(currentPlayerIndex >= players.size()-1)
            currentPlayerIndex = 0;
        else currentPlayerIndex++;
    }

    private void killPlayer(Player player){     // if a player is in debt, return his properties and remove him
        player.returnProperties();
        players.remove(player);
    }
}



