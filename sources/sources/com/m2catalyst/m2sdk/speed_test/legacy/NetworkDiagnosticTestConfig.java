package com.m2catalyst.m2sdk.speed_test.legacy;

public class NetworkDiagnosticTestConfig implements Cloneable {
    public static final int DEFAULT_MANUAL_TEST_DATA_SIZE = 52428800;
    private static final int DEFAULT_PACKET_DATA_SIZE = 102400;
    public static String LIBRE_DEFAULT_OVERHEAD_FACTOR = "1.06";
    public static final int TEST_TYPE_ALL = 0;
    public static final int TEST_TYPE_DOWNLOAD = 2;
    public static final int TEST_TYPE_LATENCY = 1;
    public static final int TEST_TYPE_UPLOAD = 3;
    public static final int TRIGGER_AUTOMATED = 0;
    public static final int TRIGGER_BEAST = 2;
    public static final int TRIGGER_USER = 1;
    public Integer LatencyAlgorithm;
    public Integer bandwidthAlgorithm;
    private String libreDlOverheadFactor;
    private String libreUlOverheadFactor;
    public int maxDataSize;
    public int packetDataSize = DEFAULT_PACKET_DATA_SIZE;
    public int testType;
    private int trigger;

    public NetworkDiagnosticTestConfig(int i, Integer num, Integer num2) {
        String str = LIBRE_DEFAULT_OVERHEAD_FACTOR;
        this.libreDlOverheadFactor = str;
        this.libreUlOverheadFactor = str;
        this.trigger = 0;
        this.maxDataSize = i;
        this.testType = -1;
        this.LatencyAlgorithm = num;
        this.bandwidthAlgorithm = num2;
    }

    public Object clone() {
        return super.clone();
    }

    public String getLibreDlOverheadFactor() {
        return this.libreDlOverheadFactor;
    }

    public String getLibreUlOverheadFactor() {
        return this.libreUlOverheadFactor;
    }

    public int getTrigger() {
        return this.trigger;
    }

    public void setLibreDlOverheadFactor(String str) {
        this.libreDlOverheadFactor = str;
    }

    public void setLibreUlOverheadFactor(String str) {
        this.libreUlOverheadFactor = str;
    }

    public NetworkDiagnosticTestConfig(int i, int i2, int i3, Integer num, Integer num2) {
        String str = LIBRE_DEFAULT_OVERHEAD_FACTOR;
        this.libreDlOverheadFactor = str;
        this.libreUlOverheadFactor = str;
        this.trigger = i;
        this.maxDataSize = i3;
        this.testType = i2;
        this.LatencyAlgorithm = num;
        this.bandwidthAlgorithm = num2;
    }
}
