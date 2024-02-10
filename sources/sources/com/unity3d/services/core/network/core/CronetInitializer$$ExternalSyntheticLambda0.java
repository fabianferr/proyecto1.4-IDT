package com.unity3d.services.core.network.core;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CronetInitializer$$ExternalSyntheticLambda0 implements OnCompleteListener {
    public final /* synthetic */ CronetInitializer f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ CronetInitializer$$ExternalSyntheticLambda0(CronetInitializer cronetInitializer, long j) {
        this.f$0 = cronetInitializer;
        this.f$1 = j;
    }

    public final void onComplete(Task task) {
        CronetInitializer.create$lambda$0(this.f$0, this.f$1, task);
    }
}
