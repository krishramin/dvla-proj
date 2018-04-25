package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVDataReader {

    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";

    public List<String> getCsvData(String filePath){

        List<String> csvRows = new ArrayList<String>();
        try {

            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {

               csvRows.add(line);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return csvRows;
    }
}
