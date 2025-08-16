package co.edu.poli.model;

/**
 * Represents Level 2 of the game, which sets the specific rules and parameters
 * for this stage.
 * <p>
 * It is a concrete implementation of the abstract {@link Levels} class.
 * </p>
 */
public class Level2 extends Levels {

    /**
     * Constructor to initialize the parameters for Level 2.
     * <p>
     * It sets the following default values:
     * <ul>
     * <li>Maximum number range: 20</li>
     * <li>Available operations: Addition (+) and Subtraction (-)</li>
     * <li>Maximum points per correct answer: 60</li>
     * <li>Minimum points per correct answer: 30</li>
     * </ul>
     */
    public Level2(){
        this.rangeMaximum = 20;
        this.operationsAvailable = new String[]{"+", "-"};
        this.pointsMaximum = 60;
        this.pointsMinimum = 30;
    }
}