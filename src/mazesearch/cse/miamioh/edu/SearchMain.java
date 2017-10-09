package mazesearch.cse.miamioh.edu;


public class SearchMain {

	public static void main(String args[]) {
//		Maze maze = new Maze("E:\\Documents\\School\\AI\\maze-search\\sample-input\\maze1.txt");
//		Maze maze = new Maze("E:\\Documents\\School\\AI\\maze-search\\sample-input\\maze2.txt");
		Maze maze = new Maze("E:\\Documents\\School\\AI\\maze-search\\sample-input\\maze3.txt");
		BFS bfs = new BFS(maze);
		DFS dfs = new DFS(maze);
		A_STAR a_star = new A_STAR(maze);

		a_star.solve();
		System.out.println("A_STAR");
		System.out.print("Actions taken: ");
		System.out.println(a_star.getPathFromStartToGoal().size());
		System.out.print("Explored nodes: ");
		System.out.println(a_star.getExploredSquares().size());
		System.out.println("A_STAR cost " + a_star.getPathFromStartToGoal().size());

		dfs.solve();
		System.out.println("DFS");
		System.out.print("Actions taken: ");
		System.out.println(dfs.getPathFromStartToGoal().size());
		System.out.print("Explored nodes: ");
		System.out.println(dfs.getExploredSquares().size());
		bfs.solve();

		System.out.println("BFS");
		System.out.print("Actions taken: ");
		System.out.println(bfs.getPathFromStartToGoal().size());
		System.out.print("Explored nodes: ");
		System.out.println(bfs.getExploredSquares().size());
	}

}

