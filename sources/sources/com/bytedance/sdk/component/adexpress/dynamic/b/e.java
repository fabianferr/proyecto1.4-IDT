package com.bytedance.sdk.component.adexpress.dynamic.b;

import android.text.TextUtils;
import com.google.android.gms.cast.MediaTrack;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DynamicLayoutBrick */
public class e {
    public static final Map<String, Integer> a;
    private String b;
    private String c;
    private f d;
    private f e;
    private String f;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("root", 8);
        hashMap.put("footer", 6);
        hashMap.put("empty", 6);
        hashMap.put("title", 0);
        hashMap.put(MediaTrack.ROLE_SUBTITLE, 0);
        hashMap.put("source", 0);
        hashMap.put("score-count", 0);
        hashMap.put("text_star", 0);
        hashMap.put("text", 0);
        hashMap.put("tag-group", 17);
        hashMap.put("app-version", 0);
        hashMap.put("development-name", 0);
        hashMap.put("privacy-detail", 23);
        hashMap.put("image", 1);
        hashMap.put("image-wide", 1);
        hashMap.put("image-square", 1);
        hashMap.put("image-long", 1);
        hashMap.put("image-splash", 1);
        hashMap.put("image-cover", 1);
        hashMap.put("app-icon", 1);
        hashMap.put("icon-download", 1);
        hashMap.put("logoad", 4);
        hashMap.put("logounion", 5);
        hashMap.put("logo-union", 9);
        hashMap.put("dislike", 3);
        hashMap.put("close", 3);
        hashMap.put("close-fill", 3);
        hashMap.put("webview-close", 22);
        hashMap.put("feedback-dislike", 12);
        hashMap.put("button", 2);
        hashMap.put("downloadWithIcon", 2);
        hashMap.put("downloadButton", 2);
        hashMap.put("fillButton", 2);
        hashMap.put("laceButton", 2);
        hashMap.put("cardButton", 2);
        hashMap.put("colourMixtureButton", 2);
        hashMap.put("arrowButton", 1);
        hashMap.put("download-progress-button", 2);
        hashMap.put("vessel", 6);
        hashMap.put("image-group", 6);
        hashMap.put("custom-component-vessel", 6);
        hashMap.put("carousel", 24);
        hashMap.put("carousel-vessel", 26);
        hashMap.put("leisure-interact", 25);
        hashMap.put("video-hd", 7);
        hashMap.put("video", 7);
        hashMap.put("video-vd", 7);
        hashMap.put("video-sq", 7);
        hashMap.put("muted", 10);
        hashMap.put("star", 11);
        hashMap.put("skip-countdowns", 19);
        hashMap.put("skip-with-countdowns-skip-btn", 21);
        hashMap.put("skip-with-countdowns-video-countdown", 13);
        hashMap.put("skip-with-countdowns-skip-countdown", 20);
        hashMap.put("skip-with-time", 14);
        hashMap.put("skip-with-time-countdown", 13);
        hashMap.put("skip-with-time-skip-btn", 15);
        hashMap.put("skip", 27);
        hashMap.put("timedown", 13);
        hashMap.put(RewardPlus.ICON, 16);
        hashMap.put("scoreCountWithIcon", 6);
        hashMap.put("split-line", 18);
        hashMap.put("creative-playable-bait", 0);
        hashMap.put("score-count-type-2", 0);
    }

    public int a() {
        if (TextUtils.isEmpty(this.b)) {
            return 0;
        }
        if (this.b.equals("logo")) {
            String str = this.b + this.c;
            this.b = str;
            if (str.contains("logoad")) {
                return 4;
            }
            if (this.b.contains("logounion")) {
                return 5;
            }
        }
        Map<String, Integer> map = a;
        if (map.get(this.b) != null) {
            return map.get(this.b).intValue();
        }
        return -1;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.f = str;
    }

    public String d() {
        return this.f;
    }

    public f e() {
        return this.d;
    }

    public int f() {
        return this.d.ai();
    }

    public void a(f fVar) {
        this.d = fVar;
    }

    public void b(f fVar) {
        this.e = fVar;
    }

    public f g() {
        return this.e;
    }

    public String toString() {
        return "DynamicLayoutBrick{type='" + this.b + "', data='" + this.c + "', value=" + this.d + ", themeValue=" + this.e + ", dataExtraInfo='" + this.f + "'}";
    }
}
