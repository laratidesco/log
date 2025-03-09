package com.log;

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
