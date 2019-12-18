package neat.algorithm.model;

import neat.algorithm.util.ChromosomeGenerator;
import neat.algorithm.util.PositionUtilHelper;
import constants.AlgorithmConstants;
import neat.environment.model.CreatureAction;

public class Creature {

  private Chromosome chromosome;

  private Position position;

  private double energy = AlgorithmConstants.MAX_ENERGY;

  public Creature() {
    this.chromosome = ChromosomeGenerator.buildRandomChromosome();
    this.position = PositionUtilHelper.buildRandomPosition();
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

  public void tick(CreatureAction action) {
    // do magic shit
  }
}
