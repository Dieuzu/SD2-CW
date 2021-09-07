public class Booth {
    private Patient PatientX; //Patient type variable inside Booth class

    public Patient getPatientX() { // Getter
        return PatientX;
    }

    public void setPatientX(Patient x) { //Setter
        PatientX = x;
    }

    public Booth(Patient PN) { // Constructor
        PatientX = PN;

    }
    
}
