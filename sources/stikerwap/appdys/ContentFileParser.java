package stikerwap.appdys;

import android.text.TextUtils;
import android.util.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class ContentFileParser {
    private static final int LIMIT_EMOJI_COUNT = 3;

    ContentFileParser() {
    }

    static List<StickerPack> parseStickerPacks(InputStream inputStream) throws IOException, IllegalStateException {
        try {
            return readStickerPacks(new JsonReader(new InputStreamReader(inputStream)));
        } catch (Exception unused) {
            return null;
        }
    }

    private static List<StickerPack> readStickerPacks(JsonReader jsonReader) throws IOException, IllegalStateException {
        ArrayList<StickerPack> arrayList = new ArrayList<>();
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (StickerContentProvider.ANDROID_APP_DOWNLOAD_LINK_IN_QUERY.equals(nextName)) {
                str = jsonReader.nextString();
            } else if ("ios_app_store_link".equals(nextName)) {
                str2 = jsonReader.nextString();
            } else if ("sticker_packs".equals(nextName)) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(readStickerPack(jsonReader));
                }
                jsonReader.endArray();
            } else {
                throw new IllegalStateException("unknown field in json: " + nextName);
            }
        }
        jsonReader.endObject();
        if (arrayList.size() != 0) {
            for (StickerPack stickerPack : arrayList) {
                stickerPack.setAndroidPlayStoreLink(str);
                stickerPack.setIosAppStoreLink(str2);
            }
            return arrayList;
        }
        throw new IllegalStateException("sticker pack list cannot be empty");
    }

    private static StickerPack readStickerPack(JsonReader jsonReader) throws IOException, IllegalStateException {
        jsonReader.beginObject();
        List<Sticker> list = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = "";
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1618432855:
                    if (nextName.equals("identifier")) {
                        c = 0;
                        break;
                    }
                    break;
                case -692149211:
                    if (nextName.equals("privacy_policy_website")) {
                        c = 1;
                        break;
                    }
                    break;
                case -659123977:
                    if (nextName.equals(StickerContentProvider.ANIMATED_STICKER_PACK)) {
                        c = 2;
                        break;
                    }
                    break;
                case -5607704:
                    if (nextName.equals("license_agreement_website")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals("name")) {
                        c = 4;
                        break;
                    }
                    break;
                case 335244632:
                    if (nextName.equals("publisher_website")) {
                        c = 5;
                        break;
                    }
                    break;
                case 597456295:
                    if (nextName.equals(StickerContentProvider.IMAGE_DATA_VERSION)) {
                        c = 6;
                        break;
                    }
                    break;
                case 967150217:
                    if (nextName.equals("tray_image_file")) {
                        c = 7;
                        break;
                    }
                    break;
                case 993370168:
                    if (nextName.equals("avoid_cache")) {
                        c = 8;
                        break;
                    }
                    break;
                case 1414128537:
                    if (nextName.equals("publisher_email")) {
                        c = 9;
                        break;
                    }
                    break;
                case 1447404028:
                    if (nextName.equals("publisher")) {
                        c = 10;
                        break;
                    }
                    break;
                case 1531715286:
                    if (nextName.equals("stickers")) {
                        c = 11;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    str7 = jsonReader.nextString();
                    break;
                case 2:
                    z = jsonReader.nextBoolean();
                    break;
                case 3:
                    str8 = jsonReader.nextString();
                    break;
                case 4:
                    str2 = jsonReader.nextString();
                    break;
                case 5:
                    str6 = jsonReader.nextString();
                    break;
                case 6:
                    str9 = jsonReader.nextString();
                    break;
                case 7:
                    str4 = jsonReader.nextString();
                    break;
                case 8:
                    z2 = jsonReader.nextBoolean();
                    break;
                case 9:
                    str5 = jsonReader.nextString();
                    break;
                case 10:
                    str3 = jsonReader.nextString();
                    break;
                case 11:
                    list = readStickers(jsonReader);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException("identifier cannot be empty");
        } else if (TextUtils.isEmpty(str2)) {
            throw new IllegalStateException("name cannot be empty");
        } else if (TextUtils.isEmpty(str3)) {
            throw new IllegalStateException("publisher cannot be empty");
        } else if (TextUtils.isEmpty(str4)) {
            throw new IllegalStateException("tray_image_file cannot be empty");
        } else if (list == null || list.size() == 0) {
            throw new IllegalStateException("sticker list is empty");
        } else if (str.contains("..") || str.contains("/")) {
            throw new IllegalStateException("identifier should not contain .. or / to prevent directory traversal");
        } else if (!TextUtils.isEmpty(str9)) {
            jsonReader.endObject();
            StickerPack stickerPack = new StickerPack(str, str2, str3, str4, str5, str6, str7, str8, str9, z, z2);
            stickerPack.setStickers(list);
            return stickerPack;
        } else {
            throw new IllegalStateException("image_data_version should not be empty");
        }
    }

    private static List<Sticker> readStickers(JsonReader jsonReader) throws IOException, IllegalStateException {
        jsonReader.beginArray();
        ArrayList arrayList = new ArrayList();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            ArrayList arrayList2 = new ArrayList(3);
            String str = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("image_file".equals(nextName)) {
                    str = jsonReader.nextString();
                } else if ("emojis".equals(nextName)) {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList2.add(jsonReader.nextString());
                    }
                    jsonReader.endArray();
                } else {
                    throw new IllegalStateException("unknown field in json: " + nextName);
                }
            }
            jsonReader.endObject();
            if (TextUtils.isEmpty(str)) {
                throw new IllegalStateException("sticker image_file cannot be empty");
            } else if (!str.endsWith(".webp")) {
                throw new IllegalStateException("image file for stickers should be webp files, image file is: " + str);
            } else if (str.contains("..") || str.contains("/")) {
                throw new IllegalStateException("the file name should not contain .. or / to prevent directory traversal, image file is:" + str);
            } else {
                arrayList.add(new Sticker(str, (List<String>) arrayList2));
            }
        }
        jsonReader.endArray();
        return arrayList;
    }
}
