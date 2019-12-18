package neat.algorithm.util;

public class NeuronCounter {

  private static int counter = 0;

  public static int getNext() {
    return counter++;
  }
}
