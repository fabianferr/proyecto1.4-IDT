package com.m2catalyst.m2sdk.speed_test.legacy;

public class LatencyUpdateEvent extends TestBaseEvent {
    public int currentLatencyTest;
    public double latency;
    public double runningAverage;
    public double runningJitter;
    public int totalLatencyTests;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LatencyUpdateEvent(int i, long j, int i2, double d, int i3, int i4, double d2, double d3, int i5, int i6, int i7) {
        super((long) i, j, i2, i5, i6, i7);
        this.latency = d;
        this.totalLatencyTests = i3;
        this.currentLatencyTest = i4;
        this.runningAverage = d2;
        this.runningJitter = d3;
    }

    public String toString() {
        return "Latency Update: ID - " + this.testID + ", Time: " + this.time + ", Test Type: " + this.testType + ", Latency - " + this.latency + ", Total Tests - " + this.totalLatencyTests + ", Current Test - " + this.currentLatencyTest + ", Running Average: " + this.runningAverage + ", Running Jitter: " + this.runningJitter + ",Number of Stages: " + this.numberOfStages + ", Current Stage: " + this.currentStage + ".";
    }
}
