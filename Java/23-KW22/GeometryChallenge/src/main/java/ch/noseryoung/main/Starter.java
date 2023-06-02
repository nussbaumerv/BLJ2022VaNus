package ch.noseryoung.main;

import java.util.ArrayList;

public class Starter {

  public static void main(String[] args) {

    SideCreatorService creatorService = new SideCreatorService();
    TriangleManager sm = new TriangleManager(creatorService);
    sm.run();

    sm.getAllTrianglesSortedByLongestSide().forEach((Triangle triangle) -> System.out.println(triangle.getA()));


    // todo: print all sorted Triangles
    // ... = sm.getAllTrianglesSortedByLongestSide();
    // ... = sm.getAllTrianglesSortedByLongestSide();

  }
}
