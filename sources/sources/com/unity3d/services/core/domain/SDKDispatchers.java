package com.unity3d.services.core.domain;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/unity3d/services/core/domain/SDKDispatchers;", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "()V", "default", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault", "()Lkotlinx/coroutines/CoroutineDispatcher;", "io", "getIo", "main", "getMain", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SDKDispatchers.kt */
public final class SDKDispatchers implements ISDKDispatchers {

    /* renamed from: default  reason: not valid java name */
    private final CoroutineDispatcher f2default = Dispatchers.getDefault();

    /* renamed from: io  reason: collision with root package name */
    private final CoroutineDispatcher f36io = Dispatchers.getIO();
    private final CoroutineDispatcher main = Dispatchers.getMain();

    public CoroutineDispatcher getIo() {
        return this.f36io;
    }

    public CoroutineDispatcher getDefault() {
        return this.f2default;
    }

    public CoroutineDispatcher getMain() {
        return this.main;
    }
}
