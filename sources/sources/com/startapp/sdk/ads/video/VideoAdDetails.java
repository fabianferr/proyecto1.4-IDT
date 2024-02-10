package com.startapp.sdk.ads.video;

import com.startapp.d9;
import com.startapp.m9;
import com.startapp.r9;
import com.startapp.sdk.ads.video.tracking.VideoTrackingDetails;
import com.startapp.sdk.ads.video.vast.a;
import com.startapp.sdk.adsbase.VideoConfig;
import com.startapp.sdk.omsdk.VerificationDetails;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: Sta */
public class VideoAdDetails implements Serializable {
    private static final long serialVersionUID = 4938639129535870268L;
    @d9(type = ArrayList.class, value = VerificationDetails.class)
    private List<VerificationDetails> adVerifications;
    private String clickUrl;
    private boolean clickable;
    private boolean closeable;
    private boolean isVideoMuted;
    private String localVideoPath;
    @d9(type = PostRollType.class)
    private PostRollType postRoll;
    private String postRollClickThroughUrl;
    private String postRollHtml;
    private boolean skippable;
    private long skippableAfter;
    private Long unskipLess;
    @d9(complex = true)
    private VideoTrackingDetails videoTrackingDetails;
    private String videoUrl;

    /* compiled from: Sta */
    public enum PostRollType {
        IMAGE,
        LAST_FRAME,
        NONE
    }

    public VideoAdDetails() {
    }

    public void a(String str) {
        this.localVideoPath = str;
    }

    public String b() {
        return this.clickUrl;
    }

    public String c() {
        return this.localVideoPath;
    }

    public String d() {
        return this.postRollHtml != null ? this.postRollClickThroughUrl : this.clickUrl;
    }

    public String e() {
        return this.postRollHtml;
    }

    public PostRollType f() {
        return this.postRoll;
    }

    public long g() {
        return this.skippableAfter;
    }

    public Long h() {
        return this.unskipLess;
    }

    public VideoTrackingDetails i() {
        return this.videoTrackingDetails;
    }

    public String j() {
        return this.videoUrl;
    }

    public boolean k() {
        return (this.postRoll == PostRollType.NONE && this.postRollHtml == null) ? false : true;
    }

    public boolean l() {
        return this.clickable;
    }

    public boolean m() {
        return this.closeable;
    }

    public boolean n() {
        return this.skippable;
    }

    public boolean o() {
        return this.isVideoMuted;
    }

    public void p() {
        this.skippableAfter = TimeUnit.SECONDS.toMillis(this.skippableAfter);
    }

    public String toString() {
        return super.toString();
    }

    public VideoAdDetails(m9 m9Var, VideoConfig videoConfig, r9 r9Var) {
        long j;
        this.videoTrackingDetails = new VideoTrackingDetails(m9Var);
        this.videoUrl = m9Var.k();
        boolean z = true;
        if (r9Var != null) {
            Long a = r9Var.a();
            Integer o = m9Var.o();
            if (a != null) {
                j = a.longValue();
            } else if (o != null) {
                j = (long) o.intValue();
            } else {
                j = videoConfig.m();
            }
            this.skippableAfter = j;
            this.skippable = true;
            this.unskipLess = r9Var.b();
        } else {
            this.skippable = false;
        }
        String c = m9Var.c();
        this.clickUrl = c;
        this.clickable = c == null ? false : z;
        this.postRoll = PostRollType.NONE;
        a f = m9Var.f();
        if (f != null) {
            this.postRollHtml = f.c().a();
            this.postRollClickThroughUrl = f.a();
        }
        a((List<VerificationDetails>) Collections.unmodifiableList(m9Var.b()));
    }

    public void a(boolean z) {
        this.isVideoMuted = z;
    }

    public List<VerificationDetails> a() {
        return this.adVerifications;
    }

    public void a(List<VerificationDetails> list) {
        this.adVerifications = list;
    }
}
