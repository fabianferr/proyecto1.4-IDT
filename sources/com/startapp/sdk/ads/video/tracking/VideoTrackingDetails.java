package com.startapp.sdk.ads.video.tracking;

import com.startapp.d9;
import com.startapp.m9;
import com.startapp.q9;
import com.startapp.sdk.ads.video.vast.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Sta */
public class VideoTrackingDetails implements Serializable {
    private static final long serialVersionUID = -1841622077369870410L;
    @d9(type = AbsoluteTrackingLink.class)
    private AbsoluteTrackingLink[] absoluteTrackingUrls;
    @d9(type = ActionTrackingLink.class)
    private ActionTrackingLink[] creativeViewUrls;
    @d9(type = FractionTrackingLink.class)
    private FractionTrackingLink[] fractionTrackingUrls;
    @d9(type = ActionTrackingLink.class)
    private ActionTrackingLink[] impressionUrls;
    @d9(type = ActionTrackingLink.class)
    private ActionTrackingLink[] inlineErrorTrackingUrls;
    private boolean isVAST;
    @d9(type = ActionTrackingLink.class)
    private ActionTrackingLink[] soundMuteUrls;
    @d9(type = ActionTrackingLink.class)
    private ActionTrackingLink[] soundUnmuteUrls;
    @d9(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoClickTrackingUrls;
    @d9(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoClosedUrls;
    @d9(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoPausedUrls;
    @d9(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoPostRollClickTrackingUrls;
    @d9(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoPostRollClosedUrls;
    @d9(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoPostRollImpressionUrls;
    @d9(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoResumedUrls;
    @d9(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoRewardedUrls;
    @d9(type = ActionTrackingLink.class)
    private ActionTrackingLink[] videoSkippedUrls;

    public VideoTrackingDetails() {
    }

    public AbsoluteTrackingLink[] a() {
        return this.absoluteTrackingUrls;
    }

    public ActionTrackingLink[] b() {
        return this.creativeViewUrls;
    }

    public FractionTrackingLink[] c() {
        return this.fractionTrackingUrls;
    }

    public ActionTrackingLink[] d() {
        return this.impressionUrls;
    }

    public ActionTrackingLink[] e() {
        return this.inlineErrorTrackingUrls;
    }

    public ActionTrackingLink[] f() {
        return this.soundMuteUrls;
    }

    public ActionTrackingLink[] g() {
        return this.soundUnmuteUrls;
    }

    public ActionTrackingLink[] h() {
        return this.videoClickTrackingUrls;
    }

    public ActionTrackingLink[] i() {
        return this.videoClosedUrls;
    }

    public ActionTrackingLink[] j() {
        return this.videoPausedUrls;
    }

    public ActionTrackingLink[] k() {
        return this.isVAST ? this.videoPostRollClickTrackingUrls : this.videoClickTrackingUrls;
    }

    public ActionTrackingLink[] l() {
        return this.videoPostRollClosedUrls;
    }

    public ActionTrackingLink[] m() {
        return this.videoPostRollImpressionUrls;
    }

    public ActionTrackingLink[] n() {
        return this.videoResumedUrls;
    }

    public ActionTrackingLink[] o() {
        return this.videoRewardedUrls;
    }

    public ActionTrackingLink[] p() {
        return this.videoSkippedUrls;
    }

    public String toString() {
        return super.toString();
    }

    public VideoTrackingDetails(m9 m9Var) {
        this.isVAST = true;
        this.impressionUrls = b(m9Var.j());
        this.soundMuteUrls = b(m9Var.l());
        this.soundUnmuteUrls = b(m9Var.q());
        this.videoPausedUrls = b(m9Var.m());
        this.videoResumedUrls = b(m9Var.n());
        this.videoSkippedUrls = b(m9Var.p());
        this.videoClosedUrls = b(m9Var.e());
        this.inlineErrorTrackingUrls = b(m9Var.h());
        this.videoClickTrackingUrls = b(m9Var.d());
        this.absoluteTrackingUrls = a(m9Var.a());
        this.fractionTrackingUrls = a(m9Var.i(), m9Var.g());
        a f = m9Var.f();
        if (f != null) {
            this.videoPostRollImpressionUrls = b(f.d());
            this.videoPostRollClickTrackingUrls = b(f.b());
        }
    }

    public static ActionTrackingLink[] b(List<String> list) {
        if (list == null) {
            return new ActionTrackingLink[0];
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String b : list) {
            ActionTrackingLink actionTrackingLink = new ActionTrackingLink();
            actionTrackingLink.b(b);
            actionTrackingLink.a(true);
            actionTrackingLink.a("");
            arrayList.add(actionTrackingLink);
        }
        return (ActionTrackingLink[]) arrayList.toArray(new ActionTrackingLink[0]);
    }

    public final AbsoluteTrackingLink[] a(List<q9<Integer>> list) {
        if (list == null) {
            return new AbsoluteTrackingLink[0];
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (q9 next : list) {
            AbsoluteTrackingLink absoluteTrackingLink = new AbsoluteTrackingLink();
            absoluteTrackingLink.b(next.a);
            if (((Integer) next.b).intValue() != -1) {
                absoluteTrackingLink.a(((Integer) next.b).intValue());
            }
            absoluteTrackingLink.a(true);
            absoluteTrackingLink.a("");
            arrayList.add(absoluteTrackingLink);
        }
        return (AbsoluteTrackingLink[]) arrayList.toArray(new AbsoluteTrackingLink[0]);
    }

    public final FractionTrackingLink[] a(List<q9<Float>> list, List<String> list2) {
        ArrayList arrayList = new ArrayList(list.size());
        for (q9 next : list) {
            FractionTrackingLink fractionTrackingLink = new FractionTrackingLink();
            fractionTrackingLink.b(next.a);
            fractionTrackingLink.a((int) (((Float) next.b).floatValue() * 100.0f));
            fractionTrackingLink.a(true);
            fractionTrackingLink.a("");
            arrayList.add(fractionTrackingLink);
        }
        for (String b : list2) {
            FractionTrackingLink fractionTrackingLink2 = new FractionTrackingLink();
            fractionTrackingLink2.b(b);
            fractionTrackingLink2.a(100);
            fractionTrackingLink2.a(true);
            fractionTrackingLink2.a("");
            arrayList.add(fractionTrackingLink2);
        }
        return arrayList.size() > 0 ? (FractionTrackingLink[]) arrayList.toArray(new FractionTrackingLink[0]) : new FractionTrackingLink[0];
    }
}
