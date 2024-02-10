package com.umlaut.crowd.internal;

public enum ye {
    Default,
    Auto,
    HighRes,
    HD2160,
    HD1440,
    HD1080,
    HD720,
    Large,
    Medium,
    Small,
    Tiny,
    Unknown;

    public static ye getName(String str) {
        ye yeVar = Unknown;
        ye yeVar2 = Default;
        if (!str.equals(yeVar2.name())) {
            yeVar2 = Auto;
            if (!str.equalsIgnoreCase(yeVar2.name())) {
                yeVar2 = Tiny;
                if (!str.equalsIgnoreCase(yeVar2.name())) {
                    yeVar2 = Small;
                    if (!str.equalsIgnoreCase(yeVar2.name())) {
                        yeVar2 = Medium;
                        if (!str.equalsIgnoreCase(yeVar2.name())) {
                            yeVar2 = Large;
                            if (!str.equalsIgnoreCase(yeVar2.name())) {
                                yeVar2 = HD720;
                                if (!str.equalsIgnoreCase(yeVar2.name())) {
                                    yeVar2 = HD1080;
                                    if (!str.equalsIgnoreCase(yeVar2.name())) {
                                        yeVar2 = HD1440;
                                        if (!str.equalsIgnoreCase(yeVar2.name())) {
                                            yeVar2 = HD2160;
                                            if (!str.equalsIgnoreCase(yeVar2.name())) {
                                                yeVar2 = HighRes;
                                                if (!str.equalsIgnoreCase(yeVar2.name())) {
                                                    return yeVar;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return yeVar2;
    }

    public static ye getQuality(String str) {
        int i;
        try {
            i = Integer.parseInt(str.replaceAll("p", ""));
        } catch (Exception unused) {
            i = -1;
        }
        if (str.equalsIgnoreCase("auto")) {
            return Auto;
        }
        if (str.equalsIgnoreCase("default")) {
            return Default;
        }
        if (i < 144) {
            return Unknown;
        }
        if (i == 144) {
            return Tiny;
        }
        if (i <= 240) {
            return Small;
        }
        if (i <= 360) {
            return Medium;
        }
        if (i <= 480) {
            return Large;
        }
        if (i <= 720) {
            return HD720;
        }
        if (i <= 1080) {
            return HD1080;
        }
        if (i == 1440) {
            return HD1440;
        }
        if (i == 2160) {
            return HD2160;
        }
        return HighRes;
    }
}
