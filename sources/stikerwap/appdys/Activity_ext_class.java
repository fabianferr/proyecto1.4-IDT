package stikerwap.appdys;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import com.appnext.ads.fullscreen.RewardedVideo;
import com.facebook.ads.RewardedVideoAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.startapp.sdk.adsbase.StartAppAd;

public class Activity_ext_class extends Activity {
    boolean buscador_on = false;
    String cbtn;
    ProgressDialog dialog_cargando;
    boolean es_root;
    boolean finalizar = false;
    RewardedVideo mAd_appnext;
    RewardedVideoAd mAd_fb;
    StartAppAd mAd_st;
    RewardedAdLoadCallback ralc;
    View v_abrir_secc;
}
