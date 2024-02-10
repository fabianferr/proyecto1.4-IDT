package com.wortise.ads;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¨\u0006\u0003"}, d2 = {"", "", "a", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: ByteArray.kt */
public final class w0 {

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\r\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: ByteArray.kt */
    static final class a extends Lambda implements Function1<Byte, CharSequence> {
        public static final a a = new a();

        a() {
            super(1);
        }

        public final CharSequence a(byte b) {
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            return format;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).byteValue());
        }
    }

    public static final String a(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) a.a, 30, (Object) null);
    }
}
