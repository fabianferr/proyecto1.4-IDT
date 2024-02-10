package com.m2catalyst.m2sdk.database;

import com.m2catalyst.m2sdk.a6;
import com.m2catalyst.m2sdk.r2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/m2catalyst/m2sdk/database/V8MigrationHelper;", "", "Lcom/m2catalyst/m2sdk/r2;", "configuration", "", "migrate", "<init>", "()V", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: V8MigrationHelper.kt */
public final class V8MigrationHelper {
    public static final V8MigrationHelper INSTANCE = new V8MigrationHelper();

    private V8MigrationHelper() {
    }

    public final void migrate(r2 r2Var) {
        Intrinsics.checkNotNullParameter(r2Var, "configuration");
        r2Var.a().a(a6.DB_MIGRATION_V8_V9, Boolean.TRUE);
    }
}
