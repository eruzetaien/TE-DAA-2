import java.util.Arrays;

public class Main {

    private static void checkMemoryUsage(String filename, boolean isDp){
        long beforeUsedMem, afterUsedMem;

        HpDynamicProgramming hpDynamicProgramming = new HpDynamicProgramming();
        HpBacktracking hpBacktracking = new HpBacktracking();

        beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        int[][] graph = GraphDatasetGenerator.importFromCSV(filename);


        if (isDp){
            hpDynamicProgramming.hasHamiltonianPath(graph);
            afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        } else {
            hpBacktracking.hasHamiltonianPath(graph);
            afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        }

        System.out.println("Memory usage for " + filename + ": " + (afterUsedMem-beforeUsedMem) + " bytes");
    }


    public static void main(String[] args) {
        final double MILI2NANO = 1e6;
        double startTime, endTime;


        int[][] smallGraph = GraphDatasetGenerator.importFromCSV("small_graph.csv");
        int[][] mediumGraph = GraphDatasetGenerator.importFromCSV("medium_graph.csv");
        int[][] largeGraph = GraphDatasetGenerator.importFromCSV("large_graph.csv");


        // Check if the graph has a Hamiltonian Path
        HpDynamicProgramming hpDynamicProgramming = new HpDynamicProgramming();
        HpBacktracking hpBacktracking = new HpBacktracking();


        System.out.println("=====================================");
        startTime = System.nanoTime()/MILI2NANO;
        boolean smallGraphHasHpDp = hpDynamicProgramming.hasHamiltonianPath(smallGraph);
        endTime = System.nanoTime()/MILI2NANO;
        System.out.println("Small graph Hamiltonian Path DP: " + smallGraphHasHpDp);
        System.out.println("Time for small graph Hamiltonian DP: " + (endTime - startTime));

        System.out.println("=====================================");
        startTime = System.nanoTime()/MILI2NANO;
        boolean smallGraphHasHpBt = hpBacktracking.hasHamiltonianPath(smallGraph);
        endTime = System.nanoTime()/MILI2NANO;
        System.out.println("Small graph Hamiltonian Path Backtracking: " + smallGraphHasHpBt);
        System.out.println("Time for small graph Hamiltonian Backtracking: " + (endTime - startTime));

        System.out.println("=====================================");
        startTime = System.nanoTime()/MILI2NANO;
        boolean mediumGraphHasHpDp = hpDynamicProgramming.hasHamiltonianPath(mediumGraph);
        endTime = System.nanoTime()/MILI2NANO;
        System.out.println("Medium graph Hamiltonian Path DP: " + mediumGraphHasHpDp);
        System.out.println("Time for medium graph Hamiltonian DP: " + (endTime - startTime));

        System.out.println("=====================================");
        startTime = System.nanoTime()/MILI2NANO;
        boolean mediumGraphHasHpBt = hpBacktracking.hasHamiltonianPath(mediumGraph);
        endTime = System.nanoTime()/MILI2NANO;
        System.out.println("Medium graph Hamiltonian Path Backtracking: " + mediumGraphHasHpBt);
        System.out.println("Time for medium graph Hamiltonian Backtracking: " + (endTime - startTime));

        System.out.println("=====================================");
        startTime = System.nanoTime()/MILI2NANO;
        boolean largeGraphHasHpDp = hpDynamicProgramming.hasHamiltonianPath(largeGraph);
        endTime = System.nanoTime()/MILI2NANO;
        System.out.println("Large graph Hamiltonian Path DP: " + largeGraphHasHpDp);
        System.out.println("Time for large graph Hamiltonian DP: " + (endTime - startTime));

        System.out.println("=====================================");
        startTime = System.nanoTime()/MILI2NANO;
        boolean largeGraphHasHpBt = hpBacktracking.hasHamiltonianPath(largeGraph);
        endTime = System.nanoTime()/MILI2NANO;
        System.out.println("Large graph Hamiltonian Path Backtracking: " + largeGraphHasHpBt);
        System.out.println("Time for large graph Hamiltonian Backtracking: " + (endTime - startTime));
    }
}