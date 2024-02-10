package com.m2catalyst.m2sdk.testing.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewbinding.ViewBindings;
import com.m2catalyst.m2sdk.R;
import com.m2catalyst.m2sdk.external.M2SDK;
import com.m2catalyst.m2sdk.m3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/m2catalyst/m2sdk/testing/ui/MainTestingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: MainTestingActivity.kt */
public final class MainTestingActivity extends AppCompatActivity {
    public com.m2catalyst.m2sdk.b a;

    /* compiled from: ActivityVM.kt */
    public static final class a extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ ViewModelStoreOwner a;
        public final /* synthetic */ Scope b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ViewModelStoreOwner viewModelStoreOwner, Scope scope) {
            super(0);
            this.a = viewModelStoreOwner;
            this.b = scope;
        }

        public final Object invoke() {
            return GetViewModelFactoryKt.getViewModelFactory(this.a, Reflection.getOrCreateKotlinClass(m3.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null, (Function0<Bundle>) null, this.b);
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    public static final class b extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ ComponentActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ComponentActivity componentActivity) {
            super(0);
            this.a = componentActivity;
        }

        public final Object invoke() {
            ViewModelStore viewModelStore = this.a.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    public MainTestingActivity() {
        new ViewModelLazy(Reflection.getOrCreateKotlinClass(m3.class), new b(this), new a(this, AndroidKoinScopeExtKt.getKoinScope(this)));
    }

    public final void a() {
        com.m2catalyst.m2sdk.b bVar = this.a;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar = null;
        }
        bVar.b.setOnClickListener(new MainTestingActivity$$ExternalSyntheticLambda0(this));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(R.layout.activity_main_testing, (ViewGroup) null, false);
        int i = R.id.buildLocationPacket;
        if (((AppCompatButton) ViewBindings.findChildViewById(inflate, i)) != null) {
            i = R.id.buildMnsiPacket;
            if (((AppCompatButton) ViewBindings.findChildViewById(inflate, i)) != null) {
                i = R.id.commandScroll;
                if (((NestedScrollView) ViewBindings.findChildViewById(inflate, i)) != null) {
                    i = R.id.commands;
                    if (((LinearLayoutCompat) ViewBindings.findChildViewById(inflate, i)) != null) {
                        i = R.id.initialize;
                        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(inflate, i);
                        if (appCompatButton != null) {
                            i = R.id.sendFakeData;
                            if (((AppCompatButton) ViewBindings.findChildViewById(inflate, i)) != null) {
                                i = R.id.view;
                                if (((LinearLayoutCompat) ViewBindings.findChildViewById(inflate, i)) != null) {
                                    i = R.id.viewScroll;
                                    if (((NestedScrollView) ViewBindings.findChildViewById(inflate, i)) != null) {
                                        com.m2catalyst.m2sdk.b bVar = new com.m2catalyst.m2sdk.b((RelativeLayout) inflate, appCompatButton);
                                        Intrinsics.checkNotNullExpressionValue(bVar, "inflate(layoutInflater)");
                                        this.a = bVar;
                                        setContentView(R.layout.activity_main_testing);
                                        a();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    public static final void a(MainTestingActivity mainTestingActivity, View view) {
        Intrinsics.checkNotNullParameter(mainTestingActivity, "this$0");
        M2SDK.INSTANCE.turnOnDataCollection(mainTestingActivity);
        Intrinsics.checkNotNullParameter("Activity starting SDK", "<this>");
    }
}
