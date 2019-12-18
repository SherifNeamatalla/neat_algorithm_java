package neat.algorithm.util;

import neat.environment.model.CreatureAction;
import neat.environment.model.MovingDirection;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CreatureActionTranslator {

  public static CreatureAction translateAction(List<Double> actionDoubleMap) {

    int random = ThreadLocalRandom.current().nextInt(0, 4);
    switch (random) {
      case 0:
        return new CreatureAction(MovingDirection.NORTH);
      case 1:
        return new CreatureAction(MovingDirection.SOUTH);
      case 2:
        return new CreatureAction(MovingDirection.EAST);
      default:
        return new CreatureAction(MovingDirection.WEST);
    }
  }
}
