package day76_Advanced_Graphs_1_DFS_BFS;
/*
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the
pixel image[sr][sc].
To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel
of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same
color), and so on. Replace the color of all of the aforementioned pixels with color.
Return the modified image after performing the flood fill.

Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected
by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 */

/*
    Time Complexity: O(rows * cols)
    Reason: In the worst case, we may visit each pixel once, and for each pixel, we explore its neighboring pixels.

    Space Complexity: O(rows * cols)
    Reason: In the worst case, the entire image might be added to the queue.
*/

import java.util.LinkedList;
import java.util.Queue;

class Flood_Fill_733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;

        int originalColor = image[sr][sc];

        // If the starting pixel has the same color as the new color, no need to perform flood fill
        if (originalColor == newColor) {
            return image;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] currentPixel = queue.poll();
            int currentRow = currentPixel[0];
            int currentCol = currentPixel[1];

            // Change the color of the current pixel
            image[currentRow][currentCol] = newColor;

            // Explore the four directions
            for (int[] dir : directions) {
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];

                // Check if the new position is within bounds and has the original color
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                        image[newRow][newCol] == originalColor) {
                    // Add the new position to the queue for further processing
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return image;
    }
}
