import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CirclePanel extends JPanel implements Runnable {
    private Circle _circle;
    private boolean _dragging = false;

    public CirclePanel() {
        _circle = new Circle(50, 50, 50);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (_circle.isInside(e.getX(), e.getY())) {
                    _dragging = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                _dragging = false;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (_dragging) {
                    int newX = e.getX() - _circle.getRadius();
                    int newY = e.getY() - _circle.getRadius();

                    newX = Math.max(0, Math.min(newX, getWidth() - _circle.getDiameter()));
                    newY = Math.max(0, Math.min(newY, getHeight() - _circle.getDiameter()));

                    _circle.setX(newX);
                    _circle.setY(newY);
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getColorBasedOnY(_circle.getY()));
        g.fillOval(_circle.getX(), _circle.getY(), _circle.getDiameter(), _circle.getDiameter());
    }

    private Color getColorBasedOnY(int y) {
        int height = getHeight();
        float hue = (float) y / height;
        return Color.getHSBColor(hue, 1.0f, 1.0f);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(16); // roughly 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}
