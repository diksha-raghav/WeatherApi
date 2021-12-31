package com.dao.Service;

import java.io.File;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.model.dao.ReportViewerDao;

public class reportViewerService {

	public XSSFWorkbook getReport(String state[], String[] form, String fdate, String tdate) {
		ReportViewerDao rdao=new ReportViewerDao();
		return rdao.getReport(state, form, fdate,tdate);
		// TODO Auto-generated method stub

	}
	public XSSFWorkbook getReport(String state, String district,String user, String fdate, String tdate) {
		ReportViewerDao rdao=new ReportViewerDao();
		return rdao.getReport(state, district, user,fdate,tdate);
		// TODO Auto-generated method stub

	}
	public XSSFWorkbook getReport(String state,String fdate, String tdate) {
		ReportViewerDao rdao=new ReportViewerDao();
		return rdao.getReport(state,fdate,tdate);
		// TODO Auto-generated method stub

	}
	//public static void exceloperationBasedOnState(File file, int inserted_rows_count, int failed_rows_count,
	//		List<String> stateList) {
		// TODO Auto-generated method stub
	//	BulkUploadDao.perform_operationBasedOnState(file, inserted_rows_count, failed_rows_count, stateList);

	//}
}

