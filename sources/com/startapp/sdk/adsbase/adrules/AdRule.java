package com.startapp.sdk.adsbase.adrules;

import com.startapp.c9;
import com.startapp.e;
import java.io.Serializable;
import java.util.List;

@c9(decider = "type", packageName = "com.startapp.sdk.adsbase.adrules")
/* compiled from: Sta */
public abstract class AdRule implements Serializable {
    private static final long serialVersionUID = 7934302502238649788L;
    public transient boolean a;

    public abstract boolean a(List<e> list);
}
