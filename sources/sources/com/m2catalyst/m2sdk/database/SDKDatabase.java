package com.m2catalyst.m2sdk.database;

import androidx.room.RoomDatabase;
import com.m2catalyst.m2sdk.database.daos.BadSignalsDao;
import com.m2catalyst.m2sdk.database.daos.CounterDao;
import com.m2catalyst.m2sdk.database.daos.CrashDao;
import com.m2catalyst.m2sdk.database.daos.LocationDao;
import com.m2catalyst.m2sdk.database.daos.MNSIDao;
import com.m2catalyst.m2sdk.database.daos.NDTDao;
import com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao;
import com.m2catalyst.m2sdk.database.daos.WifiDao;
import com.m2catalyst.m2sdk.g3;
import com.m2catalyst.m2sdk.j3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0015"}, d2 = {"Lcom/m2catalyst/m2sdk/database/SDKDatabase;", "Landroidx/room/RoomDatabase;", "()V", "badSignalsDao", "Lcom/m2catalyst/m2sdk/database/daos/BadSignalsDao;", "clear", "", "counterDao", "Lcom/m2catalyst/m2sdk/database/daos/CounterDao;", "crashDao", "Lcom/m2catalyst/m2sdk/database/daos/CrashDao;", "locationLogDao", "Lcom/m2catalyst/m2sdk/database/daos/LocationDao;", "mobileSignalNetworkDao", "Lcom/m2catalyst/m2sdk/database/daos/MNSIDao;", "networkDiagnosticsDao", "Lcom/m2catalyst/m2sdk/database/daos/NDTDao;", "noNetworkSignalDao", "Lcom/m2catalyst/m2sdk/database/daos/NoSignalMNSIDao;", "wifiConnectivityDao", "Lcom/m2catalyst/m2sdk/database/daos/WifiDao;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SDKDatabase.kt */
public abstract class SDKDatabase extends RoomDatabase {
    public abstract BadSignalsDao badSignalsDao();

    public final void clear() {
        SDKDatabase$clear$1 sDKDatabase$clear$1 = new SDKDatabase$clear$1(this, (Continuation<? super SDKDatabase$clear$1>) null);
        j3.b bVar = j3.a;
        Intrinsics.checkNotNullParameter(sDKDatabase$clear$1, "block");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), j3.a, (CoroutineStart) null, new g3(sDKDatabase$clear$1, (Continuation<? super g3>) null), 2, (Object) null);
    }

    public abstract CounterDao counterDao();

    public abstract CrashDao crashDao();

    public abstract LocationDao locationLogDao();

    public abstract MNSIDao mobileSignalNetworkDao();

    public abstract NDTDao networkDiagnosticsDao();

    public abstract NoSignalMNSIDao noNetworkSignalDao();

    public abstract WifiDao wifiConnectivityDao();
}
