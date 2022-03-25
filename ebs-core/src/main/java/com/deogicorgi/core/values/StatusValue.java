package com.deogicorgi.core.values;

import java.util.Arrays;

public enum StatusValue {

    USE(1, "정상"),
    EXPIRED(2, "만료"),
    STOP(0, "정지");

    private final Integer code;
    private final String value;

    StatusValue(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public static StatusValue getStatus(Integer code) {
        return Arrays.stream(values())
                .filter(statusValue -> statusValue.code.equals(code))
                .findFirst()
                .orElse(null);
    }

    public static StatusValue getStatus(String value) {
        return Arrays.stream(values())
                .filter(statusValue -> statusValue.value.equals(value))
                .findFirst()
                .orElse(null);
    }
}
