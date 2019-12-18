package neat.algorithm.model;

import constants.AlgorithmConstants;
import neat.algorithm.util.ChromosomeGenerator;
import neat.algorithm.util.PositionUtilHelper;
import neat.environment.model.CreatureAction;

public class Creature {

  private Chromosome chromosome;

  private Position position;

  private double energy = AlgorithmConstants.MAX_ENERGY;

  private int foodCount = 0;

  public Creature() {
    this.chromosome = ChromosomeGenerator.buildRandomChromosome();
    this.position = PositionUtilHelper.buildRandomPosition();
  }

  public void tick(CreatureAction action) {

    if (energy > 0 && action.getMovingDirection() != null) {
      switch (action.getMovingDirection()) {
        case NORTH:
          this.setPosition(
              new Position(position.getX(), position.getY() - AlgorithmConstants.CREATURE_SPEED));
          break;
        case SOUTH:
          this.setPosition(
              new Position(position.getX(), position.getY() + AlgorithmConstants.CREATURE_SPEED));
          break;
        case EAST:
          this.setPosition(
              new Position(position.getX() + AlgorithmConstants.CREATURE_SPEED, position.getY()));
          break;
        case WEST:
          this.setPosition(
              new Position(position.getX() - AlgorithmConstants.CREATURE_SPEED, position.getY()));
          break;
      }
      energy -= AlgorithmConstants.CREATURE_ENERGY_DECAY;
    }
  }

  public Chromosome getChromosome() {
    return chromosome;
  }

  public void setChromosome(Chromosome chromosome) {
    this.chromosome = chromosome;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public int getFoodCount() {
    return foodCount;
  }

  public void setFoodCount(int foodCount) {
    this.foodCount = foodCount;
  }

  public double getEnergy() {
    return energy;
  }

  public void setEnergy(double energy) {
    this.energy = energy;
  }

  public void reward() {
    this.energy += AlgorithmConstants.CREATURE_FOOD_REWARD;
  }
}
