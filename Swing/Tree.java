package Swing;

/* 


*/
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Tree {
    public static void main(String[] args) {
        int depth = 10; // Adjust the depth for a more detailed tree

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Recursive Tree Visual");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create an instance of RecursiveTreePanel
            Tree2 treePanel = new Tree2(depth);

            // Add the treePanel to the frame
            frame.add(treePanel);

            frame.setSize(300, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });// timing added so you can see
    }//end void main
}//end class Tree

class Tree2 extends JPanel {
    private int depth;

    public Tree2(int depth) {
        this.depth = depth;
    }// end public Tree

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int startX = getWidth() / 2;
        int startY = getHeight();

        // Draw the initial trunk of the tree
        g2d.setColor(Color.BLACK);
        g2d.draw(new Line2D.Double(startX, startY, startX, startY - 100));

        // Call the recursive method to draw branches
        drawBranch(g2d, startX, startY - 100, 50, -Math.PI / 2, depth);
    }//end draw components

    private void drawBranch(Graphics2D g2d, double x, double y, double length, double angle, int depth) {
        if (depth == 0) {
            // Base case: Stop recursion
            return;
        } else {
            // Calculate the endpoint of the branch
            double endX = x + length * Math.cos(angle);
            double endY = y + length * Math.sin(angle);

            // Draw the branch
            g2d.setColor(Color.GREEN);
            g2d.draw(new Line2D.Double(x, y, endX, endY));

            // Recursively draw two smaller branches
            drawBranch(g2d, endX, endY, length * 0.65, angle + Math.PI / 4, depth - 1);
            drawBranch(g2d, endX, endY, length * 0.65, angle - Math.PI / 4, depth - 1);
        }//end Depth = 0 base case
    } // end drawBranch
}// end tree Extending JPanel
