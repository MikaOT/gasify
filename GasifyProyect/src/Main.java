import main.utils.FetchGasPrices;
import main.utils.HttpRequest;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        FetchGasPrices prices = new FetchGasPrices();

        System.out.println(prices.fetchAPI());

    }
}
