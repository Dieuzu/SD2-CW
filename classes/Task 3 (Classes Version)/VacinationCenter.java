import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class VacinationCenter {
    public static Booth[] CovidBooth = new Booth[6]; //Array of booth type that holds Names of patients in all 6 booths
    public static int boothNum = 0;
    public static int CVStock = 150; // Variable to hold Vaccination Stock

    public static void main(String[] args) {

        for (int x = 0; x < 6; x++)  //initializing the booth type array with new Patients per Booth with all data set to empty
            CovidBooth[x] = new Booth(new Patient("e", "e", 0, "e", "e", "e"));

        PrintMenu();
    }

    public static void PrintMenu() { // Print Menu method
        Scanner input = new Scanner(System.in);
        Boolean Boothchecker = true;
        while (Boothchecker) {

            System.out.print("\n======================== MENU ==============================");
            System.out.print("\n100 or VVB: View all Vaccination Booths");
            System.out.print("\n101 or VEB: View all Empty Booths");
            System.out.print("\n102 or APB: Add Patient to a Booth");
            System.out.print("\n103 or RPB: Remove Patient from a Booth");
            System.out.print("\n104 or VPS: View Patients Sorted in alphabetical order ");
            System.out.print("\n105 or SPD: Store Program Data into file");
            System.out.print("\n106 or LPD: Load Program Data from file");
            System.out.print("\n107 or VRV: View Remaining Vaccinations");
            System.out.print("\n108 or AVS: Add Vaccinations to the Stock");
            System.out.print("\n999 or EXT: Exit the Program");
            System.out.print("\n============================================================");

            System.out.print("\nEnter your Input : ");
            String userInput = input.nextLine();

            if (userInput.equals("100") || userInput.equalsIgnoreCase("VVB")) {
                System.out.print("\nEntered input is either 100 or VVB!\n ");
                ViewVBooth(input);
            } else if (userInput.equals("101") || userInput.equalsIgnoreCase("VEB")) {
                System.out.print("\nEntered input is either 101 or VEB!\n");
                ViewEBooth();
            } else if (userInput.equals("102") || userInput.equalsIgnoreCase("APB")) {
                System.out.print("\nEntered input is either 102 or APB!\n");
                AddP2Booth(input);
            } else if (userInput.equals("103") || userInput.equalsIgnoreCase("RPB")) {
                System.out.print("\nEntered input is either 103 or RPB!\n");
                WipeP4rmBooth(input);
            } else if (userInput.equals("104") || userInput.equalsIgnoreCase("VPS")) {
                System.out.print("\nEntered input is either 104 or VPS!\n");
                Sorter();
            } else if (userInput.equals("105") || userInput.equalsIgnoreCase("SPD")) {
                System.out.print("\nEntered input is either 105 or SPD!\n");
                StorePrgrmData();
            } else if (userInput.equals("106") || userInput.equalsIgnoreCase("LPD")) {
                System.out.print("\nEntered input is either 106 or LPD!\n");
                LoadPrgrmData();
            } else if (userInput.equals("107") || userInput.equalsIgnoreCase("VRV")) {
                System.out.print("\nEntered input is either 107 or VRV!\n");
                ViewRCV();
            } else if (userInput.equals("108") || userInput.equalsIgnoreCase("AVS")) {
                System.out.print("\nEntered input is either 108 or AVS!\n");
                AddCVStock(input);
            } else if (userInput.equals("999") || userInput.equalsIgnoreCase("EXT")) {
                System.out.print("\nThank you For Trying the Application! \n");
                Boothchecker = false;
            } else {
                System.out.print("\nThe entered input is Invalid!\n");
            }
        }
    }

    // View all Vaccination Booths method
    public static void ViewVBooth(Scanner input) {
        int OccupiCount = 0;
        for (int x = 0; x < 6; x++) {

            if (!CovidBooth[x].getPatientX().getmeFST().equals("e")) {
                OccupiCount += 1;
            }
        }
        showAllPatients();
        if (OccupiCount >0) {
            Boolean Pdloop = true;
            while (Pdloop){
                System.out.print("\nEnter a booth number to view more details about a patient \nOR Enter 99 to go back to the main menu: ");
                int PUInput = Integer.parseInt(input.nextLine());
                if (PUInput >= 0 && PUInput<6){
                    if(!CovidBooth[PUInput].getPatientX().getmeFST().equals("e")){
                        displayPatient(PUInput);
                        System.out.println("\nWould you like to check another Patient ? \n");
                        showAllPatients();
                        continue;
                    }else{
                        System.out.println("\nSorry booth number " + PUInput + " is Vacant! and therefore doesnt have any patient details to display!");  
                        continue;
                    }
                }else if (PUInput == 99){
                    System.out.println("\nReturning to back to menu");
                    Pdloop= false;
                }else{
                    System.out.println("\nInvalid Input Enterd! Try again pwease ^_^\n");
                    continue;
                }
            }

        }

    }

    public static void showAllPatients(){ //displays all booths wether they are free or occupied
        System.out.print("\nDisplaying all Vaccination Booths: \n");
        for (int x = 0; x < 6; x++) {
            if (CovidBooth[x].getPatientX().getmeFST().equals("e")) {
                System.out.println("Booth Number " + x + " is Free");
            } else {
                System.out.println("Booth Number " + x + " is occupied by: " + CovidBooth[x].getPatientX().getmeFST() + " " + CovidBooth[x].getPatientX().getmeSUR());
            }
        }
    }

    public static void displayPatient(int x){ // displays all details of a patient of requested index method to be called in the ViewVBooth() method
        System.out.println("=================== Booth "+x+" ===================");
        System.out.println("First Name              : "+CovidBooth[x].getPatientX().getmeFST());
        System.out.println("Surname                 : "+CovidBooth[x].getPatientX().getmeSUR());
        System.out.println("Age                     : "+CovidBooth[x].getPatientX().getmePA());
        System.out.println("City                    : "+CovidBooth[x].getPatientX().getmePee());
        System.out.println("Nic / Passport Number   : "+CovidBooth[x].getPatientX().getmePNICPN());
        System.out.println("Vaccination type        : "+CovidBooth[x].getPatientX().getmePVacc());
        System.out.println("================================================");
    }

    // View all Empty Booths method
    public static void ViewEBooth() {
        System.out.print("\nDisplaying all Empty Booths: \n");
        for (int x = 0; x < 6; x++) {
            if (CovidBooth[x].getPatientX().getmeFST().equals("e"))
                System.out.println("Booth Number " + x + " is Free");
        }
    }

    // Add Patient to a Booth method
    public static void AddP2Booth(Scanner input) {
        int OccupiCount = 0; //Variable to count how many booths are fully occupied
        for (int x = 0; x < 6; x++) {

            if (!CovidBooth[x].getPatientX().getmeFST().equals("e")) {
                OccupiCount += 1;
            }
        }
        if (OccupiCount == 6) { //condition to say unable to add patients if all 6 booths occupied
            System.out.print("\nWARNING!: unable to add more patients!\nSeems Like all Booths are Full! Try again later when a Booth is Free");
            return;
        }

        System.out.print("\nEnter patient First Name : ");
        String PName = input.nextLine(); 
        System.out.print("\nEnter patient Surname : ");
        String SName = input.nextLine(); 
        System.out.print("\nEnter patient Age : ");
        int Age = Integer.parseInt(input.nextLine()); 
        System.out.print("\nEnter patient City : ");
        String City = input.nextLine(); 
        System.out.print("\nEnter patient NIC/Passport Number : ");
        String NIC = input.nextLine(); 

        Boolean Boothchecker = true;
        while (Boothchecker) {         // get vaccine type and auto assign patients to proper booths
            System.out.print("\n==================== Vaccine type ====================");
            System.out.print("\nEnter 1 for : AstraZeneca");
            System.out.print("\nEnter 2 for : Sinopharm");
            System.out.print("\nEnter 3 For : Pfizer");
            System.out.print("\n======================================================\n");
    
            System.out.print("\nEnter your Input : ");
            String VType = input.nextLine();

            if (VType.equals("1")){
                if (CovidBooth[0].getPatientX().getmeFST().equals("e")){
                    CovidBooth[0].setPatientX(new Patient(PName, SName, Age, City, NIC, "AstraZeneca"));
                    System.out.print(PName+ " "+ SName + " has Been Added to the Booth Number 0 and will be Adminsterd the AstraZeneca vaccine!\n");
                    Boothchecker = false;
                }else if (CovidBooth[1].getPatientX().getmeFST().equals("e")){
                          CovidBooth[1].setPatientX(new Patient(PName, SName, Age, City, NIC, "AstraZeneca"));
                          System.out.print(PName+ " "+ SName + " has Been Added to the Booth Number 1 and will be Adminsterd the AstraZeneca vaccine!\n");
                          Boothchecker = false;
                }else{
                    System.out.print("Sorry there aren't any vacant booths that can administer AstraZeneca Try Another Vaccine Maybe ?\n");
                    continue;
                }
            }else if (VType.equals("2")){
                if(CovidBooth[2].getPatientX().getmeFST().equals("e")){
                   CovidBooth[2].setPatientX(new Patient(PName, SName, Age, City, NIC, "Sinopharm"));
                   System.out.print(PName+ " "+ SName + " has Been Added to the Booth Number 2 and will be Adminsterd the Sinopharm vaccine!\n");
                   Boothchecker=false;
                }else if (CovidBooth[3].getPatientX().getmeFST().equals("e")){
                          CovidBooth[3].setPatientX(new Patient(PName, SName, Age, City, NIC, "Sinopharm"));
                          System.out.print(PName+ " "+ SName + " has Been Added to the Booth Number 3 and will be Adminsterd the Sinopharm vaccine!\n");
                          Boothchecker=false;
                }else{
                    System.out.print("Sorry there aren't any vacant booths that can administer Sinopharm Try Another Vaccine Maybe ?\n");
                    continue;
                }
            }else if (VType.equals("3")){
                if (CovidBooth[4].getPatientX().getmeFST().equals("e")){
                    CovidBooth[4].setPatientX(new Patient(PName, SName, Age, City, NIC, "Pfizer"));
                    System.out.print(PName+ " "+ SName + " has Been Added to the Booth Number 4 and will be Adminsterd the Pfizer vaccine!\n");
                    Boothchecker=false;
                }else if (CovidBooth[5].getPatientX().getmeFST().equals("e")){
                          CovidBooth[5].setPatientX(new Patient(PName, SName, Age, City, NIC, "Pfizer"));
                          System.out.print(PName+ " "+ SName + " has Been Added to the Booth Number 5 and will be Adminsterd the Pfizer vaccine!\n");
                          Boothchecker=false;
                }else {
                    System.out.print("Sorry there aren't any vacant booths that can administer Pfizer Try Another Vaccine Maybe ?\n");
                    continue;
                }
            }else {
                System.out.print("Pls enter a Valid Vaccine Type Input");
            }
        } 
        CVStock--; // reduce stock here 
        if (CVStock % 20 == 0) {
            System.out.print("\nyour Vaccine Stock is at : " + CVStock);             // triggers every multiple of 20
        }
        if (CVStock == 20) {
            System.out.print("\nWARNING COVID Vaccine Stock Critically Low!!!\n");   // triggers when stock reaches 20
        }        
    }

    // Remove Patient from a Booth method
    public static void WipeP4rmBooth(Scanner input) {
        System.out.print("\nDisplaying all Occupied Booths: \n");  // Prints all occupied booths with their booth numbers
        for (int x = 0; x < 6; x++) {
            if (!CovidBooth[x].getPatientX().getmeFST().equals("e")) {
                System.out.println("Booth Number " + x + " is occupied by: " + CovidBooth[x].getPatientX().getmeFST()+ " " + CovidBooth[x].getPatientX().getmeSUR());
            }
        }

        Boolean Boothchecker = true;
        while (Boothchecker) {
            System.out.print("\nEnter the booth number of the patient that you wish to remove : ");
            int BoothNum = Integer.parseInt(input.nextLine());
            if (BoothNum >= CovidBooth.length) {
                System.out.print("\nThe entered Index is Out of Range!: \n");
                continue;
            } else {
                System.out.print("\nPatient " + CovidBooth[BoothNum].getPatientX().getmeFST()+ " " + CovidBooth[BoothNum].getPatientX().getmeSUR() + " Has been Removed From Booth Number " + BoothNum + "\n");
                CovidBooth[BoothNum].setPatientX(new Patient("e", "e", 0, "e", "e", "e"));
                Boothchecker = false;
            }
        }
    }

    // View Patients Sorted in alphabetical order method
    public static void Sorter() {

        String[] CloneCoronaBooth = new String[6];  // cloning Booth array as a backup to ensure no sorted change is permanant
        for (int x = 0; x < 6; x++) {
            CloneCoronaBooth[x] = CovidBooth[x].getPatientX().getmeFST() +" "+ CovidBooth[x].getPatientX().getmeSUR(); // stores names in the format "(First Name) (Surname)"
        }
        for (int x = 0; x < 5; x++) {                //Bubble sort technique
            for (int y = 0; y < 5 - x; y++) {
                if (CloneCoronaBooth[y].toLowerCase().compareTo(CloneCoronaBooth[y + 1].toLowerCase()) > 0) {

                    String Holder = CloneCoronaBooth[y];
                    CloneCoronaBooth[y] = CloneCoronaBooth[y + 1];
                    CloneCoronaBooth[y + 1] = Holder;
                }
            }
        }
        System.out.print("\nPatient Names Sorted in Alphabetical Order: \n");
        for (int x = 0; x < 6; x++) {
            if (!CloneCoronaBooth[x].equals("e e")) {
                System.out.println(CloneCoronaBooth[x]);
            }
        }

    }

    // Store Program Data into file method
    public static void StorePrgrmData() {
        try (BufferedWriter bkp = new BufferedWriter(new FileWriter("Corona.txt"))) {  // taken from here : https://www.codejava.net/java-se/file-io/how-to-read-and-write-text-file-in-java
            bkp.write(String.valueOf(CVStock)); // Stores Stock in first line
            bkp.newLine();
            for (int x = 0; x < 6; x++) {       // Stores all patient details line by line
                bkp.write(CovidBooth[x].getPatientX().getmeFST());
                bkp.newLine();
                bkp.write(CovidBooth[x].getPatientX().getmeSUR());
                bkp.newLine();
                bkp.write(String.valueOf(CovidBooth[x].getPatientX().getmePA()));
                bkp.newLine();
                bkp.write(CovidBooth[x].getPatientX().getmePee());
                bkp.newLine();
                bkp.write(CovidBooth[x].getPatientX().getmePNICPN());
                bkp.newLine();
                bkp.write(CovidBooth[x].getPatientX().getmePVacc());
                bkp.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("\nSucessfully Dumped all data to Corona.txt!\n");

    }

    // Load Program Data from file method
    public static void LoadPrgrmData() {
        try {
            Scanner Loader = new Scanner(new FileInputStream("Corona.txt")); // taken from here : https://www.codejava.net/java-se/file-io/how-to-read-and-write-text-file-in-java
            CVStock = Integer.parseInt(Loader.nextLine());
            for (int x = 0; x < 6; x++) {
                
                String PName =Loader.nextLine(); 
                String SName = Loader.nextLine(); 
                int Age = Integer.parseInt(Loader.nextLine()); 
                String City = Loader.nextLine(); 
                String NIC = Loader.nextLine(); 
                String VType = Loader.nextLine();

                CovidBooth[x].setPatientX(new Patient(PName, SName, Age, City, NIC, VType));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("\nSucessfully Loaded all data from Corona.txt!\n");
    }

    // View Remaining Vaccinations method
    public static void ViewRCV() {
        System.out.print("\nTotal Number of Covid Vaccines Left : " + CVStock);
    }

    // Add Vaccinations to the Stock
    public static void AddCVStock(Scanner input) {
        System.out.print("\nEnter Amount of Vaccines to add to stock : ");
        int CVNewStock = Integer.parseInt(input.nextLine());
        CVStock += CVNewStock;
        System.out.print("\nTotal Number of Covid Vaccines has been Updated to : " + CVStock);
    }

}