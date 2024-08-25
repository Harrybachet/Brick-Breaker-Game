import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
    private int x, y, diameter;
    private int xDir, yDir;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.diameter = 15;
        this.xDir = -1;
        this.yDir = -2;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, diameter, diameter);
    }

    public void move() {
        x += xDir;
        y += yDir;

        // Bounce off the left or right walls
        if (x < 0 || x > 800 - diameter) {
            reverseXDir();
        }

        // Bounce off the top wall
        if (y < 0) {
            reverseYDir();
        }
    }

    public void reverseXDir() {
        xDir = -xDir;
    }

    public void reverseYDir() {
        yDir = -yDir;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, diameter, diameter);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }
}
