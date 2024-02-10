package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.internal.cast.zzek;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
class InnerZoneDrawable extends Drawable {
    private final Paint zza;
    private final Paint zzb;
    private final Rect zzc = new Rect();
    private final int zzd;
    private final int zze;
    private float zzf;
    private float zzg = 1.0f;
    private float zzh;
    private float zzi;
    private float zzj;
    private float zzk;

    public InnerZoneDrawable(Context context) {
        Paint paint = new Paint();
        this.zza = paint;
        Paint paint2 = new Paint();
        this.zzb = paint2;
        Resources resources = context.getResources();
        this.zzd = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_inner_radius);
        this.zze = resources.getInteger(R.integer.cast_libraries_material_featurehighlight_pulse_base_alpha);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(-1);
    }

    public final void draw(Canvas canvas) {
        float f = this.zzk;
        if (f > 0.0f) {
            float f2 = this.zzf * this.zzj;
            this.zzb.setAlpha((int) (((float) this.zze) * f));
            canvas.drawCircle(this.zzh, this.zzi, f2, this.zzb);
        }
        canvas.drawCircle(this.zzh, this.zzi, this.zzf * this.zzg, this.zza);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setAlpha(int i) {
        this.zza.setAlpha(i);
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.zza.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setPulseAlpha(float f) {
        this.zzk = f;
        invalidateSelf();
    }

    public void setPulseScale(float f) {
        this.zzj = f;
        invalidateSelf();
    }

    public void setScale(float f) {
        this.zzg = f;
        invalidateSelf();
    }

    public final Animator zza() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scale", new float[]{0.0f}), PropertyValuesHolder.ofInt("alpha", new int[]{0}), PropertyValuesHolder.ofFloat("pulseScale", new float[]{0.0f}), PropertyValuesHolder.ofFloat("pulseAlpha", new float[]{0.0f})});
        ofPropertyValuesHolder.setInterpolator(zzek.zza());
        return ofPropertyValuesHolder.setDuration(200);
    }

    public final void zzb(Rect rect) {
        this.zzc.set(rect);
        this.zzh = this.zzc.exactCenterX();
        this.zzi = this.zzc.exactCenterY();
        this.zzf = Math.max((float) this.zzd, Math.max(((float) this.zzc.width()) / 2.0f, ((float) this.zzc.height()) / 2.0f));
        invalidateSelf();
    }
}
