package main.core;

import main.utils.ParseData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Billing {

    private int idReport;
    private String idCustomer;
    private String idGasMeter;
    private String idPlc;
    private String idDataSim;
    private String firstDate;
    private String secondDate;
    private int firstValue;
    private int secondValue;
    private ParseData data;
    public Billing(){ //Constructor

        ParseData data = new ParseData();

    }

    public int getIdReport() {
        return idReport;
    }

    public void setIdReport(int idReport) {
        this.idReport = idReport;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdGasMeter() {
        return idGasMeter;
    }

    public void setIdGasMeter(String idGasMeter) {
        this.idGasMeter = idGasMeter;
    }

    public String getIdPlc() {
        return idPlc;
    }

    public void setIdPlc(String idPlc) {
        this.idPlc = idPlc;
    }

    public String getIdDataSim() {
        return idDataSim;
    }

    public void setIdDataSim(String idDataSim) {
        this.idDataSim = idDataSim;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public String getSecondDate() {
        return secondDate;
    }

    public void setSecondDate(String secondDate) {
        this.secondDate = secondDate;
    }

    public int getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(int firstValue) {
        this.firstValue = firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(int secondValue) {
        this.secondValue = secondValue;
    }





}
