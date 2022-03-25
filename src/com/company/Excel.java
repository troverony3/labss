package com.company;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Excel {
    private List<List<Double>> listvalue = new ArrayList<>();
    private List<String> head = new ArrayList<>();

    public Excel() {
    } //конструктор

    public void read(String str) { //название класса
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(str);
            XSSFSheet sheet = workbook.getSheetAt(4);

            short lastCellNum = sheet.getRow(0).getLastCellNum();//узнали количество ячеек в строке
            for (int i = 0; i < lastCellNum; i++) {
                listvalue.add(new ArrayList<>());//добавили в общий массив количество колонок
            }
            XSSFRow header = sheet.getRow(0);//взяли первую строку, чтобы потом получить названия колонок
            for (int i = 0; i < lastCellNum; i++) {
                head.add(header.getCell(i).getStringCellValue());
            }
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < lastCellNum; j++) {
                    listvalue.get(j).add(row.getCell(j).getNumericCellValue());
                }

            }
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String str, LinkedHashMap<String, List<Double>> calc) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Troeglazova");
            XSSFRow header = sheet.createRow(0);
            for (int i = 1; i <= head.size(); i++) {
                header.createCell(i).setCellValue(head.get(i - 1));
            }
            int i = 1;
            for (String s : calc.keySet()) {
                XSSFRow row = sheet.createRow(i);
                row.createCell(0).setCellValue(s);
                for (int j = 1; j <= head.size(); j++) {
                    row.createCell(j).setCellValue(calc.get(s).get(j - 1));
                }
                i++;
            }

            File file = new File(str);
            workbook.write(new FileOutputStream(file));
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<List<Double>> getlistvalue() {
        return this.listvalue;

    }


}