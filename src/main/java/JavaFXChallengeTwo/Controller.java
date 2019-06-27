package JavaFXChallengeTwo;

import JavaFXChallengeTwo.model.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Controller {

    @FXML
    public TableColumn<Contact, String> firstNameCol;
    @FXML
    private TableView<Contact> tableView;

    private ObservableList<Contact> data;

    public void initialize() {
        data = FXCollections.observableArrayList(
                new Contact("Max", "Stevenson", "07738623761", "A note")
        );
    }
}
