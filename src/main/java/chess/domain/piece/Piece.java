package chess.domain.piece;

public class Piece {

	private final String name;
	private final Team team;

	public Piece(String name, Team team) {
		this.name = name;
		this.team = team;
	}

	public void move() {
	}

	public String getName() {
		return name;
	}

	public Team getTeam() {
		return team;
	}
}
