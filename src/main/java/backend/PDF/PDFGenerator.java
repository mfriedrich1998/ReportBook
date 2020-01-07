package backend.PDF;


import backend.I18N.I18N;
import backend.saveinstance.SaveInstance;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRSaver;

import java.io.InputStream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class PDFGenerator {

    private SaveInstance instance = SaveInstance.getInstance();

    LocalDate firstDate = instance.getFromDate();

    LocalDate toDate = instance.getToDate();

    String subject = instance.getSchoolSubject();

    String secSubject = instance.getSecondSchoolSubject();

    String schoolinput = instance.getSubjectInput();

    String secSchoolinput = instance.getSecondSubjectInput();

    String number = instance.getReportBookNumber();

    String activities = instance.getActivitiesText();

    String instructions = instance.getInstructionsText();

    String name = I18N.get("key37");

    String department = I18N.get("key44");

    String rbNumber = I18N.get("key38");

    String traineeSignature = I18N.get("key42");

    String mentorSignature = I18N.get("key43");

    String schoolSubjects = I18N.get("key41");

    String profActivities = I18N.get("key39");

    String instruction = I18N.get("key40");

    String from = I18N.get("key45");

    String to = I18N.get("key46");


    public static void main(String[] args) {

        PDFGenerator reader = new PDFGenerator();
        reader.printPDF();

    }

    public void printPDF() {

        InputStream resource = PDFGenerator.class.getResourceAsStream("../../reports/Report.jrxml");


        String subjectString = instance.getLeftSubjects().entrySet().stream().map(e -> e.getKey() + " " + e.getValue()).collect(Collectors.joining("\n"));

        String secondSubjectString = instance.getRightSubjects().entrySet().stream().map(e -> e.getKey() + " " + e.getValue()).collect(Collectors.joining("\n"));

        System.out.println("Compiling Report Design ...");
        try {
            /**
             * Compile the report to a file name same as
             * the JRXML file name
             */
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("RB_NUMBER", rbNumber + " " + number);
            params.put("DEPARTMENT", department);
            params.put("DEPARTMENT_NAME", instance.getName());
            params.put("TRAINEES_NAME", name);
            params.put("NAME", instance.getDepartment());
            params.put("SIGNATURE_TRAINEE", traineeSignature);
            params.put("SIGNATURE_MENTOR", mentorSignature);
            params.put("SCHOOL_SUBJECTS", schoolSubjects);
            params.put("DAY_1", subject + " " + schoolinput + "\n" + subjectString);
            params.put("DAY_2", secSubject + " " + secSchoolinput + "\n" + secondSubjectString);
            params.put("ACTIVITIES", activities);
            params.put("PROFESSIONAL_ACTIVITIES", profActivities);
            params.put("INSTRUCTIONS_HEADER", instruction);
            params.put("INSTRUCTIONS", instructions);
            params.put("FROM_TODATE", from + firstDate + " " + to + toDate);

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
