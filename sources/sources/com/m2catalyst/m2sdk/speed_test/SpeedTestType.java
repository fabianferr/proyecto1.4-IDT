package com.m2catalyst.m2sdk.speed_test;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/m2catalyst/m2sdk/speed_test/SpeedTestType;", "", "type", "", "testName", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getTestName", "()Ljava/lang/String;", "getType", "()I", "LEGACY", "DEFAULT", "ALL", "LATENCY", "DOWNLOAD", "UPLOAD", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SpeedTestType.kt */
public enum SpeedTestType {
    LEGACY(-1, "Legacy"),
    DEFAULT(0, "Default"),
    ALL(1, "Complete"),
    LATENCY(2, "Latency"),
    DOWNLOAD(3, "Download"),
    UPLOAD(4, "Upload");
    
    private final String testName;
    private final int type;

    private SpeedTestType(int i, String str) {
        this.type = i;
        this.testName = str;
    }

    public final String getTestName() {
        return this.testName;
    }

    public final int getType() {
        return this.type;
    }
}
