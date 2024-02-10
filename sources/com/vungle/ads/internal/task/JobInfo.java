package com.vungle.ads.internal.task;

import android.os.Bundle;
import android.util.Log;
import com.facebook.bolts.AppLinks;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 *2\u00020\u0001:\u0004*+,-B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u0004\u0018\u00010\u0000J\u0006\u0010\"\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010&\u001a\u00020\u00002\b\b\u0001\u0010\u0017\u001a\u00020\u0011J\u0016\u0010'\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0011J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dR\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0011@BX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00118\u0006@BX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u0011X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0014R\u000e\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u001d@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006."}, d2 = {"Lcom/vungle/ads/internal/task/JobInfo;", "", "jobTag", "", "(Ljava/lang/String;)V", "<set-?>", "", "delay", "getDelay", "()J", "Landroid/os/Bundle;", "extras", "getExtras", "()Landroid/os/Bundle;", "getJobTag", "()Ljava/lang/String;", "nextRescheduleTimeout", "", "priority", "getPriority$annotations", "()V", "getPriority", "()I", "requiredNetworkType", "getRequiredNetworkType$annotations", "getRequiredNetworkType", "reschedulePolicy", "getReschedulePolicy$annotations", "rescheduleTimeout", "", "updateCurrent", "getUpdateCurrent", "()Z", "copy", "makeNextRescedule", "setDelay", "setExtras", "setPriority", "setRequiredNetworkType", "setReschedulePolicy", "delayCriteria", "setUpdateCurrent", "Companion", "NetworkType", "Priority", "ReschedulePolicy", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: JobInfo.kt */
public final class JobInfo implements Cloneable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "JobInfo";
    private long delay;
    private Bundle extras = new Bundle();
    private final String jobTag;
    private long nextRescheduleTimeout;
    private int priority = 2;
    private int requiredNetworkType;
    private int reschedulePolicy = 1;
    private long rescheduleTimeout;
    private boolean updateCurrent;

    public static /* synthetic */ void getPriority$annotations() {
    }

    @NetworkType
    public static /* synthetic */ void getRequiredNetworkType$annotations() {
    }

    private static /* synthetic */ void getReschedulePolicy$annotations() {
    }

    public JobInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "jobTag");
        this.jobTag = str;
    }

    public Object clone() {
        return super.clone();
    }

    public final String getJobTag() {
        return this.jobTag;
    }

    public final boolean getUpdateCurrent() {
        return this.updateCurrent;
    }

    public final long getDelay() {
        return this.delay;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    public final JobInfo setUpdateCurrent(boolean z) {
        this.updateCurrent = z;
        return this;
    }

    public final JobInfo setExtras(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, AppLinks.KEY_NAME_EXTRAS);
        this.extras = bundle;
        return this;
    }

    public final JobInfo setDelay(long j) {
        this.delay = j;
        return this;
    }

    public final JobInfo setReschedulePolicy(long j, int i) {
        this.rescheduleTimeout = j;
        this.reschedulePolicy = i;
        return this;
    }

    public final JobInfo setPriority(int i) {
        this.priority = i;
        return this;
    }

    public final long makeNextRescedule() {
        long j = this.rescheduleTimeout;
        if (j == 0) {
            return 0;
        }
        long j2 = this.nextRescheduleTimeout;
        if (j2 == 0) {
            this.nextRescheduleTimeout = j;
        } else if (this.reschedulePolicy == 1) {
            this.nextRescheduleTimeout = j2 * ((long) 2);
        }
        return this.nextRescheduleTimeout;
    }

    public final JobInfo copy() {
        try {
            Object clone = super.clone();
            Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type com.vungle.ads.internal.task.JobInfo");
            return (JobInfo) clone;
        } catch (CloneNotSupportedException e) {
            Log.e(TAG, Log.getStackTraceString(e));
            return null;
        }
    }

    public final JobInfo setRequiredNetworkType(@NetworkType int i) {
        this.requiredNetworkType = i;
        return this;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/vungle/ads/internal/task/JobInfo$ReschedulePolicy;", "", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    /* compiled from: JobInfo.kt */
    public @interface ReschedulePolicy {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int EXPONENTIAL = 1;
        public static final int LINEAR = 0;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/task/JobInfo$ReschedulePolicy$Companion;", "", "()V", "EXPONENTIAL", "", "LINEAR", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: JobInfo.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int EXPONENTIAL = 1;
            public static final int LINEAR = 0;

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/vungle/ads/internal/task/JobInfo$Priority;", "", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    /* compiled from: JobInfo.kt */
    public @interface Priority {
        public static final int CRITICAL = 5;
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int HIGH = 3;
        public static final int HIGHEST = 4;
        public static final int LOW = 1;
        public static final int LOWEST = 0;
        public static final int NORMAL = 2;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/vungle/ads/internal/task/JobInfo$Priority$Companion;", "", "()V", "CRITICAL", "", "HIGH", "HIGHEST", "LOW", "LOWEST", "NORMAL", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: JobInfo.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int CRITICAL = 5;
            public static final int HIGH = 3;
            public static final int HIGHEST = 4;
            public static final int LOW = 1;
            public static final int LOWEST = 0;
            public static final int NORMAL = 2;

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/vungle/ads/internal/task/JobInfo$NetworkType;", "", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
    /* compiled from: JobInfo.kt */
    public @interface NetworkType {
        public static final int ANY = 0;
        public static final int CONNECTED = 1;
        public static final Companion Companion = Companion.$$INSTANCE;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/task/JobInfo$NetworkType$Companion;", "", "()V", "ANY", "", "CONNECTED", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: JobInfo.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int ANY = 0;
            public static final int CONNECTED = 1;

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/task/JobInfo$Companion;", "", "()V", "TAG", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: JobInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
