package com.umlaut.crowd.internal;

import android.util.SparseArray;
import com.facebook.internal.security.CertificateUtil;
import java.io.File;
import java.util.HashSet;

class a3 implements r3 {
    private SparseArray<String> a = new SparseArray<>();
    private HashSet<String> b = new HashSet<>();

    a3() {
    }

    private String a(int i, int i2) {
        String str = this.a.get(i);
        if (str != null) {
            return str;
        }
        String str2 = i9.a("/proc/" + i2 + "/cmdline")[0];
        this.a.put(i, str2);
        return str2;
    }

    private v8 e() {
        int i;
        File[] fileArr;
        File[] listFiles = new File("/proc").listFiles();
        int length = listFiles.length;
        v8 v8Var = null;
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        while (i3 < length) {
            File file = listFiles[i3];
            if (!this.b.contains(file.getName())) {
                if (!file.isDirectory()) {
                    this.b.add(file.getName());
                } else {
                    try {
                        int parseInt = Integer.parseInt(file.getName());
                        try {
                            String[] a2 = i9.a("/proc/" + parseInt + "/cgroup");
                            if (a2.length >= 2) {
                                int length2 = a2.length;
                                String str = "";
                                String str2 = str;
                                int i4 = 0;
                                while (i4 < length2) {
                                    fileArr = listFiles;
                                    try {
                                        String[] split = a2[i4].split(CertificateUtil.DELIMITER);
                                        i = length;
                                        if (split.length >= 2) {
                                            try {
                                                if (split[1].equals("cpu")) {
                                                    str2 = split[2];
                                                } else if (split[1].equals("cpuacct")) {
                                                    str = split[2];
                                                }
                                            } catch (Exception e) {
                                                e = e;
                                                e.printStackTrace();
                                                i3++;
                                                listFiles = fileArr;
                                                length = i;
                                            }
                                        }
                                        i4++;
                                        listFiles = fileArr;
                                        length = i;
                                    } catch (Exception e2) {
                                        e = e2;
                                        i = length;
                                        e.printStackTrace();
                                        i3++;
                                        listFiles = fileArr;
                                        length = i;
                                    }
                                }
                                fileArr = listFiles;
                                i = length;
                                if (!str2.endsWith("bg_non_interactive")) {
                                    if (!str.endsWith(Integer.toString(parseInt))) {
                                        this.b.add(file.getName());
                                    } else {
                                        int parseInt2 = Integer.parseInt(str.split("/")[1].replace("uid_", ""));
                                        if (parseInt2 < 1000 || parseInt2 > 1038) {
                                            String a3 = aa.a(a(parseInt2, parseInt));
                                            if (m.a(a3)) {
                                                this.b.add(file.getName());
                                            } else {
                                                try {
                                                    int parseInt3 = Integer.parseInt(i9.a("/proc/" + parseInt + "/oom_score")[0]);
                                                    if (parseInt3 != 1 && parseInt3 < i2) {
                                                        try {
                                                            v8 v8Var2 = new v8();
                                                            try {
                                                                v8Var2.b = parseInt2;
                                                                v8Var2.a = a3;
                                                                v8Var = v8Var2;
                                                                i2 = parseInt3;
                                                            } catch (Exception e3) {
                                                                e = e3;
                                                                v8Var = v8Var2;
                                                                i2 = parseInt3;
                                                                e.printStackTrace();
                                                                i3++;
                                                                listFiles = fileArr;
                                                                length = i;
                                                            }
                                                        } catch (Exception e4) {
                                                            e = e4;
                                                            i2 = parseInt3;
                                                            e.printStackTrace();
                                                            i3++;
                                                            listFiles = fileArr;
                                                            length = i;
                                                        }
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    e.printStackTrace();
                                                    i3++;
                                                    listFiles = fileArr;
                                                    length = i;
                                                }
                                                i3++;
                                                listFiles = fileArr;
                                                length = i;
                                            }
                                        } else {
                                            this.b.add(file.getName());
                                        }
                                    }
                                }
                                i3++;
                                listFiles = fileArr;
                                length = i;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            fileArr = listFiles;
                            i = length;
                            e.printStackTrace();
                            i3++;
                            listFiles = fileArr;
                            length = i;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            fileArr = listFiles;
            i = length;
            i3++;
            listFiles = fileArr;
            length = i;
        }
        return v8Var;
    }

    public boolean a() {
        return false;
    }

    public v8 b() {
        return e();
    }

    public c3 c() {
        return c3.Linux;
    }

    public void d() {
    }
}
