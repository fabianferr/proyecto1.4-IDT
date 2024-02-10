package com.cellrebel.sdk.utils;

class RootNative {
    private static boolean a = true;

    static {
        try {
            System.loadLibrary("tool-checker");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    RootNative() {
    }

    public boolean a() {
        return a;
    }

    public native int checkForRoot(Object[] objArr);

    public native int setLogDebugMessages(boolean z);
}
