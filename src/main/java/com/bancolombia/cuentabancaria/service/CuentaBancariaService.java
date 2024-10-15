package com.bancolombia.cuentabancaria.service;

import com.bancolombia.cuentabancaria.model.CuentaBancariaEntity;
import com.bancolombia.cuentabancaria.model.TransaccionRQ;
import com.bancolombia.cuentabancaria.repository.CuentasBancariasBD;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CuentaBancariaService {

    private CuentasBancariasBD cuentasBancariasBD;

    public boolean validSaldo(BigDecimal valor){
        if(valor.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("El saldo no puede ser negativo");
        }
        return true;
    }

    public CuentaBancariaEntity getCuenta(String cuenta){
        return cuentasBancariasBD.getCuenta(cuenta);
    }

    public CuentaBancariaEntity deposito(TransaccionRQ transaccionRQ){
        CuentaBancariaEntity cuentaEntity = cuentasBancariasBD.getCuenta(transaccionRQ.getCuenta());
        if(cuentaEntity == null){
            throw new NullPointerException("La Cuenta bancaria no existe");
        }else if(validSaldo(transaccionRQ.getValor())){
            cuentaEntity.deposito(transaccionRQ.getValor());
        }
        return cuentaEntity;
    }

    public CuentaBancariaEntity retiro(TransaccionRQ transaccionRQ){
        CuentaBancariaEntity cuentaEntity = cuentasBancariasBD.getCuenta(transaccionRQ.getCuenta());
        if(cuentaEntity == null){
            throw new NullPointerException("La Cuenta bancaria no existe");
        }else if(validSaldo(transaccionRQ.getValor())){
            cuentaEntity.retiro(transaccionRQ.getValor());
        }
        return cuentaEntity;
    }
}
