package androidx.room;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.room.RoomDatabaseKt", f = "RoomDatabase.kt", i = {0, 0}, l = {99}, m = "createTransactionContext", n = {"$this$createTransactionContext", "controlJob"}, s = {"L$0", "L$1"})
/* compiled from: RoomDatabase.kt */
final class RoomDatabaseKt$createTransactionContext$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    RoomDatabaseKt$createTransactionContext$1(Continuation<? super RoomDatabaseKt$createTransactionContext$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RoomDatabaseKt.createTransactionContext((RoomDatabase) null, this);
    }
}
