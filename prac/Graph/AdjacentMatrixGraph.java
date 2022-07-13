package prac.Graph;

public class AdjacentMatrixGraph implements Graph {

    private int[][] graph;

    public AdjacentMatrixGraph(int numOfVertex) {
        this.graph = new int[numOfVertex + 1][numOfVertex + 1];
    }

    @Override
    public void add(int from, int to) {
        // TODO Auto-generated method stub
        if(isExist(from, to)) {
            System.out.println("Already Exist");
            return;
        }

        graph[from][to] = 1;
        graph[to][from] = 1;
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub
        System.out.println("Graph");
        for(int i = 1; i < graph.length; i++) {
            for(int j = 1; j < graph.length; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println("");
        }
        
    }

    @Override
    public boolean isExist(int from, int to) {
        // TODO Auto-generated method stub
        if(graph[from][to] == 1) return true;
        return false;
    }

    @Override
    public void BFS() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void DFS() {
        // TODO Auto-generated method stub
        
    }
    
}
