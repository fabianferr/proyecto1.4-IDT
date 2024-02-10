package com.squareup.wire;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/squareup/wire/Syntax;", "", "string", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "PROTO_2", "PROTO_3", "Companion", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Syntax.kt */
public enum Syntax {
    PROTO_2("proto2"),
    PROTO_3("proto3");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public final String string;

    private Syntax(String str) {
        this.string = str;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    public String toString() {
        return this.string;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/squareup/wire/Syntax$Companion;", "", "()V", "get", "Lcom/squareup/wire/Syntax;", "string", "", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Syntax.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Syntax get(String str) {
            Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
            Syntax[] values = Syntax.values();
            int length = values.length;
            int i = 0;
            while (i < length) {
                Syntax syntax = values[i];
                i++;
                if (Intrinsics.areEqual((Object) syntax.string, (Object) str)) {
                    return syntax;
                }
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected syntax: ", str));
        }
    }
}
