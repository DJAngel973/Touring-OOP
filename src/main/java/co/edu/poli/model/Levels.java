package co.edu.poli.model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Levels {

    // Attributes, the protected for inheritance is accessible
    public int firstNumber;
    public int secondNumber;
    public int rangeMaximum;
    public String[] operationsAvailable;
    protected int answer;
    protected String operation;
    protected int[] optionAnswer;
    protected int pointsMaximum;
    protected int pointsMinimum;

    // Method for generating a mathematical question
    public void createQuestion(){
        if (this.rangeMaximum <= 0){
            // Throw an exception to handle invalid range input
            throw new IllegalArgumentException(String.format("El rango máximo deber ser mayor que cero. Valor actual: %d", this.rangeMaximum));
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
    // Generate response options, including the correct with several false
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
    // Getters
    public String getOperation(){return String.format( "%d %s %d = ?", this.firstNumber, this.operation, this.secondNumber);}
    public int[] getOptionAnswer(){return this.optionAnswer;}
    public int getAnswer(){return this.answer;}
    public int getPointsMaximum(){return this.pointsMaximum;}
    public int getPointsMinimum(){return this.pointsMinimum;}
    public boolean hasMoreQuestions(){return false;}
}