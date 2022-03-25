package chess.view;

import chess.domain.position.Row;
import chess.domain.position.Position;
import chess.domain.position.Column;
import java.util.Map;

public class OutputView {

    private OutputView() {
    }

    public static void printGuideMessage() {
        System.out.println("체스 게임을 시작합니다.");
        System.out.println("게임 시작은 start, 종료는 end 명령을 입력하세요.");
    }

    public static void printBoard(Map<Position, String> board) {
        for (Row row : Row.reverseColumns()) {
            printColumnWithRow(board, row);
            System.out.println();
        }
    }

    private static void printColumnWithRow(Map<Position, String> board, Row row) {
        for (Column column : Column.values()) {
            Position position = new Position(column, row);
            String piece = board.get(position);
            printStringOrDefault(piece);
        }
    }

    private static void printStringOrDefault(String piece) {
        if (piece != null) {
            System.out.print(piece);
            return;
        }
        System.out.print(".");
    }

    public static void printMessage(String string) {
        System.out.println(string);
    }
}
