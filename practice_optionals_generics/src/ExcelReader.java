import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExcelReader {

    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream(new File("path/to/your/excel.xlsx"));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header row

                String userId = row.getCell(13).getStringCellValue(); // Assuming user id is in column 14 (index 13)

                String url = "https://private-api.aws.playco.com/api/billing-service/v1.0/users/" + userId + "/billing/self-deactivation?sync=true&immediate=true&publishEvent=true";
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Postman-Token", "9e5bd729-e0b9-404c-a656-420c7f5a6142");
                con.setRequestProperty("cache-control", "no-cache");
                con.setRequestProperty("origin", "test-logging");

                int responseCode = con.getResponseCode();
                System.out.println("Sending 'POST' request to URL : " + url);
                System.out.println("Response Code : " + responseCode);

                con.disconnect();
            }

            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}