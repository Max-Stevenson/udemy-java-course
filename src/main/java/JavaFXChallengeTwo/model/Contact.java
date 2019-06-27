package JavaFXChallengeTwo.model;

import javafx.beans.property.SimpleStringProperty;

public class Contact {
    private final SimpleStringProperty firstName = new SimpleStringProperty("");
    private final SimpleStringProperty lastName = new SimpleStringProperty("");
    private final SimpleStringProperty phoneNumber = new SimpleStringProperty("");
    private final SimpleStringProperty notes = new SimpleStringProperty("");

    public Contact() {

    }

    public Contact(String firstName, String lastName, String phoneNumber, String notes) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setNotes(notes);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String fName) {
        firstName.set(fName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String fName) {
        lastName.set(fName);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String fName) {
        phoneNumber.set(fName);
    }

    public String getNotes() {
        return notes.get();
    }

    public void setNotes(String fName) {
        notes.set(fName);
    }
}
