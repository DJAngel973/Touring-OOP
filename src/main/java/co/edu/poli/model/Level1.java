package co.edu.poli.model;

public class Level1 extends Levels {
    // Constructor to determine the values of level1
    public Level1(){
        this.rangeMaximum = 9;
        this.operationsAvailable = new String[]{"+", "-"};
        this.pointsMaximum = 50;
        this.pointsMinimum = 25;
    }
    // Getters
    public int getRangeMaximum(){return this.rangeMaximum;}
    public String[] getOperationsAvailable(){return this.operationsAvailable;}
    public int getPointsMaximum(){return this.pointsMaximum;}
    public int getPointsMinimum(){return this.pointsMinimum;}
}