import java.util.HashMap;
import java.util.Map;

public class Pair {

    private RES firstRes;
    private RES secondRes;
    private Map<Integer, Integer> linksRES = new HashMap<Integer, Integer>();

    public Pair(RES firstRes, RES secondRes) {
        this.firstRes = firstRes;
        this.secondRes = secondRes;

        this.linksRES.put(firstRes.getId(), secondRes.getId());
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
}
