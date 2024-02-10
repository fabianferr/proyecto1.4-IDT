package com.vungle.ads.internal.network.converters;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.JsonBuilder;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/serialization/json/JsonBuilder;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: JsonConverter.kt */
final class JsonConverter$Companion$json$1 extends Lambda implements Function1<JsonBuilder, Unit> {
    public static final JsonConverter$Companion$json$1 INSTANCE = new JsonConverter$Companion$json$1();

    JsonConverter$Companion$json$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JsonBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(JsonBuilder jsonBuilder) {
        Intrinsics.checkNotNullParameter(jsonBuilder, "$this$Json");
        jsonBuilder.setIgnoreUnknownKeys(true);
        jsonBuilder.setEncodeDefaults(true);
        jsonBuilder.setExplicitNulls(false);
        jsonBuilder.setAllowStructuredMapKeys(true);
    }
}
