package com.cellrebel.sdk.youtube.player.playerUtils;

import android.view.View;
import android.view.ViewGroup;
import com.cellrebel.sdk.youtube.player.listeners.YouTubePlayerFullScreenListener;
import java.util.HashSet;
import java.util.Set;

public class FullScreenHelper {
    private boolean a = false;
    private final Set<YouTubePlayerFullScreenListener> b = new HashSet();

    public void a(View view) {
        if (!this.a) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            view.setLayoutParams(layoutParams);
            this.a = true;
            for (YouTubePlayerFullScreenListener d : this.b) {
                d.d();
            }
        }
    }

    public boolean a(YouTubePlayerFullScreenListener youTubePlayerFullScreenListener) {
        return this.b.add(youTubePlayerFullScreenListener);
    }

    public void b(View view) {
        if (this.a) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -1;
            view.setLayoutParams(layoutParams);
            this.a = false;
            for (YouTubePlayerFullScreenListener b2 : this.b) {
                b2.b();
            }
        }
    }

    public void c(View view) {
        if (this.a) {
            b(view);
        } else {
            a(view);
        }
    }
}
