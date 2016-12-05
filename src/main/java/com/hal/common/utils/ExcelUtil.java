package com.hal.common.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hal on 2016/11/26.
 */
public class ExcelUtil {
    public final static String PATH = "D:\\tmp\\demo.xlsx";

    public static void main(String[] args) throws Exception {
       /* Workbook workbook = CreateHSSFWorkBook(PATH);
        Sheet sheet = workbook.createSheet("first");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(2);
        cell.setCellValue("second");
        flushFile(workbook,PATH);*/
        OPCPackage pkg = OPCPackage.open(new File("D:\\tmp\\user.xlsx"));
        Workbook wb = new XSSFWorkbook(pkg);
        List<String> head = new ArrayList<String>();
        List<Object> value = new ArrayList<Object>();
        Sheet sheet = wb.getSheetAt(0);
        int firstRow = sheet.getFirstRowNum();
        Row rowf = sheet.getRow(firstRow);
        int lastColc = rowf.getLastCellNum();
        for (int j = 0; j < lastColc; j++) {
            Cell c = rowf.getCell(j);
            head.add(c.getRichStringCellValue().getString());
        }
        int lastRow = sheet.getLastRowNum();
        for (int i = 1; i <= lastRow; i++) {
            Row row = sheet.getRow(i);
            int lastCol = row.getLastCellNum();
            for (int j = 0; j < lastCol; j++) {
                Cell cell = row.getCell(j);
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        value.add(cell.getRichStringCellValue().getString());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            value.add(cell.getDateCellValue());
                        } else {
                            value.add(cell.getNumericCellValue());
                        }
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        value.add(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        value.add(cell.getCellFormula());
                        break;
                    case Cell.CELL_TYPE_BLANK:
                        value.add(null);
                        break;
                    default:
                        break;
                }
            }
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("insert into user(");
        for (String hd : head) {
            buffer.append(hd + ",");
        }
        buffer.append(")value(");
        for (Object o : value) {
            buffer.append("'" + o + "',");
        }
        System.out.print(buffer.toString());
    }


    public static Workbook CreateHSSFWorkBook(String filename) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        flushFile(workbook, filename);
        return workbook;
    }

    public static Sheet CreteSheet(String workname, String sheetName) throws IOException {
        Workbook wb = CreateHSSFWorkBook(workname);
        Sheet sheet = wb.createSheet(sheetName);
        FileOutputStream fos = new FileOutputStream(workname);
        wb.write(fos);
        fos.close();
        return sheet;
    }

    public static void flushFile(Workbook workbook, String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.close();
    }

    private static void createCell(Workbook wb, Row row, short column, short halign, short valign) {
        Cell cell = row.createCell(column);
        cell.setCellValue("Align It");
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cell.setCellStyle(cellStyle);
    }

    public static CellStyle setStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLUE.getIndex());
        style.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        return style;
    }
}
