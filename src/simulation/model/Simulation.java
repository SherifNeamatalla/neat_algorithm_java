package simulation.model;

import neat.algorithm.model.Creature;
import neat.environment.model.Food;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

  private List<Creature> creatures;

  private List<Food> foods;

  public Simulation() {
    creatures = new ArrayList<>();
    creatures.add(new Creature());
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
