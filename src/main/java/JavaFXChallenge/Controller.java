package JavaFXChallenge;

import JavaFXChallenge.model.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private Label deadlineLabel;
    @FXML
    private TextArea todoItemDetails;
    @FXML
    private ListView<TodoItem> todoListView;

    private List<TodoItem> todoItems;

    public void initialize() {
        TodoItem item1 = new TodoItem("Birthday Card",
                "Buy a 40th birthday card for your friend",
                LocalDate.of(2019, 9, 14));
        TodoItem item2 = new TodoItem("Doctor Appointment",
                "Checkup appointment, blood tests",
                LocalDate.of(2019, 6, 12));
        TodoItem item3 = new TodoItem("Finish design prototype",
                "Email mockups to boss",
                LocalDate.of(2019, 12, 6));
        TodoItem item4 = new TodoItem("Birthday Meal",
                "Birthday meal with family",
                LocalDate.of(2019, 6, 8));
        TodoItem item5 = new TodoItem("Stock up on food",
                "Get ready for the apocalypse",
                LocalDate.of(2019, 6, 1));

        todoItems = new ArrayList<>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
                if (newValue != null) {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    todoItemDetails.setText(item.getDetails());
                    deadlineLabel.setText(item.getDeadline().toString());
                }
            }
        });

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }
}
