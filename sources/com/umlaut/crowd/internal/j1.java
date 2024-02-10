package com.umlaut.crowd.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class j1 {
    private static final String e = "j1";
    private static final boolean f = false;
    private long a;
    private long b;
    private ArrayList<b> c = new ArrayList<>();
    private s3 d;

    private class b {
        int a;
        long b;
        long c;

        private b() {
        }
    }

    public j1() {
        if (new i3().a()) {
            this.d = new i3();
        } else if (new h3().a()) {
            this.d = new h3();
        }
    }

    private b a(int i) {
        Iterator<b> it = this.c.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.a == i) {
                return next;
            }
        }
        b bVar = new b();
        bVar.a = i;
        this.c.add(bVar);
        return bVar;
    }

    public n1 b() {
        int i;
        String[] strArr;
        String str;
        String str2;
        String str3 = " ";
        String str4 = "cpu";
        n1 n1Var = new n1();
        ArrayList arrayList = new ArrayList();
        try {
            String[] a2 = i9.a("/proc/stat");
            int length = a2.length;
            char c2 = 0;
            int i2 = 0;
            while (i2 < length) {
                String str5 = a2[i2];
                if (str5.startsWith(str4)) {
                    String[] split = str5.replace("  ", str3).split(str3);
                    if (split[c2].equals(str4)) {
                        long parseInt = (long) (Integer.parseInt(split[4]) + Integer.parseInt(split[5]));
                        long parseInt2 = ((long) (Integer.parseInt(split[1]) + Integer.parseInt(split[2]) + Integer.parseInt(split[3]) + Integer.parseInt(split[5]) + Integer.parseInt(split[6]) + Integer.parseInt(split[7]) + Integer.parseInt(split[8]))) + parseInt;
                        str2 = str3;
                        str = str4;
                        long j = this.a;
                        if (j != 0) {
                            long j2 = parseInt2 - j;
                            strArr = a2;
                            i = length;
                            long j3 = parseInt - this.b;
                            if (j2 > 0) {
                                double d2 = (double) (j2 - j3);
                                double d3 = (double) j2;
                                Double.isNaN(d2);
                                Double.isNaN(d3);
                                n1Var.CpuLoad = d2 / d3;
                            }
                        } else {
                            strArr = a2;
                            i = length;
                        }
                        this.a = parseInt2;
                        this.b = parseInt;
                    } else {
                        str2 = str3;
                        str = str4;
                        strArr = a2;
                        i = length;
                        int parseInt3 = Integer.parseInt(split[0].substring(3));
                        long parseInt4 = (long) (Integer.parseInt(split[4]) + Integer.parseInt(split[5]));
                        long parseInt5 = ((long) (Integer.parseInt(split[1]) + Integer.parseInt(split[2]) + Integer.parseInt(split[3]) + Integer.parseInt(split[5]) + Integer.parseInt(split[6]) + Integer.parseInt(split[7]) + Integer.parseInt(split[8]))) + parseInt4;
                        l1 l1Var = new l1();
                        l1Var.CoreNumber = parseInt3;
                        b a3 = a(parseInt3);
                        long j4 = a3.b;
                        if (j4 != 0) {
                            long j5 = parseInt5 - j4;
                            long j6 = parseInt4 - a3.c;
                            if (j5 > 0) {
                                double d4 = (double) (j5 - j6);
                                double d5 = (double) j5;
                                Double.isNaN(d4);
                                Double.isNaN(d5);
                                l1Var.CoreLoad = d4 / d5;
                            }
                        }
                        a3.b = parseInt5;
                        a3.c = parseInt4;
                        arrayList.add(l1Var);
                    }
                } else {
                    str2 = str3;
                    str = str4;
                    strArr = a2;
                    i = length;
                }
                i2++;
                str3 = str2;
                str4 = str;
                a2 = strArr;
                length = i;
                c2 = 0;
            }
            Iterator it = arrayList.iterator();
            long j7 = 0;
            while (it.hasNext()) {
                l1 l1Var2 = (l1) it.next();
                String[] a4 = i9.a("/sys/devices/system/cpu/cpu" + l1Var2.CoreNumber + "/cpufreq/scaling_cur_freq");
                if (a4.length > 0) {
                    l1Var2.CoreFrequency = Integer.parseInt(a4[0]);
                }
                j7 += (long) l1Var2.CoreFrequency;
                String[] a5 = i9.a("/sys/devices/system/cpu/cpu" + l1Var2.CoreNumber + "/cpufreq/cpuinfo_max_freq");
                if (a5.length > 0) {
                    l1Var2.CoreMaxFrequency = Integer.parseInt(a5[0]);
                }
                String[] a6 = i9.a("/sys/devices/system/cpu/cpu" + l1Var2.CoreNumber + "/cpufreq/cpuinfo_min_freq");
                if (a6.length > 0) {
                    l1Var2.CoreMinFrequency = Integer.parseInt(a6[0]);
                }
                n1Var.CoresOnline++;
            }
            int i3 = n1Var.CoresOnline;
            if (i3 > 0) {
                n1Var.CoresAvgFrequency = (int) (j7 / ((long) i3));
            }
            n1Var.CpuCoresLoads = (l1[]) arrayList.toArray(new l1[arrayList.size()]);
        } catch (Exception unused) {
        }
        s3 s3Var = this.d;
        if (s3Var != null) {
            n1Var.GpuFrequency = s3Var.d();
            n1Var.GpuMaxFrequency = this.d.c();
            n1Var.GpuLoad = this.d.b();
        }
        return n1Var;
    }

    public static m1 a() {
        int i;
        double d2;
        int i2;
        m1 m1Var = new m1();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (String str : i9.a("/proc/cpuinfo")) {
            if (str.startsWith("Processor")) {
                String[] split = str.split(" ", 2);
                if (split.length >= 2) {
                    m1Var.Processor = aa.a(split[1]);
                }
            } else if (str.startsWith("processor")) {
                i3++;
                if (str.split(" ", 2).length >= 2) {
                    k1 k1Var = new k1();
                    k1Var.CoreNumber = i3 - 1;
                    arrayList.add(k1Var);
                }
            } else if (str.startsWith("model name")) {
                String[] split2 = str.split(" ", 3);
                if (split2.length >= 3 && i3 - 1 >= 0 && i2 < arrayList.size()) {
                    ((k1) arrayList.get(i2)).ModelName = aa.a(split2[2]);
                }
            } else if (str.toLowerCase(Locale.ENGLISH).startsWith("bogomips")) {
                String[] split3 = str.split(" ", 2);
                if (split3.length >= 2 && i3 - 1 >= 0 && i < arrayList.size()) {
                    try {
                        d2 = Double.parseDouble(aa.a(split3[1]));
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                        d2 = 0.0d;
                    }
                    ((k1) arrayList.get(i)).BogoMIPS = d2;
                }
            } else if (str.startsWith("Features") || str.startsWith("flags")) {
                String[] split4 = str.split(" ", 2);
                if (split4.length >= 2) {
                    m1Var.CpuFeatures = aa.a(split4[1]).split(" ");
                }
            } else if (str.startsWith("CPU implementer")) {
                String[] split5 = str.split(" ", 3);
                if (split5.length >= 3) {
                    m1Var.CpuImplementer = aa.a(split5[2]);
                }
            } else if (str.startsWith("CPU implementer")) {
                String[] split6 = str.split(" ", 3);
                if (split6.length >= 3) {
                    m1Var.CpuImplementer = aa.a(split6[2]);
                }
            } else if (str.startsWith("CPU architecture")) {
                String[] split7 = str.split(" ", 3);
                if (split7.length >= 3) {
                    m1Var.CpuArchitecture = aa.a(split7[2]);
                }
            } else if (str.startsWith("CPU variant")) {
                String[] split8 = str.split(" ", 3);
                if (split8.length >= 3) {
                    m1Var.CpuVariant = aa.a(split8[2]);
                }
            } else if (str.startsWith("CPU part")) {
                String[] split9 = str.split(" ", 3);
                if (split9.length >= 3) {
                    m1Var.CpuPart = aa.a(split9[2]);
                }
            } else if (str.startsWith("CPU revision")) {
                String[] split10 = str.split(" ", 3);
                if (split10.length >= 3) {
                    m1Var.CpuRevision = aa.a(split10[2]);
                }
            } else if (str.startsWith("Chip revision")) {
                String[] split11 = str.split(" ", 3);
                if (split11.length >= 3) {
                    m1Var.CpuChipRevision = aa.a(split11[2]);
                }
            } else if (str.startsWith("MSM Hardware")) {
                String[] split12 = str.split(" ", 3);
                if (split12.length >= 3) {
                    m1Var.MSMHardware = aa.a(split12[2]);
                }
            } else if (str.startsWith("Hardware")) {
                String[] split13 = str.split(" ", 2);
                if (split13.length >= 2) {
                    m1Var.CpuHardware = aa.a(split13[1]);
                }
            } else if (str.startsWith("Revision")) {
                String[] split14 = str.split(" ", 2);
                if (split14.length >= 2) {
                    m1Var.CpuRevision = aa.a(split14[1]);
                }
            }
        }
        m1Var.Cores = (k1[]) arrayList.toArray(new k1[arrayList.size()]);
        m1Var.NumberOfCores = i3;
        return m1Var;
    }
}
