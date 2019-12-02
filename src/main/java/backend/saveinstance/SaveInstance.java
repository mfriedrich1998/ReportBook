package backend.saveinstance;

import backend.CSVConfig.CSV;
import javafx.collections.ObservableSet;
import java.time.LocalDate;
import java.util.Locale;

public class SaveInstance {


    private static SaveInstance INSTANCE;

    private String reportBookNumber;

    private LocalDate fromDate;

    private LocalDate toDate;

    private String activitiesText;

    private String instructionsText;

    private String schoolSubject;

    private String secondSchoolSubject;

    private String SubjectInput;

    private String SecondSubjectInput;

    private Locale lang;

    private ObservableSet selectedBoxes;

    private String name;

    private String department;


    private SaveInstance() {
    }


    public static SaveInstance getInstance() {
        if (SaveInstance.INSTANCE == null) {
            SaveInstance.INSTANCE = new SaveInstance();
            return SaveInstance.INSTANCE;
        }
        return INSTANCE;
    }


    public boolean loadConfigurationIfExisting(String fileName) {
        CSV csv = new CSV();
        csv.open(fileName, 'l');
        csv.load(fileName);

        if (INSTANCE.getName() != null && INSTANCE.getDepartment() != null) {
            csv.close();
            return true;
        }
        csv.close();
        return false;
    }


    public String getReportBookNumber() {
        return reportBookNumber;
    }

    public void setReportBookNumber(String reportBookNumber) {
        this.reportBookNumber = reportBookNumber;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public String getActivitiesText() {
        return activitiesText;
    }

    public void setActivitiesText(String activitiesText) {
        this.activitiesText = activitiesText;
    }

    public String getInstructionsText() {
        return instructionsText;
    }

    public void setInstructionsText(String instructionsText) {
        this.instructionsText = instructionsText;
    }

    public String getSchoolSubject() {
        return schoolSubject;
    }

    public void setSchoolSubject(String schoolSubject) {
        this.schoolSubject = schoolSubject;
    }

    public String getSecondSchoolSubject() {
        return secondSchoolSubject;
    }

    public void setSecondSchoolSubject(String secondSchoolSubject) {
        this.secondSchoolSubject = secondSchoolSubject;
    }

    public String getSubjectInput() {
        return SubjectInput;
    }

    public void setSubjectInput(String subjectInput) {
        SubjectInput = subjectInput;
    }

    public String getSecondSubjectInput() {
        return SecondSubjectInput;
    }

    public void setSecondSubjectInput(String secondSubjectInput) {
        SecondSubjectInput = secondSubjectInput;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Locale getLang() {
        return lang;
    }

    public void setLang(Locale lang) {
        this.lang = lang;
    }

    public ObservableSet getSelectedBoxes() {
        return selectedBoxes;
    }

    public void setSelectedBoxes(ObservableSet selectedBoxes) {
        this.selectedBoxes = selectedBoxes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}

