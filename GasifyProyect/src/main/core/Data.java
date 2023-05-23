package main.core;

import java.util.ArrayList;

public class Data {


     ArrayList<Customer> allCustomers;
     ArrayList<DataSim> allDataSims;
    ArrayList<GasMater> allGasMater;
    ArrayList<Plc> allPlcs;

    public Data() {

        allCustomers = new ArrayList<>();
        allDataSims = new ArrayList<>();
        allGasMater = new ArrayList<>();
        allPlcs = new ArrayList<>();

    }
}
