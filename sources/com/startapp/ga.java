package com.startapp;

import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.startapp.sdk.ads.video.tracking.VideoTrackingLink;
import com.startapp.sdk.ads.video.tracking.VideoTrackingParams;
import com.startapp.sdk.ads.video.vast.VASTErrorCodes;
import com.startapp.sdk.adsbase.a;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: Sta */
public class ga {
    public VideoTrackingLink[] a;
    public VideoTrackingParams b;
    public String c;
    public int d;
    public String e = "";
    public VASTErrorCodes f;

    public ga(VideoTrackingLink[] videoTrackingLinkArr, VideoTrackingParams videoTrackingParams, String str, int i) {
        this.a = videoTrackingLinkArr;
        this.b = videoTrackingParams;
        this.c = str;
        this.d = i;
    }

    public fa a() {
        Object obj;
        Object obj2 = null;
        if (!((this.a == null || this.b == null) ? false : true)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        VideoTrackingLink[] videoTrackingLinkArr = this.a;
        int length = videoTrackingLinkArr.length;
        int i = 0;
        while (i < length) {
            VideoTrackingLink videoTrackingLink = videoTrackingLinkArr[i];
            if (videoTrackingLink.c() == null || (this.b.b() > 0 && !videoTrackingLink.d())) {
                obj = obj2;
            } else {
                StringBuilder sb = new StringBuilder();
                VideoTrackingLink.TrackingSource b2 = videoTrackingLink.b();
                if (b2 == null) {
                    if (k9.c(videoTrackingLink.c())) {
                        b2 = VideoTrackingLink.TrackingSource.STARTAPP;
                    } else {
                        b2 = VideoTrackingLink.TrackingSource.EXTERNAL;
                    }
                }
                VideoTrackingParams videoTrackingParams = this.b;
                videoTrackingParams.internalParamsIndicator = b2 == VideoTrackingLink.TrackingSource.STARTAPP;
                VideoTrackingParams c2 = videoTrackingParams.a(videoTrackingLink.d()).c(videoTrackingLink.a());
                String c3 = videoTrackingLink.c();
                String str = this.c;
                String replace = c3.replace("[ASSETURI]", str != null ? TextUtils.htmlEncode(str) : "");
                int i2 = this.d;
                long convert = TimeUnit.SECONDS.convert((long) i2, TimeUnit.MILLISECONDS);
                long j = (long) (i2 % 1000);
                Locale locale = Locale.US;
                String replace2 = replace.replace("[CONTENTPLAYHEAD]", TextUtils.htmlEncode(String.format(locale, "%02d:%02d:%02d.%03d", new Object[]{Long.valueOf(convert / 3600), Long.valueOf((convert % 3600) / 60), Long.valueOf(convert % 60), Long.valueOf(j)}))).replace("[CACHEBUSTING]", TextUtils.htmlEncode(String.valueOf(new SecureRandom().nextInt(90000000) + 10000000)));
                String format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", locale).format(new Date());
                int length2 = format.length() - 2;
                String replace3 = replace2.replace("[TIMESTAMP]", TextUtils.htmlEncode(format.substring(0, length2) + CertificateUtil.DELIMITER + format.substring(length2)));
                VASTErrorCodes vASTErrorCodes = this.f;
                if (vASTErrorCodes != null) {
                    replace3 = replace3.replace("[ERRORCODE]", String.valueOf(vASTErrorCodes.a()));
                }
                sb.append(replace3);
                sb.append(c2.e());
                if (c2.internalParamsIndicator) {
                    obj = null;
                    sb.append(a.c(a.a(c3, (String) null)));
                } else {
                    obj = null;
                }
                arrayList.add(sb.toString());
            }
            i++;
            obj2 = obj;
        }
        return new fa(arrayList, this.e);
    }
}
