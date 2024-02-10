package com.wortise.ads;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Patterns;
import com.wortise.ads.data.DataManager;
import com.wortise.ads.user.UserGender;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078CX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/wortise/ads/u6;", "Landroid/content/ContextWrapper;", "", "", "a", "()Ljava/util/List;", "accountEmails", "", "Landroid/accounts/Account;", "b", "()[Landroid/accounts/Account;", "accounts", "", "c", "()Ljava/lang/Integer;", "age", "d", "emails", "Lcom/wortise/ads/user/UserGender;", "e", "()Lcom/wortise/ads/user/UserGender;", "gender", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: UserInfo.kt */
public final class u6 extends ContextWrapper {
    public static final a Companion = new a((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/wortise/ads/u6$a;", "", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: UserInfo.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u6(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final List<String> a() {
        ArrayList arrayList;
        Account[] b = b();
        if (b == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (Account account : b) {
                String str = account.name;
                if (str != null) {
                    arrayList2.add(str);
                }
            }
            arrayList = new ArrayList();
            for (Object next : arrayList2) {
                if (Patterns.EMAIL_ADDRESS.matcher((String) next).matches()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private final Account[] b() {
        if (b2.a((Context) this, "android.permission.GET_ACCOUNTS")) {
            return AccountManager.get(this).getAccounts();
        }
        return null;
    }

    public final Integer c() {
        return DataManager.getAge(this);
    }

    public final List<String> d() {
        List<T> mutableList = CollectionsKt.toMutableList(DataManager.getEmails(this));
        mutableList.addAll(a());
        return CollectionsKt.distinct(mutableList);
    }

    public final UserGender e() {
        return DataManager.getGender(this);
    }
}
