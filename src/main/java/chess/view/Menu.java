package chess.view;

import java.util.Arrays;

public enum Menu {

    START("start"),
    MOVE("move"),
    STATUS("status"),
    END("end");

    private final String value;

    Menu(String value) {
        this.value = value;
    }

    public static Menu of(String value) {
        return Arrays.stream(Menu.values())
                .filter(it -> it.value.equalsIgnoreCase(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 명령어 입니다."));
    }

    public boolean isEnd() {
        return this == END;
    }

    public boolean isStart() {
        return this == START;
    }

    public boolean isMove() {
        return this == MOVE;
    }

    public boolean isStatus() {
        return this == STATUS;
    }
}
