package com.ironsource.mediationsdk;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoManualListener;
import com.ironsource.mediationsdk.sdk.a;

public final class P extends a {
    private static final P d = new P();
    public RewardedVideoListener a = null;
    public LevelPlayRewardedVideoBaseListener b;
    public LevelPlayRewardedVideoBaseListener c;

    private P() {
    }

    public static P a() {
        return d;
    }

    public final void a(final AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.c != null) {
                        P.this.c.onAdOpened(P.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdOpened() adInfo = " + P.this.f(adInfo));
                    }
                }
            });
            return;
        }
        if (this.a != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.a != null) {
                        P.this.a.onRewardedVideoAdOpened();
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdOpened()", 1);
                    }
                }
            });
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.b != null) {
                        P.this.b.onAdOpened(P.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdOpened() adInfo = " + P.this.f(adInfo));
                    }
                }
            });
        }
    }

    public final void a(final IronSourceError ironSourceError) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.c != null) {
                        ((LevelPlayRewardedVideoManualListener) P.this.c).onAdLoadFailed(ironSourceError);
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdLoadFailed() error = " + ironSourceError.getErrorMessage());
                    }
                }
            });
            return;
        }
        RewardedVideoListener rewardedVideoListener = this.a;
        if (rewardedVideoListener != null && (rewardedVideoListener instanceof RewardedVideoManualListener)) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.a != null) {
                        ((RewardedVideoManualListener) P.this.a).onRewardedVideoAdLoadFailed(ironSourceError);
                        P p = P.this;
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdLoadFailed() error=" + ironSourceError.getErrorMessage(), 1);
                    }
                }
            });
        }
        LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = this.b;
        if (levelPlayRewardedVideoBaseListener != null && (levelPlayRewardedVideoBaseListener instanceof LevelPlayRewardedVideoManualListener)) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.b != null) {
                        ((LevelPlayRewardedVideoManualListener) P.this.b).onAdLoadFailed(ironSourceError);
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdLoadFailed() error = " + ironSourceError.getErrorMessage());
                    }
                }
            });
        }
    }

    public final void a(final IronSourceError ironSourceError, final AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.c != null) {
                        P.this.c.onAdShowFailed(ironSourceError, P.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdShowFailed() adInfo = " + P.this.f(adInfo) + ", error = " + ironSourceError.getErrorMessage());
                    }
                }
            });
            return;
        }
        if (this.a != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.a != null) {
                        P.this.a.onRewardedVideoAdShowFailed(ironSourceError);
                        P p = P.this;
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdShowFailed() error=" + ironSourceError.getErrorMessage(), 1);
                    }
                }
            });
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.b != null) {
                        P.this.b.onAdShowFailed(ironSourceError, P.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdShowFailed() adInfo = " + P.this.f(adInfo) + ", error = " + ironSourceError.getErrorMessage());
                    }
                }
            });
        }
    }

    public final void a(final Placement placement, final AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.c != null) {
                        P.this.c.onAdRewarded(placement, P.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdRewarded() placement = " + placement + ", adInfo = " + P.this.f(adInfo));
                    }
                }
            });
            return;
        }
        if (this.a != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.a != null) {
                        P.this.a.onRewardedVideoAdRewarded(placement);
                        P p = P.this;
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdRewarded(" + placement + ")", 1);
                    }
                }
            });
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.b != null) {
                        P.this.b.onAdRewarded(placement, P.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdRewarded() placement = " + placement + ", adInfo = " + P.this.f(adInfo));
                    }
                }
            });
        }
    }

    public final void a(final boolean z, final AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.c == null) {
                        return;
                    }
                    if (z) {
                        ((LevelPlayRewardedVideoListener) P.this.c).onAdAvailable(P.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdAvailable() adInfo = " + P.this.f(adInfo));
                        return;
                    }
                    ((LevelPlayRewardedVideoListener) P.this.c).onAdUnavailable();
                    IronLog.CALLBACK.info("onAdUnavailable()");
                }
            });
            return;
        }
        if (this.a != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.a != null) {
                        P.this.a.onRewardedVideoAvailabilityChanged(z);
                        P p = P.this;
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAvailabilityChanged() available=" + z, 1);
                    }
                }
            });
        }
        LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = this.b;
        if (levelPlayRewardedVideoBaseListener != null && (levelPlayRewardedVideoBaseListener instanceof LevelPlayRewardedVideoListener)) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.b == null) {
                        return;
                    }
                    if (z) {
                        ((LevelPlayRewardedVideoListener) P.this.b).onAdAvailable(P.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdAvailable() adInfo = " + P.this.f(adInfo));
                        return;
                    }
                    ((LevelPlayRewardedVideoListener) P.this.b).onAdUnavailable();
                    IronLog.CALLBACK.info("onAdUnavailable()");
                }
            });
        }
    }

    public final void b() {
        if (this.c == null && this.a != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.a != null) {
                        P.this.a.onRewardedVideoAdStarted();
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdStarted()", 1);
                    }
                }
            });
        }
    }

    public final void b(final AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.c != null) {
                        P.this.c.onAdClosed(P.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdClosed() adInfo = " + P.this.f(adInfo));
                    }
                }
            });
            return;
        }
        if (this.a != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.a != null) {
                        P.this.a.onRewardedVideoAdClosed();
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdClosed()", 1);
                    }
                }
            });
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.b != null) {
                        P.this.b.onAdClosed(P.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdClosed() adInfo = " + P.this.f(adInfo));
                    }
                }
            });
        }
    }

    public final void b(final Placement placement, final AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.c != null) {
                        P.this.c.onAdClicked(placement, P.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdClicked() placement = " + placement + ", adInfo = " + P.this.f(adInfo));
                    }
                }
            });
            return;
        }
        if (this.a != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.a != null) {
                        P.this.a.onRewardedVideoAdClicked(placement);
                        P p = P.this;
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdClicked(" + placement + ")", 1);
                    }
                }
            });
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.b != null) {
                        P.this.b.onAdClicked(placement, P.this.f(adInfo));
                        IronLog ironLog = IronLog.CALLBACK;
                        ironLog.info("onAdClicked() placement = " + placement + ", adInfo = " + P.this.f(adInfo));
                    }
                }
            });
        }
    }

    public final void c() {
        if (this.c == null && this.a != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    if (P.this.a != null) {
                        P.this.a.onRewardedVideoAdEnded();
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdEnded()", 1);
                    }
                }
            });
        }
    }
}
