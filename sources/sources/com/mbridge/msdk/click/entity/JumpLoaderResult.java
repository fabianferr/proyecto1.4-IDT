package com.mbridge.msdk.click.entity;

import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

public class JumpLoaderResult implements NoProGuard, Serializable {
    public static final int CODE_DOWNLOAD = 3;
    public static final int CODE_LINK = 2;
    public static final int CODE_MARKET = 1;
    public static final int CODE_NULL = 4;
    private static final long serialVersionUID = 1;
    private int code;
    private String content;
    private String exceptionMsg;
    private String header;
    private boolean is302Jump;
    private boolean jumpDone;
    private String msg;
    private String noticeurl;
    private int statusCode;
    private boolean success;
    private int type;
    private String url;

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public boolean isIs302Jump() {
        return this.is302Jump;
    }

    public void setIs302Jump(boolean z) {
        this.is302Jump = z;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String str) {
        this.header = str;
    }

    public String getExceptionMsg() {
        return this.exceptionMsg;
    }

    public void setExceptionMsg(String str) {
        this.exceptionMsg = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getNoticeurl() {
        return this.noticeurl;
    }

    public void setNoticeurl(String str) {
        this.noticeurl = str;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public boolean isjumpDone() {
        return this.jumpDone;
    }

    public void setjumpDone(boolean z) {
        this.jumpDone = z;
    }
}
