package chess.domain.board;

import chess.domain.piece.Bishop;
import chess.domain.piece.King;
import chess.domain.piece.Knight;
import chess.domain.piece.Pawn;
import chess.domain.piece.Piece;
import chess.domain.piece.Queen;
import chess.domain.piece.Rook;
import chess.domain.piece.Team;
import chess.domain.position.Column;
import chess.domain.position.Position;
import chess.domain.position.Row;
import java.util.HashMap;
import java.util.Map;

public class Board {
    private final Map<Position, Piece> board = new HashMap<>();

    public void initBoard() {
        initWhitePieces();
        initBlackPieces();
    }

    private void initBlackPieces() {
        board.put(new Position(Row.A, Column.EIGHT), new Rook(Team.BLACK));
        board.put(new Position(Row.B, Column.EIGHT), new Knight(Team.BLACK));
        board.put(new Position(Row.C, Column.EIGHT), new Bishop(Team.BLACK));
        board.put(new Position(Row.D, Column.EIGHT), new Queen(Team.BLACK));
        board.put(new Position(Row.E, Column.EIGHT), new King(Team.BLACK));
        board.put(new Position(Row.F, Column.EIGHT), new Bishop(Team.BLACK));
        board.put(new Position(Row.G, Column.EIGHT), new Knight(Team.BLACK));
        board.put(new Position(Row.H, Column.EIGHT), new Rook(Team.BLACK));

        initOneLine(Column.SEVEN, new Pawn(Team.BLACK));
    }

    private void initWhitePieces() {
        board.put(new Position(Row.A, Column.ONE), new Rook(Team.WHITE));
        board.put(new Position(Row.B, Column.ONE), new Knight(Team.WHITE));
        board.put(new Position(Row.C, Column.ONE), new Bishop(Team.WHITE));
        board.put(new Position(Row.D, Column.ONE), new Queen(Team.WHITE));
        board.put(new Position(Row.E, Column.ONE), new King(Team.WHITE));
        board.put(new Position(Row.F, Column.ONE), new Bishop(Team.WHITE));
        board.put(new Position(Row.G, Column.ONE), new Knight(Team.WHITE));
        board.put(new Position(Row.H, Column.ONE), new Rook(Team.WHITE));

        initOneLine(Column.TWO, new Pawn(Team.WHITE));
    }

    private void initOneLine(Column column, Piece piece) {
        for (Row row : Row.values()) {
            board.put(new Position(row, column), piece);
        }
    }

    public Map<Position, Piece> getBoard() {
        return board;
    }

    public void move(Position from, Position to) {
        Piece piece = board.get(from);
        // TODO - if piece.movable
        board.put(to, piece);
        board.remove(from);
    }

    public boolean isEmpty() {
        return board.isEmpty();
    }
}
