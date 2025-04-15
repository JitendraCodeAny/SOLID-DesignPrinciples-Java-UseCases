package com.jitendra.dp;

// OCP - Open-Closed Principle. Open for extension and closed for modification.
//We should be able add new functionality (extend) without modifying existing code.
//When follow OCP, it helps to add functionality without breaking existing code.
/*
	 ReportingService class handles report generation task
	 When there is a need for new report type generation, 
	 ReportingService class is not modified, instead new class is created for new report to generate.
	 To achieve this, abstract class is introduced as an abstraction to be implemented by new class 
	 Uses Runtime Polymorphism to achieve this.
	 This code comply with OCP.
	 Benefit: Code is exensible, testable, maintainable and scalable
 */

//Abstraction (Abstract class)
abstract class ReportGenerator {
	abstract void generateReport();
}

class WordReportGenerator extends ReportGenerator {
	public void generateReport() {
		System.out.println("Generating word report");
	}
}

class ExcelReportGenerator extends ReportGenerator {
	public void generateReport() {
		System.out.println("Generating excel report");
	}
}

class PDFReportGenerator extends ReportGenerator {
	public void generateReport() {
		System.out.println("Generating pdf report");
	}
}

class ReportingService {
	public void generateRport(ReportGenerator reportGenerator) {
		reportGenerator.generateReport();
	}
}

// Uses Runtime Polymorphism, for each new report type, ReportingService class is not changed
public class OCP {
	public static void main(String[] args) {
		ReportingService rService = new ReportingService();

		ReportGenerator wordReport = new WordReportGenerator();
		rService.generateRport(wordReport);

		ReportGenerator excelReport = new ExcelReportGenerator();
		rService.generateRport(excelReport);

		ReportGenerator pdfRport = new PDFReportGenerator();
		rService.generateRport(pdfRport);

	}
}
