package com.log.adaptador;

import com.log.adaptado.JSONPrinter;
import com.log.model.LogRegister;

/**
 *
 * @author lara_
 */
public class JSONAdapter implements ILogAdapter {
    private JSONPrinter jsonLog;

    public JSONAdapter() {
        this.jsonLog = new JSONPrinter();
    }

    @Override
    public void registrarLog(LogRegister log) {
       jsonLog.escreveLog(log);
    }
    
}
