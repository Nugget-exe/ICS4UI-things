package Swing;

/*  
This is a very basic recursive circle program.
This program creates 4 circles and then stops.
Check out the base case.
Your Task:
1. Change the base case to produce more circles, 3 circles, 2 circles.
2. Change the colour of each circle getting smaller
3. Copy this code into a file called RecursiveSquare OR RecursiveTriangle. Create as square or triangle version as appropriate.
4. (OPTIONAL: if time allows) - create a graphics menu to allow your user to choose between the circle, square or triangle.
5. (Even more challenging) - the user defines the colour of # 4 above.

*/
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.concurrent.ThreadLocalRandom;


public class RecursiveCircle extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    public RecursiveCircle() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Recursive Circles");
        add(new CirclePanel(WIDTH / 2, HEIGHT / 2, 200, 10)); // Start with a large circle
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            RecursiveCircle circles = new RecursiveCircle();
            circles.setVisible(true);
        });
    }

    private class CirclePanel extends JPanel {
        private int x, y, radius, depth;

        public CirclePanel(int x, int y, int radius, int depth) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.depth = depth;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            drawCircles(g2d, x, y, radius, depth);
        }

        private void drawCircles(Graphics2D g, int x, int y, int radius, int depth) {
            
        int randomNum = ThreadLocalRandom.current().nextInt(0, 253 + 1);
        int randomNum2 = ThreadLocalRandom.current().nextInt(0, 253 + 1);
        int randomNum3 = ThreadLocalRandom.current().nextInt(0, 253 + 1);
            if (depth == 0) {
                // Base case: When depth is 0, stop recursion and draw a non-filled circle
                g.setColor(Color.black);
                g.draw(new Ellipse2D.Double(x - radius, y - radius, 2 * radius, 2 * radius));
            } else {
                // Draw the current circle
                g.setColor(new Color(randomNum, randomNum2, randomNum3));
                g.draw(new Ellipse2D.Double(x - radius, y - radius, 2 * radius, 2 * radius));

                // Calculate the radius of the next smaller circle
                int smallerRadius = radius * 2 / 3;

                // Calculate the positions for the smaller circles without overlapping
                int x1 = x - smallerRadius;
                int x2 = x + radius;
                int y1 = y - smallerRadius;
                int y2 = y + radius;

                // Recursively draw four smaller circles
                drawCircles(g, x1, y1, smallerRadius, depth - 1);

                /* 
                
                drawCircles(g, x1, y2, smallerRadius, depth - 1);
                drawCircles(g, x2, y1, smallerRadius, depth - 1);
                drawCircles(g, x2, y2, smallerRadius, depth - 1);
                */
                
            }
        }
    }
}
