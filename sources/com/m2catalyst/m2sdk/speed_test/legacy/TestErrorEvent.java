package com.m2catalyst.m2sdk.speed_test.legacy;

public class TestErrorEvent extends TestBaseEvent {
    public static final int ERROR_GENERAL = 100;
    public static final int ERROR_INVALID_DATA_NETWORK_TYPE = 7;
    public static final int ERROR_LOCATION = 0;
    public static final int ERROR_NETWORK_LOST = 8;
    public static final int ERROR_NETWORK_UNAVAILABLE = 9;
    public static final int ERROR_SNIFFER_TEST_FAILED = 6;
    public static final int ERROR_TEST_ALREADY_IN_PROGRESS = 1;
    public static final int ERROR_UNABLE_TO_GET_IP_ADDRESSES = 4;
    public static final int ERROR_WEBSOCKET_CLOSED = 5;
    public static final int ERROR_WEBSOCKET_FAILURE = 3;
    public static final int ERROR_WEBSOCKET_NOT_CONNECTED = 2;
    public int errorCode;
    public String reason;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TestErrorEvent(long j, long j2, int i, int i2, String str, int i3, int i4, int i5) {
        super(j, j2, i, i3, i4, i5);
        this.errorCode = i2;
        this.reason = str;
    }

    public String toString() {
        return "TestErrorEvent: ID - " + this.testID + ", Time: " + this.time + ", Test Type - " + this.testType + ", Error code: " + this.errorCode + ", Reason: " + this.reason + ", Number of Stages - " + this.numberOfStages + ", Current Stage - " + this.currentStage + "Test Trigger: " + this.testTrigger + ".";
    }
}
