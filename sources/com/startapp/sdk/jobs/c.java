package com.startapp.sdk.jobs;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import com.startapp.a0;
import com.startapp.l7;
import com.startapp.sdk.jobs.JobRequest;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Sta */
public class c implements l7 {
    public final JobScheduler a;
    public final ComponentName b;
    public final boolean c;

    public c(Context context, Class<? extends JobService> cls) throws IllegalStateException {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            this.a = jobScheduler;
            this.b = new ComponentName(context, cls);
            this.c = a0.a(context, "android.permission.RECEIVE_BOOT_COMPLETED");
            return;
        }
        throw new IllegalStateException();
    }

    public final JobInfo.Builder a(JobRequest jobRequest, Integer num) {
        int i;
        int i2;
        if (num != null) {
            i = num.intValue();
        } else {
            i = JobRequest.a(jobRequest.a);
        }
        JobInfo.Builder builder = new JobInfo.Builder(i, this.b);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("extraKeyUuid", jobRequest.b.toString());
        persistableBundle.putStringArray("extraKeyTags", jobRequest.a);
        if (num != null) {
            persistableBundle.putInt("extraKeyDuplicate", 1);
        }
        builder.setExtras(persistableBundle);
        JobRequest.Network network = jobRequest.c;
        if (network != null) {
            if (network == JobRequest.Network.UNMETERED) {
                i2 = 2;
            } else {
                i2 = network == JobRequest.Network.ANY ? 1 : 0;
            }
            builder.setRequiredNetworkType(i2);
        }
        if (this.c) {
            builder.setPersisted(true);
        }
        return builder;
    }

    public final boolean a(JobInfo jobInfo) {
        try {
            return this.a.schedule(jobInfo) == 1;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public final List<JobInfo> a() {
        List<JobInfo> list;
        try {
            list = this.a.getAllPendingJobs();
        } catch (Throwable unused) {
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (JobInfo next : list) {
            if (this.b.equals(next.getService())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public boolean a(JobRequest jobRequest, long j) {
        JobInfo.Builder a2 = a(jobRequest, (Integer) null);
        if (Build.VERSION.SDK_INT >= 24) {
            return a(a2.setPeriodic(j, JobInfo.getMinFlexMillis()).build());
        }
        List<JobInfo> a3 = a();
        if (a3 == null) {
            return false;
        }
        for (JobInfo next : a3) {
            if (next.getId() == JobRequest.a(jobRequest.a) && next.getIntervalMillis() == j) {
                return false;
            }
        }
        return a(a2.setPeriodic(j).build());
    }

    public boolean a(JobRequest jobRequest, Long l, Long l2) {
        ArrayList arrayList = null;
        JobInfo.Builder a2 = a(jobRequest, (Integer) null);
        long j = 0;
        if (l != null || Build.VERSION.SDK_INT <= 28) {
            a2.setMinimumLatency(l != null ? l.longValue() : 0);
        }
        JobInfo build = a2.build();
        boolean a3 = a(build);
        if (Build.VERSION.SDK_INT == 23) {
            String uuid = jobRequest.b.toString();
            List<JobInfo> a4 = a();
            if (a4 != null) {
                arrayList = new ArrayList(2);
                for (JobInfo next : a4) {
                    PersistableBundle extras = next.getExtras();
                    try {
                        if (extras.containsKey("extraKeyUuid") && uuid.equals(extras.getString("extraKeyUuid"))) {
                            arrayList.add(Integer.valueOf(next.getId()));
                        }
                    } catch (NullPointerException unused) {
                    }
                }
            }
            if (arrayList != null) {
                int id = build.getId();
                int indexOf = arrayList.indexOf(Integer.valueOf(id));
                if (indexOf >= 0) {
                    arrayList.remove(indexOf);
                }
                JobInfo.Builder a5 = a(jobRequest, Integer.valueOf(!arrayList.isEmpty() ? ((Integer) arrayList.get(0)).intValue() : id < Integer.MAX_VALUE ? id + 1 : id - 1));
                if (l != null || Build.VERSION.SDK_INT <= 28) {
                    if (l != null) {
                        j = l.longValue();
                    }
                    a5.setMinimumLatency(j);
                }
                a(a5.build());
            }
        }
        return a3;
    }

    public boolean a(int i) {
        List<JobInfo> a2 = a();
        if (a2 == null) {
            return false;
        }
        try {
            for (JobInfo id : a2) {
                if (id.getId() == i) {
                    this.a.cancel(i);
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
