import java.awt.*;

public class AutoClicker {
    public static void main(String[] args) throws AWTException, InterruptedException {

        Robot robot = new Robot();
        // Klickt alle 5 Sekunden auf die aktuelle Mausposition
        while (true) {
            robot.mousePress(16); // 16 entspricht der linken Maustaste
            robot.mouseRelease(16);
            Thread.sleep(5); // Warte 5 Sekunden, bevor der nächste Klick ausgeführt wird
        }
    }
}
