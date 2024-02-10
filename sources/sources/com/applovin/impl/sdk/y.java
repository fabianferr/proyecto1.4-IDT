package com.applovin.impl.sdk;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import com.applovin.impl.mediation.a.e;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.sdk.AppLovinSdkUtils;

public class y {
    private final m a;
    private final u b;
    private final View c;

    public y(View view, m mVar) {
        this.a = mVar;
        this.b = mVar.A();
        this.c = view;
    }

    public long a(e eVar) {
        long j;
        if (u.a()) {
            this.b.b("ViewabilityTracker", "Checking visibility...");
        }
        if (!this.c.isShown()) {
            if (u.a()) {
                this.b.e("ViewabilityTracker", "View is hidden");
            }
            j = 2;
        } else {
            j = 0;
        }
        if (this.c.getAlpha() < eVar.E()) {
            if (u.a()) {
                this.b.e("ViewabilityTracker", "View is transparent");
            }
            j |= 4;
        }
        Animation animation = this.c.getAnimation();
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            if (u.a()) {
                this.b.e("ViewabilityTracker", "View is animating");
            }
            j |= 8;
        }
        if (this.c.getParent() == null) {
            if (u.a()) {
                this.b.e("ViewabilityTracker", "No parent view found");
            }
            j |= 16;
        }
        int pxToDp = AppLovinSdkUtils.pxToDp(this.c.getContext(), this.c.getWidth());
        if (pxToDp < eVar.C()) {
            if (u.a()) {
                u uVar = this.b;
                uVar.e("ViewabilityTracker", "View has width (" + pxToDp + ") below threshold");
            }
            j |= 32;
        }
        int pxToDp2 = AppLovinSdkUtils.pxToDp(this.c.getContext(), this.c.getHeight());
        if (pxToDp2 < eVar.D()) {
            if (u.a()) {
                u uVar2 = this.b;
                uVar2.e("ViewabilityTracker", "View has height (" + pxToDp2 + ") below threshold");
            }
            j |= 64;
        }
        Point a2 = g.a(this.c.getContext());
        Rect rect = new Rect(0, 0, a2.x, a2.y);
        int[] iArr = {-1, -1};
        this.c.getLocationOnScreen(iArr);
        int i = iArr[0];
        Rect rect2 = new Rect(i, iArr[1], this.c.getWidth() + i, iArr[1] + this.c.getHeight());
        if (!Rect.intersects(rect, rect2)) {
            if (u.a()) {
                u uVar3 = this.b;
                uVar3.e("ViewabilityTracker", "Rect (" + rect2 + ") outside of screen's bounds (" + rect + ")");
            }
            j |= 128;
        }
        Activity a3 = this.a.af().a();
        if (a3 != null && !Utils.isViewInTopActivity(this.c, a3)) {
            if (u.a()) {
                this.b.e("ViewabilityTracker", "View is not in top activity's view hierarchy");
            }
            j |= 256;
        }
        if (u.a()) {
            u uVar4 = this.b;
            uVar4.b("ViewabilityTracker", "Returning flags: " + Long.toBinaryString(j));
        }
        return j;
    }
}
