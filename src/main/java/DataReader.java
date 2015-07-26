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

            resList = (RESList) jaxbUnmarshaller.unmarshal(new File("D:/1-project/EMS/src/main/resources/RESList.xml"));
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
            chtrList = (CHTRList) jaxbUnmarshaller2.unmarshal(new File("D:/1-project/EMS/src/main/resources/CHTRList.xml"));
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

    public void readFile(String pathToFile) {
        try {

            BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
            String line;
            String[] curRes;
            while ((line = reader.readLine()) != null) {
                curRes = line.split(";");
                initializeLiters(curRes);
                initializeResList(curRes);
                liters.clear();
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeResList(String[] curRes) {
        RES res = new RES(Integer.valueOf(curRes[0]), Double.valueOf(curRes[1]),
                Double.valueOf(curRes[2]), Double.valueOf(curRes[3]), liters, Integer.valueOf(curRes[5]));
        resList.add(res);

    }

    private void initializeLiters(String[] curRes) {
        String[] strLiters = curRes[4].split(",");
        for (int i = 0; i < strLiters.length; i++) {
            liters.add(i, Double.valueOf(strLiters[i]));
        }
    }

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        List<CHTR> chtrList = dataReader.readCHTRList().getCHTRList();
        List<RES> resList = dataReader.readRESList().getRESList();


        Processing processing = new Processing();
        List<Pair> pairsList = processing.createAllPairs(resList, chtrList);
        processing.regularizePairsByRating(pairsList);

        //проверка сортировки
        for (Pair pair : pairsList) {
            System.out.println(pair+" Rating: "+pair.getPairRating());
        }

//        вывод(из файла)
//        for (int i = 0; i < resList.size(); i++) {
//            System.out.println("Id: " + resList.get(i).getId());
//            System.out.println("X: " + resList.get(i).getCoordinateX() + " Y: " + resList.get(i).getCoordinateY());
//            System.out.println("Frequency: " + resList.get(i).getCurrentFrequency() + " Priority: " + resList.get(i).getPriority());
//            System.out.print("Liters: ");
//            for (int q = 0; q < resList.get(i).getLiters().size(); q++) {
//                System.out.print(resList.get(i).getLiters().get(q) + ", ");
//            }
//            System.out.println("\n");
//        }


    }
}
