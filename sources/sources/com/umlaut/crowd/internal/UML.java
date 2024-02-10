package com.umlaut.crowd.internal;

public interface UML {
    void onExportProgress(int i, int i2);

    void onExportStart();

    void onUploadError();

    void onUploadFinished();

    void onUploadProgress(int i, int i2);

    void onUploadStart();
}
