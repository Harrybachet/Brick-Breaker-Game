import javax.swing.JFrame;

public class BrickBreaker {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Brick Breaker Game");
        GamePanel gamePanel = new GamePanel();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(gamePanel);
        frame.setVisible(true);
    }
}
