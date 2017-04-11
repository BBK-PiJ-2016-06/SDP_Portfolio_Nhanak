import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TodoList extends Application {

  private ObservableList<String> todos;

  //Create UI Controls
  @Override public void start(Stage stage) {
    ObservableList<String> todos =
                FXCollections.observableArrayList();
    ListView<String> listView = new ListView<String>(todos);
    Button addButton = new Button();
    addButton.setText("Add");
    TextField inputField = new TextField();

    addButton.setOnAction(e -> {
      todos.add(inputField.getText());
      inputField.setText("");
      inputField.requestFocus();
    });

    //prevents empty string from being entered. Note the use of Propety here.
    addButton.disableProperty().bind(Bindings.isEmpty(inputField.textProperty()));

    //HBox = the bottom of the box.
    HBox entryBox = new HBox();
    entryBox.getChildren().addAll(inputField, addButton);
    //VBox = the body of the list
    VBox vbox = new VBox();
    vbox.getChildren().addAll(listView, entryBox);

    //Set the scene and the stage.
    Scene scene = new Scene(vbox);
    stage.setScene(scene);
    stage.setTitle("Nate's MF'n TO DO LIST");
    stage.show();
  }

  //like a Matroshka doll   (textfield, button) -> Hbox -> (ListView, Hbox) -> Vbox -> Scene - Stage

}







