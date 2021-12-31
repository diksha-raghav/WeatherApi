package com.dao.Service;

import java.io.File;
import java.util.List;

import com.model.dao.BulkUploadDao;

public class BulkUploadService {

	public static void exceloperation(File file, int inserted_rows_count, int failed_rows_count) {
		BulkUploadDao.perform_operation(file, inserted_rows_count, failed_rows_count);
		// TODO Auto-generated method stub

	}

	public static void exceloperationBasedOnState(File file, int inserted_rows_count, int failed_rows_count,
			List<String> stateList) {
		// TODO Auto-generated method stub
		BulkUploadDao.perform_operationBasedOnState(file, inserted_rows_count, failed_rows_count, stateList);

	}
}
