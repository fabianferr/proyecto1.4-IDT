package com.umlaut.crowd.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsMessage;
import com.facebook.appevents.integrity.IntegrityManager;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.internal.CLC;
import com.umlaut.crowd.timeserver.TimeServer;

public class w5 {
    public static final String e = "w5";
    public static final boolean f = false;
    /* access modifiers changed from: private */
    public final String a = InsightCore.getInsightConfig().f1();
    /* access modifiers changed from: private */
    public final Context b;
    /* access modifiers changed from: private */
    public final IS c;
    /* access modifiers changed from: private */
    public final CLC d;

    private class b extends ContentObserver {
        private String a = "";

        public b(Handler handler) {
            super(handler);
        }

        public void onChange(boolean z) {
            onChange(z, (Uri) null);
        }

        public void onChange(boolean z, Uri uri) {
            Cursor query;
            int i;
            if (w5.this.b.checkCallingOrSelfPermission("android.permission.READ_SMS") != -1 && (query = w5.this.b.getContentResolver().query(Uri.parse("content://sms"), (String[]) null, (String) null, (String[]) null, (String) null)) != null) {
                if (query.moveToNext()) {
                    int i2 = query.getInt(query.getColumnIndexOrThrow("type"));
                    String string = query.getString(query.getColumnIndexOrThrow("_id"));
                    if (string != null && !string.equals(this.a) && i2 == 2) {
                        String string2 = query.getString(query.getColumnIndexOrThrow(IntegrityManager.INTEGRITY_TYPE_ADDRESS));
                        String string3 = query.getString(query.getColumnIndexOrThrow("body"));
                        RMR rmr = new RMR(w5.this.a, w5.this.c.q());
                        ub timeInfo = TimeServer.getTimeInfo();
                        rmr.TimeInfo = timeInfo;
                        rmr.TimestampMessage = timeInfo.TimestampTableau;
                        rmr.MessageDirection = p5.Outgoing;
                        if (!InsightCore.getInsightConfig().B()) {
                            rmr.LocationInfo = w5.this.d.getLastLocationInfo();
                        }
                        rmr.RadioInfo = InsightCore.getRadioController().i();
                        rmr.BMSISDN = aa.a(string2, w5.this.c.B());
                        if (string3 == null) {
                            i = 0;
                        } else {
                            i = string3.length();
                        }
                        rmr.MessageLength = i;
                        InsightCore.getDatabaseHelper().a(w2.MSG, (RBR) rmr);
                        if (InsightCore.getQoeManagerEnabled() && InsightCore.getQoeManager().i()) {
                            InsightCore.getQoeManager().a(rmr);
                        }
                        this.a = string;
                    }
                }
                query.close();
            }
        }
    }

    private class c extends BroadcastReceiver {
        private c() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
                RMR rmr = new RMR(w5.this.a, w5.this.c.q());
                ub timeInfo = TimeServer.getTimeInfo();
                rmr.TimeInfo = timeInfo;
                rmr.TimestampMessage = timeInfo.TimestampTableau;
                rmr.MessageDirection = p5.Incoming;
                rmr.RadioInfo = InsightCore.getRadioController().i();
                if (!InsightCore.getInsightConfig().B()) {
                    rmr.LocationInfo = w5.this.d.getLastLocationInfo();
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    for (Object obj : (Object[]) extras.get("pdus")) {
                        SmsMessage createFromPdu = SmsMessage.createFromPdu((byte[]) obj);
                        if (createFromPdu != null) {
                            rmr.BMSISDN = aa.a(createFromPdu.getOriginatingAddress() == null ? "" : createFromPdu.getOriginatingAddress(), w5.this.c.B());
                            rmr.MessageLength = createFromPdu.getMessageBody() == null ? 0 : createFromPdu.getMessageBody().length();
                            InsightCore.getDatabaseHelper().a(w2.MSG, (RBR) rmr);
                            if (InsightCore.getQoeManagerEnabled() && InsightCore.getQoeManager().i()) {
                                InsightCore.getQoeManager().a(rmr);
                            }
                        }
                    }
                }
            }
        }
    }

    public w5(Context context) {
        this.b = context;
        this.c = new IS(context);
        context.registerReceiver(new c(), new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
        b bVar = new b(new Handler());
        if (context.checkCallingOrSelfPermission("android.permission.READ_SMS") == 0) {
            context.getContentResolver().registerContentObserver(Uri.parse("content://sms"), true, bVar);
        }
        this.d = new CLC(context);
    }

    public void a() {
        this.d.startListening(CLC.ProviderMode.Passive);
    }

    public void b() {
        this.d.stopListening();
    }
}
