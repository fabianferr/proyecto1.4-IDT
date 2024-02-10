package com.umlaut.crowd.internal;

public enum xe {
    Unstarted(-1),
    Playing(1),
    Buffering(3),
    Paused(2),
    Ended(0),
    Cued(5),
    QualityChanged(6),
    DownloadingPlayer(8),
    Creating(9),
    Ready(10),
    Unknown(7);

    private xe(int i) {
    }

    public static xe getState(String str) {
        try {
            Integer valueOf = Integer.valueOf(str);
            if (valueOf != null) {
                int intValue = valueOf.intValue();
                if (intValue == -1) {
                    return Unstarted;
                }
                if (intValue == 0) {
                    return Ended;
                }
                if (intValue == 1) {
                    return Playing;
                }
                if (intValue == 2) {
                    return Paused;
                }
                if (intValue == 3) {
                    return Buffering;
                }
                if (intValue == 5) {
                    return Cued;
                }
            }
        } catch (Exception unused) {
        }
        return Unknown;
    }
}
