package co.edu.poli.model;

public class Level2 extends Levels {
    // Constructor to determine the values of level2
    public Level2(){
        this.rangeMaximum = 20;
        this.operationsAvailable = new String[]{"+", "-"};
        this.pointsMaximum = 60;
        this.pointsMinimum = 30;
    }
    // Getters
    public int getRangeMaximum(){return this.rangeMaximum;}
    public String[] getOperationsAvailable(){return this.operationsAvailable;}
    public int getPointsMaximum(){return this.pointsMaximum;}
    public int getPointsMinimum(){return this.pointsMinimum;}
}