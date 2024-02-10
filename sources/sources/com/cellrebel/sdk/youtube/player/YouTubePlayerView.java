package com.cellrebel.sdk.youtube.player;

import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.cellrebel.sdk.youtube.player.listeners.AbstractYouTubePlayerListener;
import com.cellrebel.sdk.youtube.player.listeners.YouTubePlayerFullScreenListener;
import com.cellrebel.sdk.youtube.player.listeners.YouTubePlayerInitListener;
import com.cellrebel.sdk.youtube.player.playerUtils.FullScreenHelper;
import com.cellrebel.sdk.youtube.player.playerUtils.PlaybackResumer;
import com.cellrebel.sdk.youtube.ui.DefaultPlayerUIController;
import com.cellrebel.sdk.youtube.ui.PlayerUIController;
import com.cellrebel.sdk.youtube.utils.Callable;
import com.cellrebel.sdk.youtube.utils.NetworkReceiver;
import com.cellrebel.sdk.youtube.utils.Utils;

public class YouTubePlayerView extends FrameLayout implements NetworkReceiver.NetworkListener, LifecycleObserver {
    /* access modifiers changed from: private */
    public final a a;
    private DefaultPlayerUIController b;
    private final NetworkReceiver c;
    private final PlaybackResumer d;
    private final FullScreenHelper e;
    /* access modifiers changed from: private */
    public Callable f;

    class a implements Callable {
        final /* synthetic */ YouTubePlayerInitListener a;

        /* renamed from: com.cellrebel.sdk.youtube.player.YouTubePlayerView$a$a  reason: collision with other inner class name */
        class C0077a implements YouTubePlayerInitListener {
            C0077a() {
            }

            public void a(YouTubePlayer youTubePlayer) {
                a.this.a.a(youTubePlayer);
            }
        }

        a(YouTubePlayerInitListener youTubePlayerInitListener) {
            this.a = youTubePlayerInitListener;
        }

        public void call() {
            YouTubePlayerView.this.a.a((YouTubePlayerInitListener) new C0077a());
        }
    }

    class b extends AbstractYouTubePlayerListener {
        b() {
        }

        public void a() {
            Callable unused = YouTubePlayerView.this.f = null;
        }
    }

    public YouTubePlayerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public YouTubePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YouTubePlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a aVar = new a(context);
        this.a = aVar;
        addView(aVar, new FrameLayout.LayoutParams(5000, 5000));
        this.b = new DefaultPlayerUIController(this, aVar);
        this.d = new PlaybackResumer();
        this.c = new NetworkReceiver(this);
        FullScreenHelper fullScreenHelper = new FullScreenHelper();
        this.e = fullScreenHelper;
        fullScreenHelper.a((YouTubePlayerFullScreenListener) this.b);
        a((YouTubePlayer) aVar);
    }

    private void a(YouTubePlayer youTubePlayer) {
        DefaultPlayerUIController defaultPlayerUIController = this.b;
        if (defaultPlayerUIController != null) {
            youTubePlayer.b(defaultPlayerUIController);
        }
        youTubePlayer.b(this.d);
        youTubePlayer.b(new b());
    }

    public void a() {
        Callable callable = this.f;
        if (callable != null) {
            callable.call();
        } else {
            this.d.a((YouTubePlayer) this.a);
        }
    }

    public void a(YouTubePlayerInitListener youTubePlayerInitListener, boolean z) {
        if (z) {
            getContext().registerReceiver(this.c, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        this.f = new a(youTubePlayerInitListener);
        if (Utils.a(getContext())) {
            this.f.call();
        }
    }

    public void b() {
    }

    public void c() {
        this.e.a((View) this);
    }

    public void d() {
        this.e.c(this);
    }

    public PlayerUIController getPlayerUIController() {
        DefaultPlayerUIController defaultPlayerUIController = this.b;
        if (defaultPlayerUIController != null) {
            return defaultPlayerUIController;
        }
        throw new RuntimeException("You have inflated a custom player UI. You must manage it with your own controller.");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (getLayoutParams().height == -2) {
            i2 = View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i) * 9) / 16, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: package-private */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        this.a.c();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void release() {
        removeView(this.a);
        this.a.removeAllViews();
        this.a.destroy();
        try {
            getContext().unregisterReceiver(this.c);
        } catch (Exception | OutOfMemoryError unused) {
        }
    }
}
