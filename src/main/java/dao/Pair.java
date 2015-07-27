package dao;

import dao.CHTR.CHTR;
import dao.RES.RES;

import java.util.LinkedHashMap;

public class Pair {

    private RES firstRes;
    private RES secondRes;
    private Double difFrequency;
    private Double realDistance;
    private Double criticalDistance;
    private Double pairRating; //�������� ��������� - �����������
    private CHTR CHTR; //<difFrequency(recommended),criticalDistance(recommended)>
    private  Double criticalFrequency;//����������� ������ f ��� ����������� ������������� ��������
    private Double firstNoConflictLiter;
    private Double secondNoConflictLiter;

    public Double getFirstNoConflictLiter() {
        return firstNoConflictLiter;
    }

    public void setFirstNoConflictLiter(Double firstNoConflictLiter) {
        this.firstNoConflictLiter = firstNoConflictLiter;
    }

    public Double getSecondNoConflictLiter() {
        return secondNoConflictLiter;
    }

    public void setSecondNoConflictLiter(Double secondNoConflictLiter) {
        this.secondNoConflictLiter = secondNoConflictLiter;
    }

    public Double getCriticalFrequency() {
        return criticalFrequency;
    }

    public void setCriticalFrequency(Double criticalFrequency) {
        this.criticalFrequency = criticalFrequency;
    }


    public Pair(RES firstRes, RES secondRes) {
        this.firstRes = firstRes;
        this.secondRes = secondRes;
    }

    public RES getFirstRes() {
        return firstRes;
    }

    public void setFirstRes(RES firstRes) {
        this.firstRes = firstRes;
    }

    public RES getSecondRes() {
        return secondRes;
    }

    public void setSecondRes(RES secondRes) {
        this.secondRes = secondRes;
    }

    public Double getDifFrequency() {
        return difFrequency;
    }

    public void setDifFrequency(Double difFrequency) {
        this.difFrequency = difFrequency;
    }

    public Double getRealDistance() {
        return realDistance;
    }

    public void setRealDistance(Double realDistance) {
        this.realDistance = realDistance;
    }

    public Double getCriticalDistance() {
        return criticalDistance;
    }

    public void setCriticalDistance(Double criticalDistance) {
        this.criticalDistance = criticalDistance;
    }

    public Double getPairRating() {
        return pairRating;
    }

    public void setPairRating(Double pairRating) {
        this.pairRating = pairRating;
    }

    public CHTR getCHTR() {
        return CHTR;
    }


    public void setCHTR(CHTR CHTR) {
        this.CHTR = CHTR;
    }
}
