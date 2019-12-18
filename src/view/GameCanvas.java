package view;

import constants.AlgorithmConstants;
import constants.SimulationConstants;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import neat.algorithm.model.Creature;
import neat.environment.model.Food;
import simulation.model.Simulation;

import java.util.List;

public class GameCanvas extends Canvas {
  public GameCanvas(double width, double height) {
    super(width, height);
  }

  public void draw(Simulation simulation) {

    List<Creature> creatures = simulation.getCreatures();
    List<Food> food = simulation.getFoods();
    GraphicsContext gc = this.getGraphicsContext2D();

    gc.clearRect(0, 0, this.getWidth(), this.getHeight());
    this.getGraphicsContext2D().setFill(Color.GREEN);
    this.getGraphicsContext2D().fillRect(0, 0, this.getWidth(), this.getHeight());

    if (creatures != null)
      for (Creature creature : creatures) {
        this.drawCreature(creature);
      }
    if (food != null)
      for (Food foodItem : food) {
        this.drawFood(foodItem);
      }
  }

  public void drawCreature(Creature creature) {
    GraphicsContext gc = this.getGraphicsContext2D();

    gc.setFill(Color.BLACK);
    if (creature.getEnergy() <= 0) gc.setFill(Color.RED);
    else if (creature.getEnergy() < AlgorithmConstants.MAX_ENERGY / 10) gc.setFill(Color.ORANGE);
    else if (creature.getFoodCount() > 0
        && creature.getEnergy() > AlgorithmConstants.MAX_ENERGY / 2) gc.setFill(Color.SILVER);
    else if (creature.getFoodCount() > 0) gc.setFill(Color.BLUE);
    gc.fillOval(
        creature.getPosition().getX(),
        creature.getPosition().getY(),
        SimulationConstants.CREATURE_RADIUS,
        SimulationConstants.CREATURE_RADIUS);

    gc.setFill(Color.AQUA);
    gc.fillText(
        String.valueOf(creature.getEnergy()),
        creature.getPosition().getX(),
        creature.getPosition().getY() + 40);
  }

  public void drawFood(Food food) {
    GraphicsContext gc = this.getGraphicsContext2D();

    gc.setFill(Color.YELLOW);

    gc.fillOval(food.getPosition().getX(), food.getPosition().getY(), 10, 10);
  }

  public void generateFood() {}
}
