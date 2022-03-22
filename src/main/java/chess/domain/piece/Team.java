package chess.domain.piece;

public enum Team {

	WHILE("흰"),
	BLACK("검");

	private final String value;

	Team(String color) {
		this.value = color;
	}
}
