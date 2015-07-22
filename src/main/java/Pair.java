import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Pair {

    private RES firstRes;
    private RES secondRes;
    private Map<Integer, Integer> linkRES;
    private Double difFrequency;
    private Double realDistance;
    private Double criticalDistance;
    private Double pairRating; //Реальная дальность - критическая
    private LinkedHashMap<Double, Double> CHTR; //<difFrequency(recommended),criticalDistance(recommended)>


    public Pair(RES firstRes, RES secondRes) {
        this.firstRes = firstRes;
        this.secondRes = secondRes;
        linkRES.put(firstRes.getId(), secondRes.getId());
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

    public Map<Integer, Integer> getLinkRES() {
        return linkRES;
    }

    public void setLinkRES(Map<Integer, Integer> linkRES) {
        this.linkRES = linkRES;
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

    public Double getPairRating() {
        return pairRating;
    }

    public void setPairRating(Double pairRating) {
        this.pairRating = pairRating;
    }

    public LinkedHashMap<Double, Double> getCHTR() {
        return CHTR;
    }

    public void setCHTR(LinkedHashMap<Double, Double> CHTR) {
        this.CHTR = CHTR;
    }
}
