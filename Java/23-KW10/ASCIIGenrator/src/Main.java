import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class Main {
    static Color white = new Color(255, 255, 255);
    static int rgbWhite = white.getRGB();

    static Color black = new Color(0, 0, 0);
    static int rgbBlack = black.getRGB();

    public static boolean checkNoised(int color) {
        boolean returnVal = true;
        if (color == rgbWhite || color == rgbBlack) {
            returnVal = false;
        }
        return returnVal;
    }

    public static boolean checkCoordinates(BufferedImage img, int x, int y) {
        boolean returnVal = true;
        if (x < 0 || y < 0 || x >= img.getWidth() || y >= img.getHeight()) {
            returnVal = false;
        }
        return returnVal;
    }


    public static boolean[][] setArr(int x, int y, boolean validPoints[][]) {
        if (x < 0) {
            validPoints[0][0] = false;
            validPoints[0][1] = false;
            validPoints[0][2] = false;
        }
        if (y < 0) {
            validPoints[0][0] = false;
            validPoints[1][0] = false;
            validPoints[2][0] = false;
        }
        return validPoints;
    }

    public static int getBrightness(Color color) {

        final double cr = 0.241;
        final double cg = 0.691;
        final double cb = 0.068;

        double r, g, b;
        r = color.getRed();
        g = color.getGreen();
        b = color.getBlue();

        double result = Math.sqrt(cr * r * r + cg * g * g + cb * b * b);

        return (int) result;
    }

    public static BufferedImage noise(BufferedImage img) {
        System.out.println("Noising...");
        double probability = 0.7;

        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                double rand = Math.random();
                if (rand < probability) {
                    rand = Math.random();

                    if (rand <= 0.5) {
                        img.setRGB(x, y, rgbWhite);
                    } else {
                        img.setRGB(x, y, rgbBlack);
                    }

                }
            }
        }
        return img;
    }

    public static BufferedImage deNoise(BufferedImage img) {
        System.out.println("Denoising...");
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                if (img.getRGB(x, y) == rgbWhite || img.getRGB(x, y) == rgbBlack) {
                    int rBucket = 0;
                    int gBucket = 0;
                    int bBucket = 0;
                    int finalCounter = 0;

                    int tempY = y - 1;
                    int tempX = x - 1;

                    boolean validPoints[][] = {
                            {true, true, true},
                            {true, false, true},
                            {true, true, true}
                    };

                    validPoints = setArr(tempX, tempY, validPoints);

                    for (int pY = 0; pY < 3; pY++) {
                        for (int pX = 0; pX < 3; pX++) {
                            if (validPoints[pX][pY]) {
                                if (checkCoordinates(img, tempX + pX, tempY + pY)) {
                                    if (checkNoised(img.getRGB(tempX + pX, tempY + pY))) {
                                        Color tempColor = new Color(img.getRGB(tempX + pX, tempY + pY));
                                        rBucket += tempColor.getRed();
                                        gBucket += tempColor.getGreen();
                                        bBucket += tempColor.getBlue();

                                        finalCounter++;
                                    }
                                }
                            }
                            else {
                                //System.out.println(x + " " + y + "    /   " + pX + " " + pY);
                            }

                        }
                    }

                    int finColor = img.getRGB(x, y);

                    if (finalCounter == 0) {

                    } else {
                        finColor = new Color(rBucket / finalCounter, gBucket / finalCounter, bBucket / finalCounter).getRGB();

                    }

                    img.setRGB(x, y, finColor);
                }
            }
        }

        return img;
    }

    public static void main(String[] args) throws IOException {
        BufferedImage img = null;
        System.out.println(getBrightness(Color.BLACK));
        System.out.println(getBrightness(Color.BLUE));
        System.out.println(getBrightness(Color.GREEN));
        System.out.println(getBrightness(Color.WHITE));

        try {
            img = ImageIO.read(new File("C:/Users/nussb/Desktop/me.jpg"));
            System.out.println("File Found");
        } catch (IOException e) {
            System.out.println("File not Found");
        }

        try {
            img = noise(img);
            ImageIO.write(img, "png", new File("C:/Users/nussb/Desktop/calc.png"));
            System.out.println("Successfully Denoised");
        } catch (Exception e) {
            System.out.println("Can't Denoise");
        }
    }
}