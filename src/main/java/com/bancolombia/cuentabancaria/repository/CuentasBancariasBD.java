package com.bancolombia.cuentabancaria.repository;

import com.bancolombia.cuentabancaria.model.CuentaBancariaEntity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CuentasBancariasBD {

    private static Map<String, CuentaBancariaEntity> cuentaBancariaEntity = new HashMap<>(){
        {
            put("123451", new CuentaBancariaEntity("123451", BigDecimal.valueOf(1000)));
            put("123452", new CuentaBancariaEntity("123452", BigDecimal.valueOf(3000)));
            put("123453", new CuentaBancariaEntity("123453", BigDecimal.valueOf(5000)));
        }
    };

    public static CuentaBancariaEntity getCuenta(String cuenta){
        return cuentaBancariaEntity.get(cuenta);
    }
}
