import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

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
     * @return Критическая дистанция
     */
    //TODO:исправить цикл, в этом же методе надо записывать критическую дельта f для пары объектов
    public double countCriticalDistance(Pair pair) {
        LinkedHashMap<Double, Double> CHTR = pair.getCHTR();
        Double difFrequency = pair.getDifFrequency();
        Double criticalDistance = null;


        for (int i = 0; i < CHTR.size(); i++) {
            if (difFrequency > CHTR.get(i)) {
                continue;
            } else {
                criticalDistance = CHTR.get(i - 1);
                return criticalDistance;
            }

        }
        return criticalDistance;
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
     *               перебираем относительно первого объекта, потом относительно второго
     */
    public void checkFreeFrequencies(Pair pair) {
        RES firstRes = pair.getFirstRes();
        RES secondRes = pair.getSecondRes();
        List<Double> secondResLiters = secondRes.getLiters();
        Double deltaF;
       for(Double firstResLiters: firstRes.getLiters()){
           deltaF = Math.abs(firstResLiters - secondRes.getCurrentFrequency());
           if(deltaF > pair.getCriticalFrequency()){
               firstRes.setNoConflictLiter(firstResLiters);
           }
       }
    }
}