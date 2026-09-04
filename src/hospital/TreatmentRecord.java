package hospital;

public class TreatmentRecord {
    public int treatmentId;
    public int patientId;
    public String date;
    public String doctor;
    public String notes;

    public TreatmentRecord(int treatmentId, int patientId, String date, String doctor, String notes) {
        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.date = date;
        this.doctor = doctor;
        this.notes = notes;
    }

    public void display() {
        System.out.println("Treatment ID: " + treatmentId);
        System.out.println("Patient ID  : " + patientId);
        System.out.println("Date        : " + date);
        System.out.println("Doctor      : " + doctor);
        System.out.println("Notes       : " + notes);
    }
}