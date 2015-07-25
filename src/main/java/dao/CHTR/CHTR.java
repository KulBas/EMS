package dao.CHTR;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Yury on 25.07.2015.
 */
public class CHTR {

    private int firstRESId;
    private int secondRESId;
    private List<Point> points;

    public int getFirstRESId() {
        return firstRESId;
    }

    @XmlElement (name = "firstRESId")
    public void setFirstRESId(int firstRESId) {
        this.firstRESId = firstRESId;
    }

    public int getSecondRESId() {
        return secondRESId;
    }

    @XmlElement (name = "secondRESId")
    public void setSecondRESId(int secondRESId) {
        this.secondRESId = secondRESId;
    }

    public List<Point> getPoints() {
        return points;
    }

    @XmlElementWrapper
    @XmlElement (name = "Point")
    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
