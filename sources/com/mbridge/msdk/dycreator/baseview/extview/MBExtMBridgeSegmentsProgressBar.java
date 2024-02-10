package com.mbridge.msdk.dycreator.baseview.extview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.baseview.GradientOrientationUtils;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.e.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.s;
import java.util.HashMap;
import java.util.Map;

public class MBExtMBridgeSegmentsProgressBar extends MBridgeSegmentsProgressBar implements InterBase {
    private Map<String, String> a;
    private Map<String, Boolean> b;
    private String c = "";

    public void setDynamicReport(String str, CampaignEx campaignEx) {
    }

    public MBExtMBridgeSegmentsProgressBar(Context context) {
        super(context);
    }

    public MBExtMBridgeSegmentsProgressBar(Context context, AttributeSet attributeSet) {
        super(context);
        try {
            this.a = c.a(context, attributeSet);
            setAttributeSet(attributeSet);
            setLayoutParams(generateLayoutParams(attributeSet));
            c.a(this.a, (View) this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MBExtMBridgeSegmentsProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        String[] strArr;
        HashMap<String, com.mbridge.msdk.dycreator.a.c> c2 = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            com.mbridge.msdk.dycreator.a.c cVar = c2.get(attributeSet.getAttributeName(i));
            if (cVar != null) {
                int i2 = AnonymousClass1.a[cVar.ordinal()];
                if (i2 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i);
                    if (attributeValue.startsWith("@+id/")) {
                        setId(attributeValue.substring(5).hashCode());
                    }
                } else if (i2 == 2) {
                    String attributeValue2 = attributeSet.getAttributeValue(i);
                    if (attributeValue2.startsWith("#")) {
                        try {
                            strArr = attributeValue2.split("-");
                        } catch (Exception unused) {
                            strArr = null;
                        }
                        if (strArr == null || strArr.length > 2) {
                            if (strArr != null && strArr.length == 3) {
                                try {
                                    GradientDrawable gradientDrawable = new GradientDrawable(GradientOrientationUtils.getOrientation(strArr[2]), new int[]{Color.parseColor(strArr[0]), Color.parseColor(strArr[1])});
                                    gradientDrawable.setGradientType(0);
                                    setBackground(gradientDrawable);
                                } catch (Exception unused2) {
                                }
                            }
                            setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i)));
                        } else {
                            setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i)));
                        }
                    } else {
                        if (attributeValue2.startsWith("@drawable/")) {
                            attributeValue2 = attributeValue2.substring(10);
                        }
                        String file = getContext().getFilesDir().toString();
                        setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeFile(file + "/" + attributeValue2 + ".png")));
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        String attributeValue3 = attributeSet.getAttributeValue(i);
                        if (!TextUtils.isEmpty(attributeValue3)) {
                            if (attributeValue3.equals("invisible")) {
                                setVisibility(4);
                            } else if (attributeValue3.equalsIgnoreCase("gone")) {
                                setVisibility(8);
                            }
                        }
                    } else if (i2 == 5) {
                        int b2 = b.a().b(attributeSet.getAttributeValue(i));
                        setPadding(b2, b2, b2, b2);
                    }
                } else if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i))) {
                    setOrientation(0);
                } else {
                    setOrientation(1);
                }
            }
        }
    }

    public LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LinearLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        HashMap b2 = b.a().b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            com.mbridge.msdk.dycreator.a.c cVar = (com.mbridge.msdk.dycreator.a.c) b2.get(attributeSet.getAttributeName(i));
            if (cVar != null) {
                switch (cVar) {
                    case layout_width:
                        String attributeValue = attributeSet.getAttributeValue(i);
                        if (!attributeValue.startsWith(f.a) && !attributeValue.startsWith("m")) {
                            if (!attributeValue.startsWith("wrap")) {
                                generateDefaultLayoutParams.width = b.a().b(attributeValue);
                                break;
                            } else {
                                generateDefaultLayoutParams.width = -2;
                                break;
                            }
                        } else {
                            generateDefaultLayoutParams.width = -1;
                            break;
                        }
                    case layout_height:
                        String attributeValue2 = attributeSet.getAttributeValue(i);
                        if (!attributeValue2.startsWith(f.a) && !attributeValue2.startsWith("m")) {
                            if (!attributeValue2.startsWith("wrap")) {
                                generateDefaultLayoutParams.height = b.a().b(attributeValue2);
                                break;
                            } else {
                                generateDefaultLayoutParams.height = -2;
                                break;
                            }
                        } else {
                            generateDefaultLayoutParams.height = -1;
                            break;
                        }
                        break;
                    case layout_centerHorizontal:
                        generateDefaultLayoutParams.gravity = 1;
                        break;
                    case layout_centerVertical:
                        generateDefaultLayoutParams.gravity = 16;
                        break;
                    case layout_weight:
                        generateDefaultLayoutParams.weight = attributeSet.getAttributeFloatValue(i, 0.0f);
                        break;
                    case gravity:
                        setGravity(b.a().c(attributeSet.getAttributeValue(i)));
                        break;
                    case layout_margin:
                        int b3 = b.a().b(attributeSet.getAttributeValue(i));
                        generateDefaultLayoutParams.bottomMargin = b3;
                        generateDefaultLayoutParams.leftMargin = b3;
                        generateDefaultLayoutParams.rightMargin = b3;
                        generateDefaultLayoutParams.topMargin = b3;
                        break;
                    case layout_marginLeft:
                        generateDefaultLayoutParams.leftMargin = b.a().b(attributeSet.getAttributeValue(i));
                        break;
                    case layout_marginRight:
                        generateDefaultLayoutParams.rightMargin = b.a().b(attributeSet.getAttributeValue(i));
                        break;
                    case layout_marginTop:
                        generateDefaultLayoutParams.topMargin = b.a().b(attributeSet.getAttributeValue(i));
                        break;
                    case layout_marginBottom:
                        generateDefaultLayoutParams.bottomMargin = b.a().b(attributeSet.getAttributeValue(i));
                        break;
                    case layout_gravity:
                        generateDefaultLayoutParams.gravity = b.a().c(attributeSet.getAttributeValue(i));
                        break;
                }
            }
        }
        return generateDefaultLayoutParams;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.b;
        if (map != null && map.containsKey("mbridgeAttached") && this.b.get("mbridgeAttached").booleanValue()) {
            new s.a("mbridgeAttached").a().a(this.c);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.b;
        if (map != null && map.containsKey("mbridgeDetached") && this.b.get("mbridgeDetached").booleanValue()) {
            new s.a("mbridgeDetached").a().a(this.c);
        }
    }

    public String getBindDataDes() {
        Map<String, String> map = this.a;
        return (map == null || !map.containsKey("mbridgeData")) ? "" : this.a.get("mbridgeData");
    }

    public String getActionDes() {
        Map<String, String> map = this.a;
        return (map == null || !map.containsKey("mbridgeAction")) ? "" : this.a.get("mbridgeAction");
    }

    public String getStrategyDes() {
        Map<String, String> map = this.a;
        return (map == null || !map.containsKey("mbridgeStrategy")) ? "" : this.a.get("mbridgeStrategy");
    }

    public String getEffectDes() {
        Map<String, String> map = this.a;
        return (map == null || !map.containsKey("mbridgeEffect")) ? "" : this.a.get("mbridgeEffect");
    }

    public String getReportDes() {
        Map<String, String> map = this.a;
        return (map == null || !map.containsKey("mbridgeReport")) ? "" : this.a.get("mbridgeReport");
    }
}
