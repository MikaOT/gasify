package main.utils;

import com.google.gson.Gson;
import main.core.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ParseData {

    // @@ https://stackoverflow.com/questions/35034367/convert-json-array-to-java-class-object-list
    public List<Billing> billingData() throws IOException { //Si queremos los clientes necesitamos llamar a ese metodo

        JSONReader file = new JSONReader();
        String data = file.readAsString("./src/main/data/txt/CustomerBilling.json");

        Gson gson = new Gson();

        List<Billing> billingToDate;
        billingToDate = Arrays.asList(gson.fromJson(data, Billing[].class));
        return billingToDate;


    }
    public List<Customer> customerData() throws IOException { //Si queremos los clientes necesitamos llamar a ese metodo

        JSONReader file = new JSONReader();
        String data = file.readAsString("./src/main/data/txt/customers.json");

        Gson gson = new Gson();
        List<Customer> allCustomers;
        allCustomers = Arrays.asList(gson.fromJson(data, Customer[].class));
        return allCustomers;

    }

    public List<DataSim> simData() throws IOException { // To do Exception

        JSONReader file = new JSONReader();
        String data = file.readAsString("./src/main/data/txt/dataSims.json");

        Gson gson = new Gson();
        List<DataSim> allDataSims;
        allDataSims = Arrays.asList(gson.fromJson(data, DataSim[].class));
        return allDataSims;

    }

    public List<GasMater> gasMaterData() throws IOException { // To do Exception

        JSONReader file = new JSONReader();
        String data = file.readAsString("./src/main/data/txt/gasMaters.json");

        Gson gson = new Gson();
        List<GasMater> allGasMater;
        allGasMater = Arrays.asList(gson.fromJson(data, GasMater[].class));
        return allGasMater;

    }

    public List<Plc> plcData() throws IOException { // To do Exception

        JSONReader file = new JSONReader();
        String data = file.readAsString("./src/main/data/txt/Plcs.json");

        Gson gson = new Gson();
        List<Plc> allPlc;
        allPlc = Arrays.asList(gson.fromJson(data, Plc[].class));
        return allPlc;

    }

    public List<Worker> workerData() throws IOException { // To do Exception

        JSONReader file = new JSONReader();
        String data = file.readAsString("./src/main/data/txt/workers.json");

        Gson gson = new Gson();
        List<Worker> allWorkers;
        allWorkers = Arrays.asList(gson.fromJson(data, Worker[].class));
        return allWorkers;

    }
}
