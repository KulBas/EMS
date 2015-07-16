import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pair {

    private RES firstRes;
    private RES secondRes;
    private Map<Integer, Integer> linksRES = new HashMap<Integer, Integer>();
    private List<Pair> pairsList = new ArrayList<Pair>();

    public Pair() {
    }

    public void addNewPair(RES firstRes, RES secondRes) {
        Pair pair = new Pair();
        pair.setFirstRes(firstRes);
        pair.setSecondRes(secondRes);
        linksRES.put(firstRes.getId(), secondRes.getId());
        pairsList.add(pair);
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
