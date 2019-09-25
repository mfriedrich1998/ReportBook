package backend.saveinstance;

public class SaveInstance {


    private static SaveInstance INSTANCE;


    private int reportBookNumber;

    private String fromDate;

    private String activitiesText;

    private String instructionsText;


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

    public String getFromDate(){
        return fromDate;
    }

    public void setFromDate(String fromDate){
        this.fromDate = fromDate;
    }

    public String getActivitiesText(){
        return activitiesText;
    }

    public void setActivitiesText(String activitiesText){
        this.activitiesText = activitiesText;
    }

    public String getInstructionsText(){
        return instructionsText;
    }

    public void setInstructionsText(String instructionsText){
        this.instructionsText = instructionsText;
    }


}
