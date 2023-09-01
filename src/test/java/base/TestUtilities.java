package base;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TestUtilities extends BaseTest {

    public void writeToFile(String fileName, ArrayList data){
        try {
            FileWriter newFile = new FileWriter(testName+getTodaysDate()+getSystemTime()+fileName+ ".txt");
            for (int i = 0; i < data.size(); i++){
                String productDetail = (String) data.get(i);
                newFile.write(productDetail);
                newFile.write(System.getProperty("line.separator"));
            }
            newFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Today's date in yyyyMMdd format
    private static String getTodaysDate() {
        return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
    }

    // Current time in HHmmssSSS
    private static String getSystemTime() {
        return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
    }
}
