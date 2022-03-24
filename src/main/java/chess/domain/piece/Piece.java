package chess.domain.piece;

import chess.domain.position.Position;
import java.sql.ResultSet;

public interface Piece {

    boolean movable(Position to, Position from);

    String getName();

    Direction findDirection(Position from, Position to);
}
