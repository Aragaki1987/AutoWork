package com.san.auto.job;

import com.san.auto.entity.Task;
import com.san.auto.enums.TypeOfWork;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by nguye on 3/25/2017.
 */
public class ExcelReader {
    private static Map<String, Integer> headerKeys;

    public static List<Task> loadTask(String location) {
        List<Task> tasks = new ArrayList<Task>();
        headerKeys = new HashMap<String, Integer>();
        InputStream input = null;

        try {
            input = new FileInputStream(new File(location));

            Workbook workbook = new XSSFWorkbook(input);

            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            Row header = rowIterator.next();
            loadHeader(header);


            while(rowIterator.hasNext()) {
                Row currentRow = rowIterator.next();
                String keyId = currentRow.getCell(headerKeys.get("key")).getStringCellValue();
                String description = currentRow.getCell(headerKeys.get("description")).getStringCellValue();
                String typeOfWork = currentRow.getCell(headerKeys.get("type of work")).getStringCellValue();
                Double worked = null;
                try {
                    worked = currentRow.getCell(headerKeys.get("worked")).getNumericCellValue();
                } catch (Exception ex) {
                    worked = Double.valueOf(currentRow.getCell(headerKeys.get("worked")).getStringCellValue());
                }
                Date date = currentRow.getCell(headerKeys.get("date")).getDateCellValue();


                Task task = new Task(keyId, date, worked, description, TypeOfWork.getTypeOfWork(typeOfWork));
                tasks.add(task);
            }

        } catch (Exception ex) {
            System.out.println("Failed to reading excel file :" + location);
            ex.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return tasks;
    }

    private static void loadHeader(Row header) {
        Iterator<Cell> cells = header.iterator();
        int index = 0;
        while(cells.hasNext()) {
            headerKeys.put(cells.next().getStringCellValue().trim().toLowerCase(), index);
            index++;
        }
    }
}
