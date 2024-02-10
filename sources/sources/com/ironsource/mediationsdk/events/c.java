package com.ironsource.mediationsdk.events;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\n\u000b\fJ\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\tH&¨\u0006\r"}, d2 = {"Lcom/ironsource/mediationsdk/events/EventsCollection;", "T", "", "contains", "", "value", "(Ljava/lang/Object;)Z", "size", "", "", "CombinedEvents", "Sorted", "SplitEvents", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface c<T> {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010 \n\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B5\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0004j\b\u0012\u0004\u0012\u00028\u0001`\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0004j\b\u0012\u0004\u0012\u00028\u0001`\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0004j\b\u0012\u0004\u0012\u00028\u0001`\u0005X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0004j\b\u0012\u0004\u0012\u00028\u0001`\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ironsource/mediationsdk/events/EventsCollection$CombinedEvents;", "T", "Lcom/ironsource/mediationsdk/events/EventsCollection;", "a", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "contains", "", "value", "(Ljava/lang/Object;)Z", "size", "", "", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a<T> implements c<T> {
        private final ArrayList<T> a;
        private final ArrayList<T> b;

        public a(ArrayList<T> arrayList, ArrayList<T> arrayList2) {
            Intrinsics.checkNotNullParameter(arrayList, "a");
            Intrinsics.checkNotNullParameter(arrayList2, "b");
            this.a = arrayList;
            this.b = arrayList2;
        }

        public final List<T> a() {
            return CollectionsKt.plus(this.a, this.b);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\bJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\bJ\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ironsource/mediationsdk/events/EventsCollection$SplitEvents;", "T", "Lcom/ironsource/mediationsdk/events/EventsCollection;", "collection", "maxEventsPerBatch", "", "(Lcom/ironsource/mediationsdk/events/EventsCollection;I)V", "origin", "", "contains", "", "value", "(Ljava/lang/Object;)Z", "eventsToSave", "eventsToSend", "size", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b<T> implements c<T> {
        private final int a;
        private final List<T> b;

        public b(c<T> cVar, int i) {
            Intrinsics.checkNotNullParameter(cVar, "collection");
            this.a = i;
            this.b = cVar.a();
        }

        public final List<T> a() {
            return this.b;
        }

        public final List<T> b() {
            List<T> list = this.b;
            return list.subList(0, RangesKt.coerceAtMost(list.size(), this.a));
        }

        public final List<T> c() {
            int size = this.b.size();
            int i = this.a;
            if (size <= i) {
                return CollectionsKt.emptyList();
            }
            List<T> list = this.b;
            return list.subList(i, list.size());
        }
    }

    List<T> a();
}
