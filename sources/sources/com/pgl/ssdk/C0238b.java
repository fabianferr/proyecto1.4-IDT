package com.pgl.ssdk;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* renamed from: com.pgl.ssdk.b  reason: case insensitive filesystem */
final class C0238b implements FileFilter {
    C0238b() {
    }

    public boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
