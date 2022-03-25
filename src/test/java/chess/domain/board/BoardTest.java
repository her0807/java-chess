package chess.domain.board;

import static org.assertj.core.api.Assertions.assertThat;

import chess.domain.piece.Queen;
import chess.domain.piece.Team;
import chess.domain.position.Column;
import chess.domain.position.Position;
import chess.domain.position.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess.domain.board.Board;
import chess.view.OutputView;

public class BoardTest {

    @DisplayName("보드를 생성한다.")
    @Test
    void create() {
        assertThat(new Board()).isNotNull();
    }

    @Test
    void tesT() {
        Board board = new Board();
        board.initBoard();
        OutputView.printBoard(board.getBoard());
    }

    @DisplayName("말이 없으면 보드가 이동한다.")
    @Test
    void move() {
        // given
        Board board = new Board();
		board.initBoard();

        Position fromPawn = new Position(Row.E, Column.TWO);
        Position toPawn = new Position(Row.E, Column.THREE);

        Position fromQueen = new Position(Row.D, Column.ONE);
        Position toQueen = new Position(Row.E, Column.TWO);
        // when
        OutputView.printBoard(board.getBoard());
        board.move(fromPawn, toPawn);
        OutputView.printBoard(board.getBoard());
        board.move(fromQueen, toQueen);
        OutputView.printBoard(board.getBoard());
        // then
        assertThat(board.hasPositionInPiece(toQueen, new Queen(Team.WHITE))).isTrue();
    }

    @DisplayName("이동 경로에 말이 있으면 이동 할 수 없다,.")
    @Test
    void move_false() {
        // given
        Board board = new Board();
        board.initBoard();

        Position fromQueen = new Position(Row.D, Column.ONE);
        Position toQueen = new Position(Row.E, Column.TWO);
        // when

        OutputView.printBoard(board.getBoard());
        board.move(fromQueen, toQueen);
        OutputView.printBoard(board.getBoard());
        // then
        assertThat(board.hasPositionInPiece(fromQueen, new Queen(Team.WHITE))).isTrue();
    }
}
