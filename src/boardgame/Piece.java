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
}
