import javax.swing.*;

public class MovingCircleApp extends JFrame {
    public MovingCircleApp() {
        setTitle("Moving Circle");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        CirclePanel circlePanel = new CirclePanel();
        add(circlePanel);

        setVisible(true);

        new Thread(circlePanel).start();
    }
}