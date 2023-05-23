import main.utils.FileReader;
import main.utils.ParserData;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FileReader br = new FileReader();

        //br.fileReading("GasifyProyect/src/main/data/txt/Customers.txt");

        ParserData p1 = new ParserData();

        /*p1.parserCustomer();
        p1.parserDataSim();
        p1.parserGasMater();
        p1.parserPlc(); */

        p1.parserWorkers();




    }
}
