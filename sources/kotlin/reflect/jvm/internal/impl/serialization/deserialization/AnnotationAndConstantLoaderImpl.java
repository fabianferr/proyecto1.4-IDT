package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: AnnotationAndConstantLoaderImpl.kt */
public final class AnnotationAndConstantLoaderImpl implements AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> {
    private final AnnotationDeserializer deserializer;
    private final SerializerExtensionProtocol protocol;

    /* compiled from: AnnotationAndConstantLoaderImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind[] r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_GETTER     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_SETTER     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl.WhenMappings.<clinit>():void");
        }
    }

    public ConstantValue<?> loadAnnotationDefaultValue(ProtoContainer protoContainer, ProtoBuf.Property property, KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(property, "proto");
        Intrinsics.checkNotNullParameter(kotlinType, "expectedType");
        return null;
    }

    public AnnotationAndConstantLoaderImpl(ModuleDescriptor moduleDescriptor, NotFoundClasses notFoundClasses, SerializerExtensionProtocol serializerExtensionProtocol) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics.checkNotNullParameter(serializerExtensionProtocol, "protocol");
        this.protocol = serializerExtensionProtocol;
        this.deserializer = new AnnotationDeserializer(moduleDescriptor, notFoundClasses);
    }

    public List<AnnotationDescriptor> loadClassAnnotations(ProtoContainer.Class classR) {
        Intrinsics.checkNotNullParameter(classR, "container");
        List list = (List) classR.getClassProto().getExtension(this.protocol.getClassAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, classR.getNameResolver()));
        }
        return (List) arrayList;
    }

    public List<AnnotationDescriptor> loadCallableAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        List list;
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(messageLite, "proto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, "kind");
        if (messageLite instanceof ProtoBuf.Constructor) {
            list = (List) ((ProtoBuf.Constructor) messageLite).getExtension(this.protocol.getConstructorAnnotation());
        } else if (messageLite instanceof ProtoBuf.Function) {
            list = (List) ((ProtoBuf.Function) messageLite).getExtension(this.protocol.getFunctionAnnotation());
        } else if (messageLite instanceof ProtoBuf.Property) {
            int i = WhenMappings.$EnumSwitchMapping$0[annotatedCallableKind.ordinal()];
            if (i == 1) {
                list = (List) ((ProtoBuf.Property) messageLite).getExtension(this.protocol.getPropertyAnnotation());
            } else if (i == 2) {
                list = (List) ((ProtoBuf.Property) messageLite).getExtension(this.protocol.getPropertyGetterAnnotation());
            } else if (i == 3) {
                list = (List) ((ProtoBuf.Property) messageLite).getExtension(this.protocol.getPropertySetterAnnotation());
            } else {
                throw new IllegalStateException("Unsupported callable kind with property proto".toString());
            }
        } else {
            throw new IllegalStateException(("Unknown message: " + messageLite).toString());
        }
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, protoContainer.getNameResolver()));
        }
        return (List) arrayList;
    }

    public List<AnnotationDescriptor> loadPropertyBackingFieldAnnotations(ProtoContainer protoContainer, ProtoBuf.Property property) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(property, "proto");
        return CollectionsKt.emptyList();
    }

    public List<AnnotationDescriptor> loadPropertyDelegateFieldAnnotations(ProtoContainer protoContainer, ProtoBuf.Property property) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(property, "proto");
        return CollectionsKt.emptyList();
    }

    public List<AnnotationDescriptor> loadEnumEntryAnnotations(ProtoContainer protoContainer, ProtoBuf.EnumEntry enumEntry) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(enumEntry, "proto");
        List list = (List) enumEntry.getExtension(this.protocol.getEnumEntryAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, protoContainer.getNameResolver()));
        }
        return (List) arrayList;
    }

    public List<AnnotationDescriptor> loadValueParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, ProtoBuf.ValueParameter valueParameter) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(messageLite, "callableProto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, "kind");
        Intrinsics.checkNotNullParameter(valueParameter, "proto");
        List list = (List) valueParameter.getExtension(this.protocol.getParameterAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, protoContainer.getNameResolver()));
        }
        return (List) arrayList;
    }

    public List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(messageLite, "proto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, "kind");
        return CollectionsKt.emptyList();
    }

    public List<AnnotationDescriptor> loadTypeAnnotations(ProtoBuf.Type type, NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(type, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        List list = (List) type.getExtension(this.protocol.getTypeAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, nameResolver));
        }
        return (List) arrayList;
    }

    public List<AnnotationDescriptor> loadTypeParameterAnnotations(ProtoBuf.TypeParameter typeParameter, NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(typeParameter, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        List list = (List) typeParameter.getExtension(this.protocol.getTypeParameterAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, nameResolver));
        }
        return (List) arrayList;
    }

    public ConstantValue<?> loadPropertyConstant(ProtoContainer protoContainer, ProtoBuf.Property property, KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(property, "proto");
        Intrinsics.checkNotNullParameter(kotlinType, "expectedType");
        ProtoBuf.Annotation.Argument.Value value = (ProtoBuf.Annotation.Argument.Value) ProtoBufUtilKt.getExtensionOrNull(property, this.protocol.getCompileTimeValue());
        if (value == null) {
            return null;
        }
        return this.deserializer.resolveValue(kotlinType, value, protoContainer.getNameResolver());
    }
}