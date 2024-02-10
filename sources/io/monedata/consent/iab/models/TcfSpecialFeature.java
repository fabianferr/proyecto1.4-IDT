package io.monedata.consent.iab.models;

import io.monedata.w1;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007j\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lio/monedata/consent/iab/models/TcfSpecialFeature;", "", "Lio/monedata/w1;", "", "id", "I", "getId", "()I", "version", "getVersion", "<init>", "(Ljava/lang/String;III)V", "PRECISE_GEOLOCATION", "SCAN_DEVICE_CHARACTERISTICS", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public enum TcfSpecialFeature implements w1 {
    PRECISE_GEOLOCATION(1, 0, 2, (int) null),
    SCAN_DEVICE_CHARACTERISTICS(2, 0, 2, (int) null);
    
    private final int id;
    private final int version;

    private TcfSpecialFeature(int i, int i2) {
        this.id = i;
        this.version = i2;
    }

    public int getId() {
        return this.id;
    }

    public int getVersion() {
        return this.version;
    }
}
