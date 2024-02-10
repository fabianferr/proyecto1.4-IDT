package com.applovin.impl.mediation.debugger.ui.d;

import android.text.SpannedString;
import com.applovin.impl.mediation.debugger.ui.d.c;

public class e extends c {
    public e(String str) {
        super(c.b.SECTION);
        this.d = new SpannedString(str);
    }

    public String toString() {
        return "SectionListItemViewModel{text=" + this.d + "}";
    }
}
