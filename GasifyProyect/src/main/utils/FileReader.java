package main.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader { // Clase para leer

        ArrayList<String> filesData;
        ArrayList<String> BD;
    public FileReader() {

        filesData=new ArrayList<>();
        filesData.add(0,"main/data/txt/Customers.txt");
        filesData.add(1,"main/data/txt/dataSims.txt");
        filesData.add(2,"main/data/txt/gasMaters.txt");
        filesData.add(3,"main/data/txt/Plcs.txt");
        filesData.add(4,"main/data/txt/DataClientesFacturacion.txt");

        BD = new ArrayList<>();

    }


    //Este metodo nos permite con el parametro cargar la ruta de los archivos
    public ArrayList<String> fileReading(){

        for (int i =0; i<filesData.size();i++) {

            String path = filesData.get(i);
            File file = new File(path);
            List<String> data = new ArrayList<String>();
            BufferedReader in = null;
            try {
                in = new BufferedReader(new java.io.FileReader(file));
                while (in.ready()) {
                    String line = in.readLine();
                    if (line.length() > 0) {
                        data.add(line);


                    }
                }
                data.remove(0); //Me elimina los encabezados de las columnas

            } catch (IOException e) {
                System.err.println(e.getMessage());
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
            System.out.println(data.size() + " elements loaded.");
            for (String datos : data) {

                //dataBBDD.add(data.toString());
                System.out.println(datos);
                BD.add(data.toString());
            }
            return (ArrayList<String>) data;
        }

            return BD;
    }



}



