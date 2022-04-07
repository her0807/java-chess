package chess.dao;

import static org.assertj.core.api.Assertions.assertThat;

import chess.domain.board.BasicBoardStrategy;
import chess.domain.board.Board;
import chess.domain.piece.Blank;
import chess.domain.piece.WhitePawn;
import chess.domain.position.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardDaoTest {

    private BoardDao boardDao;

    @BeforeEach
    void init() {
        boardDao = new FakeBoardDao();
        boardDao.removeAll("board");
    }

    @Test
    @DisplayName("기본 보드를 가져온다.")
    void getBoard() {
        Board board = new Board();
        board.initBoard(new BasicBoardStrategy());
        assertThat(boardDao.getBoard()).isEqualTo(board.toMap());
    }

    @Test
    @DisplayName("이동 업데이트 로직을 확인한다.")
    void update() {
        boardDao.update("a3", "white_pawn");
        boardDao.update("a2", "blank");

        Board board = new Board();
        board.initBoard(new BasicBoardStrategy());
        board.move(new Position("a3"), new WhitePawn());
        board.move(new Position("a2"), new Blank());

        assertThat(boardDao.getBoard()).isEqualTo(board.toMap());
    }
}
