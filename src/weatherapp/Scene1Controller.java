package weatherapp;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1Controller {
    @FXML
    TableView<ModelTable> tableView;

    @FXML
    TableColumn<ModelTable, String> year, tMax, tMin, airFo, rainFl;

    @FXML
    private Label stationName;

    @FXML
    private Button backBtn, hisBtn;

    @FXML
    AnchorPane childPane;

    public void setTableView(ObservableList<ModelTable> list){
        year.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("year"));
        tMax.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("tmax"));
        tMin.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("tmin"));
        airFo.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("airfo"));
        rainFl.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("rainfl"));
        tableView.setItems(list); //set table view value
    }

    public void setLable(String name){
        String text = name + " weather in 2019";
        stationName.setText(text); //set clicked button text on heading label
    }

    @FXML
    private void loadScene2(ActionEvent event){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml")); //load scene2.fxml
        try {
            Parent root = loader.load();
            Scene2Controller controller = loader.getController();
            Scene scene2 = new Scene(root);
            Stage window = new Stage();
            window.setScene(scene2);
            window.show(); //pop up detailed window
            Button btn_tmp = controller.backBtn;
            btn_tmp.setOnAction(e -> window.close()); //set backing action to button
            String title = stationName.getText();
            String name = title.substring(0,title.length() - 16); //get station name of the heading label
            ReadData.getAllMin(name); //update 4 section of values related to the selected station
            if (ReadData.allRain.size() > 0){ //avoid empty CSVs
                controller.setMinCharts(ReadData.allMin); //set charts
                controller.setMaxCharts(ReadData.allMax); //set charts
                controller.setAfCharts(ReadData.allAf); //set charts
                controller.setRainCharts(ReadData.allRain); //set charts
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void backToHomepage(ActionEvent event){ //simply go back to homepage
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainscene.fxml")); //load scene1
        try {
            Parent root = loader.load();
            MainController controller = loader.getController();
            AnchorPane pane = controller.rootPane;
            pane.setLayoutX(0);
            childPane.getChildren().setAll(pane);//switch childPane to rootPane
            controller.labelTxt.setVisible(true);
            controller.labelTxt.setAlignment(Pos.CENTER);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
