package chess.dao;

import chess.entity.Chess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChessDAOTest {
    private ChessDAO chessDao = new ChessDAO();

    @BeforeEach
    public void deleteAll() throws Exception {
        chessDao.deleteAllChess();
    }

    @Test
    public void addChess() throws Exception {
        Chess chess1 = new Chess("1", "pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp", "WHITE");
        chessDao.addChess(chess1);

        Chess chess2 = chessDao.findByChessId("1");
        assertEquals(chess1, chess2);
    }

    @Test
    public void updateChess() throws Exception {
        Chess chess1 = new Chess("1", "pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp", "WHITE");
        chessDao.addChess(chess1);
        chessDao.updateChess(chess1, "ppp", "BLACK");

        Chess chess2 = chessDao.findByChessId("1");
        assertEquals(chess2.getChess(), "ppp");
        assertEquals(chess2.getTurn(), "BLACK");
    }
}