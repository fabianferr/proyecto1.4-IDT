package com.mbridge.msdk.dycreator.bus;

final class Subscription {
    final Object a;
    final SubscriberMethod b;

    Subscription(Object obj, SubscriberMethod subscriberMethod) {
        this.a = obj;
        this.b = subscriberMethod;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        if (this.a != subscription.a || !this.b.equals(subscription.b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode() + this.b.d.hashCode();
    }
}
