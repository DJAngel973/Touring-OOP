package co.edu.poli.model;

import java.util.Random;

public class Levels {

    //Attributes, the protected for inheritance is accessible
    public int firstNumber;
    public int secondNumber;
    public int rangeMaximum;
    public String[] operationsAvailable;
    protected int answer;
    protected String operation;
    protected int[] optionAnswer;
    protected int pointsMaximum;
    protected int pointsMinimum;

    //Method for generating a mathematical question
    public void createQuestion(){
        if (this.rangeMaximum <= 0){
            //Create an Exception to handle incorrect entries
            throw new IllegalArgumentException(String.format("El rango máximo deber ser mayor que cero. Valor actual: %d", this.rangeMaximum));
        }else{
            //Random to generate random numbers
            Random randomNumber = new Random();
            this.firstNumber = randomNumber.nextInt(this.rangeMaximum) + 1; //Create number within the maximum range
            this.secondNumber = randomNumber.nextInt(this.rangeMaximum) + 1;
            this.operation = this.operationsAvailable[randomNumber.nextInt(this.operationsAvailable.length)]; //Take operation random the list

        }
    }
}
