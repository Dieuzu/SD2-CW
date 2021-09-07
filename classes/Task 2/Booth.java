public class Booth {
    private String patientName; // Primitive type Variable inside booth class

    public String getPatientName() { // Getter
        return patientName;
    }

    public void setPatientName(String x) { //Setter
        patientName = x;
    }

    public Booth(String PN) { // Constructor
        patientName = PN;

    }
}