

public class Calculations {

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

    public double getCriticalDistance(Pair pair){



        return 0;
    }

}
