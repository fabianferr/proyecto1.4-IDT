package com.bytedance.sdk.openadsdk.core.g.a.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.g.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VastAdVerificationsParser */
public class d {
    public static Set<j> a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        j a;
        if (xmlPullParser == null) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if ("Verification".equals(xmlPullParser.getName())) {
                    String attributeValue = xmlPullParser.getAttributeValue(e.g, "vendor");
                    String str = null;
                    String str2 = null;
                    String str3 = null;
                    while (true) {
                        if (xmlPullParser.getEventType() != 3 || !"Verification".equals(xmlPullParser.getName())) {
                            xmlPullParser.next();
                            if (xmlPullParser.getEventType() == 2) {
                                String name = xmlPullParser.getName();
                                name.hashCode();
                                char c = 65535;
                                switch (name.hashCode()) {
                                    case 1335132887:
                                        if (name.equals("Tracking")) {
                                            c = 0;
                                            break;
                                        }
                                        break;
                                    case 1561251035:
                                        if (name.equals("JavaScriptResource")) {
                                            c = 1;
                                            break;
                                        }
                                        break;
                                    case 1749252741:
                                        if (name.equals("VerificationParameters")) {
                                            c = 2;
                                            break;
                                        }
                                        break;
                                }
                                switch (c) {
                                    case 0:
                                        if (!"verificationNotExecuted".equals(xmlPullParser.getAttributeValue(e.g, "event"))) {
                                            break;
                                        } else {
                                            str3 = e.b(xmlPullParser, "Tracking");
                                            break;
                                        }
                                    case 1:
                                        if (!CampaignEx.KEY_OMID.equals(xmlPullParser.getAttributeValue(e.g, "apiFramework"))) {
                                            break;
                                        } else {
                                            str = e.b(xmlPullParser, "JavaScriptResource");
                                            break;
                                        }
                                    case 2:
                                        str2 = e.b(xmlPullParser, "VerificationParameters");
                                        break;
                                }
                            }
                        } else if (!TextUtils.isEmpty(str) && (a = j.a(CampaignEx.KEY_OMID, str, attributeValue, str2, str3)) != null) {
                            hashSet.add(a);
                        }
                    }
                } else {
                    e.a(xmlPullParser);
                }
            }
        }
        return hashSet;
    }
}
