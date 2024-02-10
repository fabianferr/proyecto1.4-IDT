package com.vungle.ads.internal.task;

import android.content.Context;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vungle.ads.internal.util.PathProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/vungle/ads/internal/task/VungleJobCreator;", "Lcom/vungle/ads/internal/task/JobCreator;", "context", "Landroid/content/Context;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "(Landroid/content/Context;Lcom/vungle/ads/internal/util/PathProvider;)V", "getContext", "()Landroid/content/Context;", "getPathProvider", "()Lcom/vungle/ads/internal/util/PathProvider;", "create", "Lcom/vungle/ads/internal/task/Job;", "tag", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleJobCreator.kt */
public final class VungleJobCreator implements JobCreator {
    private final Context context;
    private final PathProvider pathProvider;

    public VungleJobCreator(Context context2, PathProvider pathProvider2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(pathProvider2, "pathProvider");
        this.context = context2;
        this.pathProvider = pathProvider2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final PathProvider getPathProvider() {
        return this.pathProvider;
    }

    public Job create(String str) throws UnknownTagException {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        if (str.length() == 0) {
            throw new UnknownTagException("Job tag is null");
        } else if (Intrinsics.areEqual((Object) str, (Object) CleanupJob.TAG)) {
            return new CleanupJob(this.context, this.pathProvider);
        } else {
            if (Intrinsics.areEqual((Object) str, (Object) ResendTpatJob.TAG)) {
                return new ResendTpatJob(this.context, this.pathProvider);
            }
            throw new UnknownTagException("Unknown Job Type " + str);
        }
    }
}
