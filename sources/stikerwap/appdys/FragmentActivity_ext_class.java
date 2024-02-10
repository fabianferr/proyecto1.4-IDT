package stikerwap.appdys;

import android.app.ProgressDialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.appnext.ads.fullscreen.RewardedVideo;
import com.facebook.ads.RewardedVideoAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.startapp.sdk.adsbase.StartAppAd;

public class FragmentActivity_ext_class extends FragmentActivity {
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
