package dao.CHTR;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Yury on 25.07.2015.
 */

public class Point {
    private Double criticalDistance;
    private Double criticalDifFrequency;

    public Double getCriticalDistance() {
        return criticalDistance;
    }

    @XmlElement(name = "criticalDistance")
    public void setCriticalDistance(Double criticalDistance) {
        this.criticalDistance = criticalDistance;
    }

    public Double getCriticalDifFrequency() {
        return criticalDifFrequency;
    }
    @XmlElement (name = "criticalDifFrequency")
    public void setCriticalDifFrequency(Double criticalDifFrequency) {
        this.criticalDifFrequency = criticalDifFrequency;
    }
}
