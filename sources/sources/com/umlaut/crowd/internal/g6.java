package com.umlaut.crowd.internal;

import com.umlaut.crowd.utils.JsonUtils;

public class g6 extends f6 {
    public RDT DownloadTest = new RDT();
    public e4 IspInfo = new e4();
    public RLT LatencyTest = new RLT();
    public zb TraceRoute = new zb();
    public RUT UploadTest = new RUT();

    public g6(String str, String str2) {
        super(str, str2);
    }

    public String b() {
        return JsonUtils.toJson(w2.NFST, (RBR) this);
    }
}
