package connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Moneda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class conexion {
    public Moneda convertir(String monedaBase, String monedaAConvertir, double cantidad) throws IOException, InterruptedException {
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/25e846b87b24181b4424b5dc/pair/"+monedaBase+"/"+monedaAConvertir+"/"+cantidad);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        String json=response.body();
        return gson.fromJson(json, Moneda.class);
    }
}
