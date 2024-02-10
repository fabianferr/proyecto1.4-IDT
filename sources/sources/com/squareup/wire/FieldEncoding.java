package com.squareup.wire;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/squareup/wire/FieldEncoding;", "", "value", "", "(Ljava/lang/String;II)V", "getValue$wire_runtime", "()I", "rawProtoAdapter", "Lcom/squareup/wire/ProtoAdapter;", "VARINT", "FIXED64", "LENGTH_DELIMITED", "FIXED32", "Companion", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldEncoding.kt */
public enum FieldEncoding {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);
    
    public static final Companion Companion = null;
    private final int value;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FieldEncoding.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[FieldEncoding.values().length];
            iArr[FieldEncoding.VARINT.ordinal()] = 1;
            iArr[FieldEncoding.FIXED32.ordinal()] = 2;
            iArr[FieldEncoding.FIXED64.ordinal()] = 3;
            iArr[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final FieldEncoding get$wire_runtime(int i) throws IOException {
        return Companion.get$wire_runtime(i);
    }

    private FieldEncoding(int i) {
        this.value = i;
    }

    public final int getValue$wire_runtime() {
        return this.value;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    public final ProtoAdapter<?> rawProtoAdapter() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return ProtoAdapter.UINT64;
        }
        if (i == 2) {
            return ProtoAdapter.FIXED32;
        }
        if (i == 3) {
            return ProtoAdapter.FIXED64;
        }
        if (i == 4) {
            return ProtoAdapter.BYTES;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/squareup/wire/FieldEncoding$Companion;", "", "()V", "get", "Lcom/squareup/wire/FieldEncoding;", "value", "", "get$wire_runtime", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FieldEncoding.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FieldEncoding get$wire_runtime(int i) throws IOException {
            if (i == 0) {
                return FieldEncoding.VARINT;
            }
            if (i == 1) {
                return FieldEncoding.FIXED64;
            }
            if (i == 2) {
                return FieldEncoding.LENGTH_DELIMITED;
            }
            if (i == 5) {
                return FieldEncoding.FIXED32;
            }
            throw new ProtocolException(Intrinsics.stringPlus("Unexpected FieldEncoding: ", Integer.valueOf(i)));
        }
    }
}
