package neat.algorithm.util;

import constants.SimulationConstants;
import neat.algorithm.model.Position;

import java.util.concurrent.ThreadLocalRandom;

public class PositionUtilHelper {

  public static Position buildRandomPosition() {

    int x = ThreadLocalRandom.current().nextInt(0, SimulationConstants.MAX_X);
    int y = ThreadLocalRandom.current().nextInt(0, SimulationConstants.MAX_Y);

    // To make sure they are always generated at 10,20,30.. pixels.
    x = x - (x % SimulationConstants.SCALE_PIXELS);
    y = y - (y % SimulationConstants.SCALE_PIXELS);

    return new Position(x, y);
  }

  public static Position copy(Position position) {
    return new Position(position.getX(), position.getY());
  }

  public static boolean areEqual(Position currentPosition, Position secondPosition) {
    return currentPosition != null
        && secondPosition != null
        && currentPosition.getX() == secondPosition.getX()
        && currentPosition.getY() == secondPosition.getY();
  }
}
