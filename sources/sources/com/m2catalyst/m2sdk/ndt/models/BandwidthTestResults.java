package com.m2catalyst.m2sdk.ndt.models;

import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.BandwidthTestResultsMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B7\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u0005¢\u0006\u0002\u0010\fJ\u0006\u0010#\u001a\u00020$R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0017R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010¨\u0006&"}, d2 = {"Lcom/m2catalyst/m2sdk/ndt/models/BandwidthTestResults;", "", "type", "", "algorithm", "min", "", "max", "avg", "dataSize", "", "(IIFFFJ)V", "()V", "getAlgorithm", "()I", "setAlgorithm", "(I)V", "getAvg", "()Ljava/lang/Float;", "setAvg", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getDataSize", "()Ljava/lang/Long;", "setDataSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "id", "getId", "getMax", "setMax", "getMin", "setMin", "getType", "setType", "toMessage", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/BandwidthTestResultsMessage;", "Companion", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NDTModels.kt */
public final class BandwidthTestResults {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_DOWNLOAD = 1;
    public static final int TYPE_UPLOAD = 2;
    private int algorithm;
    private Float avg;
    private Long dataSize;
    private final Long id;
    private Float max;
    private Float min;
    private int type;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/m2catalyst/m2sdk/ndt/models/BandwidthTestResults$Companion;", "", "()V", "TYPE_DOWNLOAD", "", "TYPE_UPLOAD", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NDTModels.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BandwidthTestResults() {
    }

    public BandwidthTestResults(int i, int i2, float f, float f2, float f3, long j) {
        this();
        this.type = i;
        this.algorithm = i2;
        this.min = Float.valueOf(f);
        this.max = Float.valueOf(f2);
        this.avg = Float.valueOf(f3);
        this.dataSize = Long.valueOf(j);
    }

    public final int getAlgorithm() {
        return this.algorithm;
    }

    public final Float getAvg() {
        return this.avg;
    }

    public final Long getDataSize() {
        return this.dataSize;
    }

    public final Long getId() {
        return this.id;
    }

    public final Float getMax() {
        return this.max;
    }

    public final Float getMin() {
        return this.min;
    }

    public final int getType() {
        return this.type;
    }

    public final void setAlgorithm(int i) {
        this.algorithm = i;
    }

    public final void setAvg(Float f) {
        this.avg = f;
    }

    public final void setDataSize(Long l) {
        this.dataSize = l;
    }

    public final void setMax(Float f) {
        this.max = f;
    }

    public final void setMin(Float f) {
        this.min = f;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final BandwidthTestResultsMessage toMessage() {
        BandwidthTestResultsMessage.Builder builder = new BandwidthTestResultsMessage.Builder();
        builder.minimum(this.min).maximum(this.max).average(this.avg).type(Integer.valueOf(this.type)).algorithm(Integer.valueOf(this.algorithm)).dataSize(this.dataSize);
        BandwidthTestResultsMessage build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}
