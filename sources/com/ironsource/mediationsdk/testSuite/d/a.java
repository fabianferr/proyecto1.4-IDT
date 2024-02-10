package com.ironsource.mediationsdk.testSuite.d;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u00020\u00042\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0016\u0010\u000e\u001a\u00020\u00042\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bJ\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ironsource/mediationsdk/testSuite/utils/TestSuiteUtils;", "", "()V", "CONST_COMMA", "", "CONST_END_OF_ARRAY", "CONST_START_OF_ARRAY", "createArgsList", "", "items", "", "([Ljava/lang/Object;)Ljava/util/List;", "stringifyList", "list", "stringifyMethodArgs", "methodArgs", "stringifyObject", "elem", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {
    public static final a a = new a();

    private a() {
    }

    private static String a(Object obj) {
        if (!(obj instanceof String)) {
            return String.valueOf(obj);
        }
        return "'" + obj + '\'';
    }

    public static String a(List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "methodArgs");
        String str = new String();
        for (Object next : list) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(next instanceof List ? b((List) next) : a(next));
            str = sb.toString() + AbstractJsonLexerKt.COMMA;
        }
        return StringsKt.removeSuffix(str, (CharSequence) ",");
    }

    public static List<Object> a(Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, FirebaseAnalytics.Param.ITEMS);
        return CollectionsKt.listOf(Arrays.copyOf(objArr, objArr.length));
    }

    private static String b(List<?> list) {
        String str = "[";
        for (Object a2 : list) {
            str = str + a(a2) + AbstractJsonLexerKt.COMMA;
        }
        return StringsKt.removeSuffix(str, (CharSequence) ",") + AbstractJsonLexerKt.END_LIST;
    }
}
