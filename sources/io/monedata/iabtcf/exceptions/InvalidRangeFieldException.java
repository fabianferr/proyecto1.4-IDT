package io.monedata.iabtcf.exceptions;

public class InvalidRangeFieldException extends TCStringDecodeException {
    private static final long serialVersionUID = -7791569956366524902L;

    public InvalidRangeFieldException(String str) {
        super(str);
    }
}
