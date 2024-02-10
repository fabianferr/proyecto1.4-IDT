package com.ironsource.mediationsdk;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.ironsource.mediationsdk.sdk.a;

/* renamed from: com.ironsource.mediationsdk.u  reason: case insensitive filesystem */
public final class C0231u extends a {
    private static final C0231u a = new C0231u();
    /* access modifiers changed from: private */
    public InterstitialListener b = null;
    /* access modifiers changed from: private */
    public LevelPlayInterstitialListener c;
    /* access modifiers changed from: private */
    public LevelPlayInterstitialListener d;

    private C0231u() {
    }

    public static synchronized C0231u a() {
        C0231u uVar;
        synchronized (C0231u.class) {
            uVar = a;
        }
        return uVar;
    }

    public final void a(final AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.d != null) {
                        C0231u.this.d.onAdReady(C0231u.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdReady() adInfo = " + C0231u.this.f(adInfo));
                    }
                }
            });
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.b != null) {
                        C0231u.this.b.onInterstitialAdReady();
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdReady()", 1);
                    }
                }
            });
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.c != null) {
                        C0231u.this.c.onAdReady(C0231u.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdReady() adInfo = " + C0231u.this.f(adInfo));
                    }
                }
            });
        }
    }

    public final void a(final IronSourceError ironSourceError) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.d != null) {
                        C0231u.this.d.onAdLoadFailed(ironSourceError);
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdLoadFailed() error = " + ironSourceError.getErrorMessage());
                    }
                }
            });
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.b != null) {
                        C0231u.this.b.onInterstitialAdLoadFailed(ironSourceError);
                        C0231u uVar = C0231u.this;
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdLoadFailed() error=" + ironSourceError.getErrorMessage(), 1);
                    }
                }
            });
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.c != null) {
                        C0231u.this.c.onAdLoadFailed(ironSourceError);
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdLoadFailed() error = " + ironSourceError.getErrorMessage());
                    }
                }
            });
        }
    }

    public final void a(final IronSourceError ironSourceError, final AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.d != null) {
                        C0231u.this.d.onAdShowFailed(ironSourceError, C0231u.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdShowFailed() adInfo = " + C0231u.this.f(adInfo) + ", error = " + ironSourceError.getErrorMessage());
                    }
                }
            });
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.b != null) {
                        C0231u.this.b.onInterstitialAdShowFailed(ironSourceError);
                        C0231u uVar = C0231u.this;
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdShowFailed() error=" + ironSourceError.getErrorMessage(), 1);
                    }
                }
            });
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.c != null) {
                        C0231u.this.c.onAdShowFailed(ironSourceError, C0231u.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdShowFailed() adInfo = " + C0231u.this.f(adInfo) + ", error = " + ironSourceError.getErrorMessage());
                    }
                }
            });
        }
    }

    public final synchronized void a(InterstitialListener interstitialListener) {
        this.b = interstitialListener;
    }

    public final synchronized void a(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        this.c = levelPlayInterstitialListener;
    }

    public final void b(final AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.d != null) {
                        C0231u.this.d.onAdOpened(C0231u.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdOpened() adInfo = " + C0231u.this.f(adInfo));
                    }
                }
            });
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.b != null) {
                        C0231u.this.b.onInterstitialAdOpened();
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdOpened()", 1);
                    }
                }
            });
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.c != null) {
                        C0231u.this.c.onAdOpened(C0231u.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdOpened() adInfo = " + C0231u.this.f(adInfo));
                    }
                }
            });
        }
    }

    public final synchronized void b(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        this.d = levelPlayInterstitialListener;
    }

    public final void c(final AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.d != null) {
                        C0231u.this.d.onAdClosed(C0231u.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdClosed() adInfo = " + C0231u.this.f(adInfo));
                    }
                }
            });
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.b != null) {
                        C0231u.this.b.onInterstitialAdClosed();
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdClosed()", 1);
                    }
                }
            });
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.c != null) {
                        C0231u.this.c.onAdClosed(C0231u.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdClosed() adInfo = " + C0231u.this.f(adInfo));
                    }
                }
            });
        }
    }

    public final void d(final AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.d != null) {
                        C0231u.this.d.onAdShowSucceeded(C0231u.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdShowSucceeded() adInfo = " + C0231u.this.f(adInfo));
                    }
                }
            });
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.b != null) {
                        C0231u.this.b.onInterstitialAdShowSucceeded();
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdShowSucceeded()", 1);
                    }
                }
            });
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.c != null) {
                        C0231u.this.c.onAdShowSucceeded(C0231u.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdShowSucceeded() adInfo = " + C0231u.this.f(adInfo));
                    }
                }
            });
        }
    }

    public final void e(final AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.d != null) {
                        C0231u.this.d.onAdClicked(C0231u.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdClicked() adInfo = " + C0231u.this.f(adInfo));
                    }
                }
            });
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.b != null) {
                        C0231u.this.b.onInterstitialAdClicked();
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdClicked()", 1);
                    }
                }
            });
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (C0231u.this.c != null) {
                        C0231u.this.c.onAdClicked(C0231u.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdClicked() adInfo = " + C0231u.this.f(adInfo));
                    }
                }
            });
        }
    }
}
