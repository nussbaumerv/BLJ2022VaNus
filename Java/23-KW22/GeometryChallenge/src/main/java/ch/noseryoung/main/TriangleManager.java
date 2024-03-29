package ch.noseryoung.main;

import java.util.ArrayList;

public class TriangleManager {

  private ShapeSideCreator generator;
  private TriangleValidator triangleValidator;
  private ArrayList<Triangle> triangles;

  public TriangleManager(ShapeSideCreator generator) {
    this.generator = generator;
    triangleValidator = new TriangleValidator();
    triangles = new ArrayList<>();
  }

  /**
   * This method is the entry point for the triangle manager.
   * It creates at least one triangle with the <code>ShapeSideCreator</code> instance
   * and prints the triangle with its information.
   */
  public void valiAdd(Triangle triangle){
    boolean isEquilateral = triangleValidator.isEquilateral(triangle);
    boolean isIsosceles = triangleValidator.isIsosceles(triangle);
    boolean isScalene = triangleValidator.isScalene(triangle);

    if(triangleValidator.isScalene(triangle)){
      triangles.add(triangle);
    }

    printTriangleInfo(triangle, isEquilateral, isIsosceles, isScalene);

  }
  public void run() {

    printWelcomeText();

    valiAdd(generateTriangle());
    valiAdd(generateTriangle());
    valiAdd(generateTriangle());
  }

  /**
   * This method calls an implementation from the <code>ShapeSideCreator</code> Interface
   * to get three sides for a new triangle.
   *
   * @return created triangle
   */
  private Triangle generateTriangle() {
    return new Triangle(generator.createSide(), generator.createSide(), generator.createSide());
  }

  /**
   * This Method prints out the Triangle Information with the result form the validation.
   *
   * @param t
   * @param isEquilateral
   * @param isIsoceles
   * @param isScalene
   */
  private void printTriangleInfo(Triangle t, boolean isEquilateral, boolean isIsoceles, boolean isScalene) {
    System.out.println("A: " + t.getA() + ", B: " + t.getB() + ", C: " + t.getC());
    System.out.println(isEquilateral + " " + isIsoceles + " " + isScalene);
  }

  /**
   * This method returns out all generated Triangles, which are sorted by side.
   * The Triangles are compared with its shortest side. The longest "shortest Side" is listed first.
   *
   * @return sorted triangle list
   */
  public ArrayList<Triangle> getAllTrianglesSortedByShortestSide(){
    // todo
    return null;
  }

  /**
   * This method returns out all generated Triangles, which are sorted by side.
   * The Triangles are compared with its longest side. The longest "longest Side" is listed first.
   *
   * @return sorted triangle list
   */
  public ArrayList<Triangle> getAllTrianglesSortedByLongestSide(){

    // todo
    return triangles;
  }

  /**
   * This method prints a welcome text for the triangle manager.
   */
  private void printWelcomeText(){
    System.out.println("Welcome to my Trangle generator");
  }
}
