package backend.saveinstance;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.Locale;
import java.util.Map;

public class SaveInstance {


    private static SaveInstance INSTANCE;

    private Map<ChoiceBox, TextField> boxes;

    private int reportBookNumber;

    private String fromDate;

    private String toDate;

    private String activitiesText;

    private String instructionsText;

    private String schoolSubject;

    private String secondSchoolSubject;

    private String SubjectInput;

    private String SecondSubjectInput;

    private Locale lang;


    private SaveInstance() {
    }


    public static SaveInstance getInstance() {
        if (SaveInstance.INSTANCE == null) {
            SaveInstance.INSTANCE = new SaveInstance();
            return SaveInstance.INSTANCE;
        }
        return INSTANCE;
    }


    public int getReportBookNumber() {
        return reportBookNumber;
    }

    public void setReportBookNumber(int reportBookNumber) {
        this.reportBookNumber = reportBookNumber;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
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

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Locale getLang() {
        return lang;
    }

    public void setLang(Locale lang) {
        this.lang = lang;
    }

    public Map<ChoiceBox, TextField> getBoxes() {
        return boxes;
    }

    public void setBoxes(Map<ChoiceBox, TextField> boxes) {
        this.boxes = boxes;
    }
}

