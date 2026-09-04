package hospital;


public class Visit {
    public int visitId;
    public String date;
    public String doctor;
    public String diagnosis;
    public String treatment;
    public Visit next;

    public Visit(int visitId, String date, String doctor, String diagnosis, String treatment) {
        this.visitId = visitId;
        this.date = date;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.next = null;
    }

    public void display() {
        System.out.println("  Visit ID  : " + visitId);
        System.out.println("  Date      : " + date);
        System.out.println("  Doctor    : " + doctor);
        System.out.println("  Diagnosis : " + diagnosis);
        System.out.println("  Treatment : " + treatment);
    }
}