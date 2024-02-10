package com.appnext.a;

import android.content.Context;
import android.widget.VideoView;

public final class a extends VideoView {
    private C0023a hr;

    /* renamed from: com.appnext.a.a$a  reason: collision with other inner class name */
    public interface C0023a {
        void aB();

        void onPause();
    }

    public a(Context context) {
        super(context);
    }

    public final void setPlayPauseListener(C0023a aVar) {
        this.hr = aVar;
    }

    public final void pause() {
        super.pause();
        C0023a aVar = this.hr;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public final void start() {
        super.start();
        C0023a aVar = this.hr;
        if (aVar != null) {
            aVar.aB();
        }
    }
}
