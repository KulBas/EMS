package dao.RES;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class RES {

    private int id;
    private double coordinateX;
    private double coordinateY;
    private double currentFrequency;
    private List<Double> liters;
    private int priority;

    public Double getNoConflictLiter() {
        return noConflictLiter;
    }

    public void setNoConflictLiter(Double noConflictLiter) {
        this.noConflictLiter = noConflictLiter;
    }

    private Double noConflictLiter;//������ ��������� �� ����������� ������ ��� ������� ���

    public RES(){}


    public RES(int id, double coordinateX, double coordinateY, double currentFrequency, List<Double> liters, int priority) {
        this.id = id;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.currentFrequency = currentFrequency;
        this.liters = new ArrayList<Double>(liters);
        this.priority = priority;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    @XmlElement (name = "coordinateX")
    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    @XmlElement (name = "coordinateY")
    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public double getCurrentFrequency() {
        return currentFrequency;
    }

    @XmlElement (name = "currentFrequency")
    public void setCurrentFrequency(double currentFrequency) {
        this.currentFrequency = currentFrequency;
    }

    public List<Double> getLiters() {
        return liters;
    }

    @XmlElementWrapper(name="Liters")
    @XmlElement(name="liter")
    public void setLiters(List<Double> liters) {
        this.liters = liters;
    }

    public int getPriority() {
        return priority;
    }

    @XmlElement (name = "priority")
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    @XmlAttribute (name = "id")
    public void setId(int id) {
        this.id = id;
    }
}
