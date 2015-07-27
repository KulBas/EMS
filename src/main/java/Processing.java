import dao.CHTR.CHTR;
import dao.CHTR.Point;
import dao.Pair;
import dao.RES.RES;

import java.util.*;

public class Processing {

    // TODO: дописать
    public void process(List<RES> resList, List<CHTR> chtrList) {
        List<Pair> pairsList = createAllPairs(resList, chtrList);
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
                calc.checkFreeFrequencies(pair);
                if(firstRes.getPriority() > secondRes.getPriority()){
                    if (pair.getFirstNoConflictLiter() != null){
                        changeCurrentFrequency(pair,firstRes);
                    }
                    else{
                        System.out.println("Для РЭС " + firstRes.getId()+" нет свободной не конфликтной литеры, необходимо перестроение по дальности или мощности");
                    }
                }else{
                    if(pair.getSecondNoConflictLiter() != null){
                        changeCurrentFrequency(pair,secondRes);
                    }else{
                        System.out.println("Для РЭС " + firstRes.getId() + " нет свободной не конфликтной литеры, необходимо перестроение по дальности или мощности");
                    }
                }

            } else {
                System.out.println("Пары РЭС "+firstRes.getId()+" и "+secondRes.getId()+" не конфликтуют");
            }
        }


    }

    public void changeCurrentFrequency(Pair pair, RES res){
        Double currentFrequency = res.getCurrentFrequency();
        res.setCurrentFrequency(pair.getFirstNoConflictLiter());
        System.out.println("Для РЭС " + res.getId()+" произведена перестройка по частоте c "+currentFrequency + " на "+res.getCurrentFrequency());
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
                        if (chtr.getFirstRESId()==firstRES.getId() && chtr.getSecondRESId()==secondRES.getId() ){
                            pair.setCHTR(chtr);
                        }
                    }
                    Calculations calc = new Calculations();

                    pair.setDifFrequency(calc.countDifFrequency(pair));
                    pair.setRealDistance(calc.countRealDistance(pair));

                    Point criticalPoint=calc.countCriticalPoint(pair);
                    pair.setCriticalDistance(criticalPoint.getCriticalDistance());
                    pair.setCriticalFrequency(criticalPoint.getCriticalDifFrequency());
                    pair.setPairRating(calc.countPairRating(pair));


                    pairsList.add(pair);
                }
            }
        }

//       Посмотреть список созданных пар, и данные к ним

        System.out.println("\n CREATED "+pairsList.size()+" PAIRs"+"\n");
        for (Pair pair:pairsList){

            System.out.println("---------------------NEW PAIR----------------");
            System.out.println("First RES id: "+pair.getFirstRes().getId());
            System.out.println("SEC RES id: " + pair.getSecondRes().getId());
            System.out.println("CRITICAL DISTANCE: "+pair.getCriticalDistance());
            System.out.println("CRITICAL FREQUENCY: "+pair.getCriticalFrequency());
            System.out.println("difFrequency "+ pair.getDifFrequency());
            System.out.println("REAL DISTANCE: "+pair.getRealDistance());
            System.out.println("PAIR RATING: "+pair.getPairRating());
            System.out.println("CHTR IDs: "+pair.getCHTR().getFirstRESId()+"-"+pair.getCHTR().getSecondRESId());
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
