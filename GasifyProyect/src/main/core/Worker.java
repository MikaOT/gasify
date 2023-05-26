package main.core;

public class Worker {


    private String idEmployee;
    private String name;
    private String nameCompany;
    private String area;


    public Worker(String idEmployee, String name, String nameCompany, String area) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.nameCompany = nameCompany;
        this.area = area;
    }

    public Worker() {
    }

    @Override
    public String toString() {
        return "Worker{" +
                "idEmployee='" + idEmployee + '\'' +
                ", name='" + name + '\'' +
                ", nameCompany='" + nameCompany + '\'' +
                ", area='" + area + '\'' +
                '}';
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
