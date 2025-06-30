package co.edu.poli.model;

public class Level4 extends Levels {
    // Constructor to determine the values of level4
    public Level4(){
        this.rangeMaximum = 50;
        this.operationsAvailable = new String[]{"-", "*", "/"};
        this.pointsMaximum = 100;
        this.pointsMinimum = 50;
    }
    // Getters
    public int getRangeMaximum(){return this.rangeMaximum;}
    public String[] getOperationsAvailable(){return this.operationsAvailable;}
    public int getPointsMaximum(){return this.pointsMaximum;}
    public int getPointsMinimum(){return this.pointsMinimum;}
}