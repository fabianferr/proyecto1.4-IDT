package com.umlaut.crowd.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.util.Log;
import com.facebook.appevents.integrity.IntegrityManager;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import com.umlaut.crowd.InsightCore;

public class x {
    private static final String c = "x";
    private BatteryManager a;
    private final Context b;

    public x(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.a = (BatteryManager) context.getSystemService("batterymanager");
        }
        this.b = context;
    }

    public z a() {
        w wVar;
        y yVar;
        Intent intent = null;
        try {
            intent = this.b.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            Log.e(c, e.getMessage(), e);
        }
        z zVar = new z();
        if (intent == null) {
            zVar.MissingPermission = true;
            return zVar;
        }
        int intExtra = intent.getIntExtra("status", 1);
        a0 a0Var = a0.Unknown;
        if (intExtra == 2) {
            a0Var = a0.Charging;
        } else if (intExtra == 3) {
            a0Var = a0.Discharging;
        } else if (intExtra == 4) {
            a0Var = a0.NotCharging;
        } else if (intExtra == 5) {
            a0Var = a0.Full;
        }
        zVar.BatteryStatus = a0Var;
        int intExtra2 = intent.getIntExtra("plugged", -1);
        if (intExtra2 == 1) {
            wVar = w.AC;
        } else if (intExtra2 == 2) {
            wVar = w.USB;
        } else if (intExtra2 != 4) {
            wVar = w.Unknown;
        } else {
            wVar = w.Wireless;
        }
        zVar.BatteryChargePlug = wVar;
        zVar.BatteryLevel = (((float) intent.getIntExtra("level", -1)) / ((float) intent.getIntExtra("scale", -1))) * 100.0f;
        int intExtra3 = intent.getIntExtra(IntegrityManager.INTEGRITY_TYPE_HEALTH, -1);
        if (intExtra3 == 2) {
            yVar = y.Good;
        } else if (intExtra3 == 3) {
            yVar = y.Overheat;
        } else if (intExtra3 == 4) {
            yVar = y.Dead;
        } else if (intExtra3 == 5) {
            yVar = y.OverVoltage;
        } else if (intExtra3 != 7) {
            yVar = y.Unknown;
        } else {
            yVar = y.Cold;
        }
        zVar.BatteryHealth = yVar;
        int intExtra4 = intent.getIntExtra("temperature", -1);
        if (InsightCore.getInsightConfig().w()) {
            zVar.BatteryTemp = String.valueOf(o1.a());
        } else if (intExtra4 > -1) {
            zVar.BatteryTemp = (((float) intExtra4) / 10.0f) + "";
        }
        int intExtra5 = intent.getIntExtra("voltage", -1);
        if (intExtra5 > -1) {
            zVar.BatteryVoltage = intExtra5;
        }
        zVar.BatteryTechnology = aa.a(intent.getStringExtra(ThroughputConfigUtil.SHARED_PREFS_KEY_TECHNOLOGY));
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                a(zVar);
            } catch (Exception e2) {
                Log.e(c, e2.toString());
            }
        }
        return zVar;
    }

    private void a(z zVar) {
        BatteryManager batteryManager = this.a;
        if (batteryManager != null) {
            int intProperty = batteryManager.getIntProperty(1);
            if (intProperty != Integer.MIN_VALUE) {
                zVar.BatteryCapacity = intProperty;
            }
            int intProperty2 = this.a.getIntProperty(2);
            if (intProperty2 != Integer.MIN_VALUE) {
                zVar.BatteryCurrent = intProperty2;
            }
            long longProperty = this.a.getLongProperty(5);
            if (longProperty != Long.MIN_VALUE) {
                zVar.BatteryRemainingEnergy = longProperty;
            }
        }
    }
}
