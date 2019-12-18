package simulation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import neat.NeatRunner;
import simulation.model.GenerationMetaInformation;
import simulation.model.Simulation;
import simulation.model.SimulationConfiguration;
import view.MainView;

public class Simulator {

  private static final int MS_PER_TICK = 1;

  private static final int CYCLES_PER_ROUND = 10;

  private Timeline timeline;

  private MainView mainView;

  private NeatRunner neatRunner;

  private Simulation simulation;

  private SimulationConfiguration simulationConfiguration;

  private GenerationMetaInformation lastGenerationMetaInformation;

  public Simulator(MainView mainView, SimulationConfiguration simulationConfiguration) {

    this.mainView = mainView;

    this.simulationConfiguration = simulationConfiguration;

    this.neatRunner = new NeatRunner();

    this.simulation = new Simulation(simulationConfiguration.getCreatureCount(),simulationConfiguration.getFoodCount());

    KeyFrame keyFrame =
        new KeyFrame(
            Duration.millis(MS_PER_TICK * 1000),
            actionEvent -> {
              neatRunner.run(simulation.getCreatures(), simulation.getFoods());
              neatRunner.nextGeneration();
              this.mainView.draw(simulation);
            });

    this.mainView.connect(this);
    this.timeline = new Timeline(keyFrame);
    this.timeline.setCycleCount(CYCLES_PER_ROUND);
    this.timeline.setOnFinished(this::onSimulationDone);
  }

  private void onSimulationDone(ActionEvent actionEvent) {

    this.mainView.draw(simulation);
  }

  public void start() {

    this.timeline.play();
  }
}
