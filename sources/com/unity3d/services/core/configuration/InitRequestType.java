package com.unity3d.services.core.configuration;

import com.facebook.share.internal.ShareConstants;

public enum InitRequestType {
    PRIVACY(ShareConstants.WEB_DIALOG_PARAM_PRIVACY),
    TOKEN("token_srr");
    
    private String _callType;

    private InitRequestType(String str) {
        this._callType = str;
    }

    public String getCallType() {
        return this._callType;
    }
}
