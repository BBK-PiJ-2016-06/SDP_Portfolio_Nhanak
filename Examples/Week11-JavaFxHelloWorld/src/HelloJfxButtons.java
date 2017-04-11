import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloJfxButtons extends Application {

  private int count = 0;

  @Override
  public void start(Stage stage) {

    // create UI controls. Represents the object
    Label counterLabel = new Label("Starting...");
    Button incButton = new Button("Increment Count");
    //fires off the events.
    incButton.setOnAction(event -> counterLabel.setText("Count: "
            + (count++)));

    /* More verbose way of doing it - shows what's happening more directly

    incButton.setOnAction( new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        counterLabel.setText("Count: " + (++count));
      }
    });

    */

    //Add UI controls to a parent node (Group, Region, or Pane)
    //This subscribes the scene to the event. Scene takes a root which takes the event "firers"
    VBox root = new VBox();
    root.getChildren().addAll(counterLabel, incButton);
    Scene scene = new Scene(root);

    //Set the stage with the scene graph and show it
    stage.setScene(scene); // also holds as a listener in a sense.
    stage.setTitle("Hello");
    stage.show();

  }

}