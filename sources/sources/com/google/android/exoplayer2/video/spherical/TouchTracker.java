package com.google.android.exoplayer2.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.exoplayer2.video.spherical.OrientationListener;

final class TouchTracker extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, OrientationListener.Listener {
    static final float MAX_PITCH_DEGREES = 45.0f;
    private final PointF accumulatedTouchOffsetDegrees = new PointF();
    private final GestureDetector gestureDetector;
    private final Listener listener;
    private final PointF previousTouchPointPx = new PointF();
    private final float pxPerDegrees;
    private volatile float roll;

    public interface Listener {

        @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
        /* renamed from: com.google.android.exoplayer2.video.spherical.TouchTracker$Listener$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static boolean $default$onSingleTapUp(Listener _this, MotionEvent motionEvent) {
                return false;
            }
        }

        void onScrollChange(PointF pointF);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public TouchTracker(Context context, Listener listener2, float f) {
        this.listener = listener2;
        this.pxPerDegrees = f;
        this.gestureDetector = new GestureDetector(context, this);
        this.roll = 3.1415927f;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.gestureDetector.onTouchEvent(motionEvent);
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.previousTouchPointPx.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float x = (motionEvent2.getX() - this.previousTouchPointPx.x) / this.pxPerDegrees;
        float y = (motionEvent2.getY() - this.previousTouchPointPx.y) / this.pxPerDegrees;
        this.previousTouchPointPx.set(motionEvent2.getX(), motionEvent2.getY());
        double d = (double) this.roll;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        this.accumulatedTouchOffsetDegrees.x -= (cos * x) - (sin * y);
        this.accumulatedTouchOffsetDegrees.y += (sin * x) + (cos * y);
        PointF pointF = this.accumulatedTouchOffsetDegrees;
        pointF.y = Math.max(-45.0f, Math.min(MAX_PITCH_DEGREES, pointF.y));
        this.listener.onScrollChange(this.accumulatedTouchOffsetDegrees);
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.listener.onSingleTapUp(motionEvent);
    }

    public void onOrientationChange(float[] fArr, float f) {
        this.roll = -f;
    }
}