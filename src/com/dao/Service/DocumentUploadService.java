package com.dao.Service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;

import com.model.dao.DocumentUploadDao;

public class DocumentUploadService {
	public static Map<String, Object> uploadDoc(List<Part> files) throws IndexOutOfBoundsException {
		return new DocumentUploadDao().upload(files);
	}
}
