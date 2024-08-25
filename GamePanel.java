import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Paddle paddle;
    private Ball ball;
    private Brick[][] bricks;
    private Timer timer;
    private int score;
    private boolean gameOver;

    public GamePanel() {
        this.paddle = new Paddle(350, 500);
        this.ball = new Ball(400, 300);
        this.bricks = new Brick[5][7];
        this.score = 0;
        this.gameOver = false;

        // Initialize bricks
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[i].length; j++) {
                bricks[i][j] = new Brick(j * 100 + 50, i * 30 + 50);
            }
        }

        this.setFocusable(true);
        this.addKeyListener(this);
        this.timer = new Timer(10, this);
        this.timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paddle.draw(g);
        ball.draw(g);
        
        for (Brick[] row : bricks) {
            for (Brick brick : row) {
                if (brick.isVisible()) {
                    brick.draw(g);
                }
            }
        }
        
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 10);

        if (gameOver) {
            g.setColor(Color.RED);
            g.drawString("Game Over! Final Score: " + score, 350, 300);
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            ball.move();
            paddle.move();
            checkCollision();
            repaint();
        }
    }

    private void checkCollision() {
        // Ball and Paddle collision
        if (ball.getRect().intersects(paddle.getRect())) {
            ball.reverseYDir();
        }

        // Ball and Brick collision
        for (Brick[] row : bricks) {
            for (Brick brick : row) {
                if (brick.isVisible() && ball.getRect().intersects(brick.getRect())) {
                    ball.reverseYDir();
                    brick.setVisible(false);
                    score += 10;
                }
            }
        }

        // Ball falls below the paddle
        if (ball.getY() > 600) {
            gameOver = true;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.setLeft(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.setRight(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.setLeft(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.setRight(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
