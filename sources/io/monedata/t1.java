package io.monedata;

import android.content.SharedPreferences;
import io.monedata.consent.ConsentManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\n"}, d2 = {"Lio/monedata/t1;", "Lio/monedata/m1;", "Landroid/content/SharedPreferences;", "sp", "", "key", "", "onSharedPreferenceChanged", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class t1 extends m1 {
    public static final t1 c = new t1();
    private static final List<String> d = CollectionsKt.listOf("SFBXTCF_ExtraVendorConsents", "appconsent_hello_reply");

    private t1() {
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sp");
        if (CollectionsKt.contains(d, str)) {
            s1.a.a();
            ConsentManager.INSTANCE.invalidate$core_productionRelease(a());
        }
    }
}
