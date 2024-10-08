package com.bancolombia.cuentabancaria.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class TransaccionRQ {

    @NotNull(message = "La cuenta no puede ser nula")
    private String cuenta;

    @NotNull(message = "El valor no puede ser nulo")
    @Positive(message = "El valor debe ser positivo")
    private BigDecimal valor;

    public TransaccionRQ(String cuenta, BigDecimal valor) {
        this.cuenta = cuenta;
        this.valor = valor;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
