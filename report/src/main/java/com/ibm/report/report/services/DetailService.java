package com.ibm.report.report.services;

import java.util.List;

import com.ibm.report.report.domain.Details;

public interface DetailService {
	
	Details saveDetails(Details details) throws Exception;
	
	String generateReport() throws Exception;

}
