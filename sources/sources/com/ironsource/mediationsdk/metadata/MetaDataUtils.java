package com.ironsource.mediationsdk.metadata;

import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.metadata.MetaData;
import java.util.ArrayList;
import java.util.List;

public class MetaDataUtils {
    public static String checkMetaDataKeyValidity(String str) {
        return (str == null || str.length() > 64 || !str.matches("[A-Za-z0-9_\\-.]+")) ? "The MetaData key you entered is invalid. Please enter a key of maximum 64 characters that consists of only letters, digits and the following characters: . - _" : "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String checkMetaDataValueValidity(java.util.List<java.lang.String> r3) {
        /*
            int r0 = r3.size()
            if (r0 != 0) goto L_0x0009
            java.lang.String r3 = "The MetaData list should include at least one element."
            return r3
        L_0x0009:
            java.util.Iterator r3 = r3.iterator()
        L_0x000d:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x002e
            java.lang.Object r0 = r3.next()
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x002b
            int r1 = r0.length()
            r2 = 64
            if (r1 > r2) goto L_0x002b
            java.lang.String r1 = "[A-Za-z0-9_\\-.]+"
            boolean r0 = r0.matches(r1)
            if (r0 != 0) goto L_0x000d
        L_0x002b:
            java.lang.String r3 = "The MetaData value(s) you entered is invalid. Please enter a value of maximum 64 characters that consists of only letters, digits and the following characters: . - _"
            return r3
        L_0x002e:
            java.lang.String r3 = ""
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.metadata.MetaDataUtils.checkMetaDataValueValidity(java.util.List):java.lang.String");
    }

    public static MetaData formatMetaData(String str, List<String> list) {
        if (!isKnownKey(str)) {
            return new MetaData(str, list);
        }
        String lowerCase = StringUtils.toLowerCase(str);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String formatValueForType : list) {
            MetaData.MetaDataValueTypes valueTypeForKey = getValueTypeForKey(lowerCase);
            String formatValueForType2 = formatValueForType(formatValueForType, valueTypeForKey);
            arrayList.add(valueTypeForKey);
            arrayList2.add(formatValueForType2);
        }
        return new MetaData(lowerCase, arrayList2, arrayList);
    }

    public static String formatValueForType(String str, MetaData.MetaDataValueTypes metaDataValueTypes) {
        if (metaDataValueTypes != MetaData.MetaDataValueTypes.META_DATA_VALUE_BOOLEAN) {
            return str;
        }
        String str2 = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
        if (!str.equalsIgnoreCase(str2) && !str.equalsIgnoreCase("yes")) {
            str2 = "false";
            if (!str.equalsIgnoreCase(str2) && !str.equalsIgnoreCase("no")) {
                return "";
            }
        }
        return str2;
    }

    public static boolean getMetaDataBooleanValue(String str) {
        return !str.equals("false");
    }

    public static MetaData.MetaDataValueTypes getValueTypeForKey(String str) {
        return (str.equalsIgnoreCase("do_not_sell") || str.equalsIgnoreCase("is_child_directed") || str.equalsIgnoreCase("is_deviceid_optout") || str.equalsIgnoreCase("google_family_self_certified_sdks")) ? MetaData.MetaDataValueTypes.META_DATA_VALUE_BOOLEAN : MetaData.MetaDataValueTypes.META_DATA_VALUE_STRING;
    }

    public static boolean isKnownKey(String str) {
        return str.equalsIgnoreCase("do_not_sell") || str.equalsIgnoreCase("is_child_directed") || str.equalsIgnoreCase("is_deviceid_optout") || str.equalsIgnoreCase("is_test_suite") || str.equalsIgnoreCase("google_family_self_certified_sdks");
    }

    public static boolean isMediationKeysBeforeInit(String str) {
        return str.equalsIgnoreCase("is_deviceid_optout") || str.equalsIgnoreCase("google_family_self_certified_sdks");
    }

    public static boolean isMediationOnlyKey(String str) {
        return str.equalsIgnoreCase("is_child_directed") || str.equalsIgnoreCase("is_deviceid_optout") || str.equalsIgnoreCase("is_test_suite") || str.equalsIgnoreCase("google_family_self_certified_sdks");
    }

    public static boolean isValidCCPAMetaData(String str, String str2) {
        return isValidMetaData(str, "do_not_sell", str2);
    }

    public static boolean isValidMetaData(String str, String str2, String str3) {
        return str.equalsIgnoreCase(str2) && !TextUtils.isEmpty(str3);
    }
}
