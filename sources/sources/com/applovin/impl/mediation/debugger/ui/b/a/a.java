package com.applovin.impl.mediation.debugger.ui.b.a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.applovin.impl.mediation.debugger.b.b.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.f;
import com.applovin.sdk.R;

public class a extends c {
    private final b a;
    private final Context o;

    public a(b bVar, Context context) {
        super(c.b.DETAIL);
        this.a = bVar;
        this.o = context;
        this.d = q();
        this.e = r();
    }

    private SpannedString q() {
        return StringUtils.createSpannedString(this.a.i(), b() ? ViewCompat.MEASURED_STATE_MASK : -7829368, 18, 1);
    }

    private SpannedString r() {
        if (!b()) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(s());
        spannableStringBuilder.append(new SpannableString("\n"));
        spannableStringBuilder.append(t());
        if (this.a.a() == b.a.INVALID_INTEGRATION) {
            spannableStringBuilder.append(new SpannableString("\n"));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString("Invalid Integration", SupportMenu.CATEGORY_MASK));
        }
        return new SpannedString(spannableStringBuilder);
    }

    private SpannedString s() {
        if (!this.a.d()) {
            return StringUtils.createListItemDetailSpannedString("SDK Missing", SupportMenu.CATEGORY_MASK);
        }
        if (!TextUtils.isEmpty(this.a.j())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("SDK\t\t\t\t\t  ", -7829368));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(this.a.j(), ViewCompat.MEASURED_STATE_MASK));
            return new SpannedString(spannableStringBuilder);
        }
        return StringUtils.createListItemDetailSpannedString(this.a.e() ? "Retrieving SDK Version..." : "SDK Found", ViewCompat.MEASURED_STATE_MASK);
    }

    private SpannedString t() {
        String str;
        int i;
        if (this.a.e()) {
            boolean isEmpty = TextUtils.isEmpty(this.a.k());
            i = ViewCompat.MEASURED_STATE_MASK;
            if (!isEmpty) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ADAPTER  ", -7829368));
                spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(this.a.k(), ViewCompat.MEASURED_STATE_MASK));
                if (this.a.f()) {
                    spannableStringBuilder.append(StringUtils.createListItemDetailSubSpannedString("  LATEST  ", Color.rgb(255, 127, 0)));
                    spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(this.a.l(), ViewCompat.MEASURED_STATE_MASK));
                }
                return new SpannedString(spannableStringBuilder);
            }
            str = "Adapter Found";
        } else {
            str = "Adapter Missing";
            i = SupportMenu.CATEGORY_MASK;
        }
        return StringUtils.createListItemDetailSpannedString(str, i);
    }

    public boolean b() {
        return this.a.a() != b.a.MISSING;
    }

    public b d() {
        return this.a;
    }

    public int e() {
        int o2 = this.a.o();
        return o2 > 0 ? o2 : R.drawable.applovin_ic_mediation_placeholder;
    }

    public int f() {
        return b() ? R.drawable.applovin_ic_disclosure_arrow : super.e();
    }

    public int g() {
        return f.a(R.color.applovin_sdk_disclosureButtonColor, this.o);
    }

    public String toString() {
        return "MediatedNetworkListItemViewModel{text=" + this.d + ", detailText=" + this.e + ", network=" + this.a + "}";
    }
}
