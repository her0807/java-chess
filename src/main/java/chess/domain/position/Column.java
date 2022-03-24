package chess.domain.position;

import chess.domain.piece.Direction;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Column {
    ONE("1", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8);

    private final String value;
    private final int index;

    Column(String value, int index) {
        this.value = value;
        this.index = index;
    }

    public static Column of(final String value) {
        return Arrays.stream(values())
                .filter(it -> it.value.equalsIgnoreCase(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 컬럼입니다."));
    }

    public static Column of(final int value) {
        return Arrays.stream(values())
                .filter(it -> it.index == value)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 컬럼입니다."));
    }

    public static List<Column> reverseColumns() {
        List<Column> columns = Arrays.asList(values());
        columns.sort(Collections.reverseOrder());
        return columns;
    }

    public Column move(Direction direction) {
        return of(direction.moveColumn(index));
    }

    public int calculateIndex(Column column) {
        return column.index - this.index;
    }
}
