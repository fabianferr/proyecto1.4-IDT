package com.m2catalyst.m2sdk.speed_test.legacy;

public class TestBaseEvent {
    public int currentStage;
    public int numberOfStages;
    public long testID;
    public int testTrigger;
    public int testType;
    public long time;

    public TestBaseEvent(long j) {
        this(j, -1, -1, -1, -1, -1);
    }

    public TestBaseEvent(long j, long j2, int i, int i2, int i3, int i4) {
        this.testID = j;
        this.time = j2;
        this.testType = i;
        this.numberOfStages = i2;
        this.currentStage = i3;
        this.testTrigger = i4;
    }
}
