
public class RES {

    private int coordinateX;
    private int coordinateY;
    private double currentFrequency;
    private double[] liters;
    private int priority;

    public RES(int coordinateX,int coordinateY,double currentFrequency, double[] liters,int priority){
       this.coordinateX= coordinateX;
       this.coordinateY= coordinateY;
       this.currentFrequency=currentFrequency;
       this.liters=liters;
       this.priority=priority;
    };

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public double getCurrentFrequency() {
        return currentFrequency;
    }

    public void setCurrentFrequency(double currentFrequency) {
        this.currentFrequency = currentFrequency;
    }

    public double[] getLiters() {
        return liters;
    }

    public void setLiters(double[] liters) {
        this.liters = liters;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
