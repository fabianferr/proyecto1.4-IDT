package com.m2catalyst.m2sdk.speed_test.legacy;

public class TestBeginEvent extends TestBaseEvent {
    public int currentStage;
    public long maxDataSize;
    public int numberOfStages;
    public int testTrigger;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TestBeginEvent(int i, long j, int i2, int i3, long j2, int i4, int i5) {
        super((long) i, j, i2, i4, i5, i3);
        this.testTrigger = i3;
        this.maxDataSize = j2;
        this.numberOfStages = i4;
        this.currentStage = i5;
    }

    public String toString() {
        return "TestBeginEvent: ID - " + this.testID + ", Time: " + this.time + ", Test Type - " + this.testType + ", Max Data Size: " + this.maxDataSize + ", Trigger: " + this.testTrigger + ", Number of Stages - " + this.numberOfStages + ", Current Stage - " + this.currentStage + ".";
    }
}
