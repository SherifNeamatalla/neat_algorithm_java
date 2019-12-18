package neat;

import neat.algorithm.NeuralNetworkRunner;
import neat.algorithm.model.Creature;
import neat.environment.model.Food;

import java.util.List;

public class NeatRunner {

  public void run(List<Creature> creatures, List<Food> foods) {

    NeuralNetworkRunner.runGenerationSimulation(creatures);
  }

  public void nextGeneration() {}
}
