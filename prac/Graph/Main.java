package prac.Graph;

public class Main {
    public static void main(String[] args) {
        Graph adjacentListGraph = new AdjacentListGraph(4);
        adjacentListGraph.add(1, 3);
        adjacentListGraph.add(2, 4);
        adjacentListGraph.add(3, 4);

        adjacentListGraph.draw();
        adjacentListGraph.BFS();
        adjacentListGraph.DFS();

        Graph adjacentMatrixGraph = new AdjacentMatrixGraph(5);
        adjacentMatrixGraph.add(1, 2);
        adjacentMatrixGraph.add(4, 2);
        adjacentMatrixGraph.add(1, 2);
        adjacentMatrixGraph.add(1, 3);
        adjacentMatrixGraph.add(5, 2);

        adjacentMatrixGraph.draw();
    }
}
