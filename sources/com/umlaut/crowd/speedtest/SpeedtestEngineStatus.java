package com.umlaut.crowd.speedtest;

public enum SpeedtestEngineStatus {
    IDLE,
    CONNECT_CONTROL,
    REQUEST,
    WAIT,
    CONNECT,
    INIT_TRACEROUTE,
    TRACEROUTE,
    END,
    ERROR,
    ABORTED,
    REGISTER,
    INIT,
    RUN
}
