import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pair {

    private RES firstRes;
    private RES secondRes;
    private Map<Integer, Integer> linksRES = new HashMap<Integer, Integer>();
    private Double difFrequency;
    private Double realDistance;
    private Double criticalDistance;


    public Pair(RES firstRes, RES secondRes) {
        this.firstRes = firstRes;
        this.secondRes = secondRes;
        linksRES.put(firstRes.getId(), secondRes.getId());
    }

    public RES getFirstRes() {
        return firstRes;
    }

    public void setFirstRes(RES firstRes) {
        this.firstRes = firstRes;
    }

    public RES getSecondRes() {
        return secondRes;
    }

    public void setSecondRes(RES secondRes) {
        this.secondRes = secondRes;
    }

    public Map<Integer, Integer> getLinksRES() {
        return linksRES;
    }

    public void setLinksRES(Map<Integer, Integer> linksRES) {
        this.linksRES = linksRES;
    }

    public Double getDifFrequency() {
        return difFrequency;
    }

    public void setDifFrequency(Double difFrequency) {
        this.difFrequency = difFrequency;
    }

    public Double getRealDistance() {
        return realDistance;
    }

    public void setRealDistance(Double realDistance) {
        this.realDistance = realDistance;
    }

    public Double getCriticalDistance() {
        return criticalDistance;
    }

    public void setCriticalDistance(Double criticalDistance) {
        this.criticalDistance = criticalDistance;
    }
}
