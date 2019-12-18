package neat.environment.model;

public class CreatureAction {

  private MovingDirection movingDirection;

  public CreatureAction(MovingDirection movingDirection) {
    this.movingDirection = movingDirection;
  }

  public MovingDirection getMovingDirection() {
    return movingDirection;
  }

  public void setMovingDirection(MovingDirection movingDirection) {
    this.movingDirection = movingDirection;
  }
}
