package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public String[][] getData(String path, String fileName, String sheetName) throws IOException {
		File file = new File(path + "\\" + fileName);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = null;
		DataFormatter formatter = new DataFormatter();
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.contains(".xlsx")) {
			workbook = new XSSFWorkbook(fis);
		} else if (fileExtensionName.contains(".xls")) {
			workbook = new HSSFWorkbook(fis);
		}

		Sheet workbookSheet = workbook.getSheet(sheetName);
		int rowCount = workbookSheet.getPhysicalNumberOfRows();
		int colCount = workbookSheet.getRow(0).getLastCellNum();

		String[][] data = new String[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			Row row = workbookSheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				Cell cell = row.getCell(j);
				if (cell != null) {
					data[i][j] = formatter.formatCellValue(cell);
				}
			}
		}
		return data;

	}

}
