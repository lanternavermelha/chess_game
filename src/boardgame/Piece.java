package boardgame;

public abstract class Piece {
	
	//with the protected keyword, Position will only be accessible
	//inside the Board layer (see UML project)
	protected Position position;
	private Board board;

	//position is not included in the constructor because Piece object will
	//be instantied with null Position
	public Piece(Board board) {
		this.board = board;
	}

	//with the protected keyword, Board will only be accessible
	//inside the Board layer (see UML project)
	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	//hook-method - the abstract class hooks the concrete sub-class
	//See template method design pattern (https://refactoring.guru/design-patterns/template-method)
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	//hook-method - the abstract class hooks the concrete sub-class
	//See template method design pattern (https://refactoring.guru/design-patterns/template-method)
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i=0;i<mat.length;i++) {
			for (int j=0;j<mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
