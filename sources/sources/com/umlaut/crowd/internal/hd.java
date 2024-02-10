package com.umlaut.crowd.internal;

import android.util.Log;
import android.util.Xml;
import com.umlaut.crowd.internal.z7;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class hd {
    private static final String a = null;
    private static final String b = "\r\n";

    public static String a(String str) {
        return a(str, "LOCATION: ");
    }

    private static void c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() == 2) {
            int i = 1;
            while (i != 0) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    i++;
                } else if (next == 3) {
                    i--;
                }
            }
            return;
        }
        throw new IllegalStateException();
    }

    private static String b(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (xmlPullParser.next() != 4) {
            return "";
        }
        String text = xmlPullParser.getText();
        xmlPullParser.nextTag();
        return text;
    }

    private static String a(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return "";
        }
        int length = indexOf + str2.length();
        return str.substring(length, str.indexOf(b, length));
    }

    public static z7.b a(InputStream inputStream) throws XmlPullParserException, IOException {
        z7.b bVar = new z7.b();
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            newPullParser.setInput(inputStream, (String) null);
            newPullParser.nextTag();
            newPullParser.require(2, a, "root");
            while (true) {
                if (newPullParser.next() == 3) {
                    break;
                } else if (newPullParser.getEventType() == 2) {
                    if (newPullParser.getName().equals("device")) {
                        bVar = a(newPullParser);
                        break;
                    }
                    c(newPullParser);
                }
            }
            inputStream.close();
        } catch (XmlPullParserException e) {
            Log.d("XmlPullParserException", e.getLocalizedMessage());
        } catch (IOException e2) {
            Log.d("IOException", e2.getLocalizedMessage());
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
        return bVar;
        inputStream.close();
        return bVar;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        if (r1.equals("friendlyName") == false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.umlaut.crowd.internal.z7.b a(org.xmlpull.v1.XmlPullParser r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            com.umlaut.crowd.internal.z7$b r0 = new com.umlaut.crowd.internal.z7$b
            r0.<init>()
            java.lang.String r1 = a
            java.lang.String r2 = "device"
            r3 = 2
            r11.require(r3, r1, r2)
        L_0x000d:
            int r1 = r11.next()
            r2 = 3
            if (r1 == r2) goto L_0x00ad
            int r1 = r11.getEventType()
            if (r1 == r3) goto L_0x001b
            goto L_0x000d
        L_0x001b:
            java.lang.String r1 = r11.getName()
            r1.hashCode()
            r1.hashCode()
            int r4 = r1.hashCode()
            java.lang.String r5 = "friendlyName"
            java.lang.String r6 = "UDN"
            r7 = 1
            java.lang.String r8 = "manufacturer"
            java.lang.String r9 = "modelName"
            r10 = -1
            switch(r4) {
                case -2010829484: goto L_0x0051;
                case -1969347631: goto L_0x0048;
                case 83871: goto L_0x003f;
                case 461933014: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            r2 = -1
            goto L_0x0059
        L_0x0038:
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x0059
            goto L_0x0036
        L_0x003f:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x0046
            goto L_0x0036
        L_0x0046:
            r2 = 2
            goto L_0x0059
        L_0x0048:
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x004f
            goto L_0x0036
        L_0x004f:
            r2 = 1
            goto L_0x0059
        L_0x0051:
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x0058
            goto L_0x0036
        L_0x0058:
            r2 = 0
        L_0x0059:
            switch(r2) {
                case 0: goto L_0x00a1;
                case 1: goto L_0x0095;
                case 2: goto L_0x006b;
                case 3: goto L_0x0060;
                default: goto L_0x005c;
            }
        L_0x005c:
            c(r11)
            goto L_0x000d
        L_0x0060:
            java.lang.String r1 = a((org.xmlpull.v1.XmlPullParser) r11, (java.lang.String) r5)
            java.lang.String r1 = com.umlaut.crowd.internal.aa.a((java.lang.String) r1)
            r0.c = r1
            goto L_0x000d
        L_0x006b:
            java.lang.String r1 = a((org.xmlpull.v1.XmlPullParser) r11, (java.lang.String) r6)
            java.lang.String r2 = "-"
            java.lang.String[] r1 = r1.split(r2)
            int r2 = r1.length
            int r2 = r2 - r7
            r1 = r1[r2]
            java.lang.String r1 = r1.toLowerCase()
            java.lang.String r2 = ":"
            boolean r2 = r1.contains(r2)
            if (r2 != 0) goto L_0x008d
            java.lang.String r2 = "(..)(?!$)"
            java.lang.String r4 = "$1:"
            java.lang.String r1 = r1.replaceAll(r2, r4)
        L_0x008d:
            java.lang.String r1 = com.umlaut.crowd.internal.aa.a((java.lang.String) r1)
            r0.b = r1
            goto L_0x000d
        L_0x0095:
            java.lang.String r1 = a((org.xmlpull.v1.XmlPullParser) r11, (java.lang.String) r8)
            java.lang.String r1 = com.umlaut.crowd.internal.aa.a((java.lang.String) r1)
            r0.e = r1
            goto L_0x000d
        L_0x00a1:
            java.lang.String r1 = a((org.xmlpull.v1.XmlPullParser) r11, (java.lang.String) r9)
            java.lang.String r1 = com.umlaut.crowd.internal.aa.a((java.lang.String) r1)
            r0.d = r1
            goto L_0x000d
        L_0x00ad:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.hd.a(org.xmlpull.v1.XmlPullParser):com.umlaut.crowd.internal.z7$b");
    }

    private static String a(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        String str2 = a;
        xmlPullParser.require(2, str2, str);
        String b2 = b(xmlPullParser);
        xmlPullParser.require(3, str2, str);
        return b2;
    }
}
