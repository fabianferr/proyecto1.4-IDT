package com.bykv.vk.openvk.preload.geckox.model;

import android.webkit.WebResourceResponse;

public class WebResourceResponseModel {
    public static final int ERROR_DEFAULT = -1;
    public static final int ERROR_INTERCEPT = 1;
    public static final int ERROR_NOT_FIND_BY_RESOURCE = 2;
    int errorType;
    WebResourceResponse webResourceResponse;

    public WebResourceResponseModel(int i, WebResourceResponse webResourceResponse2) {
        this.errorType = i;
        this.webResourceResponse = webResourceResponse2;
    }

    public int getMsg() {
        return this.errorType;
    }

    public void setMsg(int i) {
        this.errorType = i;
    }

    public WebResourceResponse getWebResourceResponse() {
        return this.webResourceResponse;
    }

    public void setWebResourceResponse(WebResourceResponse webResourceResponse2) {
        this.webResourceResponse = webResourceResponse2;
    }
}
