package chess.view;

import java.util.Locale;
import java.util.Map;

import chess.domain.piece.Piece;
import chess.domain.piece.Team;
import chess.domain.position.Column;
import chess.domain.position.Position;
import chess.domain.position.Row;

public class OutputView {

	private OutputView() {
	}

	public static void printGuideMessage(String message) {
		System.out.println(message);
	}

	public static void printErrorMessage(String message) {
		System.out.println(message);
	}

	public static void printGuideStart() {
		printGuideMessage("체스 게임을 시작합니다.");
	}

	public static void printGuideInputMenu() {
		printGuideMessage("> 게임 시작 : start\n"
			+ "> 게임 종료 : end\n"
			+ "> 게임 이동 : move source위치 target위치 - 예. move b2 b3");
	}

	public static void printBoard(Map<Position, Piece> board) {
		for (Column column : Column.reverseColumns()) {
			printColumnWithRow(board, column);
			System.out.println();
		}
	}

	private static void printColumnWithRow(Map<Position, Piece> board, Column column) {
		for (Row row : Row.values()) {
			Position position = new Position(row, column);
			Piece piece = board.get(position);
			printStringOrDefault(piece);
		}
	}

	private static void printStringOrDefault(Piece piece) {
		if (piece != null) {
			convertCase(piece);
			return;
		}
		System.out.print(".");
	}

	private static void convertCase(Piece piece) {
		if (piece.getTeam() == Team.WHILE) {
			String name = piece.getName();
			System.out.print(name.toLowerCase(Locale.ROOT));
			return;
		}
		if (piece != null) {
			System.out.print(piece.getName());
			return;
		}
	}
}
