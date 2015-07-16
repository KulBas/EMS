import java.util.ArrayList;
import java.util.List;

public class Calculations {

    private List<Pair> pairsList = new ArrayList<Pair>();

    public void addNewPair(RES firstRes, RES secondRes){
        Pair pair=new Pair(firstRes,secondRes);
        pairsList.add(pair);
    }
    //TODO: сделать дальше расчет



    public double countDifFrequency(Pair pair) {
        double firstResFrequency = pair.getFirstRes().getCurrentFrequency();
        double secondResFrequency = pair.getSecondRes().getCurrentFrequency();
        double resultFrequency = Math.abs(firstResFrequency - secondResFrequency);
        return resultFrequency;
    }

    public double countRealDistance(Pair pair) {
        double firstX = pair.getFirstRes().getCoordinateX();
        double secondX = pair.getSecondRes().getCoordinateX();
        double firstY = pair.getFirstRes().getCoordinateY();
        double secondY = pair.getSecondRes().getCoordinateY();

        double realDistance = Math.sqrt((Math.pow((firstX - secondX), 2)) + (Math.pow((firstY - secondY), 2)));
        return realDistance;
    }

  // TODO: write method for the CriticalDistance
   public double getCriticalDistance(Pair pair){
        return 0;
    }


    public List<Pair> getPairsList() {
        return pairsList;
    }

    public void setPairsList(List<Pair> pairsList) {
        this.pairsList = pairsList;
    }
}
