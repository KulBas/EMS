/**
 * Created by Павел on 13.07.2015.
 */
public class RES {
    int x1, y1, x2, y2, f1, f2, currentDistance, currentFrequency;

    RES(int x1, int y1, int x2, int y2, int f1, int f2) {
        this.x1 = x1;
    }

    public int countFrequency(int f1, int f2) {
        currentFrequency = f1 - f2;
        return Math.abs(currentFrequency);
    }

    public int countDistance(int x1, int y1, int x2, int y2) {
        currentDistance = 10;
        return currentDistance;
    }
}
