package backend.PDF;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRSaver;

import java.io.InputStream;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


public class PDFGenerator {


    public static void main(String[] args) {

        PDFGenerator reader = new PDFGenerator();
        reader.printPDF();

    }

    public void printPDF() {

        InputStream resource = PDFGenerator.class.getResourceAsStream("../../reports/Report.jrxml");

        System.out.println("Compiling Report Design ...");
        try {
            /**
             * Compile the report to a file name same as
             * the JRXML file name
             */
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("RB_NUMBER", "Report Book Number ");
            params.put("DEPARTMENT", "Department");
            params.put("DEPARTMENT_NAME", "SustainHub");
            params.put("TRAINEES_NAME", "Trainees name");
            params.put("NAME", "Michelle Friedrich");
            params.put("SIGNATURE_TRAINEE", "Signature trainee");
            params.put("SIGNATURE_MENTOR", "Signature mentor");

            InputStream subreport1 = PDFGenerator.class.getResourceAsStream("../../reports/ProfActivities.jrxml");

            InputStream subreport2 = PDFGenerator.class.getResourceAsStream("../../reports/Instuctions.jrxml");

            JRSaver.saveObject(JasperCompileManager.compileReport(subreport1), "Blank_A4_4.jasper");

            JRSaver.saveObject(JasperCompileManager.compileReport(subreport2), "Blank_A4_5.jasper");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

            JasperExportManager.exportReportToPdfFile(jasperPrint, "./Report-" + getCurrentDate() + ".pdf");


        } catch (JRException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Done compiling!!! ...");

    }

    private String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);
        return currentDate;
    }


}
