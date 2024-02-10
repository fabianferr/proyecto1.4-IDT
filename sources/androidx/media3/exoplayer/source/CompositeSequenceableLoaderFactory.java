package androidx.media3.exoplayer.source;

public interface CompositeSequenceableLoaderFactory {
    SequenceableLoader createCompositeSequenceableLoader(SequenceableLoader... sequenceableLoaderArr);
}
