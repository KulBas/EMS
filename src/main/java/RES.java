import java.util.List;

public class RES {

    private int id;
    private double coordinateX;
    private double coordinateY;
    private double currentFrequency;
    private List<Double> liters;
    private int priority;

    public RES(int id, double coordinateX, double coordinateY, double currentFrequency, List<Double> liters, int priority) {
        this.id = id;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.currentFrequency = currentFrequency;
        this.liters = liters;
        this.priority = priority;
    }

    ;

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY() {
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

    public List<Double> getLiters() {
        return liters;
    }

    public void setLiters(List<Double> liters) {
        this.liters = liters;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
