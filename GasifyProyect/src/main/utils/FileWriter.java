package main.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.core.Billing;
import main.core.Worker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWriter {
    private FileReader file;
    private Gson gson;
    private String data;
    private java.io.FileWriter writer;

    public FileWriter() {
        file = new FileReader();
        gson = new Gson();
    }

    public void writeBillingData() throws IOException {

        gson = new GsonBuilder().setPrettyPrinting().create();
        data = file.readAsString("./src/main/data/txt/CustomerBilling.json");
        List<Billing> bills =  new ArrayList<>(Arrays.asList(gson.fromJson(data, Billing[].class)));
        bills.add(new Billing());
        writer  = new java.io.FileWriter("./src/main/data/txt/CustomerBilling.json");
        gson.toJson(bills, writer);
        writer.close();
    }

    public void writeWorkersData(Worker employee) throws IOException {

        gson = new GsonBuilder().setPrettyPrinting().create();
        data = file.readAsString("./src/main/data/txt/workers.json");
        List<Worker> work = new ArrayList<>(Arrays.asList(gson.fromJson(data, Worker[].class)));
        work.add(employee);
        writer  = new java.io.FileWriter("./src/main/data/txt/workers.json");
        gson.toJson(work, writer);
        writer.close();
    }
}
