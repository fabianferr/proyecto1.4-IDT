package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.a.c;
import com.mbridge.msdk.dycreator.baseview.GradientOrientationUtils;
import com.mbridge.msdk.foundation.tools.aa;
import java.util.HashMap;

public class MBCusRoundImageView extends ImageView {
    private int a;
    private int b;
    private int c;
    private int d;
    private Xfermode e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private float[] o;
    private float[] p;
    private RectF q;
    private RectF r;
    private boolean s;
    private boolean t;
    private Path u;
    private Paint v;

    public MBCusRoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MBCusRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, (AttributeSet) null, 0);
        try {
            setAttributeSet(attributeSet);
            setLayoutParams(generateLayoutParams(context, attributeSet));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public MBCusRoundImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.u = new Path();
        this.v = new Paint();
        this.o = new float[8];
        this.p = new float[8];
        this.r = new RectF();
        this.q = new RectF();
        this.e = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        super.onSizeChanged(i2, i3, i4, i5);
        try {
            this.f = i2;
            this.g = i3;
            int i9 = 0;
            if (this.t) {
                try {
                    if (!(this.o == null || this.p == null)) {
                        while (true) {
                            i6 = 2;
                            if (i9 >= 2) {
                                break;
                            }
                            float[] fArr = this.o;
                            int i10 = this.i;
                            fArr[i9] = (float) i10;
                            this.p[i9] = ((float) i10) - (((float) this.m) / 2.0f);
                            i9++;
                        }
                        while (true) {
                            i7 = 4;
                            if (i6 >= 4) {
                                break;
                            }
                            float[] fArr2 = this.o;
                            int i11 = this.j;
                            fArr2[i6] = (float) i11;
                            this.p[i6] = ((float) i11) - (((float) this.m) / 2.0f);
                            i6++;
                        }
                        while (true) {
                            if (i7 >= 6) {
                                break;
                            }
                            float[] fArr3 = this.o;
                            int i12 = this.k;
                            fArr3[i7] = (float) i12;
                            this.p[i7] = ((float) i12) - (((float) this.m) / 2.0f);
                            i7++;
                        }
                        for (i8 = 6; i8 < 8; i8++) {
                            float[] fArr4 = this.o;
                            int i13 = this.l;
                            fArr4[i8] = (float) i13;
                            this.p[i8] = ((float) i13) - (((float) this.m) / 2.0f);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (this.o != null && this.p != null) {
                while (true) {
                    try {
                        float[] fArr5 = this.o;
                        if (i9 >= fArr5.length) {
                            break;
                        }
                        int i14 = this.h;
                        fArr5[i9] = (float) i14;
                        this.p[i9] = ((float) i14) - (((float) this.m) / 2.0f);
                        i9++;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
            RectF rectF = this.r;
            if (rectF != null) {
                int i15 = this.m;
                rectF.set(((float) i15) / 2.0f, ((float) i15) / 2.0f, ((float) this.f) - (((float) i15) / 2.0f), ((float) this.g) - (((float) i15) / 2.0f));
            }
            RectF rectF2 = this.q;
            if (rectF2 != null) {
                rectF2.set(0.0f, 0.0f, (float) this.f, (float) this.g);
            }
        } catch (Exception e4) {
            aa.d("MBridgeImageView", e4.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (canvas != null) {
            try {
                canvas.saveLayer(this.q, (Paint) null, 31);
                int i2 = this.f;
                int i3 = this.m;
                int i4 = this.g;
                canvas.scale((((float) (i2 - (i3 * 2))) * 1.0f) / ((float) i2), (((float) (i4 - (i3 * 2))) * 1.0f) / ((float) i4), ((float) i2) / 2.0f, ((float) i4) / 2.0f);
                super.onDraw(canvas);
                Paint paint = this.v;
                if (paint != null) {
                    paint.reset();
                    this.v.setAntiAlias(true);
                    this.v.setStyle(Paint.Style.FILL);
                    this.v.setXfermode(this.e);
                }
                Path path = this.u;
                if (path != null) {
                    path.reset();
                    this.u.addRoundRect(this.q, this.p, Path.Direction.CCW);
                }
                canvas.drawPath(this.u, this.v);
                Paint paint2 = this.v;
                if (paint2 != null) {
                    paint2.setXfermode((Xfermode) null);
                }
                canvas.restore();
                if (this.s) {
                    int i5 = this.m;
                    int i6 = this.n;
                    RectF rectF = this.r;
                    float[] fArr = this.o;
                    try {
                        Path path2 = this.u;
                        if (path2 != null) {
                            path2.reset();
                        }
                        Paint paint3 = this.v;
                        if (paint3 != null) {
                            paint3.setStrokeWidth((float) i5);
                            this.v.setColor(i6);
                            this.v.setStyle(Paint.Style.STROKE);
                        }
                        Path path3 = this.u;
                        if (path3 != null) {
                            path3.addRoundRect(rectF, fArr, Path.Direction.CCW);
                        }
                        if (canvas != null) {
                            canvas.drawPath(this.u, this.v);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                aa.a("MBridgeImageView", e3.getMessage());
            }
        }
    }

    public void setCornerRadius(int i2) {
        this.h = i2;
    }

    public void setBorder(int i2, int i3, int i4) {
        this.s = true;
        this.m = i3;
        this.n = i4;
        this.h = i2;
    }

    public void setCustomBorder(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.s = true;
        this.t = true;
        this.m = i6;
        this.n = i7;
        this.i = i2;
        this.k = i4;
        this.j = i3;
        this.l = i5;
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        String[] strArr;
        HashMap<String, c> c2 = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            c cVar = c2.get(attributeSet.getAttributeName(i2));
            if (cVar != null) {
                switch (AnonymousClass1.a[cVar.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i2);
                        if (!attributeValue.startsWith("@+id/")) {
                            break;
                        } else {
                            setId(attributeValue.substring(5).hashCode());
                            break;
                        }
                    case 2:
                        b.a().a(attributeSet.getAttributeValue(i2), (ImageView) this);
                        break;
                    case 3:
                        String attributeValue2 = attributeSet.getAttributeValue(i2);
                        if (!attributeValue2.startsWith("#")) {
                            if (attributeValue2.startsWith("@drawable/")) {
                                attributeValue2 = attributeValue2.substring(10);
                            }
                            setBackgroundResource(getResources().getIdentifier(attributeValue2, "drawable", getContext().getPackageName()));
                            break;
                        } else {
                            try {
                                strArr = attributeValue2.split("-");
                            } catch (Exception unused) {
                                strArr = null;
                            }
                            if (strArr != null && strArr.length <= 2) {
                                setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i2)));
                                break;
                            } else {
                                if (strArr != null && strArr.length == 3) {
                                    try {
                                        GradientDrawable gradientDrawable = new GradientDrawable(GradientOrientationUtils.getOrientation(strArr[2]), new int[]{Color.parseColor(strArr[0]), Color.parseColor(strArr[1])});
                                        gradientDrawable.setGradientType(0);
                                        setBackground(gradientDrawable);
                                        break;
                                    } catch (Exception unused2) {
                                    }
                                }
                                setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i2)));
                                break;
                            }
                        }
                        break;
                    case 4:
                        String attributeValue3 = attributeSet.getAttributeValue(i2);
                        if (TextUtils.isEmpty(attributeValue3)) {
                            break;
                        } else {
                            String str = com.mbridge.msdk.dycreator.e.b.a.get(attributeValue3.substring(8));
                            if (TextUtils.isEmpty(str)) {
                                break;
                            } else {
                                setContentDescription(str);
                                break;
                            }
                        }
                    case 5:
                        String attributeValue4 = attributeSet.getAttributeValue(i2);
                        if (!TextUtils.isEmpty(attributeValue4)) {
                            String str2 = com.mbridge.msdk.dycreator.e.b.a.get(attributeValue4.substring(8));
                            if (!TextUtils.isEmpty(str2)) {
                                setTag(str2);
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    case 6:
                        String attributeValue5 = attributeSet.getAttributeValue(i2);
                        if (!TextUtils.isEmpty(attributeValue5)) {
                            if (!attributeValue5.equals("invisible")) {
                                if (!attributeValue5.equalsIgnoreCase("gone")) {
                                    break;
                                } else {
                                    setVisibility(8);
                                    break;
                                }
                            } else {
                                setVisibility(4);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 7:
                        String attributeValue6 = attributeSet.getAttributeValue(i2);
                        if (!TextUtils.isEmpty(attributeValue6)) {
                            if (!attributeValue6.equals("fitXY")) {
                                if (!attributeValue6.equals("centerInside")) {
                                    if (!attributeValue6.equals("centerCrop")) {
                                        break;
                                    } else {
                                        setScaleType(ImageView.ScaleType.CENTER_CROP);
                                        break;
                                    }
                                } else {
                                    setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                    break;
                                }
                            } else {
                                setScaleType(ImageView.ScaleType.FIT_XY);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 8:
                        int b2 = b.a().b(attributeSet.getAttributeValue(i2));
                        this.d = b2;
                        this.c = b2;
                        this.b = b2;
                        this.a = b2;
                        setPadding(b2, b2, b2, b2);
                        break;
                    case 9:
                        int b3 = b.a().b(attributeSet.getAttributeValue(i2));
                        this.b = b3;
                        setPadding(this.a, b3, this.c, this.d);
                        break;
                    case 10:
                        int b4 = b.a().b(attributeSet.getAttributeValue(i2));
                        this.d = b4;
                        setPadding(this.a, this.b, this.c, b4);
                        break;
                    case 11:
                        int b5 = b.a().b(attributeSet.getAttributeValue(i2));
                        this.a = b5;
                        setPadding(b5, this.b, this.c, this.d);
                        break;
                    case 12:
                        int b6 = b.a().b(attributeSet.getAttributeValue(i2));
                        this.c = b6;
                        setPadding(this.a, this.b, b6, this.d);
                        break;
                }
            }
        }
    }

    /* renamed from: com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mbridge.msdk.dycreator.a.c[] r0 = com.mbridge.msdk.dycreator.a.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.id     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.src     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.background     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.contentDescription     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.Y     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.visibility     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.scaleType     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.padding     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.paddingTop     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.paddingBottom     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.paddingLeft     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.paddingRight     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_width     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_height     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.gravity     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_gravity     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView.AnonymousClass1.<clinit>():void");
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        HashMap<String, c> c2 = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            c cVar = c2.get(attributeSet.getAttributeName(i2));
            if (cVar != null) {
                int i3 = AnonymousClass1.a[cVar.ordinal()];
                if (i3 == 6) {
                    String attributeValue = attributeSet.getAttributeValue(i2);
                    if (!TextUtils.isEmpty(attributeValue)) {
                        if (attributeValue.equals("invisible")) {
                            setVisibility(4);
                        } else if (attributeValue.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                        }
                    }
                } else if (i3 == 13) {
                    String attributeValue2 = attributeSet.getAttributeValue(i2);
                    if (attributeValue2.startsWith(f.a) || attributeValue2.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue2.startsWith("wrap")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.width = b.a().b(attributeValue2);
                    }
                } else if (i3 == 14) {
                    String attributeValue3 = attributeSet.getAttributeValue(i2);
                    if (attributeValue3.startsWith(f.a) || attributeValue3.startsWith("m")) {
                        layoutParams.height = -1;
                    } else if (attributeValue3.startsWith("wrap")) {
                        layoutParams.height = -2;
                    } else {
                        layoutParams.height = b.a().b(attributeValue3);
                    }
                }
            }
        }
        return layoutParams;
    }
}
