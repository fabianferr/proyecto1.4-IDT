package com.mbridge.msdk.video.module.a.a;

import android.os.Handler;
import android.text.TextUtils;
import androidx.media3.common.C;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.bt.module.b.f;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: VideoViewDefaultListener */
public final class m extends o {
    /* access modifiers changed from: private */
    public MBridgeVideoView l;
    /* access modifiers changed from: private */
    public MBridgeContainerView m;
    private int n;
    private Timer o;
    /* access modifiers changed from: private */
    public Handler p = new Handler();
    private boolean q = false;
    private boolean r = false;
    private int s;
    private int t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, c cVar, a aVar, String str, String str2, int i, int i2, com.mbridge.msdk.video.module.a.a aVar2, int i3, boolean z, int i4) {
        super(campaignEx, cVar, aVar, str, str2, aVar2, i3, z);
        MBridgeVideoView mBridgeVideoView2 = mBridgeVideoView;
        MBridgeContainerView mBridgeContainerView2 = mBridgeContainerView;
        this.l = mBridgeVideoView2;
        this.m = mBridgeContainerView2;
        this.t = i;
        this.n = i2;
        this.s = i4;
        if (mBridgeVideoView2 != null) {
            this.q = mBridgeVideoView.getVideoSkipTime() == 0;
        }
        if (mBridgeVideoView2 == null || mBridgeContainerView2 == null) {
            this.a = false;
        }
    }

    public final void a(int i, Object obj) {
        Integer num;
        if (this.a) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 5) {
                        if (i != 6) {
                            if (i != 8) {
                                switch (i) {
                                    case 10:
                                        this.r = true;
                                        this.l.soundOperate(0, 2);
                                        this.l.progressOperate(0, 2);
                                        break;
                                    case 11:
                                        this.l.videoOperate(3);
                                        this.l.dismissAllAlert();
                                        if (this.b.getVideo_end_type() == 3) {
                                            this.l.setVisibility(0);
                                        } else if (this.b.getAdSpaceT() != 2) {
                                            this.l.setVisibility(8);
                                        }
                                        if (this.b == null || this.b.getDynamicTempCode() != 5 || this.l.mCurrPlayNum != this.l.mCampaignSize) {
                                            if (this.b.getAdSpaceT() != 2) {
                                                this.m.showEndcard(this.b.getVideo_end_type());
                                                break;
                                            } else {
                                                this.m.showVideoEndCover();
                                                break;
                                            }
                                        } else {
                                            MBridgeContainerView mBridgeContainerView = this.m;
                                            if (mBridgeContainerView != null) {
                                                mBridgeContainerView.setRewardStatus(true);
                                                this.m.showOrderCampView();
                                                break;
                                            }
                                        }
                                        break;
                                    case 12:
                                        h();
                                        this.l.videoOperate(3);
                                        this.l.dismissAllAlert();
                                        if (this.b.getVideo_end_type() != 3) {
                                            this.l.setVisibility(8);
                                        } else {
                                            this.l.setVisibility(0);
                                        }
                                        if (this.r || this.s != 0) {
                                            if (this.b.isDynamicView() && this.b.getDynamicTempCode() == 5 && TextUtils.isEmpty(this.b.getendcard_url())) {
                                                j();
                                                this.s = 0;
                                            }
                                            if (!this.r && this.s == 1) {
                                                g();
                                                f();
                                                e();
                                            }
                                            if (this.b.getAdSpaceT() == 2) {
                                                this.m.showVideoEndCover();
                                                break;
                                            } else {
                                                this.m.showEndcard(this.b.getVideo_end_type());
                                                break;
                                            }
                                        }
                                    case 13:
                                        this.l.closeVideoOperate(0, 2);
                                        break;
                                    case 14:
                                        if (!this.q) {
                                            this.l.closeVideoOperate(0, 1);
                                            break;
                                        }
                                        break;
                                    case 15:
                                        if (obj != null && (obj instanceof MBridgeVideoView.a)) {
                                            MBridgeVideoView.a aVar = (MBridgeVideoView.a) obj;
                                            int videoInteractiveType = this.m.getVideoInteractiveType();
                                            if (this.b.getAdSpaceT() == 2) {
                                                this.m.showVideoClickView(1);
                                            } else if (videoInteractiveType >= 0 && aVar.a >= videoInteractiveType) {
                                                this.m.showVideoClickView(1);
                                                this.l.soundOperate(0, 1);
                                            }
                                            this.q = aVar.c;
                                            if (this.b.getDynamicTempCode() != 5) {
                                                if (((this.n >= 0 && (aVar.a >= this.n || aVar.a == aVar.b)) || (this.b.getVideoCompleteTime() > 0 && (aVar.a > this.b.getVideoCompleteTime() || aVar.a == aVar.b))) && !this.q) {
                                                    this.l.closeVideoOperate(0, 2);
                                                    this.q = true;
                                                    break;
                                                }
                                            } else {
                                                int i2 = aVar.a;
                                                int i3 = aVar.b;
                                                if (!(this.q || this.l == null || this.b == null)) {
                                                    int i4 = this.n;
                                                    int i5 = (i4 < 0 || i2 < i4) ? 1 : 2;
                                                    if (i5 != 2 && (this.b.getVideoCompleteTime() != 0 ? i2 > this.b.getVideoCompleteTime() : this.l.mCurrPlayNum > 1)) {
                                                        i5 = 2;
                                                    }
                                                    if (i5 != 2 && this.l.mCurrPlayNum > 1 && i2 == i3) {
                                                        i5 = 2;
                                                    }
                                                    if (i5 == 2) {
                                                        this.l.closeVideoOperate(0, i5);
                                                        this.q = true;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                }
                            } else {
                                MBridgeContainerView mBridgeContainerView2 = this.m;
                                if (mBridgeContainerView2 == null) {
                                    MBridgeVideoView mBridgeVideoView = this.l;
                                    if (mBridgeVideoView != null) {
                                        mBridgeVideoView.showAlertView();
                                    }
                                } else if (!mBridgeContainerView2.showAlertWebView()) {
                                    MBridgeVideoView mBridgeVideoView2 = this.l;
                                    if (mBridgeVideoView2 != null) {
                                        mBridgeVideoView2.showAlertView();
                                    }
                                } else {
                                    MBridgeVideoView mBridgeVideoView3 = this.l;
                                    if (mBridgeVideoView3 != null) {
                                        mBridgeVideoView3.alertWebViewShowed();
                                    }
                                }
                            }
                        }
                    } else if (obj != null && (obj instanceof Integer)) {
                        if (((Integer) obj).intValue() == 1) {
                            num = 2;
                        } else {
                            num = 1;
                        }
                        this.l.soundOperate(num.intValue(), -1);
                    }
                }
                this.l.dismissAllAlert();
                this.l.videoOperate(3);
                if (this.b != null && this.b.isDynamicView() && this.b.getDynamicTempCode() == 5) {
                    if (this.m == null || this.l.mCurrPlayNum != this.l.mCampaignSize) {
                        f.a(this.b, this.g, this.l.mCurrentPlayProgressTime);
                    } else {
                        if (this.b.getAdSpaceT() != 2) {
                            this.m.setRewardStatus(true);
                            this.m.showOrderCampView();
                        }
                        i = 16;
                    }
                }
                if (this.t == 2 && !this.m.endCardShowing() && this.b.getAdSpaceT() != 2) {
                    this.m.showEndcard(this.b.getVideo_end_type());
                }
                i = 16;
            } else if (!this.m.endCardShowing()) {
                int videoInteractiveType2 = this.m.getVideoInteractiveType();
                if (videoInteractiveType2 != -2) {
                    if (videoInteractiveType2 == -1) {
                        if (this.m.isLast()) {
                            this.m.showVideoClickView(1);
                            this.l.soundOperate(0, 1);
                            try {
                                i();
                                this.o = new Timer();
                                this.o.schedule(new TimerTask() {
                                    public final void run() {
                                        try {
                                            m.this.p.post(new Runnable() {
                                                public final void run() {
                                                    m.this.m.showVideoClickView(-1);
                                                    m.this.l.soundOperate(0, 2);
                                                }
                                            });
                                        } catch (Throwable th) {
                                            if (MBridgeConstans.DEBUG) {
                                                th.printStackTrace();
                                            }
                                        }
                                    }
                                }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            this.m.showVideoClickView(-1);
                            this.l.soundOperate(0, 2);
                            i();
                        }
                    }
                } else if (this.m.miniCardLoaded()) {
                    this.m.showVideoClickView(2);
                }
            }
        }
        super.a(i, obj);
    }

    private void i() {
        try {
            Timer timer = this.o;
            if (timer != null) {
                timer.cancel();
                this.o = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j() {
        /*
            r4 = this;
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r4.b
            if (r0 == 0) goto L_0x0072
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r4.b
            int r0 = r0.getDynamicTempCode()
            r1 = 5
            if (r0 != r1) goto L_0x0072
            com.mbridge.msdk.video.module.MBridgeVideoView r0 = r4.l
            if (r0 == 0) goto L_0x005e
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r0.mCampOrderViewData
            if (r0 == 0) goto L_0x005e
            r0 = 0
            r1 = 0
        L_0x0017:
            com.mbridge.msdk.video.module.MBridgeVideoView r2 = r4.l
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r2.mCampOrderViewData
            int r2 = r2.size()
            if (r1 >= r2) goto L_0x0047
            com.mbridge.msdk.video.module.MBridgeVideoView r2 = r4.l
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r2.mCampOrderViewData
            java.lang.Object r2 = r2.get(r1)
            if (r2 == 0) goto L_0x0044
            com.mbridge.msdk.video.module.MBridgeVideoView r2 = r4.l
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r2.mCampOrderViewData
            java.lang.Object r2 = r2.get(r1)
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2
            java.lang.String r2 = r2.getId()
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r4.b
            java.lang.String r3 = r3.getId()
            if (r2 != r3) goto L_0x0044
            int r0 = r1 + -1
            goto L_0x0047
        L_0x0044:
            int r1 = r1 + 1
            goto L_0x0017
        L_0x0047:
            if (r0 < 0) goto L_0x005e
            com.mbridge.msdk.video.module.MBridgeVideoView r1 = r4.l
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r1.mCampOrderViewData
            java.lang.Object r1 = r1.get(r0)
            if (r1 == 0) goto L_0x005e
            com.mbridge.msdk.video.module.MBridgeVideoView r1 = r4.l
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r1.mCampOrderViewData
            java.lang.Object r0 = r1.get(r0)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            goto L_0x005f
        L_0x005e:
            r0 = 0
        L_0x005f:
            if (r0 == 0) goto L_0x0072
            com.mbridge.msdk.video.module.MBridgeVideoView r1 = r4.l
            if (r1 == 0) goto L_0x0068
            r1.setCampaign(r0)
        L_0x0068:
            com.mbridge.msdk.video.module.MBridgeContainerView r1 = r4.m
            if (r1 == 0) goto L_0x006f
            r1.setCampaign(r0)
        L_0x006f:
            r4.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0)
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.a.a.m.j():void");
    }
}
