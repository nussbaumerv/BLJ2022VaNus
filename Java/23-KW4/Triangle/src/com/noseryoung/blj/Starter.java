package com.noseryoung.blj;

import com.noseryoung.blj.exceptions.TriangleException;

public class Starter {
  public static void main(String[] args) throws TriangleException {
    TriangleApp triangle = new TriangleApp("Google", "Valentin Nussbaumer", 2.121);
    triangle.start();
  }
}
