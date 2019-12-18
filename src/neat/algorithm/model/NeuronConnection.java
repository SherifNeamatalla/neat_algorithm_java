package neat.algorithm.model;

public class NeuronConnection {

  private double weight;

  private int inputNeuronID, outputNeuronID, innovationID;

  private boolean isEnabled;

  public NeuronConnection(
      double weight, int inputNeuronID, int outputNeuronID, int innovationID, boolean isEnabled) {
    this.weight = weight;
    this.inputNeuronID = inputNeuronID;
    this.outputNeuronID = outputNeuronID;
    this.innovationID = innovationID;
    this.isEnabled = isEnabled;
  }

  public boolean isEnabled() {
    return isEnabled;
  }

  public void setEnabled(boolean enabled) {
    isEnabled = enabled;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public int getInputNeuronID() {
    return inputNeuronID;
  }

  public void setInputNeuronID(int inputNeuronID) {
    this.inputNeuronID = inputNeuronID;
  }

  public int getOutputNeuronID() {
    return outputNeuronID;
  }

  public void setOutputNeuronID(int outputNeuronID) {
    this.outputNeuronID = outputNeuronID;
  }

  public int getInnovationID() {
    return innovationID;
  }

  public void setInnovationID(int innovationID) {
    this.innovationID = innovationID;
  }
}
