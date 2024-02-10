package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.configuration.M2Configuration;
import com.m2catalyst.m2sdk.r2;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: M2RemoteConfigManager.kt */
public final class y2 {
    public final r2 a = r2.a.a();

    /* compiled from: M2RemoteConfigManager.kt */
    public static final class a {
        public static x2 a(r2 r2Var) {
            r2 r2Var2 = r2Var;
            Intrinsics.checkNotNullParameter(r2Var2, "internalConfig");
            M2Configuration m2Configuration = r2Var2.g;
            if (m2Configuration == null) {
                m2Configuration = new M2Configuration();
            }
            String packageName = m2Configuration.getPackageName();
            Set<String> set = s1.a;
            Intrinsics.checkNotNullParameter(packageName, "<this>");
            int i = 10;
            if (s1.a.contains(packageName)) {
                boolean z = !m2Configuration.isDebug();
                q2 q2Var = new q2(Integer.valueOf(z ? 720 : 60), Integer.valueOf(z ? 180 : 10));
                n2 n2Var = new n2(a(true, true, true), a(true, true, true), a(true, true, true), a(true, true, true), a(true, true, true), a(true, true, true), a(true, true, true), a(true, true, true), a(true, true, true));
                Boolean bool = Boolean.FALSE;
                Boolean bool2 = Boolean.TRUE;
                f6 f6Var = new f6(2, 7, 45, 0, 0, 0, 50, 50, 350, 512, 250, 350, 512, 1024, bool, bool2, bool2);
                h2 h2Var = new h2(3, 5, CollectionsKt.mutableListOf("gps", "fused", "network"), bool2, 50, 3);
                f3 f3Var = new f3(6, 5, 1, 3);
                if (z) {
                    i = 180;
                }
                return new x2(q2Var, n2Var, f6Var, h2Var, f3Var, new p2(Integer.valueOf(i), bool2, 36500, bool2, bool2, bool, 21));
            }
            boolean z2 = !m2Configuration.isDebug();
            q2 q2Var2 = new q2(Integer.valueOf(z2 ? 720 : 60), Integer.valueOf(z2 ? 180 : 10));
            n2 n2Var2 = new n2(a(false, false, false), a(false, false, false), a(false, false, false), a(false, false, false), a(false, false, false), a(false, false, false), a(false, false, false), a(false, false, false), a(false, false, false));
            Boolean bool3 = Boolean.FALSE;
            f6 f6Var2 = new f6(2, 7, 45, 0, 0, 0, 50, 50, 350, 512, 250, 350, 512, 1024, bool3, bool3, bool3);
            List mutableListOf = CollectionsKt.mutableListOf("gps", "network", "fused");
            Boolean bool4 = Boolean.TRUE;
            h2 h2Var2 = new h2(3, 5, mutableListOf, bool4, 50, 3);
            f3 f3Var2 = new f3(6, 5, 1, 3);
            if (z2) {
                i = 180;
            }
            return new x2(q2Var2, n2Var2, f6Var2, h2Var2, f3Var2, new p2(Integer.valueOf(i), bool4, 36500, bool4, bool4, bool3, 21));
        }

        public static l2 a(boolean z, boolean z2, boolean z3) {
            return new l2(Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
        }
    }
}
