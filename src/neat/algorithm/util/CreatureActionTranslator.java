package neat.algorithm.util;

import constants.AlgorithmConstants;
import neat.environment.model.CreatureAction;
import neat.environment.model.MovingDirection;

import java.util.List;

public class CreatureActionTranslator {

  public static CreatureAction translateAction(List<Double> actionDoubleMap) {

    if (actionDoubleMap.size() != AlgorithmConstants.OUTPUT_SHAPE)
      throw new IllegalArgumentException("Wrong Output Shape!");

    double movingDirection = actionDoubleMap.get(0);

    if (movingDirection <= 0.2) {
      return new CreatureAction(null);

    } else if (movingDirection <= 0.4) {
      return new CreatureAction(MovingDirection.NORTH);

    } else if (movingDirection <= 0.6) {
      return new CreatureAction(MovingDirection.SOUTH);

    } else if (movingDirection <= 0.8) {
      return new CreatureAction(MovingDirection.EAST);

    } else {
      return new CreatureAction(MovingDirection.WEST);
    }
  }
}
