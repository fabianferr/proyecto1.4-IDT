package com.m2catalyst.m2sdk.database.entities;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/m2catalyst/m2sdk/database/entities/CrashEntity;", "", "()V", "id", "", "getId", "()I", "setId", "(I)V", "stack_trace", "", "getStack_trace", "()Ljava/lang/String;", "setStack_trace", "(Ljava/lang/String;)V", "time_stamp", "", "getTime_stamp", "()Ljava/lang/Long;", "setTime_stamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CrashEntity.kt */
public final class CrashEntity {
    private int id;
    private String stack_trace;
    private Long time_stamp;

    public final int getId() {
        return this.id;
    }

    public final String getStack_trace() {
        return this.stack_trace;
    }

    public final Long getTime_stamp() {
        return this.time_stamp;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setStack_trace(String str) {
        this.stack_trace = str;
    }

    public final void setTime_stamp(Long l) {
        this.time_stamp = l;
    }
}
