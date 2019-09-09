package backend;

import net.sf.jasperreports.engine.*;

import java.util.HashMap;
import java.util.Map;

public class PDFReader {

    public static void main(String[] args) {
        try {

            String filePath = "C:\\Users\\mfriedrich\\Desktop\\Report.jrxml";


            JasperReport jasperReport = JasperCompileManager.compileReport(filePath);
            JRDataSource dataSource = new JREmptyDataSource();

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("DEPARTMENT", "Department");
            parameters.put("DEPARTMENT_NAME", "SustainHub");
            parameters.put("RB_NUMBER", "Ausbildungsnachweis Nr.");
            parameters.put("TRAINEES_NAME", "Name des Azubis");
            parameters.put("NAME", "Michelle Friedrich");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\mfriedrich\\Desktop\\test_Pdf.pdf");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
