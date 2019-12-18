package neat.algorithm.model;

import java.util.List;

public class Chromosome {

  private List<Neuron> inputNeurons;
  private List<Neuron> outputNeurons;

  private List<Neuron> neurons;

  private List<NeuronConnection> neuronConnections;

  private int numberOfLayers;

  public Chromosome(
      List<Neuron> inputNeurons,
      List<Neuron> outputNeurons,
      List<Neuron> neurons,
      List<NeuronConnection> neuronConnections,
      int numberOfLayers) {
    this.inputNeurons = inputNeurons;
    this.outputNeurons = outputNeurons;
    this.neurons = neurons;
    this.neuronConnections = neuronConnections;
    this.numberOfLayers = numberOfLayers;
  }

  public int getNumberOfLayers() {
    return numberOfLayers;
  }

  public void setNumberOfLayers(int numberOfLayers) {
    this.numberOfLayers = numberOfLayers;
  }

  public List<Neuron> getInputNeurons() {
    return inputNeurons;
  }

  public void setInputNeurons(List<Neuron> inputNeurons) {
    this.inputNeurons = inputNeurons;
  }

  public List<Neuron> getOutputNeurons() {
    return outputNeurons;
  }

  public void setOutputNeurons(List<Neuron> outputNeurons) {
    this.outputNeurons = outputNeurons;
  }

  public List<Neuron> getNeurons() {
    return neurons;
  }

  public void setNeurons(List<Neuron> neurons) {
    this.neurons = neurons;
  }

  public List<NeuronConnection> getNeuronConnections() {
    return neuronConnections;
  }

  public void setNeuronConnections(List<NeuronConnection> neuronConnections) {
    this.neuronConnections = neuronConnections;
  }
}
