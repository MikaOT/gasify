package main.utils;

import main.core.*;

import java.util.ArrayList;

public class ParserData implements Parser {


    ArrayList<Customer> customers;
    ArrayList<GasMater> gasMaters;
    ArrayList<DataSim> dataSims;
    ArrayList<Plc> plcs;

    public ParserData() {

        customers = new ArrayList<>();
        gasMaters = new ArrayList<>();
        dataSims = new ArrayList<>();
        plcs = new ArrayList<>();
    }

    @Override
    public void ordenar() {

        FileReader f = new FileReader();

        //f.fileRead("GasifyProyect/src/main/data/img/DataClientesFacturacion.txt");

        //for (String datos: f.fileRead("main/data/txt/DataClientesFacturacion.txt")) {






    }
}
