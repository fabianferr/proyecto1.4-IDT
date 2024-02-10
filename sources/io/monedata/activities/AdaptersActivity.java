package io.monedata.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.facebook.internal.AnalyticsEvents;
import io.monedata.d1;
import io.monedata.j1;
import io.monedata.partners.PartnerAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\t"}, d2 = {"Lio/monedata/activities/AdaptersActivity;", "Landroid/app/Activity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "<init>", "()V", "a", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class AdaptersActivity extends Activity {

    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R#\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0005\u0010\u0010¨\u0006\u0016"}, d2 = {"Lio/monedata/activities/AdaptersActivity$a;", "Landroid/widget/ArrayAdapter;", "Lio/monedata/partners/PartnerAdapter;", "partner", "", "a", "", "position", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", "parent", "getView", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "()Landroid/view/LayoutInflater;", "inflater", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
    private static final class a extends ArrayAdapter<PartnerAdapter> {
        private final Lazy a;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "a", "()Landroid/view/LayoutInflater;"}, k = 3, mv = {1, 7, 1})
        /* renamed from: io.monedata.activities.AdaptersActivity$a$a  reason: collision with other inner class name */
        static final class C0202a extends Lambda implements Function0<LayoutInflater> {
            final /* synthetic */ Context a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0202a(Context context) {
                super(0);
                this.a = context;
            }

            /* renamed from: a */
            public final LayoutInflater invoke() {
                return LayoutInflater.from(this.a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(context, 0, j1.a.a());
            Intrinsics.checkNotNullParameter(context, "context");
            this.a = LazyKt.lazy(new C0202a(context));
        }

        private final LayoutInflater a() {
            return (LayoutInflater) this.a.getValue();
        }

        private final String a(PartnerAdapter partnerAdapter) {
            return partnerAdapter.isStopped() ? "Stopped" : partnerAdapter.isStarted() ? "Started" : !partnerAdapter.isStarted() ? "Idle" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            d1 d1Var;
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            Object item = getItem(i);
            if (item != null) {
                Intrinsics.checkNotNullExpressionValue(item, "requireNotNull(getItem(position))");
                PartnerAdapter partnerAdapter = (PartnerAdapter) item;
                if (view == null || (d1Var = d1.a(view)) == null) {
                    d1Var = d1.a(a(), viewGroup, false);
                }
                Intrinsics.checkNotNullExpressionValue(d1Var, "convertView?.let { bind(…(inflater, parent, false)");
                d1Var.b.setText(partnerAdapter.getName());
                d1Var.c.setText(a(partnerAdapter));
                LinearLayout a2 = d1Var.getRoot();
                Intrinsics.checkNotNullExpressionValue(a2, "binding.root");
                return a2;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ListView listView = new ListView(this);
        listView.setAdapter(new a(this));
        setContentView(listView);
    }
}
