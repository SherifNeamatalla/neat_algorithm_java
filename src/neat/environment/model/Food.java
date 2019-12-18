package neat.environment.model;

import neat.algorithm.model.Position;
import neat.algorithm.util.PositionUtilHelper;

public class Food {

  private Position position;

  public Food() {
    this.position = PositionUtilHelper.buildRandomPosition();
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }
}
