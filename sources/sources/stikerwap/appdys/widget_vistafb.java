package stikerwap.appdys;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.media3.common.C;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;

public class widget_vistafb extends AppWidgetProvider {
    public static final String ACTUALITZAR_ACTION = "android.appwidget.action.APPWIDGET_UPDATE";
    public static final String EXTRA_ITEM = "EXTRA_ITEM";
    public static final String TOAST_ACTION = "stikerwap.appdys.TOAST_ACTION";
    RemoteViews rv;

    public void onReceive(Context context, Intent intent) {
        String str;
        String str2;
        Object obj;
        Context context2 = context;
        Intent intent2 = intent;
        AppWidgetManager instance = AppWidgetManager.getInstance(context);
        SharedPreferences sharedPreferences = context2.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        String str3 = sharedPreferences.getLong("idusu", 0) + "";
        String string = sharedPreferences.getString("nick", "");
        if (intent.getAction().equals(TOAST_ACTION)) {
            intent2.getIntExtra(EXTRA_ITEM, 0);
            String stringExtra = intent2.getStringExtra("EXTRA_TIPO");
            String stringExtra2 = intent2.getStringExtra("EXTRA_IDUSU");
            String stringExtra3 = intent2.getStringExtra("EXTRA_IDELEM");
            intent2.getStringExtra("EXTRA_IDELEM_2");
            String stringExtra4 = intent2.getStringExtra("EXTRA_IDELEM_3");
            String stringExtra5 = intent2.getStringExtra("EXTRA_PRIVADOS");
            String stringExtra6 = intent2.getStringExtra("EXTRA_NOMBRE");
            String stringExtra7 = intent2.getStringExtra("EXTRA_COMENTS");
            String stringExtra8 = intent2.getStringExtra("EXTRA_FNAC_D");
            String stringExtra9 = intent2.getStringExtra("EXTRA_FNAC_M");
            String stringExtra10 = intent2.getStringExtra("EXTRA_FNAC_A");
            String stringExtra11 = intent2.getStringExtra("EXTRA_SEXO");
            String stringExtra12 = intent2.getStringExtra("EXTRA_VFOTO");
            String str4 = stringExtra4;
            String stringExtra13 = intent2.getStringExtra("EXTRA_FNAC_CHAT");
            String str5 = stringExtra3;
            String stringExtra14 = intent2.getStringExtra("EXTRA_SEXO_CHAT");
            String stringExtra15 = intent2.getStringExtra("EXTRA_DESCR_CHAT");
            String stringExtra16 = intent2.getStringExtra("EXTRA_DIST_CHAT");
            String stringExtra17 = intent2.getStringExtra("EXTRA_COMENTS_CHAT");
            String stringExtra18 = intent2.getStringExtra("EXTRA_GALERIA_CHAT");
            String stringExtra19 = intent2.getStringExtra("EXTRA_PRIVADOS_CHAT");
            String stringExtra20 = intent2.getStringExtra("EXTRA_FOTOS_PERFIL");
            String stringExtra21 = intent2.getStringExtra("EXTRA_FOTOS_CHAT");
            String stringExtra22 = intent2.getStringExtra("EXTRA_FCREA");
            if (stringExtra != null) {
                String str6 = stringExtra22;
                Intent intent3 = new Intent(context2, preinicio.class);
                Object obj2 = "4";
                if (!stringExtra.equals("4")) {
                    String str7 = "abrir_idsecc";
                    if (stringExtra.equals(CampaignEx.CLICKMODE_ON)) {
                        str2 = str4;
                        str = str7;
                    } else {
                        if (!stringExtra.equals("9")) {
                            obj = "9";
                            if (!stringExtra.equals("10")) {
                                Object obj3 = "6";
                                String str8 = stringExtra13;
                                if (stringExtra.equals("6") || stringExtra.equals("8")) {
                                    intent3.putExtra("abrir_perfil", str3);
                                    intent3.putExtra("nombre", string);
                                } else {
                                    intent3.putExtra("abrir_perfil", stringExtra2);
                                    intent3.putExtra("nombre", stringExtra6);
                                }
                                intent3.putExtra("privados", stringExtra5);
                                intent3.putExtra("coments", stringExtra7);
                                intent3.putExtra("fnac_d", stringExtra8);
                                intent3.putExtra("fnac_m", stringExtra9);
                                intent3.putExtra("fnac_a", stringExtra10);
                                intent3.putExtra("sexo", stringExtra11);
                                intent3.putExtra("vfoto", stringExtra12);
                                intent3.putExtra("p_fnac", Integer.parseInt(str8));
                                intent3.putExtra("p_sexo", Integer.parseInt(stringExtra14));
                                intent3.putExtra("p_descr", Integer.parseInt(stringExtra15));
                                intent3.putExtra("p_dist", Integer.parseInt(stringExtra16));
                                intent3.putExtra("coments_chat", stringExtra17.equals("1"));
                                intent3.putExtra("galeria", stringExtra18.equals("1"));
                                intent3.putExtra("privados_chat", stringExtra19.equals("1"));
                                intent3.putExtra("fotos_perfil", Integer.parseInt(stringExtra20));
                                intent3.putExtra("fotos_chat", Integer.parseInt(stringExtra21));
                                if (stringExtra.equals(obj3)) {
                                    intent3.putExtra("abrir_perfilv", str5);
                                    intent3.putExtra("abrir_perfilv_formato", str4);
                                } else {
                                    String str9 = str5;
                                    if (stringExtra.equals("7")) {
                                        intent3.putExtra("abrir_game", str9);
                                    }
                                }
                                intent3.addFlags(268435456);
                                context.startActivity(intent3);
                            }
                        } else {
                            obj = "9";
                        }
                        String[] split = str4.split("-");
                        String str10 = stringExtra5;
                        intent3.putExtra(str7, split[1]);
                        intent3.putExtra("abrir_buscvideo", str5);
                        intent3.putExtra("abrir_buscvideo_formato", split[0]);
                        if (stringExtra.equals(obj)) {
                            intent3.putExtra("abrir_buscvideo_idusu", stringExtra2);
                            intent3.putExtra("abrir_buscvideo_nombre", stringExtra6);
                            intent3.putExtra("abrir_buscvideo_vfoto", stringExtra12);
                        } else {
                            intent3.putExtra("abrir_buscvideo_idusu", str3);
                            intent3.putExtra("abrir_buscvideo_nombre", string);
                            intent3.putExtra("abrir_buscvideo_vfoto", "99999999");
                        }
                        intent3.putExtra("abrir_buscvideo_nlikes", split[2]);
                        intent3.putExtra("abrir_buscvideo_liked", split[4]);
                        intent3.putExtra("abrir_buscvideo_descr", split[3]);
                        intent3.putExtra("abrir_buscvideo_nvideos", split[5]);
                        intent3.putExtra("abrir_buscvideo_fcrea", str6);
                        intent3.putExtra("abrir_buscvideo_coments", stringExtra7);
                        intent3.putExtra("abrir_buscvideo_fnac_d", stringExtra8);
                        intent3.putExtra("abrir_buscvideo_fnac_m", stringExtra9);
                        intent3.putExtra("abrir_buscvideo_fnac_a", stringExtra10);
                        intent3.putExtra("abrir_buscvideo_sexo", stringExtra11);
                        intent3.putExtra("abrir_buscvideo_privados", str10);
                        intent3.addFlags(268435456);
                        context.startActivity(intent3);
                    }
                } else {
                    str = "abrir_idsecc";
                    str2 = str4;
                }
                String[] split2 = str2.split("-");
                intent3.putExtra(str, split2[0]);
                if (stringExtra.equals(obj2)) {
                    intent3.putExtra("abrir_idcat", split2[1]);
                    intent3.putExtra("abrir_idtema", split2[2]);
                    intent3.putExtra("idresp_ir", split2[3]);
                } else {
                    intent3.putExtra("abrir_idcat", split2[1]);
                    intent3.putExtra("abrir_idtema", split2[2]);
                    intent3.putExtra("abrir_idresp", split2[3]);
                    intent3.putExtra("idcoment_ir", split2[4]);
                }
                intent3.addFlags(268435456);
                context.startActivity(intent3);
            }
        } else if (intent.getAction().equals(ACTUALITZAR_ACTION)) {
            int intExtra = intent.getIntExtra("appWidgetId", 0);
            if (intExtra == 0) {
                for (int notifyAppWidgetViewDataChanged : AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context2, widget_vistafb.class))) {
                    instance.notifyAppWidgetViewDataChanged(notifyAppWidgetViewDataChanged, R.id.w_main);
                }
            } else {
                instance.notifyAppWidgetViewDataChanged(intExtra, R.id.w_main);
            }
            super.onReceive(context, intent);
        }
        Intent intent4 = intent;
        super.onReceive(context, intent);
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        PendingIntent pendingIntent;
        for (int i = 0; i < iArr.length; i++) {
            Intent intent = new Intent(context, s_widget_vistafb.class);
            intent.putExtra("appWidgetId", iArr[i]);
            intent.setData(Uri.parse(intent.toUri(1)));
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_vistafb);
            this.rv = remoteViews;
            remoteViews.setOnClickPendingIntent(R.id.w_reload, getPendingSelfIntent(context, ACTUALITZAR_ACTION, iArr[i]));
            this.rv.setRemoteAdapter(R.id.w_main, intent);
            Intent intent2 = new Intent(context, widget_vistafb.class);
            intent2.setAction(TOAST_ACTION);
            intent2.putExtra("appWidgetId", iArr[i]);
            intent.setData(Uri.parse(intent.toUri(1)));
            if (Build.VERSION.SDK_INT >= 23) {
                pendingIntent = PendingIntent.getBroadcast(context, 0, intent2, 201326592);
            } else {
                pendingIntent = PendingIntent.getBroadcast(context, 0, intent2, C.BUFFER_FLAG_FIRST_SAMPLE);
            }
            this.rv.setPendingIntentTemplate(R.id.w_main, pendingIntent);
            appWidgetManager.updateAppWidget(iArr[i], this.rv);
        }
        super.onUpdate(context, appWidgetManager, iArr);
    }

    /* access modifiers changed from: protected */
    public PendingIntent getPendingSelfIntent(Context context, String str, int i) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(str);
        intent.putExtra("appWidgetId", i);
        intent.setData(Uri.parse(intent.toUri(1)));
        if (Build.VERSION.SDK_INT >= 23) {
            return PendingIntent.getBroadcast(context, 0, intent, 67108864);
        }
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }
}
