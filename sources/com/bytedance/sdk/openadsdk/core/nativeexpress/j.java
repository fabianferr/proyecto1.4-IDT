package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.sdk.component.adexpress.a.a.a;
import com.bytedance.sdk.component.adexpress.a.a.b;
import com.bytedance.sdk.component.adexpress.a.a.d;
import com.bytedance.sdk.component.adexpress.d.e;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.aidl.c;
import org.json.JSONObject;

/* compiled from: ExpressInitHelper */
public class j {
    public static void a() {
        a.a().a((b) new b() {
            public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), str, contentValues, str2, strArr);
            }

            public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
                return new c(com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), str, strArr, str2, strArr2, str3, str4, str5));
            }

            public int a(String str, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), str, str2, strArr);
            }

            public void a(String str, ContentValues contentValues) {
                com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), str, contentValues);
            }
        });
        a.a().a((com.bytedance.sdk.component.adexpress.a.a.c) new com.bytedance.sdk.component.adexpress.a.a.c() {
            public int i() {
                return 1;
            }

            public int k() {
                return 0;
            }

            public int a() {
                if (o.d() == null) {
                    return 0;
                }
                return o.d().d();
            }

            public Context b() {
                return o.a();
            }

            public Handler c() {
                return l.c();
            }

            public void d() {
                if (o.d().Y() != 0 && o.d().Z() != 0) {
                    e.a().a(o.d().Y());
                    final MessageQueue[] messageQueueArr = new MessageQueue[1];
                    if (Build.VERSION.SDK_INT >= 23) {
                        MessageQueue queue = l.c().getLooper().getQueue();
                        messageQueueArr[0] = queue;
                        a(queue);
                    } else if (Looper.getMainLooper() == Looper.myLooper()) {
                        MessageQueue myQueue = Looper.myQueue();
                        messageQueueArr[0] = myQueue;
                        a(myQueue);
                    } else {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                messageQueueArr[0] = Looper.myQueue();
                                AnonymousClass2.this.a(messageQueueArr[0]);
                            }
                        });
                    }
                }
            }

            /* access modifiers changed from: private */
            public void a(MessageQueue messageQueue) {
                if (messageQueue != null) {
                    messageQueue.addIdleHandler(new MessageQueue.IdleHandler() {
                        public boolean queueIdle() {
                            com.bytedance.sdk.openadsdk.core.widget.a.b.b().c();
                            return false;
                        }
                    });
                }
            }

            public com.bytedance.sdk.component.adexpress.a.c.a e() {
                return o.c().a();
            }

            public com.bytedance.sdk.component.f.b.a f() {
                return com.bytedance.sdk.openadsdk.k.c.a().b().d();
            }

            public com.bytedance.sdk.component.f.b.b g() {
                return com.bytedance.sdk.openadsdk.k.c.a().b().c();
            }

            public String h() {
                return h.b().d();
            }

            public int j() {
                return o.d().Y();
            }
        });
        a.a().a((d) new d() {
            public void a(int i) {
                com.bytedance.sdk.openadsdk.j.b.a().a(com.bytedance.sdk.openadsdk.j.a.b.b().b(i).f(g.a(i)));
            }

            public void a(int i, String str) {
                com.bytedance.sdk.openadsdk.j.b.a().b(com.bytedance.sdk.openadsdk.j.a.b.b().b(i).f(str));
            }
        });
        com.bytedance.sdk.component.widget.a.a.a().a(new com.bytedance.sdk.component.widget.a.b() {
            public void a(com.bytedance.sdk.component.widget.b.a aVar, String str, String str2, JSONObject jSONObject, long j) {
                q b = q.b();
                b.q(aVar.a());
                b.s(aVar.b());
                b.q(aVar.c());
                com.bytedance.sdk.openadsdk.b.c.b(b, str, str2, jSONObject, j);
            }
        });
    }
}
