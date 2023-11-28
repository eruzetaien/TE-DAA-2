import java.io.*;
import java.util.*;

public class GraphDatasetGenerator {

    static int[][] generateGraph(int n) {
        int[][] graph = new int[n][n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                graph[i][j] = graph[j][i] = (rand.nextDouble() < 0.5) ? 1 : 0;
            }
        }

        return graph;
    }

    // Export graph to CSV file
    static void exportToCSV(int[][] graph, String fileName) {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            StringBuilder sb = new StringBuilder();

            sb.append(graph.length).append("\n");

            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    sb.append(graph[i][j]).append(",");
                }
                sb.append("\n");
            }

            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Import graph from CSV file
    static int[][] importFromCSV(String fileName) {
        int[][] graph = null;

        try (Scanner scanner = new Scanner(new File(fileName))) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            graph = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] line = scanner.nextLine().split(",");
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(line[j]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return graph;
    }
}