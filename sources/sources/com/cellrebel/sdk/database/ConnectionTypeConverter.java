package com.cellrebel.sdk.database;

public class ConnectionTypeConverter {
    public ConnectionType a(String str) {
        if (str == null) {
            return null;
        }
        for (ConnectionType connectionType : ConnectionType.values()) {
            if (connectionType.a.equals(str)) {
                return connectionType;
            }
        }
        return ConnectionType.UNKNOWN;
    }

    public String a(ConnectionType connectionType) {
        if (connectionType == null) {
            return null;
        }
        return connectionType.a;
    }
}
