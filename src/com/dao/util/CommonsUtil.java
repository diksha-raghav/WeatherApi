package com.dao.util;

import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class CommonsUtil {

	public static boolean isRowEmpty(Row row) {
		////System.out.println(row);
		if (row != null) {
			for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
				Cell cell = row.getCell(c);
				if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
					return false;
			}
		}
		return true;
	}
	public static String scientificNotationToString(double value) // Got here 6.743240136E7 or something..
	{
		DecimalFormat formatter;

		if (value - (int) value > 0.0)
			formatter = new DecimalFormat("0"); // Here you can also deal with rounding if you wish..
		else
			formatter = new DecimalFormat("0");

		return formatter.format(value);
	}
}
