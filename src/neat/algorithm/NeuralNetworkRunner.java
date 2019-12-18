package neat.algorithm;

import neat.algorithm.managers.NeuralNetworkManager;
import neat.algorithm.model.Chromosome;
import neat.algorithm.model.Creature;
import neat.algorithm.util.CreatureActionTranslator;
import neat.environment.EnvironmentRunner;
import neat.environment.model.CreatureAction;
import neat.environment.model.Food;

import java.util.List;

public class NeuralNetworkRunner {

  public static void runGenerationSimulation(List<Creature> creatures, List<Food> foods) {

    EnvironmentRunner environmentRunner = new EnvironmentRunner();

    for (Creature creature : creatures) {

      Chromosome chromosome = creature.getChromosome();

      List<Double> chromosomeInput =
          environmentRunner.getChromosomeInput(creature, foods, creatures);

      List<Double> outputs = NeuralNetworkManager.runNetwork(chromosome, chromosomeInput);

      CreatureAction creatureAction = CreatureActionTranslator.translateAction(outputs);

      environmentRunner.creatureTick(creature, creatureAction, foods);
    }
  }
}
