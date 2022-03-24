package chess.domain.piece;

import chess.domain.position.Position;
import java.util.List;

public class Bishop implements Piece {

    private static final String name = "B";

    private final List<Direction> directions;
    private final Team team;


    public Bishop(Team team) {
        this.team = team;
        directions = Direction.pullDiagonalDirections();
    }

    @Override
    public boolean movable(Position from, Position to) {
        Direction gap = from.findDirection(to, false);
        return directions.contains(gap);
    }

    @Override
    public String getName() {
        return team.convert(name);
    }
}
