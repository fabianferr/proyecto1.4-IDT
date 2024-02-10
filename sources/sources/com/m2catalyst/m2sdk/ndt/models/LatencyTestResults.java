package com.m2catalyst.m2sdk.ndt.models;

import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LatencyTestResultsMessage;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00105\u001a\u000206R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR.\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010 j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR\u001e\u0010)\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR\u001e\u0010,\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR\u001c\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/m2catalyst/m2sdk/ndt/models/LatencyTestResults;", "", "()V", "algorithm", "", "getAlgorithm", "()Ljava/lang/Integer;", "setAlgorithm", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "average", "", "getAverage", "()Ljava/lang/Float;", "setAverage", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "id", "", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "jitter", "", "getJitter", "()Ljava/lang/Double;", "setJitter", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "latencyTimes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLatencyTimes", "()Ljava/util/ArrayList;", "setLatencyTimes", "(Ljava/util/ArrayList;)V", "mDev", "getMDev", "setMDev", "maximum", "getMaximum", "setMaximum", "minimum", "getMinimum", "setMinimum", "serverIP", "", "getServerIP", "()Ljava/lang/String;", "setServerIP", "(Ljava/lang/String;)V", "toMessage", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/LatencyTestResultsMessage;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NDTModels.kt */
public final class LatencyTestResults {
    private Integer algorithm;
    private Float average;
    private Long id;
    private Double jitter;
    private ArrayList<Double> latencyTimes;
    private Float mDev;
    private Float maximum;
    private Float minimum;
    private String serverIP;

    public final Integer getAlgorithm() {
        return this.algorithm;
    }

    public final Float getAverage() {
        return this.average;
    }

    public final Long getId() {
        return this.id;
    }

    public final Double getJitter() {
        return this.jitter;
    }

    public final ArrayList<Double> getLatencyTimes() {
        return this.latencyTimes;
    }

    public final Float getMDev() {
        return this.mDev;
    }

    public final Float getMaximum() {
        return this.maximum;
    }

    public final Float getMinimum() {
        return this.minimum;
    }

    public final String getServerIP() {
        return this.serverIP;
    }

    public final void setAlgorithm(Integer num) {
        this.algorithm = num;
    }

    public final void setAverage(Float f) {
        this.average = f;
    }

    public final void setId(Long l) {
        this.id = l;
    }

    public final void setJitter(Double d) {
        this.jitter = d;
    }

    public final void setLatencyTimes(ArrayList<Double> arrayList) {
        this.latencyTimes = arrayList;
    }

    public final void setMDev(Float f) {
        this.mDev = f;
    }

    public final void setMaximum(Float f) {
        this.maximum = f;
    }

    public final void setMinimum(Float f) {
        this.minimum = f;
    }

    public final void setServerIP(String str) {
        this.serverIP = str;
    }

    public final LatencyTestResultsMessage toMessage() {
        LatencyTestResultsMessage.Builder builder = new LatencyTestResultsMessage.Builder();
        builder.minimum(this.minimum).maximum(this.maximum).average(this.average).deviation(this.mDev).jitter(this.jitter).serverIP(this.serverIP).algorithm(this.algorithm);
        ArrayList<Double> arrayList = this.latencyTimes;
        if (arrayList != null) {
            builder.latencyTimes(arrayList);
        }
        LatencyTestResultsMessage build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}
