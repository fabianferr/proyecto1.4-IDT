package com.m2catalyst.m2sdk;

import android.content.Context;
import androidx.room.Room;
import com.m2catalyst.m2sdk.database.SDKDatabase;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: DataModules.kt */
public final class b1 extends Lambda implements Function2<Scope, ParametersHolder, SDKDatabase> {
    public final /* synthetic */ k1 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b1(k1 k1Var) {
        super(2);
        this.a = k1Var;
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        SDKDatabase build = Room.databaseBuilder((Context) scope.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), SDKDatabase.class, "sdk-db").addMigrations(this.a).build();
        Intrinsics.checkNotNullExpressionValue(build, "databaseBuilder(\n       …RATION_DUMMY_1_2).build()");
        return build;
    }
}
