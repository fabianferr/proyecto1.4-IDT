package com.bykv.vk.openvk.preload.geckox.model;

import com.bykv.vk.openvk.preload.a.a.c;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class UpdatePackage {
    private String accessKey;
    @c(a = "channel")
    private String channel;
    @c(a = "channel_index")
    private int channelIndex;
    @c(a = "content")
    private Content content;
    @c(a = "group_name")
    private String groupName;
    private long localVersion;
    @c(a = "package_type")
    private int packageType;
    @c(a = "package_version")
    private long version;

    public static class Content {
        /* access modifiers changed from: private */
        @c(a = "package")
        public Package fullPackage;
        /* access modifiers changed from: private */
        @c(a = "patch")
        public Package patch;
        /* access modifiers changed from: private */
        @c(a = "strategies")
        public Strategy strategy;
    }

    public static final class FileType {
        public static final int COMPRESSED_FILE = 0;
        public static final int MY_ARCHIVE_FILE = 2;
        public static final int UNCOMPRESSED_FILE = 1;
    }

    public String getAccessKey() {
        return this.accessKey;
    }

    public void setAccessKey(String str) {
        this.accessKey = str;
    }

    public UpdatePackage() {
    }

    public UpdatePackage(long j, String str, Package packageR, Package packageR2) {
        this.version = j;
        this.channel = str;
        Content content2 = new Content();
        this.content = content2;
        Package unused = content2.fullPackage = packageR;
        Package unused2 = this.content.patch = packageR2;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public int getChannelIndex() {
        return this.channelIndex;
    }

    public void setChannelIndex(int i) {
        this.channelIndex = i;
    }

    public long getLocalVersion() {
        return this.localVersion;
    }

    public void setLocalVersion(long j) {
        this.localVersion = j;
    }

    public long getVersion() {
        return this.version;
    }

    public void setVersion(long j) {
        this.version = j;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public Package getFullPackage() {
        return this.content.fullPackage;
    }

    public void setFullPackage(Package packageR) {
        Package unused = this.content.fullPackage = packageR;
    }

    public Package getPatch() {
        return this.content.patch;
    }

    public void setPatch(Package packageR) {
        Package unused = this.content.patch = packageR;
    }

    public Strategy getStrategy() {
        return this.content.strategy;
    }

    public void setStrategy(Strategy strategy) {
        Strategy unused = this.content.strategy = strategy;
    }

    public boolean isFullUpdate() {
        return getFullPackage() != null && getFullPackage().getUrlList().size() > 0;
    }

    public boolean isPatchUpdate() {
        return getPatch() != null && getPatch().getUrlList().size() > 0;
    }

    public int getPackageType() {
        return this.packageType;
    }

    public String toString() {
        return "UpdatePackage{version=" + this.version + ", channel='" + this.channel + "', content=" + this.content + ", packageType=" + this.packageType + AbstractJsonLexerKt.END_OBJ;
    }

    public static class Package {
        @c(a = "id")
        long id;
        @c(a = "size")
        long length;
        @c(a = "md5")
        String md5;
        @Deprecated
        String url;
        @c(a = "url_list")
        List<String> urlList;

        public Package() {
        }

        public Package(int i, List<String> list, String str) {
            this.id = (long) i;
            this.urlList = list;
            this.md5 = str;
        }

        public long getId() {
            return this.id;
        }

        public void setId(int i) {
            this.id = (long) i;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public String getMd5() {
            return this.md5;
        }

        public void setMd5(String str) {
            this.md5 = str;
        }

        public long getLength() {
            return this.length;
        }

        public List<String> getUrlList() {
            return this.urlList;
        }

        public void setUrlList(List<String> list) {
            this.urlList = list;
        }

        public String toString() {
            return "Package{url='" + this.url + "', md5='" + this.md5 + "'}";
        }
    }

    public static class Strategy {
        @c(a = "del_if_download_failed")
        private boolean deleteIfFail;
        @c(a = "del_old_pkg_before_download")
        private boolean deleteOldPackageBeforeDownload;
        @c(a = "need_unzip")
        private boolean needUnzip;

        public Strategy(int i) {
            this.deleteIfFail = i != 1 ? false : true;
        }

        public boolean isDeleteIfFail() {
            return this.deleteIfFail;
        }

        public void setDeleteIfFail(boolean z) {
            this.deleteIfFail = z;
        }

        public boolean isDeleteOldPackageBeforeDownload() {
            return this.deleteOldPackageBeforeDownload;
        }

        public void setDeleteOldPackageBeforeDownload(boolean z) {
            this.deleteOldPackageBeforeDownload = z;
        }

        public boolean isNeedUnzip() {
            return this.needUnzip;
        }

        public void setNeedUnzip(boolean z) {
            this.needUnzip = z;
        }
    }
}
