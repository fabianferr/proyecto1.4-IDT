package com.cellrebel.sdk.networking;

import android.os.Build;
import com.cellrebel.sdk.networking.beans.request.AuthRequestModel;
import com.cellrebel.sdk.utils.PreferencesManager;
import com.cellrebel.sdk.utils.SettingsManager;
import com.cellrebel.sdk.utils.ThreadPoolProvider;
import com.cellrebel.sdk.utils.TrackingHelper;
import com.cellrebel.sdk.workers.TrackingManager;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;

public class TokenAuthenticator implements Authenticator {
    int a = 0;

    public Request authenticate(Route route, Response response) {
        int i = this.a;
        String str = null;
        if (i >= 3) {
            return null;
        }
        this.a = i + 1;
        PreferencesManager m = PreferencesManager.m();
        String str2 = Build.MODEL;
        String str3 = Build.MANUFACTURER;
        String str4 = Build.BRAND;
        ThreadPoolProvider.a().a(new TokenAuthenticator$$ExternalSyntheticLambda0(str2, str3, str4));
        AuthRequestModel authRequestModel = new AuthRequestModel();
        authRequestModel.mobileClientId = m.a(TrackingManager.getContext());
        authRequestModel.clientKey = m.f();
        authRequestModel.os = "Android";
        authRequestModel.deviceBrand = str3;
        authRequestModel.deviceModel = str2;
        authRequestModel.deviceVersion = str4;
        authRequestModel.networkMcc = TrackingHelper.a().l(TrackingManager.getContext());
        authRequestModel.appId = TrackingManager.getContext().getApplicationContext().getPackageName();
        authRequestModel.tac = TrackingHelper.a().w(TrackingManager.getContext());
        retrofit2.Response<ResponseBody> execute = ApiClient.a().a(authRequestModel, UrlProvider.b(SettingsManager.b().c())).execute();
        if (!execute.isSuccessful()) {
            return response.request();
        }
        ResponseBody body = execute.body();
        if (body != null) {
            str = body.string();
        }
        if (str == null) {
            return response.request();
        }
        this.a = 0;
        PreferencesManager.m().a(str);
        return response.request().newBuilder().header("Authorization", str).build();
    }
}
