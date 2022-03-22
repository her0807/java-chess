import chess.domain.board.Board;
import chess.view.OutputView;

public class ChessApplication {

	public static void main(String[] args) {
		Board board = new Board();
		board.initBoard();
		OutputView.printBoard(board.getBoard());
	}
}
