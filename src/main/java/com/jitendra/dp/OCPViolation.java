package com.jitendra.dp;

//OCP - Open-Closed Principle. Open for extension and closed for modification.
// We should be able add new functionality (extend) without modifying existing code.
// When follow OCP, it helps to add functionality without breaking existing code.

/*
	ReportingService class handles report generation task,
	such as word report, excel report and when need to generate another report 
	say. PDF report, then need to change the code in ReportingService class.
	i.e. Need to add one more elf if statement
	Cannot extend without modify, so this code is against OCP.
	This is tight coupling, so not scalable. This can lead to error. 
	This code violates OCP
*/

class ReportingService{
    public void generateReport(String type) {
        if (type.equals("Word")) {
            System.out.println("Generate word report");
        } else if (type.equals("Excel")) {
            System.out.println("Generate excel report");
        } else if (type.equals("PDF")) {
            System.out.println("Generate pdf report");
        }
    }
}

public class OCPViolation{
	public static void main(String[] args) {
		ReportingService rService = new ReportingService();
		rService.generateReport("Word");
		rService.generateReport("Excel");
		rService.generateReport("PDF");
	}
}
