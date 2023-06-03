package main.utils;

import com.google.gson.Gson;
import main.core.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ParseData {

    private FileReader file;
    private Gson gson;
    private String data;
    public ParseData(){
        file = new FileReader();
        gson = new Gson();
    }

    /*
    #########################################################
    Class to collect JSON files and parse them into an array,
    the information is parameterized based on the classes in the Core folder.
    @@ URL: https://stackoverflow.com/questions/35034367/convert-json-array-to-java-class-object-list
    #################################################################################################
    */
    public List<Billing> billingData() {

        data = null;
        List<Billing> billingToDate;

        try {
            data = file.readAsString("./src/main/data/txt/CustomerBilling.json");
            billingToDate = Arrays.asList(gson.fromJson(data, Billing[].class));
            return billingToDate;

        } catch (IOException e) {
            System.err.println("CustomerBilling.json not found!");
        }
        return null;
    }

    public List<Customer> customerData() {

        data = null;
        List<Customer> allCustomers;

        try {
            data = file.readAsString("./src/main/data/txt/customers.json");
            allCustomers = Arrays.asList(gson.fromJson(data, Customer[].class));
            return allCustomers;

        } catch (IOException e){
            System.err.println("Customer.json not found!");
        }
        return null;
    }

    public List<DataSim> simData() {

        data = null;
        List<DataSim> allDataSims;

        try {
            data = file.readAsString("./src/main/data/txt/dataSims.json");
            allDataSims = Arrays.asList(gson.fromJson(data, DataSim[].class));
            return allDataSims;
        }catch(IOException e){
            System.err.println("dataSims.json not found!");
        }
        return null;
    }

    public List<GasMater> gasMaterData() {

        data = null;
        List<GasMater> allGasMater;

        try {
            data = file.readAsString("./src/main/data/txt/gasMaters.json");
            allGasMater = Arrays.asList(gson.fromJson(data, GasMater[].class));
            return allGasMater;
        }catch(IOException e){
            System.err.println("gasMaters.json not found!");
        }
        return null;
    }

    public List<Plc> plcData() throws IOException { // To do Exception

        JSONReader file = new JSONReader();
        String data = file.readAsString("./src/main/data/txt/Plcs.json");

        Gson gson = new Gson();
        List<Plc> allPlc;
        allPlc = Arrays.asList(gson.fromJson(data, Plc[].class));
        return allPlc;

    }

    public List<Worker> workerData() {

        data = null;
        List<Worker> allWorkers;

        try {
            data = file.readAsString("./src/main/data/txt/workers.json");
            allWorkers = Arrays.asList(gson.fromJson(data, Worker[].class));
            return allWorkers;
        } catch(IOException e) {
            System.err.println("workers.json not found!");
        }
        return null;
    }

    public List<Prices> pricesData() {

        data = null;
        List<Prices> allPrices;

        try {
            data = file.readAsString("./src/main/data/txt/Prices.json");
            allPrices = Arrays.asList(gson.fromJson(data, Prices[].class));
            return allPrices;
        }catch(IOException e){
            System.err.println("Prices.json not found!");
        }
        return null;

    }
}
