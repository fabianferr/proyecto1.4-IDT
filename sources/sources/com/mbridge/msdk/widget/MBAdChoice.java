package com.mbridge.msdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.c.a;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.Campaign;

public class MBAdChoice extends MBImageView {
    private String a = "";
    private String b = "";
    private String c = "";
    private final Context d;
    private CampaignEx e;
    private a f;

    public MBAdChoice(Context context) {
        super(context);
        this.d = context;
        a();
    }

    public MBAdChoice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = context;
        a();
    }

    public MBAdChoice(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = context;
        a();
    }

    private void a() {
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        setClickable(true);
    }

    public void setCampaign(Campaign campaign) {
        if (campaign instanceof CampaignEx) {
            CampaignEx campaignEx = (CampaignEx) campaign;
            this.e = campaignEx;
            e b2 = f.a().b(b.d().h());
            this.e = campaignEx;
            if (campaignEx != null) {
                String privacyUrl = campaignEx.getPrivacyUrl();
                this.c = privacyUrl;
                if (TextUtils.isEmpty(privacyUrl)) {
                    CampaignEx.a adchoice = campaignEx.getAdchoice();
                    if (adchoice != null) {
                        this.c = adchoice.d();
                    }
                    if (TextUtils.isEmpty(this.c) && b2 != null) {
                        this.c = b2.al();
                    }
                    if (TextUtils.isEmpty(this.c)) {
                        this.c = d.a().j;
                    }
                }
            } else if (b2 != null) {
                this.c = b2.al();
            }
            this.e = campaignEx;
            if (campaignEx != null) {
                CampaignEx.a adchoice2 = campaignEx.getAdchoice();
                if (adchoice2 != null) {
                    this.a = adchoice2.e();
                }
                if (TextUtils.isEmpty(this.a) && b2 != null) {
                    this.a = b2.aj();
                }
            } else if (b2 != null) {
                this.a = b2.aj();
            }
            this.e = campaignEx;
            if (campaignEx != null) {
                CampaignEx.a adchoice3 = campaignEx.getAdchoice();
                if (adchoice3 != null) {
                    this.b = adchoice3.f();
                }
                if (TextUtils.isEmpty(this.b) && b2 != null) {
                    this.b = b2.ak();
                }
            } else if (b2 != null) {
                this.b = b2.ak();
            }
            boolean z = !TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.b);
            setImageUrl(this.a);
            if (z && this.d != null) {
                com.mbridge.msdk.foundation.same.c.b.a(b.d().g()).a(this.a, (c) new c() {
                    public final void onFailedLoad(String str, String str2) {
                    }

                    public final void onSuccessLoad(Bitmap bitmap, String str) {
                        MBAdChoice.this.setImageBitmap(bitmap);
                    }
                });
                return;
            }
            return;
        }
        this.e = null;
    }

    public void setFeedbackDialogEventListener(a aVar) {
        this.f = aVar;
    }

    public boolean performClick() {
        if (this.f == null) {
            this.f = new a() {
                public final void a() {
                }

                public final void a(String str) {
                }

                public final void b() {
                }
            };
        }
        af.a(this.e, this.f, 4, "");
        return true;
    }
}
