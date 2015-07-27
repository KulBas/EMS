import dao.CHTR.CHTR;
import dao.CHTR.Point;
import dao.Pair;
import dao.RES.RES;

import java.util.*;

public class Processing {

    // TODO: дописать
    public void process(List<Pair> pairsList) {
        Calculations calc = new Calculations();
//        for (Pair pair : pairsList) {//для всех пар объектов находим не конфликтные литеры
//            calc.checkFreeFrequencies(pair);
//        }
        List<Pair> regularizedPairList = regularizePairsByRating(pairsList);

        for (Pair pair : regularizedPairList) {

            RES firstRes = pair.getFirstRes();
            RES secondRes = pair.getSecondRes();
            if (pair.getPairRating() <= 0) {
                //Возможно перестроение по частоте? и т.д.
                System.out.println("Проверяется конфликтная пара " + firstRes.getId() + " и " + secondRes.getId());
                calc.checkFreeFrequencies(pair);
                boolean change = false;
                Double firstNoConflictLiter = pair.getFirstNoConflictLiter();
                Double secondNoConflictLiter = pair.getSecondNoConflictLiter();
                if (firstRes.getPriority() >= secondRes.getPriority()) {
                    change = changeCurrentFrequency(pair, firstRes,firstNoConflictLiter);
                    if (!change) {
                        change = changeCurrentFrequency(pair, secondRes,secondNoConflictLiter);
                    }
                } else if (secondRes.getPriority() > firstRes.getPriority()) {
                     change = changeCurrentFrequency(pair, secondRes,secondNoConflictLiter);
                    if (!change) {
                        change = changeCurrentFrequency(pair, firstRes,firstNoConflictLiter);
                    }
                }
                if(!change){
                    System.out.println("Для пары РЭС " +firstRes.getId()+" и "+secondRes.getId()+" невозможна отстройка по частоте, необходима перестройка помощности или дальности"+"\n");
                }
            } else {
                System.out.println("Пары РЭС " + firstRes.getId() + " и " + secondRes.getId() + " не конфликтуют"+"\n");
            }
        }


    }

    public boolean changeCurrentFrequency(Pair pair, RES res,Double liter) {
        if (liter != null) {
            Double currentFrequency = res.getCurrentFrequency();
            res.setCurrentFrequency(liter);
            System.out.println("Для РЭС " + res.getId() + " произведена перестройка по частоте c " + currentFrequency + " на " + res.getCurrentFrequency()+"\n");
            return true;
        } else {
            System.out.println("Для РЭС " + res.getId() + " нет свободной не конфликтной литеры");
            return false;
        }
    }

    /**
     * Создает в цикле все пары объектов по принципу "каждый с каждым"
     *
     * @param resList  - коллекция полученных объектов РЭС
     * @param CTHRList - <Рекоменд.Дальность,Разность частот РЭС>
     * @return список всех пар объектов
     */
    public List<Pair> createAllPairs(List<RES> resList, List<CHTR> CTHRList) {
        List<Pair> pairsList = new ArrayList<Pair>();

        for (int i = 0; i < resList.size(); i++) {

            for (int j = 0; j < resList.size(); j++) {

                if (i < j) {
                    RES firstRES = resList.get(i);
                    RES secondRES = resList.get(j);

                    Pair pair = new Pair(firstRES, secondRES);

                    for (CHTR chtr : CTHRList) {
                        if (chtr.getFirstRESId() == firstRES.getId() && chtr.getSecondRESId() == secondRES.getId()) {
                            pair.setCHTR(chtr);
                        }
                    }
                    Calculations calc = new Calculations();

                    pair.setDifFrequency(calc.countDifFrequency(pair));
                    pair.setRealDistance(calc.countRealDistance(pair));

                    Point criticalPoint = calc.countCriticalPoint(pair);
                    pair.setCriticalDistance(criticalPoint.getCriticalDistance());
                    pair.setCriticalFrequency(criticalPoint.getCriticalDifFrequency());
                    pair.setPairRating(calc.countPairRating(pair));


                    pairsList.add(pair);
                }
            }
        }

//       Посмотреть список созданных пар, и данные к ним

        System.out.println("\n CREATED " + pairsList.size() + " PAIRs" + "\n");
        for (Pair pair : pairsList) {

            System.out.println("---------------------NEW PAIR----------------");
            System.out.println("First RES id: " + pair.getFirstRes().getId());
            System.out.println("SEC RES id: " + pair.getSecondRes().getId());
            System.out.println("CRITICAL DISTANCE: " + pair.getCriticalDistance());
            System.out.println("CRITICAL FREQUENCY: " + pair.getCriticalFrequency());
            System.out.println("difFrequency " + pair.getDifFrequency());
            System.out.println("REAL DISTANCE: " + pair.getRealDistance());
            System.out.println("PAIR RATING: " + pair.getPairRating());
            System.out.println("CHTR IDs: " + pair.getCHTR().getFirstRESId() + "-" + pair.getCHTR().getSecondRESId() + "\n");
        }

        return pairsList;
    }

    /**
     * метод для упорядочивания пар РЭС по рейтингу (Дреальая - Дкритическая)
     *
     * @param pairsList Коллекция пар РЭС
     */
    public List<Pair> regularizePairsByRating(List<Pair> pairsList) {

        Collections.sort(pairsList, new Comparator<Pair>() {
            public int compare(Pair pair1, Pair pair2) {
                return pair1.getPairRating().compareTo(pair2.getPairRating());
            }
        });
        return pairsList;
    }

}
