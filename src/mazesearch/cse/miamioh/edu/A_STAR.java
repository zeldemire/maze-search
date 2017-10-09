package mazesearch.cse.miamioh.edu;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class A_STAR extends SearchStrategy{

    A_STAR(Maze maze) {
        super(maze);
    }

    @Override
    public void solve() {
        PriorityQueue<Node> pQueue = new PriorityQueue<>();

        Node startPosition = new Node(null, maze.getStart().getRow(), maze.getStart().getColumn());
        Node goal = new Node(null, maze.getGoal().getRow(), maze.getGoal().getColumn());

        pQueue.add(startPosition);
        explored.add(new Square(startPosition.getRow(), startPosition.getCol()));

        while (!pQueue.isEmpty()) {
            Node node = pQueue.poll();

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
                int x = neighbor.getRow();
                int y = neighbor.getCol();

                double new_g_score = node.g_score + (x - node.getRow() == 0 || y - node.getCol() == 0 ? 1
                        : Math.sqrt(2));
                double new_f_score = new_g_score + Math.abs(x - goal.getRow()) + Math.abs(y - goal.getCol());

                if ((explored.contains(new Square(neighbor.getRow(), neighbor.getCol())))
                        && (new_f_score >= neighbor.f_score)) {
                    continue;
                } else if ((!pQueue.contains(neighbor)) || (new_f_score < neighbor.f_score)) {
                    neighbor.g_score = new_g_score;
                    neighbor.f_score = new_f_score;

                    if (pQueue.contains(neighbor)) {
                        pQueue.remove(neighbor);
                    }

                    pQueue.add(neighbor);
                }
                explored.add(new Square(neighbor.getRow(), neighbor.getCol()));
            }
        }
    }

}
