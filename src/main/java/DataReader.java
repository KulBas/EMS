import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ����� on 13.07.2015.
 */
public class DataReader {
    private static List<RES> resList = new ArrayList<RES>();
    private static List<Double> liters = new ArrayList<Double>();

    public void readFile(String pathToFile) {
        try {

            BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
            String line;
            String[] curRes;
            while ((line = reader.readLine()) != null) {
                curRes = line.split(";");
                initializeLiters(curRes);
                initializeResList(curRes);
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
        dataReader.readFile("D:/emstest/test.txt");
        for (int i = 0; i < resList.size(); i++) {
            System.out.println("Id: " + resList.get(i).getId());
            System.out.println("X: " + resList.get(i).getCoordinateX() + " Y: " + resList.get(i).getCoordinateY());
            System.out.println("Frequency: " + resList.get(i).getCurrentFrequency() + " Priority: " + resList.get(i).getPriority());
            System.out.print("Liters: ");
            for (int q = 0; q < resList.get(i).getLiters().size(); q++) {
                System.out.print(resList.get(i).getLiters().get(q) + ", ");
            }
            System.out.println("\n");
        }
    }
}
