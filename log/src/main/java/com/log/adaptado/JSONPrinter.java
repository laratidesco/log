package com.log.adaptado;

import com.log.model.LogRegister;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author lara_
 */
public class JSONPrinter {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("hh:mm:ss");

    public void escreveLog(LogRegister log) {
        String data = LocalDateTime.now().format(DATE_FORMAT);
        String hora = LocalDateTime.now().format(TIME_FORMAT);

        String FILE_PATH = "log/" + log.getNome() + "_RegistroLog.json";

        // Criar diretório caso não exista
        File logDirectory = new File("log");
        if (!logDirectory.exists()) {
            logDirectory.mkdirs();
        }

        try {
            JSONArray logsArray;

            // Verifica se o arquivo existe e está vazio
            if (Files.exists(Paths.get(FILE_PATH)) && Files.size(Paths.get(FILE_PATH)) > 0) {
                String content = new String(Files.readAllBytes(Paths.get(FILE_PATH))).trim();

                // Verifica se é um array válido
                if (content.startsWith("[")) {
                    logsArray = new JSONArray(content);
                } else {
                    // Caso seja um objeto JSON único, converte para um array
                    JSONObject singleLog = new JSONObject(content);
                    logsArray = new JSONArray();
                    logsArray.put(singleLog);
                }
            } else {
                // Arquivo vazio ou inexistente, cria um novo array JSON
                logsArray = new JSONArray();
            }

            // Cria o novo log como um JSONObject
            JSONObject logObject = new JSONObject();
            if (log.isSucesso()) {
                logObject.put("Operacao", log.getOperacao());
                logObject.put("Nome", log.getNome());
                logObject.put("Data", data);
                logObject.put("Hora", hora);
                logObject.put("Usuario", log.getUsuario());
            } else {
                logObject.put("Falha", log.getMensagem());
                logObject.put("Operacao", log.getOperacao());
                logObject.put("Nome", log.getNome());
                logObject.put("Data", data);
                logObject.put("Hora", hora);
                logObject.put("Usuario", log.getUsuario());
            }

            // Adiciona o novo log ao array
            logsArray.put(logObject);

            // Escreve o array JSON formatado de volta no arquivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
                writer.write(logsArray.toString(4)); // Formata com 4 espaços de indentação
            }

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
            e.printStackTrace();
        }

    }
}

