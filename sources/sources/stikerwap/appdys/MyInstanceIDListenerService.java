package stikerwap.appdys;

import android.content.Intent;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyInstanceIDListenerService extends FirebaseInstanceIdService {
    public void onTokenRefresh() {
        try {
            startService(new Intent(this, RegistrationIntentService.class));
        } catch (Exception unused) {
        }
    }
}
