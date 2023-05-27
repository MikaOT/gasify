package main.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    ArrayList<String> filesData;
    ArrayList<String> BD;

    public FileReader() {

        filesData = new ArrayList<>();

        filesData.add(0,"./src/main/data/txt/Customers.txt");
        filesData.add(1,"./src/main/data/txt/CustomerBilling.json");
        filesData.add(2,"./src/main/data/txt/gasMaters.json");
        filesData.add(3,"./src/main/data/txt/Plcs.json");
        filesData.add(4,"./src/main/data/txt/dataSims.json");
        filesData.add(5,"./src/main/data/txt/workers.json");

        BD = new ArrayList<>();

    }

    //Este metodo nos permite con el parametro cargar la ruta de los archivos
    public ArrayList<String> fileReading(String path){

        File file = new File(path);
        ArrayList<String> data = new ArrayList<>();
        BufferedReader in = null;

        try {

            in = new BufferedReader(new java.io.FileReader(file));

            while (in.ready()) {
                String line = in.readLine();
                if (line.length() > 0) {
                    data.add(line);
                }
            }

            data.remove(0); //Deletes the header

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

        return data;
    }


}