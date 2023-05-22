package main.utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


    /*
    ###########################################################################
    It connects to a self-hosted API to simulate the data collection through it,
    to keep the vanilla essence of JAVA it collects the data as a String and
    iterates it based on the unique symbols of a JSON. This data is inserted
    into an array and treated as objects for later use.
    ###########################################################################
    */

public class FetchGasPrices {

public List<Map<String, String>> fetchAPI() throws IOException, InterruptedException {

    try {

        // STARTS CONNECTION

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://gas.carloscasado.es/data")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String JSONArray = response.body();

        // ENDS CONNECTION AND GIVES A JSON STRING

        // REMOVE THE SQUARE BRACKETS
        JSONArray = JSONArray.substring(1, JSONArray.length() - 1);

        // SEPARATE ELEMENTS IN THE JSON ARRAY
        String[] objects = JSONArray.split("\\},\\s?\\{");

        List<Map<String, String>> allData = new ArrayList<>();

        for (String element : objects) {

            // Add the missing brackets
            if (!element.startsWith("{")) {
                element = "{" + element;
            }
            if (!element.endsWith("}")) {
                element = element + "}";
            }

            // Object without the brackets
            element = element.substring(1, element.length() - 1);

            // Value separator (commas) per object
            String[] data = element.split(",");

            Map<String, String> dataClean = new HashMap<>();

            // for loop to separate the title and the value and clean the quotation marks
            for (String pair : data) {

                String[] res = pair.split(":");
                String title = res[0].trim().replace("\"", "");
                String value = res[1].trim().replace("\"", "");
                dataClean.put(title, value);

            }

            allData.add(dataClean);
        }

        return allData;

    } catch (Exception e) {
        //TO-DO Exceptions
    }
    return null;
}

}
