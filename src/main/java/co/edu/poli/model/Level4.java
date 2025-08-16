package co.edu.poli.model;

/**
 * Represents Level 4 of the game, which sets the specific rules and parameters
 * for this stage.
 * <p>
 * It is a concrete implementation of the abstract {@link Levels} class.
 * </p>
 */
public class Level4 extends Levels {

    /**
     * Constructor to initialize the parameters for Level 4.
     * <p>
     * It sets the following default values:
     * <ul>
     * <li>Maximum number range: 50</li>
     * <li>Available operations: Subtraction (-), Multiplication (*) and Division (/)</li>
     * <li>Maximum points per correct answer: 100</li>
     * <li>Minimum points per correct answer: 50</li>
     * </ul>
     */
    public Level4(){
        this.rangeMaximum = 50;
        this.operationsAvailable = new String[]{"-", "*", "/"};
        this.pointsMaximum = 100;
        this.pointsMinimum = 50;
    }
}