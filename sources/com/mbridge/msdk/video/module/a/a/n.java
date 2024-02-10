package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;

/* compiled from: VideoViewJSListener */
public final class n extends o {
    private IJSFactory l;
    private int m;
    private boolean n = false;
    private int o;
    private boolean p = false;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(IJSFactory iJSFactory, CampaignEx campaignEx, c cVar, a aVar, String str, String str2, int i, int i2, com.mbridge.msdk.video.module.a.a aVar2, int i3, boolean z, int i4) {
        super(campaignEx, cVar, aVar, str, str2, aVar2, i3, z);
        IJSFactory iJSFactory2 = iJSFactory;
        this.l = iJSFactory2;
        this.m = i;
        this.n = i2 == 0;
        if (iJSFactory2 == null) {
            this.a = false;
        }
        this.o = i4;
    }

    public final void a(int i, Object obj) {
        Integer num;
        int i2;
        if (this.a) {
            String str = "";
            if (i != 1) {
                if (i != 2) {
                    if (i != 5) {
                        int i3 = 6;
                        if (i != 6) {
                            if (i != 8) {
                                if (i != 114) {
                                    if (i != 116) {
                                        switch (i) {
                                            case 10:
                                                this.p = true;
                                                this.l.getJSNotifyProxy().a(0);
                                                break;
                                            case 11:
                                            case 12:
                                                this.l.getJSVideoModule().videoOperate(3);
                                                if (this.b.getVideo_end_type() == 3) {
                                                    this.l.getJSVideoModule().setVisible(0);
                                                } else if (this.b.getAdSpaceT() != 2) {
                                                    this.l.getJSVideoModule().setVisible(8);
                                                }
                                                if (i == 12) {
                                                    h();
                                                    i2 = 2;
                                                } else {
                                                    i2 = 1;
                                                }
                                                this.l.getJSNotifyProxy().a(i2);
                                                if (this.l.getJSCommon().g() == 2) {
                                                    this.l.getJSVideoModule().setVisible(0);
                                                    i jSVideoModule = this.l.getJSVideoModule();
                                                    this.l.getJSContainerModule().showMiniCard(jSVideoModule.getBorderViewTop(), jSVideoModule.getBorderViewLeft(), jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                                                } else if (i == 12) {
                                                    if (this.o == 1) {
                                                        if (this.b.getAdSpaceT() != 2) {
                                                            this.l.getJSContainerModule().showEndcard(this.b.getVideo_end_type());
                                                        } else {
                                                            this.l.getJSContainerModule().showVideoEndCover();
                                                        }
                                                    }
                                                } else if (this.b.getAdSpaceT() != 2) {
                                                    this.l.getJSContainerModule().showEndcard(this.b.getVideo_end_type());
                                                } else {
                                                    this.l.getJSContainerModule().showVideoEndCover();
                                                }
                                                this.l.getJSVideoModule().dismissAllAlert();
                                                if (i == 12 && !this.p && this.o == 1) {
                                                    h();
                                                    g();
                                                    f();
                                                    e();
                                                    break;
                                                }
                                            case 13:
                                                if (!this.l.getJSVideoModule().isH5Canvas()) {
                                                    this.l.getJSVideoModule().closeVideoOperate(0, 2);
                                                }
                                                this.l.getJSNotifyProxy().a(-1);
                                                break;
                                            case 14:
                                                if (!this.n) {
                                                    this.l.getJSVideoModule().closeVideoOperate(0, 1);
                                                    break;
                                                }
                                                break;
                                            case 15:
                                                if (obj != null && (obj instanceof MBridgeVideoView.a)) {
                                                    this.n = true;
                                                    this.l.getJSNotifyProxy().a((MBridgeVideoView.a) obj);
                                                    break;
                                                }
                                            default:
                                                switch (i) {
                                                    case 123:
                                                    case 124:
                                                        f jSNotifyProxy = this.l.getJSNotifyProxy();
                                                        if (i == 123) {
                                                            i3 = 7;
                                                        }
                                                        jSNotifyProxy.a(i3, str);
                                                        break;
                                                    case 125:
                                                        this.l.getJSContainerModule().hideAlertWebview();
                                                        break;
                                                }
                                        }
                                    } else {
                                        i jSVideoModule2 = this.l.getJSVideoModule();
                                        this.l.getJSContainerModule().configurationChanged(jSVideoModule2.getBorderViewWidth(), jSVideoModule2.getBorderViewHeight(), jSVideoModule2.getBorderViewRadius());
                                    }
                                } else if (this.l.getJSCommon().g() == 2) {
                                    i jSVideoModule3 = this.l.getJSVideoModule();
                                    this.l.getJSContainerModule().showMiniCard(jSVideoModule3.getBorderViewTop(), jSVideoModule3.getBorderViewLeft(), jSVideoModule3.getBorderViewWidth(), jSVideoModule3.getBorderViewHeight(), jSVideoModule3.getBorderViewRadius());
                                }
                            } else if (!this.l.getJSContainerModule().showAlertWebView()) {
                                this.l.getJSVideoModule().showAlertView();
                            } else {
                                this.l.getJSVideoModule().alertWebViewShowed();
                            }
                        }
                    } else if (obj != null && (obj instanceof Integer)) {
                        if (((Integer) obj).intValue() == 1) {
                            num = 2;
                        } else {
                            num = 1;
                        }
                        this.l.getJSVideoModule().soundOperate(num.intValue(), -1);
                        f jSNotifyProxy2 = this.l.getJSNotifyProxy();
                        jSNotifyProxy2.a(5, num + str);
                    }
                }
                this.l.getJSVideoModule().dismissAllAlert();
                if (i == 2) {
                    this.l.getJSNotifyProxy().a(2, str);
                }
                this.l.getJSVideoModule().videoOperate(3);
                if (this.l.getJSCommon().g() != 2) {
                    if (this.b.getVideo_end_type() != 3) {
                        this.l.getJSVideoModule().setVisible(8);
                    } else {
                        this.l.getJSVideoModule().setVisible(0);
                    }
                    if (this.m == 2 && !this.l.getJSContainerModule().endCardShowing() && this.b.getAdSpaceT() != 2) {
                        this.l.getJSContainerModule().showEndcard(this.b.getVideo_end_type());
                        this.l.getJSNotifyProxy().a(1);
                    }
                }
                i = 16;
                this.l.getJSNotifyProxy().a(1);
            } else if (!this.l.getJSContainerModule().endCardShowing()) {
                f jSNotifyProxy3 = this.l.getJSNotifyProxy();
                if (obj != null) {
                    str = obj.toString();
                }
                jSNotifyProxy3.a(1, str);
            }
        }
        super.a(i, obj);
    }
}
