import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by keithmannock on 3/20/17.
 */
public class HelloJfx extends Application {
  @Override
  public void start(Stage stage) {
    Label message = new Label("Daisy");
    message.setFont(new Font(400));
    stage.setScene(new Scene(message));
    stage.setTitle("Hello, Dave");
    stage.show();
  }
}