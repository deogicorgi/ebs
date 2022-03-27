package com.deogicorgi.core.values;

import java.util.Arrays;

public enum TTCStatusValue {

    READY(1, "준비완료"),
    CANCEL(0, "실패");

    private final Integer code;
    private final String value;

    TTCStatusValue(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public static TTCStatusValue getStatus(Integer code) {
        return Arrays.stream(values())
                .filter(statusValue -> statusValue.code.equals(code))
                .findFirst()
                .orElse(null);
    }

    public static TTCStatusValue getStatus(String value) {
        return Arrays.stream(values())
                .filter(statusValue -> statusValue.value.equals(value))
                .findFirst()
                .orElse(null);
    }
}
