package com.m2catalyst.m2sdk.business.repositories;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\nR\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/m2catalyst/m2sdk/business/repositories/BaseRepository;", "", "()V", "<set-?>", "", "testing", "getTesting", "()Z", "setTesting", "", "setTesting$m2sdk_release", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BaseRepository.kt */
public abstract class BaseRepository {
    private boolean testing;

    public final boolean getTesting() {
        return this.testing;
    }

    public final void setTesting$m2sdk_release(boolean z) {
        this.testing = z;
    }
}
