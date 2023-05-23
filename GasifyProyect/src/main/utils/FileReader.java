package main.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private List<String> lines;

    public FileReader(){
        this.lines = new ArrayList<>();
    }

    private List<String> readFileContent(String path)  {
        BufferedReader input = null;

        try {
            input = new BufferedReader(new java.io.FileReader(path));
            String line;
            while ((line = input.readLine()) != null) {
                this.lines.add(line);
            }
        } catch (FileNotFoundException e) {
            //TO-DO EXCEPTIONS
        } catch (IOException e) {
            //TO-DO EXCEPTIONS
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    //TO-DO EXCEPTIONS
                }
            }
        }

        return this.lines;

    }

    public List<String> loadFileContent(String path) {
        File file = new File(path);
        return readFileContent(path);
    }

}
