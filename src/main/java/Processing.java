import java.util.*;

public class Processing {

    // TODO: дописать
    public void process(List<RES> resList,LinkedHashMap<Double,Double> CTHR) {
        List<Pair> pairsList = createAllPairs(resList,CTHR);
        List<Pair> regularizedPairList = regularizePairsByRating(pairsList);

        for (Pair pair : regularizedPairList) {
            if (pair.getPairRating() <= 0) {
                //Возможно перестроение по частоте? и т.д.

            } else {
                // Если не критично:
                //Скорость сближения равна нулю? т.д.
            }
        }


    }

    /**
     * Создает в цикле все пары объектов по принципу "каждый с каждым"
     *
     * @param resList - коллекция полученных объектов РЭС
     * @param CTHR - <Рекоменд.Дальность,Разность частот РЭС>
     * @return список всех пар объектов
     */
    public List<Pair> createAllPairs(List<RES> resList,LinkedHashMap<Double,Double> CTHR) {
        List<Pair> pairsList = new ArrayList<Pair>();

        for (int i = 0; i < resList.size(); i++) {

            for (int j = 0; j < resList.size(); j++) {

                if (i < j) {

                    Pair pair = new Pair(resList.get(i), resList.get(j));

                    Calculations calc = new Calculations();
                    pair.setCriticalDistance(calc.countCriticalDistance(pair));
                    pair.setDifFrequency(calc.countDifFrequency(pair));
                    pair.setRealDistance(calc.countRealDistance(pair));
                    pair.setPairRating(calc.countPairRating(pair));
                    pair.setCHTR(CTHR);
                    pairsList.add(pair);
                }
            }
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
