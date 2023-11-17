package Swing;

/*

I'm surprised this actually runs.  It has an intentional error which some of you might do from time to time.  Fix it.
(Hint:  Snowflake vs. Snowflake2)
*/

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class KochSnowflakeTimer {
    public static void main(String[] args) {
        int depth = 4; // Adjust the depth for more iterations and detail

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Koch Snowflake");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create an instance of KochSnowflakePanel
            KochSnowflakePanel2 snowflakePanel = new KochSnowflakePanel2(depth);

            // Add the snowflakePanel to the frame
            frame.add(snowflakePanel);

            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });// end swing - hold so you can see
    }// end void main
}//class Snowflake Timer

class KochSnowflakePanel2 extends JPanel {
    private int depth;
    private int currentDepth;
    private Timer timer;

    public KochSnowflakePanel2(int depth) {
        this.depth = depth;
        this.currentDepth = 0;

        // Create a timer that triggers every 1000 milliseconds (1 second)
        this.timer = new Timer(1000, e -> {
            if (currentDepth <= depth) {
                currentDepth++;
                repaint(); // Repaint the panel to show the progress
            } else {
                timer.stop(); // Stop the timer when the desired depth is reached
            } // end if current Depth - base case
        });// end timer

        timer.start(); // Start the timer
    }//end KochSnowflakePanel2

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Define the initial triangle's vertices
        Point p1 = new Point(100, 300);
        Point p2 = new Point(400, 300);
        Point p3 = new Point(250, 50);

        // Draw the initial triangle
        drawKochCurve(g2d, p1, p2, currentDepth);
        drawKochCurve(g2d, p2, p3, currentDepth);
        drawKochCurve(g2d, p3, p1, currentDepth);
    }//paint component

    private void drawKochCurve(Graphics2D g2d, Point p1, Point p2, int depth) {
        if (depth == 0) {
            // Base case: Draw a straight line
            g2d.draw(new Line2D.Double(p1, p2));
        } else {
            // Calculate 1/3 and 2/3 points on the line
            Point p3 = new Point((2 * p1.x + p2.x) / 3, (2 * p1.y + p2.y) / 3);
            Point p4 = new Point((p1.x + 2 * p2.x) / 3, (p1.y + 2 * p2.y) / 3);

            // Calculate an equilateral triangle point
            double angle = Math.toRadians(60);
            int dx = p4.x - p3.x;
            int dy = p4.y - p3.y;
            Point p5 = new Point((int) (p3.x + dx * Math.cos(angle) - dy * Math.sin(angle)),
                    (int) (p3.y + dx * Math.sin(angle) + dy * Math.cos(angle)));

            // Recursively draw four segments of the Koch curve
            drawKochCurve(g2d, p1, p3, depth - 1);
            drawKochCurve(g2d, p3, p5, depth - 1);
            drawKochCurve(g2d, p5, p4, depth - 1);
            drawKochCurve(g2d, p4, p2, depth - 1);
        }//end Depth = 0
    }//end Koch Curve
}//end class KochSnowflakeTimer
