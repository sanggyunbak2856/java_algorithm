package prac.Graph;

public interface Graph {
    public void add(int from, int to);
    public void draw();
    public boolean isExist(int from, int to);
    public void BFS();
    public void DFS();
}
