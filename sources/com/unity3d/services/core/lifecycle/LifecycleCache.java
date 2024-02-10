package com.unity3d.services.core.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.unity3d.scar.adapter.common.Utils;
import com.unity3d.services.core.configuration.ConfigurationReader;
import java.util.HashSet;
import java.util.Set;

public class LifecycleCache implements Application.ActivityLifecycleCallbacks, LifecycleEventObserver {
    private boolean _appActive = true;
    private final Set<IAppActiveListener> _appActiveListeners = new HashSet();
    private final Set<IAppEventListener> _appStateListeners = new HashSet();
    private LifecycleEvent _currentState = LifecycleEvent.RESUMED;
    private boolean _lifecycleAppActive = true;
    private boolean _newLifecycle = false;
    private int _numStarted = 0;

    LifecycleCache(ConfigurationReader configurationReader) {
        this._newLifecycle = configurationReader.getCurrentConfiguration().getExperiments().isJetpackLifecycle();
        startProcessLifecycleObserving();
    }

    private void startProcessLifecycleObserving() {
        Utils.runOnUiThread(new Runnable() {
            public void run() {
                LifecycleCache.this.registerLifecycleObserver();
            }
        });
    }

    /* access modifiers changed from: private */
    public void registerLifecycleObserver() {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this._currentState = LifecycleEvent.CREATED;
    }

    public void onActivityStarted(Activity activity) {
        this._currentState = LifecycleEvent.STARTED;
        if (this._numStarted == 0) {
            this._appActive = true;
            if (!this._newLifecycle) {
                notifyActiveListeners();
            }
        }
        this._numStarted++;
    }

    public void onActivityResumed(Activity activity) {
        this._currentState = LifecycleEvent.RESUMED;
        notifyStateListeners(LifecycleEvent.RESUMED);
    }

    public void onActivityPaused(Activity activity) {
        this._currentState = LifecycleEvent.PAUSED;
        notifyStateListeners(LifecycleEvent.PAUSED);
    }

    public void onActivityStopped(Activity activity) {
        this._currentState = LifecycleEvent.STOPPED;
        int i = this._numStarted - 1;
        this._numStarted = i;
        if (i <= 0) {
            this._numStarted = 0;
            this._appActive = false;
            if (!this._newLifecycle) {
                notifyActiveListeners();
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this._currentState = LifecycleEvent.SAVE_INSTANCE_STATE;
    }

    public void onActivityDestroyed(Activity activity) {
        this._currentState = LifecycleEvent.DESTROYED;
    }

    public LifecycleEvent getCurrentState() {
        return this._currentState;
    }

    public boolean isAppActive() {
        return this._newLifecycle ? this._lifecycleAppActive : this._appActive;
    }

    public synchronized void notifyStateListeners(LifecycleEvent lifecycleEvent) {
        for (IAppEventListener onLifecycleEvent : this._appStateListeners) {
            onLifecycleEvent.onLifecycleEvent(lifecycleEvent);
        }
    }

    public synchronized void notifyActiveListeners() {
        for (IAppActiveListener onAppStateChanged : this._appActiveListeners) {
            onAppStateChanged.onAppStateChanged(this._appActive);
        }
    }

    public synchronized void addActiveListener(IAppActiveListener iAppActiveListener) {
        this._appActiveListeners.add(iAppActiveListener);
    }

    public synchronized void removeActiveListener(IAppActiveListener iAppActiveListener) {
        this._appActiveListeners.remove(iAppActiveListener);
    }

    public synchronized void addStateListener(IAppEventListener iAppEventListener) {
        this._appStateListeners.add(iAppEventListener);
    }

    public synchronized void removeStateListener(IAppEventListener iAppEventListener) {
        this._appStateListeners.remove(iAppEventListener);
    }

    /* renamed from: com.unity3d.services.core.lifecycle.LifecycleCache$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.lifecycle.Lifecycle$Event[] r0 = androidx.lifecycle.Lifecycle.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$lifecycle$Lifecycle$Event = r0
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_STOP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.lifecycle.LifecycleCache.AnonymousClass2.<clinit>():void");
        }
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        int i = AnonymousClass2.$SwitchMap$androidx$lifecycle$Lifecycle$Event[event.ordinal()];
        if (i == 1) {
            this._lifecycleAppActive = false;
            if (this._newLifecycle) {
                notifyActiveListeners();
            }
        } else if (i == 2) {
            this._lifecycleAppActive = true;
            if (this._newLifecycle) {
                notifyActiveListeners();
            }
        }
    }
}
