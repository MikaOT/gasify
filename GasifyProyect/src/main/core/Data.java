package main.core;

import main.utils.DateValidator;
import main.utils.ParseData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data extends ParseData {

    DateValidator fullDate;
    DateValidator monthYear;
    DateValidator format;

    public Data() {
        fullDate = new DateValidator("dd/MM/yyyy");
        monthYear = new DateValidator("MM/yyyy");
    }

    public List<DataSim> findSimDataByID(String customerId) {

        List <Customer> customer = findCustomerByID(customerId);
        List <DataSim> filter = new ArrayList<>();

        if (customer.size() > 0) {
            for (Customer user : customer) {
                List<GasMater> gasData = findGasMeter(user.getGasMaterID());
                if (gasData.size() > 0) {
                    for (GasMater gas : gasData) {
                        String plcID = gas.getPlcId();
                        List<Plc> plcData = findPlc(plcID);
                        if (plcData.size() > 0) {
                            for (Plc plc : plcData) {
                                String simId = plc.getSimDataId();
                                List<DataSim> simData = findSim(simId);
                                filter.addAll(simData);
                            }
                        }
                    }
                }
            }
        }
        return filter;
    }

    // #################################### General Data search methods ########################################

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



    // #################################### Customer Data search methods ########################################

    // @@ https://stackoverflow.com/questions/18410035/ways-to-iterate-over-a-list-in-java

    public List<Billing> findBillingByUser (String customerID) {

        ArrayList<Billing> filter = new ArrayList<>();

        if (billingData() != null) {
            for (Billing billding : billingData()) {
                if (billding.getIdCustomer().equalsIgnoreCase(customerID)) {
                    filter.add(billding);
                }
            }
            if (filter.size() == 0) System.err.println("User without associated billing!");
        }

        return filter;
    }

    public List<GasMater> findGasMeter(String gasMeterId) {

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

        if (simData() != null) {
            for (DataSim sim : simData()) {
                if (sim.getIdDataSim().equalsIgnoreCase(simId)) {
                    filter.add(sim);
                }
            }
            if (filter.size() == 0) System.err.println("SIM ID not found!");
        }
        return filter;

    }

    public List<Plc> findPlc(String plcId) {

        ArrayList<Plc> filter = new ArrayList<>();

        if (plcData() != null) {
            for (Plc plc : plcData()) {
                if (plc.getIdPlc().equalsIgnoreCase(plcId)) {
                    filter.add(plc);
                }
            }
            if (filter.size() == 0) System.err.println("PLC ID not found!");
        }

        return filter;
    }

    // ####################################### Customer search methods ###########################################

    /*         #### Find a customer by the name ####
    * @param name - Name of the client set in the client JSON list.
    * @return A list of users matching the entered name.
    */

    public List<Customer> findCustomerByName(String name) {

        ArrayList<Customer> filter = new ArrayList<>();

        if (customerData() != null) {
            for (Customer customer : customerData()) {
                if (customer.getNameCustomer().toLowerCase().contains(name.toLowerCase())) {
                    filter.add(customer);
                }
            }
            if (filter.size() == 0) System.err.println("User(s) not found!");
        }

        return filter;
    }

    /*         #### Find a customer by the ID (DNI) ####
     * @param ID - ID of the client set in the client JSON list.
     * @return A list of users matching the entered ID.
     */

    public List<Customer> findCustomerByID(String ID) {

        ArrayList<Customer> filter = new ArrayList<>();

        if (customerData() != null) {
            for (Customer customer : customerData()) {
                if (customer.getIdCustomer().equalsIgnoreCase(ID)) {
                    filter.add(customer);
                }
            }
            if (filter.size() == 0) System.err.println("ID not found!");
            if (filter.size() > 1) System.err.println("More than one client associated with the same ID has been found!");
        }



        return filter;
    }

    /*         #### Find a customer by the Number Phone ####
     * @param numberPhone - Number Phone of the client set in the client JSON list.
     * @return A list of users matching the entered Number Phone.
     */

    public List<Customer> findCustomerByNumber(String numberPhone) {

        ArrayList<Customer> filter = new ArrayList<>();

        if (customerData() != null) {
            for (Customer customer : customerData()) {
                if (customer.getNumberPhone().equalsIgnoreCase(numberPhone)) {
                    filter.add(customer);
                }
            }
            if (filter.size() == 0) System.err.println("Customer associated to the entered number not found!");
        }
        return filter;
    }
}