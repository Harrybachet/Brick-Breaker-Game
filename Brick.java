import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Brick {
    private int x, y, width, height;
    private boolean visible;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 100;
        this.height = 30;
        this.visible = true;
    }

    public void draw(Graphics g) {
        if (visible) {
            g.setColor(Color.RED);
            g.fillRect(x, y, width, height);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, height);
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
