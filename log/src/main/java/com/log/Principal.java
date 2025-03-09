
package com.log;



/**
 *
 * @author lara_
 */
public class Principal {

    public static void main(String[] args) {
        LogConfig.getInstance().setLogFormat("CSV");
        LogConfig.getInstance().novoRegistro(new LogRegister("Exclusão", "Fábio", "Lara", true, ""));
        LogConfig.getInstance().novoRegistro(new LogRegister("Inclusão", "Fábio", "Lara", false, "Falha X"));
        LogConfig.getInstance().novoRegistro(new LogRegister("Inclusão", "Fábio", "Lara", true, ""));
        
        LogConfig.getInstance().setLogFormat("JSON");
        LogConfig.getInstance().novoRegistro(new LogRegister("Compartilhamento", "Fábio", "Lara", true, ""));
    }
}
