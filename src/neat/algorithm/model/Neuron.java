package neat.algorithm.model;

import neat.algorithm.activationfunctions.ActivationFunction;

public class Neuron {

  private int neuronID;

  private double bias;

  // 0 if input, -1 if output
  private int layer;

  private ActivationFunction activationFunction;

  public double activateNeuron(double input) {

    return this.activationFunction.activate(input);
  }

  public Neuron(int neuronID, double bias, int layer, ActivationFunction activationFunction) {
    this.neuronID = neuronID;
    this.bias = bias;
    this.layer = layer;
    this.activationFunction = activationFunction;
  }

  public int getLayer() {
    return layer;
  }

  public void setLayer(int layer) {
    this.layer = layer;
  }

  public ActivationFunction getActivationFunction() {
    return activationFunction;
  }

  public void setActivationFunction(ActivationFunction activationFunction) {
    this.activationFunction = activationFunction;
  }

  public int getNeuronID() {
    return neuronID;
  }

  public void setNeuronID(int neuronID) {
    this.neuronID = neuronID;
  }

  public double getBias() {
    return bias;
  }

  public void setBias(double bias) {
    this.bias = bias;
  }
}
