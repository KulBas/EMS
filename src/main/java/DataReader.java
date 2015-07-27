import dao.CHTR.CHTR;
import dao.CHTR.CHTRList;
import dao.CHTR.Point;
import dao.Pair;
import dao.RES.RES;
import dao.RES.RESList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static List<RES> resList = new ArrayList<RES>();
    private List<Double> liters = new ArrayList<Double>();

    public RESList readRESList() {
        RESList resList = null;
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(RESList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            resList = (RESList) jaxbUnmarshaller.unmarshal(new File("src/main/resources/RESList.xml"));
//            Вывод полученных данных:
//            for (RES res : resList.getRESList()) {
//                System.out.println("-----------------NEW RES-------------");
//                System.out.println("CoordX: " + res.getCoordinateX());
//                System.out.println("CoordY: " + res.getCoordinateY());
//                System.out.println("CurrentFrequency: " + res.getCurrentFrequency());
//                System.out.println("id: " + res.getId());
//                System.out.println("Priority: " + res.getPriority());
//                System.out.println("Liters: " + res.getLiters());
//            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return resList;
    }


    public CHTRList readCHTRList() {
        CHTRList chtrList = null;
        try {

            JAXBContext jaxbContext2 = JAXBContext.newInstance(CHTRList.class);
            Unmarshaller jaxbUnmarshaller2 = jaxbContext2.createUnmarshaller();
            chtrList = (CHTRList) jaxbUnmarshaller2.unmarshal(new File("src/main/resources/CHTRList.xml"));
//            Вывод полученных данных:
//            for (CHTR chtr : chtrList.getCHTRList()) {
//                List<Point> points = chtr.getPoints();
//                System.out.println("-----------------NEW CHTR for RES-------------");
//                System.out.println("FirstResId: " + chtr.getFirstRESId());
//                System.out.println("SecondResId: " + chtr.getSecondRESId());
//                System.out.println("-----------------POINTS:-------------");
//                for (Point point : points) {
//
//                    System.out.println("CriticalDistance: " + point.getCriticalDistance());
//                    System.out.println("DifFrequency: " + point.getCriticalDifFrequency());
//                }
//
//            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return chtrList;
    }


    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        Calculations calc = new Calculations();
        List<CHTR> chtrList = dataReader.readCHTRList().getCHTRList();
        List<RES> resList = dataReader.readRESList().getRESList();


        Processing processing = new Processing();
        List<Pair> pairsList = processing.createAllPairs(resList, chtrList);
        processing.regularizePairsByRating(pairsList);
        processing.process(resList,chtrList);

        //проверка сортировки и не конфликтных литер
//        for (Pair pair : pairsList) {
//            calc.checkFreeFrequencies(pair);
//            System.out.println("Значение не конфлиткной литеры для первой РЭС из пары:  " + pair.getFirstRes().getNoConflictLiter());
//            System.out.println("Значение не конфлиткной литеры для второй РЭС из пары:  "+pair.getSecondRes().getNoConflictLiter());
//            System.out.println(pair+" Rating: "+pair.getPairRating());
//        }
    }
}
