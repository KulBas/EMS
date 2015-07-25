import dao.CHTR.CHTR;
import dao.CHTR.Point;
import dao.Pair;
import dao.RES.RES;

public class Calculations {


    /**
     * Расчет разности частот РЭС
     *
     * @param pair Пара РЭС
     * @return Разность частот
     */
    public double countDifFrequency(Pair pair) {
        double firstResFrequency = pair.getFirstRes().getCurrentFrequency();
        double secondResFrequency = pair.getSecondRes().getCurrentFrequency();
        double resultFrequency = Math.abs(firstResFrequency - secondResFrequency);
        return resultFrequency;
    }

    /**
     * Расчет реальной дистанции для пары, по координатам двух РЭС
     *
     * @param pair Пара РЭС
     * @return Реальная дистанция между РЭС
     */
    public double countRealDistance(Pair pair) {
        RES firstRES = pair.getFirstRes();
        RES secondRES = pair.getSecondRes();
        double firstX = firstRES.getCoordinateX();
        double secondX = secondRES.getCoordinateX();
        double firstY = firstRES.getCoordinateY();
        double secondY = secondRES.getCoordinateY();

        double realDistance = Math.sqrt((Math.pow((firstX - secondX), 2)) + (Math.pow((firstY - secondY), 2)));
        return realDistance;
    }

    /**
     * Расчет критической дистанции для пары, по ЧТР и разности частот РЭС
     *
     * @param pair Пара РЭС
     * @return  Point - критическая точка (крит.дальность,крит.частота)
     */
    public Point countCriticalPoint(Pair pair) {
        CHTR CHTR = pair.getCHTR();
        Double difFrequency = pair.getDifFrequency();
        Double criticalDistance;
        Point point=new Point();

        for (int i = 0; i < CHTR.getPoints().size(); i++) {

            if (difFrequency > CHTR.getPoints().get(i).getCriticalDifFrequency()) {
                continue;
            } else {
                if(i==0){
                    criticalDistance = CHTR.getPoints().get(i).getCriticalDistance();
                    point.setCriticalDistance(criticalDistance);
                    point.setCriticalDifFrequency(CHTR.getPoints().get(i).getCriticalDifFrequency());
                    return point;
                }else
                criticalDistance = CHTR.getPoints().get(i - 1).getCriticalDistance();
                point.setCriticalDistance(criticalDistance);
                point.setCriticalDifFrequency(CHTR.getPoints().get(i - 1).getCriticalDifFrequency());
                return point;
            }

        }
        return point;
    }


    /**
     * Вычисление рейтинга критичности для пары
     *
     * @param pair Пара РЭС
     * @return рейтинг пары = Дреальная-Дкритическая;
     */
    public double countPairRating(Pair pair) {
        return pair.getRealDistance() - pair.getCriticalDistance();
    }

    /**
     * Составление списка не конфликтных литер
     *
     * @param pair - пара объектов, для которой находим не конфликтные литеры, сначала
     *             перебираем относительно первого объекта, потом относительно второго
     */
    public void checkFreeFrequencies(Pair pair) {
        RES firstRes = pair.getFirstRes();
        RES secondRes = pair.getSecondRes();
        Double deltaF;
        for (Double firstResLiters : firstRes.getLiters()) {
            deltaF = Math.abs(firstResLiters - secondRes.getCurrentFrequency());
            if (deltaF > pair.getCriticalFrequency()) {
                firstRes.setNoConflictLiter(firstResLiters);
            }
        }
        for (Double secondResLiters : secondRes.getLiters()) {
            deltaF = Math.abs(secondResLiters - firstRes.getCurrentFrequency());
            if (deltaF > pair.getCriticalFrequency()) {
                secondRes.setNoConflictLiter(secondResLiters);
            }
        }
    }
}