package io.monedata.iabtcf.exceptions;

public class UnsupportedVersionException extends TCStringDecodeException {
    private static final long serialVersionUID = -775269289273925740L;

    public UnsupportedVersionException(String str) {
        super(str);
    }
}
