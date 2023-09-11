package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.exceptions.MyException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class HomeController {
    @FXML
    public void initialize(){
    }
    private void openDialog(String title, String file){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
            //loader.setController(controller);
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setTitle(title);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        }catch (Exception e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }
    public void openTags(ActionEvent actionEvent) {
        openDialog("Tags","/fxml/tag.fxml");
    }

    public void openUsers(ActionEvent actionEvent) {
        openDialog("Users","/fxml/user.fxml");
    }
}
