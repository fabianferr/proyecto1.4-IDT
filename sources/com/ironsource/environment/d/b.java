package com.ironsource.environment.d;

import com.ironsource.environment.c.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ironsource/environment/init/InitProvider;", "", "()V", "mGlobalDataReader", "Lcom/ironsource/environment/globaldata/GlobalDataReader;", "mInitKeyList", "Ljava/util/ArrayList;", "", "getInitData", "Lorg/json/JSONObject;", "environment_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {
    private final ArrayList<String> a = new ArrayList<>(new a().a);
    private final c b = new c();

    public final JSONObject a() {
        JSONObject a2 = this.b.a((List<String>) this.a);
        Intrinsics.checkNotNullExpressionValue(a2, "mGlobalDataReader.getDataByKeys(mInitKeyList)");
        return a2;
    }
}
