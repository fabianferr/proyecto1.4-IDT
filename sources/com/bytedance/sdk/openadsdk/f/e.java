package com.bytedance.sdk.openadsdk.f;

import com.bytedance.sdk.component.d.c.a;
import com.bytedance.sdk.component.d.c.c;
import com.bytedance.sdk.component.d.i;
import com.bytedance.sdk.component.d.s;
import com.bytedance.sdk.component.utils.l;

/* compiled from: StepTrackImpl */
public class e implements s {
    private static int a;
    private long b = 0;
    private long c;
    private boolean d;
    private final String e;

    public e() {
        a++;
        this.e = "image_request_" + a;
    }

    public void a(String str, i iVar) {
        if (!this.d) {
            l.b("ImageLoaderStep", "start " + this.e + " request:" + iVar.a() + ", width:" + iVar.b() + ",height:" + iVar.c());
            this.d = true;
        }
        this.b = System.currentTimeMillis();
        l.b("ImageLoaderStep", this.e + " start:" + c(str, iVar));
    }

    public void b(String str, i iVar) {
        long currentTimeMillis = System.currentTimeMillis() - this.b;
        this.c += currentTimeMillis;
        l.b("ImageLoaderStep", this.e + " end:" + c(str, iVar) + ",cost：" + currentTimeMillis + " ms， total：" + this.c + "\r\n");
    }

    private String c(String str, i iVar) {
        a q;
        if (str != null) {
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1867169789:
                    if (str.equals("success")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1584526165:
                    if (str.equals("raw_cache")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1442758754:
                    if (str.equals("image_type")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1428113824:
                    if (str.equals("disk_cache")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1335717394:
                    if (str.equals("decode")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1281977283:
                    if (str.equals("failed")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1076854124:
                    if (str.equals("check_duplicate")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1017400004:
                    if (str.equals("memory_cache")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 1478448621:
                    if (str.equals("net_request")) {
                        c2 = 8;
                        break;
                    }
                    break;
                case 1718821013:
                    if (str.equals("generate_key")) {
                        c2 = 9;
                        break;
                    }
                    break;
                case 2067979407:
                    if (str.equals("cache_policy")) {
                        c2 = 10;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return "success";
                case 1:
                    return "raw cache";
                case 2:
                    return "image type：";
                case 3:
                    return "disk cache";
                case 4:
                    return "decode";
                case 5:
                    if (!(iVar instanceof c) || (q = ((c) iVar).q()) == null) {
                        return "fail";
                    }
                    Throwable c3 = q.c();
                    StringBuilder sb = new StringBuilder("fail：code:");
                    sb.append(q.a());
                    sb.append(", msg:");
                    sb.append(q.b());
                    sb.append(", exception:");
                    sb.append(c3 != null ? c3.getMessage() : "null \r\n");
                    return sb.toString();
                case 6:
                    return "duplicate request";
                case 7:
                    return "memory cache";
                case 8:
                    return "net request";
                case 9:
                    return "generate key:" + iVar.e();
                case 10:
                    return "cache policy";
            }
        }
        return str;
    }
}
