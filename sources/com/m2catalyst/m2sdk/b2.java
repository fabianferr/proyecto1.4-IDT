package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.a4;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage;
import com.m2catalyst.m2sdk.data_transmission.ingestion.ingestion_api_clients.IngestionApis;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

/* compiled from: IngestionVerifyApiKeyClient.kt */
public final class b2 {
    public final a4 a;

    public b2(a4 a4Var) {
        Intrinsics.checkNotNullParameter(a4Var, "networkFactory");
        this.a = a4Var;
    }

    public final Object a(byte[] bArr, Continuation<? super ApiResponseMessage> continuation) {
        Retrofit a2 = this.a.a(a4.b.INGESTION, a4.a.WIRE);
        Intrinsics.checkNotNullParameter(a2, "retrofit");
        Intrinsics.checkNotNullParameter(IngestionApis.class, "apiInterface");
        return ((IngestionApis) a2.create(IngestionApis.class)).verifyApiKey(a2.a(bArr), continuation);
    }
}
