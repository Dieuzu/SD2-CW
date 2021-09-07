package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ReceiptControl {

    @FXML
    private Label FName;

    @FXML
    private Label SName;

    @FXML
    private Label Age;

    @FXML
    private Label City;

    @FXML
    private Label NIC;

    @FXML
    private Label Booth;

    @FXML
    private Label VacType;

    @FXML
    private Label DT;

    @FXML
    void Easteregg(ActionEvent actionEvent) throws Exception{
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("eegg.fxml"));
        newStage.setScene(new Scene(root,850,850));
        newStage.show();
        newStage.setTitle("Hey You Found KizuraSG's Latest Artwork in Second Hidden Easter Egg Location!");

    }

}