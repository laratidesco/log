package com.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author lara_
 */
public class CSVPrinter {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");

            
    public void escreveLog(LogRegister log) {
        // Obtendo a data e hora formatada
        String data = LocalDateTime.now().format(DATE_FORMAT);
        String hora = LocalDateTime.now().format(TIME_FORMAT);
        // Definindo a mensagem de log
        String logMessage;
        // Definindo o nome do arquivo de acordo com o nome do cliente
        var FILE_PATH = ("log/" + log.getNome() + "_RegistroLog.csv"); 
        // Garantindo que o diretório de log existe
        File logDirectory = new File("log");
        if (!logDirectory.exists()) {
            logDirectory.mkdirs(); // Cria o diretório se não existir
        }
        
        // Caso a operação tenha sucesso
        if (log.isSucesso()) {
            logMessage = String.format("%s; %s; %s; %s; %s\n", log.getOperacao(), log.getNome(),
                    data, hora, log.getUsuario());
        } 
        // Caso a operação falhe
        else {
            logMessage = String.format("Ocorreu a falha %s ao realizar a \"%s\" do contato %s; %s; %s; %s\n",
                    log.getMensagem(), log.getOperacao(), log.getNome(), data, hora, log.getUsuario());
        }
        

        // Escrevendo a mensagem no arquivo de log com codificação UTF-8 para exibir acentuação
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(FILE_PATH, true), StandardCharsets.UTF_8))) {
            writer.write(logMessage); // Adicionando parágrafo
        } catch (IOException e) {
        }
    }
}
