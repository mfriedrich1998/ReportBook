package backend.CSVConfig;

import backend.saveinstance.SaveInstance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSV {
    private static FileReader fileReader = null;
    private static FileWriter fileWriter = null;
    private static BufferedReader bufferedReader = null;


    public void open(String fileName, char mode) {
        try {
            if (mode == 's') {
                fileWriter = new FileWriter(fileName + ".csv");
            } else if (mode == 'l') {
                fileReader = new FileReader(fileName + ".csv");
            }
        } catch (IOException e) {
            //nothing to show. Then config does not exist
        }
    }


    public void save(String string) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(",");
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void load(String fileName) {
        String loadedString = "";

        try {
            fileReader = new FileReader(fileName + ".csv");
            bufferedReader = new BufferedReader(fileReader);
            String name = null;
            String department = null;
            while ((loadedString = bufferedReader.readLine()) != null) {
                String[] personsAttribute = loadedString.split(",");
                name = personsAttribute[0];
                department = personsAttribute[1];
                break;
            }
            SaveInstance sv = SaveInstance.getInstance();
            sv.setName(name);
            sv.setDepartment(department);
        } catch (Exception e) {
            SaveInstance sv = SaveInstance.getInstance();
            sv.setName(null);
            sv.setDepartment(null);
        }
    }


    public void close() {
        if (fileReader != null) {
            try {
                fileReader.close();
            } catch (IOException e) {

            }
        }
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {

            }
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {

            }
        }
    }
}
