package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.mediationsdk.demandOnly.l;
import com.ironsource.mediationsdk.logger.IronSourceError;

public final class m extends l.a<ISDemandOnlyInterstitialListener> implements ISDemandOnlyInterstitialListener {
    m() {
    }

    m(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        a(iSDemandOnlyInterstitialListener);
    }

    public final void onInterstitialAdClicked(final String str) {
        final ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener = (ISDemandOnlyInterstitialListener) a();
        a((Runnable) new Runnable() {
            public final void run() {
                m.a(str, "onInterstitialAdClicked()");
                iSDemandOnlyInterstitialListener.onInterstitialAdClicked(str);
            }
        }, iSDemandOnlyInterstitialListener != null);
    }

    public final void onInterstitialAdClosed(final String str) {
        final ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener = (ISDemandOnlyInterstitialListener) a();
        a((Runnable) new Runnable() {
            public final void run() {
                m.a(str, "onInterstitialAdClosed()");
                iSDemandOnlyInterstitialListener.onInterstitialAdClosed(str);
            }
        }, iSDemandOnlyInterstitialListener != null);
    }

    public final void onInterstitialAdLoadFailed(final String str, final IronSourceError ironSourceError) {
        final ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener = (ISDemandOnlyInterstitialListener) a();
        a((Runnable) new Runnable() {
            public final void run() {
                String str = str;
                m.a(str, "onInterstitialAdLoadFailed() error = " + ironSourceError.getErrorMessage());
                iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(str, ironSourceError);
            }
        }, iSDemandOnlyInterstitialListener != null);
    }

    public final void onInterstitialAdOpened(final String str) {
        final ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener = (ISDemandOnlyInterstitialListener) a();
        a((Runnable) new Runnable() {
            public final void run() {
                m.a(str, "onInterstitialAdOpened()");
                iSDemandOnlyInterstitialListener.onInterstitialAdOpened(str);
            }
        }, iSDemandOnlyInterstitialListener != null);
    }

    public final void onInterstitialAdReady(final String str) {
        final ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener = (ISDemandOnlyInterstitialListener) a();
        a((Runnable) new Runnable() {
            public final void run() {
                m.a(str, "onInterstitialAdReady()");
                iSDemandOnlyInterstitialListener.onInterstitialAdReady(str);
            }
        }, iSDemandOnlyInterstitialListener != null);
    }

    public final void onInterstitialAdShowFailed(final String str, final IronSourceError ironSourceError) {
        final ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener = (ISDemandOnlyInterstitialListener) a();
        a((Runnable) new Runnable() {
            public final void run() {
                String str = str;
                m.a(str, "onInterstitialAdShowFailed()  error = " + ironSourceError.getErrorMessage());
                iSDemandOnlyInterstitialListener.onInterstitialAdShowFailed(str, ironSourceError);
            }
        }, iSDemandOnlyInterstitialListener != null);
    }
}
