import main.utils.HttpRequest;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        HttpRequest httpRequest = new HttpRequest();

        httpRequest.fetchGasPrices("https://www.epdata.es/comparacion-precio-gas-espana-2020-2021/480448b3-23d2-4f5a-bb92-e969270156eb");

    }
}
