package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {

    @FXML
    public TextField uName;

    @FXML
    private TextField sName;

    @FXML
    private TextField uAge;

    @FXML
    private TextField uCity;

    @FXML
    private TextField uNic;

    @FXML
    private TextField uBooth;

    @FXML
    private ComboBox comboBox;

    @FXML
    public void initialize() {
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("AstraZeneca", "Sinopharm", "Pfizer");
    }

    @FXML
    public void recit(ActionEvent actionEvent) throws Exception{
        System.out.println("========================== Receipt ==========================");
        String printerFN = uName.getText();
        System.out.println("First Name             : " + printerFN);

        String printerSN = sName.getText();
        System.out.println("Surname                : " + printerSN);

        String printerA = uAge.getText();
        System.out.println("Age                    : " + printerA);

        String printerC = uCity.getText();
        System.out.println("City                   : " + printerC);

        String printerNi = uNic.getText();
        System.out.println("Nic/passport Number    : " + printerNi);

        String printerB = uBooth.getText();
        System.out.println("Booth                  : " + printerB);

        Object printerCB = comboBox.getSelectionModel().getSelectedItem();
        System.out.println("Vaccine type           : " + printerCB);


        String timeStamp = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").format(new Date());
        System.out.println("\nReceipt created at     : "+ timeStamp);


        System.out.println("=============================================================");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Receipt.txt", false))) {
            bw.write("========================== Receipt ==========================");
            bw.newLine();
            bw.write("First Name             : " + printerFN);
            bw.newLine();
            bw.write("Surname                : " + printerSN);
            bw.newLine();
            bw.write("Age                    : " + printerA);
            bw.newLine();
            bw.write("City                   : " + printerC);
            bw.newLine();
            bw.write("Nic/passport Number    : " + printerNi);
            bw.newLine();
            bw.write("Booth                  : " + printerB);
            bw.newLine();
            bw.write("Vaccine type           : " + comboBox.getSelectionModel().getSelectedItem());
            bw.newLine();
            bw.write("\nReceipt created at     : "+ timeStamp);
            bw.newLine();
            bw.write("=============================================================");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();

        }

        if(printerFN.equalsIgnoreCase("Zikra") || printerFN.equalsIgnoreCase("Kizura")){
            Stage newStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("eegg.fxml"));
            newStage.setScene(new Scene(root,850,850));
            newStage.show();
            newStage.setTitle("Hey You Found KizuraSG's Latest Artwork in First Hidden Easter Egg Location!");
        }else{
            Stage newStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("receipt.fxml"));
            newStage.setScene(new Scene(root,928,662));
            newStage.show();
            newStage.setTitle("Receipt");

            Label field1 = (Label) root.lookup("#FName");
            field1.setText(printerFN);

            Label field2 = (Label) root.lookup("#SName");
            field2.setText(printerSN);

            Label field3 = (Label) root.lookup("#Age");
            field3.setText(printerA);

            Label field4 = (Label) root.lookup("#City");
            field4.setText(printerC);

            Label field5 = (Label) root.lookup("#NIC");
            field5.setText(printerNi);

            Label field6 = (Label) root.lookup("#Booth");
            field6.setText(printerB);

            Label field7 = (Label) root.lookup("#VacType");
            field7.setText(""+comboBox.getSelectionModel().getSelectedItem());

            Label field8 = (Label) root.lookup("#DT");
            field8.setText(timeStamp);
        }

    }

}