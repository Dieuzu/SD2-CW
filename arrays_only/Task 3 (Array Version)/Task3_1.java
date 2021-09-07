import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Task3_1 {
    public static String[] CovidBooth = new String[6];   //Array that holds full Names (first and 2nd ) of patients in all 6 booths
    public static String[] PatientFName = new String[6]; //Array that holds FIRST Names of patients in all 6 booths
    public static String[] PatientSName = new String[6]; //Array that holds Surnames of patients in all 6 booths
    public static String[] VaccineType = new String[6];  // Array that holds the vaccine type adminsterd in all 6 booths
    public static int boothNum = 0;
    public static int CVStock = 150;                     // Variable to hold Vaccination Stock

    public static void main(String[] args) {

        for (int x = 0; x < 6; x++) { //initializing the primitive arrays with all empty values
            CovidBooth[x] = "e";
            PatientFName[x] = "e";
            PatientSName[x] = "e";
            VaccineType[x] = "e";
        }

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
                ViewVBooth();
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
    public static void ViewVBooth() {
        System.out.print("\nDisplaying all Vaccination Booths: \n");
        for (int x = 0; x < 6; x++) {
            if (CovidBooth[x].equals("e")) {
                System.out.println("Booth Number " + x + " is Free\n");
            } else {
                System.out.println("Booth Number " + x + " is occupied by: " + CovidBooth[x]);
                System.out.println("          | Vaccination type : " + VaccineType[x] + "\n");
            }
        }
    }

    // View all Empty Booths method
    public static void ViewEBooth() {
        System.out.print("\nDisplaying all Empty Booths: \n");
        for (int x = 0; x < 6; x++) {
            if (CovidBooth[x].equals("e"))
                System.out.println("Booth Number " + x + " is Free");
        }
    }

    // Add Patient to a Booth method
    public static void AddP2Booth(Scanner input) {
        int OccupiCount = 0; //Variable to count how many booths are fully occupied
        for (int x = 0; x < 6; x++) {
            
            if (!CovidBooth[x].equals("e")){
                OccupiCount +=1;
            }    
        }
        if (OccupiCount==6){ //condition to say unable to add patients if all 6 booths occupied
            System.out.print("\nWARNING!: unable to add more patients!\nSeems Like all Booths are Full! Try again later when a Booth is Free");
            return;
        }
    
        System.out.print("\nEnter patient First Name : ");
        String PName = input.nextLine();
    
        System.out.print("\nEnter patient Surname: ");
        String SName = input.nextLine();
        
        Boolean VaccineChecker = true;
        while(VaccineChecker){ //while loop to get vaccine type and auto assign a booth accordingly
            System.out.print("\n==================== Vaccine type ====================");
            System.out.print("\nEnter 1 for : AstraZeneca");
            System.out.print("\nEnter 2 for : Sinopharm");
            System.out.print("\nEnter 3 For : Pfizer");
            System.out.print("\n======================================================\n");
    
            System.out.print("\nEnter your Input : ");
            String UserVaccine = input.nextLine();
    
            if (UserVaccine.equals("1")) {

                if (CovidBooth[0].equals("e")){
                    System.out.print("\nYou have Requested for AstraZeneca!\n");
                    VaccineType[0] = "AstraZeneca";
                    CovidBooth[0] = PName + " " + SName;
                    PatientFName[0] = PName;
                    PatientSName[0] = SName;
                    System.out.print(PName+ " "+ SName + " has Been Added to the Booth Number 0 and will be Adminsterd the AstraZeneca vaccine!\n");
                }
                else if(CovidBooth[1].equals("e")){

                    System.out.print("\nYou have Requested for AstraZeneca!\n");
                    VaccineType[1] = "AstraZeneca";
                    CovidBooth[1] = PName + " " + SName;
                    PatientFName[1] = PName;
                    PatientSName[1] = SName;
                    System.out.print(PName+ " "+ SName + " has Been Added to the Booth Number 1 and will be Adminsterd the AstraZeneca vaccine!\n");
                }else {
                    System.out.print("Sorry there aren't any vacant booths that can administer AstraZeneca\n");
                    continue;
                }
                VaccineChecker = false;
            } else if (UserVaccine.equals("2")) {
                if (CovidBooth[2].equals("e")){
                    System.out.print("\nYou have Requested for Sinopharm! \n");
                    VaccineType[2] = "Sinopharm";
                    CovidBooth[2] = PName + " " + SName;
                    PatientFName[2] = PName;
                    PatientSName[2] = SName;
                    System.out.print(PName+ " "+ SName + " has Been Added to the Booth Number 2 and will be Adminsterd the Sinopharm vaccine!\n");
                }
                else if(CovidBooth[3].equals("e")){
                    System.out.print("\nYou have Requested for Sinopharm! \n");
                    VaccineType[3] = "Sinopharm";
                    CovidBooth[3] = PName + " " + SName;
                    PatientFName[3] = PName;
                    PatientSName[3] = SName;
                    System.out.print(PName+ " "+ SName + " has Been Added to the Booth Number 3 and will be Adminsterd the Sinopharm vaccine!\n");
                }else {
                    System.out.print("Sorry there aren't any vacant booths that can administer Sinopharm\n");
                    continue;
                }
                VaccineChecker = false;
            } else if (UserVaccine.equals("3")) {
                if (CovidBooth[4].equals("e")){
                    System.out.print("\nYou have Requested for Pfizer! \n");
                    VaccineType[4] = "Pfizer";
                    CovidBooth[4] = PName + " " + SName;
                    PatientFName[4] = PName;
                    PatientSName[4] = SName;
                    System.out.print(PName+ " "+ SName + " has Been Added to the Booth Number 4 and will be Adminsterd the Pfizer vaccine!\n");
                }
                else if(CovidBooth[5].equals("e")){
                    System.out.print("\nYou have Requested for Pfizer! \n");
                    VaccineType[5] = "Pfizer";
                    CovidBooth[5] = PName + " " + SName;
                    PatientFName[5] = PName;
                    PatientSName[5] = SName;
                    System.out.print(PName+ " "+ SName + " has Been Added to the Booth Number 5 and will be Adminsterd the Pfizer vaccine!\n");
                }else {
                    System.out.print("Sorry there aren't any vacant booths that can administer Pfizer\n");
                    continue;
                }
                VaccineChecker = false;
            } else {
                System.out.print("\nThe entered input is Invalid! try again\n");
            }
        }
        CVStock--;
        if (CVStock%20==0){
            System.out.print("\nyour Vaccine Stock is at : " + CVStock);            // triggers every multiple of 20
        }
        if (CVStock==20){
            System.out.print("\nWARNING COVID Vaccine Stock Critically Low!!!\n");  // triggers when stock reaches 20
        }
    
    }

    // Remove Patient from a Booth method
    public static void WipeP4rmBooth(Scanner input) {
        System.out.print("\nDisplaying all Occupied Booths: \n");   // Prints all occupied booths with their booth numbers
        for (int x = 0; x < 6; x++) {
            if (!CovidBooth[x].equals("e")) {
                System.out.println("Booth Number " + x + " is occupied by: " + CovidBooth[x]);
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
                System.out.print(
                        "\nPatient " + CovidBooth[BoothNum] + " Has been Removed From Booth Number " + BoothNum + "\n");
                CovidBooth[BoothNum] = "e";
                PatientFName[BoothNum] = "e";
                PatientSName[BoothNum] = "e";
                VaccineType[BoothNum] = "e";
                Boothchecker = false;
            }
        }
    }

    // View Patients Sorted in alphabetical order method
    public static void Sorter() {

        String[] CloneCoronaBooth = new String[6];     // cloning Booth array as a backup to ensure no sorted change is permanant
        for (int x = 0; x < 6; x++) {
            CloneCoronaBooth[x] = CovidBooth[x];

        }
        for (int x = 0; x < 5; x++) {               //Bubble sort technique
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
            if (!CloneCoronaBooth[x].equals("e")) {
                System.out.println(CloneCoronaBooth[x]);
            }
        }

    }

    // Store Program Data into file method
    public static void StorePrgrmData() {
        try (BufferedWriter bkp = new BufferedWriter(new FileWriter("Corona.txt"))) { // taken from here : https://www.codejava.net/java-se/file-io/how-to-read-and-write-text-file-in-java
            bkp.write(String.valueOf(CVStock));    // Stores Stock in first line
            bkp.newLine();
            for (int x = 0; x < 6; x++) {
                bkp.write(CovidBooth[x]);
                bkp.newLine();
                bkp.write(PatientFName[x]);
                bkp.newLine();
                bkp.write(PatientSName[x]);
                bkp.newLine();
                bkp.write(VaccineType[x]);
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
                CovidBooth[x] = Loader.nextLine();
                PatientFName[x] = Loader.nextLine();
                PatientSName[x] = Loader.nextLine();
                VaccineType[x] = Loader.nextLine();
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