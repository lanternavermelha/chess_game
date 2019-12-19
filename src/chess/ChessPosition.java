package chess;

import boardgame.Position;

public class ChessPosition {
	
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		//defensive programming
		if (column < 'a' || column > 'h' || row <1 || row >8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}
	public char getColumn() {
		return column;
	}
	public int getRow() {
		return row;
	}
	
	//converts the matrix position [0-7] to the the chess board position [a1...h8]
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	//converts the other way around (chess board position to matrix position)
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	//the "" forces the compiler to concatenate as a string
	public String toString() {
		return "" + column + row;
	}
}
