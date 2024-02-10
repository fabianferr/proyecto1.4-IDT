package com.mbridge.msdk.foundation.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.applovin.impl.sdk.utils.Utils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: SameSDKTool */
public final class ae extends i {
    public static boolean a = false;
    public static char[] b = {'a', 'n', 'd', 'r', 'o', 'i', 'd', 'c', 'o', 'n', 't', 'e', 'n', 't', 'p', 'm', 'g', 'e', 't', 'C', 'o', 'n', 't', 'e', 'x', 't'};
    public static LinearLayout c;

    /* compiled from: SameSDKTool */
    public static class a {
        private static Intent a(Context context) {
            return new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.package.name"));
        }

        private static List<ResolveInfo> b(Context context) {
            try {
                return context.getPackageManager().queryIntentActivities(a(context), 0);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static boolean a(String str) {
            return b(str) || c(str);
        }

        public static boolean b(String str) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return Uri.parse(str).getScheme().equals(Utils.PLAY_STORE_SCHEME);
                }
                return false;
            } catch (Throwable th) {
                aa.d("SDKUtil", Log.getStackTraceString(th));
                return false;
            }
        }

        private static boolean c(String str) {
            Uri parse;
            try {
                if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getHost())) {
                    return false;
                }
                if (parse.getHost().equals("play.google.com") || parse.getHost().equals("market.android.com")) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                aa.d("SDKUtil", Log.getStackTraceString(th));
            }
            return false;
        }

        public static boolean a(Context context, String str, NativeListener.NativeTrackingListener nativeTrackingListener) {
            try {
                List<ResolveInfo> b = b(context);
                if (b != null) {
                    if (b.size() > 0) {
                        if (!b(str)) {
                            if (c(str)) {
                                str = "market://" + str.substring(str.indexOf("details?id="));
                            } else {
                                str = null;
                            }
                        }
                        if (TextUtils.isEmpty(str)) {
                            return false;
                        }
                        Intent a = a(context);
                        a.setData(Uri.parse(str));
                        a.addFlags(268435456);
                        Iterator<ResolveInfo> it = b.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next().activityInfo.packageName.equals("com.android.vending")) {
                                    a.setPackage("com.android.vending");
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        context.startActivity(a);
                        ae.a((BaseTrackingListener) nativeTrackingListener);
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                aa.d("SDKUtil", Log.getStackTraceString(th));
                return false;
            }
        }
    }

    public static void a(BaseTrackingListener baseTrackingListener) {
        if (baseTrackingListener instanceof NativeListener.TrackingExListener) {
            ((NativeListener.TrackingExListener) baseTrackingListener).onLeaveApp();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|(2:12|(2:14|(2:26|16))(0))|17|18|19|20|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r8, java.lang.String r9, com.mbridge.msdk.out.NativeListener.NativeTrackingListener r10) {
        /*
            java.lang.String r0 = "com.android.vending"
            android.content.Intent r1 = new android.content.Intent     // Catch:{ Exception -> 0x009f }
            java.lang.String r2 = "android.intent.action.VIEW"
            android.net.Uri r3 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x009f }
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x009f }
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r1.addFlags(r2)     // Catch:{ Exception -> 0x009f }
            android.content.pm.PackageManager r2 = r8.getPackageManager()     // Catch:{ Exception -> 0x009f }
            r3 = 0
            java.util.List r2 = r2.queryIntentActivities(r1, r3)     // Catch:{ Exception -> 0x009f }
            int r4 = r2.size()     // Catch:{ Exception -> 0x009f }
            if (r4 <= 0) goto L_0x0022
            r3 = 1
        L_0x0022:
            java.lang.String r4 = "market://"
            boolean r4 = r9.startsWith(r4)     // Catch:{ Exception -> 0x009f }
            java.lang.String r5 = ""
            java.lang.String r6 = "market://details?id="
            java.lang.String r7 = "https://play.google.com/store/apps/details?id="
            if (r4 == 0) goto L_0x0083
            if (r3 != 0) goto L_0x0046
            java.lang.String r9 = r9.replace(r6, r5)     // Catch:{ Exception -> 0x009f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009f }
            r0.<init>(r7)     // Catch:{ Exception -> 0x009f }
            r0.append(r9)     // Catch:{ Exception -> 0x009f }
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x009f }
            a((android.content.Context) r8, (java.lang.String) r9, (com.mbridge.msdk.out.BaseTrackingListener) r10)     // Catch:{ Exception -> 0x009f }
            goto L_0x00a9
        L_0x0046:
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x009f }
        L_0x004a:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x009f }
            if (r3 == 0) goto L_0x0065
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x009f }
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3     // Catch:{ Exception -> 0x009f }
            android.content.pm.ActivityInfo r3 = r3.activityInfo     // Catch:{ Exception -> 0x009f }
            java.lang.String r3 = r3.packageName     // Catch:{ Exception -> 0x009f }
            boolean r3 = r3.equals(r0)     // Catch:{ Exception -> 0x009f }
            if (r3 == 0) goto L_0x004a
            java.lang.String r2 = "com.android.vending.AssetBrowserActivity"
            r1.setClassName(r0, r2)     // Catch:{ Exception -> 0x009f }
        L_0x0065:
            r8.startActivity(r1)     // Catch:{ Exception -> 0x006c }
            a((com.mbridge.msdk.out.BaseTrackingListener) r10)     // Catch:{ Exception -> 0x006c }
            goto L_0x00a9
        L_0x006c:
            java.lang.String r9 = r9.replace(r6, r5)     // Catch:{ Exception -> 0x009f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009f }
            r0.<init>()     // Catch:{ Exception -> 0x009f }
            r0.append(r7)     // Catch:{ Exception -> 0x009f }
            r0.append(r9)     // Catch:{ Exception -> 0x009f }
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x009f }
            a((android.content.Context) r8, (java.lang.String) r9, (com.mbridge.msdk.out.BaseTrackingListener) r10)     // Catch:{ Exception -> 0x009f }
            goto L_0x00a9
        L_0x0083:
            java.lang.String r0 = "https://play.google.com/"
            boolean r0 = r9.startsWith(r0)     // Catch:{ Exception -> 0x009f }
            if (r0 == 0) goto L_0x00a9
            java.lang.String r9 = r9.replace(r7, r5)     // Catch:{ Exception -> 0x009f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009f }
            r0.<init>(r6)     // Catch:{ Exception -> 0x009f }
            r0.append(r9)     // Catch:{ Exception -> 0x009f }
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x009f }
            a((android.content.Context) r8, (java.lang.String) r9, (com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r10)     // Catch:{ Exception -> 0x009f }
            goto L_0x00a9
        L_0x009f:
            r8 = move-exception
            java.lang.String r9 = "SDKUtil"
            java.lang.String r8 = r8.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r9, r8)
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ae.a(android.content.Context, java.lang.String, com.mbridge.msdk.out.NativeListener$NativeTrackingListener):void");
    }

    public static void a(Context context, String str, CampaignEx campaignEx, com.mbridge.msdk.click.a aVar, BaseTrackingListener baseTrackingListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "4");
        try {
            BrowserView browserView = new BrowserView(b.d().g(), campaignEx);
            browserView.setLayoutParams(new LinearLayout.LayoutParams(w.l(context), w.m(context)));
            browserView.setListener(new com.mbridge.msdk.foundation.webview.a(context, campaignEx, aVar, browserView, baseTrackingListener));
            browserView.loadUrl(str);
            hashMap.put(IronSourceConstants.EVENTS_RESULT, "1");
        } catch (Exception e) {
            aa.d("SDKUtil", e.getMessage());
            hashMap.put(IronSourceConstants.EVENTS_RESULT, "2");
        }
        try {
            m.a().a("2000150", campaignEx, (Map<String, String>) hashMap);
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, String str, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener) {
        String str2;
        if (context != null) {
            HashMap hashMap = new HashMap();
            if (campaignEx != null) {
                str2 = campaignEx.getCurrentLRid();
            } else {
                str2 = "";
            }
            if (a) {
                a(context, str, (BaseTrackingListener) nativeTrackingListener, str2);
                return;
            }
            try {
                Class.forName("com.mbridge.msdk.activity.MBCommonActivity");
                Intent intent = new Intent(context, Class.forName("com.mbridge.msdk.activity.MBCommonActivity"));
                if (!TextUtils.isEmpty(str)) {
                    if (a.b(str)) {
                        str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
                    }
                    intent.putExtra("url", str);
                    aa.b("url", "webview url = " + str);
                    intent.setFlags(268435456);
                    intent.putExtra("mvcommon", campaignEx);
                    context.startActivity(intent);
                    hashMap.put(IronSourceConstants.EVENTS_RESULT, "1");
                    try {
                        hashMap.put("type", CampaignEx.CLICKMODE_ON);
                        m.a().a("2000150", str2, (Map<String, String>) hashMap);
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                hashMap.put(IronSourceConstants.EVENTS_RESULT, "2");
                a(context, str, (BaseTrackingListener) nativeTrackingListener, str2);
            }
        }
    }

    public static void a(Context context, String str, BaseTrackingListener baseTrackingListener) {
        a(context, str, baseTrackingListener, "");
    }

    public static void a(Context context, String str, BaseTrackingListener baseTrackingListener, String str2) {
        if (str != null && context != null) {
            HashMap hashMap = new HashMap();
            try {
                if (a.b(str)) {
                    str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(268435456);
                ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
                if (resolveActivity != null) {
                    intent.setClassName(resolveActivity.activityInfo.packageName, resolveActivity.activityInfo.name);
                }
                context.startActivity(intent);
                a(baseTrackingListener);
                hashMap.put(IronSourceConstants.EVENTS_RESULT, "1");
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent2.addFlags(268468224);
                    context.startActivity(intent2);
                    a(baseTrackingListener);
                    hashMap.put(IronSourceConstants.EVENTS_RESULT, "1");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    hashMap.put(IronSourceConstants.EVENTS_RESULT, "2");
                }
            }
            try {
                hashMap.put("type", CampaignEx.CLICKMODE_ON);
                m.a().a("2000150", str2, (Map<String, String>) hashMap);
            } catch (Exception unused) {
            }
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File a2 = e.a(c.MBRIDGE_700_IMG);
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            if (str.lastIndexOf("/") == -1) {
                str2 = str.hashCode() + str2;
            } else {
                str2 = (str.hashCode() + str.substring(str.lastIndexOf("/") + 1).hashCode()) + str2;
            }
        }
        return new File(a2, str2).getAbsolutePath();
    }

    public static void a(Campaign campaign, ViewGroup viewGroup) {
        a(campaign, viewGroup, 0, 0);
    }

    public static void a(Campaign campaign, ViewGroup viewGroup, int i, int i2) {
        if (campaign != null) {
            CampaignEx campaignEx = (CampaignEx) campaign;
            if (campaignEx.getLinkType() != 8 || campaignEx.getAabEntity() == null || campaignEx.getAabEntity().getHlp() != 1) {
                return;
            }
            if (viewGroup == null) {
                aa.c("SDKUtil", "show linkType==8 loading view failed. viewGroup is null");
                return;
            }
            try {
                if (c == null) {
                    Context g = b.d().g();
                    if (g instanceof Activity) {
                        c = (LinearLayout) LayoutInflater.from(g.getApplicationContext()).inflate(t.a(g.getApplicationContext(), "mbridge_cm_loading_layout", "layout"), (ViewGroup) null);
                    } else {
                        c = (LinearLayout) LayoutInflater.from(g).inflate(t.a(g, "mbridge_cm_loading_layout", "layout"), (ViewGroup) null);
                    }
                }
                int min = Math.min(viewGroup.getWidth(), viewGroup.getHeight());
                int min2 = Math.min(Math.max(min / 4, 70), min);
                if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(min2, min2);
                    layoutParams.gravity = 17;
                    ao.a(c);
                    viewGroup.addView(c, layoutParams);
                    return;
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(min2, min2);
                if (i2 == 0 && i == 0) {
                    layoutParams2.addRule(13);
                } else {
                    layoutParams2.leftMargin = i2;
                    layoutParams2.topMargin = i;
                }
                ao.a(c);
                viewGroup.addView(c, layoutParams2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(Campaign campaign, ViewGroup viewGroup) {
        if (campaign != null) {
            CampaignEx campaignEx = (CampaignEx) campaign;
            if (campaignEx.getLinkType() != 8 || campaignEx.getAabEntity() == null || campaignEx.getAabEntity().getHlp() != 1) {
                return;
            }
            if (viewGroup == null) {
                aa.c("SDKUtil", "hide linkType==8 loading view failed. viewGroup is null");
                return;
            }
            try {
                LinearLayout linearLayout = c;
                if (linearLayout != null) {
                    viewGroup.removeView(linearLayout);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
