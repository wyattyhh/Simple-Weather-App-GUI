package weatherapp;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {
    @FXML
    private ImageView imgView;

    @FXML
    private ToggleButton tgBtn0, tgBtn1, tgBtn2, tgBtn3, tgBtn4, tgBtn5, tgBtn6, tgBtn7, tgBtn8, tgBtn9, tgBtn10, tgBtn11, tgBtn12, tgBtn13, tgBtn14, tgBtn15, tgBtn16, tgBtn17, tgBtn18, tgBtn19, tgBtn20, tgBtn21, tgBtn22, tgBtn23, tgBtn24, tgBtn25, tgBtn26, tgBtn27, tgBtn28, tgBtn29, tgBtn30, tgBtn31, tgBtn32, tgBtn33, tgBtn34, tgBtn35, tgBtn36;

    @FXML
    ToggleGroup group;

    @FXML
    AnchorPane rootPane;

    @FXML
    Label labelTxt;

    @FXML
    private Button gen_report;

    @FXML
    private void loadScene1(ActionEvent event){
        ToggleButton selectedTgBtn = (ToggleButton) group.getSelectedToggle(); // get a selected toggle button from toggle group
        String csvPath = "weather_data/" + selectedTgBtn.getText() + ".csv"; //get locations of related csv file
        ReadData data = new ReadData(); //call method
        ObservableList<ModelTable> list = data.readCSV(csvPath); //generate a list through readCSV method
        group.selectedToggleProperty().addListener((obsVal, oldVal, newVal) -> {
            if (newVal == null)
                oldVal.setSelected(true); //prevent throwing exceptions while click on same button
        });
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene1.fxml")); //load scene1
        try {
            Parent root = loader.load();
            rootPane.getChildren().addAll(root); //switch rootPane to scene1
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene1Controller controller = loader.getController(); //access scene1 controller
        controller.setLable(selectedTgBtn.getText());
        controller.setTableView(list); //update tableview
    }

    @FXML
    private void genReport(ActionEvent event) throws IOException { //action event to create txt file
        txtingData txting = new txtingData(); //call txtingData class
        txting.writeTXT(); //call method writeTXT
        labelTxt.setText("Report is generated."); //setText when button clicked
        labelTxt.setVisible(true); //set label visible when button clicked
        labelTxt.setAlignment(Pos.CENTER);
    }

    @FXML
    private void initialize(){
        Image image1 = new Image("weatherapp/cloud.png");
        imgView.setImage(image1);
    }

}
