package main.core;

public class GasMater {

    private String idGasMater;
    private String nameModel;
    private int readInstallationDay;
    private int currentReading;

    public GasMater(String idGasMater, String nameModel, int readInstallationDay, int currentReading) {
        this.idGasMater = idGasMater;
        this.nameModel = nameModel;
        this.readInstallationDay = readInstallationDay;
        this.currentReading = currentReading;
    }

    public GasMater() {

    }

    public String getIdGasMater() {
        return idGasMater;
    }

    public void setIdGasMater(String idGasMater) {
        this.idGasMater = idGasMater;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public int getReadInstallationDay() {
        return readInstallationDay;
    }

    public void setReadInstallationDay(int readInstallationDay) {
        this.readInstallationDay = readInstallationDay;
    }

    public int getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(int currentReading) {
        this.currentReading = currentReading;
    }


    public String toStringGasMater() {
        return "GasMater{" +
                "idGasMater='" + idGasMater + '\'' +
                ", nameModel='" + nameModel + '\'' +
                ", readInstallationDay=" + readInstallationDay +
                ", currentReading=" + currentReading +
                '}';
    }
}
