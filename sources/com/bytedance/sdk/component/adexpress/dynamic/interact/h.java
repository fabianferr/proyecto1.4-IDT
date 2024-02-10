package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: InteractViewFactory */
public class h {
    public static f a(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar, int i, int i2, int i3, int i4) {
        if (context == null || dynamicBaseWidget == null || gVar == null) {
            return null;
        }
        String K = gVar.K();
        K.hashCode();
        char c = 65535;
        switch (K.hashCode()) {
            case 48:
                if (K.equals("0")) {
                    c = 0;
                    break;
                }
                break;
            case 50:
                if (K.equals("2")) {
                    c = 1;
                    break;
                }
                break;
            case 53:
                if (K.equals(CampaignEx.CLICKMODE_ON)) {
                    c = 2;
                    break;
                }
                break;
            case 54:
                if (K.equals("6")) {
                    c = 3;
                    break;
                }
                break;
            case 55:
                if (K.equals("7")) {
                    c = 4;
                    break;
                }
                break;
            case 56:
                if (K.equals("8")) {
                    c = 5;
                    break;
                }
                break;
            case 57:
                if (K.equals("9")) {
                    c = 6;
                    break;
                }
                break;
            case 1567:
                if (K.equals("10")) {
                    c = 7;
                    break;
                }
                break;
            case 1568:
                if (K.equals("11")) {
                    c = 8;
                    break;
                }
                break;
            case 1569:
                if (K.equals("12")) {
                    c = 9;
                    break;
                }
                break;
            case 1570:
                if (K.equals("13")) {
                    c = 10;
                    break;
                }
                break;
            case 1571:
                if (K.equals("14")) {
                    c = 11;
                    break;
                }
                break;
            case 1573:
                if (K.equals("16")) {
                    c = 12;
                    break;
                }
                break;
            case 1574:
                if (K.equals("17")) {
                    c = 13;
                    break;
                }
                break;
            case 1575:
                if (K.equals("18")) {
                    c = 14;
                    break;
                }
                break;
            case 1598:
                if (K.equals("20")) {
                    c = 15;
                    break;
                }
                break;
            case 1600:
                if (K.equals("22")) {
                    c = 16;
                    break;
                }
                break;
            case 1602:
                if (K.equals("24")) {
                    c = 17;
                    break;
                }
                break;
            case 1607:
                if (K.equals("29")) {
                    c = 18;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new d(context, dynamicBaseWidget, gVar);
            case 1:
                return new b(context, dynamicBaseWidget, gVar);
            case 2:
                if (gVar.L() == 1) {
                    return new o(context, dynamicBaseWidget, gVar, gVar.X());
                }
                return new m(context, dynamicBaseWidget, gVar);
            case 3:
            case 8:
                return new k(context, dynamicBaseWidget, gVar);
            case 4:
            case 11:
                return new i(context, dynamicBaseWidget, gVar);
            case 5:
                return new j(context, dynamicBaseWidget, gVar);
            case 6:
            case 12:
                return new l(context, dynamicBaseWidget, gVar, K, i, i2, i4);
            case 7:
                return new c(context, dynamicBaseWidget, gVar);
            case 9:
                return new m(context, dynamicBaseWidget, gVar);
            case 10:
                return new o(context, dynamicBaseWidget, gVar);
            case 13:
            case 14:
                return new q(context, dynamicBaseWidget, gVar, K, i3);
            case 15:
                return new a(context, dynamicBaseWidget, gVar);
            case 16:
                if (d.b()) {
                    return new n(context, dynamicBaseWidget, gVar);
                }
                return new p(context, dynamicBaseWidget, gVar);
            case 17:
                return new n(context, dynamicBaseWidget, gVar);
            case 18:
                return new e(context, dynamicBaseWidget, gVar, i, i2, i4);
            default:
                return null;
        }
    }
}
