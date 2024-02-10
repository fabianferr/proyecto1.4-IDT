package com.wortise.ads.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Patterns;
import com.wortise.ads.r5;
import com.wortise.ads.user.UserGender;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0017\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\nH\u0007J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\u0010\u0015J \u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018H\u0007J\u001a\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/wortise/ads/data/DataManager;", "", "()V", "KEY_AGE", "", "KEY_EMAILS", "KEY_GENDER", "addEmail", "", "context", "Landroid/content/Context;", "email", "getAge", "", "(Landroid/content/Context;)Ljava/lang/Integer;", "getEmails", "", "getGender", "Lcom/wortise/ads/user/UserGender;", "setAge", "age", "(Landroid/content/Context;Ljava/lang/Integer;)V", "setEmails", "list", "", "setGender", "gender", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: DataManager.kt */
public final class DataManager {
    public static final DataManager INSTANCE = new DataManager();
    private static final String KEY_AGE = "userAge";
    private static final String KEY_EMAILS = "userEmails";
    private static final String KEY_GENDER = "userGender";

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Landroid/content/SharedPreferences$Editor;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: DataManager.kt */
    static final class a extends Lambda implements Function1<SharedPreferences.Editor, Unit> {
        final /* synthetic */ Integer a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Integer num) {
            super(1);
            this.a = num;
        }

        public final void a(SharedPreferences.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "$this$edit");
            Integer num = this.a;
            int i = 0;
            if (num != null) {
                if (!(num.intValue() > 0)) {
                    num = null;
                }
                if (num != null) {
                    i = num.intValue();
                }
            }
            editor.putInt(DataManager.KEY_AGE, i);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SharedPreferences.Editor) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Landroid/content/SharedPreferences$Editor;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: DataManager.kt */
    static final class b extends Lambda implements Function1<SharedPreferences.Editor, Unit> {
        final /* synthetic */ Set<String> a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Set<String> set) {
            super(1);
            this.a = set;
        }

        public final void a(SharedPreferences.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "$this$edit");
            editor.putStringSet(DataManager.KEY_EMAILS, this.a);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SharedPreferences.Editor) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Landroid/content/SharedPreferences$Editor;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: DataManager.kt */
    static final class c extends Lambda implements Function1<SharedPreferences.Editor, Unit> {
        final /* synthetic */ UserGender a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(UserGender userGender) {
            super(1);
            this.a = userGender;
        }

        public final void a(SharedPreferences.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "$this$edit");
            UserGender userGender = this.a;
            editor.putString(DataManager.KEY_GENDER, userGender == null ? null : userGender.name());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SharedPreferences.Editor) obj);
            return Unit.INSTANCE;
        }
    }

    private DataManager() {
    }

    @JvmStatic
    public static final void addEmail(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "email");
        List<T> mutableList = CollectionsKt.toMutableList(getEmails(context));
        mutableList.add(str);
        setEmails(context, mutableList);
    }

    @JvmStatic
    public static final Integer getAge(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Integer valueOf = Integer.valueOf(r5.a.a(context).getInt(KEY_AGE, -1));
        if (valueOf.intValue() > 0) {
            return valueOf;
        }
        return null;
    }

    @JvmStatic
    public static final List<String> getEmails(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        List<String> list = null;
        Set<String> stringSet = r5.a.a(context).getStringSet(KEY_EMAILS, (Set) null);
        if (stringSet != null) {
            ArrayList arrayList = new ArrayList();
            for (T next : stringSet) {
                String str = (String) next;
                Intrinsics.checkNotNullExpressionValue(str, "it");
                if (Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
                    arrayList.add(next);
                }
            }
            list = CollectionsKt.distinct(arrayList);
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0020  */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.wortise.ads.user.UserGender getGender(android.content.Context r2) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            com.wortise.ads.r5 r0 = com.wortise.ads.r5.a
            android.content.SharedPreferences r2 = r0.a(r2)
            java.lang.String r0 = "userGender"
            r1 = 0
            java.lang.String r2 = r2.getString(r0, r1)     // Catch:{ all -> 0x001b }
            if (r2 != 0) goto L_0x0016
            goto L_0x001c
        L_0x0016:
            com.wortise.ads.user.UserGender r2 = com.wortise.ads.user.UserGender.valueOf(r2)     // Catch:{ all -> 0x001b }
            goto L_0x001d
        L_0x001b:
        L_0x001c:
            r2 = r1
        L_0x001d:
            if (r2 != 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r1 = r2
        L_0x0021:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.data.DataManager.getGender(android.content.Context):com.wortise.ads.user.UserGender");
    }

    @JvmStatic
    public static final void setAge(Context context, Integer num) {
        Intrinsics.checkNotNullParameter(context, "context");
        r5.a.a(context, new a(num));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        r4 = kotlin.collections.CollectionsKt.distinct(r4);
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void setEmails(android.content.Context r3, java.util.Collection<java.lang.String> r4) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            if (r4 != 0) goto L_0x0008
            goto L_0x0035
        L_0x0008:
            java.util.Iterator r0 = r4.iterator()
        L_0x000c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0035
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.util.regex.Pattern r2 = android.util.Patterns.EMAIL_ADDRESS
            java.util.regex.Matcher r2 = r2.matcher(r1)
            boolean r2 = r2.matches()
            if (r2 == 0) goto L_0x0025
            goto L_0x000c
        L_0x0025:
            java.lang.String r3 = " is not a valid email address"
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r3)
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r3 = r3.toString()
            r4.<init>(r3)
            throw r4
        L_0x0035:
            if (r4 != 0) goto L_0x0038
            goto L_0x003e
        L_0x0038:
            java.util.List r4 = kotlin.collections.CollectionsKt.distinct(r4)
            if (r4 != 0) goto L_0x0040
        L_0x003e:
            r4 = 0
            goto L_0x0044
        L_0x0040:
            java.util.Set r4 = kotlin.collections.CollectionsKt.toSet(r4)
        L_0x0044:
            com.wortise.ads.r5 r0 = com.wortise.ads.r5.a
            com.wortise.ads.data.DataManager$b r1 = new com.wortise.ads.data.DataManager$b
            r1.<init>(r4)
            r0.a(r3, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.data.DataManager.setEmails(android.content.Context, java.util.Collection):void");
    }

    @JvmStatic
    public static final void setGender(Context context, UserGender userGender) {
        Intrinsics.checkNotNullParameter(context, "context");
        r5.a.a(context, new c(userGender));
    }
}
