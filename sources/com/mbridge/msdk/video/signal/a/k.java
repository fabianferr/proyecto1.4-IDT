package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.video.module.MBridgeContainerView;

/* compiled from: JSContainerModule */
public final class k extends d {
    private MBridgeContainerView a;

    public k(MBridgeContainerView mBridgeContainerView) {
        this.a = mBridgeContainerView;
    }

    public final boolean showAlertWebView() {
        super.showAlertWebView();
        MBridgeContainerView mBridgeContainerView = this.a;
        if (mBridgeContainerView != null) {
            return mBridgeContainerView.showAlertWebView();
        }
        return false;
    }

    public final void showVideoClickView(int i) {
        super.showVideoClickView(i);
        MBridgeContainerView mBridgeContainerView = this.a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.showVideoClickView(i);
        }
    }

    public final void showEndcard(int i) {
        super.showEndcard(i);
        try {
            MBridgeContainerView mBridgeContainerView = this.a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.showEndcard(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showVideoEndCover() {
        super.showVideoEndCover();
        try {
            MBridgeContainerView mBridgeContainerView = this.a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.showVideoEndCover();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void toggleCloseBtn(int i) {
        super.toggleCloseBtn(i);
        try {
            MBridgeContainerView mBridgeContainerView = this.a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.toggleCloseBtn(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean endCardShowing() {
        try {
            MBridgeContainerView mBridgeContainerView = this.a;
            if (mBridgeContainerView != null) {
                return mBridgeContainerView.endCardShowing();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.endCardShowing();
    }

    public final boolean miniCardShowing() {
        try {
            MBridgeContainerView mBridgeContainerView = this.a;
            if (mBridgeContainerView != null) {
                return mBridgeContainerView.miniCardShowing();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.miniCardShowing();
    }

    public final void readyStatus(int i) {
        try {
            MBridgeContainerView mBridgeContainerView = this.a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.readyStatus(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.readyStatus(i);
    }

    public final void showMiniCard(int i, int i2, int i3, int i4, int i5) {
        super.showMiniCard(i, i2, i3, i4, i5);
        try {
            MBridgeContainerView mBridgeContainerView = this.a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.showMiniCard(i, i2, i3, i4, i5);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void resizeMiniCard(int i, int i2, int i3) {
        super.resizeMiniCard(i, i2, i3);
        try {
            MBridgeContainerView mBridgeContainerView = this.a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.resizeMiniCard(i, i2, i3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void configurationChanged(int i, int i2, int i3) {
        super.configurationChanged(i, i2, i3);
        try {
            MBridgeContainerView mBridgeContainerView = this.a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.configurationChanged(i, i2, i3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void hideAlertWebview() {
        super.hideAlertWebview();
        MBridgeContainerView mBridgeContainerView = this.a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.hideAlertWebview();
        }
    }

    public final void ivRewardAdsWithoutVideo(String str) {
        super.ivRewardAdsWithoutVideo(str);
        MBridgeContainerView mBridgeContainerView = this.a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.ivRewardAdsWithoutVideo(str);
        }
    }
}
