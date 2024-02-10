package com.startapp;

import android.view.View;
import android.widget.VideoView;
import com.startapp.a0;
import com.startapp.sdk.ads.video.VideoMode;

/* compiled from: Sta */
public class z implements View.OnLayoutChangeListener {
    public final /* synthetic */ a0.b a;

    public z(a0.b bVar) {
        this.a = bVar;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        VideoView videoView;
        ja jaVar = (ja) this.a;
        boolean unused = jaVar.a.R = true;
        VideoMode videoMode = jaVar.a;
        if (videoMode.Q && videoMode.F()) {
            VideoMode videoMode2 = jaVar.a;
            if (videoMode2.Y && (videoView = videoMode2.L) != null) {
                videoMode2.b((View) videoView);
            }
        }
    }
}
