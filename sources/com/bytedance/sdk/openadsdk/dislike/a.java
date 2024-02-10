package com.bytedance.sdk.openadsdk.dislike;

import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.List;

/* compiled from: DislikeDispatcher */
public class a {
    private static volatile a a;
    private final p<com.bytedance.sdk.openadsdk.b.a> b = o.c();

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public void a(String str, List<FilterWord> list) {
        a(str, list, (String) null, (String) null);
    }

    public void a(String str, List<FilterWord> list, String str2, String str3) {
        this.b.a(str, list, str2, str3);
    }
}
