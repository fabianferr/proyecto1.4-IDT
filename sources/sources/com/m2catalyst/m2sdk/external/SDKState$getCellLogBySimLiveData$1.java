package com.m2catalyst.m2sdk.external;

import androidx.lifecycle.MutableLiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SDKState.kt */
public /* synthetic */ class SDKState$getCellLogBySimLiveData$1 extends FunctionReferenceImpl implements Function1<Integer, MutableLiveData<List<? extends String>>> {
    public SDKState$getCellLogBySimLiveData$1(Object obj) {
        super(1, obj, SDKState.class, "getCellLogBySimLiveData", "getCellLogBySimLiveData(I)Landroidx/lifecycle/MutableLiveData;", 0);
    }

    public final MutableLiveData<List<String>> invoke(int i) {
        return ((SDKState) this.receiver).getCellLogBySimLiveData(i);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
