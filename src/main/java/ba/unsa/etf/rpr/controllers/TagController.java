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


}
