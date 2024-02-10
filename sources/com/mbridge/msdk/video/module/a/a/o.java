package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.module.a.a.k;
import com.mbridge.msdk.video.module.b.b;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;
import java.util.Map;

/* compiled from: VideoViewStatisticsListener */
public class o extends k {
    protected int k = 0;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p = false;
    private Map<Integer, String> q;
    private int r = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(CampaignEx campaignEx, c cVar, a aVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i, boolean z) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i, z);
        if (this.a) {
            this.q = campaignEx.getAdvImpList();
        }
        this.k = campaignEx.getVideoCompleteTime();
    }

    public void a(int i, final Object obj) {
        int i2;
        if (i != 2) {
            if (i != 130) {
                if (i != 6) {
                    if (i != 7) {
                        int i3 = 0;
                        if (i == 15) {
                            g();
                            f();
                            e();
                            if (obj == null || !(obj instanceof MBridgeVideoView.a)) {
                                i2 = 0;
                            } else {
                                int i4 = ((MBridgeVideoView.a) obj).a;
                                i3 = ((MBridgeVideoView.a) obj).b;
                                i2 = i4;
                            }
                            if (i3 == 0 && this.b != null) {
                                i3 = this.b.getVideoLength();
                            }
                            b.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.b, i2, i3, this.j);
                            b.a(this.b, this.q, this.g, i2);
                            if (!this.o) {
                                this.o = true;
                                b.a(this.b, this.g);
                            }
                            if (!this.p) {
                                int i5 = this.k;
                                if (i5 != 0) {
                                    i3 = i5;
                                }
                                if (i2 >= i3) {
                                    this.p = true;
                                    i = 17;
                                }
                            }
                            aa.d("NotifyListener", "onPlayProgress:" + i2);
                            this.r = i2;
                        } else if (i != 16) {
                            switch (i) {
                                case 11:
                                    com.mbridge.msdk.videocommon.download.c.getInstance().b(false);
                                    d();
                                    break;
                                case 12:
                                    AnonymousClass1 r0 = new Runnable() {
                                        public final void run() {
                                            Object obj = obj;
                                            if (obj != null && (obj instanceof String)) {
                                                o.this.a((String) obj);
                                            }
                                        }
                                    };
                                    com.mbridge.msdk.foundation.controller.c.a();
                                    com.mbridge.msdk.foundation.same.f.b.a().execute(r0);
                                    d();
                                    b();
                                    c();
                                    k.AnonymousClass4 r02 = new Runnable() {
                                        public final void run(
/*
Method generation error in method: com.mbridge.msdk.video.module.a.a.k.4.run():void, dex: classes5.dex
                                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.mbridge.msdk.video.module.a.a.k.4.run():void, class status: UNLOADED
                                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:298)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                                        
*/
                                    };
                                    com.mbridge.msdk.foundation.controller.c.a();
                                    com.mbridge.msdk.foundation.same.f.b.a().execute(r02);
                                    com.mbridge.msdk.videocommon.download.c.getInstance().b(false);
                                    break;
                                case 13:
                                    try {
                                        b();
                                        c();
                                        break;
                                    } catch (Throwable th) {
                                        aa.b("NotifyListener", th.getMessage(), th);
                                        return;
                                    }
                            }
                        }
                    } else if (this.a && obj != null && (obj instanceof Integer)) {
                        int intValue = ((Integer) obj).intValue();
                        if (intValue == 2) {
                            if (!this.m) {
                                this.m = true;
                                b.b(com.mbridge.msdk.foundation.controller.b.d().g(), this.b);
                            }
                        } else if (intValue == 1 && !this.l) {
                            this.l = true;
                            b.c(com.mbridge.msdk.foundation.controller.b.d().g(), this.b);
                        }
                    }
                }
            } else if (obj instanceof Integer) {
                this.k = ((Integer) obj).intValue();
            }
            this.i.a(i, obj);
        }
        if (this.a && !this.n) {
            this.n = true;
            d();
            b.e(com.mbridge.msdk.foundation.controller.b.d().g(), this.b);
        }
        this.i.a(i, obj);
    }
}
