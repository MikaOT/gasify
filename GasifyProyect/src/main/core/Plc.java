package main.core;

public class Plc {

    private String idPlc;
    private String maker;
    private String model;

    public Plc(String idPlc, String maker,String model) {
        this.idPlc = idPlc;
        this.maker = maker;
        this.model=model;

    }

    public Plc() {

    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getIdPlc() {
        return idPlc;
    }

    public void setIdPlc(String idPlc) {
        this.idPlc = idPlc;
    }



    public String toStringPlc() {
        return "Plc{" +
                "idPlc='" + idPlc + '\'' +
                ", maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
