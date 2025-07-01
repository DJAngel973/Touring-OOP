package co.edu.poli.model;

//Create Player class to enter a user into the game
public class Player {

    //Attributes for the player
    private String name;
    private int points;
    private int lives;

    //Constructor for the initial state of the player object
    public Player(String name){
        this.name = name;
        this.points = 0;
        this.lives = 3;
    }

    //Getters and setters
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}

    public int getPoints(){return this.points;}
    public void setPoints(int points){this.points = points;}

    public int getLives(){return this.lives;}
    public void setLives(int lives){this.lives = lives;}

    //Methods to update game status
    public void addPoints(int points){this.points += points;}
    public void subtractLives(){--this.lives;}

    //Method for sum lives 'increase lives if possible'(Incrementar vidas si es posible.)
    public void increaseLivesPossible(){
        if (this.lives < 3){
            ++this.lives;
        }
    }
}
