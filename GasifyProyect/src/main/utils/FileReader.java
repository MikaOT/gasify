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
        filesData.add(0,"GasifyProyect/src/main/data/txt/Customers.txt");
        filesData.add(1,"GasifyProyect/src/main/data/txt/DataClientesFacturacion.txt");
        filesData.add(2,"GasifyProyect/src/main/data/txt/gasMaters.txt");
        filesData.add(3,"GasifyProyect/src/main/data/txt/Plcs.txt");
        filesData.add(4,"GasifyProyect/src/main/data/txt/dataSims.txt");
        filesData.add(5,"GasifyProyect/src/main/data/txt/workers.txt");

        BD = new ArrayList<>();

    }


    //Este metodo nos permite con el parametro cargar la ruta de los archivos
    public ArrayList<String> fileReading(String path){


            File file = new File(path);
            ArrayList<String> data = new ArrayList<String>();
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
           /* for (String datos : data) {

                //dataBBDD.add(data.toString());
                System.out.println(datos);

            }*/

            return data;
    }

    @Override
    public String toString() {
        return "FileReader{" +
                "BD=" + BD +
                '}';
    }

    public ArrayList<String> getBD(){

        return BD;
        }


}



