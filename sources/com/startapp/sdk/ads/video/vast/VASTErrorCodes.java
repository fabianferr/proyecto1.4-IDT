package com.startapp.sdk.ads.video.vast;

/* compiled from: Sta */
public enum VASTErrorCodes {
    ErrorNone(0),
    XMLParsingError(100),
    WrapperTimeout(301),
    WrapperNoReponse(303),
    GeneralLinearError(400),
    FileNotFound(401),
    TimeoutMediaFileURI(402),
    MediaFileDisplayError(405),
    UndefinedError(900),
    SAProcessSuccess(20000);
    
    private int value;

    /* access modifiers changed from: public */
    VASTErrorCodes(int i) {
        this.value = i;
    }

    public int a() {
        return this.value;
    }
}
