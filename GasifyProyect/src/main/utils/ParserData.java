package main.utils;

import main.core.*;
import sun.plugin2.message.CustomSecurityManagerAckMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.FileHandler;

public class ParserData implements Parser {


    ArrayList<Customer> customers;
    ArrayList<GasMater> gasMaters;
    ArrayList<DataSim> dataSims;
    ArrayList<Plc> plcs;

    Customer customer;
    DataSim dataSim;
    Plc plc;
    Worker woker;

    public ParserData() {

        Customer customer = new Customer();
        DataSim dataSim = new DataSim();
        Worker woker = new Worker();
        customers = new ArrayList<>();
        gasMaters = new ArrayList<>();
        dataSims = new ArrayList<>();
        plcs = new ArrayList<>();
    }

    @Override
    public void parserCustomer() {

        FileReader readFile = new FileReader();
        List<String> customers;

        customers = readFile.fileReading("GasifyProyect/src/main/data/txt/Customers.txt");

        for (String line : customers) {


            String[] data = line.split(",");


            String idName;
            String nameCustomer;
            String numberPhone;
            String address;

            idName = data[0];
            nameCustomer = data[1];
            numberPhone = data[2];
            address = data[3];

            customer = new Customer(idName, nameCustomer, numberPhone, address);

            this.customers.add(customer);


        }
        //Esto por ahora para comprobar si están cargados
        for (Customer print : this.customers
        ) {
            System.out.println(print.toString());
        }


    }


    public void parserDataSim() {

        FileReader readFile = new FileReader();
        List<String> dataSim;

        dataSim = readFile.fileReading("GasifyProyect/src/main/data/txt/dataSims.txt");

        for (String line : dataSim) {


            String[] data = line.split(",");


            String idDataSim;
            String numberDataSim;
            String servicesCompany;

            idDataSim = data[0];
            numberDataSim = data[1];
            servicesCompany = data[2];


            DataSim dataSim1 = new DataSim(idDataSim, numberDataSim, servicesCompany);

            this.dataSims.add(dataSim1);

        }
        //Esto por ahora para comprobar si están cargados
        for (DataSim print : this.dataSims
        ) {
            System.out.println(print.toStringDataSim());
        }

    }
        public void parserGasMater() {

            FileReader read = new FileReader();
            List<String> gasmater;

            gasmater = read.fileReading("GasifyProyect/src/main/data/txt/gasMaters.txt");

            for (String line : gasmater) {


                String[] data = line.split(",");


                String idGasMeter;
                String brand;
                String ref;
                String ean13;
                String serie;
                int readIstallationDay;

                idGasMeter = data[0];
                brand = data[1];
                ref = data[2];
                ean13 = data[3];
                serie = data[4];
                readIstallationDay = Integer.parseInt(data[5]);


                GasMater gasMater = new GasMater(idGasMeter, brand, ref, ean13, serie, readIstallationDay);


                this.gasMaters.add(gasMater);

            }
            //Esto por ahora para comprobar si están cargados
            for (GasMater print : this.gasMaters
            ) {
                System.out.println(print.toStringGasMater());
            }


        }


    public void parserPlc() {

        FileReader read = new FileReader();
        List<String> plcs;

        plcs = read.fileReading("GasifyProyect/src/main/data/txt/Plcs.txt");

        for (String line : plcs) {


            String[] data = line.split(",");


            String idPlc;
            String maker;
            String model;


            idPlc = data[0];
            maker = data[1];
            model= data[2];



            Plc plc = new Plc(idPlc,maker,model);


            this.plcs.add(plc);

        }
        //Esto por ahora para comprobar si están cargados
        for (Plc print : this.plcs
        ) {
            System.out.println(print.toStringPlc());
        }


    }

    public void parserWorkers() { // Revisar Porque algo falla

        FileReader read = new FileReader();
        List<String> wo;

        wo= read.fileReading("GasifyProyect/src/main/data/txt/workers.txt");

        for (String line : wo) {


            String[] dato = line.split(",");


            String idEmployee;
            String name;
            String nameCompany;
            String area;


            idEmployee = dato[0];
            name = dato[1];
            nameCompany= dato[2];
            area = dato[3];


           Worker  tra = new Worker(idEmployee,name,nameCompany,area);

            wo.add(String.valueOf(tra));


        }
        //Esto por ahora para comprobar si están cargados
        for (String print : wo
        ) {
            System.out.println(print);
        }


    }






    }

