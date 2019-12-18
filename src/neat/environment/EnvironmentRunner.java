package neat.environment;

import neat.algorithm.model.Creature;
import neat.environment.model.CreatureAction;

import java.util.ArrayList;
import java.util.List;

public class EnvironmentRunner {

  public List<Double> getChromosomeInput(Creature creature) {
    return new ArrayList<>();
  }

  public void creatureTick(Creature creature, CreatureAction action) {

    // some magic shit
    creature.tick(action);
  }
}
