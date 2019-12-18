package neat.algorithm.util;

import neat.algorithm.model.Neuron;

import java.util.List;
import java.util.Optional;

public class NeuronFinder {

  public static Optional<Neuron> findNeuronByID(int id, List<Neuron> neurons) {

    if (neurons == null) return Optional.empty();
    return neurons.parallelStream().filter(neuron -> neuron.getNeuronID() == id).findFirst();
  }
}
