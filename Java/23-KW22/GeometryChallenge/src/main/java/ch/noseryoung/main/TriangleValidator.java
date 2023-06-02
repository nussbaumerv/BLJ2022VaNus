package ch.noseryoung.main;

public class TriangleValidator {

  /**
   * Checks if the Triangle is equilateral or not.
   * Returns only true if all sides equal the same lengths.
   *
   * @param t triangle to be evaluated
   * @return true the triangle is equilateral , false if not
   */
  public boolean isEquilateral(Triangle t){
    boolean valid = false;
    if(t.getA() == t.getB() && t.getB() == t.getC()){
      valid = true;
    }
    return valid;
  }

  /**
   * Checks if the Triangle is equilateral or not.
   * Returns only true if two sides equal the same lengths.
   *
   * @param t triangle to be evaluated
   * @return true the triangle is equilateral , false if not
   */
  public boolean isIsosceles(Triangle t){
    boolean valid = false;
    if(t.getA() == t.getB() && t.getA() == t.getC() && t.getB() == t.getC()){
      valid = true;
    }
    return valid;
  }

  /**
   * Checks if the Triangle is a valid triangle.
   *
   * @param t triangle to be evaluated
   * @return true the triangle is scalene, false if not
   */
  public boolean isScalene(Triangle t){
    boolean valid = true;

    if (t.getA() + t.getB() <= t.getC() || t.getA() + t.getC() <= t.getB() || t.getB() + t.getC() <= t.getA()){
      valid = false;
    }

    return valid;
  }

}
