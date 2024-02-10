package com.mbridge.msdk.foundation.same.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.same.a.a;
import com.mbridge.msdk.foundation.same.a.c;
import com.mbridge.msdk.foundation.same.c.d;
import com.mbridge.msdk.foundation.same.c.e;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.af;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/* compiled from: CommonImageLoader */
public final class b {
    private static b a;
    private com.mbridge.msdk.foundation.same.e.b b;
    private c<String, Bitmap> c;
    /* access modifiers changed from: private */
    public LinkedHashMap<String, List<c>> d = new LinkedHashMap<>();
    /* access modifiers changed from: private */
    public Handler e = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            try {
                if (message.what == 1) {
                    String string = message.getData().getString("message_key");
                    Bitmap a2 = a.a(message.getData().getString("message_bitmap"));
                    b.this.a(string, a2);
                    LinkedList linkedList = (LinkedList) b.this.d.get(string);
                    if (linkedList != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            c cVar = (c) it.next();
                            if (cVar != null) {
                                cVar.onSuccessLoad(a2, string);
                            }
                        }
                    }
                    b.this.d.remove(string);
                } else if (message.what == 2) {
                    String string2 = message.getData().getString("message_key");
                    String string3 = message.getData().getString("message_message");
                    LinkedList linkedList2 = (LinkedList) b.this.d.get(string2);
                    if (linkedList2 != null) {
                        Iterator it2 = linkedList2.iterator();
                        while (it2.hasNext()) {
                            c cVar2 = (c) it2.next();
                            if (cVar2 != null) {
                                cVar2.onFailedLoad(string3, string2);
                            }
                        }
                    }
                    b.this.d.remove(string2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };

    public final void a(String str, Bitmap bitmap) {
        if (d(str) == null && bitmap != null) {
            this.c.a(str, bitmap);
        }
    }

    private Bitmap d(String str) {
        return this.c.b(str);
    }

    private b(Context context) {
        this.b = new com.mbridge.msdk.foundation.same.e.b(context);
        e g = f.a().g(com.mbridge.msdk.foundation.controller.b.d().h());
        int i = 10;
        int z = g != null ? g.z() : 10;
        this.c = new a(((int) Runtime.getRuntime().maxMemory()) / (z > 0 ? z : i));
    }

    public static b a(Context context) {
        if (a == null) {
            a = new b(context);
        }
        return a;
    }

    public final Bitmap a(String str) {
        Bitmap a2;
        if (af.a(str)) {
            return null;
        }
        if (g.b()) {
            return d.a.a.a(str);
        }
        String a3 = ae.a(str);
        File file = new File(a3);
        if (d(str) != null) {
            return d(str);
        }
        if (!file.exists() || (a2 = a.a(a3)) == null) {
            return null;
        }
        a(str, a2);
        return a2;
    }

    public final boolean b(String str) {
        if (af.a(str)) {
            return false;
        }
        if (g.b()) {
            return d.a.a.b(str);
        }
        File file = new File(ae.a(str));
        if (d(str) == null && !file.exists()) {
            return false;
        }
        return true;
    }

    private void a(String str, String str2, String str3, boolean z, boolean z2, c cVar) {
        if (!this.d.containsKey(str2)) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(cVar);
            this.d.put(str2, linkedList);
            this.b.a(a(str, str2, str3, z, z2));
            return;
        }
        LinkedList linkedList2 = (LinkedList) this.d.get(str2);
        if (linkedList2 != null && !linkedList2.contains(cVar)) {
            linkedList2.add(cVar);
        }
    }

    private e a(String str, String str2, String str3, boolean z, boolean z2) {
        AnonymousClass5 r6 = new e.a() {
            public final void a(String str, String str2) {
                Message obtainMessage = b.this.e.obtainMessage();
                obtainMessage.what = 1;
                Bundle bundle = new Bundle();
                bundle.putString("message_key", str);
                bundle.putString("message_bitmap", str2);
                obtainMessage.setData(bundle);
                b.this.e.sendMessage(obtainMessage);
            }

            public final void b(String str, String str2) {
                Message obtainMessage = b.this.e.obtainMessage();
                obtainMessage.what = 2;
                Bundle bundle = new Bundle();
                bundle.putString("message_key", str);
                bundle.putString("message_message", str2);
                obtainMessage.setData(bundle);
                b.this.e.sendMessage(obtainMessage);
            }
        };
        e eVar = new e(str, str2, str3);
        eVar.a(z);
        eVar.a((e.a) r6);
        return eVar;
    }

    public final void a() {
        if (!g.b()) {
            this.c.b();
            LinkedHashMap<String, List<c>> linkedHashMap = this.d;
            if (linkedHashMap != null) {
                linkedHashMap.clear();
            }
        }
    }

    public static void b() {
        if (!g.b()) {
            a.c();
        }
    }

