public class Patient{
    // Primitive type Variable inside patient class
    private String FSTName;
    private String SURName;
    private int PAge;
    private String PeeCity;
    private String PNICPN;
    private String PVaccType;

    // Getters for the above variables
    public String getmeFST(){
        return FSTName;
    }
    public String getmeSUR(){
        return SURName;
    }
    public int getmePA(){
        return PAge;
    }
    public String getmePee(){
        return PeeCity;
    }
    public String getmePNICPN(){
        return PNICPN;
    }
    public String getmePVacc(){
        return PVaccType;
    }

    //Setters for the above variables
    public void setmeFST(String x){
        FSTName = x;   
    }
    public void setmeSUR(String y){
        SURName = y;   
    }
    public void setmePA(int s){
        PAge = s;   
    }
    public void setmePee(String z){
        PeeCity = z;   
    }
    public void setmePNICPN(String q){
        PNICPN = q;   
    }
    public void setmePVacc(String d){
        PVaccType = d;   
    }

    public Patient(String PFN){
        FSTName = PFN;

    }

    // Constructor 
    public Patient(String Name, String Surname, int Age, String City, String ID, String VaccineType){
        FSTName= Name ;
        SURName= Surname ;
        PAge= Age ;
        PeeCity= City;
        PNICPN= ID;
        PVaccType = VaccineType;
    }

}