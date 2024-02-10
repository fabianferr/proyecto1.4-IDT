package com.umlaut.crowd.internal;

import java.io.IOException;

public class n2 {
    private static final boolean c = false;
    private final String a;
    private final String b;

    public n2(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static void a(u2 u2Var, n2 n2Var) throws IOException {
        String[] split = n2Var.b.split("\n");
        int i = 0;
        if (split.length > 1) {
            while (i < split.length - 1) {
                u2Var.a(new String(n2Var.a + "-" + split[i] + "\r\n"));
                i++;
            }
        }
        u2Var.write(new String(n2Var.a + " " + split[i] + "\r\n"));
        u2Var.flush();
    }

    public synchronized String b() {
        return this.b;
    }

    public String toString() {
        return "[code=" + this.a + ", message=" + this.b + "]";
    }

    public static n2 a(p2 p2Var) throws IOException {
        String str = "";
        String str2 = null;
        boolean z = false;
        do {
            String g = p2Var.g();
            if (g == null) {
                return null;
            }
            if (g.length() <= 3 || z) {
                if (!z) {
                    str2 = "";
                    str = g;
                } else if (!g.startsWith(str2) || g.charAt(3) != ' ') {
                    str = str + g + "\n";
                    continue;
                } else {
                    str = str + "\n" + g;
                }
                z = false;
                continue;
            } else {
                str = g.substring(4);
                str2 = g.substring(0, 4);
                if (g.charAt(3) == '-') {
                    str2 = str2.substring(0, 3);
                    z = true;
                    continue;
                } else {
                    continue;
                }
            }
        } while (z);
        return new n2(str2.trim(), str.trim());
    }

    public synchronized String a() {
        return this.a;
    }
}
