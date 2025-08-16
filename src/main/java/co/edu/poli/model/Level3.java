package co.edu.poli.model;

/**
 * Represents Level 3 of the game, which sets the specific rules and parameters
 * for this stage.
 * <p>
 * It is a concrete implementation of the abstract {@link Levels} class.
 * </p>
 */
public class Level3 extends Levels {

    /**
     * Constructor to initialize the parameters for Level 3.
     * <p>
     * It sets the following default values:
     * <ul>
     * <li>Maximum number range: 30</li>
     * <li>Available operations: Addition (+), Subtraction (-) and Multiplication (*)</li>
     * <li>Maximum points per correct answer: 80</li>
     * <li>Minimum points per correct answer: 40</li>
     * </ul>
     */
    public Level3(){
        this.rangeMaximum = 30;
        this.operationsAvailable = new String[]{"+", "-", "*"};
        this.pointsMaximum = 80;
        this.pointsMinimum = 40;
    }
}