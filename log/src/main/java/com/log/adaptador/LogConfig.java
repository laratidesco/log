package com.log.adaptador;

import com.log.model.LogRegister;

/**
 *
 * @author lara_
 */
public class LogConfig {
    private static LogConfig instance;
    private String formatoLog;
    private ILogAdapter log;

    private LogConfig() {

    }

    //Singleton
    public static LogConfig getInstance() {
        if (instance == null) {
            instance = new LogConfig();
        }
        return instance;
    }

    public String getLogFormat() {
        return formatoLog;
    }

    public void setLogFormat(String logFormat) {
        if(logFormat.equalsIgnoreCase("CSV")){
            ILogAdapter logTeste = new CSVAdapter();
            this.formatoLog = logFormat;
            this.log = logTeste;
        } else if(logFormat.equalsIgnoreCase("JSON")) {
            ILogAdapter logTeste = new JSONAdapter();
            this.formatoLog = logFormat;
            this.log = logTeste;
        }
    }
    
    public void novoRegistro(LogRegister registro){
        log.registrarLog(registro);
    }
}

