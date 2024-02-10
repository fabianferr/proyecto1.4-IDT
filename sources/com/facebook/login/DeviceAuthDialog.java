package com.facebook.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.common.R;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginClient;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceAuthDialog extends DialogFragment {
    private static final String DEVICE_LOGIN_ENDPOINT = "device/login";
    private static final String DEVICE_LOGIN_STATUS_ENDPOINT = "device/login_status";
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED = 1349173;
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING = 1349174;
    private static final int LOGIN_ERROR_SUBCODE_CODE_EXPIRED = 1349152;
    private static final int LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING = 1349172;
    private static final String REQUEST_STATE_KEY = "request_state";
    /* access modifiers changed from: private */
    public AtomicBoolean completed = new AtomicBoolean();
    private TextView confirmationCode;
    private volatile GraphRequestAsyncTask currentGraphRequestPoll;
    /* access modifiers changed from: private */
    public volatile RequestState currentRequestState;
    private DeviceAuthMethodHandler deviceAuthMethodHandler;
    private TextView instructions;
    /* access modifiers changed from: private */
    public boolean isBeingDestroyed = false;
    /* access modifiers changed from: private */
    public boolean isRetry = false;
    /* access modifiers changed from: private */
    public LoginClient.Request mRequest = null;
    private View progressBar;
    private volatile ScheduledFuture scheduledPoll;

    /* access modifiers changed from: package-private */
    public Map<String, String> additionalDeviceInfo() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onBackButtonPressed() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.deviceAuthMethodHandler = (DeviceAuthMethodHandler) ((LoginFragment) ((FacebookActivity) getActivity()).getCurrentFragment()).getLoginClient().getCurrentHandler();
        if (!(bundle == null || (requestState = (RequestState) bundle.getParcelable(REQUEST_STATE_KEY)) == null)) {
            setCurrentRequestState(requestState);
        }
        return onCreateView;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AnonymousClass1 r3 = new Dialog(getActivity(), R.style.com_facebook_auth_dialog) {
            public void onBackPressed() {
                DeviceAuthDialog.this.onBackButtonPressed();
                super.onBackPressed();
            }
        };
        r3.setContentView(initializeContentView(DeviceRequestsHelper.isAvailable() && !this.isRetry));
        return r3;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (!this.isBeingDestroyed) {
            onCancel();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.currentRequestState != null) {
            bundle.putParcelable(REQUEST_STATE_KEY, this.currentRequestState);
        }
    }

    public void onDestroyView() {
        this.isBeingDestroyed = true;
        this.completed.set(true);
        super.onDestroyView();
        if (this.currentGraphRequestPoll != null) {
            this.currentGraphRequestPoll.cancel(true);
        }
        if (this.scheduledPoll != null) {
            this.scheduledPoll.cancel(true);
        }
        this.progressBar = null;
        this.confirmationCode = null;
        this.instructions = null;
    }

    public void startLogin(LoginClient.Request request) {
        this.mRequest = request;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request.getPermissions()));
        String deviceRedirectUriString = request.getDeviceRedirectUriString();
        if (deviceRedirectUriString != null) {
            bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, deviceRedirectUriString);
        }
        String deviceAuthTargetUserId = request.getDeviceAuthTargetUserId();
        if (deviceAuthTargetUserId != null) {
            bundle.putString(DeviceRequestsHelper.DEVICE_TARGET_USER_ID, deviceAuthTargetUserId);
        }
        bundle.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
        bundle.putString(DeviceRequestsHelper.DEVICE_INFO_PARAM, DeviceRequestsHelper.getDeviceInfo(additionalDeviceInfo()));
        new GraphRequest((AccessToken) null, DEVICE_LOGIN_ENDPOINT, bundle, HttpMethod.POST, new GraphRequest.Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                if (!DeviceAuthDialog.this.isBeingDestroyed) {
                    if (graphResponse.getError() != null) {
                        DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                        return;
                    }
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    RequestState requestState = new RequestState();
                    try {
                        requestState.setUserCode(jSONObject.getString("user_code"));
                        requestState.setRequestCode(jSONObject.getString("code"));
                        requestState.setInterval(jSONObject.getLong("interval"));
                        DeviceAuthDialog.this.setCurrentRequestState(requestState);
                    } catch (JSONException e) {
                        DeviceAuthDialog.this.onError(new FacebookException((Throwable) e));
                    }
                }
            }
        }).executeAsync();
    }

    /* access modifiers changed from: private */
    public void setCurrentRequestState(RequestState requestState) {
        this.currentRequestState = requestState;
        this.confirmationCode.setText(requestState.getUserCode());
        this.instructions.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, new BitmapDrawable(getResources(), DeviceRequestsHelper.generateQRCode(requestState.getAuthorizationUri())), (Drawable) null, (Drawable) null);
        this.confirmationCode.setVisibility(0);
        this.progressBar.setVisibility(8);
        if (!this.isRetry && DeviceRequestsHelper.startAdvertisementService(requestState.getUserCode())) {
            new InternalAppEventsLogger(getContext()).logEventImplicitly(AnalyticsEvents.EVENT_SMART_LOGIN_SERVICE);
        }
        if (requestState.withinLastRefreshWindow()) {
            schedulePoll();
        } else {
            poll();
        }
    }

    /* access modifiers changed from: protected */
    public View initializeContentView(boolean z) {
        View inflate = getActivity().getLayoutInflater().inflate(getLayoutResId(z), (ViewGroup) null);
        this.progressBar = inflate.findViewById(R.id.progress_bar);
        this.confirmationCode = (TextView) inflate.findViewById(R.id.confirmation_code);
        ((Button) inflate.findViewById(R.id.cancel_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    try {
                        DeviceAuthDialog.this.onCancel();
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.com_facebook_device_auth_instructions);
        this.instructions = textView;
        textView.setText(Html.fromHtml(getString(R.string.com_facebook_device_auth_instructions)));
        return inflate;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResId(boolean z) {
        return z ? R.layout.com_facebook_smart_device_dialog_fragment : R.layout.com_facebook_device_auth_dialog_fragment;
    }

    /* access modifiers changed from: private */
    public void poll() {
        this.currentRequestState.setLastPoll(new Date().getTime());
        this.currentGraphRequestPoll = getPollRequest().executeAsync();
    }

    /* access modifiers changed from: private */
    public void schedulePoll() {
        this.scheduledPoll = DeviceAuthMethodHandler.getBackgroundExecutor().schedule(new Runnable() {
            public void run() {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    try {
                        DeviceAuthDialog.this.poll();
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            }
        }, this.currentRequestState.getInterval(), TimeUnit.SECONDS);
    }

    private GraphRequest getPollRequest() {
        Bundle bundle = new Bundle();
        bundle.putString("code", this.currentRequestState.getRequestCode());
        return new GraphRequest((AccessToken) null, DEVICE_LOGIN_STATUS_ENDPOINT, bundle, HttpMethod.POST, new GraphRequest.Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                if (!DeviceAuthDialog.this.completed.get()) {
                    FacebookRequestError error = graphResponse.getError();
                    if (error != null) {
                        int subErrorCode = error.getSubErrorCode();
                        if (subErrorCode != DeviceAuthDialog.LOGIN_ERROR_SUBCODE_CODE_EXPIRED) {
                            switch (subErrorCode) {
                                case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING /*1349172*/:
                                case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING /*1349174*/:
                                    DeviceAuthDialog.this.schedulePoll();
                                    return;
                                case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED /*1349173*/:
                                    DeviceAuthDialog.this.onCancel();
                                    return;
                                default:
                                    DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                                    return;
                            }
                        } else {
                            if (DeviceAuthDialog.this.currentRequestState != null) {
                                DeviceRequestsHelper.cleanUpAdvertisementService(DeviceAuthDialog.this.currentRequestState.getUserCode());
                            }
                            if (DeviceAuthDialog.this.mRequest != null) {
                                DeviceAuthDialog deviceAuthDialog = DeviceAuthDialog.this;
                                deviceAuthDialog.startLogin(deviceAuthDialog.mRequest);
                                return;
                            }
                            DeviceAuthDialog.this.onCancel();
                        }
                    } else {
                        try {
                            JSONObject jSONObject = graphResponse.getJSONObject();
                            DeviceAuthDialog.this.onSuccess(jSONObject.getString("access_token"), Long.valueOf(jSONObject.getLong(AccessToken.EXPIRES_IN_KEY)), Long.valueOf(jSONObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
                        } catch (JSONException e) {
                            DeviceAuthDialog.this.onError(new FacebookException((Throwable) e));
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void presentConfirmation(String str, Utility.PermissionsLists permissionsLists, String str2, String str3, Date date, Date date2) {
        String string = getResources().getString(R.string.com_facebook_smart_login_confirmation_title);
        String string2 = getResources().getString(R.string.com_facebook_smart_login_confirmation_continue_as);
        String string3 = getResources().getString(R.string.com_facebook_smart_login_confirmation_cancel);
        String format = String.format(string2, new Object[]{str3});
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        final String str4 = str;
        final Utility.PermissionsLists permissionsLists2 = permissionsLists;
        final String str5 = str2;
        final Date date3 = date;
        final Date date4 = date2;
        builder.setMessage(string).setCancelable(true).setNegativeButton(format, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DeviceAuthDialog.this.completeLogin(str4, permissionsLists2, str5, date3, date4);
            }
        }).setPositiveButton(string3, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DeviceAuthDialog.this.getDialog().setContentView(DeviceAuthDialog.this.initializeContentView(false));
                DeviceAuthDialog deviceAuthDialog = DeviceAuthDialog.this;
                deviceAuthDialog.startLogin(deviceAuthDialog.mRequest);
            }
        });
        builder.create().show();
    }

    /* access modifiers changed from: private */
    public void onSuccess(String str, Long l, Long l2) {
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,permissions,name");
        final Date date = null;
        final Date date2 = l.longValue() != 0 ? new Date(new Date().getTime() + (l.longValue() * 1000)) : null;
        if (!(l2.longValue() == 0 || l2 == null)) {
            date = new Date(l2.longValue() * 1000);
        }
        final String str2 = str;
        new GraphRequest(new AccessToken(str, FacebookSdk.getApplicationId(), "0", (Collection<String>) null, (Collection<String>) null, (Collection<String>) null, (AccessTokenSource) null, date2, (Date) null, date), "me", bundle, HttpMethod.GET, new GraphRequest.Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                if (!DeviceAuthDialog.this.completed.get()) {
                    if (graphResponse.getError() != null) {
                        DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                        return;
                    }
                    try {
                        JSONObject jSONObject = graphResponse.getJSONObject();
                        String string = jSONObject.getString("id");
                        Utility.PermissionsLists handlePermissionResponse = Utility.handlePermissionResponse(jSONObject);
                        String string2 = jSONObject.getString("name");
                        DeviceRequestsHelper.cleanUpAdvertisementService(DeviceAuthDialog.this.currentRequestState.getUserCode());
                        if (!FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.RequireConfirm) || DeviceAuthDialog.this.isRetry) {
                            DeviceAuthDialog.this.completeLogin(string, handlePermissionResponse, str2, date2, date);
                            return;
                        }
                        boolean unused = DeviceAuthDialog.this.isRetry = true;
                        DeviceAuthDialog.this.presentConfirmation(string, handlePermissionResponse, str2, string2, date2, date);
                    } catch (JSONException e) {
                        DeviceAuthDialog.this.onError(new FacebookException((Throwable) e));
                    }
                }
            }
        }).executeAsync();
    }

    /* access modifiers changed from: private */
    public void completeLogin(String str, Utility.PermissionsLists permissionsLists, String str2, Date date, Date date2) {
        this.deviceAuthMethodHandler.onSuccess(str2, FacebookSdk.getApplicationId(), str, permissionsLists.getGrantedPermissions(), permissionsLists.getDeclinedPermissions(), permissionsLists.getExpiredPermissions(), AccessTokenSource.DEVICE_AUTH, date, (Date) null, date2);
        getDialog().dismiss();
    }

    /* access modifiers changed from: protected */
    public void onError(FacebookException facebookException) {
        if (this.completed.compareAndSet(false, true)) {
            if (this.currentRequestState != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
            }
            this.deviceAuthMethodHandler.onError(facebookException);
            getDialog().dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onCancel() {
        if (this.completed.compareAndSet(false, true)) {
            if (this.currentRequestState != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler2 = this.deviceAuthMethodHandler;
            if (deviceAuthMethodHandler2 != null) {
                deviceAuthMethodHandler2.onCancel();
            }
            getDialog().dismiss();
        }
    }

    private static class RequestState implements Parcelable {
        public static final Parcelable.Creator<RequestState> CREATOR = new Parcelable.Creator<RequestState>() {
            public RequestState createFromParcel(Parcel parcel) {
                return new RequestState(parcel);
            }

            public RequestState[] newArray(int i) {
                return new RequestState[i];
            }
        };
        private String authorizationUri;
        private long interval;
        private long lastPoll;
        private String requestCode;
        private String userCode;

        public int describeContents() {
            return 0;
        }

        RequestState() {
        }

        public String getAuthorizationUri() {
            return this.authorizationUri;
        }

        public String getUserCode() {
            return this.userCode;
        }

        public void setUserCode(String str) {
            this.userCode = str;
            this.authorizationUri = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", new Object[]{str});
        }

        public String getRequestCode() {
            return this.requestCode;
        }

        public void setRequestCode(String str) {
            this.requestCode = str;
        }

        public long getInterval() {
            return this.interval;
        }

        public void setInterval(long j) {
            this.interval = j;
        }

        public void setLastPoll(long j) {
            this.lastPoll = j;
        }

        protected RequestState(Parcel parcel) {
            this.authorizationUri = parcel.readString();
            this.userCode = parcel.readString();
            this.requestCode = parcel.readString();
            this.interval = parcel.readLong();
            this.lastPoll = parcel.readLong();
        }

        public boolean withinLastRefreshWindow() {
            if (this.lastPoll != 0 && (new Date().getTime() - this.lastPoll) - (this.interval * 1000) < 0) {
                return true;
            }
            return false;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.authorizationUri);
            parcel.writeString(this.userCode);
            parcel.writeString(this.requestCode);
            parcel.writeLong(this.interval);
            parcel.writeLong(this.lastPoll);
        }
    }
}
