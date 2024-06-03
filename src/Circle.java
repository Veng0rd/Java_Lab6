public class Circle {
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public int getDiameter() {
        return radius * 2;
    }

    public boolean isInside(int x, int y) {
        int dx = x - (this.x + radius);
        int dy = y - (this.y + radius);
        return dx * dx + dy * dy <= radius * radius;
    }
}
