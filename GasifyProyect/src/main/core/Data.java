package main.core;

import main.utils.ParseData;

import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {


    public Data() {
        this.data = new ParseData();
    }

    // 01/01/2022 hasta 01/12/2030
    public long diffDate (String date1, String date2) {
        LocalDate d1 = LocalDate.parse(date1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate d2 = LocalDate.parse(date2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
        return diff.toDays();

        // año 365 dias
        // Enero 1<Enero<31
        // Febrero 32<Febrero<60

    }
    public String verMes(String fecha){

        return dateFormat(fecha)[1];


    }
    public String[] dateFormat(String date) {

        return date.split("/");
    }

    // @@ https://stackoverflow.com/questions/26075490/filter-an-arraylist-with-dates-by-start-and-end-time
    // @@ https://stackoverflow.com/questions/13037654/subtract-two-dates-in-java
    
    //Filtro le pasas un CustomerId y un intervalo de fechas y te devuelve toda la info respecto al usuario
    public List<Billing> monthlyBill (String customerId, String firstDate, String secondDate) throws IOException {

        List<Billing> filtro = new ArrayList<>();

        List<Billing> getUser = findBillingByUser(customerId);

        for (Billing user : getUser) {

            LocalDate enteredFirstDate = LocalDate.parse(firstDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate userFirstDate = LocalDate.parse(user.getFirstDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate enteredSecondDate = LocalDate.parse(secondDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate userSecondDate = LocalDate.parse(user.getSecondDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            if ((userFirstDate.isEqual(enteredFirstDate) || userFirstDate.isAfter(enteredFirstDate)) && (userSecondDate.isEqual(enteredSecondDate) || userSecondDate.isBefore(enteredSecondDate))) {
                filtro.add(user);
            }
        }

        return filtro;

    }

    // @@ https://stackoverflow.com/questions/18410035/ways-to-iterate-over-a-list-in-java

    public List<Billing> findBillingByUser (String customerID) throws IOException {

        ArrayList<Billing> filter = new ArrayList<>();

        for (Billing billding : data.billingData()) {
            if (billding.getIdCustomer().equalsIgnoreCase(customerID)) {
                filter.add(billding);
            }
        }

        return filter;

    }

    public int difValues (String customerID, String mes) throws IOException {


        List<Billing> filter = findBillingByUser(customerID);


        // Si no encuentra customer con un billing disponible

        int value1 = filter.get(0).getFirstValue();
        int value2 = filter.get(0).getSecondValue();


        int result = value2 - value1;
        return result;

    }



    public List<Customer> findCustomerByNumber (String numberPhone) throws IOException {

        ArrayList<Customer> filter = new ArrayList<>();

        for (Customer customer : data.customerData()) {
            if (customer.getNumberPhone().equalsIgnoreCase(numberPhone)) {
                filter.add(customer);
            }
        }

        return filter;

    }
    public List<GasMater> findGasMeter(String gasMeterId) throws IOException {

        ArrayList<GasMater> filter = new ArrayList<>();

        for (GasMater gas : data.gasMaterData()) {
            if (gas.getIdGasMater().equalsIgnoreCase(gasMeterId)) {
                filter.add(gas);
            }
        }

        return filter;

    }

    public List<DataSim> findSim(String simId) throws IOException {

        ArrayList<DataSim> filter = new ArrayList<>();

        for (DataSim sim : data.simData()) {
            if (sim.getIdDataSim().equalsIgnoreCase(simId)) {
                filter.add(sim);
            }
        }

        return filter;

    }

    public List<Plc> findPlc(String plcId) throws IOException {

        ArrayList<Plc> filter = new ArrayList<>();

        for (Plc plc : data.plcData()) {
            if (plc.getIdPlc().equalsIgnoreCase(plcId)) {
                filter.add(plc);
            }
        }

        return filter;

    }

    public String findSimNumber(String customerId) throws IOException { // to do Exception


        List <Customer> cus = findCustomerByID(customerId);

        String customerGasId = (cus.size() > 0)
                ? cus.get(0).getGasMaterID()
                : null;

        if (customerGasId != null) {

            List<GasMater> gas = findGasMeter(customerGasId);

            // excepción si no encuentra un usuario asociado con un GasMeter

            String plcID = gas.get(0).getPlcId();

            List<Plc> plc = findPlc(plcID);

            String plcGetSim = plc.get(0).getSimDataId();

            List<DataSim> sim = findSim(plcGetSim);

            return sim.get(0).getNumberDataSim();
        }

        return null;

    }

    public List<Customer> findCustomerByName(String name) throws IOException {

        ArrayList<Customer> filter = new ArrayList<>();

        for (Customer customer : data.customerData()) {
            if (customer.getNameCustomer().toLowerCase().contains(name.toLowerCase())) {
                filter.add(customer);
            }
        }

        return filter;

    }

    public List<Customer> findCustomerByID(String ID) throws IOException {

        ArrayList<Customer> filter = new ArrayList<>();

        for (Customer customer : data.customerData()) {
            if (customer.getIdCustomer().equalsIgnoreCase(ID)) {
                filter.add(customer);
            }
        }

        return filter;

    }



}