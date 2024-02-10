package org.apache.commons.logging.impl;

import java.io.Serializable;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class Log4JLogger implements Log, Serializable {
    private static final String FQCN;
    static /* synthetic */ Class class$org$apache$commons$logging$impl$Log4JLogger;
    static /* synthetic */ Class class$org$apache$log4j$Level;
    static /* synthetic */ Class class$org$apache$log4j$Priority;
    private static Priority traceLevel;
    private transient Logger logger;
    private String name;

    static {
        Class cls = class$org$apache$commons$logging$impl$Log4JLogger;
        if (cls == null) {
            cls = class$("org.apache.commons.logging.impl.Log4JLogger");
            class$org$apache$commons$logging$impl$Log4JLogger = cls;
        }
        FQCN = cls.getName();
        Class cls2 = class$org$apache$log4j$Priority;
        if (cls2 == null) {
            cls2 = class$("org.apache.log4j.Priority");
            class$org$apache$log4j$Priority = cls2;
        }
        Class cls3 = class$org$apache$log4j$Level;
        if (cls3 == null) {
            cls3 = class$("org.apache.log4j.Level");
            class$org$apache$log4j$Level = cls3;
        }
        if (cls2.isAssignableFrom(cls3)) {
            try {
                Class cls4 = class$org$apache$log4j$Level;
                if (cls4 == null) {
                    cls4 = class$("org.apache.log4j.Level");
                    class$org$apache$log4j$Level = cls4;
                }
                traceLevel = (Priority) cls4.getDeclaredField("TRACE").get((Object) null);
            } catch (Exception unused) {
                traceLevel = Priority.DEBUG;
            }
        } else {
            throw new InstantiationError("Log4J 1.2 not available");
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public Log4JLogger() {
        this.logger = null;
        this.name = null;
    }

    public Log4JLogger(String str) {
        this.logger = null;
        this.name = str;
        this.logger = getLogger();
    }

    public Log4JLogger(Logger logger2) {
        this.logger = null;
        this.name = null;
        if (logger2 != null) {
            this.name = logger2.getName();
            this.logger = logger2;
            return;
        }
        throw new IllegalArgumentException("Warning - null logger in constructor; possible log4j misconfiguration.");
    }

    public void trace(Object obj) {
        getLogger().log(FQCN, traceLevel, obj, (Throwable) null);
    }

    public void trace(Object obj, Throwable th) {
        getLogger().log(FQCN, traceLevel, obj, th);
    }

    public void debug(Object obj) {
        getLogger().log(FQCN, Priority.DEBUG, obj, (Throwable) null);
    }

    public void debug(Object obj, Throwable th) {
        getLogger().log(FQCN, Priority.DEBUG, obj, th);
    }

    public void info(Object obj) {
        getLogger().log(FQCN, Priority.INFO, obj, (Throwable) null);
    }

    public void info(Object obj, Throwable th) {
        getLogger().log(FQCN, Priority.INFO, obj, th);
    }

    public void warn(Object obj) {
        getLogger().log(FQCN, Priority.WARN, obj, (Throwable) null);
    }

    public void warn(Object obj, Throwable th) {
        getLogger().log(FQCN, Priority.WARN, obj, th);
    }

    public void error(Object obj) {
        getLogger().log(FQCN, Priority.ERROR, obj, (Throwable) null);
    }

    public void error(Object obj, Throwable th) {
        getLogger().log(FQCN, Priority.ERROR, obj, th);
    }

    public void fatal(Object obj) {
        getLogger().log(FQCN, Priority.FATAL, obj, (Throwable) null);
    }

    public void fatal(Object obj, Throwable th) {
        getLogger().log(FQCN, Priority.FATAL, obj, th);
    }

    public Logger getLogger() {
        if (this.logger == null) {
            this.logger = Logger.getLogger(this.name);
        }
        return this.logger;
    }

    public boolean isDebugEnabled() {
        return getLogger().isDebugEnabled();
    }

    public boolean isErrorEnabled() {
        return getLogger().isEnabledFor(Priority.ERROR);
    }

    public boolean isFatalEnabled() {
        return getLogger().isEnabledFor(Priority.FATAL);
    }

    public boolean isInfoEnabled() {
        return getLogger().isInfoEnabled();
    }

    public boolean isTraceEnabled() {
        return getLogger().isEnabledFor(traceLevel);
    }

    public boolean isWarnEnabled() {
        return getLogger().isEnabledFor(Priority.WARN);
    }
}
