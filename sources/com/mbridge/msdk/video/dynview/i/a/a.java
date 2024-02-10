package com.mbridge.msdk.video.dynview.i.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.f.b;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.l;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.g.a;
import java.util.List;
import java.util.Map;

/* compiled from: ChoiceOneDrawBitBg */
public class a {
    private static volatile a a;
    /* access modifiers changed from: private */
    public View b;
    private Bitmap c;
    private Bitmap d;

    private a() {
    }

    public static a a() {
        a aVar;
        if (a != null) {
            return a;
        }
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public final void a(Map<String, Bitmap> map, c cVar, View view) {
        if (view != null && cVar != null && map != null && map.size() != 0 && map.size() >= 2 && cVar.g() != null && cVar.g().size() >= 2) {
            this.b = view;
            int e = cVar.e();
            float d2 = cVar.d();
            float c2 = cVar.c();
            try {
                List<CampaignEx> g = cVar.g();
                String str = "";
                String md5 = g.get(0) != null ? SameMD5.getMD5(g.get(0).getImageUrl()) : str;
                if (g.get(1) != null) {
                    str = SameMD5.getMD5(g.get(1).getImageUrl());
                }
                Bitmap bitmap = (TextUtils.isEmpty(md5) || !map.containsKey(md5)) ? null : map.get(md5);
                Bitmap bitmap2 = (TextUtils.isEmpty(str) || !map.containsKey(str)) ? null : map.get(str);
                if (bitmap != null && !bitmap.isRecycled() && bitmap2 != null && !bitmap2.isRecycled()) {
                    a(e, d2, c2, bitmap, bitmap2);
                }
            } catch (Exception e2) {
                aa.d("ChoiceOneDrawBitBg", e2.getMessage());
            }
        }
    }

    private synchronized void a(int i, float f, float f2, Bitmap bitmap, Bitmap bitmap2) {
        try {
            final Bitmap bitmap3 = bitmap;
            final int i2 = i;
            final float f3 = f;
            final float f4 = f2;
            b.d().execute(new Runnable() {
                public final void run() {
                    try {
                        Bitmap a2 = l.a(bitmap3, 10);
                        Bitmap a3 = l.a(bitmap3, 10);
                        final a.C0156a a4 = com.mbridge.msdk.video.dynview.g.a.a();
                        a4.a(i2).a(a2).b(a3);
                        if (i2 == 2) {
                            float f = f3;
                            float f2 = f4;
                            if (f > f2) {
                                a4.a(f).b(f4);
                            } else {
                                a4.a(f2).b(f3);
                            }
                        } else {
                            a4.a(f3).b(f4);
                        }
                        if (a.this.b != null) {
                            a.this.b.post(new Runnable() {
                                public final void run() {
                                    if (a.this.b != null && a4.a() != null) {
                                        a.this.b.setBackground(a4.a());
                                    }
                                }
                            });
                        }
                    } catch (Exception e2) {
                        aa.d("ChoiceOneDrawBitBg", e2.getMessage());
                    }
                }
            });
        } catch (Exception e) {
            aa.a("ChoiceOneDrawBitBg", e.getMessage());
        }
        return;
    }

    public final void b() {
        if (this.b != null) {
            this.b = null;
        }
        Bitmap bitmap = this.c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.c.recycle();
            this.c = null;
        }
        Bitmap bitmap2 = this.d;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.d.recycle();
            this.d = null;
        }
    }
}
