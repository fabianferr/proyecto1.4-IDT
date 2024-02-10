package com.umlaut.crowd.internal;

import android.net.Uri;
import android.util.SparseArray;
import java.net.URLDecoder;

class ue {
    private static final String c = "ip";
    private static final String d = "fps";
    private static final String e = "url";
    private static final String f = "itag";
    private static final String g = "size";
    private static final String h = "type";
    private static final String i = "clen";
    private static final String j = "dur";
    private static final String k = "eotf";
    private static final String l = "bitrate";
    private static final String m = "quality_label";
    private static final String n = "primaries";
    private static final String o = "initcwndbps";
    private static final String p = "audio_sample_rate";
    private String a;
    private SparseArray<df> b = new SparseArray<>();

    ue(String str) {
        this.a = str;
        if (str != null && !str.isEmpty()) {
            a();
        }
    }

    private void a() {
        String str;
        String str2;
        String str3;
        String[] strArr;
        int i2;
        String[] strArr2;
        String str4;
        String str5;
        String str6;
        Uri uri;
        long j2;
        String[] split;
        String str7 = o;
        String str8 = c;
        String str9 = "\\?";
        String[] split2 = this.a.split(",");
        int length = split2.length;
        int i3 = 0;
        while (i3 < length) {
            String[] split3 = split2[i3].split("&");
            df dfVar = new df();
            int length2 = split3.length;
            int i4 = 0;
            while (i4 < length2) {
                String[] split4 = split3[i4].split("=");
                if (split4 != null) {
                    strArr2 = split2;
                    i2 = length;
                    if (split4.length > 1) {
                        strArr = split3;
                        String str10 = split4[0];
                        String str11 = split4[1];
                        String str12 = "=";
                        if (str10.equalsIgnoreCase(l)) {
                            try {
                                dfVar.Bitrate = Long.parseLong(str11);
                            } catch (Exception unused) {
                                dfVar.Bitrate = -1;
                            }
                        } else if (str10.equalsIgnoreCase(d)) {
                            try {
                                dfVar.VideoFps = Integer.parseInt(str11);
                            } catch (Exception unused2) {
                                dfVar.VideoFps = -1;
                            }
                        } else if (str10.equalsIgnoreCase(n)) {
                            dfVar.VideoPrimaries = str11;
                        } else if (str10.equalsIgnoreCase(k)) {
                            dfVar.VideoEOTF = str11;
                        } else if (str10.equalsIgnoreCase(m)) {
                            dfVar.VideoQuality = ye.getQuality(str11);
                        } else if (str10.equalsIgnoreCase(f)) {
                            try {
                                dfVar.Tag = Integer.parseInt(str11);
                            } catch (Exception unused3) {
                                dfVar.Tag = -1;
                            }
                        } else if (str10.equalsIgnoreCase(i)) {
                            try {
                                dfVar.TotalBytes = Long.parseLong(str11);
                            } catch (Exception unused4) {
                                dfVar.TotalBytes = -1;
                            }
                        } else if (str10.equalsIgnoreCase(p)) {
                            try {
                                dfVar.AudioSampleRate = Long.parseLong(str11);
                            } catch (Exception unused5) {
                                dfVar.AudioSampleRate = -1;
                            }
                        } else if (str10.equalsIgnoreCase(g)) {
                            if (str11.toLowerCase().contains("x") && (split = str11.toLowerCase().split("x")) != null && split.length > 1) {
                                try {
                                    dfVar.VideoWidth = Integer.parseInt(split[0]);
                                } catch (Exception unused6) {
                                    dfVar.VideoWidth = 0;
                                }
                                try {
                                    dfVar.VideoHeight = Integer.parseInt(split[1]);
                                } catch (Exception unused7) {
                                    dfVar.VideoHeight = 0;
                                }
                            }
                        } else if (str10.equalsIgnoreCase("type")) {
                            try {
                                String[] split5 = URLDecoder.decode(str11, "UTF-8").replaceAll(" ", "").replaceAll("\"", "").split("codecs=");
                                if (split5.length > 0) {
                                    dfVar.Mime = split5[0];
                                }
                                if (split5.length > 1) {
                                    dfVar.Codec = split5[1];
                                }
                            } catch (Exception unused8) {
                            }
                        } else if (str10.equalsIgnoreCase("url")) {
                            try {
                                str4 = URLDecoder.decode(str11, "UTF-8");
                                try {
                                    dfVar.Server = str4.split(str9)[0];
                                } catch (Exception unused9) {
                                }
                            } catch (Exception unused10) {
                                str4 = null;
                            }
                            if (str4 != null) {
                                try {
                                    Uri parse = Uri.parse(str4);
                                    Float valueOf = Float.valueOf(parse.getQueryParameter(j));
                                    if (valueOf == null || valueOf.isNaN()) {
                                        uri = parse;
                                        j2 = -1;
                                    } else {
                                        uri = parse;
                                        j2 = (long) (valueOf.floatValue() * 1000.0f);
                                    }
                                    dfVar.TotalDuration = j2;
                                    Uri uri2 = uri;
                                    dfVar.IP = uri2.getQueryParameter(str8);
                                    try {
                                        dfVar.Initcwndbps = Long.valueOf(uri2.getQueryParameter(str7)).longValue();
                                    } catch (Exception unused11) {
                                        dfVar.Initcwndbps = -1;
                                    }
                                } catch (Exception unused12) {
                                    String[] split6 = str4.split(str9);
                                    if (split6 != null && split6.length > 1) {
                                        String[] split7 = split6[1].split("&");
                                        int length3 = split7.length;
                                        int i5 = 0;
                                        while (i5 < length3) {
                                            String str13 = str12;
                                            String[] split8 = split7[i5].split(str13);
                                            String str14 = str9;
                                            if (split8[0].equalsIgnoreCase(str8)) {
                                                dfVar.IP = split8[1];
                                                str6 = str7;
                                                str5 = str8;
                                            } else if (split8[0].equalsIgnoreCase(str7)) {
                                                try {
                                                    str6 = str7;
                                                    str5 = str8;
                                                    try {
                                                        dfVar.Initcwndbps = Long.valueOf(split8[1]).longValue();
                                                    } catch (Exception unused13) {
                                                    }
                                                } catch (Exception unused14) {
                                                    str6 = str7;
                                                    str5 = str8;
                                                    dfVar.Initcwndbps = -1;
                                                    i5++;
                                                    str9 = str14;
                                                    str7 = str6;
                                                    str8 = str5;
                                                    str12 = str13;
                                                }
                                            } else {
                                                str6 = str7;
                                                str5 = str8;
                                                if (split8[0].equalsIgnoreCase(j)) {
                                                    Float valueOf2 = Float.valueOf(split8[1]);
                                                    dfVar.TotalDuration = (valueOf2 == null || valueOf2.isNaN()) ? -1 : (long) (valueOf2.floatValue() * 1000.0f);
                                                    i5++;
                                                    str9 = str14;
                                                    str7 = str6;
                                                    str8 = str5;
                                                    str12 = str13;
                                                }
                                                i5++;
                                                str9 = str14;
                                                str7 = str6;
                                                str8 = str5;
                                                str12 = str13;
                                            }
                                            i5++;
                                            str9 = str14;
                                            str7 = str6;
                                            str8 = str5;
                                            str12 = str13;
                                        }
                                    }
                                }
                            }
                        }
                        str2 = str7;
                        str = str8;
                        str3 = str9;
                        i4++;
                        split2 = strArr2;
                        length = i2;
                        split3 = strArr;
                        str9 = str3;
                        str7 = str2;
                        str8 = str;
                    } else {
                        str2 = str7;
                        str = str8;
                        str3 = str9;
                    }
                } else {
                    str2 = str7;
                    str = str8;
                    str3 = str9;
                    strArr2 = split2;
                    i2 = length;
                }
                strArr = split3;
                i4++;
                split2 = strArr2;
                length = i2;
                split3 = strArr;
                str9 = str3;
                str7 = str2;
                str8 = str;
            }
            String[] strArr3 = split2;
            int i6 = length;
            this.b.append(dfVar.Tag, dfVar);
            i3++;
            str9 = str9;
            str7 = str7;
            str8 = str8;
        }
    }

    /* access modifiers changed from: package-private */
    public SparseArray<df> b() {
        return this.b;
    }
}
