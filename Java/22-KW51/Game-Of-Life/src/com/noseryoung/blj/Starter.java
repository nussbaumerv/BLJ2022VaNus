package com.noseryoung.blj;

/**
 * The starter class. Clean, simple and short, as all starter classes should be.
 * 
 * @author surber
 *
 */
public class Starter {
  public static void main(String[] args) {
    Simulation sim = new Simulation(100, true, Preset.PULSAR_17X17);
    SimulationPanel simPanel = new SimulationPanel(sim, 40, 0.9);
    simPanel.getSimulation().start();
  }
}