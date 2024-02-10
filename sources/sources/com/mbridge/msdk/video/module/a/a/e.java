package com.mbridge.msdk.video.module.a.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.w;

/* compiled from: DefaultImageLoaderListener */
public class e implements c {
    /* access modifiers changed from: private */
    public CampaignEx a;
    protected ImageView b;
    /* access modifiers changed from: private */
    public String c;

    public e(ImageView imageView) {
        this.b = imageView;
    }

    public e(ImageView imageView, CampaignEx campaignEx, String str) {
        this.b = imageView;
        this.a = campaignEx;
        this.c = str;
    }

    public void onSuccessLoad(Bitmap bitmap, String str) {
        if (bitmap == null) {
            try {
                aa.d("ImageLoaderListener", "bitmap=null");
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        } else if (this.b != null && !bitmap.isRecycled()) {
            this.b.setImageBitmap(bitmap);
            this.b.setVisibility(0);
        }
    }

    public void onFailedLoad(final String str, String str2) {
        AnonymousClass1 r3 = new Runnable() {
            public final void run() {
                try {
                    q a2 = q.a((g) h.a(b.d().g()));
                    if (e.this.a == null) {
                        aa.a("ImageLoaderListener", "campaign is null");
                        return;
                    }
                    n nVar = new n();
                    nVar.s("2000044");
                    nVar.d(w.r(b.d().g()));
                    nVar.r(e.this.a.getId());
                    nVar.d(e.this.a.getImageUrl());
                    nVar.n(e.this.a.getRequestId());
                    nVar.p(e.this.a.getRequestIdNotice());
                    nVar.q(e.this.c);
                    nVar.t(str);
                    a2.a(nVar);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        com.mbridge.msdk.foundation.controller.c.a();
        com.mbridge.msdk.foundation.same.f.b.a().execute(r3);
        aa.d("ImageLoaderListener", "desc:" + str);
    }
}
