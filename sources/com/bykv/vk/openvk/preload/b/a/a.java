package com.bykv.vk.openvk.preload.b.a;

import java.util.ArrayList;
import java.util.List;
import org.koin.core.instance.InstanceFactory;

/* compiled from: ParallelException */
public final class a extends Exception {
    private List<Throwable> a;

    public a(List<Throwable> list) {
        this.a = list;
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Throwable a2 : list) {
                a(a2, arrayList);
            }
            setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]));
        }
    }

    private static void a(Throwable th, List<StackTraceElement> list) {
        while (th != null) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            for (int i = 0; i < length; i++) {
                StackTraceElement stackTraceElement = stackTrace[i];
                if (i == 0) {
                    String message = th.getMessage();
                    StringBuilder sb = new StringBuilder("\b\b\b\nCaused by:");
                    if (message == null) {
                        message = "";
                    }
                    sb.append(message);
                    sb.append(InstanceFactory.ERROR_SEPARATOR);
                    sb.append(stackTraceElement.getClassName());
                    list.add(new StackTraceElement(sb.toString(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber()));
                } else {
                    list.add(stackTraceElement);
                }
            }
            th = th.getCause();
        }
    }
}
