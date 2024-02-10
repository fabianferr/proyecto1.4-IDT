package com.m2catalyst.m2sdk.speed_test.legacy;

public class TestSnifferEvent extends TestBaseEvent {
    private Float downloadEstimatedSpeed;
    private Float uploadEstimatedSpeed;

    public TestSnifferEvent(long j, Float f, Float f2) {
        super(j);
        this.downloadEstimatedSpeed = f;
        this.uploadEstimatedSpeed = f2;
    }

    public Float getDownloadEstimatedSpeed() {
        return this.downloadEstimatedSpeed;
    }

    public Float getUploadEstimatedSpeed() {
        return this.uploadEstimatedSpeed;
    }
}
