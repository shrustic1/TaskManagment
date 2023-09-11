package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.TagManager;
import ba.unsa.etf.rpr.domain.Tag;
import ba.unsa.etf.rpr.exceptions.MyException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.List;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class TagController {
    public ListView<Tag> tagsList;
    public TextField tagName;
    private final TagManager manager = new TagManager();

    @FXML
    public void initialize(){
        try {
            refreshTags();
            tagsList.getSelectionModel().selectedItemProperty().addListener((obs, o, n)->{
                if (n != null){
                    tagName.setText(n.getName());
                }
            });
        } catch (MyException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }
    private void openDialog(String title, String file, Object controller){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
            loader.setController(controller);
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setTitle(title);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        }catch (Exception e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }
    public void addTag(ActionEvent event){
        try {
            Tag tag = new Tag();
            tag.setName(tagName.getText());
            tag = manager.add(tag);
            tagsList.getItems().add(tag);
            tagName.setText("");
            refreshTags();
        }catch (MyException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
        }
    }

    public void updateTag(ActionEvent event){
        try {
            Tag tag = tagsList.getSelectionModel().getSelectedItem();
            tag.setName(tagName.getText());
            tag = manager.update(tag);
            refreshTags();
        }catch (MyException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
        }
    }


}
