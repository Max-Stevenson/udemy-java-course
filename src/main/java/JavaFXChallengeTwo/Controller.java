package JavaFXChallengeTwo;

import JavaFXChallengeTwo.model.Contact;
import JavaFXChallengeTwo.model.ContactData;
import com.sun.tools.javac.util.List;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class Controller {

    @FXML
    private BorderPane mainPanel;

    @FXML
    private TableView<Contact> tableView;

    private ContactData contactData;

    public void initialize() {
        contactData = new ContactData();
        contactData.loadContacts();
        // This is responsible for populating table with data.
//        tableView.setItems(contactData.getContacts());
        tableView.setItems(FXCollections.observableList(new ArrayList<>(
                List.of(new Contact("Max", "stevenson", "1234", "text")))));
    }

    @FXML
    public void showAddContactDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPanel.getScene().getWindow());
        dialog.setTitle("Add New Contact");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/JavaFXChallengeTwo/fxml/contactDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(loader.load());
        } catch (IOException e) {
            System.out.println("Could not load dialog");
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController dialogController = loader.getController();
            Contact newContact =  dialogController.getNewContact();
            contactData.addContact(newContact);
            contactData.saveContacts();
        }
    }
}
