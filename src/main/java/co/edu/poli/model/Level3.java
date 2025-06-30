package co.edu.poli.model;

public class Level3 extends Levels {
    // Constructor to determine the values of level3
    public Level3(){
        this.rangeMaximum = 30;
        this.operationsAvailable = new String[]{"+", "-", "*"};
        this.pointsMaximum = 80;
        this.pointsMinimum = 40;
    }
    // Getters
    public int getRangeMaximum(){return this.rangeMaximum;}
    public String[] getOperationsAvailable(){return this.operationsAvailable;}
    public int getPointsMaximum(){return this.pointsMaximum;}
    public int getPointsMinimum(){return this.pointsMinimum;}
}