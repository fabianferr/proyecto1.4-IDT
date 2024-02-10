package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.accessibility.CaptioningManager;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.PlatformVersion;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class TextTrackStyle extends AbstractSafeParcelable {
    public static final int COLOR_UNSPECIFIED = 0;
    public static final Parcelable.Creator<TextTrackStyle> CREATOR = new zzds();
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    String zza;
    private float zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private String zzj;
    private int zzk;
    private int zzl;
    private JSONObject zzm;

    public TextTrackStyle() {
        this(1.0f, 0, 0, -1, 0, -1, 0, 0, (String) null, -1, -1, (String) null);
    }

    public static TextTrackStyle fromSystemSettings(Context context) {
        CaptioningManager captioningManager;
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (!PlatformVersion.isAtLeastKitKat() || (captioningManager = (CaptioningManager) context.getSystemService("captioning")) == null) {
            return textTrackStyle;
        }
        textTrackStyle.setFontScale(captioningManager.getFontScale());
        CaptioningManager.CaptionStyle userStyle = captioningManager.getUserStyle();
        textTrackStyle.setBackgroundColor(userStyle.backgroundColor);
        textTrackStyle.setForegroundColor(userStyle.foregroundColor);
        int i = userStyle.edgeType;
        if (i == 1) {
            textTrackStyle.setEdgeType(1);
        } else if (i != 2) {
            textTrackStyle.setEdgeType(0);
        } else {
            textTrackStyle.setEdgeType(2);
        }
        textTrackStyle.setEdgeColor(userStyle.edgeColor);
        Typeface typeface = userStyle.getTypeface();
        if (typeface != null) {
            if (Typeface.MONOSPACE.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(1);
            } else if (Typeface.SANS_SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(0);
            } else if (Typeface.SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(2);
            } else {
                textTrackStyle.setFontGenericFamily(0);
            }
            boolean isBold = typeface.isBold();
            boolean isItalic = typeface.isItalic();
            if (isBold && isItalic) {
                textTrackStyle.setFontStyle(3);
            } else if (isBold) {
                textTrackStyle.setFontStyle(1);
            } else if (isItalic) {
                textTrackStyle.setFontStyle(2);
            } else {
                textTrackStyle.setFontStyle(0);
            }
        }
        return textTrackStyle;
    }

    private static final int zzb(String str) {
        if (str != null && str.length() == 9 && str.charAt(0) == '#') {
            try {
                return Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    private static final String zzc(int i) {
        return String.format("#%02X%02X%02X%02X", new Object[]{Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Integer.valueOf(Color.alpha(i))});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) obj;
        JSONObject jSONObject = this.zzm;
        boolean z = jSONObject == null;
        JSONObject jSONObject2 = textTrackStyle.zzm;
        if (z != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && this.zzb == textTrackStyle.zzb && this.zzc == textTrackStyle.zzc && this.zzd == textTrackStyle.zzd && this.zze == textTrackStyle.zze && this.zzf == textTrackStyle.zzf && this.zzg == textTrackStyle.zzg && this.zzh == textTrackStyle.zzh && this.zzi == textTrackStyle.zzi && CastUtils.zze(this.zzj, textTrackStyle.zzj) && this.zzk == textTrackStyle.zzk && this.zzl == textTrackStyle.zzl;
    }

    public void fromJson(JSONObject jSONObject) throws JSONException {
        this.zzb = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.zzc = zzb(jSONObject.optString("foregroundColor"));
        this.zzd = zzb(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            String string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.zze = 0;
            } else if ("OUTLINE".equals(string)) {
                this.zze = 1;
            } else if ("DROP_SHADOW".equals(string)) {
                this.zze = 2;
            } else if ("RAISED".equals(string)) {
                this.zze = 3;
            } else if ("DEPRESSED".equals(string)) {
                this.zze = 4;
            }
        }
        this.zzf = zzb(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            String string2 = jSONObject.getString("windowType");
            if ("NONE".equals(string2)) {
                this.zzg = 0;
            } else if ("NORMAL".equals(string2)) {
                this.zzg = 1;
            } else if ("ROUNDED_CORNERS".equals(string2)) {
                this.zzg = 2;
            }
        }
        this.zzh = zzb(jSONObject.optString("windowColor"));
        if (this.zzg == 2) {
            this.zzi = jSONObject.optInt("windowRoundedCornerRadius", 0);
        }
        this.zzj = CastUtils.optStringOrNull(jSONObject, "fontFamily");
        if (jSONObject.has("fontGenericFamily")) {
            String string3 = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string3)) {
                this.zzk = 0;
            } else if ("MONOSPACED_SANS_SERIF".equals(string3)) {
                this.zzk = 1;
            } else if ("SERIF".equals(string3)) {
                this.zzk = 2;
            } else if ("MONOSPACED_SERIF".equals(string3)) {
                this.zzk = 3;
            } else if ("CASUAL".equals(string3)) {
                this.zzk = 4;
            } else if ("CURSIVE".equals(string3)) {
                this.zzk = 5;
            } else if ("SMALL_CAPITALS".equals(string3)) {
                this.zzk = 6;
            }
        }
        if (jSONObject.has("fontStyle")) {
            String string4 = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string4)) {
                this.zzl = 0;
            } else if ("BOLD".equals(string4)) {
                this.zzl = 1;
            } else if ("ITALIC".equals(string4)) {
                this.zzl = 2;
            } else if ("BOLD_ITALIC".equals(string4)) {
                this.zzl = 3;
            }
        }
        this.zzm = jSONObject.optJSONObject("customData");
    }

    public int getBackgroundColor() {
        return this.zzd;
    }

    public JSONObject getCustomData() {
        return this.zzm;
    }

    public int getEdgeColor() {
        return this.zzf;
    }

    public int getEdgeType() {
        return this.zze;
    }

    public String getFontFamily() {
        return this.zzj;
    }

    public int getFontGenericFamily() {
        return this.zzk;
    }

    public float getFontScale() {
        return this.zzb;
    }

    public int getFontStyle() {
        return this.zzl;
    }

    public int getForegroundColor() {
        return this.zzc;
    }

    public int getWindowColor() {
        return this.zzh;
    }

    public int getWindowCornerRadius() {
        return this.zzi;
    }

    public int getWindowType() {
        return this.zzg;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Integer.valueOf(this.zzf), Integer.valueOf(this.zzg), Integer.valueOf(this.zzh), Integer.valueOf(this.zzi), this.zzj, Integer.valueOf(this.zzk), Integer.valueOf(this.zzl), String.valueOf(this.zzm));
    }

    public void setBackgroundColor(int i) {
        this.zzd = i;
    }

    public void setCustomData(JSONObject jSONObject) {
        this.zzm = jSONObject;
    }

    public void setEdgeColor(int i) {
        this.zzf = i;
    }

    public void setEdgeType(int i) {
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.zze = i;
    }

    public void setFontFamily(String str) {
        this.zzj = str;
    }

    public void setFontGenericFamily(int i) {
        if (i < 0 || i > 6) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.zzk = i;
    }

    public void setFontScale(float f) {
        this.zzb = f;
    }

    public void setFontStyle(int i) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.zzl = i;
    }

    public void setForegroundColor(int i) {
        this.zzc = i;
    }

    public void setWindowColor(int i) {
        this.zzh = i;
    }

    public void setWindowCornerRadius(int i) {
        if (i >= 0) {
            this.zzi = i;
            return;
        }
        throw new IllegalArgumentException("invalid windowCornerRadius");
    }

    public void setWindowType(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.zzg = i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject zza() {
        /*
            r8 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "fontScale"
            float r2 = r8.zzb     // Catch:{ JSONException -> 0x00fb }
            double r2 = (double) r2     // Catch:{ JSONException -> 0x00fb }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00fb }
            int r1 = r8.zzc     // Catch:{ JSONException -> 0x00fb }
            if (r1 == 0) goto L_0x001a
            java.lang.String r2 = "foregroundColor"
            java.lang.String r1 = zzc(r1)     // Catch:{ JSONException -> 0x00fb }
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00fb }
        L_0x001a:
            int r1 = r8.zzd     // Catch:{ JSONException -> 0x00fb }
            if (r1 == 0) goto L_0x0027
            java.lang.String r2 = "backgroundColor"
            java.lang.String r1 = zzc(r1)     // Catch:{ JSONException -> 0x00fb }
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00fb }
        L_0x0027:
            int r1 = r8.zze     // Catch:{ JSONException -> 0x00fb }
            java.lang.String r2 = "NONE"
            r3 = 3
            r4 = 1
            r5 = 2
            java.lang.String r6 = "edgeType"
            if (r1 == 0) goto L_0x0054
            if (r1 == r4) goto L_0x004e
            if (r1 == r5) goto L_0x0048
            if (r1 == r3) goto L_0x0042
            r7 = 4
            if (r1 == r7) goto L_0x003c
            goto L_0x0057
        L_0x003c:
            java.lang.String r1 = "DEPRESSED"
            r0.put(r6, r1)     // Catch:{ JSONException -> 0x00fb }
            goto L_0x0057
        L_0x0042:
            java.lang.String r1 = "RAISED"
            r0.put(r6, r1)     // Catch:{ JSONException -> 0x00fb }
            goto L_0x0057
        L_0x0048:
            java.lang.String r1 = "DROP_SHADOW"
            r0.put(r6, r1)     // Catch:{ JSONException -> 0x00fb }
            goto L_0x0057
        L_0x004e:
            java.lang.String r1 = "OUTLINE"
            r0.put(r6, r1)     // Catch:{ JSONException -> 0x00fb }
            goto L_0x0057
        L_0x0054:
            r0.put(r6, r2)     // Catch:{ JSONException -> 0x00fb }
        L_0x0057:
            int r1 = r8.zzf     // Catch:{ JSONException -> 0x00fb }
            if (r1 == 0) goto L_0x0064
            java.lang.String r6 = "edgeColor"
            java.lang.String r1 = zzc(r1)     // Catch:{ JSONException -> 0x00fb }
            r0.put(r6, r1)     // Catch:{ JSONException -> 0x00fb }
        L_0x0064:
            int r1 = r8.zzg     // Catch:{ JSONException -> 0x00fb }
            java.lang.String r6 = "NORMAL"
            java.lang.String r7 = "windowType"
            if (r1 == 0) goto L_0x007b
            if (r1 == r4) goto L_0x0077
            if (r1 == r5) goto L_0x0071
            goto L_0x007e
        L_0x0071:
            java.lang.String r1 = "ROUNDED_CORNERS"
            r0.put(r7, r1)     // Catch:{ JSONException -> 0x00fb }
            goto L_0x007e
        L_0x0077:
            r0.put(r7, r6)     // Catch:{ JSONException -> 0x00fb }
            goto L_0x007e
        L_0x007b:
            r0.put(r7, r2)     // Catch:{ JSONException -> 0x00fb }
        L_0x007e:
            int r1 = r8.zzh     // Catch:{ JSONException -> 0x00fb }
            if (r1 == 0) goto L_0x008b
            java.lang.String r2 = "windowColor"
            java.lang.String r1 = zzc(r1)     // Catch:{ JSONException -> 0x00fb }
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00fb }
        L_0x008b:
            int r1 = r8.zzg     // Catch:{ JSONException -> 0x00fb }
            if (r1 != r5) goto L_0x0096
            java.lang.String r1 = "windowRoundedCornerRadius"
            int r2 = r8.zzi     // Catch:{ JSONException -> 0x00fb }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00fb }
        L_0x0096:
            java.lang.String r1 = r8.zzj     // Catch:{ JSONException -> 0x00fb }
            if (r1 == 0) goto L_0x009f
            java.lang.String r2 = "fontFamily"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00fb }
        L_0x009f:
            int r1 = r8.zzk     // Catch:{ JSONException -> 0x00fb }
            java.lang.String r2 = "fontGenericFamily"
            switch(r1) {
                case 0: goto L_0x00cb;
                case 1: goto L_0x00c5;
                case 2: goto L_0x00bf;
                case 3: goto L_0x00b9;
                case 4: goto L_0x00b3;
                case 5: goto L_0x00ad;
                case 6: goto L_0x00a7;
                default: goto L_0x00a6;
            }
        L_0x00a6:
            goto L_0x00d0
        L_0x00a7:
            java.lang.String r1 = "SMALL_CAPITALS"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00fb }
            goto L_0x00d0
        L_0x00ad:
            java.lang.String r1 = "CURSIVE"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00fb }
            goto L_0x00d0
        L_0x00b3:
            java.lang.String r1 = "CASUAL"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00fb }
            goto L_0x00d0
        L_0x00b9:
            java.lang.String r1 = "MONOSPACED_SERIF"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00fb }
            goto L_0x00d0
        L_0x00bf:
            java.lang.String r1 = "SERIF"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00fb }
            goto L_0x00d0
        L_0x00c5:
            java.lang.String r1 = "MONOSPACED_SANS_SERIF"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00fb }
            goto L_0x00d0
        L_0x00cb:
            java.lang.String r1 = "SANS_SERIF"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00fb }
        L_0x00d0:
            int r1 = r8.zzl     // Catch:{ JSONException -> 0x00fb }
            java.lang.String r2 = "fontStyle"
            if (r1 == 0) goto L_0x00ef
            if (r1 == r4) goto L_0x00e9
            if (r1 == r5) goto L_0x00e3
            if (r1 == r3) goto L_0x00dd
            goto L_0x00f2
        L_0x00dd:
            java.lang.String r1 = "BOLD_ITALIC"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00fb }
            goto L_0x00f2
        L_0x00e3:
            java.lang.String r1 = "ITALIC"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00fb }
            goto L_0x00f2
        L_0x00e9:
            java.lang.String r1 = "BOLD"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00fb }
            goto L_0x00f2
        L_0x00ef:
            r0.put(r2, r6)     // Catch:{ JSONException -> 0x00fb }
        L_0x00f2:
            org.json.JSONObject r1 = r8.zzm     // Catch:{ JSONException -> 0x00fb }
            if (r1 == 0) goto L_0x00fb
            java.lang.String r2 = "customData"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00fb }
        L_0x00fb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.TextTrackStyle.zza():org.json.JSONObject");
    }

    TextTrackStyle(float f, int i, int i2, int i3, int i4, int i5, int i6, int i7, String str, int i8, int i9, String str2) {
        this.zzb = f;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = i5;
        this.zzh = i6;
        this.zzi = i7;
        this.zzj = str;
        this.zzk = i8;
        this.zzl = i9;
        this.zza = str2;
        if (str2 != null) {
            try {
                this.zzm = new JSONObject(this.zza);
            } catch (JSONException unused) {
                this.zzm = null;
                this.zza = null;
            }
        } else {
            this.zzm = null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str;
        JSONObject jSONObject = this.zzm;
        if (jSONObject == null) {
            str = null;
        } else {
            str = jSONObject.toString();
        }
        this.zza = str;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 2, getFontScale());
        SafeParcelWriter.writeInt(parcel, 3, getForegroundColor());
        SafeParcelWriter.writeInt(parcel, 4, getBackgroundColor());
        SafeParcelWriter.writeInt(parcel, 5, getEdgeType());
        SafeParcelWriter.writeInt(parcel, 6, getEdgeColor());
        SafeParcelWriter.writeInt(parcel, 7, getWindowType());
        SafeParcelWriter.writeInt(parcel, 8, getWindowColor());
        SafeParcelWriter.writeInt(parcel, 9, getWindowCornerRadius());
        SafeParcelWriter.writeString(parcel, 10, getFontFamily(), false);
        SafeParcelWriter.writeInt(parcel, 11, getFontGenericFamily());
        SafeParcelWriter.writeInt(parcel, 12, getFontStyle());
        SafeParcelWriter.writeString(parcel, 13, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
