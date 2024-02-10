package com.bytedance.sdk.component.adexpress.dynamic.c;

import com.bytedance.sdk.component.adexpress.dynamic.c.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FlexComputeRuler */
public class i {
    public static float a(float f) {
        return (float) Math.ceil((double) ((f * 16.0f) / 16.0f));
    }

    public static List<a.C0045a> a(float f, List<a.C0045a> list) {
        ArrayList<a.C0045a> arrayList = new ArrayList<>();
        for (a.C0045a clone : list) {
            arrayList.add((a.C0045a) clone.clone());
        }
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (a.C0045a aVar : arrayList) {
            if (aVar.b) {
                i = (int) (((float) i) + aVar.a);
            } else {
                i2 = (int) (((float) i2) + aVar.a);
                z = false;
            }
        }
        if (z && f > ((float) i)) {
            return arrayList;
        }
        float f2 = (float) i;
        float f3 = f < f2 ? f / f2 : 1.0f;
        float f4 = f > f2 ? (f - f2) / ((float) i2) : 0.0f;
        if (f4 > 1.0f) {
            ArrayList arrayList2 = new ArrayList();
            boolean z2 = false;
            for (a.C0045a aVar2 : arrayList) {
                if (!aVar2.b && aVar2.c != 0.0f && aVar2.a * f4 > aVar2.c) {
                    aVar2.a = aVar2.c;
                    aVar2.b = true;
                    z2 = true;
                }
                arrayList2.add(aVar2);
            }
            if (z2) {
                return a(f, arrayList2);
            }
        }
        int i3 = 0;
        for (a.C0045a aVar3 : arrayList) {
            if (aVar3.b) {
                aVar3.a = a(aVar3.a * f3);
            } else {
                aVar3.a = a(aVar3.a * f4);
            }
            i3 = (int) (((float) i3) + aVar3.a);
        }
        float f5 = (float) i3;
        if (f5 < f) {
            float f6 = f - f5;
            for (int i4 = 0; i4 < arrayList.size() && f6 > 0.0f; i4 = (i4 + 1) % arrayList.size()) {
                a.C0045a aVar4 = (a.C0045a) arrayList.get(i4);
                if ((f < f2 && aVar4.b) || (f > f2 && !aVar4.b)) {
                    aVar4.a += 0.0625f;
                    f6 -= 0.0625f;
                }
            }
        }
        return arrayList;
    }
}
