package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;
import com.android.tools.r8.annotations.SynthesizedClassV2;

public interface AutoMigrationSpec {

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: androidx.room.migration.AutoMigrationSpec$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onPostMigrate(AutoMigrationSpec _this, SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }

    void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase);
}
