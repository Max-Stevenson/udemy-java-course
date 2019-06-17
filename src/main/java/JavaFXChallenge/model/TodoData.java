package JavaFXChallenge.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class TodoData {
    private static TodoData instance = new TodoData();
    private static String filename = "TodoListItems.txt";

    private ObservableList<TodoItem> todoItemList;
    private DateTimeFormatter dateTimeFormatter;

    public static TodoData getInstance() {
        return instance;
    }

    private TodoData() {
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    }

    public ObservableList<TodoItem> getTodoItemList() {
        return todoItemList;
    }

    public void loadTodoItems() throws IOException {
        todoItemList = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader bufferedReader = Files.newBufferedReader(path);
        String input;

        try {
            while ((input = bufferedReader.readLine()) != null) {
                String[] itemPieces = input.split("\t");

                String shortDescription = itemPieces[0];
                String details = itemPieces[1];
                String dateString = itemPieces[2];

                LocalDate date = LocalDate.parse(dateString, dateTimeFormatter);

                TodoItem todoItem = new TodoItem(shortDescription, details, date);
                todoItemList.add(todoItem);
            }

        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }

    public void storeTodoItems() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bufferedWriter = Files.newBufferedWriter(path);
        try {
            Iterator<TodoItem> iterator = todoItemList.iterator();
            while (iterator.hasNext()) {
                TodoItem item = iterator.next();
                bufferedWriter.write(String.format("%s\t%s\t%s",
                        item.getDescription(),
                        item.getDetails(),
                        item.getDeadline()));
                bufferedWriter.newLine();
            }
        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }
    }

    public void deleteTodoItem(TodoItem item) {
        todoItemList.remove(item);
    }


    public void addTodoItem(TodoItem item) {
        todoItemList.add(item);
    }
}
