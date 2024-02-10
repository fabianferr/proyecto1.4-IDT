package com.cellrebel.sdk.youtube.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.cellrebel.sdk.R;
import com.cellrebel.sdk.youtube.player.YouTubePlayerBridge;
import com.cellrebel.sdk.youtube.player.listeners.YouTubePlayerInitListener;
import com.cellrebel.sdk.youtube.player.listeners.YouTubePlayerListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class a extends WebView implements YouTubePlayer, YouTubePlayerBridge.YouTubePlayerBridgeCallbacks {
    /* access modifiers changed from: private */
    public final Set<YouTubePlayerListener> a;
    /* access modifiers changed from: private */
    public final Handler b;
    private YouTubePlayerInitListener c;

    /* renamed from: com.cellrebel.sdk.youtube.player.a$a  reason: collision with other inner class name */
    class C0078a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ float b;

        C0078a(String str, float f) {
            this.a = str;
            this.b = f;
        }

        public void run() {
            a aVar = a.this;
            aVar.loadUrl("javascript:loadVideo('" + this.a + "', " + this.b + ")");
        }
    }

    class b implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public void run() {
            a aVar = a.this;
            aVar.loadUrl("javascript:setSize('" + this.a + "px', '" + this.b + "px')");
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            a.this.loadUrl("javascript:stopVideo()");
            try {
                a.this.a.clear();
                a.this.b.removeCallbacksAndMessages((Object) null);
                a.this.stopLoading();
                a.this.getSettings().setJavaScriptEnabled(false);
                a.this.destroyDrawingCache();
                a.this.setWebChromeClient(new WebChromeClient());
            } catch (Exception | OutOfMemoryError unused) {
            }
        }
    }

    class d implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ float b;

        d(String str, float f) {
            this.a = str;
            this.b = f;
        }

        public void run() {
            a aVar = a.this;
            aVar.loadUrl("javascript:cueVideo('" + this.a + "', " + this.b + ")");
        }
    }

    class e implements Runnable {
        e() {
        }

        public void run() {
            a.this.loadUrl("javascript:playVideo()");
        }
    }

    class f implements Runnable {
        f() {
        }

        public void run() {
            a.this.loadUrl("javascript:pauseVideo()");
        }
    }

    class g implements Runnable {
        final /* synthetic */ int a;

        g(int i) {
            this.a = i;
        }

        public void run() {
            a aVar = a.this;
            aVar.loadUrl("javascript:setVolume(" + this.a + ")");
        }
    }

    class h implements Runnable {
        final /* synthetic */ float a;

        h(float f) {
            this.a = f;
        }

        public void run() {
            a aVar = a.this;
            aVar.loadUrl("javascript:seekTo(" + this.a + ")");
        }
    }

    class i extends WebChromeClient {
        i() {
        }

        public Bitmap getDefaultVideoPoster() {
            Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
            return defaultVideoPoster == null ? Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565) : defaultVideoPoster;
        }
    }

    protected a(Context context) {
        this(context, (AttributeSet) null);
    }

    protected a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = new Handler(Looper.getMainLooper());
        this.a = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    private void f() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(2);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setUserAgentString("Mozilla/5.0 (iPhone; CPU iPhone OS 6_1_4 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10B350 Safari/8536.25");
        addJavascriptInterface(new YouTubePlayerBridge(this), "YouTubePlayerBridge");
        loadDataWithBaseURL("https://www.youtube.com", g(), "text/html", "utf-8", (String) null);
        setWebChromeClient(new i());
    }

    private String g() {
        try {
            InputStream openRawResource = getResources().openRawResource(R.raw.youtube_player);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource, "utf-8"));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append("\n");
                } else {
                    openRawResource.close();
                    return sb.toString();
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
            throw new RuntimeException("Can't parse HTML file containing the player.");
        }
    }

    public void a() {
        this.c.a(this);
    }

    public void a(float f2) {
        this.b.post(new h(f2));
    }

    public void a(int i2) {
        if (i2 < 0 || i2 > 100) {
            throw new IllegalArgumentException("Volume must be between 0 and 100");
        }
        this.b.post(new g(i2));
    }

    public void a(int i2, int i3) {
        this.b.post(new b(i2, i3));
    }

    /* access modifiers changed from: protected */
    public void a(YouTubePlayerInitListener youTubePlayerInitListener) {
        this.c = youTubePlayerInitListener;
        f();
    }

    public void a(String str, float f2) {
        this.b.post(new C0078a(str, f2));
    }

    public boolean a(YouTubePlayerListener youTubePlayerListener) {
        return this.a.remove(youTubePlayerListener);
    }

    public void b() {
        this.b.post(new e());
    }

    public void b(String str, float f2) {
        this.b.post(new d(str, f2));
    }

    public boolean b(YouTubePlayerListener youTubePlayerListener) {
        if (youTubePlayerListener != null) {
            return this.a.add(youTubePlayerListener);
        }
        Log.e("YouTubePlayer", "null YouTubePlayerListener not allowed.");
        return false;
    }

    public void c() {
        this.b.post(new f());
    }

    public Collection<YouTubePlayerListener> d() {
        return Collections.unmodifiableCollection(new HashSet(this.a));
    }

    public void destroy() {
        this.a.clear();
        this.b.removeCallbacksAndMessages((Object) null);
        stopLoading();
        getSettings().setJavaScriptEnabled(false);
        try {
            destroyDrawingCache();
            setWebChromeClient(new WebChromeClient());
        } catch (Exception | OutOfMemoryError unused) {
        }
        super.destroy();
    }

    public void e() {
        this.b.post(new c());
    }
}
