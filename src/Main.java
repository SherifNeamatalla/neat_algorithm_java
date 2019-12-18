import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import simulation.Simulator;
import view.MainView;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    MainView mainView = new MainView();
    new Simulator(mainView);

    Rectangle2D bounds = Screen.getPrimary().getVisualBounds();

    primaryStage.setX(bounds.getMinX());
    primaryStage.setY(bounds.getMinY());
    primaryStage.setWidth(bounds.getWidth());
    primaryStage.setHeight(bounds.getHeight());

    primaryStage.setTitle("Genetic Evolution");
    primaryStage.setScene(new Scene(mainView, 300, 275));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
