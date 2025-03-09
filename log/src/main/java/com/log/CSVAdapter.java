package com.log;

/**
 *
 * @author lara_
 */
public class CSVAdapter implements ILogAdapter {
    private CSVPrinter csvLog;

    public CSVAdapter() {
        this.csvLog = new CSVPrinter();
    }

    @Override
    public void registrarLog(LogRegister log) {
        csvLog.escreveLog(log);
    }

}

