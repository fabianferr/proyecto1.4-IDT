package com.ironsource.mediationsdk;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerListener;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;
import com.ironsource.mediationsdk.sdk.a;

/* renamed from: com.ironsource.mediationsdk.l  reason: case insensitive filesystem */
public final class C0222l extends a {
    private static final C0222l d = new C0222l();
    /* access modifiers changed from: package-private */
    public BannerListener a = null;
    /* access modifiers changed from: package-private */
    public LevelPlayBannerListener b = null;
    public LevelPlayBannerListener c = null;

    private C0222l() {
    }

    public static C0222l a() {
        return d;
    }

    public final void a(final AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.c != null) {
                        C0222l.this.c.onAdScreenPresented(C0222l.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdScreenPresented() adInfo = " + C0222l.this.f(adInfo));
                    }
                }
            });
            return;
        }
        if (this.a != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.a != null) {
                        C0222l.this.a.onBannerAdScreenPresented();
                        IronLog.CALLBACK.info("onBannerAdScreenPresented()");
                    }
                }
            });
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.b != null) {
                        C0222l.this.b.onAdScreenPresented(C0222l.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdScreenPresented() adInfo = " + C0222l.this.f(adInfo));
                    }
                }
            });
        }
    }

    public final void a(final AdInfo adInfo, boolean z) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.c != null) {
                        C0222l.this.c.onAdLoaded(C0222l.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdLoaded() adInfo = " + C0222l.this.f(adInfo));
                    }
                }
            });
            return;
        }
        if (this.a != null && !z) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.a != null) {
                        C0222l.this.a.onBannerAdLoaded();
                        IronLog.CALLBACK.info("onBannerAdLoaded()");
                    }
                }
            });
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.b != null) {
                        C0222l.this.b.onAdLoaded(C0222l.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdLoaded() adInfo = " + C0222l.this.f(adInfo));
                    }
                }
            });
        }
    }

    public final void a(final IronSourceError ironSourceError, boolean z) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.c != null) {
                        C0222l.this.c.onAdLoadFailed(ironSourceError);
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdLoadFailed() error = " + ironSourceError.getErrorMessage());
                    }
                }
            });
            return;
        }
        if (this.a != null && !z) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.a != null) {
                        C0222l.this.a.onBannerAdLoadFailed(ironSourceError);
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onBannerAdLoadFailed() error = " + ironSourceError.getErrorMessage());
                    }
                }
            });
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.b != null) {
                        C0222l.this.b.onAdLoadFailed(ironSourceError);
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdLoadFailed() error = " + ironSourceError.getErrorMessage());
                    }
                }
            });
        }
    }

    public final void b(final AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.c != null) {
                        C0222l.this.c.onAdScreenDismissed(C0222l.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdScreenDismissed() adInfo = " + C0222l.this.f(adInfo));
                    }
                }
            });
            return;
        }
        if (this.a != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.a != null) {
                        C0222l.this.a.onBannerAdScreenDismissed();
                        IronLog.CALLBACK.info("onBannerAdScreenDismissed()");
                    }
                }
            });
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.b != null) {
                        C0222l.this.b.onAdScreenDismissed(C0222l.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdScreenDismissed() adInfo = " + C0222l.this.f(adInfo));
                    }
                }
            });
        }
    }

    public final void c(final AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.c != null) {
                        C0222l.this.c.onAdLeftApplication(C0222l.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdLeftApplication() adInfo = " + C0222l.this.f(adInfo));
                    }
                }
            });
            return;
        }
        if (this.a != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.a != null) {
                        C0222l.this.a.onBannerAdLeftApplication();
                        IronLog.CALLBACK.info("onBannerAdLeftApplication()");
                    }
                }
            });
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.b != null) {
                        C0222l.this.b.onAdLeftApplication(C0222l.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdLeftApplication() adInfo = " + C0222l.this.f(adInfo));
                    }
                }
            });
        }
    }

    public final void d(final AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.c != null) {
                        C0222l.this.c.onAdClicked(C0222l.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdClicked() adInfo = " + C0222l.this.f(adInfo));
                    }
                }
            });
            return;
        }
        if (this.a != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.a != null) {
                        C0222l.this.a.onBannerAdClicked();
                        IronLog.CALLBACK.info("onBannerAdClicked()");
                    }
                }
            });
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0222l.this.b != null) {
                        C0222l.this.b.onAdClicked(C0222l.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdClicked() adInfo = " + C0222l.this.f(adInfo));
                    }
                }
            });
        }
    }
}
