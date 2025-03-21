
package com.log.model;


import com.log.adaptador.LogConfig;

/**
 *
 * @author lara_
 */
public class Principal {

    public static void main(String[] args) {
        LogConfig.getInstance().setLogFormat("CSV");
        LogConfig.getInstance().novoRegistro(new LogRegister("Exclusão", "Fábio", "Lara", true, "Sucesso"));
        LogConfig.getInstance().novoRegistro(new LogRegister("Inclusão", "Fábio", "Lara", false, "Falha X"));
        LogConfig.getInstance().novoRegistro(new LogRegister("Inclusão", "Fábio", "Lara", true, "Sucesso"));
        
        LogConfig.getInstance().setLogFormat("JSON");
        LogConfig.getInstance().novoRegistro(new LogRegister("Exclusão", "Fábio", "Lara", true, "Sucesso"));
        LogConfig.getInstance().novoRegistro(new LogRegister("Inclusão", "Fábio", "Lara", false, "Falha X"));
        LogConfig.getInstance().novoRegistro(new LogRegister("Inclusão", "Fábio", "Lara", true, "Sucesso"));
        LogConfig.getInstance().novoRegistro(new LogRegister("Compartilhamento", "Cláudio", "Lara", true, "Sucesso"));
        LogConfig.getInstance().novoRegistro(new LogRegister("Exlusão", "Cláudio", "Lara", true, "Sucesso"));
        LogConfig.getInstance().novoRegistro(new LogRegister("Compartilhamento", "Fábio", "Lara", false, "Falha X"));

    }
}
