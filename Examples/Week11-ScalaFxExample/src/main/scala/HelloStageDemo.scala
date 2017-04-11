import javafx.scene.image.ImageView

import scalafx.Includes._
import scalafx.application.JFXApp

import scalafx.scene.Scene
import scalafx.scene.image.Image
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle

object HelloStageDemo extends JFXApp {

  stage = new JFXApp.PrimaryStage {
    title.value = "Hello Stage"
    width = 600
    height = 450
    scene = new Scene {

        val img = new Image("javert.jpeg");
        val view = new ImageView(img);
/*
        root.setStyle("-fx-background-image: url('" + view+ "'); " +
        "-fx-background-position: center center; " +
        "-fx-background-repeat: stretch;");
*/
        content = {
          new Rectangle {
            x = 25
            y = 40
            width = 100
            height = 100
            fill <== when(hover) choose Green otherwise Red
          }
        }

    }
  }
}