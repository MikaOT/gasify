package main.core;

public class Plc {

    private String idPlc;
    private String modelPlc;

    public Plc(String idPlc, String modelPlc) {
        this.idPlc = idPlc;
        this.modelPlc = modelPlc;
    }

    public Plc() {

    }

    public String getIdPlc() {
        return idPlc;
    }

    public void setIdPlc(String idPlc) {
        this.idPlc = idPlc;
    }

    public String getModelPlc() {
        return modelPlc;
    }

    public void setModelPlc(String modelPlc) {
        this.modelPlc = modelPlc;
    }


    public String toStringPlc() {
        return "Plc{" +
                "idPlc='" + idPlc + '\'' +
                ", modelPlc='" + modelPlc + '\'' +
                '}';
    }
}
