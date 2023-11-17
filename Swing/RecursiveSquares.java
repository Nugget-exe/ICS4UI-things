package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.concurrent.ThreadLocalRandom;


public class RecursiveSquares extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    public RecursiveSquares() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Recursive Squares");
        add(new SquarePanel(WIDTH / 2, HEIGHT / 2, 200, 9)); // Start with a large circle
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            RecursiveSquares Squares = new RecursiveSquares();
            Squares.setVisible(true);
        });
    }

    private class SquarePanel extends JPanel {
        private int x, y, halfwidth, depth;

        public SquarePanel(int x, int y, int halfwidth, int depth) {
            this.x = x;
            this.y = y;
            this.halfwidth = halfwidth;
            this.depth = depth;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            drawSquares(g2d, x, y, halfwidth, depth);
        }

        private void drawSquares(Graphics2D g, int x, int y, int halfwidth, int depth) {
            
        int randomNum = ThreadLocalRandom.current().nextInt(0, 253 + 1);
        int randomNum2 = ThreadLocalRandom.current().nextInt(0, 253 + 1);
        int randomNum3 = ThreadLocalRandom.current().nextInt(0, 253 + 1);
            if (depth == 0) {
                // Base case: When depth is 0, stop recursion and draw a non-filled circle
                g.setColor(Color.black);
                g.draw(new Rectangle2D.Double(x - halfwidth, y - halfwidth, 2 * halfwidth, 2 * halfwidth));
            } else {
                // Draw the current circle
                g.setColor(new Color(randomNum, randomNum2, randomNum3));
                g.draw(new Rectangle2D.Double(x - halfwidth, y - halfwidth, 2 * halfwidth, 2 * halfwidth));

                // Calculate the radius of the next smaller circle
                int smallerwidth = halfwidth * 2 / 3;

                // Calculate the positions for the smaller circles without overlapping
                int x1 = x - smallerwidth;
                int x2 = x + halfwidth;
                int y1 = y - smallerwidth;
                int y2 = y + halfwidth;

                // Recursively draw four smaller circles
                drawSquares(g, x1, y1, smallerwidth, depth - 1);
                
               
                
                
            }
        }
    }
}
