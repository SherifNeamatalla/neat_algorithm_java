package neat.algorithm.util;

import constants.AlgorithmConstants;
import neat.algorithm.activationfunctions.SigmoidActivationFunction;
import neat.algorithm.model.Chromosome;
import neat.algorithm.model.Neuron;
import neat.algorithm.model.NeuronConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ChromosomeGenerator {

  public static Chromosome buildRandomChromosome() {

    List<Neuron> inputNeurons = generateRandomInputLayer();
    List<Neuron> outputNeurons = generateRandomOutputLayer();

    List<Neuron> neurons = generateRandomHiddenLayer();

    List<NeuronConnection> neuronConnections =
        generateRandomNeuronConnections(inputNeurons, outputNeurons, neurons);

    return new Chromosome(inputNeurons, outputNeurons, neurons, neuronConnections, 1);
  }

  private static List<NeuronConnection> generateRandomNeuronConnections(
      List<Neuron> inputNeurons, List<Neuron> outputNeurons, List<Neuron> neurons) {

    List<NeuronConnection> result = new ArrayList<>();

    result.addAll(generateConnectionsBetweenTwoLayers(inputNeurons, neurons));
    result.addAll(generateConnectionsBetweenTwoLayers(neurons, outputNeurons));

    return result;
  }

  private static List<NeuronConnection> generateConnectionsBetweenTwoLayers(
      List<Neuron> inputNeurons, List<Neuron> neurons) {

    List<NeuronConnection> result = new ArrayList<>();
    for (Neuron inputNeuron : inputNeurons) {
      double randomValue = ThreadLocalRandom.current().nextDouble();
      if (randomValue <= AlgorithmConstants.INITIAL_NEURON_CONNECTION_RATE) {

        Neuron randomNeuron = neurons.get(ThreadLocalRandom.current().nextInt(neurons.size()));

        boolean isEnabled = ThreadLocalRandom.current().nextBoolean();

        double randomWeight =
            ThreadLocalRandom.current()
                .nextDouble(AlgorithmConstants.MIN_WEIGHT, AlgorithmConstants.MAX_WEIGHT);

        result.add(
            new NeuronConnection(
                randomWeight,
                inputNeuron.getNeuronID(),
                randomNeuron.getNeuronID(),
                InnovationIDCounter.getNext(),
                isEnabled));
      }
    }
    return result;
  }

  private static List<Neuron> generateRandomHiddenLayer() {
    List<Neuron> result = new ArrayList<>();

    result.add(new Neuron(NeuronCounter.getNext(), 0, 1, new SigmoidActivationFunction()));

    return result;
  }

  private static List<Neuron> generateRandomOutputLayer() {
    List<Neuron> result = new ArrayList<>();

    result.add(new Neuron(NeuronCounter.getNext(), 0, -1, new SigmoidActivationFunction()));

    return result;
  }

  private static List<Neuron> generateRandomInputLayer() {
    List<Neuron> result = new ArrayList<>();

    result.add(new Neuron(NeuronCounter.getNext(), 0, 0, new SigmoidActivationFunction()));

    result.add(new Neuron(NeuronCounter.getNext(), 0, 0, new SigmoidActivationFunction()));

    result.add(new Neuron(NeuronCounter.getNext(), 0, 0, new SigmoidActivationFunction()));

    return result;
  }
}
