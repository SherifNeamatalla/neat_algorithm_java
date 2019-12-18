package simulation.model;

public class SimulationConfiguration {

  private int creatureCount;

  private int foodCount;

  public SimulationConfiguration(int creatureCount, int foodCount) {
    this.creatureCount = creatureCount;
    this.foodCount = foodCount;
  }

  public int getFoodCount() {
    return foodCount;
  }

  public void setFoodCount(int foodCount) {
    this.foodCount = foodCount;
  }

  public int getCreatureCount() {
    return creatureCount;
  }

  public void setCreatureCount(int creatureCount) {
    this.creatureCount = creatureCount;
  }
}
