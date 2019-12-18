package simulation.model;

import neat.algorithm.model.Creature;
import neat.environment.model.Food;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

  private List<Creature> creatures;

  private List<Food> foods;

  public Simulation(int creatureCount, int foodCount) {
    creatures = new ArrayList<>();
    foods = new ArrayList<>();

    for (int i = 0; i < creatureCount; i++) {
      creatures.add(new Creature());
    }
    for (int i = 0; i < foodCount; i++) {
      foods.add(new Food());
    }
  }

  public List<Creature> getCreatures() {
    return creatures;
  }

  public void setCreatures(List<Creature> creatures) {
    this.creatures = creatures;
  }

  public List<Food> getFoods() {
    return foods;
  }

  public void setFoods(List<Food> foods) {
    this.foods = foods;
  }
}
