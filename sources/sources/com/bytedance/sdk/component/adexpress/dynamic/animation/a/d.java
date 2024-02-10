package com.bytedance.sdk.component.adexpress.dynamic.animation.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.appnext.ads.fullscreen.RewardedVideo;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.e;
import com.bytedance.sdk.component.g.f;
import com.google.android.gms.cast.MediaTrack;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: BaseAnimation */
public abstract class d implements e {
    public List<ObjectAnimator> a = a();
    com.bytedance.sdk.component.adexpress.dynamic.b.a b;
    public View c;
    /* access modifiers changed from: private */
    public Set<ScheduledFuture<?>> d = new HashSet();

    /* access modifiers changed from: package-private */
    public abstract List<ObjectAnimator> a();

    public d(View view, com.bytedance.sdk.component.adexpress.dynamic.b.a aVar) {
        this.c = view;
        this.b = aVar;
    }

    public void c() {
        List<ObjectAnimator> list = this.a;
        if (list != null) {
            for (final ObjectAnimator next : list) {
                next.start();
                if (this.b.q() > 0.0d) {
                    next.addListener(new Animator.AnimatorListener() {
                        public void onAnimationCancel(Animator animator) {
                        }

                        public void onAnimationEnd(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator, boolean z) {
                            onAnimationStart(animator);
                        }

                        public void onAnimationEnd(Animator animator, boolean z) {
                            onAnimationEnd(animator);
                        }

                        public void onAnimationRepeat(Animator animator) {
                            next.pause();
                            a aVar = new a(next);
                            ScheduledFuture<?> schedule = f.f().schedule(aVar, (long) (d.this.b.q() * 1000.0d), TimeUnit.MILLISECONDS);
                            aVar.a(schedule);
                            d.this.d.add(schedule);
                        }
                    });
                }
            }
        }
    }

    public void b() {
        List<ObjectAnimator> list = this.a;
        if (list != null) {
            for (ObjectAnimator next : list) {
                next.cancel();
                next.removeAllUpdateListeners();
            }
            for (ScheduledFuture<?> cancel : this.d) {
                cancel.cancel(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ObjectAnimator a(final ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay((long) (this.b.n() * 1000.0d));
        if (this.b.o() > 0) {
            objectAnimator.setRepeatCount(this.b.o() - 1);
        } else {
            objectAnimator.setRepeatCount(-1);
        }
        if (!RewardedVideo.VIDEO_MODE_NORMAL.equals(this.b.p())) {
            if (MediaTrack.ROLE_ALTERNATE.equals(this.b.p()) || "alternate-reverse".equals(this.b.p())) {
                objectAnimator.setRepeatMode(2);
            } else {
                objectAnimator.setRepeatMode(1);
            }
        }
        if ("ease-in-out".equals(this.b.m())) {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if ("ease-in".equals(this.b.p())) {
            objectAnimator.setInterpolator(new AccelerateInterpolator());
        } else if ("ease-out".equals(this.b.p())) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        } else {
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getCurrentPlayTime() > 0) {
                    d.this.c.setVisibility(0);
                    if (d.this.c.getParent() instanceof DynamicBaseWidgetImp) {
                        View view = (View) d.this.c.getParent();
                        View view2 = view;
                        view.setVisibility(0);
                    }
                    objectAnimator.removeAllUpdateListeners();
                }
            }
        });
        return objectAnimator;
    }

    /* compiled from: BaseAnimation */
    public class a implements Runnable {
        ObjectAnimator a;
        ScheduledFuture<?> b;

        a(ObjectAnimator objectAnimator) {
            this.a = objectAnimator;
        }

        public void a(ScheduledFuture<?> scheduledFuture) {
            this.b = scheduledFuture;
        }

        public void run() {
            if (com.bytedance.sdk.component.adexpress.a.a.a.a().c() != null) {
                com.bytedance.sdk.component.adexpress.a.a.a.a().c().c().post(new Runnable() {
                    public void run() {
                        a.this.a.resume();
                    }
                });
                if (this.b != null) {
                    d.this.d.remove(this.b);
                }
            }
        }
    }
}
