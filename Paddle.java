import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle {
    private int x, y, width, height;
    private boolean left, right;
    
    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 100;
        this.height = 15;
        this.left = false;
        this.right = false;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }
    
    public void move() {
        if (left && x > 0) {
            x -= 5;
        }
        if (right && x < 800 - width) {
            x += 5;
        }
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }
    
    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
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
