package com.ironsource.sdk.a;

import com.google.android.gms.cast.CastStatusCodes;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

public final class h {
    public static a a = new a(2001, a("initsdk"));
    public static a b = new a(2026, a("sdkrecoverstart"));
    public static a c = new a(2002, a("createcontrollerweb"));
    public static a d = new a(2003, a("createcontrollernative"));
    public static a e = new a(2004, a("controllerstageready"));
    public static a f = new a(2005, a("loadad"));
    public static a g = new a(2006, a("loadadfailed"));
    public static a h = new a(2007, a("initproduct"));
    public static a i = new a(2008, a("initproductfailed"));
    public static a j = new a(2009, a("loadproduct"));
    public static a k = new a(2010, a("parseadmfailed"));
    public static a l = new a(2011, a("loadadsuccess"));
    public static a m = new a(2027, a("destroyproduct"));
    public static a n = new a(2030, a("registerad"));
    public static a o = new a(2013, a("controllerfailed"));
    public static a p = new a(2015, a("appendnativefeaturesdatafailed"));
    public static a q = new a(CastStatusCodes.DEVICE_CONNECTION_SUSPENDED, a("adunitcouldnotloadtowebview"));
    public static a r = new a(2017, a("webviewcleanupfailed"));
    public static a s = new a(2018, a("removewebviewfailed"));
    public static a t = new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_SUCCESS, a("fialedregactlifecycle"));
    public static a u = new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_FAILED, a("loadcontrollerhtml"));
    public static a v = new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_TIMED_OUT, a("controllerhtmlsuccess"));
    public static a w = new a(2024, a("controllerhtmlfailed"));
    public static a x = new a(2025, a("webviewcrashrpg"));
    public static a y = new a(2031, a("getorientationcalled"));

    public static class a {
        String a;
        int b;

        a(int i, String str) {
            this.b = i;
            this.a = str;
        }
    }

    static {
        new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN, a("banneralreadydestroyed"));
    }

    private static String a(String str) {
        return "n_" + str;
    }
}
