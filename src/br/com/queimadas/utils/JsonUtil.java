package br.com.queimadas.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;


public class JsonUtil {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> void salvarParaArquivo(String caminho, T dados) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(dados, writer);
            System.out.println("Dados salvos em " + caminho);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T lerDeArquivo(String caminho, Type tipo) {
        try (FileReader reader = new FileReader(caminho)) {
            return gson.fromJson(reader, tipo);
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado ou erro de leitura: " + caminho);
            return null;
        }
    }
}
