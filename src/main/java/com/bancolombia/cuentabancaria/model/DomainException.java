package com.bancolombia.cuentabancaria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
public class DomainException extends IOException {

    private final transient Object errorModel;

    public DomainException(String msg, Object errorModel) {
        super(msg);
        this.errorModel = errorModel;
    }

    public DomainException(String msg, Throwable cause, Object errorModel) {
        super(msg, cause);
        this.errorModel = errorModel;
    }

    public DomainException(int code, String title, String msg) {
        this(msg, Map.of("code", code, "title", title, "detail", msg));
    }

    public Object getErrorModel1() {
        return errorModel;
    }
}
