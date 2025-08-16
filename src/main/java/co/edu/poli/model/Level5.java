package co.edu.poli.model;

/**
 * Represents Level 5 of the game, which sets the specific rules and parameters
 * for this stage.
 * <p>
 * It is a concrete implementation of the abstract {@link Levels} class.
 * </p>
 */
public class Level5 extends Levels {

    /**
     * Constructor to initialize the parameters for Level 5.
     * <p>
     * It sets the following default values:
     * <ul>
     * <li>Maximum number range: 80</li>
     * <li>Available operations: Multiplication (*) and Division (/)</li>
     * <li>Maximum points per correct answer: 150</li>
     * <li>Minimum points per correct answer: 70</li>
     * </ul>
     */
    public Level5(){
        this.rangeMaximum = 80;
        this.operationsAvailable = new String[]{"*", "/"};
        this.pointsMaximum = 150;
        this.pointsMinimum = 70;
    }
}