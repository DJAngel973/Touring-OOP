package co.edu.poli.model;

/**
 * Represents Level 1 of the game, which sets the specific rules and parameters
 * for this stage.
 * <p>
 *     It is a concrete implementation of the abstract {@link Levels} class.
 * </p>
 */
public class Level1 extends Levels {

    /**
     * Constructor to initialize the parameters for Level 1.
     * <p>
     * It sets the following default values:
     * <ul>
     * <li>Maximum number range: 9</li>
     * <li>Available operations: Addition (+) and Subtraction (-)</li>
     * <li>Maximum points per correct answer: 50</li>
     * <li>Minimum points per correct answer: 25</li>
     * </ul>
     */
    public Level1(){
        this.rangeMaximum = 9;
        this.operationsAvailable = new String[]{"+", "-"};
        this.pointsMaximum = 50;
        this.pointsMinimum = 25;
    }
}