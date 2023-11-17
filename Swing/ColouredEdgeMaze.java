package Swing;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ColouredEdgeMaze {
    public static void main(String[] args) {
        int mazeSize = 5;

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Coloured Edge Maze (5x5)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel mazePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    drawMaze(g, mazeSize);
                }
            };

            frame.add(mazePanel);
            frame.setSize(300, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static void drawMaze(Graphics g, int mazeSize) {
        int cellSize = 60;
        boolean[][] maze = generateMaze(mazeSize);

        // Set up color for maze edges
        g.setColor(Color.BLACK);

        for (int row = 0; row < mazeSize; row++) {
            for (int col = 0; col < mazeSize; col++) {
                if (maze[row][col]) {
                    // Draw maze walls with colored edges
                    g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                    g.setColor(Color.WHITE); // Change color for edges
                    g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);
                    g.setColor(Color.BLACK); // Change back to black for potential walls
                }
            }
        }
    }

    private static boolean[][] generateMaze(int mazeSize) {
        boolean[][] maze = new boolean[mazeSize][mazeSize];
        Random random = new Random();

        for (int row = 0; row < mazeSize; row++) {
            for (int col = 0; col < mazeSize; col++) {
                // Set walls randomly, but leave open borders
                if (row == 0 || col == 0 || row == mazeSize - 1 || col == mazeSize - 1) {
                    maze[row][col] = false; // Open borders
                } else {
                    maze[row][col] = random.nextBoolean();
                }
            }
        }

        return maze;
    }
}
