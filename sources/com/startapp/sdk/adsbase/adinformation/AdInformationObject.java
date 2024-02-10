package com.startapp.sdk.adsbase.adinformation;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.startapp.d;
import com.startapp.sdk.adsbase.adinformation.AdInformationConfig;
import com.startapp.sdk.adsbase.adinformation.AdInformationPositions;
import com.startapp.sdk.adsbase.consent.ConsentData;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.u1;
import java.lang.ref.WeakReference;

/* compiled from: Sta */
public class AdInformationObject implements View.OnClickListener {
    public final WeakReference<Context> a;
    public final AdInformationView b;
    public final AdPreferences.Placement c;
    public final ConsentData d;
    public final String e;
    public final String f;
    public final AdInformationOverrides g;

    /* compiled from: Sta */
    public enum Size {
        SMALL(AdInformationConfig.ImageResourceType.INFO_S, AdInformationConfig.ImageResourceType.INFO_EX_S),
        LARGE(AdInformationConfig.ImageResourceType.INFO_L, AdInformationConfig.ImageResourceType.INFO_EX_L);
        
        private final AdInformationConfig.ImageResourceType infoExtendedType;
        private final AdInformationConfig.ImageResourceType infoType;

        /* access modifiers changed from: public */
        Size(AdInformationConfig.ImageResourceType imageResourceType, AdInformationConfig.ImageResourceType imageResourceType2) {
            this.infoType = imageResourceType;
            this.infoExtendedType = imageResourceType2;
        }

        public AdInformationConfig.ImageResourceType a() {
            return this.infoType;
        }
    }

    /* compiled from: Sta */
    public class a implements View.OnClickListener {
        public final /* synthetic */ d a;

