package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.f.a.a;
import com.mbridge.msdk.f.a.b;

public class MBCountDownView extends MBTextView {
    /* access modifiers changed from: private */
    public b a;
    /* access modifiers changed from: private */
    public MBCountDownView b = this;

    public MBCountDownView(Context context) {
        super(context);
    }

    public MBCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.a;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.a;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void initView(final String str, final String str2, int i) {
        this.a = new b().b((long) (i * 1000)).a(1000).a((a) new a() {
            public void onTick(long j) {
                if (str2.startsWith("zh")) {
                    MBCountDownView a2 = MBCountDownView.this.b;
                    a2.setText((j / 1000) + CmcdHeadersFactory.STREAMING_FORMAT_SS + str);
                    return;
                }
                MBCountDownView a3 = MBCountDownView.this.b;
                a3.setText(MBCountDownView.this.b + " " + (j / 1000) + CmcdHeadersFactory.STREAMING_FORMAT_SS);
            }

            public void onFinish() {
                MBCountDownView.this.a.b();
                SplashResData splashResData = new SplashResData();
                splashResData.seteAction(EAction.CLOSE);
                EventBus.getDefault().post(splashResData);
            }
        });
    }
}
