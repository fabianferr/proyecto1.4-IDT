package com.m2catalyst.m2sdk.speed_test.legacy;

import java.util.ArrayList;

public class ThroughputConfigurationVO {
    public int checkIfRoaming;
    public long dataLimit = ThroughputConfigUtil.DEFAULT_DATA_LIMIT;
    public ArrayList<Integer> daysOfWeek;
    public int endTime;
    public Double frequency;
    public ArrayList<Integer> hours;
    public int mcc;
    public ArrayList<Integer> mccmnc;
    public int mnc;
    public String operator;
    public ArrayList<String> operators;
    public int startTime;
    public ArrayList<Integer> technologyArray;

    public void clear() {
        this.startTime = -1;
        this.endTime = -1;
        this.checkIfRoaming = -1;
        ArrayList<Integer> arrayList = this.technologyArray;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.mnc = -1;
        this.mcc = -1;
        this.operator = null;
        ArrayList<Integer> arrayList2 = this.daysOfWeek;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        this.frequency = null;
        ArrayList<Integer> arrayList3 = this.hours;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        ArrayList<Integer> arrayList4 = this.mccmnc;
        if (arrayList4 != null) {
            arrayList4.clear();
        }
        ArrayList<String> arrayList5 = this.operators;
        if (arrayList5 != null) {
            arrayList5.clear();
        }
    }

    public String toString() {
        return "Data limit: " + this.dataLimit + System.getProperty("line.separator") + "Start time: " + this.startTime + System.getProperty("line.separator") + "End time: " + this.endTime + System.getProperty("line.separator") + "Roaming: " + this.checkIfRoaming + System.getProperty("line.separator") + "Tech array: " + this.technologyArray + System.getProperty("line.separator") + "MNC: " + this.mnc + System.getProperty("line.separator") + "MCC: " + this.mcc + System.getProperty("line.separator") + "Operator: " + this.operator + System.getProperty("line.separator") + "Days of week: " + this.daysOfWeek + System.getProperty("line.separator") + "Frequency: " + this.frequency + System.getProperty("line.separator") + "Hours: " + this.hours + System.getProperty("line.separator") + "MCCMNC: " + this.mccmnc + System.getProperty("line.separator") + "Operators: " + this.operators;
    }
}
