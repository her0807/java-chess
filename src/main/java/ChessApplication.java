import static chess.view.OutputView.printGuideStart;

import chess.Menu;
import chess.domain.board.Board;
import chess.view.InputView;
import chess.view.OutputView;

public class ChessApplication {

	public static void main(String[] args) {
		printGuideStart();
		while (selectMenu().isStart()) {
			Board board = new Board();
			board.initBoard();
			OutputView.printBoard(board.getBoard());
		}
	}

	private static Menu selectMenu() {
		try {
			return Menu.of(InputView.insertMenu());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return selectMenu();
		}
	}
}
