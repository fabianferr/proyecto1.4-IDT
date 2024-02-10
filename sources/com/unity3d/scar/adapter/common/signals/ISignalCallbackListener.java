package com.unity3d.scar.adapter.common.signals;

public interface ISignalCallbackListener<T> {
    void onFailure(String str);

    void onSuccess(String str, String str2, T t);
}
