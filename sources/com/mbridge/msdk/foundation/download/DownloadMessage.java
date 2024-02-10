package com.mbridge.msdk.foundation.download;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.g.b;
import com.mbridge.msdk.foundation.tools.aa;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DownloadMessage<T> {
    private static final String TAG = "DownloadMessage";
    private T campaign;
    private boolean checkMD5 = false;
    private int downloadRate;
    private DownloadResourceType downloadResourceType;
    private String downloadUrl;
    private Map<String, Object> extraData;
    private String host;
    private boolean isUseCronet = false;
    private String md5 = "";
    private String resourceUrl;
    private String saveFileName;
    private String saveFilePath;

    public DownloadMessage(T t, String str, String str2, int i, DownloadResourceType downloadResourceType2) {
        this.campaign = t;
        this.downloadUrl = str;
        this.saveFileName = str2;
        this.downloadRate = i;
        this.downloadResourceType = downloadResourceType2;
        try {
            URL url = new URL(str);
            StringBuilder sb = new StringBuilder();
            this.host = url.getHost();
            sb.append(url.getProtocol());
            sb.append("://");
            sb.append(url.getHost());
            sb.append(url.getPath());
            this.resourceUrl = sb.toString();
        } catch (MalformedURLException unused) {
            this.resourceUrl = "";
        }
    }

    public T getCampaign() {
        return this.campaign;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getSaveFileName() {
        return this.saveFileName;
    }

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public boolean isCheckMD5() {
        return this.checkMD5;
    }

    public void setCheckMD5(boolean z) {
        this.checkMD5 = z;
    }

    public int getDownloadRate() {
        return this.downloadRate;
    }

    public void setDownloadRate(int i) {
        this.downloadRate = i;
    }

    public void addExtra(String str, Object obj) {
        if (this.extraData == null) {
            this.extraData = new HashMap(4);
        }
        this.extraData.put(str, obj);
    }

    public Object getExtra(String str) {
        Map<String, Object> map = this.extraData;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.extraData.get(str);
    }

    public DownloadResourceType getDownloadResourceType() {
        return this.downloadResourceType;
    }

    public String getSaveFilePath() {
        return this.saveFilePath;
    }

    public void setSaveFilePath(String str) {
        this.saveFilePath = str;
    }

    public String getResourceUrl() {
        return this.resourceUrl;
    }

    public void setUseCronetDownload(int i) {
        try {
            if (!TextUtils.isEmpty(this.downloadUrl)) {
                if (TextUtils.isEmpty(this.host)) {
                    this.host = new URL(this.downloadUrl).getHost();
                }
                boolean z = true;
                if (i != 1) {
                    if (i != 2) {
                        z = false;
                    }
                }
                this.isUseCronet = z;
                if (z) {
                    b.a(this.host);
                }
            }
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    public boolean canUseCronet() {
        return this.isUseCronet;
    }
}
