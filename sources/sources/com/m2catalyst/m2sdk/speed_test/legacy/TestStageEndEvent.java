package com.m2catalyst.m2sdk.speed_test.legacy;

public class TestStageEndEvent extends TestBaseEvent {
    public TestStageEndEvent(long j, long j2, int i, int i2, int i3, int i4) {
        super(j, j2, i, i2, i3, i4);
    }

    public String toString() {
        return "TestStageEndEvent: ID - " + this.testID + ", Time: " + this.time + ", Test Type - " + this.testType + ", Number of Stages - " + this.numberOfStages + ", Current Stage - " + this.currentStage + ", Test trigger: " + this.testTrigger + ".";
    }
}
