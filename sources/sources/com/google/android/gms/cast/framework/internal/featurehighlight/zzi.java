package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.cast.framework.R;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzi {
    private final Rect zza = new Rect();
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;
    private final zzh zzf;

    zzi(zzh zzh) {
        this.zzf = zzh;
        Resources resources = zzh.getResources();
        this.zzb = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_inner_radius);
        this.zzc = resources.getDimensionPixelOffset(R.dimen.cast_libraries_material_featurehighlight_inner_margin);
        this.zzd = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_text_max_width);
        this.zze = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_text_horizontal_offset);
    }

    private final int zzb(View view, int i, int i2, int i3, int i4) {
        int i5;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = i3 / 2;
        if (i4 - i <= i2 - i4) {
            i5 = (i4 - i6) + this.zze;
        } else {
            i5 = (i4 - i6) - this.zze;
        }
        if (i5 - marginLayoutParams.leftMargin < i) {
            return i + marginLayoutParams.leftMargin;
        }
        return (i5 + i3) + marginLayoutParams.rightMargin > i2 ? (i2 - i3) - marginLayoutParams.rightMargin : i5;
    }

    private final void zzc(View view, int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(Math.min((i - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, this.zzd), 1073741824), View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
    }

    /* access modifiers changed from: package-private */
    public final void zza(Rect rect, Rect rect2) {
        View zzb2 = this.zzf.zzb();
        if (rect.isEmpty() || rect2.isEmpty()) {
            zzb2.layout(0, 0, 0, 0);
        } else {
            int centerY = rect.centerY();
            int centerX = rect.centerX();
            int centerY2 = rect2.centerY();
            int height = rect.height();
            int i = this.zzb;
            int max = Math.max(i + i, height) / 2;
            int i2 = this.zzc;
            int i3 = centerY + max + i2;
            if (centerY < centerY2) {
                zzc(zzb2, rect2.width(), rect2.bottom - i3);
                int zzb3 = zzb(zzb2, rect2.left, rect2.right, zzb2.getMeasuredWidth(), centerX);
                zzb2.layout(zzb3, i3, zzb2.getMeasuredWidth() + zzb3, zzb2.getMeasuredHeight() + i3);
            } else {
                int i4 = (centerY - max) - i2;
                zzc(zzb2, rect2.width(), i4 - rect2.top);
                int zzb4 = zzb(zzb2, rect2.left, rect2.right, zzb2.getMeasuredWidth(), centerX);
                zzb2.layout(zzb4, i4 - zzb2.getMeasuredHeight(), zzb2.getMeasuredWidth() + zzb4, i4);
            }
        }
        this.zza.set(zzb2.getLeft(), zzb2.getTop(), zzb2.getRight(), zzb2.getBottom());
        this.zzf.zzf().zzf(rect, this.zza);
        this.zzf.zzd().zzb(rect);
    }
}
