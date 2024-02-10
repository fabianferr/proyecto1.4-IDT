package com.bytedance.sdk.openadsdk.api.nativeAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.utils.c;

public class PAGVideoMediaView extends PAGMediaView implements a.C0061a {
    private NativeVideoTsView b;
    private final com.bytedance.sdk.openadsdk.apiImpl.feed.a c;
    private q d;

    public PAGVideoMediaView(Context context, View view, com.bytedance.sdk.openadsdk.apiImpl.feed.a aVar) {
        super(context);
        a(view);
        this.c = aVar;
    }

    private void a(View view) {
        if (view instanceof NativeVideoTsView) {
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) view;
            this.b = nativeVideoTsView;
            addView(nativeVideoTsView, -1, -1);
        }
    }

    private void a() {
        NativeVideoTsView nativeVideoTsView = this.b;
        if (nativeVideoTsView != null) {
            nativeVideoTsView.n();
        }
    }

    private boolean b() {
        NativeVideoTsView nativeVideoTsView = this.b;
        if (nativeVideoTsView != null) {
            return nativeVideoTsView.l();
        }
        return false;
    }

    public void handleInterruptVideo() {
        if (!b()) {
            a();
        }
    }

    public void setVideoAdListener(final PAGVideoAdListener pAGVideoAdListener) {
        com.bytedance.sdk.openadsdk.apiImpl.feed.a aVar = this.c;
        if (aVar != null) {
            aVar.a((PAGVideoAdListener) new PAGVideoAdListener() {
                public void onVideoAdPlay() {
                    PAGVideoAdListener pAGVideoAdListener = pAGVideoAdListener;
                    if (pAGVideoAdListener != null) {
                        pAGVideoAdListener.onVideoAdPlay();
                    }
                }

                public void onVideoAdPaused() {
                    PAGVideoAdListener pAGVideoAdListener = pAGVideoAdListener;
                    if (pAGVideoAdListener != null) {
                        pAGVideoAdListener.onVideoAdPaused();
                    }
                }

                public void onVideoAdComplete() {
                    PAGVideoAdListener pAGVideoAdListener = pAGVideoAdListener;
                    if (pAGVideoAdListener != null) {
                        pAGVideoAdListener.onVideoAdComplete();
                    }
                }

                public void onVideoError() {
                    PAGVideoAdListener pAGVideoAdListener = pAGVideoAdListener;
                    if (pAGVideoAdListener != null) {
                        pAGVideoAdListener.onVideoError();
                    }
                }
            });
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        if (onClickListener instanceof a) {
            ((a) onClickListener).a((a.C0061a) this);
        }
    }

    public void close() {
        NativeVideoTsView nativeVideoTsView = this.b;
        if (nativeVideoTsView != null) {
            nativeVideoTsView.o();
        }
    }

    public long getVideoProgress() {
        NativeVideoTsView nativeVideoTsView = this.b;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.b.getNativeVideoController().e();
    }

    public void setMaterialMeta(q qVar) {
        this.d = qVar;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.a((ViewGroup) this, this.d);
    }
}
