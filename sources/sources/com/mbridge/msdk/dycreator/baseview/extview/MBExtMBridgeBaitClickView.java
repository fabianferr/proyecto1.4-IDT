package com.mbridge.msdk.dycreator.baseview.extview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.baseview.GradientOrientationUtils;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.e.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.t;
import java.util.HashMap;
import java.util.Map;

public class MBExtMBridgeBaitClickView extends MBridgeBaitClickView implements InterBase {
    private Map<String, String> a;

    public void setDynamicReport(String str, CampaignEx campaignEx) {
    }

    public MBExtMBridgeBaitClickView(Context context) {
        super(context);
    }

    public MBExtMBridgeBaitClickView(Context context, AttributeSet attributeSet) {
        super(context);
        try {
            this.a = c.a(context, attributeSet);
            setAttributeSet(attributeSet);
            setLayoutParams(generateLayoutParams(attributeSet));
            c.a(this.a, (View) this);
        } catch (Exception e) {
            aa.d("MBExtMBridgeBaitClickView", e.getMessage());
        }
    }

    public MBExtMBridgeBaitClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        String[] strArr;
        HashMap<String, com.mbridge.msdk.dycreator.a.c> c = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            com.mbridge.msdk.dycreator.a.c cVar = c.get(attributeSet.getAttributeName(i));
            if (cVar != null) {
                int i2 = AnonymousClass1.a[cVar.ordinal()];
                if (i2 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i);
                    if (attributeValue.startsWith("@+id/")) {
                        setId(attributeValue.substring(5).hashCode());
                    }
                } else if (i2 == 2) {
                    Log.i("litongtest", "设置背景颜色");
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
                        setBackgroundResource(t.a(com.mbridge.msdk.foundation.controller.b.d().g(), attributeValue2, "drawable"));
                    }
                } else if (i2 == 3) {
                    int b = b.a().b(attributeSet.getAttributeValue(i));
                    setPadding(b, b, b, b);
                } else if (i2 == 4) {
                    setGravity(b.a().c(attributeSet.getAttributeValue(i)));
                } else if (i2 == 5) {
                    String attributeValue3 = attributeSet.getAttributeValue(i);
                    if (!TextUtils.isEmpty(attributeValue3)) {
                        if (attributeValue3.equals("invisible")) {
                            setVisibility(4);
                        } else if (attributeValue3.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                        }
                    }
                }
            }
        }
    }

    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        HashMap b = b.a().b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            com.mbridge.msdk.dycreator.a.c cVar = (com.mbridge.msdk.dycreator.a.c) b.get(attributeSet.getAttributeName(i));
            if (cVar != null) {
                switch (cVar) {
                    case layout_width:
                        String attributeValue = attributeSet.getAttributeValue(i);
                        if (!attributeValue.startsWith("fill") && !attributeValue.startsWith("match")) {
                            if (!attributeValue.startsWith("w")) {
                                layoutParams.width = b.a().b(attributeValue);
                                break;
                            } else {
                                layoutParams.width = -2;
                                break;
                            }
                        } else {
                            layoutParams.width = -1;
                            break;
                        }
                        break;
                    case layout_height:
                        String attributeValue2 = attributeSet.getAttributeValue(i);
                        if (!attributeValue2.startsWith("fill") && !attributeValue2.startsWith("match")) {
                            if (!attributeValue2.startsWith("wrap")) {
                                layoutParams.height = b.a().b(attributeValue2);
                                break;
                            } else {
                                layoutParams.height = -2;
                                break;
                            }
                        } else {
                            layoutParams.height = -1;
                            break;
                        }
                        break;
                    case layout_centerHorizontal:
                        if (!attributeSet.getAttributeBooleanValue(i, false)) {
                            break;
                        } else {
                            layoutParams.addRule(14, -1);
                            break;
                        }
                    case layout_alignParentBottom:
                        if (!attributeSet.getAttributeBooleanValue(i, false)) {
                            break;
                        } else {
                            layoutParams.addRule(12, -1);
                            break;
                        }
                    case layout_alignParentTop:
                        if (!attributeSet.getAttributeBooleanValue(i, false)) {
                            break;
                        } else {
                            layoutParams.addRule(10, -1);
                            break;
                        }
                    case layout_centerVertical:
                        if (!attributeSet.getAttributeBooleanValue(i, false)) {
                            break;
                        } else {
                            layoutParams.addRule(15, -1);
                            break;
                        }
                    case layout_below:
                        String attributeValue3 = attributeSet.getAttributeValue(i);
                        if (!attributeValue3.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(3, attributeValue3.substring(5).hashCode());
                            break;
                        }
                    case layout_above:
                        String attributeValue4 = attributeSet.getAttributeValue(i);
                        if (!attributeValue4.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(2, attributeValue4.substring(5).hashCode());
                            break;
                        }
                    case layout_toLeftOf:
                        String attributeValue5 = attributeSet.getAttributeValue(i);
                        if (!attributeValue5.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(0, attributeValue5.substring(5).hashCode());
                            break;
                        }
                    case layout_toRightOf:
                        String attributeValue6 = attributeSet.getAttributeValue(i);
                        if (!attributeValue6.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(1, attributeValue6.substring(5).hashCode());
                            break;
                        }
                    case layout_toEndOf:
                        String attributeValue7 = attributeSet.getAttributeValue(i);
                        if (!attributeValue7.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(17, attributeValue7.substring(5).hashCode());
                            break;
                        }
                    case layout_margin:
                        int b2 = b.a().b(attributeSet.getAttributeValue(i));
                        layoutParams.setMargins(b2, b2, b2, b2);
                        break;
                    case layout_marginLeft:
                        layoutParams.leftMargin = b.a().b(attributeSet.getAttributeValue(i));
                        break;
                    case layout_marginRight:
                        layoutParams.rightMargin = b.a().b(attributeSet.getAttributeValue(i));
                        break;
                    case layout_marginTop:
                        layoutParams.topMargin = b.a().b(attributeSet.getAttributeValue(i));
                        break;
                    case layout_marginBottom:
                        layoutParams.bottomMargin = b.a().b(attributeSet.getAttributeValue(i));
                        break;
                    case layout_alignParentRight:
                        if (!attributeSet.getAttributeBooleanValue(i, false)) {
                            break;
                        } else {
                            layoutParams.addRule(11, -1);
                            break;
                        }
                    case layout_alignParentLeft:
                        if (!attributeSet.getAttributeBooleanValue(i, false)) {
                            break;
                        } else {
                            layoutParams.addRule(9, -1);
                            break;
                        }
                    case layout_alignTop:
                        String attributeValue8 = attributeSet.getAttributeValue(i);
                        if (!attributeValue8.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(6, attributeValue8.substring(5).hashCode());
                            break;
                        }
                    case layout_alignLeft:
                        String attributeValue9 = attributeSet.getAttributeValue(i);
                        if (!attributeValue9.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(5, attributeValue9.substring(5).hashCode());
                            break;
                        }
                    case layout_alignRight:
                        String attributeValue10 = attributeSet.getAttributeValue(i);
                        if (!attributeValue10.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(7, attributeValue10.substring(5).hashCode());
                            break;
                        }
                    case layout_alignBottom:
                        String attributeValue11 = attributeSet.getAttributeValue(i);
                        if (!attributeValue11.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(8, attributeValue11.substring(5).hashCode());
                            break;
                        }
                    case layout_centerInParent:
                        if (!attributeSet.getAttributeBooleanValue(i, false)) {
                            break;
                        } else {
                            layoutParams.addRule(13, -1);
                            break;
                        }
                    case layout_alignParentEnd:
                        if (!attributeSet.getAttributeBooleanValue(i, false)) {
                            break;
                        } else {
                            layoutParams.addRule(21, -1);
                            break;
                        }
                }
            }
        }
        return layoutParams;
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
