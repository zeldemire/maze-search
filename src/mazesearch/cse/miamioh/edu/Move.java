package mazesearch.cse.miamioh.edu;

public class Move {
    public Square moveLeft(Square position) {
        return new Square(position.getRow(), position.getColumn() - 1);
    }

    public Square moveRight(Square position) {
    	return new Square(position.getRow(), position.getColumn() + 1);
    }

    public Square moveUp(Square position) {
    	return new Square(position.getRow() - 1, position.getColumn());
    }

    public Square moveDown(Square position) {
        return new Square(position.getRow() + 1, position.getColumn());
    }
}
