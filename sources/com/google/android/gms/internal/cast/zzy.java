package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.mediarouter.app.MediaRouteChooserDialog;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzy extends MediaRouteChooserDialog implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final Logger zzh = new Logger("DeviceChooserDialog");
    TextView zza;
    ListView zzb;
    View zzc;
    LinearLayout zzd;
    LinearLayout zze;
    LinearLayout zzf;
    RelativeLayout zzg;
    private final zzw zzi = new zzw(this);
    /* access modifiers changed from: private */
    public final List zzj = new CopyOnWriteArrayList();
    private final long zzk = zzac.zza();
    private final boolean zzl = zzac.zzc();
    private MediaRouter zzm;
    private zzdy zzn;
    private MediaRouteSelector zzo = MediaRouteSelector.EMPTY;
    private ArrayAdapter zzp;
    private boolean zzq;
    private Runnable zzr;
    /* access modifiers changed from: private */
    public MediaRouter.RouteInfo zzs;

    public zzy(Context context, int i) {
        super(context, 0);
    }

    /* access modifiers changed from: private */
    public final void zzf() {
        MediaRouter mediaRouter = this.zzm;
        if (mediaRouter != null) {
            ArrayList arrayList = new ArrayList(mediaRouter.getRoutes());
            onFilterRoutes(arrayList);
            Collections.sort(arrayList, zzx.zza);
            for (zzv zza2 : this.zzj) {
                zza2.zza(arrayList);
            }
        }
    }

    private final void zzg() {
        Logger logger = zzh;
        logger.d("startDiscovery", new Object[0]);
        MediaRouter mediaRouter = this.zzm;
        if (mediaRouter == null) {
            logger.d("Can't start discovery. setUpMediaRouter needs to be called first", new Object[0]);
            return;
        }
        mediaRouter.addCallback(this.zzo, this.zzi, 1);
        for (zzv zzc2 : this.zzj) {
            zzc2.zzc(1);
        }
    }

    private final void zzh() {
        Logger logger = zzh;
        logger.d("stopDiscovery", new Object[0]);
        MediaRouter mediaRouter = this.zzm;
        if (mediaRouter == null) {
            logger.d("Can't stop discovery. setUpMediaRouter needs to be called first", new Object[0]);
            return;
        }
        mediaRouter.removeCallback(this.zzi);
        this.zzm.addCallback(this.zzo, this.zzi, 0);
        for (zzv zzd2 : this.zzj) {
            zzd2.zzd();
        }
    }

    private final void zzi(int i) {
        if (this.zzd != null && this.zze != null && this.zzf != null && this.zzg != null) {
            CastContext sharedInstance = CastContext.getSharedInstance();
            if (this.zzl && sharedInstance != null && !sharedInstance.zzf().zza()) {
                i = 3;
            }
            int i2 = i - 1;
            if (i2 == 0) {
                setTitle(R.string.cast_device_chooser_title);
                ((LinearLayout) Preconditions.checkNotNull(this.zzd)).setVisibility(0);
                ((LinearLayout) Preconditions.checkNotNull(this.zze)).setVisibility(8);
                ((LinearLayout) Preconditions.checkNotNull(this.zzf)).setVisibility(8);
                ((RelativeLayout) Preconditions.checkNotNull(this.zzg)).setVisibility(8);
            } else if (i2 != 1) {
                setTitle(R.string.cast_wifi_warning_title);
                ((LinearLayout) Preconditions.checkNotNull(this.zzd)).setVisibility(8);
                ((LinearLayout) Preconditions.checkNotNull(this.zze)).setVisibility(8);
                ((LinearLayout) Preconditions.checkNotNull(this.zzf)).setVisibility(0);
                ((RelativeLayout) Preconditions.checkNotNull(this.zzg)).setVisibility(0);
            } else {
                setTitle(R.string.cast_device_chooser_title);
                ((LinearLayout) Preconditions.checkNotNull(this.zzd)).setVisibility(8);
                ((LinearLayout) Preconditions.checkNotNull(this.zze)).setVisibility(0);
                ((LinearLayout) Preconditions.checkNotNull(this.zzf)).setVisibility(8);
                ((RelativeLayout) Preconditions.checkNotNull(this.zzg)).setVisibility(0);
            }
        }
    }

    public final void dismiss() {
        super.dismiss();
        zzdy zzdy = this.zzn;
        if (zzdy != null) {
            zzdy.removeCallbacks(this.zzr);
        }
        View view = this.zzc;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        for (zzv zzb2 : this.zzj) {
            zzb2.zzb(this.zzs);
        }
        this.zzj.clear();
    }

    public final MediaRouteSelector getRouteSelector() {
        return this.zzo;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.zzq = true;
        zzg();
        zzf();
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ListView listView = (ListView) super.findViewById(androidx.mediarouter.R.id.mr_chooser_list);
        if (listView != null) {
            setContentView(R.layout.cast_device_chooser_dialog);
            this.zzp = (ArrayAdapter) listView.getAdapter();
            ListView listView2 = (ListView) findViewById(R.id.cast_device_chooser_list);
            this.zzb = listView2;
            if (listView2 != null) {
                listView2.setAdapter(this.zzp);
                this.zzb.setOnItemClickListener(listView.getOnItemClickListener());
            }
            this.zza = (TextView) findViewById(R.id.cast_device_chooser_title);
            this.zzd = (LinearLayout) findViewById(R.id.cast_device_chooser_searching);
            this.zze = (LinearLayout) findViewById(R.id.cast_device_chooser_zero_devices);
            this.zzf = (LinearLayout) findViewById(R.id.cast_device_chooser_wifi_warning);
            this.zzg = (RelativeLayout) findViewById(R.id.footer);
            TextView textView = (TextView) findViewById(R.id.cast_device_chooser_learn_more);
            TextView textView2 = (TextView) findViewById(R.id.cast_device_chooser_wifi_warning_description);
            zzt zzt = new zzt(this);
            if (textView != null) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setOnClickListener(zzt);
            }
            if (textView2 != null) {
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                textView2.setOnClickListener(zzt);
            }
            Button button = (Button) findViewById(R.id.done_button);
            if (button != null) {
                button.setOnClickListener(new zzu(this));
            }
            View findViewById = findViewById(16908292);
            this.zzc = findViewById;
            if (!(this.zzb == null || findViewById == null)) {
                ((View) Preconditions.checkNotNull(findViewById)).getViewTreeObserver().addOnGlobalLayoutListener(this);
                ((ListView) Preconditions.checkNotNull(this.zzb)).setEmptyView((View) Preconditions.checkNotNull(this.zzc));
            }
            this.zzr = new zzs(this);
        }
    }

    public final void onDetachedFromWindow() {
        this.zzq = false;
        super.onDetachedFromWindow();
        zzh();
    }

    public final void onGlobalLayout() {
        View view = this.zzc;
        if (view != null) {
            Object tag = view.getTag();
            int visibility = this.zzc.getVisibility();
            if (tag == null || ((Integer) tag).intValue() != visibility) {
                if (visibility == 0) {
                    zzi(1);
                    zzdy zzdy = this.zzn;
                    if (zzdy != null) {
                        zzdy.removeCallbacks(this.zzr);
                        this.zzn.postDelayed(this.zzr, this.zzk);
                    }
                } else {
                    setTitle(R.string.cast_device_chooser_title);
                }
                ((View) Preconditions.checkNotNull(this.zzc)).setTag(Integer.valueOf(visibility));
            }
        }
    }

    public final void refreshRoutes() {
        super.refreshRoutes();
        zzf();
    }

    public final void setTitle(int i) {
        TextView textView = this.zza;
        if (textView != null) {
            textView.setText(i);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        zzi(2);
        for (zzv zzv : this.zzj) {
        }
    }

    public final void zze() {
        this.zzm = MediaRouter.getInstance(getContext());
        this.zzn = new zzdy(Looper.getMainLooper());
        zzv zza2 = zzp.zza();
        if (zza2 != null) {
            this.zzj.add(zza2);
        }
    }

    public final void setRouteSelector(MediaRouteSelector mediaRouteSelector) {
        if (mediaRouteSelector != null) {
            super.setRouteSelector(mediaRouteSelector);
            if (!this.zzo.equals(mediaRouteSelector)) {
                this.zzo = mediaRouteSelector;
                zzh();
                if (this.zzq) {
                    zzg();
                }
                zzf();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("selector must not be null");
    }

    public final void setTitle(CharSequence charSequence) {
        TextView textView = this.zza;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
