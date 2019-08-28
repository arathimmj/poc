package com.ibm.report.report.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.report.report.domain.Details;
import com.ibm.report.report.repository.DetailRepository;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class DetailServiceImpl implements DetailService {
	
	DetailRepository detailRepository;
	
	@Autowired
	public DetailServiceImpl(DetailRepository detailRepository){

        this.detailRepository = detailRepository;

    }
	

	@Override
	public Details saveDetails(Details details) throws Exception {
		System.out.println(details.getFirstName());
		System.out.println(details.getLastName());
		System.out.println(details.getCity());
		System.out.println(details.getPhoneNo());
		
		Details detail = detailRepository.save(details);
		
		return detail;
	}

	public String generateReport() {
		try {

			String reportPath = "C:\\Users\\MethalepurayilArathi\\Documents\\workspace-spring-tool-suite-4-4.3.2.RELEASE\\report\\src\\main\\resources";

			JasperReport jasperReport = JasperCompileManager.compileReport(reportPath + "\\detail-report.jrxml");
			
			List<Details> listOfDetails = detailRepository.findAll();

			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(listOfDetails);

			Map<String, Object> parameters = new HashMap<>();
			parameters.put("title", "Detail Report");

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,jrBeanCollectionDataSource);

			JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\Emp-Rpt.pdf");

			System.out.println("Done");
			

			return "Report successfully generated @path= " + reportPath;

		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}
