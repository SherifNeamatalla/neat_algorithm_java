package neat.environment;

import constants.SimulationConstants;
import neat.algorithm.model.Creature;
import neat.algorithm.model.Position;
import neat.algorithm.util.DistanceHelper;
import neat.environment.model.CreatureAction;
import neat.environment.model.Food;

import java.util.ArrayList;
import java.util.List;

public class EnvironmentRunner {

  public List<Double> getChromosomeInput(
      Creature creature, List<Food> foods, List<Creature> creatures) {

    List<Double> result = new ArrayList<>();

    double minDistance = Integer.MAX_VALUE;
    Position minPosition = null;

    for (Food food : foods) {

      var distance = DistanceHelper.getDistance(food.getPosition(), creature.getPosition());

      if (distance <= minDistance) {
        minDistance = distance;
        minPosition = food.getPosition();
      }
    }

    if (minPosition != null) {
      double xDirection = Double.compare(minPosition.getX(), creature.getPosition().getX());
      double yDirection = Double.compare(minPosition.getY(), creature.getPosition().getY());

      result.add(xDirection);
      result.add(yDirection);
    }

    return result;
  }

  public void creatureTick(Creature creature, CreatureAction action, List<Food> foods) {

    // some magic shit
    creature.tick(action);

    Food ateFood = null;
    for (Food food : foods) {
      if (Math.abs(food.getPosition().getX() - creature.getPosition().getX())
              <= SimulationConstants.CREATURE_RADIUS
          && Math.abs(food.getPosition().getY() - creature.getPosition().getY())
              <= SimulationConstants.CREATURE_RADIUS) {

        creature.reward();
        ateFood = food;
        break;
      }
    }

    if (ateFood != null) foods.remove(ateFood);
  }
}
