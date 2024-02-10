package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class IronSourceSegment {
    public static final String AGE = "age";
    public static final String GENDER = "gen";
    public static final String IAPT = "iapt";
    public static final String LEVEL = "lvl";
    public static final String PAYING = "pay";
    public static final String USER_CREATION_DATE = "ucd";
    private String a;
    private int b = 999999;
    private double c = 999999.99d;
    private final String d = "custom";
    private final int e = 5;
    private int f = -1;
    private String g;
    private int h = -1;
    private AtomicBoolean i = null;
    private double j = -1.0d;
    private long k = 0;
    private ArrayList<Pair<String, String>> l = new ArrayList<>();

    private static boolean a(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]*$");
    }

    private static boolean a(String str, int i2, int i3) {
        return str != null && str.length() > 0 && str.length() <= 32;
    }

    public int getAge() {
        return this.f;
    }

    public String getGender() {
        return this.g;
    }

    public double getIapt() {
        return this.j;
    }

    public AtomicBoolean getIsPaying() {
        return this.i;
    }

    public int getLevel() {
        return this.h;
    }

    public ArrayList<Pair<String, String>> getSegmentData() {
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        if (this.f != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f);
            arrayList.add(new Pair(AGE, sb.toString()));
        }
        if (!TextUtils.isEmpty(this.g)) {
            arrayList.add(new Pair(GENDER, this.g));
        }
        if (this.h != -1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.h);
            arrayList.add(new Pair(LEVEL, sb2.toString()));
        }
        if (this.i != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.i);
            arrayList.add(new Pair(PAYING, sb3.toString()));
        }
        if (this.j != -1.0d) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.j);
            arrayList.add(new Pair(IAPT, sb4.toString()));
        }
        if (this.k != 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.k);
            arrayList.add(new Pair(USER_CREATION_DATE, sb5.toString()));
        }
        if (!TextUtils.isEmpty(this.a)) {
            arrayList.add(new Pair("segName", this.a));
        }
        arrayList.addAll(this.l);
        return arrayList;
    }

    public String getSegmentName() {
        return this.a;
    }

    public long getUcd() {
        return this.k;
    }

    public void setAge(int i2) {
        if (i2 <= 0 || i2 > 199) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            logger.log(ironSourceTag, "setAge( " + i2 + " ) age must be between 1-199", 2);
            return;
        }
        this.f = i2;
    }

    public void setCustom(String str, String str2) {
        try {
            if (!a(str) || !a(str2) || !a(str, 1, 32) || !a(str2, 1, 32)) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "setCustom( " + str + " , " + str2 + " ) key and value must be alphanumeric and 1-32 in length", 2);
                return;
            }
            String str3 = "custom_" + str;
            if (this.l.size() >= 5) {
                this.l.remove(0);
            }
            this.l.add(new Pair(str3, str2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setGender(String str) {
        if (TextUtils.isEmpty(str) || (!StringUtils.toLowerCase(str).equals("male") && !StringUtils.toLowerCase(str).equals("female"))) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            logger.log(ironSourceTag, "setGender( " + str + " ) is invalid", 2);
            return;
        }
        this.g = str;
    }

    public void setIAPTotal(double d2) {
        if (d2 <= 0.0d || d2 >= this.c) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            logger.log(ironSourceTag, "setIAPTotal( " + d2 + " ) iapt must be between 0-" + this.c, 2);
            return;
        }
        this.j = Math.floor(d2 * 100.0d) / 100.0d;
    }

    public void setIsPaying(boolean z) {
        if (this.i == null) {
            this.i = new AtomicBoolean();
        }
        this.i.set(z);
    }

    public void setLevel(int i2) {
        if (i2 <= 0 || i2 >= this.b) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            logger.log(ironSourceTag, "setLevel( " + i2 + " ) level must be between 1-" + this.b, 2);
            return;
        }
        this.h = i2;
    }

    public void setSegmentName(String str) {
        if (!a(str) || !a(str, 1, 32)) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            logger.log(ironSourceTag, "setSegmentName( " + str + " ) segment name must be alphanumeric and 1-32 in length", 2);
            return;
        }
        this.a = str;
    }

    public void setUserCreationDate(long j2) {
        if (j2 > 0) {
            this.k = j2;
            return;
        }
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "setUserCreationDate( " + j2 + " ) is an invalid timestamp", 2);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        Iterator<Pair<String, String>> it = getSegmentData().iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            try {
                jSONObject.put((String) next.first, next.second);
            } catch (JSONException e2) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("exception " + e2.getMessage());
            }
        }
        return jSONObject;
    }
}