        public a(d dVar) {
            this.a = dVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x007e A[Catch:{ all -> 0x008e }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0081 A[Catch:{ all -> 0x008e }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.view.View r8) {
            /*
                r7 = this;
                com.startapp.d r8 = r7.a
                com.startapp.sdk.adsbase.adinformation.AdInformationObject r0 = com.startapp.sdk.adsbase.adinformation.AdInformationObject.this
                java.lang.String r1 = r0.e
                java.lang.String r0 = r0.f
                com.startapp.i2<com.startapp.sdk.adsbase.remoteconfig.AdDebuggerMetadata> r2 = r8.c
                java.lang.Object r2 = r2.a()
                com.startapp.sdk.adsbase.remoteconfig.AdDebuggerMetadata r2 = (com.startapp.sdk.adsbase.remoteconfig.AdDebuggerMetadata) r2
                if (r2 == 0) goto L_0x002a
                boolean r2 = r2.b()
                if (r2 == 0) goto L_0x002a
                com.startapp.i3 r2 = new com.startapp.i3
                com.startapp.j3 r3 = com.startapp.j3.d
                r2.<init>((com.startapp.j3) r3)
                java.lang.String r3 = "adDebugInfo"
                r2.d = r3
                r2.e = r1
                r2.g = r0
                r2.a()
            L_0x002a:
                r2 = 0
                if (r1 != 0) goto L_0x003b
                if (r0 != 0) goto L_0x003b
                android.content.Context r8 = r8.a
                java.lang.String r0 = "Ad debug info not available"
                android.widget.Toast r8 = android.widget.Toast.makeText(r8, r0, r2)
                r8.show()
                goto L_0x008e
            L_0x003b:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "Ad debug info"
                r3.<init>(r4)
                java.lang.String r5 = "\n"
                r3.append(r5)
                if (r1 == 0) goto L_0x0053
                java.lang.String r6 = "url: "
                r3.append(r6)
                r3.append(r1)
                goto L_0x0055
            L_0x0053:
                java.lang.String r5 = ""
            L_0x0055:
                if (r0 == 0) goto L_0x0062
                r3.append(r5)
                java.lang.String r1 = "d: "
                r3.append(r1)
                r3.append(r0)
            L_0x0062:
                android.content.Context r0 = r8.a     // Catch:{ all -> 0x0079 }
                java.lang.String r1 = "clipboard"
                java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ all -> 0x0079 }
                boolean r1 = r0 instanceof android.content.ClipboardManager     // Catch:{ all -> 0x0079 }
                if (r1 == 0) goto L_0x0079
                android.content.ClipboardManager r0 = (android.content.ClipboardManager) r0     // Catch:{ all -> 0x0079 }
                android.content.ClipData r1 = android.content.ClipData.newPlainText(r4, r3)     // Catch:{ all -> 0x0079 }
                r0.setPrimaryClip(r1)     // Catch:{ all -> 0x0079 }
                r0 = 1
                goto L_0x007a
            L_0x0079:
                r0 = 0
            L_0x007a:
                android.content.Context r8 = r8.a     // Catch:{ all -> 0x008e }
                if (r0 == 0) goto L_0x0081
                java.lang.String r0 = " copied to clipboard"
                goto L_0x0083
            L_0x0081:
                java.lang.String r0 = " printed to logcat"
            L_0x0083:
                java.lang.String r0 = r4.concat(r0)     // Catch:{ all -> 0x008e }
                android.widget.Toast r8 = android.widget.Toast.makeText(r8, r0, r2)     // Catch:{ all -> 0x008e }
                r8.show()     // Catch:{ all -> 0x008e }
            L_0x008e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.adinformation.AdInformationObject.a.onClick(android.view.View):void");
        }
    }

    public AdInformationObject(Context context, Size size, AdPreferences.Placement placement, AdInformationOverrides adInformationOverrides, ConsentData consentData, String str, String str2) {
        this.a = new WeakReference<>(context);
        this.c = placement;
        this.g = adInformationOverrides;
        this.d = consentData;
        this.e = str;
        this.f = str2;
        this.b = new AdInformationView(context, size, placement, adInformationOverrides, this);
    }

    public void a(RelativeLayout relativeLayout) {
        boolean z;
        Context context = relativeLayout.getContext();
        AdInformationConfig a2 = AdInformationMetaData.a.a();
        AdInformationOverrides adInformationOverrides = this.g;
        if (adInformationOverrides == null || !adInformationOverrides.d()) {
            z = a2.b(context);
        } else {
            z = this.g.c();
        }
        if (z) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            AdInformationOverrides adInformationOverrides2 = this.g;
            if (adInformationOverrides2 == null || !adInformationOverrides2.e()) {
                AdPreferences.Placement placement = this.c;
                AdInformationPositions.Position position = a2.Positions.get(placement);
                if (position == null) {
                    position = AdInformationPositions.Position.BOTTOM_LEFT;
                    a2.Positions.put(placement, position);
                }
                position.addRules(layoutParams);
            } else {
                this.g.b().addRules(layoutParams);
            }
            relativeLayout.addView(this.b, layoutParams);
        }
        d a3 = ComponentLocator.a(context).L.a();
        if (a3.a()) {
            TextView textView = new TextView(context);
            textView.setGravity(17);
            textView.setText("D");
            textView.setTypeface(textView.getTypeface(), 1);
            textView.setTextSize(0, ((float) (this.b.c() * 2)) / 3.0f);
            textView.setTextColor(-1);
            textView.setBackgroundColor(Integer.MIN_VALUE);
            RelativeLayout relativeLayout2 = new RelativeLayout(context);
            relativeLayout2.setOnClickListener(new a(a3));
            AdInformationPositions.Position position2 = this.b.f;
            if (position2 == null) {
                position2 = AdInformationPositions.Position.BOTTOM_LEFT;
            }
            AdInformationPositions.Position flipHorizontal = position2.flipHorizontal();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.b.d(), this.b.c());
            layoutParams2.setMargins(0, 0, 0, 0);
            flipHorizontal.addRules(layoutParams2);
            relativeLayout2.addView(textView, layoutParams2);
            AdInformationView adInformationView = this.b;
            float e2 = adInformationView.d.e();
            AdInformationView adInformationView2 = this.b;
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) (e2 * ((float) adInformationView.d())), (int) (adInformationView2.d.e() * ((float) adInformationView2.c())));
            flipHorizontal.addRules(layoutParams3);
            relativeLayout.addView(relativeLayout2, layoutParams3);
        }
    }

    public void onClick(View view) {
        Context context = (Context) this.a.get();
        if (context != null) {
            u1 g2 = ComponentLocator.a(context).g();
            ConsentData consentData = this.d;
            String str = null;
            String c2 = consentData != null ? consentData.c() : null;
            ConsentData consentData2 = this.d;
            String d2 = consentData2 != null ? consentData2.d() : null;
            ConsentData consentData3 = this.d;
            if (consentData3 != null) {
                str = consentData3.b();
            }
            g2.a(true, c2, d2, str);
        }
    }
}
