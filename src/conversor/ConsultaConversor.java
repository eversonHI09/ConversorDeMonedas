package conversor;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversor {

    public Intercambio buscarMoneda(String base, String objetivo, int conversion) {
        // Construye la URL de la API con los parámetros necesarios.
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/4b3c39f0128bbae6c6066129/pair/" + base + "/" + objetivo + "/" + conversion);
        // Crea un cliente HTTP.
        HttpClient client = HttpClient.newHttpClient();
        // Construye una solicitud HTTP GET.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            // Envía la solicitud y obtiene la respuesta.
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            // Convierte la respuesta JSON a un objeto Intercambio.
            return new Gson().fromJson(response.body(), Intercambio.class);
        } catch (IOException | InterruptedException e) {
            // Lanza una RuntimeException en caso de error.
            throw new RuntimeException(e);
        }
    }
}






