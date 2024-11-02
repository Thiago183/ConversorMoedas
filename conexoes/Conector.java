package com.conversor.conexoes;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conector {

    String apiKey = "";
    private Gson gson = new Gson();

    public Double pegarValorJson(String moeda,String moedaConversao) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/"+apiKey +"/pair/"+moeda+"/"+moedaConversao))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        JsonObject object = gson.fromJson(response.body(), JsonObject.class);
        JsonElement converterDouble = object.get("conversion_rate");


        return converterDouble.getAsDouble();



    }
}
