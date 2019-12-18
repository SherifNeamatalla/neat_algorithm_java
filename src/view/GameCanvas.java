package view;

import javafx.scene.canvas.Canvas;
import simulation.model.Simulation;

public class GameCanvas extends Canvas {
  public GameCanvas(double width, double height) {
    super(width, height);
  }

  public void draw(Simulation simulation) {}
}
