package co.edu.poli.model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * An abstract class that serves as a base for defining game levels.
 * <p>
 * This class contains the core logic for generating mathematical questions,
 * calculating answers, and creating answer options, allowing subclasses (like
 * {@link Level1}) to configure specific parameters.
 */
public abstract class Levels {

    /** The first number in the operation. */
    public int firstNumber;
    /** The second number in the operation. */
    public int secondNumber;
    /** The maximum range for the numbers in the operation. */
    public int rangeMaximum;
    /** The array of available mathematical operations for the level. */
    public String[] operationsAvailable;
    /** The correct answer to the operation. */
    protected int answer;
    /** The selected mathematical operation. */
    protected String operation;
    /** The array of answer options, which includes the correct one. */
    protected int[] optionAnswer;
    /** The maximum score that can be obtained for a correct answer. */
    protected int pointsMaximum;
    /** The minimum score that can be obtained for a correct answer. */
    protected int pointsMinimum;

    /**
     * Generates a new random mathematical question and its answer options.
     * <p>
     *     It ensures that the numbers and operations are valid for the level's rules,
     *     and handles special cases such as division and subtraction.
     * </p>
     * @throws IllegalArgumentException if the {@code rangeMaximum} is less than or equal to zero.
     * @throws UnsupportedOperationException if the generated operation is not supported.
     */
    public void createQuestion(){
        if (this.rangeMaximum <= 0){
            // Throw an exception to handle invalid range input
            throw new IllegalArgumentException(String.format("El rango máximo deber ser mayor que cero. Valor actual: %d\n", this.rangeMaximum));
        }else{
            // Random to generate random numbers
            Random randomNumber = new Random();
            this.firstNumber = randomNumber.nextInt(this.rangeMaximum) + 1; // Create number within the maximum range
            this.secondNumber = randomNumber.nextInt(this.rangeMaximum) + 1;
            this.operation = this.operationsAvailable[randomNumber.nextInt(this.operationsAvailable.length)]; // Take operation random the list

            // Switch implement to assign the operation according to the type of operator
            switch (this.operation){
                case "+":
                    this.answer = this.firstNumber + this.secondNumber;
                    break;
                case "-":
                    // Ensure that the firstNumber is greater
                    if (this.firstNumber < this.secondNumber) {
                        int temporary = this.firstNumber; // Variable temporary for take the firstNumber and exchange
                        this.firstNumber = this.secondNumber;
                        this.secondNumber = temporary;
                    }
                    this.answer = this.firstNumber - this.secondNumber;
                    break;
                case "*":
                    this.answer = this.firstNumber * this.secondNumber;
                    break;
                case "/":
                    // Implement do-while for the forcing firstNumber to be greater and divisible than secondNumber
                    do{
                        this.firstNumber = randomNumber.nextInt(this.rangeMaximum) + 1;
                        this.secondNumber = randomNumber.nextInt(this.rangeMaximum) + 1;
                    }while(this.firstNumber < this.secondNumber || this.firstNumber % this.secondNumber != 0);
                    this.answer = this.firstNumber / this.secondNumber;
                    break;
                default:
                    throw new UnsupportedOperationException(String.format("Operación no soportada: %s", this.operation));
            }
            // After calculating the correct answer, generate the multiple-choice options
            this.createOptions(this.answer);
        }
    }

    /**
     * Generates an array of three answer options, including the correct one and two incorrect ones.
     * The incorrect options are randomly generated non-duplicate numbers.
     * The final options array is shuffled so the correct answer is not always in the same position.
     * @param answerCorrect The correct answer for the question.
     */
    public void createOptions(int answerCorrect){
        Random randomOption = new Random();
        this.optionAnswer = new int[3]; // Arrangement of 3 spaces
        Set<Integer> possibleAnswers = new HashSet<>(); // Set to avoid duplicate answers 'possibleAnswers' uses HashSet implementation: unordered, fast access, and no duplicate elements
        possibleAnswers.add(answerCorrect);
        this.optionAnswer[0] = answerCorrect; // Add correct zero position

        // Position options answer
        int positionAnswer = 1;

        // Loop to generate two more false response
        while(possibleAnswers.size() < 3){ // .size() tell how many unique values contains 'possibleAnswers'
            int rangeNumber = randomOption.nextInt(11) -5; // Create number between 0-10, '-5' for final number
            int answerFalse = answerCorrect + rangeNumber; // Create number for a false answer
            // if the number is negative it becomes positive 'Math.abs()'
            if (answerFalse < 0){
                answerFalse = Math.abs(answerFalse);
            }
            // Ensure not add repeated answers
            // .contains verify if the 'answerFalse' is inside 'possibleAnswers','!' if this is not, 'if' is executed
            if (!possibleAnswers.contains(answerFalse)){
                possibleAnswers.add(answerFalse);
                this.optionAnswer[positionAnswer++] = answerFalse;
            }
        }
        // Shuffle the answer options to display them in random order
        for(int i = 0; i < this.optionAnswer.length; ++i){
            int randomIndex = randomOption.nextInt(this.optionAnswer.length); // We generate a random index
            int numTemporary = this.optionAnswer[i]; // Change response position
            this.optionAnswer[i] = this.optionAnswer[randomIndex]; // Change response position
            this.optionAnswer[randomIndex] = numTemporary; // Change response position
        }
    }

    /**
     * Gets the mathematical question as a string.
     * @return The formatted question (e.g., "5 + 3 = ?").
     */
    public String getOperation(){return String.format( "%d %s %d = ?\n", this.firstNumber, this.operation, this.secondNumber);}
    /**
     * Gets the generated answer options for the current question.
     * @return An array of integers with the answer options.
     */
    public int[] getOptionAnswer(){return this.optionAnswer;}
    /**
     * Gets the correct answer to the current question.
     * @return The correct answer.
     */
    public int getAnswer(){return this.answer;}
    /**
     * Gets the maximum number of points that can be earned in this level.
     * @return The maximum points.
     */
    public int getPointsMaximum(){return this.pointsMaximum;}
    /**
     * Gets the minimum number of points that can be earned in this level.
     * @return The minimum points.
     */
    public int getPointsMinimum(){return this.pointsMinimum;}

    /**
     * Indicates whether there are more questions available in this level.
     * This method can be overridden in subclasses if the game has a limited
     * number of questions per level.
     * @return Always {@code false} by default, indicating that the level has no question limit.
     */
    public boolean hasMoreQuestions(){return false;}
}