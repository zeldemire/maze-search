package mazesearch.cse.miamioh.edu;

public class Node implements Comparable {

    private Node parent;
    private int row;
    private int col;
    double f_score = 0;
    double g_score = 0;

    Node(Node parent, int row, int col) {
        this.parent = parent;
        this.row = row;
        this.col = col;
    }

    Node getParent() {
        return parent;
    }

    int getRow() {
        return row;
    }

    int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            Node that = (Node) obj;
            return this.row == that.row && this.col == that.col;
        }
        return false;
    }

    @Override
    public int compareTo(Object object) {
        Node node = (Node) object;
        // Maybe change this
        return Double.compare(this.f_score, node.f_score);
    }

}
