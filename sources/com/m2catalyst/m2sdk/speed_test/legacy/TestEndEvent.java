package com.m2catalyst.m2sdk.speed_test.legacy;

public class TestEndEvent extends TestBaseEvent {
    public TestEndEvent(long j, long j2, int i, int i2, int i3, int i4) {
        super(j, j2, i, i2, i3, i4);
    }

    public String toString() {
        return "TestEndEvent: ID - " + this.testID + ", Time: " + this.time + ", Test Type - " + this.testType + ", Number of Stages - " + this.numberOfStages + ", Current Stage - " + this.currentStage + ", Test trigger: " + this.testTrigger + ".";
    }
}
