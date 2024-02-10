package com.facebook.share.internal;

import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.model.SharePhoto;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ShareInternalUtility$$ExternalSyntheticLambda1 implements OpenGraphJSONUtility.PhotoJSONProcessor {
    public final /* synthetic */ UUID f$0;
    public final /* synthetic */ ArrayList f$1;

    public /* synthetic */ ShareInternalUtility$$ExternalSyntheticLambda1(UUID uuid, ArrayList arrayList) {
        this.f$0 = uuid;
        this.f$1 = arrayList;
    }

    public final JSONObject toJSONObject(SharePhoto sharePhoto) {
        return ShareInternalUtility.m1982toJSONObjectForCall$lambda5(this.f$0, this.f$1, sharePhoto);
    }
}
