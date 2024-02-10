package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0002\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lkotlinx/serialization/internal/UShortSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/UShort;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserialize-BwKQO78", "(Lkotlinx/serialization/encoding/Decoder;)S", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serialize-i8woANY", "(Lkotlinx/serialization/encoding/Encoder;S)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ValueClasses.kt */
public final class UShortSerializer implements KSerializer<UShort> {
    public static final UShortSerializer INSTANCE = new UShortSerializer();
    private static final SerialDescriptor descriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("kotlin.UShort", BuiltinSerializersKt.serializer(ShortCompanionObject.INSTANCE));

    private UShortSerializer() {
    }

    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return UShort.m2619boximpl(m2985deserializeBwKQO78(decoder));
    }

    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        m2986serializei8woANY(encoder, ((UShort) obj).m2675unboximpl());
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* renamed from: serialize-i8woANY  reason: not valid java name */
    public void m2986serializei8woANY(Encoder encoder, short s) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.encodeInline(getDescriptor()).encodeShort(s);
    }

    /* renamed from: deserialize-BwKQO78  reason: not valid java name */
    public short m2985deserializeBwKQO78(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return UShort.m2625constructorimpl(decoder.decodeInline(getDescriptor()).decodeShort());
    }
}
