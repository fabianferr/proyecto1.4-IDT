package com.startapp.sdk.ads.video.vast;

import androidx.media3.common.MimeTypes;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: Sta */
public class VASTResource {
    public static final List<String> f = Arrays.asList(new String[]{"image/jpeg", MimeTypes.IMAGE_PNG, "image/bmp", "image/gif"});
    public static final List<String> g = Collections.singletonList("application/x-javascript");
    public final String a;
    public final Type b;
    public final CreativeType c;
    public final int d;
    public final int e;

    /* compiled from: Sta */
    public enum CreativeType {
        NONE,
        b,
        JAVASCRIPT
    }

    /* compiled from: Sta */
    public enum Type {
        HTML_RESOURCE,
        IFRAME_RESOURCE
    }

    public VASTResource(String str, Type type, CreativeType creativeType, int i, int i2) {
        this.a = str;
        this.b = type;
        this.c = creativeType;
        this.d = i;
        this.e = i2;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html><head><link rel=\"icon\" href=\"data:;base64,iVBORw0KGgo=\" /><style type=\"text/css\"> html, body { background-color: black; height: 100%; margin: 0; } #content { border: 0px; position: absolute; top: 50%; left: 50%; margin: -");
        sb.append(this.e / 2);
        sb.append("px 0 0 -");
        sb.append(this.d / 2);
        sb.append("px; }</style><script>function performClick() { top.location.href = \"https://www.startapp.com\"; }</script></head><body onclick=\"performClick()\">");
        int ordinal = this.b.ordinal();
        if (ordinal == 0) {
            CreativeType creativeType = this.c;
            if (creativeType == CreativeType.b) {
                sb.append("<img id=\"content\"");
                a(sb);
            } else if (creativeType == CreativeType.JAVASCRIPT) {
                sb.append("<script src=\"");
                sb.append(this.a);
                sb.append("\" />");
            }
        } else if (ordinal == 1) {
            return this.a;
        } else {
            if (ordinal == 2) {
                sb.append("<iframe id=\"content\" frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\"");
                a(sb);
            }
        }
        sb.append("</body></html>");
        return sb.toString();
    }

    public final void a(StringBuilder sb) {
        sb.append(" width=\"");
        sb.append(this.d);
        sb.append("\"");
        sb.append(" height=\"");
        sb.append(this.e);
        sb.append("\"");
        sb.append(" src=\"");
        sb.append(this.a);
        sb.append("\" />");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.startapp.sdk.ads.video.vast.VASTResource a(com.startapp.p9 r10, com.startapp.sdk.ads.video.vast.VASTResource.Type r11, int r12, int r13) {
        /*
            java.lang.String r0 = "StaticResource"
            r1 = 0
            com.startapp.p9 r2 = r10.b(r0, r1, r1)
            if (r2 != 0) goto L_0x000a
            goto L_0x0012
        L_0x000a:
            java.lang.String r3 = "creativeType"
            java.lang.String r2 = r2.a(r3)
            if (r2 != 0) goto L_0x0014
        L_0x0012:
            r2 = r1
            goto L_0x0018
        L_0x0014:
            java.lang.String r2 = r2.toLowerCase()
        L_0x0018:
            com.startapp.sdk.ads.video.vast.VASTResource$CreativeType r3 = com.startapp.sdk.ads.video.vast.VASTResource.CreativeType.NONE
            int r4 = r11.ordinal()
            if (r4 == 0) goto L_0x0036
            r0 = 1
            if (r4 == r0) goto L_0x002e
            r0 = 2
            if (r4 == r0) goto L_0x0027
            goto L_0x003c
        L_0x0027:
            java.lang.String r0 = "IFrameResource"
            java.lang.String r10 = r10.f(r0)
            goto L_0x0034
        L_0x002e:
            java.lang.String r0 = "HTMLResource"
            java.lang.String r10 = r10.f(r0)
        L_0x0034:
            r5 = r10
            goto L_0x003d
        L_0x0036:
            java.lang.String r10 = r10.f(r0)
            if (r10 != 0) goto L_0x003f
        L_0x003c:
            r5 = r1
        L_0x003d:
            r7 = r3
            goto L_0x005d
        L_0x003f:
            java.util.List<java.lang.String> r0 = f
            boolean r3 = r0.contains(r2)
            if (r3 != 0) goto L_0x0051
            java.util.List<java.lang.String> r3 = g
            boolean r3 = r3.contains(r2)
            if (r3 == 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r10 = r1
        L_0x0051:
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L_0x005a
            com.startapp.sdk.ads.video.vast.VASTResource$CreativeType r3 = com.startapp.sdk.ads.video.vast.VASTResource.CreativeType.b
            goto L_0x0034
        L_0x005a:
            com.startapp.sdk.ads.video.vast.VASTResource$CreativeType r3 = com.startapp.sdk.ads.video.vast.VASTResource.CreativeType.JAVASCRIPT
            goto L_0x0034
        L_0x005d:
            if (r5 != 0) goto L_0x0060
            return r1
        L_0x0060:
            com.startapp.sdk.ads.video.vast.VASTResource r10 = new com.startapp.sdk.ads.video.vast.VASTResource
            r4 = r10
            r6 = r11
            r8 = r12
            r9 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.video.vast.VASTResource.a(com.startapp.p9, com.startapp.sdk.ads.video.vast.VASTResource$Type, int, int):com.startapp.sdk.ads.video.vast.VASTResource");
    }
}
