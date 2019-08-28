package com.ibm.report.report.controller;

import java.io.FileInputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.report.report.domain.Details;
import com.ibm.report.report.services.DetailService;

@RestController
@RequestMapping(value="api/v1")
@CrossOrigin(origins = "*")
public class Controller {

	@Autowired
    private DetailService detailService;
	
	@PostMapping("detail")
    public ResponseEntity<?> saveDetail(@RequestBody Details details) throws Exception
    {
		Details savedDetails = detailService.saveDetails(details);
		return new ResponseEntity<Details>(savedDetails, HttpStatus.CREATED);   
    }
	
	@GetMapping("report")
	public void empReport(HttpServletResponse response) throws Exception {
				
		String setResponse = detailService.generateReport();
		
		System.out.println(setResponse);
		
		IOUtils.copy( new FileInputStream( "C:\\Users\\MethalepurayilArathi\\Documents\\workspace-spring-tool-suite-4-4.3.2.RELEASE\\report\\src\\main\\resources\\Emp-Rpt.pdf" ), response.getOutputStream( ) );
	      response.setContentType( "application/pdf" );
	      response.setHeader( "Content-Disposition", "attachment; filename=Emp-Rpt.pdf");
	      response.flushBuffer( );
		
	}
		
}
