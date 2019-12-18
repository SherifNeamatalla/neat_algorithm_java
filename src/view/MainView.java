package view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import simulation.Simulator;
import simulation.model.GenerationMetaInformation;
import simulation.model.Simulation;
import simulation.model.SimulationConfiguration;

public class MainView extends BorderPane {
  private Simulator simulator;
  private GameCanvas gameCanvas;
  private AppSidebar appSidebar;

  public MainView() {
    this.gameCanvas = new GameCanvas(1024, 1024);
    this.appSidebar = new AppSidebar(this);
    this.setTop(new VBox(new AppToolbar(this)));

    this.setLeft(appSidebar);
    this.setCenter(gameCanvas);
  }

  public void nextGeneration() {

    this.simulator.start();
  }

  public void refreshSidebar(GenerationMetaInformation generationMetaInformation) {}

  public void refreshSidebarConfigurationTextValue(
      SimulationConfiguration simulationConfiguration) {}

  public void connect(Simulator simulator) {
    this.simulator = simulator;
  }

  public void start() {

    this.simulator.start();
  }

  public void draw(Simulation simulation) {
    this.gameCanvas.draw(simulation);
  }
}
