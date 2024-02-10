package com.m2catalyst.m2sdk;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import com.m2catalyst.m2sdk.business.models.SubInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionHelper.kt */
public final class m6 {
    public static SubInfo a(Context context) {
        int i;
        int i2;
        SubscriptionInfo activeSubscriptionInfo;
        int slotIndex;
        int defaultSubscriptionId;
        List<SubscriptionInfo> activeSubscriptionInfoList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            i = context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
        } catch (RuntimeException unused) {
            i = v.a(context.getPackageManager(), "context.packageManager", context, "android.permission.READ_PHONE_STATE");
        }
        boolean z = true;
        int i3 = Integer.MAX_VALUE;
        if (i == 0) {
            Object systemService = context.getApplicationContext().getSystemService("telephony_subscription_service");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.SubscriptionManager");
            SubscriptionManager subscriptionManager = (SubscriptionManager) systemService;
            if (!(subscriptionManager == null || (activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList()) == null)) {
                Intrinsics.checkNotNullExpressionValue(activeSubscriptionInfoList, "activeSubscriptionInfoList");
                if (activeSubscriptionInfoList.size() == 1) {
                    return new SubInfo(activeSubscriptionInfoList.get(0).getSubscriptionId(), activeSubscriptionInfoList.get(0).getSimSlotIndex());
                }
                if (activeSubscriptionInfoList.size() == 0) {
                    return new SubInfo(Integer.MAX_VALUE, Integer.MAX_VALUE);
                }
            }
        }
        int defaultDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
        if (defaultDataSubscriptionId == -1) {
            defaultDataSubscriptionId = Integer.MAX_VALUE;
        }
        if (defaultDataSubscriptionId == Integer.MAX_VALUE && (defaultSubscriptionId = SubscriptionManager.getDefaultSubscriptionId()) != -1) {
            defaultDataSubscriptionId = defaultSubscriptionId;
        }
        if (Build.VERSION.SDK_INT >= 29 && (slotIndex = SubscriptionManager.getSlotIndex(defaultDataSubscriptionId)) != -1) {
            return new SubInfo(defaultDataSubscriptionId, slotIndex);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            i2 = context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
        } catch (RuntimeException unused2) {
            i2 = v.a(context.getPackageManager(), "context.packageManager", context, "android.permission.READ_PHONE_STATE");
        }
        if (i2 != 0) {
            z = false;
        }
        if (z) {
            Object systemService2 = context.getApplicationContext().getSystemService("telephony_subscription_service");
            Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.telephony.SubscriptionManager");
            SubscriptionManager subscriptionManager2 = (SubscriptionManager) systemService2;
            if (!(subscriptionManager2 == null || (activeSubscriptionInfo = subscriptionManager2.getActiveSubscriptionInfo(defaultDataSubscriptionId)) == null)) {
                Intrinsics.checkNotNullExpressionValue(activeSubscriptionInfo, "getActiveSubscriptionInfo(subscriberId)");
                i3 = activeSubscriptionInfo.getSimSlotIndex();
            }
        }
        return new SubInfo(defaultDataSubscriptionId, i3);
    }

    public static ArrayList b(Context context) {
        int i;
        List<SubscriptionInfo> list;
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            i = context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
        } catch (RuntimeException unused) {
            i = v.a(context.getPackageManager(), "context.packageManager", context, "android.permission.READ_PHONE_STATE");
        }
        if (i == 0) {
            Object systemService = context.getApplicationContext().getSystemService("telephony_subscription_service");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.SubscriptionManager");
            SubscriptionManager subscriptionManager = (SubscriptionManager) systemService;
            if (subscriptionManager != null) {
                list = subscriptionManager.getActiveSubscriptionInfoList();
            } else {
                list = null;
            }
            if (list != null) {
                for (SubscriptionInfo subscriptionInfo : list) {
                    arrayList.add(new SubInfo(subscriptionInfo.getSubscriptionId(), subscriptionInfo.getSimSlotIndex()));
                }
            }
        }
        if (arrayList.isEmpty()) {
            SubInfo a = a(context);
            if (a.getId() != Integer.MAX_VALUE) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }
}
