package ch.noseryoung.main;

import java.util.Random;

public class SideCreatorService implements ShapeSideCreator{

  /**
   * This method generates a random <code>double</code>, rounded to .0 or .5.
   *
   * @return the generated value, to be used as a side for a shape
   */
  @Override
  public double createSide() {
    Random random = new Random();
    double randomNumber = random.nextDouble() * 10;
    randomNumber = Math.round(randomNumber * 2) / 2.0;
    return randomNumber;
  }
}
