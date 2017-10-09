package mazesearch.cse.miamioh.edu;

import java.util.ArrayList;
import java.util.Stack;

public class DFS extends SearchStrategy{


    /**
     * Default constructor
     * @param maze
     */
    DFS(Maze maze) {
		super(maze);
	}

	@Override
	public void solve() {
		Stack<Node> stack = new Stack<>();

        stack.push(new Node(null, maze.getStart().getRow(), maze.getStart().getColumn()));
        explored.add(new Square(maze.getStart().getRow(), maze.getStart().getColumn()));

        while (!stack.empty()) {
            Node node = stack.pop();

            if (node.equals(new Node(null, maze.getGoal().getRow(), maze.getGoal().getColumn()))) {
                // Print path
                while (node.getParent() != null) {
                    path.add(new Square(node.getRow(), node.getCol()));
                    node = node.getParent();
                }
                path.add(new Square(node.getRow(), node.getCol()));
                break;
            }

            ArrayList<Node> neighbors = maze.getNeighbors(node, explored);

            for (Node neighbor : neighbors) {
                stack.push(neighbor);
                explored.add(new Square(neighbor.getRow(), neighbor.getCol()));
            }

        }

	}
}
