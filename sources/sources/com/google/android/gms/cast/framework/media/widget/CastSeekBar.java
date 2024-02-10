package com.google.android.gms.cast.framework.media.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.common.internal.Objects;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public class CastSeekBar extends View {
    public zze zza;
    public zzc zzb;
    public List zzc;
    public zzd zzd;
    private boolean zze;
    private Integer zzf;
    private final float zzg;
    private final float zzh;
    private final float zzi;
    private final float zzj;
    private final float zzk;
    private final Paint zzl;
    private final int zzm;
    private final int zzn;
    private final int zzo;
    private final int zzp;
    private int[] zzq;
    private Point zzr;
    private Runnable zzs;

    public CastSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    private final int zzf(int i) {
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        double d = (double) this.zza.zzb;
        double d2 = (double) i;
        double d3 = (double) measuredWidth;
        Double.isNaN(d2);
        Double.isNaN(d3);
        Double.isNaN(d);
        return (int) ((d2 / d3) * d);
    }

    private final void zzg(Canvas canvas, int i, int i2, int i3, int i4, int i5) {
        this.zzl.setColor(i5);
        float f = this.zzi;
        float f2 = (float) i3;
        float f3 = ((float) i2) / f2;
        float f4 = ((float) i) / f2;
        float f5 = (float) i4;
        canvas.drawRect(f4 * f5, -f, f3 * f5, f, this.zzl);
    }

    /* access modifiers changed from: private */
    public final void zzh(int i) {
        zze zze2 = this.zza;
        if (zze2.zzf) {
            int i2 = zze2.zzd;
            this.zzf = Integer.valueOf(Math.min(Math.max(i, i2), zze2.zze));
            zzd zzd2 = this.zzd;
            if (zzd2 != null) {
                zzd2.zza(this, getProgress(), true);
            }
            Runnable runnable = this.zzs;
            if (runnable == null) {
                this.zzs = new zza(this);
            } else {
                removeCallbacks(runnable);
            }
            postDelayed(this.zzs, 200);
            postInvalidate();
        }
    }

    /* access modifiers changed from: private */
    public final void zzi() {
        this.zze = true;
        zzd zzd2 = this.zzd;
        if (zzd2 != null) {
            zzd2.zzb(this);
        }
    }

    /* access modifiers changed from: private */
    public final void zzj() {
        this.zze = false;
        zzd zzd2 = this.zzd;
        if (zzd2 != null) {
            zzd2.zzc(this);
        }
    }

    public int getMaxProgress() {
        return this.zza.zzb;
    }

    public int getProgress() {
        Integer num = this.zzf;
        if (num != null) {
            return num.intValue();
        }
        return this.zza.zza;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        Runnable runnable = this.zzs;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        int save = canvas.save();
        canvas2.translate((float) getPaddingLeft(), (float) getPaddingTop());
        zzc zzc2 = this.zzb;
        if (zzc2 == null) {
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int progress = getProgress();
            int save2 = canvas.save();
            canvas2.translate(0.0f, (float) (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) / 2));
            zze zze2 = this.zza;
            if (zze2.zzf) {
                int i = zze2.zzd;
                if (i > 0) {
                    zzg(canvas, 0, i, zze2.zzb, measuredWidth, this.zzo);
                }
                zze zze3 = this.zza;
                int i2 = zze3.zzd;
                if (progress > i2) {
                    zzg(canvas, i2, progress, zze3.zzb, measuredWidth, this.zzm);
                }
                zze zze4 = this.zza;
                int i3 = zze4.zze;
                if (i3 > progress) {
                    zzg(canvas, progress, i3, zze4.zzb, measuredWidth, this.zzn);
                }
                zze zze5 = this.zza;
                int i4 = zze5.zzb;
                int i5 = zze5.zze;
                if (i4 > i5) {
                    zzg(canvas, i5, i4, i4, measuredWidth, this.zzo);
                }
            } else {
                int max = Math.max(zze2.zzc, 0);
                if (max > 0) {
                    zzg(canvas, 0, max, this.zza.zzb, measuredWidth, this.zzo);
                }
                if (progress > max) {
                    zzg(canvas, max, progress, this.zza.zzb, measuredWidth, this.zzm);
                }
                int i6 = this.zza.zzb;
                if (i6 > progress) {
                    zzg(canvas, progress, i6, i6, measuredWidth, this.zzo);
                }
            }
            canvas2.restoreToCount(save2);
            List<zzb> list = this.zzc;
            if (list != null && !list.isEmpty()) {
                this.zzl.setColor(this.zzp);
                int measuredWidth2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                int save3 = canvas.save();
                canvas2.translate(0.0f, (float) (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) / 2));
                for (zzb zzb2 : list) {
                    if (zzb2 != null) {
                        int min = Math.min(zzb2.zza, this.zza.zzb);
                        int i7 = (zzb2.zzc ? zzb2.zzb : 1) + min;
                        float f = (float) measuredWidth2;
                        float f2 = (float) this.zza.zzb;
                        float f3 = this.zzk;
                        float f4 = (((float) i7) * f) / f2;
                        float f5 = (((float) min) * f) / f2;
                        if (f4 - f5 < f3) {
                            f4 = f5 + f3;
                        }
                        float f6 = f4 > f ? f : f4;
                        if (f6 - f5 < f3) {
                            f5 = f6 - f3;
                        }
                        float f7 = this.zzi;
                        canvas.drawRect(f5, -f7, f6, f7, this.zzl);
                    }
                }
                canvas2.restoreToCount(save3);
            }
            if (isEnabled() && this.zza.zzf) {
                this.zzl.setColor(this.zzm);
                int measuredWidth3 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                double progress2 = (double) getProgress();
                double d = (double) this.zza.zzb;
                int save4 = canvas.save();
                float f8 = this.zzj;
                Paint paint = this.zzl;
                Double.isNaN(progress2);
                Double.isNaN(d);
                double d2 = progress2 / d;
                double d3 = (double) measuredWidth3;
                Double.isNaN(d3);
                canvas2.drawCircle((float) ((int) (d2 * d3)), ((float) measuredHeight) / 2.0f, f8, paint);
                canvas2.restoreToCount(save4);
            }
        } else {
            int measuredWidth4 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int save5 = canvas.save();
            canvas2.translate(0.0f, (float) (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) / 2));
            Canvas canvas3 = canvas;
            int i8 = measuredWidth4;
            zzg(canvas3, 0, zzc2.zza, zzc2.zzb, i8, this.zzp);
            int i9 = zzc2.zza;
            int i10 = zzc2.zzb;
            zzg(canvas3, i9, i10, i10, i8, this.zzo);
            canvas2.restoreToCount(save5);
        }
        canvas2.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSizeAndState((int) (this.zzg + ((float) getPaddingLeft()) + ((float) getPaddingRight())), i, 0), resolveSizeAndState((int) (this.zzh + ((float) getPaddingTop()) + ((float) getPaddingBottom())), i2, 0));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !this.zza.zzf) {
            return false;
        }
        if (this.zzr == null) {
            this.zzr = new Point();
        }
        if (this.zzq == null) {
            this.zzq = new int[2];
        }
        getLocationOnScreen(this.zzq);
        this.zzr.set((((int) motionEvent.getRawX()) - this.zzq[0]) - getPaddingLeft(), ((int) motionEvent.getRawY()) - this.zzq[1]);
        int action = motionEvent.getAction();
        if (action == 0) {
            zzi();
            zzh(zzf(this.zzr.x));
            return true;
        } else if (action == 1) {
            zzh(zzf(this.zzr.x));
            zzj();
            return true;
        } else if (action == 2) {
            zzh(zzf(this.zzr.x));
            return true;
        } else if (action != 3) {
            return false;
        } else {
            this.zze = false;
            this.zzf = null;
            zzd zzd2 = this.zzd;
            if (zzd2 != null) {
                zzd2.zza(this, getProgress(), true);
                this.zzd.zzc(this);
            }
            postInvalidate();
            return true;
        }
    }

    public final void zzd(List list) {
        ArrayList arrayList;
        if (!Objects.equal(this.zzc, list)) {
            if (list == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(list);
            }
            this.zzc = arrayList;
            postInvalidate();
        }
    }

    public final void zze(zze zze2) {
        if (!this.zze) {
            zze zze3 = new zze();
            zze3.zza = zze2.zza;
            zze3.zzb = zze2.zzb;
            zze3.zzc = zze2.zzc;
            zze3.zzd = zze2.zzd;
            zze3.zze = zze2.zze;
            zze3.zzf = zze2.zzf;
            this.zza = zze3;
            this.zzf = null;
            zzd zzd2 = this.zzd;
            if (zzd2 != null) {
                zzd2.zza(this, getProgress(), false);
            }
            postInvalidate();
        }
    }

    public CastSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CastSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzc = new ArrayList();
        setAccessibilityDelegate(new zzg(this, (zzf) null));
        Paint paint = new Paint(1);
        this.zzl = paint;
        paint.setStyle(Paint.Style.FILL);
        this.zzg = context.getResources().getDimension(R.dimen.cast_seek_bar_minimum_width);
        this.zzh = context.getResources().getDimension(R.dimen.cast_seek_bar_minimum_height);
        this.zzi = context.getResources().getDimension(R.dimen.cast_seek_bar_progress_height) / 2.0f;
        this.zzj = context.getResources().getDimension(R.dimen.cast_seek_bar_thumb_size) / 2.0f;
        this.zzk = context.getResources().getDimension(R.dimen.cast_seek_bar_ad_break_minimum_width);
        zze zze2 = new zze();
        this.zza = zze2;
        zze2.zzb = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.CastExpandedController, R.attr.castExpandedControllerStyle, R.style.CastExpandedController);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarProgressAndThumbColor, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarSecondaryProgressColor, 0);
        int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarUnseekableProgressColor, 0);
        int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castAdBreakMarkerColor, 0);
        this.zzm = context.getResources().getColor(resourceId);
        this.zzn = context.getResources().getColor(resourceId2);
        this.zzo = context.getResources().getColor(resourceId3);
        this.zzp = context.getResources().getColor(resourceId4);
        obtainStyledAttributes.recycle();
    }
}
