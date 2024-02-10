package com.umlaut.crowd.internal;

public class w7 implements u5 {
    public a fail;
    public String message;

    public enum a {
        FAIL_UNKNOWN,
        FAIL_UNKNOWN_REQUEST,
        FAIL_REQUEST_FAILED,
        FAIL_WRONG_CONNECTION,
        FAIL_INVALID_PARAMETER,
        FAIL_INVALID_SIGNATURE,
        FAIL_NO_FREE_SLOTS
    }

    public v5 c() {
        return v5.MESSAGETYPE_FAIL;
    }

    public String toString() {
        return "ResponseFail [fail=" + this.fail + ", message=" + this.message + "]";
    }
}
