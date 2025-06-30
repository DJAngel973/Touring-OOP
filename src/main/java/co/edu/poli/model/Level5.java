package co.edu.poli.model;

public class Level5 extends Levels {
    // Constructor to determine the values of level5
    public Level5(){
        this.rangeMaximum = 80;
        this.operationsAvailable = new String[]{"*", "/"};
        this.pointsMaximum = 150;
        this.pointsMinimum = 70;
    }
    // Getters
    public int getRangeMaximum(){return this.rangeMaximum;}
    public String[] getOperationsAvailable(){return this.operationsAvailable;}
    public int getPointsMaximum(){return this.pointsMaximum;}
    public int getPointsMinimum(){return this.pointsMinimum;}
}
