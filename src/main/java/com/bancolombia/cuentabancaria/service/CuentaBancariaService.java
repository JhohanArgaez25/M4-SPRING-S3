package com.bancolombia.cuentabancaria.service;

import com.bancolombia.cuentabancaria.model.CuentaBancariaEntity;
import com.bancolombia.cuentabancaria.model.DomainException;
import com.bancolombia.cuentabancaria.repository.CuentasBancariasBD;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CuentaBancariaService {

    private CuentasBancariasBD cuentasBancariasBD;

    public boolean validSaldo(BigDecimal valor) throws DomainException {
        if(valor.compareTo(BigDecimal.ZERO) < 0){
            throw new DomainException(1, "Saldo negativo", "El saldo no puede ser negativo");
        }
        return true;
    }

    public CuentaBancariaEntity getCuenta(String cuenta){
        return cuentasBancariasBD.getCuenta(cuenta);
    }
}
