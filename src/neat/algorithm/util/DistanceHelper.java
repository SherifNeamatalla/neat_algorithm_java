package neat.algorithm.util;

import neat.algorithm.model.Position;

public class DistanceHelper {

  public static double getDistance(Position p1, Position p2) {

    double lat1 = p1.getX();
    double lng1 = p1.getY();
    double lat2 = p2.getX();
    double lng2 = p2.getY();

    double firstSum = Math.abs(lat1 - lat2);
    double secondSum = Math.abs(lng1 - lng2);

    return Math.sqrt(Math.pow(firstSum, 2) + Math.pow(secondSum, 2));
  }
}
