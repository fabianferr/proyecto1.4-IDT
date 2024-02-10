package com.appnext.core.ra.services;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.appnext.core.ra.a.c;
import com.appnext.core.ra.services.a;
import com.facebook.internal.NativeProtocol;

public class RecentAppsWorkManagerService extends Worker {
    public RecentAppsWorkManagerService(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public ListenableWorker.Result doWork() {
        try {
            Data inputData = getInputData();
            if (inputData == null) {
                return ListenableWorker.Result.success();
            }
            Bundle a = a(inputData);
            int i = inputData.getInt(NativeProtocol.WEB_DIALOG_ACTION, -1);
            if (i >= 0) {
                if (i < a.C0026a.values().length) {
                    c.a(getApplicationContext(), a.C0026a.values()[i], a).ap();
                    return ListenableWorker.Result.success();
                }
            }
            return ListenableWorker.Result.success();
        } catch (Throwable th) {
            com.appnext.base.a.a("RecentAppsWorkManagerService$doWork", th);
        }
    }

    private static Bundle a(Data data) {
        try {
            int i = data.getInt(NativeProtocol.WEB_DIALOG_ACTION, -1);
            String string = data.getString("more_data");
            Bundle bundle = new Bundle();
            bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, i);
            if (!TextUtils.isEmpty(string)) {
                bundle.putString("more_data", string);
            }
            return bundle;
        } catch (Throwable th) {
            com.appnext.base.a.a("RecentAppsWorkManagerService$createBundleFromData", th);
            return null;
        }
    }
}
