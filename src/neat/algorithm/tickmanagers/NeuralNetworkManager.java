package neat.algorithm.tickmanagers;

import neat.algorithm.model.Chromosome;
import neat.algorithm.model.Neuron;
import neat.algorithm.model.NeuronConnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NeuralNetworkManager {

  public static List<Double> runNetwork(Chromosome chromosome, List<Double> inputs) {

    List<Double> outputs = new ArrayList<>();
    // Input for Input layer
    // Get Input Layer Output
    Map<Integer, Double> neuronIDToInputMap = getInputLayerOutput(chromosome, inputs);

    List<NeuronConnection> neuronConnections = chromosome.getNeuronConnections();

    List<Neuron> neurons = chromosome.getNeurons();

    for (int i = 1; i <= chromosome.getNumberOfLayers(); i++) {

      Map<Integer, Double> nextLayerInput = new HashMap<>();

      final int layer = i;
      var layerNeurons =
          neurons.parallelStream().filter(n -> n.getLayer() == layer).collect(Collectors.toList());

      for (Neuron layerNeuron : layerNeurons) {
        if (!neuronIDToInputMap.containsKey(layerNeuron.getNeuronID())) continue;

        double weightedInput = neuronIDToInputMap.get(layerNeuron.getNeuronID());
        double output = layerNeuron.activateNeuron(weightedInput);

        var outputNeuronsConnections =
            neuronConnections
                .parallelStream()
                .filter(c -> c.isEnabled() && c.getInputNeuronID() == layerNeuron.getNeuronID())
                .collect(Collectors.toList());
        for (NeuronConnection connection : outputNeuronsConnections) {

          int outputNeuronID = connection.getOutputNeuronID();
          double weightedOutput = output * connection.getWeight();

          if (nextLayerInput.containsKey(outputNeuronID)) {
            nextLayerInput.put(outputNeuronID, nextLayerInput.get(outputNeuronID) + weightedOutput);
          } else {
            nextLayerInput.put(outputNeuronID, weightedOutput);
          }
        }

        neuronIDToInputMap = nextLayerInput;
      }
    }

    for (Neuron outputNeuron : chromosome.getOutputNeurons()) {
      if (!neuronIDToInputMap.containsKey(outputNeuron.getNeuronID())) outputs.add(0.0);
      else {
        outputs.add(
            outputNeuron.activateNeuron(neuronIDToInputMap.get(outputNeuron.getNeuronID())));
      }
    }
    return outputs;
  }

  private static Map<Integer, Double> getInputLayerOutput(
      Chromosome chromosome, List<Double> inputs) {
    Map<Integer, Double> neuronIDToInputMap = new HashMap<>();

    double inputSum = 0;

    for (Double input : inputs) {
      inputSum += input;
    }

    var neuronConnections = chromosome.getNeuronConnections();

    var neurons = chromosome.getInputNeurons();

    for (Neuron neuron : neurons) {

      var output = neuron.activateNeuron(inputSum);

      var outputConnections =
          neuronConnections
              .parallelStream()
              .filter(
                  connection ->
                      connection.isEnabled()
                          && connection.getInputNeuronID() == neuron.getNeuronID())
              .collect(Collectors.toList());

      for (NeuronConnection neuronConnection : outputConnections) {

        double weight = neuronConnection.getWeight();

        double weightedOutput = weight * output;

        var outputNeuronID = neuronConnection.getOutputNeuronID();

        if (neuronIDToInputMap.containsKey(outputNeuronID))
          neuronIDToInputMap.put(
              outputNeuronID, neuronIDToInputMap.get(outputNeuronID) + weightedOutput);
        else {
          neuronIDToInputMap.put(outputNeuronID, output);
        }
      }
    }
    return neuronIDToInputMap;
  }
}
