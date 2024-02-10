package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.checker.IntersectionTypeKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: TypeParameterUpperBoundEraser.kt */
public final class TypeParameterUpperBoundEraser {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy erroneousErasedBound$delegate;
    private final MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> getErasedUpperBound;
    private final TypeParameterErasureOptions options;
    private final ErasureProjectionComputer projectionComputer;
    private final LockBasedStorageManager storage;

    public TypeParameterUpperBoundEraser(ErasureProjectionComputer erasureProjectionComputer, TypeParameterErasureOptions typeParameterErasureOptions) {
        Intrinsics.checkNotNullParameter(erasureProjectionComputer, "projectionComputer");
        Intrinsics.checkNotNullParameter(typeParameterErasureOptions, "options");
        this.projectionComputer = erasureProjectionComputer;
        this.options = typeParameterErasureOptions;
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("Type parameter upper bound erasure results");
        this.storage = lockBasedStorageManager;
        this.erroneousErasedBound$delegate = LazyKt.lazy(new TypeParameterUpperBoundEraser$erroneousErasedBound$2(this));
        MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> createMemoizedFunction = lockBasedStorageManager.createMemoizedFunction(new TypeParameterUpperBoundEraser$getErasedUpperBound$1(this));
        Intrinsics.checkNotNullExpressionValue(createMemoizedFunction, "storage.createMemoizedFu…ameter, typeAttr) }\n    }");
        this.getErasedUpperBound = createMemoizedFunction;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TypeParameterUpperBoundEraser(ErasureProjectionComputer erasureProjectionComputer, TypeParameterErasureOptions typeParameterErasureOptions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(erasureProjectionComputer, (i & 2) != 0 ? new TypeParameterErasureOptions(false, false) : typeParameterErasureOptions);
    }

    private final ErrorType getErroneousErasedBound() {
        return (ErrorType) this.erroneousErasedBound$delegate.getValue();
    }

    /* compiled from: TypeParameterUpperBoundEraser.kt */
    private static final class DataToEraseUpperBound {
        private final ErasureTypeAttributes typeAttr;
        private final TypeParameterDescriptor typeParameter;

        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.typeParameter + ", typeAttr=" + this.typeAttr + ')';
        }

        public DataToEraseUpperBound(TypeParameterDescriptor typeParameterDescriptor, ErasureTypeAttributes erasureTypeAttributes) {
            Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
            Intrinsics.checkNotNullParameter(erasureTypeAttributes, "typeAttr");
            this.typeParameter = typeParameterDescriptor;
            this.typeAttr = erasureTypeAttributes;
        }

        public final TypeParameterDescriptor getTypeParameter() {
            return this.typeParameter;
        }

        public final ErasureTypeAttributes getTypeAttr() {
            return this.typeAttr;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof DataToEraseUpperBound)) {
                return false;
            }
            DataToEraseUpperBound dataToEraseUpperBound = (DataToEraseUpperBound) obj;
            if (!Intrinsics.areEqual((Object) dataToEraseUpperBound.typeParameter, (Object) this.typeParameter) || !Intrinsics.areEqual((Object) dataToEraseUpperBound.typeAttr, (Object) this.typeAttr)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = this.typeParameter.hashCode();
            return hashCode + (hashCode * 31) + this.typeAttr.hashCode();
        }
    }

    public final KotlinType getErasedUpperBound(TypeParameterDescriptor typeParameterDescriptor, ErasureTypeAttributes erasureTypeAttributes) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics.checkNotNullParameter(erasureTypeAttributes, "typeAttr");
        KotlinType invoke = this.getErasedUpperBound.invoke(new DataToEraseUpperBound(typeParameterDescriptor, erasureTypeAttributes));
        Intrinsics.checkNotNullExpressionValue(invoke, "getErasedUpperBound(Data…typeParameter, typeAttr))");
        return invoke;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.types.KotlinType getDefaultType(kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes r1) {
        /*
            r0 = this;
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = r1.getDefaultType()
            if (r1 == 0) goto L_0x000e
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(r1)
            if (r1 != 0) goto L_0x0014
        L_0x000e:
            kotlin.reflect.jvm.internal.impl.types.error.ErrorType r1 = r0.getErroneousErasedBound()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
        L_0x0014:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser.getDefaultType(kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes):kotlin.reflect.jvm.internal.impl.types.KotlinType");
    }

    /* access modifiers changed from: private */
    public final KotlinType getErasedUpperBoundInternal(TypeParameterDescriptor typeParameterDescriptor, ErasureTypeAttributes erasureTypeAttributes) {
        TypeProjection typeProjection;
        Set<TypeParameterDescriptor> visitedTypeParameters = erasureTypeAttributes.getVisitedTypeParameters();
        if (visitedTypeParameters != null && visitedTypeParameters.contains(typeParameterDescriptor.getOriginal())) {
            return getDefaultType(erasureTypeAttributes);
        }
        SimpleType defaultType = typeParameterDescriptor.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "typeParameter.defaultType");
        Iterable<TypeParameterDescriptor> extractTypeParametersFromUpperBounds = TypeUtilsKt.extractTypeParametersFromUpperBounds(defaultType, visitedTypeParameters);
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(extractTypeParametersFromUpperBounds, 10)), 16));
        for (TypeParameterDescriptor typeParameterDescriptor2 : extractTypeParametersFromUpperBounds) {
            if (visitedTypeParameters == null || !visitedTypeParameters.contains(typeParameterDescriptor2)) {
                typeProjection = this.projectionComputer.computeProjection(typeParameterDescriptor2, erasureTypeAttributes, this, getErasedUpperBound(typeParameterDescriptor2, erasureTypeAttributes.withNewVisitedTypeParameter(typeParameterDescriptor)));
            } else {
                typeProjection = TypeUtils.makeStarProjection(typeParameterDescriptor2, erasureTypeAttributes);
                Intrinsics.checkNotNullExpressionValue(typeProjection, "makeStarProjection(it, typeAttr)");
            }
            Pair pair = TuplesKt.to(typeParameterDescriptor2.getTypeConstructor(), typeProjection);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        boolean z = false;
        TypeSubstitutor create = TypeSubstitutor.create((TypeSubstitution) TypeConstructorSubstitution.Companion.createByConstructorsMap$default(TypeConstructorSubstitution.Companion, linkedHashMap, false, 2, (Object) null));
        Intrinsics.checkNotNullExpressionValue(create, "create(TypeConstructorSu…ap(erasedTypeParameters))");
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
        Set<KotlinType> substituteErasedUpperBounds = substituteErasedUpperBounds(create, upperBounds, erasureTypeAttributes);
        if (!(!substituteErasedUpperBounds.isEmpty())) {
            return getDefaultType(erasureTypeAttributes);
        }
        if (!this.options.getIntersectUpperBounds()) {
            if (substituteErasedUpperBounds.size() == 1) {
                z = true;
            }
            if (z) {
                return (KotlinType) CollectionsKt.single(substituteErasedUpperBounds);
            }
            throw new IllegalArgumentException("Should only be one computed upper bound if no need to intersect all bounds".toString());
        }
        Iterable<KotlinType> list = CollectionsKt.toList(substituteErasedUpperBounds);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (KotlinType unwrap : list) {
            arrayList.add(unwrap.unwrap());
        }
        return IntersectionTypeKt.intersectTypes((List) arrayList);
    }

    private final Set<KotlinType> substituteErasedUpperBounds(TypeSubstitutor typeSubstitutor, List<? extends KotlinType> list, ErasureTypeAttributes erasureTypeAttributes) {
        Set createSetBuilder = SetsKt.createSetBuilder();
        for (KotlinType kotlinType : list) {
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassDescriptor) {
                createSetBuilder.add(Companion.replaceArgumentsOfUpperBound(kotlinType, typeSubstitutor, erasureTypeAttributes.getVisitedTypeParameters(), this.options.getLeaveNonTypeParameterTypes()));
            } else if (declarationDescriptor instanceof TypeParameterDescriptor) {
                Set<TypeParameterDescriptor> visitedTypeParameters = erasureTypeAttributes.getVisitedTypeParameters();
                boolean z = false;
                if (visitedTypeParameters != null && visitedTypeParameters.contains(declarationDescriptor)) {
                    z = true;
                }
                if (z) {
                    createSetBuilder.add(getDefaultType(erasureTypeAttributes));
                } else {
                    List<KotlinType> upperBounds = ((TypeParameterDescriptor) declarationDescriptor).getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(upperBounds, "declaration.upperBounds");
                    createSetBuilder.addAll(substituteErasedUpperBounds(typeSubstitutor, upperBounds, erasureTypeAttributes));
                }
            }
            if (!this.options.getIntersectUpperBounds()) {
                break;
            }
        }
        return SetsKt.build(createSetBuilder);
    }

    /* compiled from: TypeParameterUpperBoundEraser.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:100:0x00b9 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x015c A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x0206 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final kotlin.reflect.jvm.internal.impl.types.KotlinType replaceArgumentsOfUpperBound(kotlin.reflect.jvm.internal.impl.types.KotlinType r17, kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor r18, java.util.Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> r19, boolean r20) {
            /*
                r16 = this;
                r0 = r18
                r1 = r19
                java.lang.String r2 = "<this>"
                r3 = r17
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
                java.lang.String r2 = "substitutor"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
                kotlin.reflect.jvm.internal.impl.types.UnwrappedType r2 = r17.unwrap()
                boolean r4 = r2 instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType
                java.lang.String r5 = "argument.type"
                java.lang.String r6 = "type"
                r8 = 10
                java.lang.String r9 = "constructor.parameters"
                r11 = 0
                if (r4 == 0) goto L_0x016d
                r4 = r2
                kotlin.reflect.jvm.internal.impl.types.FlexibleType r4 = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) r4
                kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r4.getLowerBound()
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r14 = r13.getConstructor()
                java.util.List r14 = r14.getParameters()
                boolean r14 = r14.isEmpty()
                if (r14 != 0) goto L_0x00c6
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r14 = r13.getConstructor()
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r14 = r14.getDeclarationDescriptor()
                if (r14 != 0) goto L_0x0042
                goto L_0x00c6
            L_0x0042:
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r14 = r13.getConstructor()
                java.util.List r14 = r14.getParameters()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r9)
                java.lang.Iterable r14 = (java.lang.Iterable) r14
                java.util.ArrayList r15 = new java.util.ArrayList
                int r10 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r14, r8)
                r15.<init>(r10)
                java.util.Collection r15 = (java.util.Collection) r15
                java.util.Iterator r10 = r14.iterator()
            L_0x005e:
                boolean r14 = r10.hasNext()
                if (r14 == 0) goto L_0x00bf
                java.lang.Object r14 = r10.next()
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r14 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r14
                java.util.List r12 = r17.getArguments()
                int r8 = r14.getIndex()
                java.lang.Object r8 = kotlin.collections.CollectionsKt.getOrNull(r12, r8)
                kotlin.reflect.jvm.internal.impl.types.TypeProjection r8 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r8
                if (r20 == 0) goto L_0x0091
                if (r8 == 0) goto L_0x008d
                kotlin.reflect.jvm.internal.impl.types.KotlinType r12 = r8.getType()
                if (r12 == 0) goto L_0x008d
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r6)
                boolean r12 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.containsTypeParameter(r12)
                if (r12 != 0) goto L_0x008d
                r12 = 1
                goto L_0x008e
            L_0x008d:
                r12 = 0
            L_0x008e:
                if (r12 == 0) goto L_0x0091
                goto L_0x00b9
            L_0x0091:
                if (r1 == 0) goto L_0x009b
                boolean r12 = r1.contains(r14)
                if (r12 == 0) goto L_0x009b
                r12 = 1
                goto L_0x009c
            L_0x009b:
                r12 = 0
            L_0x009c:
                if (r8 == 0) goto L_0x00b1
                if (r12 != 0) goto L_0x00b1
                kotlin.reflect.jvm.internal.impl.types.TypeSubstitution r12 = r18.getSubstitution()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = r8.getType()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
                kotlin.reflect.jvm.internal.impl.types.TypeProjection r7 = r12.get(r7)
                if (r7 != 0) goto L_0x00b9
            L_0x00b1:
                kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl r7 = new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl
                r7.<init>(r14)
                kotlin.reflect.jvm.internal.impl.types.TypeProjection r7 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r7
                r8 = r7
            L_0x00b9:
                r15.add(r8)
                r8 = 10
                goto L_0x005e
            L_0x00bf:
                java.util.List r15 = (java.util.List) r15
                r7 = 2
                kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.replace$default(r13, r15, r11, r7, r11)
            L_0x00c6:
                kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = r4.getUpperBound()
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r7 = r4.getConstructor()
                java.util.List r7 = r7.getParameters()
                boolean r7 = r7.isEmpty()
                if (r7 != 0) goto L_0x0167
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r7 = r4.getConstructor()
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r7 = r7.getDeclarationDescriptor()
                if (r7 != 0) goto L_0x00e4
                goto L_0x0167
            L_0x00e4:
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r7 = r4.getConstructor()
                java.util.List r7 = r7.getParameters()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
                java.lang.Iterable r7 = (java.lang.Iterable) r7
                java.util.ArrayList r8 = new java.util.ArrayList
                r9 = 10
                int r9 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r9)
                r8.<init>(r9)
                java.util.Collection r8 = (java.util.Collection) r8
                java.util.Iterator r7 = r7.iterator()
            L_0x0102:
                boolean r9 = r7.hasNext()
                if (r9 == 0) goto L_0x0160
                java.lang.Object r9 = r7.next()
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r9
                java.util.List r10 = r17.getArguments()
                int r12 = r9.getIndex()
                java.lang.Object r10 = kotlin.collections.CollectionsKt.getOrNull(r10, r12)
                kotlin.reflect.jvm.internal.impl.types.TypeProjection r10 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r10
                if (r20 == 0) goto L_0x0135
                if (r10 == 0) goto L_0x0131
                kotlin.reflect.jvm.internal.impl.types.KotlinType r12 = r10.getType()
                if (r12 == 0) goto L_0x0131
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r6)
                boolean r12 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.containsTypeParameter(r12)
                if (r12 != 0) goto L_0x0131
                r12 = 1
                goto L_0x0132
            L_0x0131:
                r12 = 0
            L_0x0132:
                if (r12 == 0) goto L_0x0135
                goto L_0x015c
            L_0x0135:
                if (r1 == 0) goto L_0x013f
                boolean r12 = r1.contains(r9)
                if (r12 == 0) goto L_0x013f
                r12 = 1
                goto L_0x0140
            L_0x013f:
                r12 = 0
            L_0x0140:
                if (r10 == 0) goto L_0x0155
                if (r12 != 0) goto L_0x0155
                kotlin.reflect.jvm.internal.impl.types.TypeSubstitution r12 = r18.getSubstitution()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r14 = r10.getType()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r5)
                kotlin.reflect.jvm.internal.impl.types.TypeProjection r12 = r12.get(r14)
                if (r12 != 0) goto L_0x015c
            L_0x0155:
                kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl r10 = new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl
                r10.<init>(r9)
                kotlin.reflect.jvm.internal.impl.types.TypeProjection r10 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r10
            L_0x015c:
                r8.add(r10)
                goto L_0x0102
            L_0x0160:
                java.util.List r8 = (java.util.List) r8
                r1 = 2
                kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.replace$default(r4, r8, r11, r1, r11)
            L_0x0167:
                kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r13, r4)
                goto L_0x0214
            L_0x016d:
                boolean r4 = r2 instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType
                if (r4 == 0) goto L_0x0228
                r4 = r2
                kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r4
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r7 = r4.getConstructor()
                java.util.List r7 = r7.getParameters()
                boolean r7 = r7.isEmpty()
                if (r7 != 0) goto L_0x0211
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r7 = r4.getConstructor()
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r7 = r7.getDeclarationDescriptor()
                if (r7 != 0) goto L_0x018e
                goto L_0x0211
            L_0x018e:
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r7 = r4.getConstructor()
                java.util.List r7 = r7.getParameters()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
                java.lang.Iterable r7 = (java.lang.Iterable) r7
                java.util.ArrayList r8 = new java.util.ArrayList
                r9 = 10
                int r9 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r9)
                r8.<init>(r9)
                java.util.Collection r8 = (java.util.Collection) r8
                java.util.Iterator r7 = r7.iterator()
            L_0x01ac:
                boolean r9 = r7.hasNext()
                if (r9 == 0) goto L_0x020a
                java.lang.Object r9 = r7.next()
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r9
                java.util.List r10 = r17.getArguments()
                int r12 = r9.getIndex()
                java.lang.Object r10 = kotlin.collections.CollectionsKt.getOrNull(r10, r12)
                kotlin.reflect.jvm.internal.impl.types.TypeProjection r10 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r10
                if (r20 == 0) goto L_0x01df
                if (r10 == 0) goto L_0x01db
                kotlin.reflect.jvm.internal.impl.types.KotlinType r12 = r10.getType()
                if (r12 == 0) goto L_0x01db
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r6)
                boolean r12 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.containsTypeParameter(r12)
                if (r12 != 0) goto L_0x01db
                r12 = 1
                goto L_0x01dc
            L_0x01db:
                r12 = 0
            L_0x01dc:
                if (r12 == 0) goto L_0x01df
                goto L_0x0206
            L_0x01df:
                if (r1 == 0) goto L_0x01e9
                boolean r12 = r1.contains(r9)
                if (r12 == 0) goto L_0x01e9
                r12 = 1
                goto L_0x01ea
            L_0x01e9:
                r12 = 0
            L_0x01ea:
                if (r10 == 0) goto L_0x01ff
                if (r12 != 0) goto L_0x01ff
                kotlin.reflect.jvm.internal.impl.types.TypeSubstitution r12 = r18.getSubstitution()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r13 = r10.getType()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r5)
                kotlin.reflect.jvm.internal.impl.types.TypeProjection r12 = r12.get(r13)
                if (r12 != 0) goto L_0x0206
            L_0x01ff:
                kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl r10 = new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl
                r10.<init>(r9)
                kotlin.reflect.jvm.internal.impl.types.TypeProjection r10 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r10
            L_0x0206:
                r8.add(r10)
                goto L_0x01ac
            L_0x020a:
                java.util.List r8 = (java.util.List) r8
                r1 = 2
                kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.replace$default(r4, r8, r11, r1, r11)
            L_0x0211:
                r1 = r4
                kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = (kotlin.reflect.jvm.internal.impl.types.UnwrappedType) r1
            L_0x0214:
                kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2
                kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.inheritEnhancement(r1, r2)
                kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
                kotlin.reflect.jvm.internal.impl.types.Variance r2 = kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE
                kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.safeSubstitute(r1, r2)
                java.lang.String r1 = "substitutor.safeSubstitu…s, Variance.OUT_VARIANCE)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                return r0
            L_0x0228:
                kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
                r0.<init>()
                goto L_0x022f
            L_0x022e:
                throw r0
            L_0x022f:
                goto L_0x022e
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser.Companion.replaceArgumentsOfUpperBound(kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor, java.util.Set, boolean):kotlin.reflect.jvm.internal.impl.types.KotlinType");
        }
    }
}
