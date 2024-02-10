package com.m2catalyst.m2sdk;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataModules.kt */
public final class k1 extends Migration {
    public k1() {
        super(1, 68);
    }

    public final void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
    }
}
