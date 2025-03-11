package com.log.adaptado;

import com.log.model.LogRegister;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
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
        String FILE_PATH = ("log/" + log.getNome() + "_RegistroLog.csv");

        // Garantindo que o diretório de log existe
        File logDirectory = new File("log");
        if (!logDirectory.exists()) {
            logDirectory.mkdirs(); // Cria o diretório se não existir
        }

        // Define a mensagem caso a operação tenha sucesso
        if (log.isSucesso()) {
            logMessage = String.format( "\n\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"",
                    log.getMensagem(), log.getOperacao(), log.getNome(), data, hora, log.getUsuario());

        }
        // Define a mensagem caso a operação falhe
        else {
            logMessage = String.format("\n\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"",
                    log.getMensagem(), log.getOperacao(), log.getNome(), data, hora, log.getUsuario());
        }


        // Escrevendo a mensagem no arquivo de log com codificação UTF-8 para exibir acentuação
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(FILE_PATH, true), StandardCharsets.UTF_8))) {

            // Se o arquivo for novo, escreve o cabeçalho do mesmo
            File logFile = new File(FILE_PATH);
            if (!logFile.exists() || logFile.length() == 0) {
                writer.write("\"Mensagem\",\"Operação\",\"Nome\",\"Data\",\"Hora\",\"Usuário\""); // Cabeçalho
            }
            writer.write(logMessage); // Adicionando mensagem de log

        } catch (IOException e) {
            // Tratamento de exceção
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
            e.printStackTrace(); // Imprime o rastreamento da pilha
        }
    }
}
