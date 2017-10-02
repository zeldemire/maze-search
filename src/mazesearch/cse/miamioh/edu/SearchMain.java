package mazesearch.cse.miamioh.edu;


public class SearchMain {

	public static void main(String args[]) {
		Maze maze = new Maze("D:\\Documents\\School\\AI\\maze-search\\sample-input\\maze1.txt");
		SearchStrategy strategy = new SearchStrategy(maze) {
			@Override
			public void solve() {
				BFS bfs = new BFS(maze.getStart(), maze.getGoal());
				DFS dfs = new DFS(maze.getStart(), maze.getGoal());
				A_STAR a_star = new A_STAR(maze.getStart(), maze.getGoal());
			}
		};
	}

}

