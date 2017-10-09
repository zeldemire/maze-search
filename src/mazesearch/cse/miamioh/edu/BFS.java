package mazesearch.cse.miamioh.edu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS extends SearchStrategy {

	BFS(Maze maze) {
		super(maze);
	}

	@Override
	public void solve() {
		Queue<Node> tree = new LinkedList<>();

		Node startPosition = new Node(null, maze.getStart().getRow(), maze.getStart().getColumn());
		Node goal = new Node(null, maze.getGoal().getRow(), maze.getGoal().getColumn());

		tree.add(startPosition);
		explored.add(new Square(startPosition.getRow(), startPosition.getCol()));

		while (!tree.isEmpty()) {
			Node node = tree.remove();

			if (node.equals(goal)) {
				// make it print out the path
				while (node.getParent() != null) {
					path.add(new Square(node.getRow(), node.getCol()));
					node = node.getParent();
				}
				path.add(new Square(node.getRow(), node.getCol()));
				break;
			}

			ArrayList<Node> neighbors = maze.getNeighbors(node, explored);

			for (Node neighbor : neighbors) {
				tree.add(neighbor);
				explored.add(new Square(neighbor.getRow(), neighbor.getCol()));
			}
		}
	}

}
