package stikerwap.appdys;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.media3.common.MimeTypes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StickerContentProvider extends ContentProvider {
    public static final String ANDROID_APP_DOWNLOAD_LINK_IN_QUERY = "android_play_store_link";
    public static final String ANIMATED_STICKER_PACK = "animated_sticker_pack";
    public static final Uri AUTHORITY_URI = new Uri.Builder().scheme("content").authority(BuildConfig.CONTENT_PROVIDER_AUTHORITY).appendPath("metadata").build();
    public static final String AVOID_CACHE = "whatsapp_will_not_cache_stickers";
    private static final String CONTENT_FILE_NAME = "contents.json";
    public static final String IMAGE_DATA_VERSION = "image_data_version";
    public static final String IOS_APP_DOWNLOAD_LINK_IN_QUERY = "ios_app_download_link";
    public static final String LICENSE_AGREENMENT_WEBSITE = "sticker_pack_license_agreement_website";
    private static final UriMatcher MATCHER = new UriMatcher(-1);
    private static final String METADATA = "metadata";
    private static final int METADATA_CODE = 1;
    private static final int METADATA_CODE_FOR_SINGLE_PACK = 2;
    public static final String PRIVACY_POLICY_WEBSITE = "sticker_pack_privacy_policy_website";
    public static final String PUBLISHER_EMAIL = "sticker_pack_publisher_email";
    public static final String PUBLISHER_WEBSITE = "sticker_pack_publisher_website";
    static final String STICKERS = "stickers";
    static final String STICKERS_ASSET = "stickers_asset";
    private static final int STICKERS_ASSET_CODE = 4;
    private static final int STICKERS_CODE = 3;
    public static final String STICKER_FILE_EMOJI_IN_QUERY = "sticker_emoji";
    public static final String STICKER_FILE_NAME_IN_QUERY = "sticker_file_name";
    public static final String STICKER_PACK_ICON_IN_QUERY = "sticker_pack_icon";
    public static final String STICKER_PACK_IDENTIFIER_IN_QUERY = "sticker_pack_identifier";
    public static final String STICKER_PACK_NAME_IN_QUERY = "sticker_pack_name";
    public static final String STICKER_PACK_PUBLISHER_IN_QUERY = "sticker_pack_publisher";
    private static final int STICKER_PACK_TRAY_ICON_CODE = 5;
    private List<StickerPack> stickerPackList;

    public boolean onCreate() {
        if (BuildConfig.CONTENT_PROVIDER_AUTHORITY.startsWith(getContext().getPackageName())) {
            UriMatcher uriMatcher = MATCHER;
            uriMatcher.addURI(BuildConfig.CONTENT_PROVIDER_AUTHORITY, "metadata", 1);
            uriMatcher.addURI(BuildConfig.CONTENT_PROVIDER_AUTHORITY, "metadata/*", 2);
            uriMatcher.addURI(BuildConfig.CONTENT_PROVIDER_AUTHORITY, "stickers/*", 3);
            return true;
        }
        throw new IllegalStateException("your authority (stikerwap.appdys.stickercontentprovider) for the content provider should start with your package name: " + getContext().getPackageName());
    }

    private void ini() {
        List<StickerPack> stickerPackList2 = getStickerPackList();
        if (stickerPackList2 != null) {
            for (StickerPack next : stickerPackList2) {
                UriMatcher uriMatcher = MATCHER;
                uriMatcher.addURI(BuildConfig.CONTENT_PROVIDER_AUTHORITY, "stickers_asset/" + next.identifier + "/" + next.trayImageFile, 5);
                for (Sticker sticker : next.getStickers()) {
                    UriMatcher uriMatcher2 = MATCHER;
                    uriMatcher2.addURI(BuildConfig.CONTENT_PROVIDER_AUTHORITY, "stickers_asset/" + next.identifier + "/" + sticker.imageFileName, 4);
                }
            }
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        ini();
        int match = MATCHER.match(uri);
        if (match == 1) {
            return getPackForAllStickerPacks(uri);
        }
        if (match == 2) {
            return getCursorForSingleStickerPack(uri);
        }
        if (match == 3) {
            return getStickersForAStickerPack(uri);
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    public AssetFileDescriptor openAssetFile(Uri uri, String str) {
        ini();
        int match = MATCHER.match(uri);
        if (match == 4 || match == 5) {
            return getImageAsset(uri);
        }
        return null;
    }

    public String getType(Uri uri) {
        ini();
        int match = MATCHER.match(uri);
        if (match == 1) {
            return "vnd.android.cursor.dir/vnd.stikerwap.appdys.stickercontentprovider.metadata";
        }
        if (match == 2) {
            return "vnd.android.cursor.item/vnd.stikerwap.appdys.stickercontentprovider.metadata";
        }
        if (match == 3) {
            return "vnd.android.cursor.dir/vnd.stikerwap.appdys.stickercontentprovider.stickers";
        }
        if (match == 4) {
            return MimeTypes.IMAGE_WEBP;
        }
        if (match == 5) {
            return MimeTypes.IMAGE_PNG;
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01b0, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01b2, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void readContentFile(android.content.Context r22) {
        /*
            r21 = this;
            r1 = r21
            monitor-enter(r21)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x01b3 }
            r0.<init>()     // Catch:{ all -> 0x01b3 }
            r1.stickerPackList = r0     // Catch:{ all -> 0x01b3 }
            android.content.Context r0 = r22.getApplicationContext()     // Catch:{ all -> 0x01b3 }
            stikerwap.appdys.config r0 = (stikerwap.appdys.config) r0     // Catch:{ all -> 0x01b3 }
            if (r0 == 0) goto L_0x01b1
            stikerwap.appdys.Seccion[] r2 = r0.secciones_a     // Catch:{ all -> 0x01b3 }
            if (r2 != 0) goto L_0x0018
            goto L_0x01b1
        L_0x0018:
            java.lang.String r2 = "sh"
            r3 = 0
            r4 = r22
            android.content.SharedPreferences r2 = r4.getSharedPreferences(r2, r3)     // Catch:{ all -> 0x01b3 }
            android.content.pm.PackageManager r5 = r22.getPackageManager()     // Catch:{ all -> 0x01b3 }
            android.content.pm.ApplicationInfo r4 = r22.getApplicationInfo()     // Catch:{ NameNotFoundException -> 0x0030 }
            java.lang.String r4 = r4.packageName     // Catch:{ NameNotFoundException -> 0x0030 }
            android.content.pm.ApplicationInfo r4 = r5.getApplicationInfo(r4, r3)     // Catch:{ NameNotFoundException -> 0x0030 }
            goto L_0x0031
        L_0x0030:
            r4 = 0
        L_0x0031:
            if (r4 == 0) goto L_0x003c
            java.lang.CharSequence r4 = r5.getApplicationLabel(r4)     // Catch:{ all -> 0x01b3 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01b3 }
            goto L_0x003e
        L_0x003c:
            java.lang.String r4 = ""
        L_0x003e:
            java.lang.String r5 = ""
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x01b3 }
            if (r5 != 0) goto L_0x01af
            r15 = 0
        L_0x0047:
            stikerwap.appdys.Seccion[] r5 = r0.secciones_a     // Catch:{ all -> 0x01b3 }
            int r5 = r5.length     // Catch:{ all -> 0x01b3 }
            if (r15 >= r5) goto L_0x01af
            stikerwap.appdys.Seccion[] r5 = r0.secciones_a     // Catch:{ all -> 0x01b3 }
            r14 = r5[r15]     // Catch:{ all -> 0x01b3 }
            int r5 = r14.tipo     // Catch:{ all -> 0x01b3 }
            r6 = 13
            if (r5 != r6) goto L_0x01a7
            boolean r5 = r14.stickers     // Catch:{ all -> 0x01b3 }
            if (r5 == 0) goto L_0x01a7
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x01b3 }
            android.content.Context r6 = r21.getContext()     // Catch:{ all -> 0x01b3 }
            java.io.File r6 = r6.getFilesDir()     // Catch:{ all -> 0x01b3 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b3 }
            r7.<init>()     // Catch:{ all -> 0x01b3 }
            java.lang.String r8 = "img_s"
            r7.append(r8)     // Catch:{ all -> 0x01b3 }
            int r8 = r14.id     // Catch:{ all -> 0x01b3 }
            r7.append(r8)     // Catch:{ all -> 0x01b3 }
            java.lang.String r8 = "_ico"
            r7.append(r8)     // Catch:{ all -> 0x01b3 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x01b3 }
            r5.<init>(r6, r7)     // Catch:{ all -> 0x01b3 }
            boolean r5 = r5.exists()     // Catch:{ all -> 0x01b3 }
            if (r5 != 0) goto L_0x0087
            goto L_0x01a7
        L_0x0087:
            stikerwap.appdys.StickerPack r13 = new stikerwap.appdys.StickerPack     // Catch:{ all -> 0x01b3 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b3 }
            r5.<init>()     // Catch:{ all -> 0x01b3 }
            int r6 = r14.id     // Catch:{ all -> 0x01b3 }
            r5.append(r6)     // Catch:{ all -> 0x01b3 }
            java.lang.String r6 = ""
            r5.append(r6)     // Catch:{ all -> 0x01b3 }
            java.lang.String r6 = r5.toString()     // Catch:{ all -> 0x01b3 }
            java.lang.String r7 = r14.titulo     // Catch:{ all -> 0x01b3 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b3 }
            r5.<init>()     // Catch:{ all -> 0x01b3 }
            java.lang.String r8 = "img_s"
            r5.append(r8)     // Catch:{ all -> 0x01b3 }
            int r8 = r14.id     // Catch:{ all -> 0x01b3 }
            r5.append(r8)     // Catch:{ all -> 0x01b3 }
            java.lang.String r8 = "_ico.png"
            r5.append(r8)     // Catch:{ all -> 0x01b3 }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x01b3 }
            r10 = 0
            r16 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b3 }
            r5.<init>()     // Catch:{ all -> 0x01b3 }
            long r11 = r14.v_stickers     // Catch:{ all -> 0x01b3 }
            r5.append(r11)     // Catch:{ all -> 0x01b3 }
            java.lang.String r8 = ""
            r5.append(r8)     // Catch:{ all -> 0x01b3 }
            java.lang.String r18 = r5.toString()     // Catch:{ all -> 0x01b3 }
            boolean r12 = r14.stickers_anim     // Catch:{ all -> 0x01b3 }
            r19 = 0
            r5 = r13
            r8 = r4
            r11 = 0
            r17 = r12
            r12 = 0
            r20 = r13
            r13 = r16
            r3 = r14
            r14 = r18
            r18 = r15
            r15 = r17
            r16 = r19
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x01b3 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x01b3 }
            r5.<init>()     // Catch:{ all -> 0x01b3 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b3 }
            r6.<init>()     // Catch:{ all -> 0x01b3 }
            java.lang.String r7 = "gal_a_"
            r6.append(r7)     // Catch:{ all -> 0x01b3 }
            int r3 = r3.id     // Catch:{ all -> 0x01b3 }
            r6.append(r3)     // Catch:{ all -> 0x01b3 }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x01b3 }
            java.lang.String r6 = ""
            java.lang.String r3 = r2.getString(r3, r6)     // Catch:{ all -> 0x01b3 }
            java.lang.String r6 = "/"
            java.lang.String[] r3 = r3.split(r6)     // Catch:{ all -> 0x01b3 }
            int r6 = r3.length     // Catch:{ all -> 0x01b3 }
            r7 = 0
        L_0x010c:
            if (r7 >= r6) goto L_0x018a
            r8 = r3[r7]     // Catch:{ all -> 0x01b3 }
            java.lang.String r9 = ""
            boolean r9 = r8.equals(r9)     // Catch:{ all -> 0x01b3 }
            if (r9 != 0) goto L_0x0186
            java.lang.String r9 = "@"
            java.lang.String[] r8 = r8.split(r9)     // Catch:{ all -> 0x01b3 }
            int r9 = r8.length     // Catch:{ all -> 0x01b3 }
            r10 = 4
            if (r9 == r10) goto L_0x012a
            int r9 = r8.length     // Catch:{ all -> 0x01b3 }
            r10 = 5
            if (r9 == r10) goto L_0x012a
            int r9 = r8.length     // Catch:{ all -> 0x01b3 }
            r10 = 6
            if (r9 != r10) goto L_0x0186
        L_0x012a:
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x01b3 }
            android.content.Context r10 = r21.getContext()     // Catch:{ all -> 0x01b3 }
            java.io.File r10 = r10.getFilesDir()     // Catch:{ all -> 0x01b3 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b3 }
            r11.<init>()     // Catch:{ all -> 0x01b3 }
            java.lang.String r12 = "gal_"
            r11.append(r12)     // Catch:{ all -> 0x01b3 }
            r12 = 0
            r13 = r8[r12]     // Catch:{ all -> 0x01b3 }
            r11.append(r13)     // Catch:{ all -> 0x01b3 }
            java.lang.String r12 = "_g.webp"
            r11.append(r12)     // Catch:{ all -> 0x01b3 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x01b3 }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x01b3 }
            boolean r9 = r9.exists()     // Catch:{ all -> 0x01b3 }
            if (r9 != 0) goto L_0x0157
            goto L_0x0186
        L_0x0157:
            stikerwap.appdys.Sticker r9 = new stikerwap.appdys.Sticker     // Catch:{ all -> 0x01b3 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b3 }
            r10.<init>()     // Catch:{ all -> 0x01b3 }
            java.lang.String r11 = "gal_"
            r10.append(r11)     // Catch:{ all -> 0x01b3 }
            r11 = 0
            r8 = r8[r11]     // Catch:{ all -> 0x01b3 }
            r10.append(r8)     // Catch:{ all -> 0x01b3 }
            java.lang.String r8 = "_g.webp"
            r10.append(r8)     // Catch:{ all -> 0x01b3 }
            java.lang.String r8 = r10.toString()     // Catch:{ all -> 0x01b3 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x01b3 }
            r10.<init>()     // Catch:{ all -> 0x01b3 }
            r9.<init>((java.lang.String) r8, (java.util.List<java.lang.String>) r10)     // Catch:{ all -> 0x01b3 }
            r5.add(r9)     // Catch:{ all -> 0x01b3 }
            int r8 = r5.size()     // Catch:{ all -> 0x01b3 }
            r9 = 29
            if (r8 <= r9) goto L_0x0187
            goto L_0x018b
        L_0x0186:
            r11 = 0
        L_0x0187:
            int r7 = r7 + 1
            goto L_0x010c
        L_0x018a:
            r11 = 0
        L_0x018b:
            int r3 = r5.size()     // Catch:{ all -> 0x01b3 }
            r6 = 2
            if (r3 <= r6) goto L_0x01aa
            r3 = r20
            r3.setStickers(r5)     // Catch:{ all -> 0x01b3 }
            java.util.List<stikerwap.appdys.StickerPack> r5 = r1.stickerPackList     // Catch:{ all -> 0x01b3 }
            r5.add(r3)     // Catch:{ all -> 0x01b3 }
            java.util.List<stikerwap.appdys.StickerPack> r3 = r1.stickerPackList     // Catch:{ all -> 0x01b3 }
            int r3 = r3.size()     // Catch:{ all -> 0x01b3 }
            r5 = 9
            if (r3 <= r5) goto L_0x01aa
            goto L_0x01af
        L_0x01a7:
            r18 = r15
            r11 = 0
        L_0x01aa:
            int r15 = r18 + 1
            r3 = 0
            goto L_0x0047
        L_0x01af:
            monitor-exit(r21)
            return
        L_0x01b1:
            monitor-exit(r21)
            return
        L_0x01b3:
            r0 = move-exception
            monitor-exit(r21)
            goto L_0x01b7
        L_0x01b6:
            throw r0
        L_0x01b7:
            goto L_0x01b6
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.StickerContentProvider.readContentFile(android.content.Context):void");
    }

    private List<StickerPack> getStickerPackList() {
        readContentFile(getContext());
        return this.stickerPackList;
    }

    private Cursor getPackForAllStickerPacks(Uri uri) {
        return getStickerPackInfo(uri, getStickerPackList());
    }

    private Cursor getCursorForSingleStickerPack(Uri uri) {
        List<StickerPack> stickerPackList2 = getStickerPackList();
        if (stickerPackList2 != null) {
            String lastPathSegment = uri.getLastPathSegment();
            for (StickerPack next : stickerPackList2) {
                if (lastPathSegment.equals(next.identifier)) {
                    return getStickerPackInfo(uri, Collections.singletonList(next));
                }
            }
        }
        return getStickerPackInfo(uri, new ArrayList());
    }

    private Cursor getStickerPackInfo(Uri uri, List<StickerPack> list) {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{STICKER_PACK_IDENTIFIER_IN_QUERY, STICKER_PACK_NAME_IN_QUERY, STICKER_PACK_PUBLISHER_IN_QUERY, STICKER_PACK_ICON_IN_QUERY, ANDROID_APP_DOWNLOAD_LINK_IN_QUERY, IOS_APP_DOWNLOAD_LINK_IN_QUERY, PUBLISHER_EMAIL, PUBLISHER_WEBSITE, PRIVACY_POLICY_WEBSITE, LICENSE_AGREENMENT_WEBSITE, IMAGE_DATA_VERSION, ANIMATED_STICKER_PACK, AVOID_CACHE});
        for (StickerPack next : list) {
            MatrixCursor.RowBuilder newRow = matrixCursor.newRow();
            newRow.add(next.identifier);
            newRow.add(next.name);
            newRow.add(next.publisher);
            newRow.add(next.trayImageFile);
            newRow.add(next.androidPlayStoreLink);
            newRow.add(next.iosAppStoreLink);
            newRow.add(next.publisherEmail);
            newRow.add(next.publisherWebsite);
            newRow.add(next.privacyPolicyWebsite);
            newRow.add(next.licenseAgreementWebsite);
            newRow.add(next.imageDataVersion);
            newRow.add(Integer.valueOf(next.animatedStickerPack ? 1 : 0));
            newRow.add(Integer.valueOf(next.avoidCache ? 1 : 0));
        }
        Uri uri2 = uri;
        matrixCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return matrixCursor;
    }

    private Cursor getStickersForAStickerPack(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{STICKER_FILE_NAME_IN_QUERY, STICKER_FILE_EMOJI_IN_QUERY});
        List<StickerPack> stickerPackList2 = getStickerPackList();
        if (stickerPackList2 != null) {
            for (StickerPack next : stickerPackList2) {
                if (lastPathSegment.equals(next.identifier)) {
                    for (Sticker next2 : next.getStickers()) {
                        matrixCursor.addRow(new Object[]{next2.imageFileName, TextUtils.join(",", next2.emojis)});
                    }
                }
            }
        }
        matrixCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return matrixCursor;
    }

    private AssetFileDescriptor getImageAsset(Uri uri) throws IllegalArgumentException {
        AssetManager assets = getContext().getAssets();
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 3) {
            String str = pathSegments.get(pathSegments.size() - 1);
            String str2 = pathSegments.get(pathSegments.size() - 2);
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("identifier is empty, uri: " + uri);
            } else if (!TextUtils.isEmpty(str)) {
                List<StickerPack> stickerPackList2 = getStickerPackList();
                if (stickerPackList2 == null) {
                    return null;
                }
                for (StickerPack next : stickerPackList2) {
                    if (str2.equals(next.identifier)) {
                        if (str.equals(next.trayImageFile)) {
                            return fetchFile(uri, assets, str, str2);
                        }
                        for (Sticker sticker : next.getStickers()) {
                            if (str.equals(sticker.imageFileName)) {
                                return fetchFile(uri, assets, str, str2);
                            }
                        }
                        continue;
                    }
                }
                return null;
            } else {
                throw new IllegalArgumentException("file name is empty, uri: " + uri);
            }
        } else {
            throw new IllegalArgumentException("path segments should be 3, uri is: " + uri);
        }
    }

    private AssetFileDescriptor fetchFile(Uri uri, AssetManager assetManager, String str, String str2) {
        if (str.endsWith("_ico.png")) {
            str = str.replace("_ico.png", "_ico");
        }
        File file = new File(getContext().getFilesDir(), str);
        if (!file.exists()) {
            return null;
        }
        try {
            return new AssetFileDescriptor(ParcelFileDescriptor.open(file, 268435456), 0, -1);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not supported");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Not supported");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not supported");
    }
}
