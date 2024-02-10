package com.m2catalyst.m2sdk.speed_test.legacy;

public class ThroughputUpdateEvent extends TestBaseEvent {
    public double currentCalculation;
    public long dataUsed;
    public double percentComplete;
    public double runningAverage;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThroughputUpdateEvent(int i, long j, int i2, long j2, double d, double d2, double d3, int i3, int i4, int i5) {
        super((long) i, j, i2, i3, i4, i5);
        this.dataUsed = j2;
        this.runningAverage = d;
        this.currentCalculation = d2;
        this.percentComplete = d3;
    }

    public String toString() {
        return "ThroughputUpdateEvent: ID - " + this.testID + ", Time: " + this.time + ", Test Type - " + this.testType + ", Data Used - " + this.dataUsed + ", Average - " + this.runningAverage + ", Current Calculation - " + this.currentCalculation + ", Percent Complete: " + this.percentComplete + ", Number of Stages - " + this.numberOfStages + ", Current Stage - " + this.currentStage + ".";
    }
}
