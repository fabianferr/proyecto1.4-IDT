package stikerwap.appdys;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.C;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.mbridge.msdk.foundation.entity.CampaignUnit;

public class MyFcmListenerService extends FirebaseMessagingService {
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str;
        int i;
        NotificationCompat.Builder builder;
        NotificationCompat.Builder builder2;
        String str2 = remoteMessage.getData().get(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        if (str2 != null) {
            String replace = str2.replace("@EURO@", "€");
            SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
            try {
                sharedPreferences.getLong("idusu", 0);
            } catch (ClassCastException unused) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove("idusu");
                edit.commit();
                edit.putLong("idusu", (long) sharedPreferences.getInt("idusu", 0));
                edit.commit();
            }
            if (sharedPreferences == null || !sharedPreferences.getBoolean("sin_acceso", false)) {
                int i2 = Build.VERSION.SDK_INT >= 23 ? 201326592 : C.BUFFER_FLAG_FIRST_SAMPLE;
                if (replace.equals("ACC_APROB")) {
                    try {
                        getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit().putBoolean("glob_acceso_validado", true).commit();
                    } catch (Exception unused2) {
                    }
                    if (Build.VERSION.SDK_INT >= 26) {
                        builder2 = new NotificationCompat.Builder((Context) this, config.crear_channel(this, 1).getId());
                    } else {
                        builder2 = new NotificationCompat.Builder(this);
                    }
                    builder2.setSmallIcon((int) R.drawable.notif).setContentTitle(getResources().getString(R.string.acceso_aprobado)).setContentText(getResources().getString(R.string.acceso_aprobado_descr)).setAutoCancel(true);
                    Bitmap ico_en_notif = config.ico_en_notif(this);
                    if (ico_en_notif != null) {
                        builder2.setLargeIcon(ico_en_notif);
                    }
                    builder2.setDefaults(5);
                    Intent intent = new Intent(this, preinicio.class);
                    intent.setFlags(268468224);
                    builder2.setContentIntent(PendingIntent.getActivity(this, 8, intent, i2));
                    ((NotificationManager) getSystemService("notification")).notify(8, builder2.build());
                    return;
                }
                try {
                    SharedPreferences sharedPreferences2 = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
                    String string = sharedPreferences2.getString(CmcdHeadersFactory.OBJECT_TYPE_INIT_SEGMENT, "");
                    if (string.length() > 16 && Integer.parseInt(string.substring(16, 17)) > 1 && !sharedPreferences2.getBoolean("glob_acceso_validado", false)) {
                        return;
                    }
                } catch (Exception unused3) {
                }
                String[] split = replace.split(";");
                if (split.length < 3) {
                    String replace2 = replace.replace("@x@", ";");
                    int length = replace2.split("@").length;
                    if (length == 8 || length == 5 || length == 9 || length == 11 || length == 12 || length == 13 || length == 7) {
                        config.notificar(this, replace2);
                    }
                } else if (split[1].equals("0") || split[1].equals("1") || split[1].equals("2") || split[1].equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                    try {
                        SharedPreferences sharedPreferences3 = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
                        SharedPreferences.Editor edit2 = sharedPreferences3.edit();
                        if (split[1].equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                            String str3 = split[4];
                            if (sharedPreferences3.getString("ultmsg", "").equals(str3)) {
                                i = i2;
                                str = "notification";
                                if (System.currentTimeMillis() - sharedPreferences3.getLong("fchat_ult", System.currentTimeMillis()) < 5000) {
                                    return;
                                }
                            } else {
                                i = i2;
                                str = "notification";
                            }
                            edit2.putLong("fchat_ult", System.currentTimeMillis());
                            edit2.putString("ultmsg", str3);
                            String string2 = sharedPreferences3.getString("conv", "");
                            edit2.putString("conv", string2 + "@0@" + split[4].replace("@x@", ";"));
                            edit2.commit();
                        } else {
                            i = i2;
                            str = "notification";
                        }
                        if (!split[1].equals(ExifInterface.GPS_MEASUREMENT_3D) || !sharedPreferences3.getBoolean("activa", false)) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                builder = new NotificationCompat.Builder((Context) this, config.crear_channel(this, 1).getId());
                            } else {
                                builder = new NotificationCompat.Builder(this);
                            }
                            NotificationCompat.Builder builder3 = builder;
                            builder3.setSmallIcon((int) R.drawable.notif).setContentTitle(split[2].replace("@x@", ";")).setContentText(split[3].replace("@x@", ";")).setAutoCancel(true);
                            Bitmap ico_en_notif2 = config.ico_en_notif(this);
                            if (ico_en_notif2 != null) {
                                builder3.setLargeIcon(ico_en_notif2);
                            }
                            if (split[6].equals("1")) {
                                Bitmap bitmapFromURL = config.getBitmapFromURL(config.DOM_CDN + "/srv/imgs/notif/n" + split[0] + ".png");
                                if (bitmapFromURL != null) {
                                    try {
                                        builder3.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmapFromURL).bigLargeIcon((Bitmap) null));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            builder3.setDefaults(5);
                            Intent intent2 = new Intent(this, preinicio.class);
                            intent2.setFlags(268468224);
                            intent2.putExtra("notif_id", split[0]);
                            intent2.putExtra("notif_tipo", split[1]);
                            intent2.putExtra("notif_idelem", split[4].replace("@x@", ";"));
                            int i3 = sharedPreferences3.getInt("numnotif", 20);
                            if (split[5].equals("0")) {
                                i3++;
                                if (i3 > 99) {
                                    i3 = 20;
                                }
                                edit2.putInt("numnotif", i3);
                                edit2.commit();
                            }
                            int i4 = i3;
                            config.crear_notif(this, split[2].replace("@x@", ";"), split[3].replace("@x@", ";"), intent2, i4, 1, "0", "0");
                            builder3.setContentIntent(PendingIntent.getActivity(this, i4, intent2, i));
                            ((NotificationManager) getSystemService(str)).notify(i4, builder3.build());
                            return;
                        }
                        edit2.putString("f_id", "0");
                        edit2.putString("f_idfrase", config.idfrase_global + "");
                        edit2.putString("f_frase", split[4].replace("@x@", ";"));
                        config.idfrase_global = config.idfrase_global + 1;
                        edit2.commit();
                    } catch (Exception unused4) {
                    }
                }
            }
        }
    }
}
