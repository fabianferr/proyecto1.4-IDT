package com.umlaut.crowd.internal;

import com.umlaut.crowd.timeserver.TimeServer;
import java.util.HashMap;
import java.util.Map;

public class ge extends Thread {
    private static final long e = 1000;
    private final int a;
    private final String b;
    private boolean c = false;
    private Map<String, c1> d = null;

    public ge(String str, int i) {
        this.a = i;
        this.b = str;
        this.d = new HashMap();
    }

    public Map<String, c1> a() {
        this.c = false;
        interrupt();
        return this.d;
    }

    public void run() {
        int i;
        String str;
        super.run();
        this.c = true;
        char c2 = 0;
        int i2 = 0;
        while (this.c && i2 < this.a) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("ip -s -d neighbor");
                String str2 = this.b;
                if (str2 == null || str2.isEmpty()) {
                    str = "";
                } else {
                    str = " show dev " + this.b;
                }
                sb.append(str);
                String[] b2 = i9.b(sb.toString());
                long timeInMillis = TimeServer.getTimeInMillis();
                int length = b2.length;
                int i3 = 0;
                while (i3 < length) {
                    String str3 = b2[i3];
                    c1 c1Var = new c1();
                    c1Var.Timestamp = timeInMillis;
                    String[] split = str3.split(" ");
                    if (split.length > 0) {
                        String str4 = split[c2];
                        c1Var.IpAddress = str4;
                        c1Var.IpAddress_Full = str4;
                        int length2 = split.length;
                        int i4 = 0;
                        boolean z = false;
                        boolean z2 = false;
                        boolean z3 = false;
                        while (i4 < length2) {
                            String str5 = split[i4];
                            if (z) {
                                String[] split2 = str5.split("/");
                                if (split2.length > 2) {
                                    i = i2;
                                    try {
                                        c1Var.EntryUsedAge = ((long) Integer.parseInt(split2[c2])) * 1000;
                                    } catch (Exception unused) {
                                        i2 = i + 1;
                                        c2 = 0;
                                    }
                                    try {
                                        c1Var.EntryConfirmedAge = ((long) Integer.parseInt(split2[1])) * 1000;
                                        c1Var.EntryUpdatedAge = ((long) Integer.parseInt(split2[2])) * 1000;
                                    } catch (Exception unused2) {
                                    }
                                } else {
                                    i = i2;
                                }
                                z = false;
                            } else {
                                i = i2;
                                if (z2) {
                                    c1Var.Probes = Integer.parseInt(str5);
                                    z2 = false;
                                } else if (z3) {
                                    c1Var.MacAddress = str5;
                                    z3 = false;
                                }
                            }
                            if (str5.equalsIgnoreCase("used")) {
                                z = true;
                            } else if (str5.equalsIgnoreCase("probes")) {
                                z2 = true;
                            } else if (str5.equalsIgnoreCase("lladdr")) {
                                z3 = true;
                            }
                            i4++;
                            i2 = i;
                            c2 = 0;
                        }
                        i = i2;
                        String str6 = split[split.length - 1];
                        if (!str6.equalsIgnoreCase("FAILED") && !c1Var.MacAddress.isEmpty() && !this.d.keySet().contains(c1Var.MacAddress)) {
                            c1Var.Status = de.b(str6);
                            this.d.put(c1Var.MacAddress, c1Var);
                        }
                    } else {
                        i = i2;
                    }
                    i3++;
                    i2 = i;
                    c2 = 0;
                }
                i = i2;
                Thread.sleep(1000);
            } catch (Exception unused3) {
                i = i2;
                i2 = i + 1;
                c2 = 0;
            }
            i2 = i + 1;
            c2 = 0;
        }
        this.c = false;
    }
}
