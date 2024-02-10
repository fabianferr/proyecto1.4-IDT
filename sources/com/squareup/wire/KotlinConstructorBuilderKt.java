package com.squareup.wire;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, d2 = {"isMap", "", "Lcom/squareup/wire/WireField;", "(Lcom/squareup/wire/WireField;)Z", "wire-runtime"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: KotlinConstructorBuilder.kt */
public final class KotlinConstructorBuilderKt {
    /* access modifiers changed from: private */
    public static final boolean isMap(WireField wireField) {
        return wireField.keyAdapter().length() > 0;
    }
}
