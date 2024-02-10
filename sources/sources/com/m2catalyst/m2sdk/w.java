package com.m2catalyst.m2sdk;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.m2catalyst.m2sdk.business.models.SubInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

/* compiled from: CollectionListenersFactory.kt */
public final class w implements KoinComponent {
    public final Lazy a = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new a(this));
    public final Lazy b = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new b(this));

    /* compiled from: KoinComponent.kt */
    public static final class a extends Lambda implements Function0<q3> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.q3, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.q3, java.lang.Object] */
        public final q3 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(q3.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(q3.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class b extends Lambda implements Function0<Context> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [android.content.Context, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [android.content.Context, java.lang.Object] */
        public final Context invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    public final SparseArray<v2> a() {
        Object obj;
        int i;
        SparseArray<v2> sparseArray = new SparseArray<>();
        ArrayList b2 = m6.b(c());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(b2, 10));
        Iterator it = b2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((SubInfo) it.next()).getId()));
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            int intValue = ((Number) it2.next()).intValue();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 31) {
                Context c = c();
                Intrinsics.checkNotNullParameter(c, "context");
                try {
                    i = c.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
                } catch (RuntimeException unused) {
                    i = v.a(c.getPackageManager(), "context.packageManager", c, "android.permission.READ_PHONE_STATE");
                }
                if (i == 0) {
                    obj = new p6((q3) this.a.getValue(), intValue, c());
                    sparseArray.put(intValue, obj);
                }
            }
            if (i2 >= 31) {
                obj = new q6((q3) this.a.getValue(), intValue, c());
            } else if (i2 == 30) {
                obj = new q4((q3) this.a.getValue(), intValue, c());
            } else {
                obj = new p4((q3) this.a.getValue(), intValue, c());
            }
            sparseArray.put(intValue, obj);
        }
        return sparseArray;
    }

    public final SparseArray<TelephonyManager> b() {
        SparseArray<TelephonyManager> sparseArray = new SparseArray<>();
        ArrayList b2 = m6.b(c());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(b2, 10));
        Iterator it = b2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((SubInfo) it.next()).getId()));
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            int intValue = ((Number) it2.next()).intValue();
            Object systemService = c().getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            sparseArray.put(intValue, ((TelephonyManager) systemService).createForSubscriptionId(intValue));
        }
        return sparseArray;
    }

    public final Context c() {
        return (Context) this.b.getValue();
    }

    public final Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }
}
