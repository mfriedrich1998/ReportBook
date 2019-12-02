package backend.CSVConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSV {
    private FileReader fileReader = null;
    private FileWriter fileWriter = null;
    private BufferedReader bufferedReader = null;


    public void open(String fileName, char mode) {
        if (mode == 's') {
            try {
                fileWriter = new FileWriter(fileName + ".csv");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (mode == 'l') {
            try {
                fileReader = new FileReader(fileName + ".csv");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void save(String string) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("\n");
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String load(String fileName) {
        String loadedString = "";
        StringBuilder stringBuilder = new StringBuilder();


        try {
            fileReader = new FileReader(fileName + ".csv");
            bufferedReader = new BufferedReader(fileReader);

            while ((loadedString = bufferedReader.readLine()) != null) {
                String[] personsAttribute = loadedString.split("\n");
                String name = personsAttribute[0];
                String department = personsAttribute[1];

                stringBuilder.append(name);
                stringBuilder.append("\n");
                stringBuilder.append(department);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
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
