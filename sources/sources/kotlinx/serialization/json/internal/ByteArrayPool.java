package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/serialization/json/internal/ByteArrayPool;", "", "()V", "MAX_CHARS_IN_POOL", "", "arrays", "Lkotlin/collections/ArrayDeque;", "", "charsTotal", "release", "", "array", "take", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ByteArrayPool.kt */
public final class ByteArrayPool {
    public static final ByteArrayPool INSTANCE = new ByteArrayPool();
    private static final int MAX_CHARS_IN_POOL;
    private static final ArrayDeque<byte[]> arrays = new ArrayDeque<>();
    private static int charsTotal;

    private ByteArrayPool() {
    }

    static {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            Intrinsics.checkNotNullExpressionValue(property, "getProperty(\"kotlinx.ser…lization.json.pool.size\")");
            obj = Result.m2344constructorimpl(StringsKt.toIntOrNull(property));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2350isFailureimpl(obj)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        MAX_CHARS_IN_POOL = num != null ? num.intValue() : 2097152;
    }

    public final byte[] take() {
        byte[] removeLastOrNull;
        synchronized (this) {
            removeLastOrNull = arrays.removeLastOrNull();
            if (removeLastOrNull != null) {
                charsTotal -= removeLastOrNull.length;
            } else {
                removeLastOrNull = null;
            }
        }
        return removeLastOrNull == null ? new byte[512] : removeLastOrNull;
    }

    public final void release(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "array");
        synchronized (this) {
            int i = charsTotal;
            if (bArr.length + i < MAX_CHARS_IN_POOL) {
                charsTotal = i + bArr.length;
                arrays.addLast(bArr);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
