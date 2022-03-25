package chess.domain.position;

import chess.domain.piece.Direction;
import java.util.Objects;


public class Position {

    private final Row row;
    private final Column column;

    public Position(Row row, Column column) {
        this.row = row;
        this.column = column;
    }

    public Position(String value) {
        this(Row.of(value.substring(0, 1)), Column.of(value.substring(1, 2)));
    }

    public Direction findDirection(Position position, boolean isOne) {
        int x = row.calculateIndex(position.row);
        int y = column.calculateIndex(position.column);

        if (isOne) {
            return Direction.of(x, y);
        }

        int nx = convertCompactValue(x, y);
        int ny = convertCompactValue(y, x);

        return Direction.of(nx, ny);
    }

    private int convertCompactValue(int target, int other) {
        if (target == 0) {
            return 0;
        }
        if (check((float) other / Math.abs(target))) {
            return target / Math.abs(target);
        }
        return target;
    }

    private boolean check(float target) {
        return target == 0 || target == 1 || target == -1;
    }

    public Position createPathPosition(Direction direction){
        return new Position(row.move(direction),column.move(direction));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return row == position.row && column == position.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    public boolean isNotSameColumn(Column column) {
        return this.column != column;
    }
}
