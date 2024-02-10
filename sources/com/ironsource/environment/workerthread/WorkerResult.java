package com.ironsource.environment.workerthread;

import java.util.concurrent.Callable;

public abstract class WorkerResult<T> {

    public static final class Canceled<T> extends WorkerResult<T> {
        public Callable<T> callable;

        public Canceled(Callable<T> callable2) {
            super((byte) 0);
            this.callable = callable2;
        }
    }

    public static final class Completed<T> extends WorkerResult<T> {
        public T data;

        public Completed(T t) {
            super((byte) 0);
            this.data = t;
        }
    }

    public static final class Failed<T> extends WorkerResult<T> {
        public Callable<T> callable;
        public Exception exception;

        public Failed(Callable<T> callable2, Exception exc) {
            super((byte) 0);
            this.callable = callable2;
            this.exception = exc;
        }
    }

    private WorkerResult() {
    }

    /* synthetic */ WorkerResult(byte b) {
        this();
    }
}
