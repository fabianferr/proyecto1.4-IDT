package com.cellrebel.sdk.trafficprofile;

import com.cellrebel.sdk.trafficprofile.models.TrafficProfile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TrafficProfileRandomizer {
    private static int a(List<TrafficProfile> list) {
        int i = 0;
        for (TrafficProfile trafficProfile : list) {
            i += trafficProfile.e;
        }
        return i;
    }

    public static List<TrafficProfile> a(List<TrafficProfile> list, int i) {
        if (list.size() <= i) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (TrafficProfile next : list) {
            if (next.e == 0) {
                arrayList2.add(next);
            } else {
                arrayList.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList(arrayList2);
        if (arrayList.isEmpty()) {
            return arrayList3;
        }
        Random random = new Random();
        int a = a(arrayList);
        for (int i2 = 0; i2 < i - arrayList2.size(); i2++) {
            int nextInt = random.nextInt(a);
            Iterator it = arrayList.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TrafficProfile trafficProfile = (TrafficProfile) it.next();
                i3 += trafficProfile.e;
                if (nextInt < i3) {
                    arrayList3.add(trafficProfile);
                    it.remove();
                    a -= trafficProfile.e;
                    break;
                }
            }
        }
        return arrayList3;
    }
}