    public final void a(String str, c cVar) {
        if (g.b()) {
            d.a.a.a(str, (h) null, cVar);
            return;
        }
        String a2 = ae.a(str);
        if (g.a()) {
            if (!af.a(str) && !af.a(str) && !af.a(a2)) {
                if (g.b()) {
                    d.a.a.a(str, (h) null, cVar);
                    return;
                }
                final String str2 = a2;
                final String str3 = str;
                final c cVar2 = cVar;
                final String str4 = str;
                g.c().execute(new Runnable((h) null, false) {
                    public final void run() {
                        if (new File(str2).exists()) {
                            Bitmap a2 = a.a(str2);
                            if (a2 == null || a2.isRecycled()) {
                                b.a(b.this, str3, str4, str2, true, false, cVar2, null);
                                return;
                            }
                            h hVar = null;
                            if (hVar != null) {
                                try {
                                    Bitmap a3 = hVar.a(a2);
                                    if (a3 != null) {
                                        b.a(b.this, str3, a3, cVar2);
                                    } else {
                                        b.a(b.this, str3, "image transform failed", cVar2);
                                    }
                                } catch (Exception unused) {
                                    b.a(b.this, str3, "image transform failed", cVar2);
                                }
                            } else {
                                b.a(b.this, str3, a2, cVar2);
                            }
                        } else {
                            b.a(b.this, str3, str4, str2, false, false, cVar2, null);
                        }
                    }
                });
            }
        } else if (!af.a(str) && !af.a(str) && !af.a(a2)) {
            if (g.b()) {
                d.a.a.a(str, (h) null, cVar);
                return;
            }
            File file = new File(a2);
            Bitmap d2 = d(str);
            if (d2 != null && !d2.isRecycled()) {
                cVar.onSuccessLoad(d2, str);
            } else if (file.exists()) {
                Bitmap a3 = a.a(a2);
                if (a3 == null || a3.isRecycled()) {
                    a(str, str, a2, true, false, cVar);
                    return;
                }
                a(str, a3);
                cVar.onSuccessLoad(a3, str);
            } else {
                a(str, str, a2, false, false, cVar);
            }
        }
    }

    public final void c() {
        c<String, Bitmap> cVar;
        if (!g.b() && (cVar = this.c) != null) {
            cVar.b();
        }
    }

    public final void c(String str) {
        if (!g.b()) {
            try {
                c<String, Bitmap> cVar = this.c;
                if (cVar != null && cVar.a().contains(str)) {
                    this.c.a(str);
                }
            } catch (Throwable th) {
                aa.d("ImageLoader", th.getMessage());
            }
        }
    }

    static /* synthetic */ void a(b bVar, final String str, final Bitmap bitmap, final c cVar) {
        if (MBridgeConstans.DEBUG) {
            aa.a("ImageLoader", "handler image load success event");
        }
        if (cVar != null) {
            bVar.e.post(new Runnable() {
                public final void run() {
                    c cVar = cVar;
                    if (cVar != null) {
                        cVar.onSuccessLoad(bitmap, str);
                    }
                }
            });
        }
    }

    static /* synthetic */ void a(b bVar, final String str, final String str2, final c cVar) {
        if (MBridgeConstans.DEBUG) {
            aa.a("ImageLoader", "handler image load failed event");
        }
        if (cVar != null) {
            bVar.e.post(new Runnable() {
                public final void run() {
                    c cVar = cVar;
                    if (cVar != null) {
                        cVar.onFailedLoad(str2, str);
                    }
                }
            });
        }
    }

    static /* synthetic */ void a(b bVar, final String str, String str2, String str3, boolean z, boolean z2, final c cVar, final h hVar) {
        if (!bVar.d.containsKey(str2)) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(cVar);
            bVar.d.put(str2, linkedList);
            AnonymousClass6 r6 = new e.a() {
                public final void a(String str, String str2) {
                    Bitmap a2 = a.a(str2);
                    if (a2 == null || a2.isRecycled()) {
                        b.a(b.this, str, "bitmap file not found", cVar);
                        return;
                    }
                    h hVar = hVar;
                    if (hVar != null) {
                        try {
                            Bitmap a3 = hVar.a(a2);
                            if (a3 != null) {
                                b.a(b.this, str, a3, cVar);
                            } else {
                                b.a(b.this, str, "bitmap transform failed", cVar);
                            }
                        } catch (Exception unused) {
                            b.a(b.this, str, "bitmap transform failed", cVar);
                        }
                    } else {
                        b.a(b.this, str, a2, cVar);
                    }
                }

                public final void b(String str, String str2) {
                    b.a(b.this, str, str2, cVar);
                }
            };
            e eVar = new e(str, str2, str3, hVar);
            eVar.a(z);
            eVar.a((e.a) r6);
            com.mbridge.msdk.foundation.same.f.b.e().execute(eVar);
            return;
        }
        LinkedList linkedList2 = (LinkedList) bVar.d.get(str2);
        if (linkedList2 != null && !linkedList2.contains(cVar)) {
            linkedList2.add(cVar);
        }
    }
}
