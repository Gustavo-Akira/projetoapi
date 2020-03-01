package com.example.demo.entities.enums;

public enum Status {
    NOT_START(1),
    ONGOING(2),
    REVISION(3),
    DELETED(4),
    FINISHED(5);

    private int code;

    private Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Status valueOf(int code) {
        for (Status value : Status.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
