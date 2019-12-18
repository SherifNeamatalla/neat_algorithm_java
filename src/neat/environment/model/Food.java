package neat.environment.model;

import neat.algorithm.model.Position;

public class Food {

  private Position position;

  public Food(Position position) {
    this.position = position;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }
}
