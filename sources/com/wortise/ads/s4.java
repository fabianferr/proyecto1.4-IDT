package com.wortise.ads;

import android.location.Location;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\"3\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00018F@FX\u0002¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0005\u0010\u0007\"3\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00018F@FX\u0002¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\n\u0010\u0007¨\u0006\f"}, d2 = {"Landroid/location/Location;", "", "<set-?>", "speedAccuracyMetersPerSecondCompat$delegate", "Lcom/wortise/ads/b6;", "a", "(Landroid/location/Location;)Ljava/lang/Float;", "(Landroid/location/Location;Ljava/lang/Float;)V", "speedAccuracyMetersPerSecondCompat", "verticalAccuracyMetersCompat$delegate", "b", "verticalAccuracyMetersCompat", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: Location.kt */
public final class s4 {
    static final /* synthetic */ KProperty<Object>[] a;
    private static final b6 b = c6.a(a.a, b.a);
    private static final b6 c = c6.a(c.a, d.a);

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Landroid/location/Location;", "Lkotlin/Function0;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: Location.kt */
    static final class a extends Lambda implements Function1<Location, Function0<? extends Float>> {
        public static final a a = new a();

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* renamed from: com.wortise.ads.s4$a$a  reason: collision with other inner class name */
        /* compiled from: Location.kt */
        /* synthetic */ class C0199a extends FunctionReferenceImpl implements Function0<Float> {
            C0199a(Object obj) {
                super(0, obj, Location.class, "getSpeedAccuracyMetersPerSecond", "getSpeedAccuracyMetersPerSecond()F", 0);
            }

            /* renamed from: a */
            public final Float invoke() {
                return Float.valueOf(((Location) this.receiver).getSpeedAccuracyMetersPerSecond());
            }
        }

        a() {
            super(1);
        }

        /* renamed from: a */
        public final Function0<Float> invoke(Location location) {
            Intrinsics.checkNotNullParameter(location, "$this$safeDelegate");
            return new C0199a(location);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\n"}, d2 = {"Landroid/location/Location;", "Lkotlin/Function1;", "", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: Location.kt */
    static final class b extends Lambda implements Function1<Location, Function1<? super Float, ? extends Object>> {
        public static final b a = new b();

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* compiled from: Location.kt */
        /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Float, Unit> {
            a(Object obj) {
                super(1, obj, Location.class, "setSpeedAccuracyMetersPerSecond", "setSpeedAccuracyMetersPerSecond(F)V", 0);
            }

            public final void a(float f) {
                ((Location) this.receiver).setSpeedAccuracyMetersPerSecond(f);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((Number) obj).floatValue());
                return Unit.INSTANCE;
            }
        }

        b() {
            super(1);
        }

        /* renamed from: a */
        public final Function1<Float, Object> invoke(Location location) {
            Intrinsics.checkNotNullParameter(location, "$this$safeDelegate");
            return new a(location);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Landroid/location/Location;", "Lkotlin/Function0;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: Location.kt */
    static final class c extends Lambda implements Function1<Location, Function0<? extends Float>> {
        public static final c a = new c();

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* compiled from: Location.kt */
        /* synthetic */ class a extends FunctionReferenceImpl implements Function0<Float> {
            a(Object obj) {
                super(0, obj, Location.class, "getVerticalAccuracyMeters", "getVerticalAccuracyMeters()F", 0);
            }

            /* renamed from: a */
            public final Float invoke() {
                return Float.valueOf(((Location) this.receiver).getVerticalAccuracyMeters());
            }
        }

        c() {
            super(1);
        }

        /* renamed from: a */
        public final Function0<Float> invoke(Location location) {
            Intrinsics.checkNotNullParameter(location, "$this$safeDelegate");
            return new a(location);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\n"}, d2 = {"Landroid/location/Location;", "Lkotlin/Function1;", "", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: Location.kt */
    static final class d extends Lambda implements Function1<Location, Function1<? super Float, ? extends Object>> {
        public static final d a = new d();

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* compiled from: Location.kt */
        /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Float, Unit> {
            a(Object obj) {
                super(1, obj, Location.class, "setVerticalAccuracyMeters", "setVerticalAccuracyMeters(F)V", 0);
            }

            public final void a(float f) {
                ((Location) this.receiver).setVerticalAccuracyMeters(f);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((Number) obj).floatValue());
                return Unit.INSTANCE;
            }
        }

        d() {
            super(1);
        }

        /* renamed from: a */
        public final Function1<Float, Object> invoke(Location location) {
            Intrinsics.checkNotNullParameter(location, "$this$safeDelegate");
            return new a(location);
        }
    }

    static {
        Class<s4> cls = s4.class;
        a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "speedAccuracyMetersPerSecondCompat", "getSpeedAccuracyMetersPerSecondCompat(Landroid/location/Location;)Ljava/lang/Float;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "verticalAccuracyMetersCompat", "getVerticalAccuracyMetersCompat(Landroid/location/Location;)Ljava/lang/Float;", 1))};
    }

    public static final Float a(Location location) {
        Intrinsics.checkNotNullParameter(location, "<this>");
        return (Float) b.getValue(location, a[0]);
    }

    public static final Float b(Location location) {
        Intrinsics.checkNotNullParameter(location, "<this>");
        return (Float) c.getValue(location, a[1]);
    }

    public static final void a(Location location, Float f) {
        Intrinsics.checkNotNullParameter(location, "<this>");
        b.setValue(location, a[0], f);
    }

    public static final void b(Location location, Float f) {
        Intrinsics.checkNotNullParameter(location, "<this>");
        c.setValue(location, a[1], f);
    }
}
