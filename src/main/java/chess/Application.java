package chess;

import java.util.Arrays;
import java.util.List;

import chess.domain.board.Board;
import chess.domain.board.Position;
import chess.domain.view.InputView;
import chess.domain.view.OutputView;

public class Application {
    private static final String COMMAND_PATTERN = "move [a-h][1-8] [a-h][1-8]";
    private static final String DELIMITER = " ";
    private static Board board;

    public static void main(String[] args) {
        OutputView.instruction();

        while (true) {
            String command = InputView.getInput();
            if (command.equals("end")) {
                break;
            }
            if (command.equals("start")) {
                board = Board.init();
                OutputView.showBoard(board);
            }
            if (command.matches(COMMAND_PATTERN)) {
                List<Position> positions = getMovePositions(command);
                Position start = positions.get(0);
                Position end = positions.get(1);
                board.move(start, end);
                OutputView.showBoard(board);
            }
        }
    }

    private static List<Position> getMovePositions(String command) {
        if (!command.matches(COMMAND_PATTERN)) {
            throw new UnsupportedOperationException();
        }
        String start = command.split(DELIMITER)[1];
        String end = command.split(DELIMITER)[2];
        return Arrays.asList(Position.of(start), Position.of(end));
    }
}
