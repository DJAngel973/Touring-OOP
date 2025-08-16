package co.edu.poli.model;

/**
 * Represents a player in a game,
 * This class manages the player's name, points, and live,
 * and allows interaction with the game logic.
 * */
public class Player {

    /** The name of the player. */
    private String name;
    /** The points accumulated by the player. */
    private int points;
    /** The number lives of lives remaining for the player. */
    private int lives;

    /**
     * Constructs a new player with a specified name.
     * <p>
     *    Upon creation, the player starts with 0 points and 3 lives by default.
     * </p>
     * @param name the name of the ser.
     * */
    public Player(String name){
        this.name = name;
        this.points = 0;
        this.lives = 3;
    }

    // Getters
    /**
     * Gets the player's name.
     * @return the player's name.
     * */
    public String getName(){return this.name;}
    /**
     * Gets the player's current points.
     * @return The number of points..
     * */
    public int getPoints(){return this.points;}
    /**
     * Gets the number of lives remaining for the player..
     * @return The number of lives.
     * */
    public int getLives(){return this.lives;}

    /**
     * Adds points to the player's current score.
     * @param points The number of points to add.
     * */
    public void addPoints(int points){this.points += points;}

    /**
     * Subtracts one life from the player.
     * This method is used when the player loses a round or opportunity.
     * */
    public void subtractLives(){--this.lives;}

    /**
     * Increases the player`s number of lives by 1.
     * The maximum number of lives allowed is 3. If the payer already has
     * 3 lives, no action is taken.
     * */
    public void increaseLivesPossible(){
        if (this.lives < 3){
            ++this.lives;
        }
    }
}