package main.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpRequest {

    private ArrayList<String> pricesMAter;

    public HttpRequest() {

        this.pricesMAter = new ArrayList<>();
    }

    public void setPricesMAter(ArrayList<String> pricesMAter) {
        this.pricesMAter = pricesMAter;
    }

    String gasPriceUrl = "https://www.epdata.es/comparacion-precio-gas-espana-2020-2021/480448b3-23d2-4f5a-bb92-e969270156eb";

       /*try {
        List<String> pricesMater = null;
        try {
            pricesMater = fetchGasPrices(gasPriceUrl);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("Precios del gas por mes: " + pricesMater);
    } catch (IOException e) {
        e.printStackTrace();
    }*/




    public  List<String> fetchGasPrices(String gasPriceUrl) throws IOException {
        List<String> pricesMater = new ArrayList<>();

        // Realizar la solicitud HTTP y obtener el contenido HTML de la página
        Document document = Jsoup.connect(gasPriceUrl).get();

        // Buscar el elemento HTML que contiene los precios del gas
        Element pricesContainer = document.selectFirst(".ep-infographic");

        // Obtener los elementos de precio dentro del contenedor
        Elements priceElements = pricesContainer.select(".ep-infographic-text");

        // Extraer los precios del gas por mes
        for (Element priceElement : priceElements) {
            String price = priceElement.text();
            pricesMater.add(price);
        }

        return pricesMater;
    }

    public String toStringHttpRequest() {
        return "HttpRequest{" +
                "pricesMAter=" + pricesMAter +
                '}';
    }
}
